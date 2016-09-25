package ua.artcode.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by serhii on 9/25/16.
 */
public class PropertiesHolder {

    private static Properties properties = load();

    private static Properties load() {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesHolder.class.getResourceAsStream("/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
