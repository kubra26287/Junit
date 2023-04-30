package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
   https://the-internet.herokuapp.com/iframe sayfasına gidiniz
   Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
   Textbox içindeki yazıyı siliniz.
   Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
   Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
    */

    @Test
    public void iframe() {

        /*
         https://the-internet.herokuapp.com/iframe sayfasına gidiniz
         Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
         */
        driver.get("https://the-internet.herokuapp.com/iframe");
     WebElement baslikElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.getText().contains("Editor"));
        bekle(2);

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame(0);  //once iframe e gecis yapiyoruz.
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        bekle(2);

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(2);

       // Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        bekle(2);
        //elemental selenium frame disinda oldugu icin once frame den bu sekilde (driver.switchTo().defaultContent();) cikis yapmamiz gerekir
       // yada  driver.navigate().refresh(); ile sayfayi yeniledigimiz icin anasayfaya gecmis oluruz.
       WebElement elementelSelenium = driver.findElement(By.xpath("(//a)[3]"));
       Assert.assertTrue(elementelSelenium.isDisplayed());




    }
}
