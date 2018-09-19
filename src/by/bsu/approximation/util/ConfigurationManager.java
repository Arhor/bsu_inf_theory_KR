package by.bsu.approximation.util;

import java.util.ResourceBundle;

public class ConfigurationManager {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");

    private ConfigurationManager(){}

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
