package com.ihor_dynka.tests.tests;

import logger.ILogger;
import logger.TestLogger;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import reporter.AllureReporter;
import reporter.IReporter;
import web.webdriver.IWebdriver;
import web.webdriver.SelenideDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.ihor_dynka.tests.config.TestProperties.BROWSER_REMOTE;
import static com.ihor_dynka.tests.config.TestProperties.BROWSER_REMOTE_ENABLE;
import static com.ihor_dynka.tests.config.TestProperties.BROWSER_NAME;
import static com.ihor_dynka.tests.config.TestProperties.BROWSER_SIZE;
import static com.ihor_dynka.tests.config.TestProperties.BROWSER_DRIVER_TIMEOUT;
import static com.ihor_dynka.tests.config.TestProperties.BROWSER_HEADLESS;
import static com.ihor_dynka.tests.config.TestProperties.BROWSER_DRIVER_MANAGER_ENABLE;

@Getter
public abstract class AbstractBaseTest {

    private final IWebdriver webdriver = new SelenideDriver();
    private final Map<String, String> map = new HashMap<>();
    private final ILogger logger = new TestLogger();
    private final IReporter reporter = new AllureReporter();

    @BeforeEach
    void beforeEachTest() {
        webdriver.setBrowser(BROWSER_NAME)
                .setBrowserSize(BROWSER_SIZE)
                .setTimeout(BROWSER_DRIVER_TIMEOUT)
                .setDownloadFilePath("build/selenide/downloads/")
                .logDriverEvents(true);

        if (BROWSER_REMOTE_ENABLE) {
            webdriver.setRemoteUrl(BROWSER_REMOTE);
        } else {
            webdriver.setHeadlessMode(BROWSER_HEADLESS);
            webdriver.setDriverManagerEnabled(BROWSER_DRIVER_MANAGER_ENABLE);
        }

        reporter.enableBrowserAttachments();
    }

    @AfterEach
    void afterEachTest() {
        set("OS name", System.getProperty("os.name"));
        set("OS version", System.getProperty("os.name"));
        set("Browser name", BROWSER_NAME);
        set("Browser version", getWebdriver().getBrowserSize());
        set("Browser size", getWebdriver().getBrowserVersion());

        reporter.addEnvironmentInfo(map);
        webdriver.closeWebdriver();
    }

    private void set(String name, String value) {
        map.put(name, Optional.ofNullable(value).orElse(""));
    }
}
