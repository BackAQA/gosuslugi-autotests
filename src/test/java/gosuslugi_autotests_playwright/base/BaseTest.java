package gosuslugi_autotests_playwright.base;

import com.microsoft.playwright.options.LoadState;
import org.example.gosuslugi_playwright.base.BasePage;
import org.example.gosuslugi_playwright.pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.Scanner;

abstract public class BaseTest extends BasePage {

    protected static MainPage mainPage;  // ← Связываем через композицию

    @BeforeAll
    public static void setUpTest() {
        setUp();                                      // 1. Запускаем браузер
        openPage("https://www.gosuslugi.ru/");        // 2. Открываем страницу
        page.waitForLoadState(LoadState.NETWORKIDLE); // 3. Ждем полной загрузки

        mainPage = new MainPage();  // 1 раз для всех тестов
    }

    @AfterAll
    public static void tearDownTest() {
        System.out.println("Нажмите Enter, чтобы закрыть браузер...");
        new Scanner(System.in).nextLine();  // ждем нажатия Enter
        tearDown();
//        tearDown();  // закрываем браузер
    }

}
