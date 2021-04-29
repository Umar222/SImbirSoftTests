package ru.Ilnur.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    @FindBy(css = "td:nth-child(1) > .A2W7l > .MEdqYd")
    private WebElement leftParenthesis;
    @FindBy(css = "tr:nth-child(4) > td:nth-child(1) > .A2W7l > .XRsWPe")
    private WebElement buttonOne;
    @FindBy(css = "tr:nth-child(5) .mF5fo > .MEdqYd")
    private WebElement plus;
    @FindBy(css = "tr:nth-child(4) > td:nth-child(2) > .A2W7l > .XRsWPe")
    private WebElement buttonTwo;
    @FindBy(css = "td:nth-child(2) > .A2W7l > .MEdqYd")
    private WebElement RightParenthesis;
    @FindBy(css = "tr:nth-child(3) .mF5fo > .XRsWPe")
    private WebElement multiply;
    @FindBy(css = "tr:nth-child(4) > td:nth-child(3) > .A2W7l > .XRsWPe")
    private WebElement buttonThree;
    @FindBy(css = "tr:nth-child(4) .mF5fo > .XRsWPe")
    private WebElement minus;
    @FindBy(css = "tr:nth-child(3) > td:nth-child(1) > .A2W7l > .XRsWPe")
    private WebElement buttonFore;
    @FindBy(css = "tr:nth-child(5) .A2W7l > .XRsWPe")
    private WebElement buttonZero;
    @FindBy(css = "tr:nth-child(2) .mF5fo > .XRsWPe")
    private WebElement divide;
    @FindBy(css = "tr:nth-child(3) > td:nth-child(2) > .A2W7l > .XRsWPe")
    private WebElement buttonFive;
    @FindBy(css = "tr:nth-child(3) > td:nth-child(3) > .A2W7l > .XRsWPe")
    private WebElement buttonSix;
    @FindBy(xpath = "//div[@jsname = \"aN1RFf\"]")
    private WebElement buttonSin;
    @FindBy(xpath = "//span[@jsname = \"ubtiRe\"]")
    private WebElement history;
    @FindBy(xpath = "//span[@jsname = \"VssY5c\"]")
    private WebElement numberField;
    @FindBy(css = ".UUhRt")
    private WebElement equally;

    public WebDriver driver;

    public CalculatorPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void equallyB(){
        equally.click();
    }

    public void leftParenthesisB(){
        leftParenthesis.click();
    }

    public void One(){
        buttonOne.click();
    }

    public void plusB(){
        plus.click();
    }

    public void Two(){
        buttonTwo.click();
    }

    public void RightParenthesisB(){
        RightParenthesis.click();
    }

    public void multiplyB(){
        multiply.click();
    }

    public void Three(){
        buttonThree.click();
    }

    public void minusB(){
        minus.click();
    }

    public void Fore(){
        buttonFore.click();
    }

    public void Zero(){
        buttonZero.click();
    }

    public void divideB(){
        divide.click();
    }

    public void Five(){
        buttonFive.click();
    }

    public void Six(){
        buttonSix.click();
    }

    public void Sin(){
        buttonSin.click();
    }

    public String historyField(){
        String historyField = history.getText();
        return historyField;

    }

    public String numberFieldB(){
        String field = numberField.getText();
        return field;
    }
}
