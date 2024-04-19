package com.lukmanova.spec;

import io.restassured.specification.RequestSpecification;

import static com.lukmanova.allure.log.filter.FormattedAllureLogFilter.formattedAllureLogFilter;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class Specifications {

    public static RequestSpecification requestSpec = with()
        .basePath("/api")
        .filter(formattedAllureLogFilter().withCustomTemplates())
        .log().all()
        .contentType(JSON);
}
