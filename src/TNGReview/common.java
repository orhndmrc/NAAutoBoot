package TNGReview;

import main.java.junitClass.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class common  {
    public void screenShot() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\demir\\NAAutoBoot\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        RandomString rString = new RandomString();
        String fileNm = System.getProperty("user.dir") + "\\src\\snippets\\" + rString.genRandom(5) + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileNm));
    }
}
