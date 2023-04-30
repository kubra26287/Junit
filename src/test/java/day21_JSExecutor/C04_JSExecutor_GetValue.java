package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutor_GetValue extends TestBase {
    @Test
    public void getValueTest() {
        //  1)getValueTest metotu olustur
       //  2)https://www.priceline.com/ a git
       //  3)Tarih kısmındaki Yazili metinleri al ve yazdır
        driver.get("https://www.carettahotel.com");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        //  3)Tarih kısmındaki Yazili metinleri al ve yazdır
        JavascriptExecutor js = (JavascriptExecutor) driver;
       WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");
       /*
       Eger bir websayfasinda webeleement olustururlurken JS kullanilmissa normal olarak locate almakta zorlaniti´´iz bu gibi durumlarda
       yukaridaki ornekteki gibi JSExecutor kullanarak webele. locate edebiliriz

        */
       sendKeysJS(date,"5/24/2023");
    }
}
