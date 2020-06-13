package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge_Driver {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver","C:\\Users\\demir\\NAAutoBoot\\msedgedriver.exe");
        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://amazon.com");
    }
}
