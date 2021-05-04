package ru.Ilnur.SimbirSoftTests;


import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Ilnur.Pages.BasePage;
import ru.Ilnur.Pages.MailAuthPage;
import ru.Ilnur.Pages.MailPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YandexMailTests {

    public static WebDriver driver = new ChromeDriver();
    static MailAuthPage mailAuthPage;
    static MailPage mailPage;
    static BasePage basePage;


    @BeforeAll
    public static void setUp() {
        basePage = new BasePage(driver);
        mailAuthPage = new MailAuthPage(driver);
        mailPage = new MailPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
        mailPage.clickEnter();
        mailAuthPage.authMail("testovumar@yandex.ru", "qwertY116");
        mailPage.openMailWindow();
    }


    @Description("Проверка отображения нового письма")
    @Test
    public void checkAddingNewMessage() {
        BasePage.switchNewPage(1);
        int count1 = mailPage.mailCount("Simbirsoft theme");
        System.out.println("Найдено " + count1 + " писем\\ьма");
        mailPage.newMessage();
        mailPage.inputMailAddress("testovumar@yandex.ru", "Simbirsoft theme");
        mailPage.sendMessage();
        assertEquals(mailPage.modalTitle().getText(), "Письмо отправлено", "Текст не отобразился");
        driver.navigate().refresh();
        int count2 = mailPage.mailCount("Simbirsoft theme");
        assertEquals(count1 + 1, count2, "Новое письмо не создалось");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
