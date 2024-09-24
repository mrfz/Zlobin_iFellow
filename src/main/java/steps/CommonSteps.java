package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utils.ConfigurationManager;

public class CommonSteps {
    
    @BeforeAll
    public static void beforeAll() {
        WebDriverRunner.setWebDriver(ConfigurationManager.getWebDriver());
    }

    @After
    public static void afterAll() {
        Selenide.closeWebDriver();
    }
}
