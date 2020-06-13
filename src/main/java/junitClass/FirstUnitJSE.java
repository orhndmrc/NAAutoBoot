package main.java.junitClass;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstUnitJSE {
   static WebDriver driver;
    static String baseUrl;
    static  JavascriptExecutor jse;

    @BeforeAll
    public  static void setUp() throws Exception{
        baseUrl = "https://www.bankofamerica.com/";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\geckodriver.exe");
        driver = new FirefoxDriver();
       // driver.manage().window().maximize();
        //driver.get(baseUrl);
        jse =(JavascriptExecutor) driver;
        jse.executeScript("window.location=arguments[0]",baseUrl);


        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @AfterAll
    public static void  tearDown(){
        driver.quit();
        System.out.println("@AfterAll-executed once after all test methods in this class");
    }

    @Test
    public  void test1() throws Exception{
        Thread.sleep(5000L);
        WebElement checking = driver.findElement(By.id("//a[@id='navChecking']"));
        jse.executeScript("arguments[0].click();",checking);

        System.out.println("@Test1-executed test");
    }
    @Test
    public  void test2() throws InterruptedException {
        WebElement onlineID = driver.findElement(By.xpath("//input[@aria-labelledby='labelForonlineId1']"));
        jse.executeScript("arguments[0].value'tester1'",onlineID);
        Thread.sleep(5000L);

        System.out.println("@Test2-executed test");
    }
    @Test
    public  void test3() throws Exception{
        Thread.sleep(5000L);
        jse.executeScript("window.scrollBy(0,1800)");//scroll down
        System.out.println("@Test3-executed test");
    }
}
