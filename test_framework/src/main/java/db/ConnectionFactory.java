package db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import lombok.SneakyThrows;

public final class ConnectionFactory {

    private static final String DATABASE_PROPERTIES_FILENAME = "ess_database.properties";
    private static final String DATABASE_URL_PROPERTY = "url";

    private final Properties databaseProperties;
    private final String url;

    @SneakyThrows
    private ConnectionFactory() {
        databaseProperties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(DATABASE_PROPERTIES_FILENAME);
        databaseProperties.load(inputStream);
        url = databaseProperties.getProperty(DATABASE_URL_PROPERTY);
    }

    @SneakyThrows
    public Connection getConnection() {
        return DriverManager.getConnection(url, databaseProperties);
    }

    public static ConnectionFactory getInstance() {
        return ConnectionFactoryHolder.INSTANCE;
    }

    private static class ConnectionFactoryHolder {
        private static final ConnectionFactory INSTANCE = new ConnectionFactory();
    }

}
