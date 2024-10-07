package hw3.utils;

import org.aeonbits.owner.Config;

/**
 * Класс для хранения учетных данных
 * в репозитории хранится с данными по умолчанию,
 * для работы в приложении необходимо изменить возвращаемые параметры
 *
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

