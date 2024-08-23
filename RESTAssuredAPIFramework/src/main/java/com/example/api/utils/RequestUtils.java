package com.example.api.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;

public class RequestUtils {

    private static final String BASE_URI = "https://jsonplaceholder.typicode.com";

    private static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType("application/json")
                .build();
    }

    public static Response get(String endpoint) {
        return RestAssured.given()
                .spec(getRequestSpecification())
                .when()
                .get(endpoint);
    }

    public static Response post(String endpoint, String body) {
        return RestAssured.given()
                .spec(getRequestSpecification())
                .body(body)
                .when()
                .post(endpoint);
    }

    public static Response patch(String endpoint, String body) {
        return RestAssured.given()
                .spec(getRequestSpecification())
                .body(body)
                .when()
                .patch(endpoint);
    }

    public static Response delete(String endpoint) {
        return RestAssured.given()
                .spec(getRequestSpecification())
                .when()
                .delete(endpoint);
    }
}
