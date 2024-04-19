package com.lukmanova.allure.log.filter;

import io.qameta.allure.restassured.AllureRestAssured;

public class FormattedAllureLogFilter {

    private static final AllureRestAssured FILTER = new AllureRestAssured();

    private FormattedAllureLogFilter() {
    }

    public static FormattedAllureLogFilter formattedAllureLogFilter() {
        return InitializeLogFilter.logFilter;
    }

    public AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");
        return FILTER;
    }

    private static class InitializeLogFilter {
        private static final FormattedAllureLogFilter logFilter = new FormattedAllureLogFilter();
    }
}
