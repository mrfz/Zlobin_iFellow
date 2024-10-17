package ru.iFellow.utils;

import org.aeonbits.owner.Config;

/**
 * Класс для хранения настроек приложения
 * @author Fedor Zlobin
 */
@Config.Sources("classpath:api.properties")
public interface Properties extends Config{

    @Key("rickandmorty.api.uri")
    @DefaultValue("someUri")
    String rickAndMortyUri();

    @Key("rickandmorty.api.character.uri")
    String characterUri();


    @Key("rickandmorty.api.character.name")
    String characterName();

    @Key("rickandmorty.api.episode.uri")
    String episodeUri();

    @Key("reqres.api.uri")
    String reqresUri();

    @Key("reqres.api.create")
    String reqresCreate();

    @Key("reqres.user.name")
    String reqresUserName();

    @Key("reqres.user.job")
    String reqresUserJob();

    @Key("reqres.json.path")
    String reqresJsonPath();
}
