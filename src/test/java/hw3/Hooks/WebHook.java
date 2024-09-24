package hw3.Hooks;

import com.codeborne.selenide.Selenide;
import hw3.utils.ConfigurationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class WebHook {
    @BeforeAll
    public static void setUp() {
        ConfigurationManager configurationManager = new ConfigurationManager();
        configurationManager.openOnFullResolution();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }


}
