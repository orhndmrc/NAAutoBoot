package main.java.junitClass;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstUnitState {
    static WebDriver driver;
    static String baseUrl;
    @BeforeAll
    public  static void setUp(){
        baseUrl = "https://www.expedia.com/";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @AfterAll
    public static void  tearDown(){
        //driver.quit();
        System.out.println("@AfterAll-executed once after all test methods in this class");
    }
    @BeforeEach
    public  void init(){
        driver.findElement(By.cssSelector("#hotel-checkin-hp-hotel")).click();
        System.out.println("@BeforeEach-clicking on check-in");
    }
    @AfterEach
    public void done(){


        System.out.println("AfterEach-executed once after all test methods in this class");
    }
    @Test
    public  void test1() throws Exception{
        Thread.sleep(5000L);
        WebElement datefield = driver.findElement(By.xpath("//button[(@data-day='31' and @data-month='4') or (starts-with(@aria-label, 'May 31'))]"));
        datefield.click();
        System.out.println("@Test1-clicking on disabled date");
    }
    @Test
    public  void test2() throws InterruptedException {
        Thread.sleep(5000L);
        WebElement datefield = driver.findElement(By.xpath("//button[(@data-day='31' and @data-month='4') or (starts-with(@aria-label, 'May 31'))]"));
        datefield.click();
        System.out.println("@Test2-clicking on disabled date");
    }

}
