package main.java.junitClass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClearTest {
    String baseURL;
    WebDriver driver;
    @BeforeEach
    void init() {
        baseURL = "https://learn.letskodeit.com/p/practice";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(baseURL);
    System.out.println("Navigated to given url");
    }
    @Test
    void test1() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys("my name");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).clear();
        Thread.sleep(5000);
        System.out.println("@Test - entered my name inside edit field and cleared");
    }
    @AfterEach
    void done() {
        driver.quit();
        System.out.println("Closed browser session");
    }
}
