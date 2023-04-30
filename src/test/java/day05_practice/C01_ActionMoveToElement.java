package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C01_ActionMoveToElement extends TestBase {
    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

    // https://amazon.com adresine gidiniz

    @Test
    public void name() {
        driver.get("https://amazon.com");
        String sayfa1Handle = driver.getWindowHandle();
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dilMenu = driver.findElement(By.xpath("//div[text()='EN']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(dilMenu).perform(); //action objesini kullanarak mausu moveToelement ile dil menusu uzerine getirdik
        bekle(3);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        //DropDown acik kaldigi icin 'go to website' ye tiklayamadigindan dolayi herhangi bir yerin locate ini alip tiklariz. DropDown menu kapanir.
        //daha sonrasinda go to website ye tiklayabilir.
        driver.findElement(By.xpath("//*[@id='icp-dropdown_18']")).click();
        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

        Set<String> windowhandlesSet = driver.getWindowHandles();
        System.out.println("Tum Sayfalarin handle degeri ="+windowhandlesSet);
        System.out.println("sayfa1Handle="+sayfa1Handle);
       String sayfa2Handle="";
        for (String w:windowhandlesSet) {
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle=w;
            }

        }
        System.out.println("sayfa2Handle = " + sayfa2Handle);

       driver.switchTo().window(sayfa2Handle);
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
        String actualTitel =driver.getTitle();
        System.out.println("actualTitel = " + actualTitel);
        String expectedTitel = "Elektronik";
        Assert.assertTrue(actualTitel.contains(expectedTitel));

    }
}
