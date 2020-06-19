package main.java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TabsPage {
    private WebDriver tabsDriver;
    public TabsPage(WebDriver driver){
        tabsDriver=driver;
        PageFactory.initElements(tabsDriver,this);
    }
}
