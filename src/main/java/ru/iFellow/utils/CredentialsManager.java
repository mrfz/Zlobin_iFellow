package ru.iFellow.utils;

import org.aeonbits.owner.Config;

/**
 * Класс для получения учетных данных из проперти файла
 * в репозитории хранится с данными по умолчанию,
 * для работы в приложении необходимо изменить параметры в проперти файле
 * @author Fedor Zlobin
 */
@Config.Sources({"classpath:CredentialsManager.properties"})
public interface CredentialsManager extends Config  {

    @Key("url")
    String url();

    @Key("username")
    String username();

    @Key("password")
    String password();
}

