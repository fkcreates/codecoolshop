package com.codecool.shop.dao.implementation.mem;

import javax.servlet.ServletContext;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

    private static Properties prop = null;
    private static final String FILE_NAME = "/connection.properties";


    public static void loadPropertiesFile(ServletContext servletContext) {
        try {
            Properties prop = new Properties();
            InputStream in = servletContext.getResourceAsStream(FILE_NAME);
            prop.load(in);
            in.close();
            ConnectionHandler.prop = prop;
        }
        catch (Exception e) {
            System.err.println("Couldn't read properties file: " + FILE_NAME);
            System.exit(1);
        }
    }

    public static Connection getConnection() throws SQLException {
        String DB_USER = prop.getProperty("user");
        String DB_PASSWORD = prop.getProperty("password");
        String DATABASE = prop.getProperty("database");

        return DriverManager.getConnection(DATABASE, DB_USER, DB_PASSWORD);
    }

}
