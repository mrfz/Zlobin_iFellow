package hw3.utils;

/**
 * Класс для хранения учетных данных
 * в репозитории хранится с данными по умолчанию,
 * для работы в приложении необходимо изменить возвращаемые параметры
 *
 */
public class CredentialsManager {
    public static String getUsername() {
        return "username";
    }

    public static String getPassword() {
        return "password";
    }
}

