package com.example.api.base;

// import io.rest-assured.RestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        // Set up base URI or any other common configurations
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
