package main.java.junitClass;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstUnitMultiSelectDrop {
   static WebDriver driver;
    static String baseUrl;
    @BeforeAll
    public  static void setUp(){
        baseUrl = "https://letskodeit.teachable.com/p/practice";
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
    public  void multiSelectEach() throws InterruptedException {

        WebElement multiEle = driver.findElement(By.name("multiple-select-example"));
        Select sel = new Select(multiEle);
        sel.selectByValue("orange");
        Thread.sleep(2000L);
        sel.selectByVisibleText("Apple");
        Thread.sleep(2000L);
        sel.selectByIndex(2);
        Thread.sleep(5000L);

        System.out.println("@Test1-executed test");
    }
    @Test
    public  void multideSelectEach() throws InterruptedException {

        WebElement multiEle = driver.findElement(By.name("multiple-select-example"));
        Select sel = new Select(multiEle);

        sel.deselectByValue("orange");
        Thread.sleep(2000L);
        sel.deselectByVisibleText("Apple");
        Thread.sleep(2000L);
        sel.deselectByIndex(2);
        Thread.sleep(5000L);

        System.out.println("@Test2-executed test");
    }



    }


