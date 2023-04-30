package calismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Deneme5 extends TestBase {
    /*
    -Amazon sayfasına gidelim
    -Arama Kutusundaki Dropdown menuyu yazdıralım
    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
     başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    Not: Select Class'ı kullanalım
     */

    @Test
    public void Amazon() {
       driver.get("https://amazon.com");
        Select select = new Select(driver.findElement(By.cssSelector("select[id='searchDropdownBox']")));
        for (WebElement w:select.getOptions()) {
            System.out.println(w.getText());
        }
// input[id='nav-search-submit-button']
        for (int i = 1; i <6 ; i++) {
            Select options = new Select(driver.findElement(By.cssSelector("select[id='searchDropdownBox']")));
            options.getOptions().get(i).click();
            driver.findElement(By.cssSelector(" input[id='nav-search-submit-button']")).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();

        }
    }
}
