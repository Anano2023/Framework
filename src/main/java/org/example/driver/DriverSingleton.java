package org.example.driver;

import org.example.configFile.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSingleton {
    private static WebDriver driver;
    private DriverSingleton(){}

    public static WebDriver getDriver() {
            if (driver == null) {
                String browser = TestDataReader.getProperty("browser");

                switch (browser.toLowerCase()) {
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + browser);
                }

            if (TestDataReader.shouldMaximizeBrowser()) {
                driver.manage().window().maximize();
            }
        }
        return driver;
    }
    public static void closeBrowser(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
