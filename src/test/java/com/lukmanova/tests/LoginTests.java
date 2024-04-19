package com.lukmanova.tests;

import com.lukmanova.model.User;
import org.junit.jupiter.api.Test;

import static com.lukmanova.spec.Specifications.requestSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTests extends BaseTest {

    User user;

    @Test
    public void successfulLogin() {
        user = new User("eve.holt@reqres.in", "cityslicka");
        given()
            .spec(requestSpec)
            .body(user)
            .when()
            .post("/login")
            .then()
            .statusCode(200);
    }

    @Test
    public void unsuccessfulLoginWithEmptyPassword() {
        user = new User("eve.holt@reqres.in");
        given().spec(requestSpec)
            .body(user)
            .when()
            .post("/login")
            .then()
            .statusCode(400);
    }

    @Test
    public void tokenGrantedAfterSuccessfulLogin() {
        user = new User("eve.holt@reqres.in", "pistol");
        String token = given()
            .spec(requestSpec)
            .body(user)
            .when()
            .post("/login")
            .then()
            .extract().body().path("token");

        assertThat(token).isNotEmpty();
    }
}
