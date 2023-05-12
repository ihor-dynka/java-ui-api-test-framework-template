package reporter;

import utils.FileUtils;

import java.io.IOException;
import java.util.Properties;

public final class EnvironmentInfo {

	private EnvironmentInfo() {
	}

	public static void main(String[] args) throws IOException {
		FileUtils.writeToPropertyFile(System.getProperty("allure.results.directory") + "environment.properties", new Properties(), null);
	}
}
