package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class DenemeHandle extends TestBase {
           /*
    https://the-internet.herokuapp.com/windows adresine gidin.
    İlk sayfanın ID'sini(Window Handle değerini) alın.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    "Click Here" butonuna tıklayın.
    Açılan pencereye geçin.
    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
    2. pencereye tekrar geçin.
    1. pencereye tekrar dönün.
     */

    @Test
    public void windowHandle() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilksayfaWindowHandle =driver.getWindowHandle();
       String actualText = driver.findElement(By.xpath("//h3")).getText();
       String expectedText = "Opening a new window";
       Assert.assertEquals(expectedText,actualText);
      String actualTitel = driver.getTitle();
      String expectedTitel ="The Internet";
      Assert.assertEquals(expectedTitel,actualTitel);
      driver.findElement(By.xpath("//*[text()='Click Here']")).click();

      List<String> tumPencereler = new ArrayList<>(driver.getWindowHandles());
      driver.switchTo().window(tumPencereler.get(1));

      String actualTitel1 = driver.getTitle();
      String expectedTitel1 = "New Window";
      Assert.assertEquals(expectedTitel1,actualTitel1);

      driver.switchTo().window(ilksayfaWindowHandle);
        String actualTite = driver.getTitle();
        String expectedTite ="The Internet";
        Assert.assertEquals(expectedTitel,actualTitel);

        driver.switchTo().window(tumPencereler.get(1));
    }
}
