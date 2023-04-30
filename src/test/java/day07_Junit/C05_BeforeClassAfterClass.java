package day07_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C05_BeforeClassAfterClass {
    WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Amazon Testi baslatildi");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon Testi sonuclandi");
    }

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void Test01() {
       // driver.get("https://amazon.com"); bunu buraya yazarsak diger testler calismaz bu yuzden BeforeClass a almamiz gerekir
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung", Keys.ENTER);
    }

    @Test
    public void Test02() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);

    }
}
