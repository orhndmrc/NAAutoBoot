package main.java.junitClass;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstUnit {
   static WebDriver driver;
    static String baseUrl;
    @BeforeAll
    public  static void setUp(){
        baseUrl = "https://letskodeit.teachable.com/";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
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
    public  void test1(){
        WebElement logo = driver.findElement(By.cssSelector("a.navbar-brand.header-logo"));
        logo.click();
        System.out.println("@Test1-executed test");
    }
    @Test
    public  void test2() throws InterruptedException {
        Thread.sleep(5000L);
        WebElement logo = driver.findElement(By.cssSelector("a.navbar-brand.header-logo"));
        logo.click();
        System.out.println("@Test2-executed test");
    }
    @Test
    public  void test3(){
        WebElement logo = driver.findElement(By.cssSelector("a.navbar-brand.header-logo"));
        logo.click();
        System.out.println("@Test3-executed test");
    }
}
