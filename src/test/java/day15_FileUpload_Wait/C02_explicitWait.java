package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_explicitWait extends TestBase {
    @Test
    public void explicitWait() {
      /*
      2 temel wait vardir.

        1- Java based wait == Thread.sleep()
        2- Selenium based waits
        2.1- implicitly wait
        Obje olusturmaksizin driver.manage.timeouts... seklinde olusturabiliriz.
        2.2- explicitly wait
        WebDriverWait class'indan obje olusturmaliyiz. Constructor'in icine driverimizi ve Duration koymaliyiz.

       */


        /*
    https://the-internet.herokuapp.com/dynamic_loading/1
    Start buttonuna tıklayın
    Hello World! Yazının sitede oldugunu test edin
     */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();
       //Assert.assertTrue(driver.findElement(By.xpath("(//h4)[2]")).isDisplayed());
       //bir webelementin gorunurlulugunu implicitly wait ile cozemedik
       //Hello World! Yazının sitede oldugunu test edin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //1.yol:
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
                                       //until: e kadar demek           visibilityOfElementLocated : webelemetin gorunur olmasini bekler

        //2.Yol
        //WebElement helloWordText1 = driver.findElement(By.xpath("(//h4)[2]"));
        //wait.until(ExpectedConditions.visibilityOf(helloWordText1));


        Assert.assertTrue(helloWorldText.isDisplayed());


      //Not NOt NOT
        /*
        Thread.Sleep: Javadan gelen bu bekleme ile belirttiğimiz süre kadar kodları bekletir
        Implictly Wait: Sayfadaki tüm webelementler için max süre kadar sayfanın yüklemesini bekler
        Explict Wait: Belirli bir koşul gerçekleşene kadar belirttiğimiz süre boyunca driver'ın beklemesini sağlar
        Fluent Wait: Belirli bir koşul gerçeklesene kadar belirttiğimiz aralıklarla beklemeye devam eder
         */

    }
}
