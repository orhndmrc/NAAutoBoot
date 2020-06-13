package main.java.junitClass;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Random;

public class FirstUnitScreenShot {
    static WebDriver driver;
    static String baseUrl;
   /* public class RandomString {
        public String genRandom(int length) {
            int leftLimit = 97; // letter a
            int rightLimit = 122; // letter z
            Random random = new Random();

            return random.ints(leftLimit, rightLimit + 1)
                    .limit(5)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
    }*/
    @BeforeAll
    public static void setUp() {
        baseUrl = "https://www.amazon.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-executed once before all test methods in this class");
    }

    @AfterAll
    public static void tearDown() throws Exception{
        RandomString rString = new RandomString();
        String fileNm = System.getProperty("user.dir") + "\\src\\snippets\\" + rString.genRandom(5) + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileNm));
        driver.quit();
        System.out.println("@AfterAll-executed once after all test methods in this class");
    }

    @Test
    public void test1() throws Exception {
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("stun gun");
        driver.findElement(By.xpath("//span[@id='nav-search-submit-text']//following-sibling::input")).click();
    }
}