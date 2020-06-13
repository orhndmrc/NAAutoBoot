package main.java.TestNGclassess;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TNG_Dependency extends TNG_Suite{
    //Tests are in alphaphetical order.
    static WebDriver driver;
    static String baseUrl;
    @BeforeClass//similar to @BeforeAll in junit
    public  static void setUp(){
        baseUrl = "https://www.bankofamerica.com/";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @AfterClass//similar to @AfterAll in junit
    public static void  tearDown() throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\demir\\NAAutoBoot\\src\\snippets\\screenshot1.png"));
        driver.quit();
        System.out.println("@AfterAll-executed once after all test methods in this class");
    }
    @BeforeMethod//similar to @BeforeEach in junit
    public void init(){
        System.out.println("@BeforeMethod method");
    }
    @AfterMethod//similar to @AfterEach in junit
    public void quit(){
        System.out.println("@AfterMethod method");
    }
    @Test(timeOut = 4000)
    public  void test1(){
        WebDriverWait w = new WebDriverWait(driver,5);
        WebElement khanAcademy = driver.findElement(By.xpath("//a[@id='EFF3SX93']"));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='EFF3SX93']")));
        khanAcademy.click();
        System.out.println("@Test1-executed test");
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("@test2 method");
    }
    @Test(enabled = false)//ignoring the test
    public void test3(){
        System.out.println("@test3 method");
    }


}
