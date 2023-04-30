package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
    /*
        https://www.amazon.com/ sayfasina gidelim
        arama kutusunu locate edelim
       “Samsung headphones” ile arama yapalim
        Bulunan sonuc sayisini yazdiralim
        Ilk urunu tiklayalim
        Sayfadaki tum basliklari yazdiralim
        Collapse
*/
        WebDriverManager.chromiumdriver().setup();   //dependieses lerle kisa yoldan driver calistirma
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Samsung headphones");
        aramakutusu.submit();

        // Bulunan sonuc sayisini yazdiralim
        WebElement sonucsayisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String [] sonuc =  sonucsayisi.getText().split(" ");
        System.out.println("Bulunan sonuc sayisi " +sonuc[2]);

        //2. yol lambda ile yazdiralim
        //1-16 of 200 results for
        Arrays.stream(sonucsayisi.getText().split(" ")).skip(2).limit(1).  //skip ile 2 yi atla limit 1. sini ver
                forEach(t->System.out.println("Sonuc sayisi"+t));
        // Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")).click();

        //  Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1"));
        //foreach ile
        for (WebElement w:sayfaBasliklari) {
            System.out.println(w.getText());

        }
       //lambda ile
        sayfaBasliklari.forEach(t-> System.out.println(t.getText()));
    }
}
