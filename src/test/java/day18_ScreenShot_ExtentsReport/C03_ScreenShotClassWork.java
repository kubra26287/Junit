package day18_ScreenShot_ExtentsReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_ScreenShotClassWork extends TestBase {
    @Test
    public void ScreenShotClassWork() {
        //Techproeducation sayfasına gidelim
        //sayfanın resmini alalım
        //Arama bölümünde java aratalım
        //ve sonuc yazısının resmini alalım
        //Yeni bir sekmede amazona gidelim
        //sayfanın resmini alalım
        //arama bölümde iphone aratalım
        //ve sonuc yazısının resmini alalım
        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); //Reklam kapatir

        //sayfanın resmini alalım
        tumSayfascreenShot();
        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("java", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
       WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
       webelementScreenShot(sonucYazisi);
        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        //sayfanın resmini alalım
        tumSayfascreenShot();
        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi2 = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webelementScreenShot(sonucYazisi2);
        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow(0);//test base methodu
        tumSayfascreenShot();
    }
}
