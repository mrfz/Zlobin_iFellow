package ru.iFellow.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;


public class Specifications {

    public static RequestSpecification baseRequestSpec (String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/json")
                .log(LogDetail.URI)
                .build();
    };

    public static ResponseSpecification baseResponseSpec () {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .log(LogDetail.BODY)
                .build();
    };

}
