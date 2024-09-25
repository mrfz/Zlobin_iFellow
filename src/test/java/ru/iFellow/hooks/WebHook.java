package ru.iFellow.hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.iFellow.utils.ConfigurationManager;

public class WebHook {
    @Before
    public static void before() {
        WebDriverRunner.setWebDriver(ConfigurationManager.getWebDriver());
    }

    @After
    public static void after() {
        Selenide.closeWebDriver();
    }
}
