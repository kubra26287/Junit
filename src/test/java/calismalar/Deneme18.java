package calismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Deneme18 extends TestBase {
    /*
    //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
    //Click me, to open an alert after 5 seconds butonuna basalım
    //Çıkan alert'i kapatalım
     */

    @Test
    public void name() {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.findElement(By.xpath("//*[@id='alert']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
