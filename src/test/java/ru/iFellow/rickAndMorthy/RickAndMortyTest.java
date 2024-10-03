package ru.iFellow.rickAndMorthy;

import org.aeonbits.owner.ConfigCache;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.api.rickAndMorty.RickAndMortyApi;
import ru.iFellow.dto.rickAndMorty.Episode;
import ru.iFellow.dto.rickAndMorty.SeriesCharacter;
import ru.iFellow.steps.rickAndMorty.RickAndMortySteps;
import ru.iFellow.utils.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RickAndMortyTest {


    Properties props = ConfigCache.getOrCreate(Properties.class);
    private final RickAndMortySteps steps = new RickAndMortySteps();
    private final RickAndMortyApi api = new RickAndMortyApi();


    @Test
    @DisplayName("Проверка get запроса поиска персонажа")
    public void getCharacterTest () {
        api.getCharacter(2)
        .and().body("id", is(2));
    }

    @Test
    @DisplayName("Проверка получения персонажа по  id")
    public void getCharacterByIdTest() {
        SeriesCharacter firstCharacter= steps.getCharacterById(props.characterId());
        assertEquals(props.characterId(), firstCharacter.id);
    }


    @Test
    @DisplayName("Проверка получения персонажа по имени")
    public void getCharacterByNameTest() {
        SeriesCharacter  firstCharacter= steps.getCharacterIdByName(props.characterName());
        assertEquals(firstCharacter.getId(), props.characterId());
    }

    @Test
    @DisplayName("Проверка get запроса эпизода")
    public void getEpisodeTest() {
        api.getEpisode(1)
                .and().body("id", is(1));
    }

    @Test
    @DisplayName("Проверка поиска получения эпизода по id")
    public void getEpisodeByIdTest() {
        Episode episode = steps.getEpisodeById(props.episodeId());
        assertEquals(props.episodeId(), episode.id);
    }

    @Test
    @DisplayName("Проверка получения последнего эпизода персонажа")
    public void getLastEpisodeFromCharacterTest() {
        Episode episode = steps.getLastEpisodeFromCharacter(props.characterName());
        assertEquals(props.episodeCorrectId(), episode.id);
    }

    @Test
    @DisplayName("Проверка получения последнего персонажа эпизода")
    public void getLastCharacterFromEpisodeTest() {
        SeriesCharacter character = steps.getLastCharacterFromEpisode(props.episodeCorrectId());
        assertEquals(props.characterCorrectId(), character.id);
    }

    @Test
    @DisplayName("Проверка совпадения локации и расы персонажей")
    public void checkLocationAndSpeciesTest() {
        SeriesCharacter characterMorty = steps.getCharacterIdByName(props.characterName());
        SeriesCharacter characterToCheck = steps.getLastCharacterFromEpisode(steps.getLastEpisodeFromCharacter(props.characterName()).getId());
        assertNotEquals(characterMorty.getLocation(), characterToCheck.getLocation());
        assertEquals(characterMorty.getSpecies(), characterToCheck.getSpecies());

    }

}
