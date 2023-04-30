package calismalar;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Deneme7 extends TestBase {
    /*
       //odev
    //● https://the-internet.herokuapp.com/iframe adresine
    //gidin.
    //● Bir metod olusturun: iframeTest
    //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //○Text Box’a “Merhaba Dunya!” yazin.
     //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
    //oldugunu dogrulayin ve konsolda yazdirin
     */

    @Test
    public void IframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
     WebElement erisilebilirtext = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        erisilebilirtext.isEnabled();
        driver.switchTo().frame(2);
        System.out.println(erisilebilirtext.getText());
        WebElement mesaj =driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        mesaj.sendKeys("Merhaba Dünya", Keys.ENTER);

    }
}
