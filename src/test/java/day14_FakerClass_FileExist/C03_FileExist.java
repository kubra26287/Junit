package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void fileExist() {
        //masa ustunde bir dosya olustuun ve bu dosyanin varligini dogrulayin
        System.out.println(System.getProperty("user.dir"));
        ///Users/fatihyilmaz/IdeaProjects/B129SeleniumMavenJunit
        //projemizin icinde bulundugu yolu verir
        System.out.println(System.getProperty("user.home"));
        ///Users/fatihyilmaz
        //localimizdeki kullanici yolunu verir
        //String dosyayolu ="/Users/fatihyilmaz/Desktop"; bu masa ustunde actigimiz dosyanin yolu asagida bunun sadece ortak olan Desktop kismini aliyoruz
        //Dosya yolunu nasil aliriz: dosya uzerinde sag tik bilgi ver tikla yer: basligi iceren aciklamayi kopyala

        String farkliKisim =System.getProperty("user.home");//her kullanicinin ana yolu farkili oldugu icin farkli kisim dedik
        String ortakKisim ="/Desktop"; //ayni yerde yani masa ustunde olusturuldugu icin ortak kisim dedik ve sadece ortak olan \desktop kismini aldik
        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); //File exist methodu ile dosyanin varligini dogruladik


    }
}
