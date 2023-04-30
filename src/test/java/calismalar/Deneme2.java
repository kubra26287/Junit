package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Deneme2 {
    /*
    *** Aşağıdaki Task'i Junit framework'u ile yapınız
- ebay sayfasına gidiniz
- electronics bölümüne tıklayınız
- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
- Her sayfanın sayfa başlığını yazdıralım
- sayfayı kapatalım
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://ebay.com");

       WebElement click = driver.findElement(By.xpath("//*[@id='gdpr-banner-accept']"));
       click.click();
       driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

      List<WebElement> urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for (int i = 0; i <urunler.size() ; i++) {
            urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            urunler.get(i).click();
            Thread.sleep(2000);
            System.out.println(i+". baslik : "+driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();

        }
        driver.close();

    }
}
