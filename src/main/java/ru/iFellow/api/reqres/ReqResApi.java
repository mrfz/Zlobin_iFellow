package ru.iFellow.api.reqres;

import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigCache;
import ru.iFellow.dto.reqres.User;
import ru.iFellow.utils.Properties;
import ru.iFellow.utils.Specifications;

import static io.restassured.RestAssured.given;

/**
 * Класс для работы с API ReqRes
 */
public class ReqResApi extends Specifications {

    final Properties props = ConfigCache.getOrCreate(Properties.class);

    /**
     * Метод для создания пользователя
     * @param user {@link User} - объект пользователя
     * @return {@link ValidatableResponse} - ответ сервера
     */
    public ValidatableResponse postUser(User user) {
        return given()
                .spec(Specifications.postRequestSpec(props.reqresUri()))
                .when().body(user)
                .post(props.reqresCreate())
                .then()
                .spec(Specifications.postResponseSpec());
    }
}
