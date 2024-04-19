package com.lukmanova.tests;

import com.lukmanova.model.PantoneColor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.lukmanova.spec.Specifications.requestSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PantoneColorColorTests extends BaseTest {

    @Test
    public void pantoneColorsListContainsTigerlily() {
        PantoneColor tigerlilly = new PantoneColor(
            5, "tigerlily", 2004, "#E2583E", "17-1456");
        List<PantoneColor> pantoneColors = new ArrayList<>();

        pantoneColors =
            given()
                .spec(requestSpec)
                .when()
                .get("/unknown")
                .then()
                .extract().body().jsonPath().getList("data", PantoneColor.class);

        assertThat(pantoneColors.contains(tigerlilly));
    }
}
