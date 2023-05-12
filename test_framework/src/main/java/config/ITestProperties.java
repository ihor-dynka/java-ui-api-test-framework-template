package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:api_test.properties",
        "system:env"
})
public interface ITestProperties extends Config {

    @DefaultValue("false")
    @Key("testsWithBreakingChanges.enabled")
    boolean isTestsWithBreakingChangesEnabled();
}
