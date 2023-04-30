package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {   //Reusable methodlar
    //TestBase classindan Obje olusturmanin onune gecilmesi icin abstract yapilabilir
    //Orn; TastBase base = new TestBase();
    //Bu classi extend ettigimiz test classlarindan ulasabiliri

    protected static WebDriver driver;
    //Raporlama icin gerekli olan objeler;
    protected static ExtentReports extentReports; //Raporlamayi baslatir
    protected static ExtentTest extentTest;
    protected static ExtentHtmlReporter extentHtmlReporter;
    @Before
    public void setUp() throws Exception {
        //Configurator.initialize(null,"log4j2.xml"); Eğer log4j2.xml dosyasını proje seviyesinde oluşturursanız bu ayarlamayı yapmak gerekir.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//------------------------------------------------------------------------------------------

    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(3000);
       // driver.quit();

    }

    // HARD WAIT METHOD :Thread.sleep methodu
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //ALLERT ACCEPT
    public static void alertaccept(){
        driver.switchTo().alert().accept();
    }
    //Allert dismiss
    public static void alertdismiss(){
        driver.switchTo().alert().dismiss();
    }
    //Alert getText
    public static void alertText(){
        driver.switchTo().alert().getText();
    }
    //alert promtbox: alert uzerindeki kutucuga denir //sendKeys
    public static void alertPromptbox(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //DropDown menu visibleText
    public static void dbmVisibleText(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);

    }
    //Dropdown index
    public static void dbmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);

    }
    public static void dbmValue(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByValue(secenek);

    }

    //SwitchToWindow
    public static void switchToWindow(int sayi){
        List<String> tumWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowHandles.get(sayi));
        //baska pencereye gecis icin olusturulmus method
    }
    //switchToWindow2
    public static void window(int sayi){
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
        //baska pencereye gecis icin olusturulmus method. objeyi stringe dondurebilmek icin toString yapiyoruz
    }

   // Explicit Wait Methods :

    //visibleWait
    public static void visibleWaitElement(WebElement element,int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

     // Alert Wait
    public static void alertWait(int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());
    }


     //VisibleElementLocater Wait
    public static void visibleWaitLocator(By locator, int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //TUM SAYFA EKRAN GORUNTUSU
    public static void tumSayfascreenShot(){

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu ="test_output/screenShot"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try { //try catch bloguna almamizin sebebi copy file bizden exeption istiyordu methodu kullanirken her defasinda ugrasmamak icin yaptik
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //WebelementScreenShot
    public static void webelementScreenShot(WebElement element){

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu ="test_output/screenShot"+tarih+".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void extentReports(){
        extentReports = new ExtentReports(); //2
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu ="test_output/report/extentsReport"+tarih+".html";
        extentHtmlReporter =new ExtentHtmlReporter(dosyaYolu); //3
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Kubra");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("smoke Test Raporu");
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
    }

    //WebTable
    //WebTble daki istedigimiz satir ve sutunu almaka icin method olusturduk
    public void printData(int satir, int sutun){
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());
    }

    //click Method
    public void click(WebElement element){
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
        }

    }

    //JavaScript Scroll
    public void jSScroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    //JavaScript sayfa sonu
    public void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JavaScript sayfa basi
    public void scrollSayfaBasi() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JsSendKeys
    public void sendKeysJS(WebElement element,String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+text+"'",element);

    }
    //SendAttribute
    public void sendAttribute(WebElement element,String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
    }








}
