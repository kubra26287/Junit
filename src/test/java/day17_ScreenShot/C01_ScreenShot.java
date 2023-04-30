package day17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void screennschot() throws IOException {
        /*
            Tüm ekran görüntüsünü Selenium'dan gelen getScreenShotAs methodu ile alırız.
        Bu method selenium'daki TakesScreenshot arayüz'ünden(interface) gelir
         */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //1.adim =ilk olarak ekran resmini alacagimiz dosyayi nereye kaydedigimizi belirtiriz
        //bunun icin once proje basliginin altinda new +drectory tiklayip test_output ismi verir,dosyalarimizi bunun icne kaydeder.

        //String dosyaYolu ="screenShot.png";Sadece Bu sekilde yaparsak pom.xml in altinda bir dosya acar. Bunun icine de kaydedebiliriz

        String dosyaYolu ="test_output/screenShot.png"; //test output dosyasina sag tik ile 'copyPath reference' ile dosya yolunu aldik 'test_output' yapistirdik.
        // sonra dosya adini 'screenShot' yazdik .png uzantisi ile

       //2. adim: TakesScreenshot arayuzunden obje olusturmak
        TakesScreenshot ts = (TakesScreenshot) driver;// TakesScreenshot:Ekran goruntusunu al. Parantez icine yazili TakesScreenshot ile TypeCasting yaptik
        //cunku; driver in Type i webelement, digeri TakesScreenshot classindan bu yuzden TypeCasting yaptik


      /*
            FileUtils class'ı file nesneleri ile birlikte kullanabileceğimiz methodlar içerir.
        Bu methodları kullanarak dosyalarda okuma, yazma, kopyalama ve silme işlemlerini çok daha kolay yapabiliriz
        NOT: Files.write() methodu'da aynı işlemi görür
         */
       //3.adim:
        //Ekran resmini projemize kaydedelim
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        //File kutuphanesinden copyFile ile Git ekrangoruntusunu al. OutputType i da FILE olsun sonra aldigimiz dosya yolunu da
        // o dosyanin icine koy.

    }

    @Test
    public void screenShottest2() throws IOException {
        driver.get("https://amazon.com");
        //Kaydettigimiz ekran resmini her seferinde ayni dosyanin uzerine yazmamasi icin
        // dosya isminden sonra bir tarih atariz
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu ="test_output/screenShot"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
}
