package org.example.gosuslugi_playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.gosuslugi_playwright.base.BasePage;

//// Главная страница сайта gosuslugi.ru
public class MainPage extends BasePage {

    // Не нужно создавать конструктор, используем статический page из BasePage

    // Локаторы как методы (ленивая инициализация)
    public static Locator loginButton() {
        return page.getByText("Войти");
    }

    public static Locator searchInput() {
        return page.locator("input[type='search']");
    }

    public static Locator personalCabinet() {
        return page.locator("a:has-text('Личный кабинет')");
    }

    // Методы действий
    public static void clickLoginButton() {
        loginButton().click();
    }

    public static void search(String query) {
        searchInput().fill(query);
        searchInput().press("Enter");
    }

    public static boolean isLoginButtonVisible() {
        return loginButton().isVisible();
    }

    public static String getPageTitle() {
        return page.title();
    }
}
