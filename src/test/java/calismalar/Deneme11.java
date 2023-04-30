package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Deneme11 extends TestBase {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın

    @Test
    public void name() {
        driver.get("https://www.amazon.com/");
       WebElement dropD = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropD);
        select.selectByVisibleText("Baby");
        System.out.println("Baby optionu = " + select.getFirstSelectedOption().getText());
        List<WebElement> ddbList = select.getOptions();
        int optionSize = ddbList.size();
        int expectedSize = 28;
        Assert.assertEquals(expectedSize,optionSize);
        int sayac =1;
        for (WebElement w:ddbList) {
            System.out.println(sayac+".ci option" + w.getText());
            sayac++;
        }
    }
}
