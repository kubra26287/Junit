package day16_SeleniumExeption;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_StaleElementReferenceException extends TestBase {
    /*
    StaleElementReferenceException:

    Bir web sayfasindaki bir webelementin gecerliliginin kayboldugu durumlarda olusur
    yani bir web elementi locate ettikten sonra sayfada
    refresh yada back -forward kullaniyorsak yeniden o elemente ulasmakistedigimizde
    bu hatayi aliriz bunu handle edebilmek icin  webelemente yeniden locate atamaliyiz.
    (Webelementin locate ini hatirlatma gibi
     */

    @Test
    public void StaleElementReferenceExceptionHATASIZ() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //Reklam kapatir
        //sayfaya gittikten sonra sayfayi yenileyelim
        driver.navigate().refresh();
        //login butonuna tiklayalim
        driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]")).click();
    }

    @Test
    public void StaleElementReferenceExceptionHATALI() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //Reklam kapatir

        //login butonuna tiklayalim
      WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        //sayfaya gittikten sonra sayfayi yenileyelim
        driver.navigate().refresh();
        //logine Tikla
        login.click();
        //WEbelementi locate ettikten sonra sayfayi yeniledikten sonra clickledik bu yuzden StaleElementReferenceException
        //hatasi aldik cunku locate ettikten sonra refresh yaptigimiz icin element eskimis oldu. Dolayisiyla bu elementi hamdle
        //edebilmek icin click yapmadan once tekrar ayni locati webelemente atamamiz gerekir.

    }

    @Test
    public void StaleElementReferenceExceptionHANDLE() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //Reklam kapatir

        //login butonuna tiklayalim
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        //sayfaya gittikten sonra sayfayi yenileyelim
        driver.navigate().refresh();
        //logine Tikla
        login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();
    }

    @Test
    public void StaleElementReferenceException() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //Reklam kapatir

        //login butonuna tiklayalim
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();
        bekle(2);
        //sayfaya gittikten sonra sayfayi yenileyelim
        driver.navigate().back();
        //logine Tikla
       // login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]")); Bu atamayi yapsaydik hata almazdik
        login.click(); //C04_StaleElementReferenceException.StaleElementReferenceException

    }
    @Test
    public void StaleElementReferanceExceptionTest5() {
        //NOT:StaleElementReferanceException hatası almamız gerekiyor
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//h2"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            bekle(3);
            driver.navigate().back();
            bekle(3);
            if (i==4){
                break;
            }
        }
        //Sayfayı kapatalım
    }
    @Test
    public void StaleElementReferanceExceptionTest6() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//h2"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            bekle(3);
            driver.navigate().back();
            bekle(3);
            if (i==4){
                break;
            }
            urunler = driver.findElements(By.xpath("//h2"));
        }
    }
}
