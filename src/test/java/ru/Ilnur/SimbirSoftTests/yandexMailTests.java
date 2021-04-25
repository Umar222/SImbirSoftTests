package ru.Ilnur.SimbirSoftTests;

import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Ilnur.Pages.MailAuthPage;
import ru.Ilnur.Pages.MailPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexMailTests{

    public static WebDriver driver = new ChromeDriver();
    static MailAuthPage mailAuthPage;
    static MailPage mailPage;
    int n;

    public void switchNewPage(int pageNumber) {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(pageNumber));
    }

    @BeforeAll
    public static void setUp() {
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

        switchNewPage(1);
        int n = mailPage.mailCount("Simbirsoft theme");
        System.out.println("Найдено " + n + " писем\\ьма");

        mailPage.newMessage();
        mailPage.addMailAddress("testovumar@yandex.ru", "Simbirsoft theme");
        mailPage.sendMessage();
        assertEquals(mailPage.modalTitle().getText(), "Письмо отправлено");

        driver.navigate().refresh();

        int count = mailPage.mailCount("Simbirsoft theme");

        assertTrue(count > n);

    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
