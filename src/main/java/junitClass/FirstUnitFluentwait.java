package main.java.junitClass;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class FirstUnitFluentwait {
   static WebDriver driver;
    static String baseUrl;
    @BeforeAll
    public  static void setUp(){
        baseUrl = "https://www.bankofamerica.com/";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @AfterAll
    public static void  tearDown() throws IOException {
        driver.quit();
        System.out.println("@AfterAll-executed once after all test methods in this class");
    }
    @BeforeEach
    public  void init(){

        System.out.println("@BeforeEach-executed once before all test methods in this class");
    }
    @AfterEach
    public void done(){

        System.out.println("AfterEach-executed once after all test methods in this class");
    }
    @Test
    public  void test1(){
        WebElement khanAcademy = driver.findElement(By.xpath("//a[@id='EFF3SX93']"));
        khanAcademy.click();
        System.out.println("@Test1-executed test");
    }
    @Test
    public  void test2()  {

        System.out.println("@Test2-executed test");
    }
    @Test
    public  void test3(){

        System.out.println("@Test3-executed test");
    }
}
