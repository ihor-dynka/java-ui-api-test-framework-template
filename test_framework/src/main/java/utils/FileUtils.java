package utils;

import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public final class FileUtils {

    private FileUtils() {
    }

    public static String readFileFromResources(String filename) throws IOException {
        return IOUtils.resourceToString(filename, StandardCharsets.UTF_8);
    }

    public static void writeToPropertyFile(String file, Properties props, String comments) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            props.store(fileOutputStream, comments);
        } finally {
            assert fileOutputStream != null;
            fileOutputStream.close();
        }
    }
}
