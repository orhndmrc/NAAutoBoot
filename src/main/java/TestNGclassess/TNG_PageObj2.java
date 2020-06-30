package main.java.TestNGclassess;

import main.java.pageObjects.ButtonsPage;
import main.java.pageObjects.JQueryHPage;
import main.java.pageObjects.TabsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TNG_PageObj2 {
    WebDriver driver;
    String baseUrl;
    ButtonsPage bPage;
    JQueryHPage jPage;
    TabsPage tPage;
    @BeforeClass
    public void setup() {
        baseUrl = "https://jqueryui.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
        bPage = new ButtonsPage(driver);
        jPage = new JQueryHPage(driver);
        tPage = new TabsPage(driver);
        driver.manage().window().maximize();
        jPage.clicks("tabs");
        jPage.switchToFrame();
    }

    @AfterClass
    public void quitter() {
        driver.quit();
    }
    @Test
    public void testButtonsPage() {

        Assert.assertEquals(driver.getCurrentUrl(), "https://jqueryui.com/tabs/");
    }
    @Test
    public void clickTabs(){//example of accessing page objects outside of the class

        Assert.assertEquals(TabsPage.allTabs.size(),3);
        for(WebElement eachTab : TabsPage.allTabs){
            System.out.println("tab name: "+eachTab.getText() );
            eachTab.click();
        }
    }
}
