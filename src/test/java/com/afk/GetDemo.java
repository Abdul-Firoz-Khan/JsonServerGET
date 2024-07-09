package com.afk;

import io.restassured.RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetDemo {

    @Test
    public void getReq() {
        // Set the base URI for REST-assured
        RestAssured.baseURI = "http://localhost:3000";
        // Set the base path for REST-assured
        RestAssured.basePath = "ping";

        // Make a GET request and validate the response
        given()
                .when() // Specify that this is a GET request
                .get() // Execute the GET request
                .then() // Validate the response
                .log().all() // Log the entire response
                .statusCode(200) // Check that the status code is 200 (OK)
                .body("[0].result", equalTo("pong")); // Check that the result field of the first object in the array is "pong"
    }
}
