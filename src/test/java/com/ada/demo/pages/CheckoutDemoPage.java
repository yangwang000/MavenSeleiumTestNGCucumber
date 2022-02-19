package com.ada.demo.pages;

import com.ada.demo.base.BaseDemoPage;
import com.ada.demo.dataObjects.BillingAddress;
import com.ada.demo.dataObjects.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutDemoPage extends BaseDemoPage {
    private final By firstnameFld = By.id("billing_first_name");
    private final By lastNameFld = By.id("billing_last_name");
    private final By addressLineOneFld = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostCodeFld = By.id("billing_postcode");
    private final By billingEmailFld = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");

    private final By clickHereToLoginLink = By.className("showlogin");
    private final By usernameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    private final By countryDropDown = By.id("billing_country");
    private final By stateDropDown = By.id("billing_state");

    private final By alternateCountryDropDown = By.id("select2-billing_country-container");
    private final By alternateStateDropDown = By.id("select2-billing_state-container");

    private final By directBankTransferRadioBtn = By.id("payment_method_bacs");

    private final By productName = By.cssSelector("td[class='product-name']");

    public CheckoutDemoPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutDemoPage load(){
        load("/checkout/");
        return this;
    }

    public CheckoutDemoPage enterFirstName(String firstName){
        WebElement e = waitShort.until(ExpectedConditions.visibilityOfElementLocated(firstnameFld));
        e.clear();
        e.sendKeys(firstName);
        return this;
    }

    public CheckoutDemoPage enterLastName(String lastName){
        WebElement e = waitShort.until(ExpectedConditions.visibilityOfElementLocated(lastNameFld));
        e.clear();
        e.sendKeys(lastName);
        return this;
    }

    public CheckoutDemoPage selectCountry(String countryName) {
/*        Select select = new Select(driver.findElement(countryDropDown));
        select.selectByVisibleText(countryName);*/
        waitShort.until(ExpectedConditions.elementToBeClickable(alternateCountryDropDown)).click();
        WebElement e = waitShort.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + countryName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }

    public CheckoutDemoPage enterAddressLineOne(String addressLineOne){
        WebElement e = waitShort.until(ExpectedConditions.visibilityOfElementLocated(addressLineOneFld));
        e.clear();
        e.sendKeys(addressLineOne);
        return this;
    }

    public CheckoutDemoPage enterCity(String city){
        WebElement e = waitShort.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld));
        e.clear();
        e.sendKeys(city);
        return this;
    }

    public CheckoutDemoPage selectState(String stateName){
/*        Select select = new Select(driver.findElement(stateDropDown));
        select.selectByVisibleText(stateName);*/
        waitShort.until(ExpectedConditions.elementToBeClickable(alternateStateDropDown)).click();
        WebElement e = waitShort.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + stateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }

    public CheckoutDemoPage enterPostCode(String postCode){
        WebElement e = waitShort.until(ExpectedConditions.visibilityOfElementLocated(billingPostCodeFld));
        e.clear();
        e.sendKeys(postCode);
        return this;
    }

    public CheckoutDemoPage enterEmail(String email){
        WebElement e = waitShort.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld));
        e.clear();
        e.sendKeys(email);
        return this;
    }

    public CheckoutDemoPage setBillingAddress(BillingAddress billingAddress) throws InterruptedException {
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                selectCountry(billingAddress.getCountry()).
                enterAddressLineOne(billingAddress.getStreetAddress()).
                enterCity(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                enterPostCode(billingAddress.getZipCode()).
                enterEmail(billingAddress.getEmail());
    }

    public CheckoutDemoPage placeOrder(){
        waitForOverlaysToDisappear(overlay);
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
        return waitShort.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
    }

    public CheckoutDemoPage clickHereToLoginLink(){
        waitShort.until(ExpectedConditions.elementToBeClickable(clickHereToLoginLink)).click();
        return this;
    }

    public CheckoutDemoPage enterUserName(String username){
        waitShort.until(ExpectedConditions.visibilityOfElementLocated(usernameFld)).sendKeys(username);
        return this;
    }

    public CheckoutDemoPage enterPassword(String password){
        waitShort.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).sendKeys(password);
        return this;
    }

    public CheckoutDemoPage clickLoginBtn(){
        waitShort.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        return this;
    }

    private CheckoutDemoPage waitForLoginBtnToDisappear(){
        waitShort.until(ExpectedConditions.invisibilityOfElementLocated(loginBtn));
        return this;
    }

    public CheckoutDemoPage login(User user){
        return enterUserName(user.getUsername()).
                enterPassword(user.getPassword()).
                clickLoginBtn().waitForLoginBtnToDisappear();
    }

    public CheckoutDemoPage selectDirectBankTransfer(){
        WebElement e = waitShort.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
        if(!e.isSelected()){
            e.click();
        }
        return this;
    }

    public String getProductName() throws Exception {
        int i = 5;
        while(i > 0){
            try {
                return waitShort.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
            }catch (StaleElementReferenceException e){
                System.out.println("NOT FOUND. TRYING AGAIN" + e);
            }
            Thread.sleep(5000);
            i--;
        }
        throw new Exception("Element not found");
    }
}
