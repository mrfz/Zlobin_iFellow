package ru.iFellow.utils;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface Properties extends Config{

    @Key("rickandmorty.api.uri")
    String rickAndMortyUri();

    @Key("rickandmorty.api.character.uri")
    String characterUri();


    @Key("rickandmorty.api.character.id")
    long characterId();

    @Key("rickandmorty.api.character.name")
    String characterName();

    @Key("rickandmorty.api.episode.uri")
    String episodeUri();

    @Key("rickandmorty.api.episode.id")
    long episodeId();

}
