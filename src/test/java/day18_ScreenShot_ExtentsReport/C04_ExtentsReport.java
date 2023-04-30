package day18_ScreenShot_ExtentsReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_ExtentsReport extends TestBase {
    ExtentReports extentReports; //Raporlamayi baslatir
    ExtentTest extentTest;
    ExtentHtmlReporter extentHtmlReporter;

    @Test
    public void ExtentsReport() {
        /*
       EXTENTREPORT kullanabilmemiz icin;
       1-pom.xml dosyasina extentreport dependency'si eklenir
       2-ExtentReport class'indan bir obje olusturulur //Raporlamayi baslatir
       3-HTML formatinda duzenlenecegi icin ExtentHtmlReporter class'indan obje olusturulur.//raporu html formatinda duzenler
       4-Rapora test ile ilgili bilgiler girebilmek icin ExtentTest class'indan bir obje olusturulur
 */
       extentReports = new ExtentReports(); //2
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu ="test_output/report/extentsReport"+tarih+".html";
        extentHtmlReporter =new ExtentHtmlReporter(dosyaYolu); //3
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Kubra");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("smoke Test Raporu");
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");

        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Amazon sayfasina iphone aramasi yapildi");
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisi.getText());
        extentTest.info("Sonuc yazisi konsola yazdirildi");
        extentTest.pass("sayfa kapatildi");
        extentReports.flush();


    }
}
