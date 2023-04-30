package day05_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_Files  {
    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

    //Not:
    //selenium bilgisayardaki masaustune indirilenlere mudahale edemez sadcee websayfasi test eder bu yuzden java ile test edicez.

    @Test
    public void test01() {
      ///Users/fatihyilmaz : herkesin bilg. farkli olan kisim      /Desktop: herkesin bilg. ayni olan kisim
      String farkliKisim =  System.getProperty("user.home");
        System.out.println(farkliKisim);
      String ayniKisim = "/Desktop";
        System.out.println(ayniKisim);

        String dosyaYolu = farkliKisim + ayniKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
