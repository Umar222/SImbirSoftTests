package ru.Ilnur.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mailPage {

    public WebDriver driver;

    public mailPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text() = \"Войти\"]")
    private WebElement openMailButton;


    public void openMail(){
        openMailButton.click();
    }

}
