package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstUnit_Navigation {
    static WebDriver driver;
    static String baseUrl;
    static String currentUrl;
    @BeforeAll
    public  static void setUp(){
        baseUrl = "https://letskodeit.teachable.com/";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
        currentUrl = driver.getCurrentUrl();
        System.out.println("@BeforeAll - Current url : "+currentUrl);
    }
    @AfterAll
    public static void  tearDown(){
        driver.quit();
        System.out.println("@AfterAll-executed once after all test methods in this class");
    }
    @BeforeEach
    public  void init(){
        driver.navigate().refresh();
        System.out.println("@BeforeEach-executed once before all test methods in this class");
    }
    @AfterEach
    public void done(){
        driver.navigate().refresh();
        System.out.println("AfterEach-executed once after all test methods in this class");
    }
    @Test
    public  void browser_navigation() throws Exception{
        currentUrl = driver.getCurrentUrl();
        System.out.println("@browserNavigation - Current url : "+currentUrl);
        driver.findElement(By.xpath("//a[contains(text(),'Practice')]")).click();
        Thread.sleep(5000L);
        System.out.println("@Test1-clicking on practice page");
        currentUrl = driver.getCurrentUrl();
        System.out.println("@browserNavigation - Current url : "+currentUrl);
       driver.navigate().back();
       Thread.sleep(5000L);
        System.out.println("@Test1-back to home page");
        currentUrl = driver.getCurrentUrl();
        System.out.println("@browserNavigation - Current url : "+currentUrl);
        driver.navigate().forward();
        System.out.println("@Test1-from home page to practice page");
        currentUrl = driver.getCurrentUrl();
        System.out.println("@browserNavigation - Current url : "+currentUrl);
        Thread.sleep(5000L);
    }

}

