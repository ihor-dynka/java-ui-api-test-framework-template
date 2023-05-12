package reporter;

import java.util.Map;

public interface IReporter {
    void startStep(String message);

    void endStep(String message, StepStatus status);

    void addAttachment(String name, String type, String fileExtension, byte[] inputStream);

    void addEnvironmentInfo(Map<String, String> map);

    void enableBrowserAttachments();
}
