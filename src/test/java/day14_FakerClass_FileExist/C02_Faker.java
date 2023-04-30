package day14_FakerClass_FileExist;
import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_Faker {
    @Test
    public void faker() {
        //1. Faker objesi oluştururuz
        Faker faker = new Faker();
        //YADA Faker.instance() static methodu ile obje olusturmadan da kullanabiliriz. Faker faker = Faker.instance();
        //Faker.instance();


        //Firstname yazdıralım
        System.out.println("Fake firstname : "+faker.name().firstName());
        System.out.println(Faker.instance().name().firstName()); //boylede yazdirilabilir

        //Lastname yazdıralım
        System.out.println(faker.name().lastName());

        //Kullanıcı adi yazdıralım
        System.out.println(faker.name().username());

        //Meslek ismi yazdıralım
        System.out.println(faker.name().title());
        System.out.println(faker.job().position());

        //Şehir ismi yazdıralım
        System.out.println(faker.address().city());

        //Ulke ismi yazdıralım
        System.out.println(faker.address().country());

        //adress yazdıralım
        System.out.println(faker.address().fullAddress());

        //telefon numarası
        System.out.println(faker.phoneNumber().cellPhone());

        //zipcode numarası
        System.out.println(Faker.instance().address().countryCode());
        System.out.println(faker.address().zipCode());

        //Rastgele 15 haneli bir numara
        System.out.println(faker.number().digits(15));
    }
}
