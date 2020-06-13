package main.java.junitClass;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Expedia {
    static WebDriver driver;
    static String baseUrl;

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://www.expedia.com/Hotels";
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

    @BeforeEach
    public void init() {
        driver.navigate().refresh();
        System.out.println("@BeforeEach-executed once before all test methods in this class");
    }

    @AfterEach
    public void done() {
         driver.navigate().refresh();
        System.out.println("AfterEach-executed once after all test methods in this class");
    }

    @Test
    public void test1() throws Exception {
     driver.findElement(By.xpath("//div[@id='traveler-selector-hlp']//button[contains(@class,'t menu-arrow gcw-compone')]")).click();
        WebElement childDisplay = driver.findElement(By.xpath("//div[contains(@class, 'cols-nested children')]//span[text()='Child 1 age']"));
        WebElement ageDisplay = driver.findElement(By.xpath("//div[contains(@class, 'cols-nested children')]/label[1]/select"));
        WebElement minusDisplay = driver.findElement(By.xpath("//div[contains(@class,'children-wrapper')]//div[contains(@class,' gcw-step-input gcw-component-initialized')]//div[2]"));
        System.out.println(minusDisplay.isEnabled());
        System.out.println(childDisplay.isDisplayed());
        System.out.println(ageDisplay.isDisplayed());
        WebElement childrenIncrease = driver.findElement(By.xpath("//div[contains(@class,'children-wrapper')]//div[contains(@class,' gcw-step-input gcw-component-initialized')]//div[4]/button/span//*[local-name()='svg']"));
        for (int i = 0; i <2 ; i++) {
            Thread.sleep(5000);
            childrenIncrease .click();
            System.out.println(childDisplay.isDisplayed());
            System.out.println(ageDisplay.isDisplayed());
            System.out.println("@Test-executed test");
        }

    }
}