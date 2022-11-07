package com.qa.auto.pages;

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
public class PersonalPage {

	FunctionlLibrary misc;

	public PersonalPage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionlLibrary(browserFctry);
	}

	@FindBy(xpath = "//h4[contains(text(),'personal data')]")
	public static WebElement personalData;

	@FindBy(xpath = "//span[text()='Next']")
	public static WebElement nextButton;

	@FindBy(xpath = "//input[@name='company']")
	public static WebElement companyText;

	@FindBy(xpath = "//select[@name='salutation']")
	public static WebElement salutation;

	@FindBy(xpath = "//input[@name='name']")
	public static WebElement firstName;

	@FindBy(xpath = "//input[@name='surname']")
	public static WebElement lastName;

	@FindBy(xpath = "//span[text()='Enter address manually']")
	public static WebElement addressBtn;

	@FindBy(xpath = "//input[@name='street']")
	public static WebElement street;

	@FindBy(xpath = "//input[@name='streetNo']")
	public static WebElement streetNo;

	@FindBy(xpath = "//input[@name='city']")
	public static WebElement city;

	@FindBy(xpath = "//input[@name='zip']")
	public static WebElement zip;

	@FindBy(xpath = "//input[@name='area']")
	public static WebElement area;

	@FindBy(xpath = "//select[@name='country']")
	public static WebElement country;

	@FindBy(xpath = "//input[@name='vatNo']")
	public static WebElement vatNo;

	@FindBy(xpath = "//input[@name='vatNo']//parent::div/div/img")
	public static WebElement checkImg;

	@FindBy(xpath = "//input[@name='email']")
	public static WebElement email;

	@FindBy(xpath = "//input[@name='tel']")
	public static WebElement tel;

	public void getPersonalDataText() {
		String actualText = misc.elementGetText(personalData);
		String expectedText = "Please enter your personal data.";
		Assert.assertEquals(actualText, expectedText);
	}

	public void fillPersonalDetails() {
		JsonObject data = misc.getJsonData();
		misc.elementSendKeys(companyText, data.get("companyName").toString());
		misc.selectByText(salutation, "Mr");
		misc.elementSendKeys(firstName, data.get("firstName").toString());
		misc.elementSendKeys(lastName, data.get("lastName").toString());
		misc.elementClick(addressBtn);
		misc.elementSendKeys(street, data.get("street").toString());
		misc.elementSendKeys(streetNo, data.get("streetNo").toString());
		misc.elementSendKeys(city, data.get("city").toString());
		misc.elementSendKeys(zip, data.get("zip").toString());
		misc.elementSendKeys(area, data.get("area").toString());
		misc.selectByText(country, data.get("country").toString());
		misc.elementSendKeys(vatNo, data.get("vatNo").toString());
		// misc.waitElementToBeVisible(checkImg);
		misc.elementSendKeys(email, data.get("email").toString());
		misc.elementSendKeys(tel, data.get("tel").toString());
		misc.hardWait(5000);

	}

	public void clickNext() {
		misc.elementClick(nextButton);
	}

}
