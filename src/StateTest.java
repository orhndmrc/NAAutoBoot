import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StateTest {
    WebDriver driver;
    String baseUrl;
    @BeforeEach
    public void setUp() throws Exception {
        baseUrl = "https://www.google.com/";
        System.setProperty("webdriver.edge.driver","C:\\Users\\demir\\NAAutoBoot\\msedgedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
                }
    @Test
    public void test() throws InterruptedException {
        WebElement webElement = driver.findElement(By.name("iflsig"));
        System.out.println("Element state isEnabled: " + webElement.isEnabled());
        Thread.sleep(5000);       }
    @AfterEach
    void done() {
        driver.quit();
        System.out.println("Closed browser session");
    }
    }
