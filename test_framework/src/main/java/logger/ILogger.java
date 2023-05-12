package logger;

public interface ILogger {
    void info(String message);

    void error(String message, Throwable e);

    void warn(String message);

    void debug(String message);
}
