package ru.iFellow.Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import ru.iFellow.utils.ConfigurationManager;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebHook {

    @Step("Подготовка веб-драйвера")
    @BeforeEach
    public void setUp() {

        WebDriverRunner.setWebDriver(ConfigurationManager.getWebDriver());
        Configuration.clickViaJs = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeAll
    public static void setUpAllureLogger() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @Step("Закрытие веб-драйвера")
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }



}
