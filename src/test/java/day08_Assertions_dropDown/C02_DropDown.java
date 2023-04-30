package day08_Assertions_dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {

    /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a Tüm eyalet isimlerini yazdıralım
        3.Method:
            a State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
     */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
     driver.close();
    }

    @Test
    public void Test01() {    //*[@id='year']
        WebElement yil = driver.findElement(By.xpath(" //*[@id='year']"));
        Select select = new Select(yil);
        select.selectByIndex(5); //index 0 dan baslar DropDown menu de 6. yi alir
       // yil.sendKeys("2018"); //bu kisa yol calismadiginda yukaridaki gibi select classindan obje olusturularak yapilabilir
        //driver.findElement(By.xpath("//*[@value='2016']")).click(); --> Bu şekilde de seçebilirim
        WebElement ay = driver.findElement(By.xpath("//*[@id='month']"));
        Select select1 = new Select(ay);
        //select1.selectByVisibleText("April");
        select1.selectByValue("6");
        WebElement gun = driver.findElement(By.xpath("//*[@id='day']"));
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");
    }

    @Test
    public void Test02() {
        //tum eyalet isimleri
       WebElement tumEyalet = driver.findElement(By.cssSelector("select[id='state'"));
       Select select = new Select(tumEyalet);
        List<WebElement> satateList = select.getOptions();  //tum secenekleri listele
        for (WebElement w: satateList) {
            System.out.println(w.getText());
        }
        // Lambda ile;
       // satateList.stream().forEach(t-> System.out.println(t.getText()));

    }

    @Test
    public void Test03() {
        //a State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify (dogrulamak) edelim
        WebElement tumEyalet = driver.findElement(By.cssSelector("select[id='state'"));
        Select select = new Select(tumEyalet);
        String sonSecilenText = select.getFirstSelectedOption().getText();
        //get.firstSelectOption --> en son secilmis olan optionu verir
        Assert.assertEquals("Select a State",sonSecilenText);
    }

}
