package ru.iFellow.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:BrowserConfig.properties"})
public interface BrowserConfig extends Config {

    @Key("webdriver.path")
    @DefaultValue("defaultpath")
    String getWebDriverPath();

}
