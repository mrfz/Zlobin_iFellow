package ru.iFellow.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

/**
 * Спецификация для запросов и ответов
 * @author Fedor Zlobin
 */
public class Specifications {

    /**
     * Базовая спецификация запроса
     * @param url - путь к API
     * @return {@link RequestSpecification}
     */
    public static RequestSpecification baseRequestSpec (String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/json")
                .log(LogDetail.URI)
                .build();
    }

    /**
     * Базовая спецификация ответа
     * @return {@link ResponseSpecification}
     */
    public static ResponseSpecification baseResponseSpec () {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .log(LogDetail.BODY)
                .build();
    }

    /**
     * Базовая спецификация POST запроса
     * @param url - путь к API
     * @return {@link RequestSpecification}
     */
    public static RequestSpecification postRequestSpec (String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/json")
                .log(LogDetail.ALL)
                .build();
    }

    /**
     * Базовая спецификация POST ответа
     * @return {@link ResponseSpecification}
     */
    public static ResponseSpecification postResponseSpec () {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .log(LogDetail.ALL)
                .build();
    }

}
