package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Deneme10 extends TestBase {
    //1.http://zero.webappsecurity.com/ Adresine gidin 2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password.” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10.“US Dollars” in secilmedigini test edin
    //11.“Selected currency” butonunu secin
    //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin 13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini
    //kontrol edin.


    @Test
    public void name() {
        //● https://www.amazon.com/ adresine gidin.
        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        driver.get("https://www.amazon.com/");
       WebElement dropDown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDown);
        List<WebElement> kategoriList = select.getOptions();
        int actualList = kategoriList.size();
        int expectedList=45;
        Assert.assertEquals(expectedList,actualList);






    }
}
