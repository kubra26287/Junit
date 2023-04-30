package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Type extends TestBase {
       /*
      Techpro education ana sayfasina git
      Arama kutusuna QA yaz
      */

    @Test
    public void name() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
       WebElement search = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*
        bazi giris kutulari normal sendKeys methodu ile veri gonderilmesine izin vermez.
        Bu gibi durumlarda asagidaki ornekteki gibi JSExecutor kullanilir.
         */
        js.executeScript("arguments[0].value='QA'",search);
        //sendKeysJS(search,"QA"); method olarak

        //js.executeScript("arguments[0].setAttribute('value','QA')",search);
        sendAttribute(search,"QA");//method yaptik Test Base de
        search.submit();
    }
}
