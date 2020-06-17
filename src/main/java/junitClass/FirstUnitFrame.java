package main.java.junitClass;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class FirstUnitFrame {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://jqueryui.com/droppable/");
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
            Actions a = new Actions(driver);
            a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
            driver.switchTo().defaultContent();


        }
    }