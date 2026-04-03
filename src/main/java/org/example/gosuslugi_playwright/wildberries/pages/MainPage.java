package org.example.gosuslugi_playwright.wildberries.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.wildberries.base.BasePage;

import java.nio.file.Paths;

@Slf4j
//// Главная страница сайта gosuslugi.ru
public class MainPage extends BasePage {

    // ========== ЗАКРЫТЬ ПОПАП ==========
    public MainPage closePopup() {
        page.locator("button._close_heicy_55").click();
        log.info("🔘 Попап закрыт");
        return this;
    }

    // ========== ПРИНЯТЬ КУКИ ==========
    public MainPage acceptCookies() {
        page.locator("button.cookies__btn").click();
        log.info("🍪 Куки приняты");
        return this;
    }

    // ========== КЛИК ПО ИКОНКЕ ПОИСКА ПО ФОТО ==========
    public MainPage clickSearchPhoto() {
        page.locator("div .imageIcon--Ji1JO").click();
        log.info("🔍 Клик по иконке поиска по фото");
        return this;
    }

    /*// ========== КЛИК ПО ИКОНКЕ ПОИСКА ПО ФОТО ==========
    public MainPage clickSearchPhotoSelectAPhoto() {
        page.locator("[id='uploadLink']").click();
        log.info("🔍 Клик по ссылке 'выберите фото'");
        return this;
    }*/

    // ========== ПОСЧИТАТЬ ИНПУТЫ ==========
    public MainPage countFileInputs() {
        int count = page.locator("input[type='file']").count();
        log.info("📁 Найдено input[type='file']: {}", count);
        return this;
    }

    // ========== ЗАГРУЗИТЬ ФОТО ДЛЯ ПОИСКА ==========
    public MainPage uploadPhoto(String filePath) {
        log.info("=== Загрузка фото ===");

        page.locator("#popUpFileInput").setInputFiles(
                Paths.get(filePath)
        );
        page.waitForTimeout(3000);

        log.info("📁 Файл загружен");
        return this;
    }

    // ========== ПОЛНЫЙ ПОИСК ПО ФОТО ==========
    public MainPage searchByImage(String filePath) {
        return closePopup()
                .acceptCookies()
                .clickSearchPhoto()
                //.clickSearchPhotoSelectAPhoto()
                .countFileInputs()
                .uploadPhoto(filePath);
    }
//==================================================================================================================
// ========== ПОЛУЧИТЬ ЗНАЧЕНИЕ placeholder ==========
public String getSearchPlaceholder() {
    closePopup().acceptCookies();
    Locator search = page.locator("[id='searchInput']");
    String placeholder = search.getAttribute("placeholder");
    log.info("Получаем значение атрибута placeholder: {}", placeholder);
    return placeholder;
}

    // ========== ПОИСК ==========
    public Skirts setGetSearch(String query) {
        // Проверяем и закрываем попап, если он есть
        Locator closeButton = page.locator("button._close_heicy_55");
        if (closeButton.count() > 0 && closeButton.isVisible()) {
            closeButton.click();
            log.info("🔘 Попап закрыт");
        } else {
            log.info("🔘 Попап не найден, пропускаем");
        }

        // Проверяем и принимаем куки, если они есть
        Locator cookiesButton = page.locator("button.cookies__btn");
        if (cookiesButton.count() > 0 && cookiesButton.isVisible()) {
            cookiesButton.click();
            log.info("🍪 Куки приняты");
        } else {
            log.info("🍪 Кнопка куки не найдена, пропускаем");
        }

        // Поиск
        Locator search = page.locator("[id='searchInput']");
        search.fill(query);

        // Проверяем, что текст ввёлся
        String actualValue = search.inputValue();
        boolean isTextEntered = actualValue.equals(query);
        log.info("Смотрим результат ввода текста в поиск: {}", isTextEntered);
        search.press("Enter");

        return new Skirts();

    }



}
