package day13_Actionsclass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C04_actions04 extends TestBase {
    /*
    https://jqueryui.com/droppable/ adresine gidin
    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
     */
    //3 farkli sekilde cozduk asagida 

    @Test
    public void actions() {
         driver.get("https://jqueryui.com/droppable/");
        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.

        driver.switchTo().frame(0);
        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        //bir elementi digeri uzerine koymak icin dragAndDrop methodu kullanilir
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragSource,dropTarget).perform();   //kaynak(drag) (source) elementini Hedef(drop)(Target) elementi uzerine birakir.
    }

    @Test
    public void actions2() {
        driver.get("https://jqueryui.com/droppable/");
        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.

        driver.switchTo().frame(0);
        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        //bir elementi tutup digeri uzerine koymak icin bu methodu kullanilir
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource). //webelementi tutup bekler
                            moveToElement(dropTarget). //mouse u elementin uzerine tasir
                            release().  //mouse u serbest birakir
                            perform();
    }

    @Test
    public void actions3() {
        driver.get("https://jqueryui.com/droppable/");
        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.

        driver.switchTo().frame(0);
        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        //bir elementi tutup digeri uzerine koymak icin dragAndDrop methodu kullanilir
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource).
                moveByOffset(84,28). //webelementi istedigimiz koordinata tasir.
                release().perform();
    }
}
