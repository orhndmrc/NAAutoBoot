package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_driver {
    public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
    }
}
