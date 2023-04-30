package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Deneme13 extends TestBase {
     /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test  edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
     */

    @Test
    public void name() {
        driver.get("https://amazon.com");
        Set<Cookie> cookiesList = driver.manage().getCookies();
        for (Cookie cookie:cookiesList) {
            System.out.println("Name : "+cookie.getName());
            System.out.println("Value : "+cookie.getValue());

        }
        int cookieSize = driver.manage().getCookies().size();
        Assert.assertTrue(cookieSize>5);

      String cookieValue =  driver.manage().getCookieNamed("i18n-prefs").getValue();
      Assert.assertEquals("USD",cookieValue);
      Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
      driver.manage().addCookie(cookie);

      cookiesList = driver.manage().getCookies();
      int sayac = 1;
        for (Cookie cookies:cookiesList) {
            System.out.println(sayac+". ci cookie :"+cookies.getName()+cookies.getValue());
            sayac++;
        }

        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookiesList.contains("skin"));

        driver.manage().deleteAllCookies();
       cookiesList = driver.manage().getCookies();
        Assert.assertTrue(cookiesList.isEmpty());
    }
}
