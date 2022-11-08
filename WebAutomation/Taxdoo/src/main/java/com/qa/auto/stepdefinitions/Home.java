package com.qa.auto.stepdefinitions;

import com.qa.auto.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * 
 * @author Prince Khanna
 *
 */
public class Home {
	
	HomePage bookingPage;
	
	public Home(HomePage bookingPage) {
        this.bookingPage = bookingPage;
    }

	
	
	@Given("User accept the cookies")
	public void acceptCookies() {
		bookingPage.acceptCookies();
	}
	
	@Given("Select the average revenue as {string}")
	public void selectRevenue(String revenue) {
		bookingPage.selectAvgRevenue(revenue);
	}
	
	@Given("Select the {string} package")
	public void selectPackage(String pckg) {
		bookingPage.choosePackage(pckg);
	}
	
	@Given("Select {string} as the add-ons")
	public void selectAddOns(String addOns) {
		bookingPage.selectedAddOns(addOns);
	}
	
	@When("I click on next button")
	public void pressNext() {
		bookingPage.clickNext();
	}
	


}
