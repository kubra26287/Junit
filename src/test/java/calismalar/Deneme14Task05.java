package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Deneme14Task05 extends TestBase {
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

    @Test
    public void alert() {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.cssSelector("button[class='btn btn-danger'")).click();
        System.out.println(driver.switchTo().alert().getText());
        bekle(3);
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        bekle(3);
        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
        driver.switchTo().alert().dismiss();
        bekle(3);
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();

        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
        driver.switchTo().alert().sendKeys("Kubra");
        bekle(3);
        driver.switchTo().alert().accept();
       WebElement message = driver.findElement(By.xpath("//*[text()='Hello Kubra How are you today']"));
        System.out.println(message.getText());
        Assert.assertEquals("Hello Kubra How are you today",message.getText());
    }
}
