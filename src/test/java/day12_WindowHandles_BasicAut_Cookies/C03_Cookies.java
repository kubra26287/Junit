package day12_WindowHandles_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
     */

    @Test

    public void cookies() throws InterruptedException {
        // 1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        //2-tum cookie’leri listeleyin
       //Tüm cookiesleri listeleyebilek icin  driver.manage().getCookies() methodunu kullaniriz
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac=1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac+".ci cookie "+w);
            System.out.println("Name "+w.getName());  //adini yazdirmak istedigimiz de getName
            System.out.println("Value "+w.getValue()); //degeri istedigimizde getValue
            sayac++;
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = cookieSet.size();
        Assert.assertTrue(cookieSayisi>5);

        //4-ismi "i18n-prefs" olan cookie degerinin "USD" oldugunu test edin
        String cookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD",cookieValue);

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie =new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet=driver.manage().getCookies();
        int sayac1=1;
        for (Cookie cookie1:cookieSet){
            System.out.println(sayac1+". ci cookies "+cookie1);
            sayac1++;
        }

        // 7-ismi "skin" olan cookie’yi silin ve silindigini test edin
        Thread.sleep(3000);
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieSet.contains("skin"));
        int cookieSizeSilinmis = cookieSet.size();
        cookieSet=driver.manage().getCookies();
        int sayacc=1;
        for (Cookie cookie1:cookieSet){
            System.out.println(sayacc+". ci cookies "+cookie1);
            sayacc++;
        }

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies(); //once sildik
        cookieSet = driver.manage().getCookies(); //sonra silinmis halini set e attik
        Assert.assertTrue(cookieSet.isEmpty());   //bos oldugunu test ettik
       



     //    driver.switchTo().frame(3);
        //    driver.findElement(By.xpath("//*[@id='save']")).click();

    }
}
