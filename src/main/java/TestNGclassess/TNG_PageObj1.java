package main.java.TestNGclassess;

import main.java.pageObjects.ButtonsPage;
import main.java.pageObjects.JQueryHPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TNG_PageObj1 {
    WebDriver driver;
    String baseUrl;
    ButtonsPage bPage;
    JQueryHPage jPage;
    @BeforeClass
    public void setup() {
        baseUrl = "https://jqueryui.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
        bPage = new ButtonsPage(driver);
        jPage = new JQueryHPage(driver);
        driver.manage().window().maximize();
        jPage.clicks("buttons");
        bPage.switchToFrame();
    }

    @AfterClass
    public void quitter() {
        driver.quit();
    }
    @Test
    public void testButtonsPage() {

        Assert.assertEquals(driver.getCurrentUrl(), "https://jqueryui.com/button/");
    }
    @Test
    public void clickButtons(){
     bPage.buttonEleClick();
        Assert.assertEquals(bPage.listSize(),2);
    }
}
