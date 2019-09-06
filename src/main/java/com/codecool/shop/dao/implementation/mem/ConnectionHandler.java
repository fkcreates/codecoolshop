package com.codecool.shop.dao.implementation.mem;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

    private static Properties prop = loadPropertiesFile();
    private static final String FILE_NAME = "/Users/fruzsinakiss/Desktop/OOP/TW/TW_4/webshop-java-techiteasy/src/main/webapp/connection.properties";


    public static Properties loadPropertiesFile() {
        try {
            Properties prop = new Properties();
            InputStream in = new FileInputStream(FILE_NAME);
            prop.load(in);
            in.close();
            return prop;
        }
        catch (Exception e) {
            System.err.println("Couldn't read properties file: " + FILE_NAME);
            System.exit(1);
        }

        return null;
    }

    public static Connection getConnection() throws SQLException {
        String DB_USER = prop.getProperty("username");
        String DB_PASSWORD = prop.getProperty("password");
        String DATABASE = prop.getProperty("database");

        return DriverManager.getConnection(DATABASE, DB_USER, DB_PASSWORD);
    }

}
