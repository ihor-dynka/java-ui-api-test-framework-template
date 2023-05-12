package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public final class StringUtils {

    public static String getRandomString(int count){
        return RandomStringUtils.randomAlphabetic(count);
    }

    public static String getRandomNumericString(int count){
        return RandomStringUtils.randomNumeric(count);
    }

    public static int getRandomNumeric() {
        return RandomUtils.nextInt(1, 999999);
    }

    private StringUtils(){}
}
