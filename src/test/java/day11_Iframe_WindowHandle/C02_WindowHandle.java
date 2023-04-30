package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandle extends TestBase {
    /*
    //Window 1'de https://www.techproeducation.com adresine gidiniz
    //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
    //Window 2'de https://www.youtube.com sayfasını açınız:
    //Window 3'te https://www.linkedin.com sayfasını açınız:
    //techproeducation sayfasına geçiniz:
    //youtube sayfasına geçiniz:
    //linkedIn sayfasına geçiniz:
     */

    @Test
    public void windowHandle() {
        driver.get("https://www.techproeducation.com");
        String techprowindowHandle = driver.getWindowHandle();//baska sayfadayken bu sayfaya kolayca geri donebilmek icin yaptik bunu
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitel = driver.getTitle();
        String expectedTitel = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitel,actualTitel);

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().//gecis icin
                         newWindow(WindowType.WINDOW); //yeni bir pencereye driver'i tasir.
        //windowType.TAB --> yeni sekmede acar
        //newWindow(WindowType.WINDOW) yeni pencere acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        bekle(3);
        driver.switchTo().window(techprowindowHandle);

        //youtube sayfasına geçiniz:
        bekle(3);
        driver.switchTo().window(youtubeWindowHandle);

        //linkedIn sayfasına geçiniz:
        bekle(3);
        driver.switchTo().window(linkedinWindowHandle);


        List<String> tumWindowList = new ArrayList<String>(driver.getWindowHandles());
        //boyle butun Handlelari liste atip index numarasi ile cagirabiliriz. Her link altinda String ile Handle degerini almaya gerek kalmaz buda baska bir alternatif
       // driver.switchTo().window(tumWindowList.get(0));
       // driver.switchTo().window(tumWindowList.get(1));
       // driver.switchTo().window(tumWindowList.get(2));  gibi


    }
}
