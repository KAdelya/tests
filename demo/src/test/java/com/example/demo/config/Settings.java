package com.example.demo.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Settings {
//     TODO: изменить путь
    public static String file = "C:\\Users\\Home\\IdeaProjects\\demo\\Settings.xml";

    private static final Properties properties;
//    private static String baseUrl;
    private static String username;
    private static String password;
//    private static String path;

    static {
        try (FileInputStream fis = new FileInputStream(file)) {
            properties = new Properties();
            properties.loadFromXML(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static String getBaseUrl() {
//        if (baseUrl == null) {
//            baseUrl = properties.getProperty("BaseUrl");
//        }
//        return baseUrl;
//    }

    public static String getLogin() {
        if (username == null) {
            username = properties.getProperty("username");
        }
        return username;
    }

    public static String getPassword() {
        if (password == null) {
            password = properties.getProperty("password");
        }
        return password;
    }

//    public static String getPath() {
//        if (path == null) {
//            path = properties.getProperty("Path");
//        }
//        return path;
//    }
}
