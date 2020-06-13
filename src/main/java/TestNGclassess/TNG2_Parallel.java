package main.java.TestNGclassess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TNG2_Parallel {
    WebDriver driver;
    String baseUrl;
    Actions action;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        baseUrl = "https://jqueryui.com/";
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        action = new Actions(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }



    @Parameters({"LinkNm"})
    @Test
    public void test1(String LinkNm) {
        action.moveToElement(driver.findElement(By.xpath("//a[text()='Contribute']"))).build().perform();
        WebElement cla = driver.findElement(By.xpath("//a[text()='" + LinkNm + "']"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cla)).click();
    }

    @Parameters({"header", "urlLink", "LinkNm"})
    @Test(dependsOnMethods = {"test1"})
    public void test2(String header, String urlLink, String LinkNm) {
        String actualHead = "";

        if (LinkNm.contains("CLI")) {
            actualHead = driver.findElement(By.xpath("//img[contains(@class,'stnd')]")).getAttribute("alt");
        }else {
            actualHead = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
        }
            String curUrl = driver.getCurrentUrl();
            Assert.assertEquals(curUrl, "https://openjsf.org/");


        }
    }

