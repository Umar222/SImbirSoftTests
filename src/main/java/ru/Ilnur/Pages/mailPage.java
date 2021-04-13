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

    @FindBy(xpath = "//input[@id = \"passp-field-login\"]")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id = \"passp-field-passwd\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type = \"submit\"]")
    private WebElement submit;

    public void clickEnter(){
        openMailButton.click();
    }


    public void openMail(String mail, String password){
        loginField.sendKeys(mail);
        loginField.submit();
        passwordField.sendKeys(password);
        submit.click();

    }

}
