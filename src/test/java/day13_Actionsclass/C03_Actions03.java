package day13_Actionsclass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions03 extends TestBase {
    /*
     https://techproeducation.com adresine gidin
     Sayfanın alt tarafına gidin
     Sayfanın üst tarafına gidin
     */


    @Test
    public void actions() {
        // https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Sayfanın alt tarafına gidin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

        //Sayfanın üst tarafına gidin
        bekle(2);
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();

    }

    @Test
    public void actions02() {
        // https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Sayfanın alt tarafına gidin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform(); //End : sayfanin en sonuna goturur

        //Sayfanın üst tarafına gidin
        bekle(2);
        actions.sendKeys(Keys.HOME).build().perform(); //Home: sayfanin en ustune cikar
        //build().perform() ile action objesini birbirine baglariz ustekinde perform kullanmaya gerek kalmaz
    }

    @Test
    public void actions3() {
        driver.get("https://amazon.com");
        //arama kutusunda buyuk harflerle Samsung aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(Keys.SHIFT,"s",Keys.SHIFT,"amsung",Keys.ENTER);
        //shif ile ilk harfi buyuk yazip tekrar shift yazaarak iptal ettik digerlerini kucuk yazdi.


    }
}
