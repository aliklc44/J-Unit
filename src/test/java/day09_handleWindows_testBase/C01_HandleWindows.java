package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindows {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
         driver.quit();
    }
    @Test
    public void test01() {
        //1-amazon anasayfaya gidin

        driver.get("https://www.amazon.com");
        String ilkSayfaHnadleDegeri = driver.getWindowHandle();

        //2-nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);


        /*
        CDwindow-AF4F91AFEC139E5EE1E1180137D415BE
        bu kod acilan sayfanin unique hash kodudur
        Selenium sayfalar arasi geciste bu window handle degerini kullanir

        eger sayfalar arasinda driver ı gezdiriyorsak ve herhangi bir
        sayfadan su an bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-AF4F91AFEC139E5EE1E1180137D415BE");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz.
         */

        // 3- ilk urunun resmini farkli bir tab olarak acin
        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
       driver.switchTo().newWindow(WindowType.TAB);
       /*
       bu komutu kullandigimizda driver otomatik olarak new tab a gecer
       yeni tab da gorevi gerceklestirmek icin bastan almaliyiz
        */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        // 4- yeni tabda acilan urunun title ni yazdirin
        WebElement urunTitleElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());
        System.out.println(driver.getCurrentUrl());

         // 5- ilk sayfaya gecip url i yazdiralim
        driver.switchTo().window(ilkSayfaHnadleDegeri);
        System.out.println(driver.getCurrentUrl());


    }
}
