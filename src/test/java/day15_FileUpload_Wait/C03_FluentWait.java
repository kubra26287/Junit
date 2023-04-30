package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;
import java.util.NoSuchElementException;

public class C03_FluentWait extends TestBase {
    @Test
    public void name() {
           /*
    https://the-internet.herokuapp.com/dynamic_loading/1
    Start buttonuna tıklayın
    Hello World! Yazının sitede oldugunu test edin
     */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();
       // Hello World! Yazının sitede oldugunu test edin
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).//Fluentwait icin max sureyi belirtir
                pollingEvery(Duration.ofSeconds(3)). //Her 3 saniyade bir web elementi kontrol eder
                withMessage("Ignore Exeption"). //zorunlu degil bu
                ignoring(NoSuchElementException.class);//zorunlu degil Exeption handle eder.

        WebElement helloWorldText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText1));


        Assert.assertTrue(helloWorldText1.isDisplayed());

    }
}
