package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Executor_Scroll extends TestBase {
    /*
    Techpro education ana sayfasına git
    "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
    Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
     */
    JavascriptExecutor js;
    @Test
    public void executor_Scroll() {
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
        bekle(2);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        //bunula lgili method da olusturduk TestBase de jSScroll(weOffer);

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al

        WebElement enroll =  driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
        js.executeScript("arguments[0].scrollIntoView(true);",enroll);
        bekle(2);
        tumSayfascreenShot();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        bekle(2);
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        jSScroll(whyUs); //bu sefer method ile yaptim
        tumSayfascreenShot();

        //Sayfayi en alta scroll yap
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //

        //Sayfayi en uste scroll yap
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

        //scroll Home sayfa basi
        js.executeScript("window.scrollTo(0,-500)");
    }
}
