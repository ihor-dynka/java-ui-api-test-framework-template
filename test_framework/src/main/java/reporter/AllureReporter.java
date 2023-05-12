package reporter;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import lombok.SneakyThrows;
import utils.FileUtils;

import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;

public class AllureReporter implements IReporter {

    private String uuid;
    private AllureLifecycle lifecycle;

    @Override
    public void startStep(String message) {
        uuid = getUuid();
        lifecycle = Allure.getLifecycle();
        lifecycle.startStep(uuid, new StepResult().setName(message));
    }

    @Override
    public void endStep(String message, StepStatus status) {
        lifecycle.getCurrentTestCaseOrStep().ifPresent(parentUuid -> {
            if (status == StepStatus.PASSED) {
                lifecycle.updateStep(step -> step.setStatus(Status.PASSED));
            } else {
                lifecycle.updateStep(step -> step.setStatus(Status.FAILED));
            }
        });

        lifecycle.stopStep(uuid);
    }

    @Override
    public void addAttachment(String name, String type, String fileExtension, byte[] inputStream) {
        lifecycle.addAttachment(name, type, fileExtension, inputStream);
    }

    @SneakyThrows
    @Override
    public void addEnvironmentInfo(Map<String, String> map) {
        Properties props = new Properties();
        map.forEach(props::setProperty);
        String file = System.getProperty("allure.results.directory") + "/environment.properties";
        FileUtils.writeToPropertyFile(file, props, null);
    }

    @Override
    public void enableBrowserAttachments() {
        SelenideLogger.addListener("Allure Selenide", new AllureSelenide()
                .enableLogs(LogType.BROWSER, Level.INFO)
                .includeSelenideSteps(true)
                .savePageSource(false)
                .screenshots(true));
    }

    private String getUuid() {
        return UUID.randomUUID().toString();
    }
}
