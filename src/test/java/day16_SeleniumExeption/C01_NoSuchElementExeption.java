package day16_SeleniumExeption;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementExeption extends TestBase {
    @Test
    public void NoSuchElementExeption() {
        /*
        NoSuchElementExeption :
        Sayfada bulunmayan bir elemente erisim saylamaya calisildiginda karsilasilir
         */
        //Techpro education sayfasina gidelim searchbox elementini locate edelim
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //Reklam kapatir
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("java", Keys.ENTER);

        //locate hatasi yapilirsa asagidaki gibi Exeption alinir
        //at day16_SeleniumExeption.C01_NoSuchElementExeption.NoSuchElementExeption(C01_NoSuchElementExeption.java:19)
    }
}
