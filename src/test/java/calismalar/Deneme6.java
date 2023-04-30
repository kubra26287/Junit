package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Deneme6 extends TestBase {


    @Test
    public void name() {
        /*
        -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
-Çıkan alert'te iptal butonuna basınız
-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
-Çıkan mesajı konsola yazdırınız
-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
         */
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.cssSelector("button[onclick='alertbox()']")).click();
        String alert =driver.switchTo().alert().getText();
        System.out.println(alert);
        bekle(3);
        driver.switchTo().alert().accept();
        bekle(3);
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        bekle(3);
        driver.switchTo().alert().dismiss();





    }
    @Test
    public void mesaj() {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();
        bekle(4);
        alertPromptbox("Kübra");
        alertaccept();

        String actualmesaj = driver.findElement(By.xpath("//*[text()='Hello Kübra How are you today']")).getText();
        System.out.println(actualmesaj);
        Assert.assertEquals(actualmesaj,"Hello Kübra How are you today");

    }

}
