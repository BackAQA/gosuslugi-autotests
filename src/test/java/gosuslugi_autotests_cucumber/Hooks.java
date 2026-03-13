package gosuslugi_autotests_cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.cucumber.CommonActionsSeleniumCucumber;
import org.example.cucumber.MainPageCucumber;

public class Hooks {
    private TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp() throws InterruptedException {
        context.driver = CommonActionsSeleniumCucumber.createDriverCucumber();
        context.mainPage = new MainPageCucumber(context.driver);
        context.mainPage.open("https://www.gosuslugi.ru/");
    }

    @After
    public void tearDown() {
        if (context.driver != null) {
            context.driver.quit();
        }
    }
}
