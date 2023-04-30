package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme9 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
     // driver.close();
    }

    @Test
    public void name() throws InterruptedException {
        /*
        1.http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3.Loginalanine “username”yazdirin
        4. Password alanine “password” yazdirin
        5. Sign in buttonuna tiklayin
        6. Pay Bills sayfasina gidin
        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        8. tarih kismina “2020-09-10” yazdirin
        9. Pay buttonuna tiklayin
        10.“The payment was successfully submitted.” mesajinin ciktigini control edin
         */
        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();
       WebElement userName =  driver.findElement(By.xpath("//*[@id='user_login']"));
       userName.sendKeys("username");
       Thread.sleep(3000);
       WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
       password.sendKeys("password");
        Thread.sleep(3000);
       driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
    }
}
