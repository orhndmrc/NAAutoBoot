package main.java.junitClass;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FirstUnitActions {
   static WebDriver driver;
    static String baseUrl;
    static Actions action;
    @BeforeAll
    public  static void setUp(){
        baseUrl = "https://jqueryui.com/";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
         action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }
    @AfterAll
    public static void  tearDown(){
        driver.quit();
        System.out.println("@AfterAll-executed once after all test methods in this class");
    }

    @Test
    public  void test1() throws InterruptedException {
WebElement hovSupport = driver.findElement(By.xpath("//section//a[text()='Support']"));
        WebElement forums = driver.findElement(By.xpath("//a[text()='Forums']"));
action.moveToElement(hovSupport).perform();
        Thread.sleep(5000L);
action.moveToElement(forums).click().perform();
        Thread.sleep(5000L);
        String currUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://forum.jquery.com/",currUrl,"url mismatch. Actual url is: "+currUrl);
        System.out.println("@Test1-executed test");
    }
    @Test
    public  void test2() throws InterruptedException {
        driver.navigate().to("https://forum.jquery.com/droppable/");
        Thread.sleep(5000L);
        //action.moveToElement(anchor).doubleClick().perform();// to double click
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        action.dragAndDrop(draggable,droppable).build().perform();
        Thread.sleep(5000L);
        String actualTxt = droppable.findElement(By.tagName("p")).getText();
        Assertions.assertEquals("Droppd!",actualTxt);
        System.out.println("@Test2-executed test");
    }
}
