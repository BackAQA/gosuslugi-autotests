package gosuslugi_autotests_playwright.base;


import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

abstract public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected BrowserContext context;

    @BeforeEach
    public void init() {
        // Создаём Playwright один раз
        playwright = Playwright.create();

        // Запускаем браузер
        browser = playwright.chromium().launch();

        // Запускаем НАСТОЯЩИЙ Chrome, а не Chromium!
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")  // 👈 КЛЮЧЕВОЙ ПАРАМЕТР!
                .setHeadless(false));

        // Создаём новую страницу
        page = browser.newPage();

        // Переходим на сайт
        page.navigate("https://www.gosuslugi.ru/");
    }

    @AfterEach
    public void tearDown() {
        // Закрываем страницу
        if (page != null) {
            page.close();
        }

        // Закрываем браузер
        if (browser != null) {
            browser.close();
        }

        // Закрываем Playwright
        if (playwright != null) {
            playwright.close();
        }
    }

}
