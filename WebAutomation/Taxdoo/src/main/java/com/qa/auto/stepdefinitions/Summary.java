package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.SummaryPage;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Prince Khanna
 *
 */
public class Summary {
	

	SummaryPage summaryPage;
	
	public Summary(SummaryPage summaryPage) {
        this.summaryPage = summaryPage;
    }
	
	
	@Then("Verify the booking screen")
	public void checkPersonalDetails() {
		summaryPage.validateBooking();;
	}
	
	@Then("Verify the confirmation message")
	public void validateConfirmation() {
		summaryPage.confirmationMessage();
	}
}
