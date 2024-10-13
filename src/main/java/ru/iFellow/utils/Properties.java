package ru.iFellow.utils;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:api.properties")
public interface Properties extends Config{

    @Key("rickandmorty.api.uri")
    @DefaultValue("someUri")
    String rickAndMortyUri();

    @Key("rickandmorty.api.character.uri")
    String characterUri();


    @Key("rickandmorty.api.character.id")
    long characterId();

    @Key("rickandmorty.api.character.name")
    String characterName();

    @Key("rickandmorty.api.character.correctId")
    long characterCorrectId();

    @Key("rickandmorty.api.episode.uri")
    String episodeUri();

    @Key("rickandmorty.api.episode.id")
    long episodeId();

    @Key("rickandmorty.api.episode.correctId")
    long episodeCorrectId();

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
