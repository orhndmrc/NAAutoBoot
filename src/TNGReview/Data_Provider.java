package TNGReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Data_Provider  {

    WebDriver driver;
    String url;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\eclipse\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        url = "https://opensource-demo.orangehrmlive.com/";
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();

    }
    @BeforeMethod
    public void login(){

        //enter username and password
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.xpath(" //input[@name='txtPassword']")).sendKeys("admin123");

        //click login button
        driver.findElement(By.cssSelector(".button")).click();
    }
    @AfterMethod
    public void logout(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();
    }
    @Test(groups="smoke", dataProvider = "getData")
    public void addMultipleEmployee (String name, String lastName) throws Exception{

        //navigate to add employee page
       driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b")).click();
       Thread.sleep(10000);
        driver.findElement(By.xpath("//a[contains(@href,'pim/addEmployee')]")).click();

        //add employee name and last name
        driver.findElement(By.id("firstName")).sendKeys(name);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        String employeeId = driver.findElement(By.id("employeeId")).getAttribute("value");
        driver.findElement(By.id("btnSave")).click();
        String actualEmpId = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
        Assert.assertEquals(actualEmpId,employeeId);
       

    }
    @DataProvider//provide argument for @Test method
    public Object[][] getData(){
    Object [][] data = {
        {"John","Smith"},{"Micheal","Knight"},{"Hakan","Sukur"}
};
return  data;
    }
}
