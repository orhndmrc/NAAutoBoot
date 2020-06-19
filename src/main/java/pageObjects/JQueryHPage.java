package main.java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JQueryHPage {
    private WebDriver hpageDriver;
    public JQueryHPage(WebDriver driver){
        hpageDriver =driver;
        PageFactory.initElements(hpageDriver,this);
    }
    @FindBy(linkText="Button")
    WebElement buttons;

    @FindBy(linkText="Menu")
    WebElement menu;

    @FindBy(linkText="Checkboxradio")
    WebElement checkboxradio;

    @FindBy(linkText="Selectmenu")
    WebElement selectmenu;

    @FindBy(linkText="Tabs")
    WebElement tabs;

    public void clicks(String buttonNm){
        switch(buttonNm){
            case "buttons":
                buttons.click();
            case "menu":
                menu.click();
            case "selectMenu":
                selectmenu.click();
            case "tabs":
                tabs.click();
        }
    }
}
