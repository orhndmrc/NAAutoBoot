package Junit_Examples;

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
    static Actions action;
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'king')]")));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement target = driver.findElement(By.id("dropdown-class-example"));
       Select s = new Select(target);
       s.selectByValue("option1");

       action = new Actions(driver);
        Thread.sleep(5000);
       WebElement hover = driver.findElement(By.id("mousehover"));
      action.moveToElement(hover).build().perform();
      driver.findElement(By.xpath("//a[@href='#top']")).click();
      String Actualurl = driver.getCurrentUrl();
      String Expectedurl = "https://rahulshettyacademy.com/AutomationPractice/#top";
       Assert.assertEquals(Expectedurl,Actualurl,"fail");
        System.out.println(Actualurl);
        driver.get("https://jqueryui.com/droppable/");
        WebElement frame= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame("iframe.demo-frame");
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        action.dragAndDrop(drag,drop).build().perform();

    }
}