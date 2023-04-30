package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme3 {
   /*
   -BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
-Before methodunda http://www.google.com adresine gidin
-Üç farklı test methodu ile;
-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
-NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
-AfterClass ile kapatın
    */
   WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.google.com");
    }

    @Test
    public void test01() {
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
       WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
       searchBox.sendKeys("The God Father", Keys.ENTER);
       String sonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ")[1];
        System.out.println(sonucSayisi);

    }

    @Test
    public void test02() {
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("Lord of the Rings",Keys.ENTER);
        String sonucsayisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ")[1];
        System.out.println(sonucsayisi);
    }

    @Test
    public void test03() {
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("Kill Bill",Keys.ENTER);
        String sonucsayisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ")[1];
        System.out.println(sonucsayisi);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();


    }
}
