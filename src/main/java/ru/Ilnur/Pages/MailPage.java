package ru.Ilnur.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MailPage {

    @FindBy(xpath = "//div[text() = \"Войти\"]")
    private WebElement openMailButton;
    @FindBy(xpath = "//a[@href=\"https://mail.yandex.ru/\"]")
    private WebElement mailButton;
    @FindBy(xpath = "//input[@placeholder=\"Поиск\"]")
    private WebElement searchField;
    @FindBy(xpath = "//span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_subject\"]")
    public List<WebElement> messageTheme;
    @FindBy(xpath = "//span[@class=\"mail-ComposeButton-Text\"]")
    private WebElement createMessage;
    @FindBy(xpath = "//div[@data-class-bubble=\"yabble-compose js-yabble\"]")
    private WebElement emailField;
    @FindBy(xpath = "//input[@class = \"composeTextField ComposeSubject-TextField\"]")
    private WebElement emailThemeField;
    @FindBy(xpath = "//button[@class = \"control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action\"]")
    private WebElement sendMessageButton;
    @FindBy(xpath = "//div[@class=\"ComposeDoneScreen-Title\"]")
    private WebElement modalWindowTitle;

    public WebDriver driver;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Отображение заголовка молдального окна")
    public WebElement modalTitle() {
        return this.modalWindowTitle;
    }

    @Step("Кликаю Отправить сообщение")
    public void sendMessage() {
        sendMessageButton.click();
    }

    @Step("Ввожу адрес и тему письма")
    public void addMailAddress(String email, String theme) {
        emailField.sendKeys(email);
        emailThemeField.sendKeys(theme);
    }

    @Step("Кликнуть Новое сообщение")
    public void newMessage() {
        createMessage.click();
    }

    @Step("Кликаю Войти")
    public void openMailWindow() {
        mailButton.click();
    }

    @Step("Кликнуть Войти в почту")
    public void clickEnter() {
        openMailButton.click();
    }

    @Step("Считаю количество писем с темой ")
    public int mailCount(String mailTheme) {
        int count = 0;
        for (WebElement title : messageTheme) {
            if (title.getText().equals(mailTheme))
                count++;
        }
        return count;
    }


}
