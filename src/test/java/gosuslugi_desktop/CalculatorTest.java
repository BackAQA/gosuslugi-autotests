package gosuslugi_desktop;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CalculatorTest {

    @DisplayName("Тесты Windows-приложений (WinAppDriver)")
    public static void setUp(){
        System.out.println("🔧 Настройка WinAppDriver...");

        DesiredCapabilities capabilities = new DesiredCapabilities();
    }
}
