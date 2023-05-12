package com.ihor_dynka.tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:ui_test.properties",
        "system:env"
})
public interface ITestProperties extends Config {

    @Key("browser.remote.enable")
    boolean browserRemoteEnable();

    @Key("browser.remote")
    String browserRemote();

    @Key("browser.name")
    String browserName();

    @Key("browser.size")
    String browserSize();

    @Key("browser.headless")
    boolean browserHeadless();

    @Key("browser.driver.manager.enable")
    boolean browserDriverManagerEnabled();

    @Key("allure.report.enable")
    boolean allureReportEnable();

    @Key("browser.driver.timeout")
    long browserDriverTimeout();

    @Key("logging.request.enable")
    boolean loggingRequestEnable();

    @Key("logging.response.enable")
    boolean loggingResponseEnable();
}
