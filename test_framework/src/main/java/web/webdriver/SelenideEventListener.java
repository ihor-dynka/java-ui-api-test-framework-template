package web.webdriver;

import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import logger.ILogger;
import logger.TestLogger;

public class SelenideEventListener implements LogEventListener {

    private static final ILogger logger = new TestLogger();

    @Override
    public void afterEvent(LogEvent currentLog) {
        logger.info(String.format("Duration --> %dms; Status --> %s", currentLog.getDuration(), currentLog.getStatus()));
    }

    @Override
    public void beforeEvent(LogEvent currentLog) {
        logger.info(currentLog.getElement() + " --> " + currentLog.getSubject());
    }
}
