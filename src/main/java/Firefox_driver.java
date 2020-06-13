package main.java;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox_driver {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\demir\\NAAutoBoot\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");
    }
}