package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BankofAmerica {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://bankofamerica.com");
        driver.findElement(By.xpath("//*[text()='Businesses & Institutions']")).click();
        WebDriverWait w = new WebDriverWait(driver,5);


    }
}
