package gosuslugi_autotests_cucumber;

import org.example.cucumber.LoginRegistrationPageCucumber;
import org.example.cucumber.MainPageCucumber;
import org.openqa.selenium.WebDriver;

public class TestContext {
    public WebDriver driver;
    public MainPageCucumber mainPage;
    public LoginRegistrationPageCucumber loginPage;

    public TestContext() {
        // Инициализация будет происходить в Hooks
    }
}
