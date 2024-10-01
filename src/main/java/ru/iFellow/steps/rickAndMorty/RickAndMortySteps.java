package ru.iFellow.steps.rickAndMorty;

import org.apache.http.HttpStatus;
import ru.iFellow.api.rickAndMorty.RickAndMortyApi;
import ru.iFellow.dto.rickAndMorty.Episode;
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

    public Episode getEpisodeById(long id) {
        return API.getEpisode(id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Episode.class);
    }

    public Episode getLastEpisodeFromCharacter(String name) {
        SeriesCharacter character = getCharacterIdByName(name);
        String LastEpisodeLink = character.getEpisode().get(character.getEpisode().size()-1);
        long episodeId = Long.parseLong(LastEpisodeLink.substring(LastEpisodeLink.lastIndexOf("/")+1));
        return getEpisodeById(episodeId);
    }

}
