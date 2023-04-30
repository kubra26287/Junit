package calismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Deneme20 extends TestBase {
    //techproya gidin
    //ilk kelime SHIFT tusuna basili sekilde, ikinci kelime basilmadan "TECHPRO education" aramasi yapin

    @Test
    public void name() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
       WebElement search = driver.findElement(By.xpath("//*[@type='search']"));
        Actions actions = new Actions(driver);
      actions.keyDown(search,Keys.SHIFT).sendKeys("techpro").keyUp(search,Keys.SHIFT).sendKeys("education",Keys.ENTER).perform();

    }
}
