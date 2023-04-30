package day16_SeleniumExeption;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_NullPointerException {
    /*
    NullPointerException:
    Degisken (obje) olusturup bu degiskene atama yapmadigimizda yada esitlemedigimizde NullPointerException hatasi aliriz

   Not:
    Non Primitive'lerde default deger null oldugu icin NullPointerException aliriz.
    Numeric olan primitive'lerde default deger sayi oldugundan bu hata alinmaz.
     */
    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    int number ;
    String isim;
    @Test

    public void NullPointerException() {
        driver.get("https://amazon.com"); //C03_NullPointerException.name(C03_NullPointerException.java:22)
        //driver objemize browser atamasi yapmadigimiz icin NullPointerException hatasi aliriz

    }

    @Test
    public void NullPointerException1() {
        //faker = new Faker; bu atamayi yapmadigimiz icin bu hatayi aldik
        System.out.println(faker.name().firstName());

    }

    @Test
    public void NullPointerException2() {
       // actions = new Actions(driver); atamasi yapmadigimiz icin bu hatayi aliriz
        actions.doubleClick().perform();//java.lang.NullPointerExeption

    }

    @Test
    public void NullPointerException3() {
       // sayi = 0; sayi degiskenine atama yapilmadigi icin hata aliriz
        System.out.println(sayi+5);//C03_NullPointerException.NullPointerException3(C03_NullPointerException.java:43)
    }

    @Test
    public void NullPointerException4() {
        //isim="Erol"; atamasi yapmazsak
        System.out.println(isim.charAt(0));//C03_NullPointerException.NullPointerException4 hatasi aliriz
    }

    @Test
    public void NullPointerException5() {
        System.out.println(number);
    }

    @Test
    public void StaleElementReferanceExceptionTest5() {
        /*
        NOT:StaleElementReferanceException hatası almamız gerekiyor
        //Amazon sayfasına gidelim
        //iphone aratalım
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        //Sayfayı kapatalım
         */
    }
    @Test
    public void StaleElementReferanceExceptionTest6() {
        /*
        NOT:Exception almadan doğru şekilde yapalım
        //Amazon sayfasına gidelim
        //iphone aratalım
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        //Sayfayı kapatalım
         */
    }
}
