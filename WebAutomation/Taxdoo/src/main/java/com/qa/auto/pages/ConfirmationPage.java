package com.qa.auto.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionlLibrary;

/**
 * 
 * @author Prince Khanna
 *
 */
public class ConfirmationPage {
	
	
	FunctionlLibrary misc;

	public ConfirmationPage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionlLibrary(browserFctry);
	}

	@FindBy(xpath = "//h4[contains(text(),'information is correct')]")
	public static WebElement confirmationText;

	@FindBy(xpath = "//input[@type='checkbox' and @id='accept']")
	public static WebElement tcRadio;
	
	@FindBy(xpath = "//span[text()='Complete booking']")
	public static WebElement bookingBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Company Name')]//following-sibling::div")
	public static WebElement companyNameDisplay;
	
	@FindBy(xpath = "//div[contains(text(),'Email')]//following-sibling::div")
	public static WebElement emailDisplay;
	
	@FindBy(xpath = "//div[contains(text(),'VAT')]//following-sibling::div")
	public static WebElement vatDisplay;
	
	@FindBy(xpath = "//div[contains(text(),'Tel')]//following-sibling::div[1]")
	public static WebElement numberDisplay;
	
	
	

	public void getConfirmationText() {
		String actualText = misc.elementGetText(confirmationText);
		String expectedText = "Please confirm your information is correct";
		Assert.assertEquals(actualText, expectedText);
	}

	public void clickTermsAndCondition() {
		misc.elementClickByJs(tcRadio);
	}

	public void clickBooking() {
		misc.elementClick(bookingBtn);
	}

	
	public void validatePersonalData() {
		
		JsonObject data = misc.getJsonData();
		ArrayList<String> actualValues= new ArrayList<>();
		actualValues.add(misc.elementGetText(companyNameDisplay));
		actualValues.add(misc.elementGetText(emailDisplay));
		actualValues.add(misc.elementGetText(vatDisplay));
		actualValues.add(misc.elementGetText(numberDisplay));
		
		ArrayList<String> expectedValues= new ArrayList<>();
		expectedValues.add(data.get("companyName").toString());
		expectedValues.add(data.get("email").toString());
		expectedValues.add(data.get("vatNo").toString());
		expectedValues.add(data.get("tel").toString());
		
		Assert.assertEquals(actualValues, expectedValues);
		
	}

}
