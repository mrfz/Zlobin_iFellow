package hw3.Hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import hw3.utils.ConfigurationManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WebHook {

    @Step("Подготовка веб-драйвера")
    @BeforeEach
    public void setUp() {

        WebDriverRunner.setWebDriver(ConfigurationManager.getWebDriver());

    }

    @Step("Закрытие веб-драйвера")
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }



}
