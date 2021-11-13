package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {
	WebDriver webdriver;
	@Given("^I am on the Guru(\\d+) homepage$")
	public void i_am_on_the_Guru_homepage(int arg1) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String driverPath = "/Users/yangwang/Documents/Utils/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
		webdriver = new ChromeDriver();
		webdriver.get("http://demo.guru99.com/");
	}

	@When("^enter blank details for Register$")
	public void enter_blank_details_for_Register() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		webdriver.findElement(By.name("emailid")).sendKeys(" ");
		webdriver.findElement(By.name("btnLogin")).click();
	}

	@Then("^error email shown$")
	public void error_email_shown() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("email is required");
	}

	@When("^enter details for Register$")
	public void enter_details_for_Register() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^login details shown$")
	public void login_details_shown() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
}
