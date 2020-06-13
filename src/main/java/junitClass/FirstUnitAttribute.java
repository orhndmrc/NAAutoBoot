package main.java.junitClass;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstUnitAttribute {
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
       //driver.navigate().refresh();
        System.out.println("@BeforeEach-executed once before all test methods in this class");
    }
    @AfterEach
    public void done(){
        //driver.navigate().refresh();
        System.out.println("AfterEach-executed once after all test methods in this class");
    }

    @Test
    public  void table() throws InterruptedException {
  WebElement openTab = driver.findElement(By.xpath("//legend[text()='Switch Tab Example']/following-sibling::a"));
        System.out.println("class name is "+openTab.getAttribute("class"));
        System.out.println("id name is "+openTab.getAttribute("id"));
        System.out.println("href value is "+openTab.getAttribute("href"));
        System.out.println("target value is "+openTab.getAttribute("target"));


        System.out.println("@Test1-executed test");
    }


    }


