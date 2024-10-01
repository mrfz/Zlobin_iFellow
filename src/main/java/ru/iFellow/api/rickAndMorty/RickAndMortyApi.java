package ru.iFellow.api.rickAndMorty;

import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigCache;
import ru.iFellow.utils.Properties;
import ru.iFellow.utils.Specifications;

import static io.restassured.RestAssured.given;

public class RickAndMortyApi extends Specifications  {


    Properties props = ConfigCache.getOrCreate(Properties.class);


    public ValidatableResponse getCharacter(long id) {
        return given()
                .spec(Specifications.baseRequestSpec(props.rickAndMortyUri()))
                .when()
                .get(props.characterUri() + "/" + id)
                .then()
                .spec(Specifications.baseResponseSpec());
    }

    public ValidatableResponse getCharacterByFilter(String filter) {
        return given()
                .spec(Specifications.baseRequestSpec(props.rickAndMortyUri()))
                .when().queryParam("name", filter)
                .get(props.characterUri())
                .then()
                .spec(Specifications.baseResponseSpec());
    }

    public ValidatableResponse getEpisode(long id) {
        return given()
                .spec(Specifications.baseRequestSpec(props.rickAndMortyUri()))
                .when()
                .get(props.episodeUri() + "/" + id)
                .then()
                .spec(Specifications.baseResponseSpec());
    }

}
