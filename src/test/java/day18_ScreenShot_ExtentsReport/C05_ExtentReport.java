package day18_ScreenShot_ExtentsReport;

import com.aventstack.extentreports.ExtentTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_ExtentReport extends TestBase {
    @Test
    public void test() {
        extentReports(); //Method olusturduk onu cagirdik
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        extentTest.info("Techpro sayfasina gidildi");
        bekle(3);
        extentTest.info("3 saniye bekletildi");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); //Reklam kapatir
        extentTest.info("cikan reklam kapatildi");

        //sayfanın resmini alalım
        tumSayfascreenShot();
        extentTest.info("Tum sayfanin resmi alindi");

        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("java", Keys.ENTER);
        extentTest.info("Arama bolumunde Java aratildi");

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        webelementScreenShot(sonucYazisi);//method kullandik
        extentTest.info("sonuc yazisinin resmi alindi");
        extentTest.info("Test sonlandirildi");
        extentReports.flush(); //raporlama icin


    }
}
