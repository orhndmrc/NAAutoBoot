package main.java.junitClass;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstUnitSelectDrop {
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
    public  void dropSelectEach() throws InterruptedException {

        WebElement dropEle = driver.findElement(By.id("carselect"));
        Select sel = new Select(dropEle);
        sel.selectByValue("honda");
        Thread.sleep(2000L);
        sel.selectByIndex(1);
        Thread.sleep(5000L);

        System.out.println("@Test1-executed test");
    }
    @Test
    public  void dropSelectAll() throws InterruptedException {

        WebElement dropEle = driver.findElement(By.id("carselect"));
        Select sel = new Select(dropEle);
        List<WebElement> opts = sel.getOptions();
        for(WebElement ele:opts){
            System.out.println("Options is "+ele.getText());
            sel.selectByVisibleText(ele.getText());
            Thread.sleep(5000L);
        }


        System.out.println("@Test2-executed test");
    }

}
