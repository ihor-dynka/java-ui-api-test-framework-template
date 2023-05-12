package com.ihor_dynka.tests.config;

import org.aeonbits.owner.ConfigCache;

public final class TestProperties {

    private static final ITestProperties TEST_PROPERTIES = ConfigCache.getOrCreate(ITestProperties.class);

    public static final boolean BROWSER_REMOTE_ENABLE = TEST_PROPERTIES.browserRemoteEnable();
    public static final String BROWSER_REMOTE = TEST_PROPERTIES.browserRemote();
    public static final String BROWSER_NAME = TEST_PROPERTIES.browserName();
    public static final String BROWSER_SIZE = TEST_PROPERTIES.browserSize();
    public static final boolean BROWSER_HEADLESS = TEST_PROPERTIES.browserHeadless();
    public static final boolean BROWSER_DRIVER_MANAGER_ENABLE = TEST_PROPERTIES.browserDriverManagerEnabled();
    public static final boolean ALLURE_REPORT_ENABLE = TEST_PROPERTIES.allureReportEnable();
    public static final long BROWSER_DRIVER_TIMEOUT = TEST_PROPERTIES.browserDriverTimeout();
    public static final boolean LOGGING_REQUEST_ENABLE = TEST_PROPERTIES.loggingRequestEnable();
    public static final boolean LOGGING_RESPONSE_ENABLE = TEST_PROPERTIES.loggingResponseEnable();

    private TestProperties() {
    }
}
