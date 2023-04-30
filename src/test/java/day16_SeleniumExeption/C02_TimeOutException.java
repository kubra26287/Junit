package day16_SeleniumExeption;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_TimeOutException extends TestBase {
    @Test
    public void TimeOutException() {
        /*
        TimeOutException
        Sayfada aradigimiz elementi wait ile belirledigimiz max. suredde bulamadigi durumda TimeOutException
        hatasi aliriz
         */
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //Reklam kapatir
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("java", Keys.ENTER);

       //TimeOutException alabilmek icin visibeofelementlocater methodunu kullanarak yanlis bir locate aldik
        visibleWaitLocator(By.xpath("Yanlis Locate"),30);
        //C02_TimeOutException.TimeOutException(C02_TimeOutException.java:21) locate yanlis oldugunda hatasi verir

    }

    @Test
    public void timeOutException() {
       driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
       //Start butonuna tiklayalim
        driver.findElement(By.xpath("//*[.='Start']")).click();
        //Hello world textinin ciktigini dogrulayiniz
       WebElement helloworldText = driver.findElement(By.xpath("(//h4)[2]"));
       visibleWaitElement(helloworldText,2);
       //bekleme suresini iki saniye verdigimiz icin ,hello world yazisi 6 saniyede ciktigindan dolayi timeoutException hatasi aliriz

        Assert.assertTrue(helloworldText.isDisplayed());//C02_TimeOutException.timeOutException(C02_TimeOutException.java:36)
    }
}
