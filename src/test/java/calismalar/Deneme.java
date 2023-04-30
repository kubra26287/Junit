package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Deneme {
    public static void main(String[] args) {
        /*
*** Aşağıdaki Task'i Junit framework'u ile yapınız
- http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
- Add Element butonuna 100 defa basınız
- 100 defa basıldığını test ediniz
- 90 defa delete butonuna basınız
- 90 defa basıldığını doğrulayınız
- Sayfayı kapatınız
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

      WebElement adButton =  driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i <100 ; i++) {
            adButton.click();

        }

       List<WebElement> addButton = driver.findElements(By.xpath("//*[@onclick='addElement()']"));
        Assert.assertEquals(100,adButton);









    }
}
