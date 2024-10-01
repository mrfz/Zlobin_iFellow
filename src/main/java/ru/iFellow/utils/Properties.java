package ru.iFellow.utils;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface Properties extends Config{

    @Key("rickandmorty.api.uri")
    String rickAndMortyUri();

    @Key("rickandmorty.api.character.uri")
    String characterUri();

    @Key("character.id")
    long characterId();

    @Key("character.name")
    String characterName();


}
