package com.codecool.shop.dao.implementation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionHandler {

    public static Properties loadPropertiesFile() throws Exception {
        Properties prop = new Properties();
        InputStream in = new FileInputStream("/Users/fruzsinakiss/Desktop/OOP/TW/TW_4/webshop-java-techiteasy/src/main/webapp/connection.properties");
        prop.load(in);
        in.close();
        return prop;
    }

    public static Connection getConnection() throws Exception {
        Properties prop = loadPropertiesFile();

        String DB_USER = prop.getProperty("username");
        String DB_PASSWORD = prop.getProperty("password");
        String DATABASE = prop.getProperty("database");

        return DriverManager.getConnection(DATABASE, DB_USER, DB_PASSWORD);
    }

}
