package main.java.junitClass;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class FirstUnitHandle {
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
    public static void  tearDown() throws IOException {
        //taking a screenshot
        TakesScreenshot screenShot =(TakesScreenshot) driver;

        File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\demir\\NAAutoBoot\\src\\snippets\\screenshot1.png"));
        driver.quit();

        System.out.println("@AfterAll-executed once after all test methods in this class");
    }

    @Test
    public  void test1() throws Exception{
        String parentHandle= driver.getWindowHandle();
        System.out.println("@Test1-current window handle before clicking "+parentHandle);
      driver.findElement(By.id("openwindow")).click();//opens a new window
      Thread.sleep(5000L);
       // currHandle= driver.getWindowHandle();
       // System.out.println("@Test1-current window handle after clicking "+currHandle);
       // Thread.sleep(5000L);
        Set<String> handles = driver.getWindowHandles();
        System.out.println("number of windows "+handles.size());
        Iterator<String> itr = handles.iterator();
        while(itr.hasNext()){
            String childHandle = itr.next();
            System.out.println(childHandle);
            if(!parentHandle.equals(childHandle)){
                driver.switchTo().window(childHandle);
                driver.findElement(By.xpath("//div[@class='course-listing-title' and contains(text(),'Selenium WebDriver With Java')]")).click();
            }
        }




//        for(String handle :handles) {
//            System.out.println("handle is: " + handle);
//
//            if (!handles.equals(currHandle)) {
//                System.out.println("handle is parent handle"+handle);
//                driver.switchTo().window(handle);
//                System.out.println("handle is child handle"+handle);
//                driver.findElement(By.xpath("//div[@class='course-listing-title' and contains(text(),'Selenium WebDriver With Java')]")).click();
//                driver.close();
//                break;
//            }
        }
    }


