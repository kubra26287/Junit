package calismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Deneme8 extends TestBase {
    /*
        a. Verilen web sayfasına gidin.
        https://the-internet.herokuapp.com/checkboxes
        b. Checkbox1 ve checkbox2 elementlerini locate edin.
        c. Checkbox1 seçili değilse onay kutusunu tıklayın
        d. Checkbox2 seçili değilse onay kutusunu tıklayın
         */

    @Test
    public void checkbox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
      WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
      WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

      if (!checkbox1.isSelected()){
          checkbox1.click();
      }
      if (!checkbox2.isSelected()){
          checkbox2.click();
      }

    }
}
