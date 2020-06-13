import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println(title);
        if(title.equalsIgnoreCase("Google")){
            System.out.println("Expected and actual title match");
        }
        else{
            System.out.println("Expected and actual title match does not match");
        }
        driver.quit();
    }
}
