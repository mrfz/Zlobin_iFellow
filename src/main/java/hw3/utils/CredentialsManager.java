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

    String url();
    @DefaultValue("username")
    String username();
    @DefaultValue("password")
    String password();
}

