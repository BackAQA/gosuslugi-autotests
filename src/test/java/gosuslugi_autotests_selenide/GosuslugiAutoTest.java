package gosuslugi_autotests_selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GosuslugiAutoTest extends BaseTest{
    @Nested
    @DisplayName("🔐 Работа с главной страницей")
    class MainPageTest {  // ✅ статический

        @Nested
        @DisplayName("Позитивные тесты")
        class PositiveAuthTests {  // ✅ статический

            @Test
            @DisplayName("Открытие ссылки")
            void test1() {
                System.out.println("Тест сработал");
            }
        }
    }
}
