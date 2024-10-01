package ru.iFellow.api.rickAndMorty;

import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigCache;
import ru.iFellow.utils.Properties;
import ru.iFellow.utils.Specifications;

import static io.restassured.RestAssured.given;

public class RickAndMortyApi extends Specifications  {


    Properties props = ConfigCache.getOrCreate(Properties.class);
    private final String CHARACTER_URI = props.characterUri();


    public ValidatableResponse getCharacter(long id) {
        return given()
                .spec(Specifications.baseRequestSpec(props.rickAndMortyUri()))
                .when()
                .get(CHARACTER_URI + "/" + id)
                .then()
                .spec(Specifications.baseResponseSpec());
    }

    public ValidatableResponse getCharacterByFilter(String filter) {
        return given()
                .spec(Specifications.baseRequestSpec(props.rickAndMortyUri()))
                .when().queryParam("name", filter)
                .get(CHARACTER_URI)
                .then()
                .spec(Specifications.baseResponseSpec());
    }
}
