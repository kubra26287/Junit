package day14_FakerClass_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void actions() {
        //techproya gidin
        //ilk kelime SHIFT tusuna basili sekilde, ikinci kelime basilmadan "TECHPRO education" aramasi yapin
        driver.get("https://techproeducation.com");

        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
      WebElement search =  driver.findElement(By.xpath("//*[@type='search']"));
      Actions actions = new Actions(driver);
      actions.keyDown(search, Keys.SHIFT).//arama kutusu(search) uzerinde shift tusuna basili tutar.
              sendKeys("techpro").
              keyUp(Keys.SHIFT).//keyUp ile shift tusuna basma islemi sonlanir
              sendKeys("education",Keys.ENTER)
              .perform();

       //sayfayi richmond collage enrollment form linkine kadar scroll yapalim
        WebElement scroll = driver.findElement(By.xpath("(//h3//a)[2]"));
        actions.scrollToElement(scroll).perform();
        //scrollToElement methodu ile locate ettiginiz bir webelemente kadar yani o element gorunur olana kadar scroll yapar( sayfayi asagi indirir).



    }
}
