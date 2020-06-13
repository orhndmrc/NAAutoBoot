package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chase {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.chase.com/");
        driver.findElement(By.id("userId-text-input-field")).click();
        driver.findElement(By.id("userId-text-input-field")).sendKeys("orhan");
        driver.findElement(By.cssSelector("div[id='password-text']>input[class='jpui input logon-xs-toggle']")).click();
        driver.findElement(By.cssSelector("div[id='password-text']>input[class='jpui input logon-xs-toggle']")).sendKeys("demirci");
        driver.findElement(By.xpath("//input[contains(@aria-label, 'Remember me')]")).click();
        driver.findElement(By.xpath("//button[starts-with(@id, 'signin') and @type='submit']")).click();

    }
}
