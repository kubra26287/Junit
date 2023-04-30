package day07_Junit;

import org.junit.*;

public class C04_BeforeClass_AfterClass {
    // @Beforclass ve @Afterclass sadece static methodlar ile calisir


    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Class'taki Tüm testlerden once 1 kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'taki Tum testlerden sonra bir kez calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("her test methodundan once  calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("her test methodundan sonra  calisir");
    }

    @Test
    public void Test01() {
        System.out.println("ilk Test");
    }

    @Test
    public void Test02() {
        System.out.println("ikinci Test");
    }
}
