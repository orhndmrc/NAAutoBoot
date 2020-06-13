package main.java.TestNGclassess;


import main.java.Edge_Driver;
import main.java.junitClass.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TNG_Parameter  {
    //Tests are in alphaphetical order.
    static WebDriver driver;
    static String baseUrl;
    static Actions action; // create an object of type Actions class

    @Parameters({"browser","platform"})

    @BeforeClass//similar to @BeforeAll in junit
    public  void setUp(String browser, String platform) {
        System.out.println("Browser name is: "+browser);
        System.out.println("Browser name is: "+platform);
        baseUrl = "https://jqueryui.com/";
        setBrowser(browser);//we use it to open drivers based on parameter names.We call the method which we created below in setBrowser method.
        action = new Actions(driver); // initializing the actions class object by passing driver object to Actions class constructor
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    private void setBrowser(String browser){
        switch(browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.firefox.driver", "C:\\Users\\demir\\NAAutoBoot\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\demir\\NAAutoBoot\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }
    }

    @AfterClass//similar to @AfterAll in junit
    public static void tearDown() throws IOException {
        RandomString rString = new RandomString();
        String fileNm = System.getProperty("user.dir") + "\\src\\snippets\\" + rString.genRandom(5) + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileNm));
        driver.quit();
        System.out.println("@AfterAll - closed browser session");

    }
    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(5000);
        WebElement hovSupport = driver.findElement(By.xpath("//section//a[text()='Support']"));
        WebElement forums = driver.findElement(By.xpath("//a[text()='Forums']"));
        action.moveToElement(hovSupport).perform(); // to hover on a given WebElement
        Thread.sleep(5000);
        action.moveToElement(forums).click().perform(); // to click on a given WebElement
        // action.click(forums).perform();// to click on a given WebElement

        Thread.sleep(5000);
        String currUrl = driver.getCurrentUrl();
        Assert.assertEquals(currUrl, "https://forum.jquery.com/","url mismatch!!!");
        System.out.println("@Test1 - currUrl is:"+currUrl);
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
        WebElement getStarted = driver.findElement(By.xpath("//a[text()='Getting Started']"));
        getStarted.click();
        System.out.println("@Test2 method");
        Assert.assertTrue(driver.getCurrentUrl().contains("getting-started"));
    }

    @Test()
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Class1 - @Test3 method");
    }
}