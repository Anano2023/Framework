package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public abstract class BasePage {
    protected WebDriver driver;
    protected abstract BasePage openPage();
    protected final Duration WAIT_TIMEOUT_SECONDS= Duration.ofSeconds(15);
    protected BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    protected BasePage(){};
    protected void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void waitToClickOnElement(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }
    protected void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitVisibilityOfElement(WebElement element) {
        waitForElementToBeVisible(element);
        element.click();
    }
    protected void switchToTab(String originalWindow) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
