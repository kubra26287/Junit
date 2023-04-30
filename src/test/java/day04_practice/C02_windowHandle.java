package day04_practice;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.awt.image.Kernel;

public class C02_windowHandle extends TestBase {
    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        String windowHandle1 = driver.getWindowHandle();
        bekle(2);
        // 2- url'in 'amazon' icerdigini test edelim
        String amazonUrl = driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));
        bekle(2);
        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        bekle(2);
        driver.get("https://www.bestbuy.com");
        String Handle2 = driver.getWindowHandle();
        // 4- title'in 'Best Buy' icerdigini test edelim
       String titel =  driver.getTitle();
       Assert.assertTrue(titel.contains("Best Buy"));
       bekle(2);
        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(windowHandle1);
       WebElement search = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
       search.sendKeys("Java", Keys.ENTER);
       bekle(2);
        // 6- arama sonuclarının 'Java' icerdigini test edelim
       WebElement aramaSonucu =   driver.findElement(By.cssSelector("div[class='a-section a-spacing-small a-spacing-top-small']"));
       Assert.assertTrue(aramaSonucu.getText().contains("Java"));
       bekle(2);
        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(Handle2);
        // 8- logonun gorundugunu test edelim
       WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
        bekle(2);

    }
}
