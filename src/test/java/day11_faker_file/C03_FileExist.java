package day11_faker_file;

import org.junit.Test;

public class C03_FileExist {

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir"));
        // icinde oldugumuz projenin dosya yolunu (path) verir

        System.out.println(System.getProperty("user.home"));
        // C:\Users\Casper bilgisayarin bana ozel kismini verdi
        String dosyaYolu = System.getProperty("user.home")+"C:\\Users\\Casper\\Desktop\\text.txt";
        System.out.println(dosyaYolu);


    }
}
