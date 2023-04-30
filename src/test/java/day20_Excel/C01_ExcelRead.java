package day20_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void name() throws IOException {
/*
    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    Kullanılan satır sayısın bulun
    Ülke-Başkent şeklinde verileri yazdırın
    */

 //Excel dosyasindan bir veri okuyabilmemiz icin oncelikle ne yapmak gerekir.
       //1 - Dosya yolu aliriz
        String dosyaYolu = "src/test/java/resourses/Capitals (2).xlsx";
       //2- Dosyayi okuyabilmek icin akisa almak gerekir.
        FileInputStream fis = new FileInputStream(dosyaYolu);
       //3-java ortaminda bir excel dosyasi olusuturmamiz gerekir.
        Workbook workbook = WorkbookFactory.create(fis); //creat fis ile excel de bu dosyayi okuruz.
        //4- exceldeki sayfayi(sheet) secmemiz gerekir
        Sheet sheet = workbook.getSheet("Sheet1");
        //5- Satir secmemiz gerekir
        Row row = sheet.getRow(0);//"0" 1. satirdir index meselesi

        //6-Hücreyi (Cell) secmemiz gerekir.
        Cell cell = row.getCell(0);//1. sütun

        System.out.println(cell);
    }

    @Test
    public void readExcelTest2() throws IOException {
        FileInputStream fis = new FileInputStream( "src/test/java/resourses/Capitals (2).xlsx");
        //1. satir 1. sutundaki bilgiyi yazdiriniz
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0).toString());
    }

    @Test
    public void readExcelTest3() throws IOException {
        /*
    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın

    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    Kullanılan satır sayısın bulun
    Ülke-Başkent şeklinde verileri yazdırın

    */
      FileInputStream fis = new FileInputStream("src/test/java/resourses/Capitals (2).xlsx") ;
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1).toString());

       // 3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
       String satir3sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(satir3sutun1);
        Assert.assertEquals("France",satir3sutun1);

        //KUllanilan satir sayisini bulun
        System.out.println("Son satir sayisi : "+workbook.getSheet("Sheet1").getLastRowNum());
        //Excel tablosundaki son satır sayısını getSheet("Sheet1") yani sayfayı belirledikten sonra getLastRowNum()
        //methodu ile alabiliriz
        System.out.println("Son satir sayisi : "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //Excel tablosunda kullanilan satir sayisini getPhysicalNumberOfRows() methodu ile alabiliriz

        System.out.println("son Sutun sayisi : "+workbook.getSheet("Sheet1").getRow(0).getLastCellNum());
        System.out.println("Kullanilan sutun sayisi : "+workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells());

        //Ülke-Başkent şeklinde verileri yazdırın
        Map<String,String> ulkeVeBaskent = new HashMap<>();
        for (int index = 1; index < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); index++) {
            String elke = workbook.getSheet("Sheet1").getRow(index).getCell(0).toString();
            String baskent = workbook.getSheet("Sheet1").getRow(index).getCell(1).toString();
            ulkeVeBaskent.put(elke,baskent+"\n");
        }
        System.out.println("ulkeVeBaskent = " + ulkeVeBaskent);

    }

    @Test
    public void readExcelTest4() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resourses/Capitals (2).xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }
    }
}
