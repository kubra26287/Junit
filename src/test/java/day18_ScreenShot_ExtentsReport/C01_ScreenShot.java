package day18_ScreenShot_ExtentsReport;

import org.junit.Test;
import utilities.TestBase;

public class C01_ScreenShot extends TestBase {
    @Test
    public void screenShotTest1() {
    //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

    //Sayfanın resmini alalım
        tumSayfascreenShot();//Test Base de Method olusturup kullandik
    //Sonra amazon sayfasına gidelim
        driver.get("https://amazon.com");
    //Amazon sayfasının ekran görüntüsünü alalım
        tumSayfascreenShot();//Test Base de Method olusturup kullandik


    }
}
