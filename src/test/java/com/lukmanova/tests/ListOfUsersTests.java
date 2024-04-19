package com.lukmanova.tests;

import org.junit.jupiter.api.Test;

import static com.lukmanova.spec.Specifications.requestSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ListOfUsersTests extends BaseTest {

    @Test
    public void getUsersListMatchesSchema() {
        given()
            .spec(requestSpec)
            .when()
            .get("/users?page=2")
            .then()
            .log().body()
            .body(matchesJsonSchemaInClasspath("schema/ListOfUsersSchema.json"))
            .statusCode(200);
    }
}
