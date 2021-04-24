package ru.Ilnur.SimbirSoftTests;

import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Ilnur.Pages.MailPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YandexMailTests {

    public static WebDriver driver = new ChromeDriver();
    static MailPage mailPage;
    int n;

    @BeforeAll
    public static void setUp() {
        mailPage = new MailPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
        mailPage.clickEnter();
        mailPage.openMail("testovumar@yandex.ru", "qwertY116");
        mailPage.openMailWindow();
    }


    @Description("Проверка отображения писем на тему Simbirsoft theme")
    @Test
    public void checkEnterMessage() {
        mailPage.switchNewPage(1);
        for (WebElement title : mailPage.messageTheme) {
            assertEquals(title.getText(), "Simbirsoft theme");
            if (title.getText().equals("Simbirsoft theme"))
                n++;
        }
        if (n < 1) {
            System.out.println("Писем по теме Simbirsoft theme нет");
        } else {
            System.out.println("Найдено " + n + " писем");

        }
    }

    @Description("Проверка отображения нового письма")
    @Test
    public void checkAddingNewMessage() {
        int count = 0;
        mailPage.switchNewPage(1);
        for (WebElement title : mailPage.messageTheme) {
            if (title.getText().equals("Simbirsoft theme"))
                n++;
        }
        mailPage.newMessage();
        mailPage.addMailAddress("testovumar@yandex.ru", "Simbirsoft theme");
        mailPage.sendMessage();
        mailPage.modalTitle().isDisplayed();
        driver.navigate().refresh();
        for (WebElement title : mailPage.messageTheme) {
            if (title.getText().equals("Simbirsoft theme"))
                count++;
        }
        System.out.println("Первый счетчик " + n);
        System.out.println("Второй счетчик " + count);
        assert (count > n);

    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
