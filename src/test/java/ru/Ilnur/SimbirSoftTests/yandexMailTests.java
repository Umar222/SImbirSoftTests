package ru.Ilnur.SimbirSoftTests;

import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Ilnur.Pages.mailPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class yandexMailTests {


    public static WebDriver driver = new ChromeDriver();
    static mailPage mailPage;
    int count;


    @BeforeAll
    public static void setUp() {
        mailPage = new mailPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
        mailPage.clickEnter();
        mailPage.openMail("testovumar@yandex.ru", "qwertY116");
        mailPage.openMailWindow();


    }


//    @Description("Проверка отображения писем на тему Simbirsoft theme")
    @Test
    public void checkEnterMessage() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_subject\"]"));
        for (WebElement title : elements) {
            if (title.getText().equals("Simbirsoft theme"))
                count++;
        }
        System.out.println("Писем по теме найдено " + count);
    }




    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
