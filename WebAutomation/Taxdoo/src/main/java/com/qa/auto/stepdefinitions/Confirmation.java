package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.ConfirmationPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Prince Khanna
 *
 */
public class Confirmation {

	ConfirmationPage cnfrPage;

	public Confirmation(ConfirmationPage cnfrPage) {
		this.cnfrPage = cnfrPage;
	}

	@Then("I am able to navigate to confirmation screen")
	public void checkPersonalDetails() {
		cnfrPage.getConfirmationText();
	}

	@When("I accept terms and condition")
	public void validateTerms() {
		cnfrPage.clickTermsAndCondition();
	}

	@When("I click on complete button")
	public void completeBooking() {
		cnfrPage.clickBooking();
	}

	@Then("Verify Personal Data section details")
	public void validatePersonalDetails() {
		cnfrPage.validatePersonalData();
	}
}
