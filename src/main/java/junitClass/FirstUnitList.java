package main.java.junitClass;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstUnitList {
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

        List<WebElement> listHead = driver.findElements(By.xpath("//table[@class='table-display']//th"));
        List<WebElement> listauthor = driver.findElements(By.xpath("//table[@class='table-display']//td[1]"));
        List<WebElement> listCourse = driver.findElements(By.xpath("//table[@class='table-display']//td[2]"));
        List<WebElement> listPrice = driver.findElements(By.xpath("//table[@class='table-display']//td[3]"));
        for (int i = 0; i <listHead.size() ; i++) {
            System.out.println("Author is : "+listauthor.get(i).getText()+" \n"
                    +"Course is : "+listCourse.get(i).getText()+"\n "
                    +"Price is : "+listPrice.get(i).getText());
            System.out.println("******************************");

        }
//        for(WebElement hele : listHead){
//            System.out.println("Table Header is "+hele.getText());
//        }
//        for(WebElement aele : listauthor){
//            System.out.println("Author is "+aele.getText());
//        }
//        for(WebElement cele : listCourse){
//            System.out.println("Course is "+cele.getText());
//        }
//
//        for(WebElement pele : listPrice){
//            System.out.println("Price is "+pele.getText());
//        }


        System.out.println("@Test1-executed test");
    }


    }


