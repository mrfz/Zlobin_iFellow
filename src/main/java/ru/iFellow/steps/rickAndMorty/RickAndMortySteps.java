package ru.iFellow.steps.rickAndMorty;


import io.qameta.allure.Step;
import org.apache.http.HttpStatus;
import ru.iFellow.api.rickAndMorty.RickAndMortyApi;
import ru.iFellow.dto.rickAndMorty.Episode;
import ru.iFellow.dto.rickAndMorty.SeriesCharacter;

public class RickAndMortySteps {

    private final RickAndMortyApi API = new RickAndMortyApi();

    @Step("Получение персонажа по id {id}")
    public SeriesCharacter getCharacterById(long id) {
        return API.getCharacter(id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(SeriesCharacter.class);
    }

    @Step("Получение id персонажа по имени {name}")
    public SeriesCharacter getCharacterIdByName(String name) {
        long id = API.getCharacterByFilter(name)
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .body()
                        .jsonPath()
                        .getLong("results[0].id");
        return getCharacterById(id);
    }

    @Step("Получение эпизода по id {id}")
    public Episode getEpisodeById(long id) {
        return API.getEpisode(id)
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .as(Episode.class);
    }

    @Step("Получение последнего эпизода персонажа {name}")
    public Episode getLastEpisodeFromCharacter(String name) {
        SeriesCharacter character = getCharacterIdByName(name);
        String LastEpisodeLink = character.getEpisode().get(character.getEpisode().size()-1);
        long episodeId = Long.parseLong(LastEpisodeLink.substring(LastEpisodeLink.lastIndexOf("/")+1));
        return getEpisodeById(episodeId);
    }

    @Step("Получение последнего персонажа эпизода {episodeId}")
    public SeriesCharacter getLastCharacterFromEpisode(long episodeId) {
        Episode episode = getEpisodeById(episodeId);
        String LastCharacterLink = episode.getCharacters().get(episode.getCharacters().size()-1);
        long characterId = Long.parseLong(LastCharacterLink.substring(LastCharacterLink.lastIndexOf("/")+1));
        return getCharacterById(characterId);
    }

}
