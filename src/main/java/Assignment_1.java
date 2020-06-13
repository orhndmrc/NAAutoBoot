package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1 {

        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://letskodeit.teachable.com/p/practice");
            driver.findElement(By.xpath("//td[text()='JavaScript Programming Language']/following-sibling::td")).click();
            driver.findElement(By.xpath("//td[text()='35']/preceding-sibling::td[1]")).click();

        }
}
