package com.qa.auto.pages;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.auto.helper.BrowserFactory;
import com.qa.auto.helper.FunctionlLibrary;

/**
 * 
 * @author Prince Khanna
 *
 */
public class HomePage {

	FunctionlLibrary misc;

	public HomePage(BrowserFactory browserFctry) {
		PageFactory.initElements(browserFctry.getDriver(), this);
		misc = new FunctionlLibrary(browserFctry);
	}

	@FindBy(xpath = "//button[normalize-space()='Accept All']")
	public static WebElement acceptButton;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	public static WebElement nextButton;

	@FindBy(xpath = "//label[contains(text(),'1.000 €')]")
	public static WebElement firstRevenue;

	@FindBy(xpath = "//label[contains(text(),'10.000 €')]")
	public static WebElement secondRevenue;

	@FindBy(xpath = "//label[contains(text(),'25.000 €')]")
	public static WebElement thirdRevenue;

	@FindBy(xpath = "//label[contains(text(),'50.000 €')]")
	public static WebElement fourthRevenue;

	@FindBy(xpath = "//label[contains(text(),'100.000 €')]")
	public static WebElement fifthRevenue;

	@FindBy(xpath = "//label[contains(text(),'200.000 €')]")
	public static WebElement sixthRevenue;

	@FindBy(xpath = "//label[contains(text(),'400.000 €')]")
	public static WebElement sevethRevenue;

	@FindBy(xpath = "label[for='average-gross-400001']")
	public static WebElement eighthRevenue;

	@FindBy(xpath = "//div[text()='professional']")
	public static WebElement professionalPackages;

	@FindBy(xpath = "//div[text()='starter']")
	public static WebElement starterPackages;

	@FindBy(xpath = "//div[text()='premium']")
	public static WebElement premiumPackages;

	@FindBy(xpath = "//label[text()='DATEV Export']")
	public static WebElement datev;

	@FindBy(xpath = "//label[contains(text(),'Forma')]")
	public static WebElement forma;

	@FindBy(xpath = "//label[text()='IOSS Export']")
	public static WebElement ioss;

	@FindBy(xpath = "//label[text()='OSS Export']")
	public static WebElement oss;

	@FindBy(xpath = "//label[contains(text(),'VAT returns')]")
	public static WebElement vatReturns;

	public void choosePackage(String pckg) {
		switch (pckg) {
		case ("professional"):
			misc.elementClick(professionalPackages);
			break;
		case ("premium"):
			misc.elementClick(premiumPackages);
			break;
		case ("starter"):
			misc.elementClick(starterPackages);
			break;
		default:
			fail("Incorrect package selected");
		}

	}

	public void selectAvgRevenue(String revenue) {
		switch (revenue) {
		case ("1000"):
			misc.elementClick(firstRevenue);
			break;
		case ("10000"):
			misc.elementClick(secondRevenue);
			break;
		case ("25000"):
			misc.elementClick(thirdRevenue);
			break;
		case ("50000"):
			misc.elementClick(fourthRevenue);
			break;
		case ("100000"):
			misc.elementClick(fifthRevenue);
			break;
		case ("200000"):
			misc.elementClick(sixthRevenue);
			break;
		case ("400000"):
			misc.elementClick(sevethRevenue);
			break;
		case (">400000"):
			misc.elementClick(eighthRevenue);
			break;
		default:
			fail("Incorrect monthly revenue selected");
		}

	}

	public void selectedAddOns(String addOns) {
		switch (addOns) {
		case ("OSS"):
			misc.elementClick(oss);
			break;
		case ("DATEV"):
			misc.elementClick(datev);
			break;
		case ("Pro Forma"):
			misc.elementClick(forma);
			break;
		case ("IOSS"):
			misc.elementClick(ioss);
			break;
		case ("VAT returns"):
			misc.elementClick(vatReturns);
			break;
		default:
			fail("Incorrect adds on selected");
		}

	}

	public void acceptCookies() {
		misc.wait(2000);
		misc.elementClick(acceptButton);
	}

	public void clickNext() {
		misc.elementClick(nextButton);
	}

}
