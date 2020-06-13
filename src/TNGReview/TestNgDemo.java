package TNGReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNgDemo {
    WebDriver driver;
    String url;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\eclipse\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        url = "https://opensource-demo.orangehrmlive.com/";
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
    @Test (groups={"regression","login"})//(enabled=false)//(priority = 1)
    public void titleValidation() {
        String expectedTitle ="OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle,"Title miscmatch");
    }
    @Test(groups="smoke")//(priority = 2)
    public void login() {
        //enter username and password
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.xpath(" //input[@name='txtPassword']")).sendKeys("admin123");

        //click login button
        driver.findElement(By.cssSelector(".button")).click();

        WebElement logo = driver.findElement(By.xpath("//div[@id='branding']//a//img"));
        Assert.assertTrue(logo.isDisplayed(),"Login Fail");

    }
    @Test(dependsOnMethods = "titleValidation")
    public void test3(){
        System.out.println("Method 3");
    }
}
