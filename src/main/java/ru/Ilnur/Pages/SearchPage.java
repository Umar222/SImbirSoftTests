package ru.Ilnur.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    @Step("Ввожу текст в поле поиска")
    public void Field(String text){
        searchField.sendKeys(text);
    }

    @Step("Кликаю Поиск")
    public void search(){
        searchButton.click();
    }

    public WebDriver driver;

    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


}
