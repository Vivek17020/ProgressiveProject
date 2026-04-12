package com.edutech.progressive.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    // Stores database configuration loaded from properties file
    private static final Properties properties = new Properties();

    // Static block ensures properties are loaded once when the class is loaded
    static {
        loadProperties();
    }

    /**
     * Loads database configuration from application.properties
     */
    private static void loadProperties() {
        try (InputStream inputStream =
                     DatabaseConnectionManager.class
                             .getClassLoader()
                             .getResourceAsStream("application.properties")) {

            if (inputStream == null) {
                throw new RuntimeException("application.properties file not found in classpath");
            }

            properties.load(inputStream);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load database properties", e);
        }
    }

    /**
     * Returns a JDBC connection using the loaded properties
     *
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }
}





