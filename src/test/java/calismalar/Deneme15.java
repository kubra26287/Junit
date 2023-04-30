package calismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deneme15 extends TestBase {
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
// ikinci emojiye tıklayın
// İkinci emoji öğelerini yazdırınız
// Parent iframe e geri donun
// Formu doldurun,(Formu istediğiniz metinlerle doldurun)
// Apply button a basiniz

    @Test
    public void iframe() {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        List<WebElement> emojiList = driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']"));
        for (WebElement w:emojiList) {
            System.out.println(w.getText());

        }

        driver.switchTo().defaultContent();
        List<WebElement> formList = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));


        List<String> veriler = new ArrayList<>(Arrays.asList(
                "Erol","Evren","selenium","lambda","java","sql","gitgithub","fsd","dfasf","lkjl","asdasd","asd","sda"));

        for (int i = 0; i < formList.size() ; i++) {
            formList.get(i).sendKeys(veriler.get(i));

        }
       driver.findElement(By.xpath("//*[@id='send']")).click();

    }
}
