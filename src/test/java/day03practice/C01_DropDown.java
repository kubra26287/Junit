package day03practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {


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
        driver.get("https://www.amazon.com/");
        // https://www.amazon.com/ sayfasina gidin
        // dropdown'dan "Books" secenegini secin
        //dropdownlarda üc asama takip edilir :
        //1.dropDown locate edilmeli
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2_) select objesi olusturulur
        Select select = new Select(dropDown);
        //3-) optionlardan bir tanesi secilir :  select.selectByIndex();   select.selectByValue();  select.selectByVisibleText()
        select.selectByVisibleText("Books"); //en cok tercih edilendir
        //select.selectByIndex(5);  //bu pek kullanilmaz cunku yeni bir element daha eklenebilir sonrasinda. Boylece index sayisi degismis olur
        //select.selectByValue("search-alias=stripbooks-intl-ship"); //select tag inin oldugu satirdaki üc noktaya... tikladigimizda optionlar acilir
        //oradan Books optionunu bulup Value="search-alias=stripbooks-intl-ship" degerini copyalayip alabiliriz.

        // arama cubuguna "Java" aratın
       WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucu = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(aramaSonucu.getText().contains("Java"));


    }
}
