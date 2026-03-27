package gosuslugi_autotests_playwright.base;

import org.example.gosuslugi_playwright.base.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

abstract public class BaseTest {

    @BeforeAll
    public static void setUp() {
        BasePage.setUp();  // открываем браузер
        BasePage.openPage("https://www.gosuslugi.ru/");
    }

    @AfterAll
    public static void tearDown() {
        BasePage.tearDown();  // закрываем браузер
    }

}
