package org.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener  implements ITestListener {
    private WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed! Taking screenshot...");
        captureScreenshot(result.getMethod().getMethodName());
    }
    private void captureScreenshot(String methodName) {
        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "screenshots/" + methodName + "_" + getDateTimeString() + ".png";
            try {
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                System.out.println("Screenshot captured: " + screenshotPath);
            } catch (IOException e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }

    private String getDateTimeString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return now.format(formatter);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
