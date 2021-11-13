package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScenarioOutlineDemo {
	WebDriver webdriver = null;
	@Given("^user navigates to Facebook$")
	public void user_navigates_to_Facebook() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String driverPath = "/Users/yangwang/Documents/Utils/chromedriver";
		System.setProperty("webdriver.chrome.driver", driverPath);
		webdriver = new ChromeDriver();
		webdriver.navigate().to("https://www.facebook.com/");
	}

	@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void i_enter_Username_as_and_Password_as(String arg1, String arg2) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		webdriver.findElement(By.id("email")).sendKeys(arg1);
		webdriver.findElement(By.id("pass")).sendKeys(arg2);
		webdriver.findElement(By.name("login")).click();
	}

	@Then("^login should be unsuccessful$")
	public void login_should_be_unsuccessful() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		if(webdriver.getCurrentUrl().equalsIgnoreCase(
				"https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Failed");
		}
	}

}
