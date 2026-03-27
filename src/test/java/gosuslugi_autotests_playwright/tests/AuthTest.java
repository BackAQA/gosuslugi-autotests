package gosuslugi_autotests_playwright.tests;

import com.microsoft.playwright.Page;
import gosuslugi_autotests_playwright.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.pages.MainPage;
import org.junit.jupiter.api.*;
import java.nio.file.Paths;

@Slf4j
public class AuthTest extends BaseTest {

    @Nested
    @DisplayName("🔐 Работа с главной страницей")
    class MainPageTest {

        @Nested
        @DisplayName("Позитивные сценарии")
        @Tag("positive")
        @Tag("smoke") // позитивные тесты часто входят в smoke
        class PositiveAuthTests {

            @Test
            @DisplayName("Открытие главной страницы https://www.gosuslugi.ru/")
            void test1() {
                log.info("=== Запуск теста test1 ===");
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test1.png")));
            }

            @Test
            @DisplayName("Получения списка ссылок и название этих ссылок в меню")
            void test2() {
                mainPage.allLocatorText();
            }

            @Test
            @DisplayName("Получение списка ссылок всех услуг и название этих услуг")
            void test3() {
                mainPage.allLocatorTextServices();
            }

            @Test
            @DisplayName("Переход на страницу регистрации")
            void test5() {
                mainPage.clickLoginButton();
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test3.png")));
            }
        }
    }
}
