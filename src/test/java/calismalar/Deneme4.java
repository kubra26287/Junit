package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Deneme4 {
    /*
    -Amazon sayfasına gidelim
-Arama Kutusundaki Dropdown menuyu yazdıralım
-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
Not: Select Class'ı kullanalım
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         driver.get("https://amazon.com");
    }



    @Test
    public void DropDown() throws InterruptedException {
        Select select = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
        for (WebElement w:select.getOptions()) {
            System.out.println(w.getText());
        }
        int sayac=1;
        for (WebElement w:select.getOptions()) {
            Select select1 = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            select1.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click(); //buyutec butonu locate'i
            Thread.sleep(3000);
            System.out.println(driver.getTitle());
            Thread.sleep(3000);
            driver.navigate().back();
            sayac++;

            if (sayac>=6){
                break;
            }
        }

    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
