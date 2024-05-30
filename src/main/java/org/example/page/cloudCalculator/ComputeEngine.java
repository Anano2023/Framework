package org.example.page.cloudCalculator;

import org.example.configFile.TestDataReader;
import org.example.page.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputeEngine extends BasePage {
    private String url;
    @FindBy(className = "YSM5S")
    private WebElement searchButton;
    @FindBy(className = "qdOxv-fmcmS-wGMbrd")
    private WebElement searchInput;
    @FindBy(css = ".PETVs-OWXEXe-UbuQg")
    private WebElement searchSubmitButton;
    @FindBy(xpath = "//a[@href='https://cloud.google.com/products/calculator']")
    private WebElement pricingCalculatorLink;
    @FindBy(xpath = "//button[@data-idom-class='xhASFc']")
    private WebElement addToEstimateButton;
    @FindBy(className = "aHij0b-aGsRMb")
    private WebElement computeEngineButton;
    @FindBy(xpath ="//div[div[text() = 'Number of Instances']]/following-sibling::div//input")
    private WebElement numOfInstances;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=4]")
    private WebElement selectDropdownSystemList;
    @FindBy(xpath ="//span[text() = 'Operating System / Software']/ancestor::div[1]")
    private WebElement operatingSystem;
    @FindBy(xpath = "//label[@for='regular']")
    private WebElement modelRegular;
    @FindBy(xpath = "(//div[@jsname='wSASue']/div/div)[position()=5]")
    private WebElement mFamily;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=5]")
    private WebElement chooseGeneralPurpose;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=6]")
    private WebElement seriesDropdown;
    @FindBy(xpath = "//span[text() = 'Series']/ancestor::div[1]")
    //"//ul[@aria-label='Series']/li[span[contains(., 'N1')]]")
    private WebElement chooseSeries;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=7]")
    private WebElement machineType;
    @FindBy(xpath ="//ul[@aria-label='Machine type']/li[span[contains(., 'n1-standard-8')]]")
    //"//span[text() = 'Machine type']/ancestor::div[1]"
    private WebElement chooseMachineType;
    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement gpuBtn;
    @FindBy(xpath = "//div[@data-field-type='158']")
    private WebElement gpuModel;
    @FindBy(xpath = "//li[span[contains(., 'NVIDIA V100')]]")
    private WebElement nvidiaV100;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[position()=9]")
    private WebElement gpuNumberDropdown;
    @FindBy(xpath = "//ul[@aria-label='Number of GPUs']//li[span[contains(.,'1')]]")
    private WebElement chooseGpuNumber;
    @FindBy(xpath = "(//div[@jsname='oYxtQd']/div[@class='VfPpkd-aPP78e'])[position()=10]")
    private WebElement ssd;
    @FindBy(xpath = "//ul[@aria-label='Local SSD']//li[span[contains(.,'2x375 GB')]]")
    private WebElement ssdOption;
    @FindBy(xpath = "//label[@for='1-year']")
    private WebElement usage;
    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    private WebElement shareButton;

    public ComputeEngine(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.url = TestDataReader.getProperty("url");
    }
    public ComputeEngine searchText(String text){
        searchButton.click();
        searchInput.sendKeys(text);
        searchSubmitButton.click();
        Actions actions = new Actions(driver);
        int xCoordinate = 100; // Example x-coordinate
        int yCoordinate = 200; // Example y-coordinate
        actions.moveByOffset(xCoordinate, yCoordinate).click().perform();
        return this;
    }

    public ComputeEngine clickOnPricingCalcLink(){
        waitToClickOnElement(pricingCalculatorLink);
        return this;
    }

    public ComputeEngine clickOnAddToEstimateBtn() {
        waitToClickOnElement(addToEstimateButton);
        return this;
    }

    public ComputeEngine clickOnComputeEngine(){
        waitToClickOnElement(computeEngineButton);
        return this;
    }

    public ComputeEngine numberOfInstances(String value) {
        waitToClickOnElement(numOfInstances);
        numOfInstances.clear();
        numOfInstances.sendKeys(value);
        return this;
    }

    public ComputeEngine selectDropdownSystem(String value) {
        waitToClickOnElement(selectDropdownSystemList);
        selectDropdownSystemList.click();
        waitToClickOnElement(operatingSystem);
        operatingSystem.click();
        return this;
    }

    public ComputeEngine provisioningModel() {
        waitToClickOnElement(modelRegular);
        modelRegular.click();
        return this;
    }

    public ComputeEngine machineType(String seriesValue, String typeValue) {
        waitToClickOnElement(mFamily);
        waitToClickOnElement(chooseGeneralPurpose);
        seriesDropdown.click();
        waitToClickOnElement(chooseSeries);
        machineType.click();
        waitToClickOnElement(chooseMachineType);
        return this;
    }

    public ComputeEngine addGpus(String gpuType, String gpuCount) {
        waitToClickOnElement(gpuBtn);
        waitToClickOnElement(gpuModel);
        waitToClickOnElement(nvidiaV100);
        gpuNumberDropdown.click();
        waitToClickOnElement(chooseGpuNumber);
        ssd.click();
        waitToClickOnElement(ssdOption);
        usage.click();
        return this;
    }

    public ComputeEngine shareEstimateBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 150)");
        js.executeScript("arguments[0].click();", shareButton);
        waitVisibilityOfElement(shareButton);
        return this;
    }

    @Override
    public BasePage openPage() {
        driver.get(url);
        return this;
    }
}
