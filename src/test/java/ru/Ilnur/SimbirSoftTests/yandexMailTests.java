package ru.Ilnur.SimbirSoftTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Ilnur.Pages.CalculatorPage;
import ru.Ilnur.Pages.SearchPage;
import ru.Ilnur.Pages.mailPage;

import java.util.concurrent.TimeUnit;

public class yandexMailTests {


    public static WebDriver driver = new ChromeDriver();
    static mailPage mailPage;


    @BeforeAll
    public static void setUp() {
         mailPage = new mailPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get(ConfProperties.getProperty("commonPage"));
        driver.get("https://yandex.ru/");

    }

    @Test
    public void openMail() {
        mailPage.openMail();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

}
