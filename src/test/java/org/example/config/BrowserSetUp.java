package org.example.config;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BrowserSetUp {
    protected WebDriver driver;

    @Parameters("env")
    @BeforeMethod
    public void setUp(){
        driver= DriverSingleton.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverSingleton.closeBrowser();
    }
}
