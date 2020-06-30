package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage {

//    WebElement buttonEle = driver.findElement(By.xpath("(//button[text()='A button element'])[position()=1]"));
//    WebElement submit = driver.findElement(By.xpath("(//input[@value='A submit button'])[position()=1]"));
//    WebElement anchor = driver.findElement(By.xpath("(//a[text()='An anchor'])[position()=1]"));
     private WebDriver buttonDriver;
public ButtonsPage(WebDriver driver){
    buttonDriver=driver;
    PageFactory.initElements(buttonDriver,this);
}
    @FindBy( how = How.XPATH, using = "(//button[text()='A button element'])[position()=1]")
    private WebElement buttonElem;

    @FindBy(xpath="(//input[@value='A submit button'])[position()=1]")
    private WebElement submit;

    @FindBy(xpath="(//a[text()='An anchor'])[position()=1]")
    private WebElement anchor;

    @FindBy(how = How.LINK_TEXT, using = "view source")
    private WebElement viewSource;



    @FindBy(how = How.ID, using="content")
    private WebElement content;

    //finding a list of elements
    @FindBys(@FindBy(xpath="//button[text()='A button element']"))
    private List<WebElement> listofButtons;

    @FindBys(@FindBy(xpath="//input[@value='A submit button']"))
    private List<WebElement> listofSubmit;

public void buttonEleClick(){
    buttonElem.click();
}

    //method to interact with the element
    public void submitClick() {
        submit.click();
    }

    //method to interact with the element
    public int listSize () {
        return listofSubmit.size();
    }
}
