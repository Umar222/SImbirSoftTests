package ru.Ilnur.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class mailPage {

    public WebDriver driver;

    public mailPage(WebDriver driver) {
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

    @FindBy(xpath = "//a[@href=\"https://mail.yandex.ru/\"]")
    private WebElement mailButton;

    @FindBy(xpath = "//input[@placeholder=\"Поиск\"]")
    private WebElement searchField;

    @FindBy(xpath = "//span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_subject\"]")
    public List<WebElement> messageTheme;




    public void openMailWindow() {
        mailButton.click();
    }

    public void clickEnter() {
        openMailButton.click();
    }

    public void openMail(String mail, String password) {
        loginField.sendKeys(mail);
        loginField.submit();
        passwordField.sendKeys(password);
        submit.click();

    }

}
