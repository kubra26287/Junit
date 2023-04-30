package day6_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    // Ulkeler dosyasındaki 3.satırdaki indexin, 3.sutunundaki indexinin
    // "Cezayir" oldugunu test eden method olusturunuz


    @Test
    public void test01() throws IOException {
        int satirNoIndex = 3;
        int sutunNoIndex = 3;
       String actualData = banaDataGetir(satirNoIndex,sutunNoIndex);
       String expectedData ="Cezayir";
        Assert.assertEquals(expectedData,actualData);
    }

    public String banaDataGetir(int satirNoIndex, int sutunNoIndex) throws IOException {
        String dosyaYolu = "src/test/java/resourses/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //FileInputStream DOsyamizi sisteme getirir akisimiza alir.
        Workbook workbook = WorkbookFactory.create(fis);
        //olusturdugumuz fis dosyayi calisma alanina workbook a atadik.
       String istenenData = workbook.getSheet("Sayfa1").getRow(satirNoIndex).getCell(sutunNoIndex).toString();
       return istenenData;

    }
}
