package ru.iFellow.utils;

import org.aeonbits.owner.Config;

/**
 * Интерфейс конфигурации браузера
 * получает расположение вебдрайвер из проперти файла
 *
 * @author Fedor Zlobin
 */
@Config.Sources({"classpath:BrowserConfig.properties"})
public interface BrowserConfig extends Config {

    @Key("webdriver.path")
    @DefaultValue("defaultpath")
    String getWebDriverPath();

}
