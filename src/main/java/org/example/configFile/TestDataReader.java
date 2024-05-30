package org.example.configFile;
import java.util.ResourceBundle;

    public class TestDataReader {
        private static final String ENVIRONMENT_PROPERTY = "env";
        private static ResourceBundle resourceBundle;
        static {
            String environment = System.getProperty(ENVIRONMENT_PROPERTY, "dev");
            resourceBundle = ResourceBundle.getBundle(environment);
        }
        public static String getProperty(String key) {
            return resourceBundle.getString(key);
        }
        public static boolean shouldMaximizeBrowser() {
            String maximize = resourceBundle.getString("browser.maximize");
            return Boolean.parseBoolean(maximize);
        }
    }

