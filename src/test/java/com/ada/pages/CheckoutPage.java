package com.ada.pages;

import com.ada.base.BasePage;
import com.ada.objects.BillingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {
	private final By firstNameFld = By.id("billing_first_name");
	private final By lastNameFld = By.cssSelector("#billing_last_name");
	private final By countryFld = By.cssSelector("#select2-billing_country-container");
	private final By streetAddressFld = By.id("billing_address_1");
	private final By cityFld = By.id("billing_city");
	private final By stateFld = By.id("select2-billing_state-container");
	private final By zipCodeFld = By.id("billing_postcode");
	private final By emailFld = By.id("billing_email");
	private final By placeOrderBtn = By.id("place_order");
	private final By successNotice = By.cssSelector(".woocommerce-notice");
	private final By overlay = By.cssSelector(".blockUI.blockOverlay");
	private final By countryDropDown = By.id("billing_country");
	private final By stateDropDown = By.id("billing_state");
	private final By alternateCountryDropDown = By.id("select2-billing_country-container");
	private final By alternateStateDropDown = By.id("select2-billing_state-container");

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public CheckoutPage enterFirstName(String txt){
		WebElement e = waitForElementToBeVisible(firstNameFld);
		e.clear();
		e.sendKeys(txt);
		return this;
	}

	public CheckoutPage enterLastName(String txt){
		driver.findElement(lastNameFld).clear();
		driver.findElement(lastNameFld).sendKeys(txt);
		return this;
	}

	public CheckoutPage enterCounty(String txt){
		driver.findElement(countryFld).clear();
		driver.findElement(countryFld).sendKeys(txt);
		return this;
	}

	public CheckoutPage enterAddress(String txt){
		driver.findElement(streetAddressFld).clear();
		driver.findElement(streetAddressFld).sendKeys(txt);
		return this;
	}

	public CheckoutPage enterCity(String txt){
		driver.findElement(cityFld).clear();
		driver.findElement(cityFld).sendKeys(txt);
		return this;
	}

	public CheckoutPage enterState(String txt){
		driver.findElement(stateFld).clear();
		driver.findElement(stateFld).sendKeys(txt);
		return this;
	}

	public CheckoutPage enterZipCode(String txt){
		driver.findElement(zipCodeFld).clear();
		driver.findElement(zipCodeFld).sendKeys(txt);
		return this;
	}

	public CheckoutPage enterEmail(String txt){
		driver.findElement(emailFld).clear();
		driver.findElement(emailFld).sendKeys(txt);
		return this;
	}

	public CheckoutPage clickPlaceOrderBtn(){
		waitForOverlaysToDisappear(overlay);
		driver.findElement(placeOrderBtn).click();
		return this;
	}

	public String getNotice(){
		return driver.findElement(successNotice).getText();
	}

	public CheckoutPage setBillingAddress(BillingAddress billingAddress){
		return enterFirstName(billingAddress.getFirstName())
				.enterLastName(billingAddress.getLastName())
				.selectCountry(billingAddress.getCountry())
				.enterAddress(billingAddress.getStreetAddress())
				.enterCity(billingAddress.getCity())
				.selectState(billingAddress.getState())
				.enterZipCode(billingAddress.getZipCode())
				.enterEmail(billingAddress.getEmail());
	}

	public CheckoutPage selectCountry(String countryName){
//		Select select = new Select(driver.findElement(countryDropDown));
//		select.selectByVisibleText(countryName);
		waitShort.until(ExpectedConditions.elementToBeClickable(alternateCountryDropDown)).click();
		WebElement e = waitShort.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//li[text()='" + countryName + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		e.click();
		return this;
	}

	public CheckoutPage selectState(String stateName){
//		Select select = new Select(driver.findElement(stateDropDown));
//		select.selectByVisibleText(stateName);
		waitShort.until(ExpectedConditions.elementToBeClickable(alternateStateDropDown)).click();
		WebElement e = waitShort.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//li[text()='" + stateName + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		e.click();
		return this;
	}
}
