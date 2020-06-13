package main.java.junitClass;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
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
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\demir\\NAAutoBoot\\src\\snippets\\screenshot1.png"));
        driver.quit();

        System.out.println("@AfterAll-executed once after all test methods in this class");
    }

    @Test
    public  void test1() throws Exception{
      String currHandle= driver.getWindowHandle();
        System.out.println("@Test1-current window handle before clicking "+currHandle);
      driver.findElement(By.id("openwindow")).click();
      Thread.sleep(5000L);
       // currHandle= driver.getWindowHandle();
       // System.out.println("@Test1-current window handle after clicking "+currHandle);
       // Thread.sleep(5000L);
        Set<String> handles = driver.getWindowHandles();
        System.out.println("number of windows "+handles.size());
        for(String handle :handles) {
            System.out.println("handle is: " + handle);

            if (handles.equals(currHandle)) {
                System.out.println("handle is parent handle"+handle);
            } else {
                System.out.println("handle is child handle"+handle);
                driver.switchTo().window(handle);
               // driver.findElement(By.id("bmwradio")).click();//cant do this because now focus is in child window and radio is in parent window
            }
        }
    }

}
