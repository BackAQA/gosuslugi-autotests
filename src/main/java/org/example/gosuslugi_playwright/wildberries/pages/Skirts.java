package org.example.gosuslugi_playwright.wildberries.pages;

import com.microsoft.playwright.Locator;
import lombok.extern.slf4j.Slf4j;
import org.example.gosuslugi_playwright.wildberries.base.BasePage;
import java.util.List;

@Slf4j
/// Страница с результатом поиска юбки
public class Skirts extends BasePage {

    public Skirts catalogPageMain(){
        List<Locator> allProductPage = page.locator(".product-card").all();
        for (int i = 0; i < allProductPage.size(); i++){
            Locator product = allProductPage.get(i);
            String ariaLabel = product.getAttribute("aria-label");
            String price = product.locator(".price").textContent();
            log.info("Товар {}: {} - {}", i+1, ariaLabel, price);
        }
        return this;
    }
}
