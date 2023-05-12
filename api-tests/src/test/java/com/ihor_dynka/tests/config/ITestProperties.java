package com.ihor_dynka.tests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:env",
        "classpath:api_test.properties"
})
public interface ITestProperties extends Config {

    @Key("logging.requests.enable")
    boolean loggingRequestsEnable();

    @Key("logging.response.enable")
    boolean loggingResponseEnable();

    @Key("logging.allure.enable")
    boolean loggingAllureEnable();

    @Key("swagger.coverage.enable")
    boolean swaggerCoverageEnable();

    @Key("app.host.url")
    String appHost();
}