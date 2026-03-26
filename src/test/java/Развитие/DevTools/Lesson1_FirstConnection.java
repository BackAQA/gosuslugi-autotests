package Развитие.DevTools;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Lesson1_FirstConnection {
    public static void main(String[] args) {
        System.out.println("=== Урок 1: Первое подключение к DevTools ===");

        // Шаг 1: Включаем браузер
        ChromeDriver driver = new ChromeDriver();
        System.out.println("✅ Браузер открыт");

        // Шаг 2: Подключаемся к DevTools
        DevTools devTools = driver.getDevTools();
        System.out.println("✅ Получили доступ к DevTools");

        // Шаг 3: Создаём сессию (как подключение пульта к телевизору)
        devTools.createSession();
        System.out.println("✅ Сессия создана! Мы в DevTools");

        // Шаг 4: Открываем сайт
        driver.get("https://www.gosuslugi.ru/");
        System.out.println("✅ Сайт открыт");

        // Шаг 5: Смотрим что получилось
        System.out.println("\n🎉 Ура! Мы подключились к DevTools из Java!");
        System.out.println("Заголовок страницы: " + driver.getTitle());

        // Шаг 6: Не закрываем сразу, чтобы ты успел посмотреть
        try {
            Thread.sleep(5000); // ждём 5 секунд
        } catch (Exception e) {
            // ничего
        }

        // Шаг 7: Закрываем
        driver.quit();
        System.out.println("✅ Браузер закрыт");
    }
}
