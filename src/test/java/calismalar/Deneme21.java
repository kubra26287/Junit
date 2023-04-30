package calismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Deneme21 extends TestBase {
    /*
        Bir web sayfasinda upload islemi yapmamiz gerekirse;
        1-oncelikle Upload edecegimiz elementi locate ederiz
        2-Upload edecegimiz dosya yolunu bir stringe assign ederiz
        3-Locate ettigimiz webelemente sendKeys() methodu ile dosya yolunu aldigimiz string degiskeni gondeririz.
         */
            /*
    https://the-internet.herokuapp.com/upload adresine gidin
    b129 dosyasini yukleyin dosyasını yükleyin(upload)
    “File Uploaded!” textinin görüntülendiğini test edin
    */

    @Test
    public void fileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
       WebElement dosya =  driver.findElement(By.xpath("//input[@id='file-upload']"));
       String dosyaYolu = "/Users/fatihyilmaz/Desktop";
       dosya.sendKeys(dosyaYolu);
       driver.findElement(By.xpath("//input[@id='file-submit']")).click();
    }
}
