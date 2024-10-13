package ru.iFellow.steps.rickAndMorty;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigCache;
import ru.iFellow.api.rickAndMorty.RickAndMortyApi;
import ru.iFellow.dto.rickAndMorty.SeriesCharacter;
import ru.iFellow.utils.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RickAndMortyCucumberSteps {

    RickAndMortySteps rickAndMortySteps = new RickAndMortySteps();
    Properties properties = ConfigCache.getOrCreate(Properties.class);
    SeriesCharacter firstCharacter = new SeriesCharacter();
    SeriesCharacter lastCharacter = new SeriesCharacter();
    private final RickAndMortyApi api = new RickAndMortyApi();


    @Дано("Получаем персонажа по заданному имени")
    public void getFirstCharacter() {
        this.firstCharacter = rickAndMortySteps.getCharacterIdByName(properties.characterName());
    }


    @Затем("Получаем последнего персонажа из последнего эпизода")
    public void getLastCharacter() {
        this.lastCharacter = rickAndMortySteps.getLastCharacterFromEpisode(rickAndMortySteps.getLastEpisodeFromCharacter(properties.characterName()).getId());
    }

    @Тогда("Проверяем не совпадение локации")
    public void checkLocation() {
        assertNotEquals(this.firstCharacter.getLocation(), this.lastCharacter.getLocation());
    }

    @Тогда("Проверяем совпадение расы")
    public void checkSpecies() {
        assertEquals(this.firstCharacter.getSpecies(), this.lastCharacter.getSpecies());
    }

}
