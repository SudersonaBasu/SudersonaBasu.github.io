package com.example.api.utils;

import io.restassured.response.Response;
import org.testng.Assert;


public class ResponseUtils {

    public static void validateStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code validation failed");
    }

    public static void validateResponseBodyNotNull(Response response) {
        Assert.assertNotNull(response.getBody().asString(), "Response body is null");
    }
}
