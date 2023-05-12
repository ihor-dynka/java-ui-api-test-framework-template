package logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestLogger implements ILogger {

    @Override
    public void info(String message) {
        log.info(message);
    }

    @Override
    public void error(String message, Throwable exception) {
        log.error(message, exception);
    }

    @Override
    public void warn(String message) {
        log.warn(message);
    }

    @Override
    public void debug(String message) {
        log.debug(message);
    }
}
