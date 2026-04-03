package gosuslugi_autotests_playwright.wildberries.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import gosuslugi_autotests_playwright.wildberries.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.wildberries.pages.MainPage;
import org.example.gosuslugi_playwright.wildberries.pages.Skirts;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Paths;

@Slf4j
public class AuthTest extends BaseTest {

    private MainPage mainPage = new MainPage();
    private Skirts skirts = new Skirts();



    @Nested
    @DisplayName("🔐 Работа с главной страницей")
    class MainPageTest {

        @Nested
        @DisplayName("Позитивные сценарии")
        @Tag("positive")
        @Tag("smoke") // позитивные тесты часто входят в smoke
        class PositiveAuthTests {

            @Test
            @DisplayName("Открытие главной страницы https://www.gosuslugi.ru/ и загрузка фотографии")
            void test1() {
                log.info("=== Запуск теста test1 ===");
                mainPage.searchByImage("C:\\Users\\admir\\OneDrive\\Desktop\\photo_2025-12-03_22-48-53.jpg");
                // Ждем загрузки после нажатия
                page.waitForLoadState(LoadState.NETWORKIDLE);
                page.waitForTimeout(500);
            }

            @Test
            @DisplayName("Получить значение placeholder")
            void test2() {
                log.info("=== Запуск теста test2 ===");
                String actualPlaceholder = mainPage.getSearchPlaceholder();
                String expectedPlaceholder = "Найти на Wildberries";  // Ожидаемое значение
                Assertions.assertEquals(expectedPlaceholder, actualPlaceholder,
                        "Placeholder соответствует ожидаемому");
                log.info("Actual placeholder: '{}'", actualPlaceholder);      // 👈 Вывод в лог
                log.info("Expected placeholder: '{}'", expectedPlaceholder);  // 👈 Вывод в лог
            }

            @Test
            @DisplayName("Поиск нужного")
            void test3() {
                log.info("=== Запуск теста test3 ===");
                mainPage.setGetSearch("юбка длина макси женская");
                page.waitForTimeout(500);
                //page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test3.png")).setFullPage(true));
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    @DisplayName("🔐 Работа со страницей результата поиска")
    class SkirtsTest{
        @Nested
        @DisplayName("Позитивные сценарии")
        @Tag("positive")
        @Tag("smoke") // позитивные тесты часто входят в smoke
        class PositiveAuthTests {

            @ParameterizedTest
            @ValueSource(strings = {"юбка макси", "платье летнее", "джинсы женские"})
            @DisplayName("Поиск разных товаров")
            void testDifferentSearches(String query) {
                log.info("=== Поиск: {} ===", query);

                mainPage.setGetSearch(query);

                // Ждём загрузки страницы после поиска
                page.waitForLoadState();

                String currentUrl = page.url();
                log.info("📍 ТЕКУЩИЙ URL ПОСЛЕ ПОИСКА: {}", currentUrl);

                Assertions.assertTrue(currentUrl.contains("search.aspx") || currentUrl.contains("catalog"),
                        "Должен быть переход на страницу поиска. URL: " + currentUrl);

            }


        }
   }
































    @Nested
    @DisplayName("🔐 Работа со страницей регистрации")
    class LoginPageTest {

        @Nested
        @DisplayName("Позитивные сценарии")
        @Tag("positive")
        @Tag("smoke") // позитивные тесты часто входят в smoke
        class PositiveAuthTests {

            @Test
            @DisplayName("Открытые страницы регистрации")
            void test1() {
                // Ждем загрузки после нажатия
                page.waitForLoadState(LoadState.NETWORKIDLE);
                page.waitForTimeout(500);

                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test2.png")).setFullPage(true));
            }
        }
    }




























}
