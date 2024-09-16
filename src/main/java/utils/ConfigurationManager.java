package utils;

import java.awt.Toolkit;
import java.awt.Dimension;
import com.codeborne.selenide.Configuration;

/**
 * Класс для хранения настроек selenide
 */
public class ConfigurationManager {

    /**
     * Открывает браузер на полном разрешении экрана
     */
    public void openOnFullResolution() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Configuration.browserSize = String.format("%1$dx%2$d", screenSize.width, screenSize.height);
        Configuration.browserPosition = "0x0";
    }
}
