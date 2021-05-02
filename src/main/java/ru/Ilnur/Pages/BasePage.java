package ru.Ilnur.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class BasePage {

    public static WebDriver driver;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        BasePage.driver = driver;
    }

    public static void switchNewPage(int pageNumber) {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(pageNumber));
    }
}
