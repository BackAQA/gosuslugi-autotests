package gosuslugi_autotests_cucumber.stepdefs;

import gosuslugi_autotests_cucumber.TestContext;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepsCucumber {

    private TestContext context;

    // PicoContainer сам передаст context
    public LoginStepsCucumber(TestContext context) {
        this.context = context;
    }

    @Дано("я открываю страницу авторизации")
    public void openAuthPage() {
        context.loginPage = context.mainPage.clickExtensionsLink();
        System.out.println("✅ Страница авторизации открыта");
    }

    @Когда("я ввожу логин {string}")
    public void enterLogin(String login) {
        context.loginPage.enterLogin(login);
    }

    @Когда("я ввожу пароль {string}")
    public void enterPassword(String password) {
        context.loginPage.enterPassword(password);
    }

    @И("нажимаю кнопку {string}")
    public void clickButton() {
        context.loginPage.enterEbutton();
    }

    @Тогда("я вижу сообщение об ошибке {string}")
    public void seeErrorMessage(String expectedMessage) {
        String result = context.loginPage
                .messageError(expectedMessage)
                .getLastErrorMessage();
        assertTrue(result.contains(expectedMessage));
    }
}
