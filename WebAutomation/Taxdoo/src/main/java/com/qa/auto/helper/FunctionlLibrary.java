package com.qa.auto.helper;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import io.cucumber.java.Scenario;

/**
 * Generic Function Class
 * 
 * @author Prince Khanna
 *
 */
public class FunctionlLibrary {

	WebDriver driver;
	BrowserFactory base;

	public FunctionlLibrary(BrowserFactory driver) {
		this.driver = driver.getDriver();

	}

	/**
	 * Generic method for element click
	 * 
	 * @param element
	 */
	public void elementClick(WebElement element) {
		try {
			if (isElementPresent(element)) {
				waitElementToBeClickable(element);
				element.click();
			}
		} catch (Exception e) {
			fail("The element is not found" + element);
		}
	}


	/**
	 * @param locator
	 * @param value
	 * @return
	 */
	public boolean selectByValue(WebElement locator, String value) {
		try {
			new Select(locator).selectByValue(value);
			return true;
		} catch (Exception e) {
			System.out.println("Could not find element" + locator);
			return false;
		}
	}


	/**
	 * Explicit wait for the element to be visible
	 * @param element
	 */
	public void waitElementToBeVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchFrameException e) {
			System.out.println("No element is present " + element);
		}
	}




	/**
	 * Method to click element by Javascript 
	 * @param element
	 */
	public void elementClickByJs(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	

	/**
	 * @param locator
	 * @param text
	 * @return
	 */
	public boolean selectByText(WebElement locator, String text) {
		try {
			new Select(locator).selectByVisibleText(text);
			return true;
		} catch (Exception e) {
			fail("Could not found the element" + locator);
			return false;
		}
	}


	/**
	 * To check whether an element is present or not
	 * 
	 * @param element
	 * @return
	 */
	public boolean isElementPresent(WebElement element) {
		boolean blnResult = false;
		if (element.isDisplayed())
			blnResult = true;
		else
			blnResult = false;
		return blnResult;
	}

	/**
	 * Hard wait method
	 * 
	 * @param browser
	 * @param waitingTime
	 */
	public void hardWait(int waitingTime) {

		try {
			Thread.sleep(waitingTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method written for explicit wait
	 * 
	 * @param element
	 */
	public void waitElementToBeClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			fail("Element is not present");
		} catch (Exception e) {
			fail("Wait for the element is not working");
		}
	}

	/**
	 * Method written for sending data for a web element like input text etc
	 * 
	 * @param element
	 * @param data
	 */
	public void elementSendKeys(WebElement element, String data) {
		try {
			waitElementToBeClickable(element);
			element.clear();
			element.sendKeys(data);
		} catch (java.util.NoSuchElementException e) {
			fail("Textbox element is not present" + element);
		} catch (Exception e) {
			fail("The textbox can not be edited" + element);
		}
	}

	/**
	 * Method to get the element text based of locator
	 * 
	 * @param locator
	 * @return
	 */
	public String elementGetText(WebElement locator) {
		String strValue = null;
		try {
			strValue = locator.getText();
		} catch (NoSuchElementException e) {
			fail("Element is not present" + locator);
		} catch (Exception e) {
			fail("Can not retrieve the text for the element" + locator);
		}
		return strValue;
	}

	/**
	 * Method to get the title of the page
	 * 
	 * @return
	 */
	public String getTitle() {
		String strValue = null;
		try {
			strValue = driver.getTitle();
		} catch (Exception e) {
			fail("cannot find the title of the page");
		}
		return strValue;
	}

	/**
	 * @param Method to return the Screenshot for the failed test cases
	 */
	public void getScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");
	}



	/**
	 * 
	 * This method is used to read data from config file based on key
	 * 
	 * @return
	 */
	public Properties readData() {

		File file = new File("src/test/java/config.properties");

		FileInputStream fileInput = null;
		Properties prop = new Properties();
		try {
			fileInput = new FileInputStream(file);
			// load properties file
			prop.load(fileInput);
		} catch (FileNotFoundException e) {
			fail("cannot find the file");
		} catch (IOException e) {
			fail("cannotload the properties file");
		}

		return prop;
	}


	/**
	 * This method return the complete json data
	 * @return
	 */
	public JsonObject getJsonData() {
		JsonObject parser = null;
		try {
			String filePath = System.getProperty("user.dir") + "//data//testdata.json";
			FileReader reader = new FileReader(filePath);
			parser = (JsonObject) Jsoner.deserialize(reader);
			// System.out.println( parser.get("companyName"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JsonException e) {
			e.printStackTrace();
		}

		return parser;
	}

}
