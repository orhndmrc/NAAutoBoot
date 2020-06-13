package main.java.junitClass;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class FirstUnitiFrame {
    static WebDriver driver;
    static String baseUrl;

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("@AfterAll-executed once after all test methods in this class");
    }

    @Test
    public void test1() throws Exception {

    }
}