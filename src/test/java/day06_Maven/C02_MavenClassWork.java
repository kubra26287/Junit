package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_MavenClassWork {
    public static void main(String[] args) {
        /*
        http://zero.webappsecurity.com sayfasina gidin
        Signin buttonuna tiklayin
        Login alanine  “username” yazdirin
        Password alanine “password” yazdirin
        Sign in buttonuna tiklayin
        Pay Bills sayfasina gidin
        amount kismina yatirmak istediginiz herhangi bir miktari yazin
        tarih kismina “2020-09-10” yazdirin
        Pay buttonuna tiklayin
        “The payment was successfully submitted.” mesajinin ciktigini control edin
       */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com");

        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //Login alanine  “username” yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");
        //Password alanine “password” yazdirin-->//*[@id='user_password']
        WebElement password = driver.findElement(with(By.tagName("input")).below(login));
        password.sendKeys("password");

        //Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.navigate().back();  // Sign in butonuna bastiktan sonra guvenlik problemini gecmek icin back() yaptik

        // Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        // amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //*[@id='sp_amount']
        WebElement amout = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amout.sendKeys("20");

       // tarih kismina “2020-09-10” yazdirin
       WebElement tarih = driver.findElement(By.cssSelector("input[id='sp_date']"));
       tarih.sendKeys("2020-09-10");
       //Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input[id='pay_saved_payees']")).click();

         //“The payment was successfully submitted.” mesajinin ciktigini control edin
       WebElement mesaj = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if (mesaj.isDisplayed()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        driver.close();

        //ODEV
        /*
        https://www.google.com/ adresine gidin  3- cookies uyarisini kabul ederek kapatin
Sayfa basliginin “Google” ifadesi icerdigini test edin
Arama cubuguna “Nutella” yazip aratin
Bulunan sonuc sayisini yazdirin
sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
Sayfayi kapatin

         */


        /*
        “https://www.saucedemo.com” Adresine gidin
Username kutusuna “standard_user” yazdirin
Password kutusuna “secret_sauce” yazdirin
Login tusuna basin
Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
Add to Cart butonuna basin
Alisveris sepetine tiklayin
Sectiginiz urunun basarili olarak sepete eklendigini control edin
Sayfayi kapatin
         */


    }
}
