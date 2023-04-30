package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Deneme12 extends TestBase {    // https://demo.guru99.com/test/radio.html adresine gidin
    // radiobutton elementlerini locate edin
    // option2'yi secin
    // option2 elementlerinin secili oldugunu Test edin
    // option1 elementlerinin secili olmadıgını test edin
    // option3 elementlerinin secili olmadıgını test edin

    @Test
    public void radioutton() {
        driver.get("https://demo.guru99.com/test/radio.html");


       WebElement ortion2 = driver.findElement(By.xpath("//*[@id='vfb-7-2']"));
       ortion2.click();
        Assert.assertTrue(ortion2.isSelected());

        WebElement ortion3 = driver.findElement(By.xpath("//*[@id='vfb-7-3']"));
        Assert.assertFalse(ortion3.isSelected());

        WebElement ortion1 = driver.findElement(By.xpath("//*[@id='vfb-7-1']"));
        Assert.assertFalse(ortion1.isSelected());

    }
}
