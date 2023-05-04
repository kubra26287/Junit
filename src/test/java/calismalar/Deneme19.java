package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Deneme19 extends TestBase {
    /*
        //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim
    //Silindiğini doğrulayalım
    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)
     */

    @Test
    public void name() throws InterruptedException {
        driver.get("https://www.selenium.dev/downloads/");
        tumSayfascreenShot();
        Actions actions = new Actions(driver);
       WebElement element= driver.findElement(By.xpath("//*[@class='card-title pb-4']"));
       actions.moveToElement(element).perform();


      WebElement browser = driver.findElement(By.xpath("(//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]"));
      browser.click();
      bekle(2);
      WebElement chromclick = driver.findElement(By.xpath("(//*[text()='documentation'])[5]"));
      chromclick.click();
      bekle(2);
      driver.findElement(By.xpath("//*[@class='vzKQHb K2OSr']")).click();
      bekle(2);
     WebElement scroll = driver.findElement(By.xpath("//*[text()='ChromeDriver Documentation']"));
      actions.scrollToElement(scroll).perform();
      bekle(2);
      webelementScreenShot(scroll);
      driver.findElement(By.xpath("//*[text()='ChromeDriver 112.0.5615.49']")).click();

        List<String>windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        bekle(3);

     WebElement click = driver.findElement(By.xpath("//*[text()='chromedriver_mac64.zip']"));
     click.click();
     Thread.sleep(50000);

     ///Users/fatihyilmaz/Downloads
     String dosyaYolu =System.getProperty("user.home"+"/Downloads");
       assert Files.exists(Paths.get(dosyaYolu));
       bekle(2);
        File file = new File(dosyaYolu);
        if (Files.exists(Paths.get(dosyaYolu))){
            file.delete();
        }else System.out.println("Dosya yok");
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));
    }
}
