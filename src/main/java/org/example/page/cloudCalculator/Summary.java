package org.example.page.cloudCalculator;

import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Summary extends BasePage {
    @FindBy(linkText = "Open estimate summary")
    private WebElement openLinkEstSummary;
    @FindBy(xpath = "//div[@class='fbc2ib']/label")
    private WebElement totalPriceElement;
    @Override
    protected BasePage openPage() {
        return null;
    }
    public Summary(WebDriver driver){
        super(driver);
    }
    public String verifyTotalPrice(){

        return totalPriceElement.getText();
    }
    public void openEstSummary() {// Click the link to open the new window
        waitToClickOnElement(openLinkEstSummary);
        String originalWindow = driver.getWindowHandle();
        switchToTab(originalWindow);

    }
    public String verifyEstSummary(int position){
        String xpath= String.format("(//span[@class='Kfvdz'])[position()=%d]", position);
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.getText();
    }
}
