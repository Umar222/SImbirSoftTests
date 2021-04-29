package ru.Ilnur.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailAuthPage {

    @FindBy(xpath = "//input[@id = \"passp-field-login\"]")
    private WebElement loginField;
    @FindBy(xpath = "//input[@id = \"passp-field-passwd\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type = \"submit\"]")
    private WebElement submit;

    public WebDriver driver;

    public MailAuthPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Авторизация на почте")
    public void authMail(String mail, String password) {
        loginField.sendKeys(mail);
        loginField.submit();
        passwordField.sendKeys(password);
        submit.click();
    }
}
