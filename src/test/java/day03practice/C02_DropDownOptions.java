package day03practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın


    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
     //driver.close();
    }

    @Test
    public void name() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com");

        // dropdown'dan "Baby" secenegini secin
       WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        System.out.println("sectigimiz option :"+select.getFirstSelectedOption().getText());
        //getFirstSelectedOption() bize sectigimiz optionu getirir

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
       List<WebElement> optionlarList = select.getOptions();
                //getOptions bize tum elementleri getirir List dondurur
        int actualOptionsayisi = optionlarList.size();
        int expectedoptionsayisi = 28;
        Assert.assertEquals(expectedoptionsayisi,actualOptionsayisi);
        // dropdown'daki optionların tamamını yazdırın
       int sayac=1;
        for (WebElement w:optionlarList) {
            System.out.println(sayac+". ci Option : "+ w.getText());
           sayac++;

        }
    }
}
