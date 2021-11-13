package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.bs.I;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Multiplication {
	int a, b, multiplication;
	@Given("^I have variable a$")
	public void i_have_variable_a() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		a = 50;
	}

	@Given("^I have variable b$")
	public void i_have_variable_b() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		b = 70;
	}

	@When("^I multiplication a and b$")
	public void i_multiplication_a_and_b() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		multiplication = a * b;
	}

	@Then("^I display the Result$")
	public void i_display_the_Result() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Multiplication " + Integer.toString(a) + " and " + Integer.toString(b) + " is " + Integer.toString(multiplication));
	}

}
