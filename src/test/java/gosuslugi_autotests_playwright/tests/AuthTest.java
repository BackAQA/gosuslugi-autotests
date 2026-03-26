package gosuslugi_autotests_playwright.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import gosuslugi_autotests_playwright.base.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AuthTest extends BaseTest {

    @Test
    public void firstTest() {
        // Ждём, пока все запросы закончатся (подходят для React/Vue приложений)
        page.waitForLoadState(LoadState.NETWORKIDLE);

        // Проверяем заголовок страницы
        String title = page.title();
        System.out.println("Title: " + title);

        // Проверяем, что мы на Госуслугах
        assert page.url().contains("gosuslugi");

        // Можно сделать скриншот
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshots/first-test.png")));
    }
}
