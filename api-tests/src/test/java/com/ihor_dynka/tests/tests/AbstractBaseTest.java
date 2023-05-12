package com.ihor_dynka.tests.tests;

import com.ihor_dynka.tests.config.ITestProperties;

import lombok.Getter;
import org.aeonbits.owner.ConfigCache;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import reporter.AllureReporter;
import reporter.IReporter;
import rest_client.IRestClient;
import rest_client.RestClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.ihor_dynka.tests.config.TestProperties.APP_HOST;

@Getter
public abstract class AbstractBaseTest {

    private IRestClient restApiClient;
    private ITestProperties testProperties;
    private final IReporter reporter = new AllureReporter();
    private final Map<String, String> envInfoProperties = new HashMap<>();

    @BeforeEach
    void beforeEachTest() {
        testProperties = ConfigCache.getOrCreate(ITestProperties.class);

        restApiClient = new RestClient();
        restApiClient
                .baseConfigure()
                .setBaseUrl(APP_HOST)
                .enableRequestLogging(testProperties.loggingRequestsEnable())
                .enableResponseLogging(testProperties.loggingResponseEnable())
                .enableAllureReporting(testProperties.loggingAllureEnable())
                .enableSwaggerCoverage(testProperties.swaggerCoverageEnable());
    }

    @AfterEach
    void afterEachTest() {
        setEnvInfo("App host URL", APP_HOST);

        reporter.addEnvironmentInfo(envInfoProperties);
        restApiClient.resetConfiguration();
    }

    private void setEnvInfo(String name, String value) {
        envInfoProperties.put(name, Optional.ofNullable(value).orElse(""));
    }
}
