package ru.iFellow.rickAndMorthy;

import org.aeonbits.owner.ConfigCache;
import org.junit.Assert;
import org.junit.Test;
import ru.iFellow.api.rickAndMorty.RickAndMortyApi;
import ru.iFellow.dto.rickAndMorty.Episode;
import ru.iFellow.dto.rickAndMorty.SeriesCharacter;
import ru.iFellow.steps.rickAndMorty.RickAndMortySteps;
import ru.iFellow.utils.Properties;

import static org.hamcrest.Matchers.is;

public class RickAndMortyTest {


    Properties props = ConfigCache.getOrCreate(Properties.class);
    private static final RickAndMortySteps steps = new RickAndMortySteps();
    private final RickAndMortyApi api = new RickAndMortyApi();


    @Test
    public void getCharacterTest () {
        api.getCharacter(2)
        .and().body("id", is(2));
    }

    @Test
    public void getCharacterByIdTest() {
        SeriesCharacter firstCharacter= steps.getCharacterById(props.characterId());
        Assert.assertEquals(props.characterId(), firstCharacter.id);
    }


    @Test
    public void getCharacterByNameTest() {
        SeriesCharacter  firstCharacter= steps.getCharacterIdByName(props.characterName());
        Assert.assertThat(firstCharacter.getId(), is(props.characterId()));
    }

    @Test
    public void getEpisodeTest() {
        api.getEpisode(1)
                .and().body("id", is(1));
    }

    @Test
    public void getEpisodeByIdTest() {
        Episode episode = steps.getEpisodeById(props.episodeId());
        Assert.assertEquals(props.episodeId(), episode.id);
    }

    @Test
    public void getLastEpisodeFromCharacterTest() {
        Episode episode = steps.getLastEpisodeFromCharacter(props.characterName());
        Assert.assertEquals(51, episode.id);
    }


}
