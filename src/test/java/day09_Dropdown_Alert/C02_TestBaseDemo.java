package day09_Dropdown_Alert;


import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;


public class C02_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //Techproya git
        driver.get("https://techproeducation.com");
        //Basligin "Bootcamp" icerdigini test edin
        String actualTitel = driver.getTitle();
        String expectedTitel = "Bootcamp";
        Assert.assertTrue(actualTitel.contains(expectedTitel));
    }
}
