package day07_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C06_CheckBoxClassWork {
    /*
     Verilen web sayfasına gidin.
     https://the-internet.herokuapp.com/checkboxes
     Checkbox1 ve checkbox2 elementlerini locate edin.
     Checkbox1 seçili değilse onay kutusunu tıklayın
     Checkbox2 seçili değilse onay kutusunu tıklayın

     */
WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void CheckBox() throws InterruptedException {
         /*
     Verilen web sayfasına gidin.
     https://the-internet.herokuapp.com/checkboxes
     Checkbox1 ve checkbox2 elementlerini locate edin.
     Checkbox1 seçili değilse onay kutusunu tıklayın
     Checkbox2 seçili değilse onay kutusunu tıklayın

     */
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Thread.sleep(3000);
      if (!checkBox1.isSelected()){
          checkBox1.click();
      }
        Thread.sleep(3000);
      if (!checkBox2.isSelected()){
          checkBox2.click();
      }
    }
}
