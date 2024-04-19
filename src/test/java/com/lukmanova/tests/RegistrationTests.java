package com.lukmanova.tests;

import com.lukmanova.model.User;
import org.junit.jupiter.api.Test;

import static com.lukmanova.spec.Specifications.requestSpec;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTests extends BaseTest {
    User user;

    @Test
    public void successfulRegistration() {
        user = new User("eve.holt@reqres.in", "pistol");

        given()
            .spec(requestSpec)
            .body(user)
            .when()
            .post("/register")
            .then()
            .statusCode(200);
    }

    @Test
    public void unsuccessfulRegistration() {
        user = new User("susie@part.com");
        String expectedErrorMessage = "Missing password";

        String actualErrorMessage = given()
            .spec(requestSpec)
            .body(user)
            .when()
            .post("/register")
            .then()
            .statusCode(400)
            .extract().body().path("error");
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
