package com.ihor_dynka.tests.config;

import org.aeonbits.owner.ConfigCache;

public final class TestProperties {
    public static final ITestProperties TEST_PROPERTIES = ConfigCache.getOrCreate(ITestProperties.class);
    public static final String APP_HOST = TEST_PROPERTIES.appHost();

    private TestProperties() {
    }
}
