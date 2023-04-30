package day09_Dropdown_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    /*
    -DropDown nedir:  Alt basliklarin oldugu acilir menu listesi
    -DropDown nasil automate edilir(Handle) :
    a-ilk olarak menuyu locate ederiz
    b- select objesi olustururuz
    c-select objesinin DropDawn menu Webelementinin icerigine ve seceneklerine erisim saglamasi icin select sinifina arguman olarak locate ettigimiz webelementi koyariz
    Syntax : Select select = new Select(DropD.Menu Webelement)
    d- select class i sadece <select> tagi ile olusturulmus DropDawn menulere uygulanabilir.
    e- select objesi ddm yi Handle edebilmek icin 3 method kullanir
             -selectByVisibleText-> ddm deki elemente gorunur metin ile ulasmak icin kullanilir
             -selectByIndex-> index ile ulasmak icin kullanilir
             -selectByValue-> elementin degeri ile ulasmak icin kullanilir(option tag indaki deger ile)
     f-getOptions() -> Locate ettigimiz DDM deki tum secenekleri bize dondurur
     g- getFirstSelectOption() -> DDM deki en son secili kalan ilk secenegi bize dondurur.

    */

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    WebDriver driver;
    @Test
    public void test02() {
        /*
        //a. Tüm eyalet isimlerini yazdıralım

        WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        List<WebElement> stateList = select.getOptions();//Bütün options taglarını getir
        //for (WebElement w:stateList) {
        //    System.out.println(w.getText());
        // }
        stateList.forEach(t-> System.out.println(t.getText()));

         */
        List<WebElement> tumEyaletler = driver.findElements(By.xpath("//*[@id='state']//option")); //option bir alttaki child taga ulasmak icin yazdik
        System.out.println(tumEyaletler.get(2).getText());
        System.out.println("**************************+++");
        tumEyaletler.forEach(t-> System.out.println(t.getText()));
        //b. Sayfadaki tum ddm lerdeki tum optionlari konsolda yazdiriniz
        List<WebElement> eyaletlerList = driver.findElements(By.tagName("option")); //tum listeyi yazdirmak icin <select> tagi ile yada option tagi ile yazdirilir
        eyaletlerList.forEach(t-> System.out.println(t.getText()));
        System.out.println("***********************");
        System.out.println(tumEyaletler.size());//size ile de alinabilir

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }
}
