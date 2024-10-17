package ru.iFellow.api.rickAndMorty;

import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigCache;
import ru.iFellow.utils.Properties;
import ru.iFellow.utils.Specifications;

import static io.restassured.RestAssured.given;

/**
 * Класс для работы с API RickAndMorty
 * @author Fedor Zlobin
 */
public class RickAndMortyApi extends Specifications  {

    final Properties props = ConfigCache.getOrCreate(Properties.class);

    /**
     * Запрос персонажа по id
     * @param  id - идентификатор персонажа
     * @return {@link ValidatableResponse} - ответ сервера
     */
    public ValidatableResponse getCharacter(long id) {
        return given()
                .spec(Specifications.baseRequestSpec(props.rickAndMortyUri()))
                .when()
                .get(props.characterUri() + "/" + id)
                .then()
                .spec(Specifications.baseResponseSpec());
    }

    /**
     * Запрос персонажа по фильтру
     * @param filter - значение для фильтра
     * @return {@link ValidatableResponse} - ответ сервера
     */
    public ValidatableResponse getCharacterByFilter(String filter) {
        return given()
                .spec(Specifications.baseRequestSpec(props.rickAndMortyUri()))
                .when().queryParam("name", filter)
                .get(props.characterUri())
                .then()
                .spec(Specifications.baseResponseSpec());
    }

    /**
     * Запрос эпизода по id
     * @param id - идентификатор эпизода
     * @return {@link ValidatableResponse} - ответ сервера
     */
    public ValidatableResponse getEpisode(long id) {
        return given()
                .spec(Specifications.baseRequestSpec(props.rickAndMortyUri()))
                .when()
                .get(props.episodeUri() + "/" + id)
                .then()
                .spec(Specifications.baseResponseSpec());
    }

}
