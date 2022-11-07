package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.PersonalPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Prince Khanna
 *
 */
public class Personal {

	PersonalPage personalPage;

	public Personal(PersonalPage personalPage) {
		this.personalPage = personalPage;
	}

	@Then("I am able to navigate to Personal screen")
	public void checkPersonalScreenDetails() {
		personalPage.getPersonalDataText();
	}

	@When("I click on next button on Person page")
	public void nextButton() {
		personalPage.clickNext();
	}

	@When("I fill in the personal details")
	public void completePersonalDetails() {
		personalPage.fillPersonalDetails();
	}

}
