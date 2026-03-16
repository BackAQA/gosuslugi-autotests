package gosuslugi_autotests_selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

abstract public class BaseTest {
    @BeforeEach
    public void init(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 4000;
        Configuration.headless = false;
        Configuration.screenshots = true;
    }

    @BeforeEach
    public void openPage() {
        open("https://www.gosuslugi.ru/");
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
