package Junit_Examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Example_ {
    static WebDriver driver;
     static Actions action;
   @BeforeAll
           public static void setUp() {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
      driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'king')]")));
       driver.get("https://rahulshettyacademy.com/AutomationPractice/");
   }
   @Test
           public void test1() throws Exception{
       WebElement target = driver.findElement(By.id("dropdown-class-example"));
       Select s = new Select(target);
       s.selectByValue("option1");

       action = new Actions(driver);
       WebElement hover = driver.findElement(By.id("mousehover"));
       action.moveToElement(hover).build().perform();
       Thread.sleep(5000);
       driver.findElement(By.xpath("//a[@href='#top']")).click();
       String Actualurl = driver.getCurrentUrl();
       String Expectedurl = "https://rahulshettyacademy.com/AutomationPractice/#top";
       Assert.assertEquals(Expectedurl, Actualurl, "fail");
       System.out.println(Actualurl);
       driver.get("https://jqueryui.com/droppable/");
       WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
       driver.switchTo().frame(frame);
       WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
       WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
       action.dragAndDrop(drag, drop).build().perform();
   }
@AfterAll
    public static void tearDown(){
       driver.quit();
}
    }
