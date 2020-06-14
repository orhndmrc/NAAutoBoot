package main.java.TestNGclassess;


import main.java.junitClass.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TNG_Listeners {
    //Tests are in alphaphetical order.
    static WebDriver driver;
    static String baseUrl;
    static Actions action; // create an object of type Actions class


    @BeforeClass//similar to @BeforeAll in junit
    public  void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://jqueryui.com/";

        action = new Actions(driver); // initializing the actions class object by passing driver object to Actions class constructor
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @AfterMethod
    public void afterTest(ITestResult testResult){
        if(testResult.getStatus()==ITestResult.SUCCESS){
            System.out.println("Success!"+testResult.getName());
        }
        if(testResult.getStatus()==ITestResult.FAILURE){
            System.out.println("Failed!"+testResult.getName());
        }
    }
     @AfterClass
     public void tearDown(){
        driver.quit();
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
    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
        WebElement getStarted = driver.findElement(By.xpath("//a[text()='Getting Started']"));
        getStarted.click();
        System.out.println("@Test2 method");
        Assert.assertTrue(driver.getCurrentUrl().contains("getting-started"));
    }

    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Class1 - @Test3 method");
    }
}