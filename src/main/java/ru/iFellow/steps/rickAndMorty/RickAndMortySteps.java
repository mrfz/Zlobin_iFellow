package ru.iFellow.steps.rickAndMorty;

import org.apache.http.HttpStatus;
import ru.iFellow.api.rickAndMorty.RickAndMortyApi;
import ru.iFellow.dto.rickAndMorty.SeriesCharacter;

public class RickAndMortySteps {

    private static final RickAndMortyApi API = new RickAndMortyApi();

    public SeriesCharacter getCharacterById(long id) {
        return API.getCharacter(id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(SeriesCharacter.class);
    }

    public SeriesCharacter getCharacterIdByName(String name) {
        long id = API.getCharacterByFilter(name)
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .body()
                        .jsonPath()
                        .getLong("results[0].id");
        return getCharacterById(id);
    }
}
