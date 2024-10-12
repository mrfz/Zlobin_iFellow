package ru.iFellow.utils;

import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;


/**
 * Класс задания конфигурации браузера\
 * @author Fedor Zlobin
 */
public class ConfigurationManager {

    /**
     * Конфигурация браузера
     * Если в папке проекта есть файл вебдрайвера то используем его,
     * иначе используем браузер selenide по умолчанию
     * @author Fedor Zlobin
     * @return <code>ChromeDriver</code> объект браузера
     */
    public static ChromeDriver getWebDriver(){
        BrowserConfig browserConfig = ConfigCache.getOrCreate(BrowserConfig.class);

        File webDriver = new File(browserConfig.getWebDriverPath());

        if (webDriver.exists()) {
            System.setProperty( "webdriver.chrome.driver", browserConfig.getWebDriverPath());
            System.out.println("Используемый webdriver: " + browserConfig.getWebDriverPath());
        }
        else {
            System.out.println("Webdriver не найден по пути: " + browserConfig.getWebDriverPath() + ".  Используем webdriver selenide по умолчанию");
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return new ChromeDriver(options);
    }

}
