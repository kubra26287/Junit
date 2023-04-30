package day07_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_Before_After {
    @Before
    public void setUp() throws Exception {
        System.out.println("Befor Her Test methodu oncesi bir kez calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After Her Test methodu sonrasi bir kez calisir");
    }


    @Test
    public void Test01() {
        System.out.println("ilk Test");
    }

    @Test
    public void Test02() {
        System.out.println("Ikinci Test");
    }
}
