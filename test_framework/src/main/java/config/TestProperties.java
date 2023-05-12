package config;

import org.aeonbits.owner.ConfigCache;

public final class TestProperties {
    public static final ITestProperties TEST_PROPERTIES = ConfigCache.getOrCreate(ITestProperties.class);
    public static final boolean TESTS_WITH_BREAKING_CHANGES_ENABLED = TEST_PROPERTIES.isTestsWithBreakingChangesEnabled();

    private TestProperties() {
    }
}
