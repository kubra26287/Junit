package day21_JSExecutor;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

public class C01_JS_Executor_Click extends TestBase {
    /*
        Eğer bir web sayfasının HTML kodları tamamen yada kısmen JavaScript kullanılarak oluşturulduysa
     o sayfaya müdahale etmek için genellikle JavaScriptExecutor arayüzünü kullanmak gerekir.
        Bu durumda, sayfayı manipüle etmek veya etkileşimde bulunmak için standart WebDriver komutları
     yetersiz kalabilir. Bu nedenle JSExecutor arayüzü, sayfanın JS kodlarına doğrudan erişebilir.
        Ancak, mümkünse WebDriver'in sunduğu standart yöntemlerle sorunları çözmek her zaman daha iyidir.
     Çünkü JS kullanımı, sayfanın daha yavaş yüklenmesine neden olabili.
    */

    /*
    http://www.uitestpractice.com/Students/Form sayfasına git
    Formu doldur
    Submit tuşuna tıkla
    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
    */
    @Test
    public void name() {
        driver.get("http://www.uitestpractice.com/Students/Form");

        //Formu doldur
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,Keys.TAB,Keys.TAB,
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,faker.phoneNumber().cellPhone());
        //Submit tuşuna tıkla
        WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
        //1. yol
        // submit.click();
        //org.openqa.selenium.ElementClickInterceptedException: Eğer JS kodlarıyla bir web element oluşturulmuşsa
        //normal click() methodunda bu exception'ı alırız
        //JavascriptExecutor js = (JavascriptExecutor) driver; //once driver yazariz uyari verir casting yap diye yaptiktan sonra (Javascrip) gelir onune
        //js.executeScript("arguments[0].click();",submit);

        //2. yol
        /*
        try {
            submit.click();
        } catch (Exception e) {
            JavascriptExecutor jS = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",submit);
        }

         */
        //3. yol Method olusturduk TestBase de
        click(submit);

        //Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        Assert.assertNotEquals("http://www.uitestpractice.com/Students/Form?optradio=on",driver.getCurrentUrl());
    }

}
