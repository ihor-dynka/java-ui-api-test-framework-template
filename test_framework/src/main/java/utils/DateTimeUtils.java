package utils;

import java.time.LocalDate;

public final class DateTimeUtils {

    public static String getCurrentDate() {
        return LocalDate.now().toString();
    }

    private DateTimeUtils() {
    }
}
