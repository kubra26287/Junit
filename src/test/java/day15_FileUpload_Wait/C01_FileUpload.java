package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {
    @Test
    public void fileUpload() {

        /*
    https://the-internet.herokuapp.com/upload adresine gidin
    b129 dosyasini yukleyin dosyasını yükleyin(upload)
    “File Uploaded!” textinin görüntülendiğini test edin
    */


        /*
        Bir web sayfasinda upload islemi yapmamiz gerekirse;
        1-oncelikle Upload edecegimiz elementi locate ederiz
        2-Upload edecegimiz dosya yolunu bir stringe assign ederiz
        3-Locate ettigimiz webelemente sendKeys() methodu ile dosya yolunu aldigimiz string degiskeni gondeririz.
         */
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));
        bekle(3);
        String dosyaYolu = "/Users/fatihyilmaz/Desktop";
       //String dosyaYolu = System.getProperty("user.home")+"/Desktop";
        dosyaSec.sendKeys(dosyaYolu);
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //“File Uploaded!” textinin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());






    }
}
