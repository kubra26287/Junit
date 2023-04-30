package day6_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class C02_ScreenShot extends TestBase {
    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc sayisini yazdiriniz
    // ilk urunun fotografını cekin
    // cikan ilk urune tiklayiniz
    // iki ArrowDown sayfayı asagiya kaydirin
    // sepete ekleyiniz
    // sepetim'e git tilayiniz
    // "Siparis Ozeti" webelementinin text'ini yazdiriniz
    // Alisverisi tamamlayiniz
    // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
    @Test
    public void screenShot() throws IOException, InterruptedException {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");
        try {
            driver.findElement(By.cssSelector("div[id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cikmadi devam");
        }
        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Oppo" + Keys.ENTER);
        Thread.sleep(3000);

        //driver.findElement(By.xpath("(//*[@class='icon icon-search'])[1]")).click();
       // sonuc sayisini yazdiriniz
       WebElement sonucSayisi = driver.findElement(By.xpath("//h1"));
        System.out.println(sonucSayisi.getText());
        bekle(2);
        // ilk urunun fotografını cekin
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);
        bekle(2);

        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='prd-link gowitPlp-js'])[1]"));
        File kayit = new File("target/ekranGoruntusu/tumsayfa"+tarih+".Jpeg");
        File gecici = ilkUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecici,kayit);
        bekle(2);

        // cikan ilk urune tiklayiniz
        ilkUrun.click();

        //sepete ekle butonu gorununceye kadar iki ArrowDown sayfayı asagiya kaydirin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        bekle(5);
        // sepete ekleyiniz
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
        Thread.sleep(3000);
        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
        WebElement siparisOzeti = driver.findElement(By.xpath("//div[text()='Sipariş Özeti']"));
        System.out.println("siparis ozeti texti "+siparisOzeti.getText());

        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();

        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
        WebElement yazi = driver.findElement(By.xpath("//div[text()='Teknosa’ya Hoş Geldiniz']"));
        System.out.println(yazi.getText());
    }
}
