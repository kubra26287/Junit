package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {
    @Test
    public void fileDownload() {
      /*  https://testcenter.techproeducation.com/index.php?page=file-download    adresine gidelim.
                b10 all test cases dosyasını indirelim
        Dosyanın başarıyla indirilip indirilmediğini test edelim

       */
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download ");
        bekle(2);
        //eger localinizden otomasyon ile dosya silmek icin File classindan obje olusturup dosya yolumuzu icine yerlestiririrz
        //ve olusturdugumuz obje ile delete methodunu kullanarak o dosyayi silebiliriz
        //bunun sebebi test classi tekrar calistirdimizda dosyasi  yeniden indirecegi icin dosya kalabaligi olusturmamak icin ve indirilen dosyalara her defasinda bir index verecegi icin test ederken de
        // bir onceki indirilmis dosyayi test eder bu yuzden test islemi saglikli gerceklesmemeis olur.
        File sil = new File("/Users/fatihyilmaz/Downloads/b10 all test cases, code.docx");
        sil.delete();
        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//a)[3]")).click();
        bekle(5);
        //Dosyanın başarıyla indirilip indirilmediğini test edelim

        //ilk olarak dosya yolunu aliyoruz
        String dosyaYolu = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
