package ru.iFellow.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 * Класс для хранения настроек selenide
 */

public class ConfigurationManager {

    public static ChromeDriver getWebDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return new ChromeDriver(options);
    }

}
