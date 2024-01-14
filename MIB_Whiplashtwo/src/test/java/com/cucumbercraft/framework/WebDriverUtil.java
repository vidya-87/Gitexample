package com.cucumbercraft.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.http.util.Asserts;
import org.apache.tools.ant.launch.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.cucumber.listener.Reporter;

import org.openqa.selenium.TimeoutException;

/**
 * Class containing useful WebDriver utility functions
 * 
 * @author Cognizant
 */
public class WebDriverUtil {
	private WebDriver driver;
	Map<String, String> locators = GetDriver.getInstance().getClaimantActionsLocators();
	Map<String, String> plocators = GetDriver.getInstance().getProUserLocators();
	String claimNumber = GetDriver.getInstance().getOICref();

	/**
	 * Constructor to initialize the {@link WebDriverUtil_org} object
	 * 
	 * @param driver The {@link WebDriver} object
	 */
	public WebDriverUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Function to pause the execution for the specified time period
	 * 
	 * @param milliSeconds The wait time in milliseconds
	 */
	public void waitFor(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function to wait until the specified element is located
	 * 
	 * @param by               The {@link WebDriver} locator used to identify the
	 *                         element
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilElementLocated(By by, long timeOutInSeconds) {
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Function to click the WebElement
	 * 
	 * @param by          The {@link WebDriver} locator used to identify the element
	 * @param elementName The WebElement to be clicked
	 */

	/*
	 * public void findByClick(By by){ try { waitFluentElementPresence(by,60,5);
	 * waitFor(1000); WebElement webElement = driver.findElement(by); waitFor(500);
	 * webElement.click(); } catch(Exception e) {
	 * System.out.println("Unable to click element - findByClick" + by); } }
	 */

	/**
	 * Function to click the WebElement
	 * 
	 * @param by          The {@link WebDriver} locator used to identify the element
	 * @param elementName The WebElement to be clicked
	 */

	public void findByClick(String element) {
		By by = By.xpath(element);
		try {
			/*
			 * switch (locator) { case "ID": by = By.id(element); break; case "XPATH": by =
			 * By.xpath(element); break; }
			 */

			waitFluentElementPresence(by, 60, 5);
			waitFor(1000);
			WebElement webElement = driver.findElement(by);
			waitFor(1000);
			webElement.click();
		} catch (Exception e) {
			System.out.println("Unable to click element - findByClick" + by);
		}
	}

	/**
	 * Function to get text
	 * 
	 * @param by      The {@link WebDriver} locator used to identify the element
	 * @param element The WebElement to retrieve the text
	 */
	public String getText(String element) {
		By by = By.xpath(element);
		try {
			/*
			 * switch (locator) { case "ID": by = By.id(element); break; case "XPATH": by =
			 * By.xpath(element); break; }
			 */

			waitFluentElementPresence(by, 60, 5);
			waitFor(1000);
			WebElement webElement = driver.findElement(by);
			waitFor(1000);
			return webElement.getText();
		} catch (Exception e) {
			System.out.println("Unable to get text-getText" + by);
			return "";
		}
	}

	/**
	 * Function to get text
	 * 
	 * @param by      The {@link WebDriver} locator used to identify the element
	 * @param element The WebElement to retrieve the text
	 */
	public String getAttributeValue(String element, String attributeName) {
		By by = By.xpath(element);
		try {
			/*
			 * switch (locator) { case "ID": by = By.id(element); break; case "XPATH": by =
			 * By.xpath(element); break; }
			 */

			waitFluentElementPresence(by, 60, 5);
			waitFor(1000);
			WebElement webElement = driver.findElement(by);
			waitFor(1000);
			// return webElement.getAttribute(attributeName);
			return webElement.getText();
		} catch (Exception e) {
			System.out.println("Unable to get text-getText" + by);
			return "";
		}
	}

	/**
	 * Function to click the link
	 * 
	 * @param by          The {@link WebDriver} locator used to identify the element
	 * @param elementName The WebElement to be clicked
	 */

	public void clickLink(String element) {
		By by = By.linkText(element);
		try {
			waitFluentElementPresence(by, 30, 5);
			waitFor(1000);
			WebElement webElement = driver.findElement(by);
			waitFor(1000);
			webElement.click();
		} catch (Exception e) {
			System.out.println("Unable to click element - findByClick" + by);
		}
	}

	/**
	 * Function to send values to the WebElement
	 * 
	 * @param by    The {@link WebDriver} locator used to identify the element
	 * @param value The WebElement to be send data
	 */

	/*
	 * public void findBySendKeys(By by,String value){
	 * waitFluentElementPresence(by,30,5); waitFor(1000); WebElement webElement =
	 * driver.findElement(by); findByClick(by); webElement.sendKeys(value); }
	 */
	/**
	 * Function to send values to the WebElement using JS and ignoring
	 * NoSuchElememtException
	 * 
	 * @param by    The {@link WebDriver} locator used to identify the element
	 * @param value The WebElement to be send data
	 */

	public void findBySendKeysJS(String element, String value) {
		By by = By.xpath(element);
		try {
			waitFor(2000);
			WebElement element1 = driver.findElement(by);
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", element1);
			element1.sendKeys(value);
		} catch (Exception e) {
		}

	}

	/**
	 * Function to send values to the WebElement using property file
	 * 
	 * @param locator The {@link WebDriver} locator used to identify the element
	 * @param element
	 * 
	 *                The WebElement to interact
	 * @param value   Value to send to the WebElement
	 */

	public void findBySendKeys(String element, String value) {
		By by = By.xpath(element);
		try {
			/*
			 * switch (locator) { case "ID": by = By.id(element); break; case "XPATH": by =
			 * By.xpath(element); break; }
			 */
			waitFluentElementPresence(element, 30, 5);
			waitFor(1500);
			WebElement webElement = driver.findElement(by);
			findByClick(element);
			webElement.clear();
			webElement.sendKeys(value);
			waitFor(2000);
		} catch (Exception e) {
			System.out.println("Undefined locator-findBySendKeys" + by.toString());
		}
	}

	/**
	 * Function to clear the textbox
	 * 
	 * @param locator The {@link WebDriver} locator used to identify the element
	 * @param element
	 * 
	 *                The WebElement to interact
	 * @param value   Value to send to the WebElement
	 */

	public void findByClear(String element) {
		By by = By.xpath(element);
		try {
			waitFluentElementPresence(element, 30, 5);
			waitFor(1500);
			WebElement webElement = driver.findElement(by);
			findByClick(element);
			webElement.clear();
			waitFor(2000);
		} catch (Exception e) {
			System.out.println("Undefined locator-findBySendKeys" + by.toString());
		}
	}

	/**
	 * Function to wait until the specified element is visible
	 * 
	 * @param by               The {@link WebDriver} locator used to identify the
	 *                         element
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilElementVisible(By by, long timeOutInSeconds) {
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * Function to wait until the specified element is enabled
	 * 
	 * @param by               The {@link WebDriver} locator used to identify the
	 *                         element
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilElementEnabled(By by, long timeOutInSeconds) {
		(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Function to fluent wait searches the element with timeout and polling until
	 * the specified element is present
	 * 
	 * @param by               The {@link WebDriver} locator used to identify the
	 *                         element
	 * @param timeOutInSeconds The wait timeout in seconds
	 * @param pollingInSeconds The wait timeout in seconds
	 */

	@SuppressWarnings("unchecked")
	public void waitFluentElementPresence(By by, long timeOutInSeconds, long pollingInSeconds) {
		try {

			@SuppressWarnings("rawtypes")
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
					.pollingEvery(Duration.ofSeconds(pollingInSeconds)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);

			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			System.out.println("Element not found-waitFluentElementPresence" + by.toString());
		}

	}

	/**
	 * Function to fluent wait searches the element with timeout and polling until
	 * the specified element is present
	 * 
	 * @param by               The {@link WebDriver} locator used to identify the
	 *                         element
	 * @param timeOutInSeconds The wait timeout in seconds
	 * @param pollingInSeconds The wait timeout in seconds
	 */

	@SuppressWarnings("unchecked")
	public void waitFluentElementPresence(String element, long timeOutInSeconds, long pollingInSeconds) {
		By by = By.xpath(element);
		try {

			@SuppressWarnings("rawtypes")
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
					.pollingEvery(Duration.ofSeconds(pollingInSeconds)).ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);

			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			System.out.println("Element not found-waitFluentElementPresence" + by.toString());
		}

	}

	/**
	 * Function to wait until the specified element is disabled
	 * 
	 * @param by               The {@link WebDriver} locator used to identify the
	 *                         element
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilElementDisabled(By by, long timeOutInSeconds) {
		(new WebDriverWait(driver, timeOutInSeconds))
				.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
	}

	/**
	 * Function to select the visible text from a listbox
	 * 
	 * @param by   The {@link WebDriver} locator used to identify the listbox
	 * @param item The value to be selected within the listbox(visible text)
	 */
	public void selectListItem(String element, String item) {
		By by = By.xpath(element);
		try {
			waitFluentElementPresence(element, 30, 5);
			waitFor(5000);
			Select dropDownList = new Select(driver.findElement(by));
			findByClick(element);
			waitFor(5000);
			dropDownList.selectByVisibleText(item);
		} catch (Exception e) {
			System.out.println("Values not found in dropdown - selectListItem" + by.toString());
		}
	}

	/**
	 * Function to select the value from a listbox
	 * 
	 * @param by   The {@link WebDriver} locator used to identify the listbox
	 * 
	 * @param item The value to be selected within the listbox
	 * 
	 */
	public void selectByValue(String element, String value) {
		By by = By.xpath(element);
		try {
			waitFluentElementPresence(element, 30, 5);
			waitFor(1000);
			Select dropDownList = new Select(driver.findElement(by));
			findByClick(element);
			dropDownList.selectByValue(value);
		} catch (Exception e) {
			System.out.println("Values not found in dropdown - selectListItem" + by.toString());
		}
	}

	/**
	 * Function to select value in option button
	 * 
	 * @param by The {@link WebDriver} locator used to identify the listbox
	 */
	public void optionButton(String element) {
		By by = By.xpath(element);
		try {
			waitFluentElementPresence(element, 30, 5);
			waitFor(1000);
			WebElement optBut = driver.findElement(by);
			waitFor(2000);
			optBut.click();
		} catch (Exception e) {
			System.out.println("Option button not found" + by.toString());
		}
	}

	/**
	 * Function to verify the presence of link
	 * 
	 * @param by The {@link WebDriver} locator used to identify the listbox
	 */
	public void assertLink(String element) {
		By by = By.linkText(element);
		try {
			WebElement link = driver.findElement(by);
			Assert.assertFalse(link.isDisplayed());
			System.out.println("Link is present" + by.toString());
		} catch (Exception e) {
			System.out.println("Link is not present" + by.toString());
		}
	}

	/**
	 * Function to verify the claim status
	 * 
	 * @param by The {@link WebDriver} locator used to identify the listbox
	 */
	public void claimantStatus(String element, String message) {
		By by = By.xpath(element);
		try {
			WebElement e = driver.findElement(by);
			String status = e.getText().trim();
			if (status.equals(message)) {
				AddLog("The claim status is: " + status);
				AddLog("Status matched..");				
			}
			else {
				System.out.println("Incorrect status" + by.toString());
				AddLog("System status : "+status+"\nExcel greenbox text : "+message);
			}
		} catch (Exception e) {
			System.out.println("Status exception " + e.toString());
		}
	}

	/**
	 * Function to verify the claim status message
	 * 
	 * @param by The {@link WebDriver} locator used to identify the listbox
	 */
	public void claimantStatusMSG(String element, String message) {
		By by = By.xpath(element);
		try {
			WebElement f = driver.findElement(by);
			String statusMsg = f.getText().split("\n")[1].trim();
			if (statusMsg.equals(message)) {
				System.out.println("The claim status on What you need to do: " + statusMsg);
				AddLog("GreenBox text matched..");
				AddLog("System greenbox text : "+statusMsg+"\nExcel greenbox text : "+message);
			}
			else {
				System.out.println("Incorrect status message");
				AddLog("GreenBox text doesn't matched..");
				AddLog("System greenbox text : "+statusMsg+"\nExcel greenbox text : "+message);
			}
		} catch (Exception e) {
			System.out.println("Error message" + by.toString());
		}
	}

	/**
	 * Function to check in checkbox
	 * 
	 * @param by The {@link WebDriver} locator used to identify the listbox
	 */
	public void checkBox(String element) {
		By by = By.xpath(element);
		try {
			waitFor(2000);
			waitFluentElementPresence(element, 30, 5);
			WebElement optBut = driver.findElement(by);
			waitFor(2500);
			if (!optBut.isSelected())
				optBut.click();
		} catch (Exception e) {
			System.out.println("checkbox not found" + by.toString());
		}
	}

	/**
	 * Function to verify whether the specified object exists within the current
	 * page
	 * 
	 * @param by The {@link WebDriver} locator used to identify the element
	 * @return Boolean value indicating whether the specified object exists
	 */
	public Boolean objectExists(By by) {
		if (driver.findElements(by).size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Function to verify whether the specified text is present within the current
	 * page
	 * 
	 * @param textPattern The text to be verified
	 * @return Boolean value indicating whether the specified test is present
	 */
	public Boolean isTextPresent(String textPattern) {
		if (driver.findElement(By.cssSelector("BODY")).getText().matches(textPattern)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Function to check if an alert is present on the current page
	 * 
	 * @param timeOutInSeconds The number of seconds to wait while checking for the
	 *                         alert
	 * @return Boolean value indicating whether an alert is present
	 */
	public Boolean isAlertPresent(long timeOutInSeconds) {
		try {
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	/**
	 * Stale ElementFunction to check element is present
	 * 
	 * @param timeOutInSeconds The number of seconds to wait while checking for the
	 *                         alert
	 * 
	 * @return Boolean value indicating whether an element is present
	 */
	public Boolean handleStaleElementException(String element, long timeOutInSeconds) {
		By by = By.xpath(element);
		boolean flag = false;
		for (int i = 0; i <= 100; i++) {
			try {
				driver.findElement(by).click();
				flag = true;
				break;

			} catch (Exception e) {
				flag = false;
				waitUntilElementVisible(by, timeOutInSeconds);
			}
		}
		return flag;

	}

	/**
	 * Function to scroll to the end of the page
	 * 
	 * @param by The {@link WebDriver} locator used to identify the listbox
	 * 
	 */
	public void scrollDown(String locator) {
		try {
			waitFor(1000);
			WebElement element = driver.findElement(By.xpath(locator));
			Coordinates coordinate = ((Locatable) element).getCoordinates();
			coordinate.onPage();

			coordinate.inViewPort();
			System.out.println("scrolled down");
		} catch (Exception e) {
			System.out.println("Unable to scroll down");
		}
	}

	/**
	 * Function to close any existing open claim when logged in
	 * 
	 * 
	 */

	public void unrepCloseClaim(String element) {
		By by = By.xpath(element);
		// check if LISTREP is present
		if (driver.findElements(By.xpath("//*[contains(@name,'UnrepReviewServiceCase')]")).size() > 0) {
			System.out.println("no open claims");
		} else {
			driver.findElement(by).click();
			System.out.println("claim closed");

		}

	}

	/**
	 * Function to click on My Team's Work link when My Work is present
	 * 
	 * 
	 */

	public void myTeamsWorkLink(String element) {

		By by = By.xpath(element);

		try {
			driver.findElement(by).click();
			waitFor(500);
		} catch (Exception e) {
			/*
			 * //close driver.findElement(By.xpath("//*[@id='close']")).click();
			 * waitFor(5000); driver.findElement(by).click();
			 */
			System.out.println("Unable to click my team's work link");
		}
	}

	public void closeTab(String element) {
		By by = By.xpath(element);
		if (driver.findElements(by).size() == 0) {
			System.out.println("no open claim tab");
		} else {
			driver.findElement(by).click();
			System.out.println("closed open claim tab");
		}

	}

	public void closeClaim(String element) {
		By by = By.xpath(element);
		final List<WebElement> ele = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames in a page :" + ele.size());
		for (WebElement el : ele) {
			// Returns the Id of a frame.
			System.out.println("Frame Id :" + el.getAttribute("id"));
			// Returns the Name of a frame.
			System.out.println("Frame name :" + el.getAttribute("name"));
			String framename = el.getAttribute("name");
			if (framename.equalsIgnoreCase("PegaGadget1Ifr")) {
				driver.findElement(by).click();
				System.out.println("closed open claims");
			} else {
				System.out.println("no open claims");
			}
		}

	}

	/**
	 * Function to scroll until the element is visible
	 * 
	 * @param by The {@link WebDriver} locator used to identify the listbox
	 * 
	 */
	public void scrollUntilVisibleElement(String element) {

		try {
			By by = By.xpath(element);
			waitFluentElementPresence(by, 30, 5);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			System.out.println("Unable to scroll down");
		}
	}

	/**
	 * To load the elements from property file
	 * 
	 * @param propertyFile The prorperty file which contains the elements
	 */

	public Properties loadProperty(String propertyFile) {
		Properties properties = new Properties();
		try

		{
			String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();
			relativePath = relativePath + Util.getFileSeparator() + "src" + Util.getFileSeparator() + "test"
					+ Util.getFileSeparator() + "resources";
			BufferedReader reader = new BufferedReader(
					new FileReader(relativePath + Util.getFileSeparator() + propertyFile + ".properties"));
			properties.load(reader);
		} catch (Exception e) {
			System.out.println("unable to propery file-loadProperty");
		}
		return properties;
	}

	public void selectByValue(WebDriver driver, By by, String value) {

		WebElement ele = driver.findElement(by);
		boolean flag = false;
		int time = 1;
		do {
			try {
				Select select = new Select(ele);
				select.selectByValue(value);
				if (!(flag = select.getOptions().get(Integer.valueOf(ele.getAttribute("selectedIndex")))
						.getAttribute("value").equals(value))) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					flag = select.getOptions().get(Integer.valueOf(ele.getAttribute("selectedIndex")))
							.getAttribute("value").equals(value);
				}
			} catch (ElementNotVisibleException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}
		} while (!flag && ++time < 5);
	}

	/**
	 * To load the elements from xls files
	 * 
	 * @param propertyFile The prorperty file which contains the elements
	 */
	public Map<String, String> readExcelData(String filePath, String sheetName) {
		Map<String, String> getLocatorDetails = new HashMap<String, String>();
		Fillo filloRead = new Fillo();
		Connection connection = null;
		Recordset recordset = null;
		try {
			connection = filloRead.getConnection(filePath);
			String strQuery = "Select * from " + sheetName;
			recordset = connection.executeQuery(strQuery);
			while (recordset.next()) {
				getLocatorDetails.put(recordset.getField("Key").trim(), recordset.getField("Value").trim());

			}
			recordset.close();
			connection.close();
		} catch (Exception e) {
			recordset.close();
			connection.close();
			System.out.println(e.toString());
		}

		return getLocatorDetails;
	}

	public Map<String, String[]> readCompDetails(String filePath, String sheetName) {
		Map<String, String[]> getLocatorDetails = new HashMap<String, String[]>();
		Fillo filloRead = new Fillo();
		Connection connection = null;
		Recordset recordset = null;
		try {
			connection = filloRead.getConnection(filePath);
			String strQuery = "Select * from " + sheetName;
			recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				String[] values = new String[3];
				values[0] = recordset.getField("EmailId").trim();
				values[1] = recordset.getField("CompOrg").trim();
				values[2] = recordset.getField("mid").trim();
				getLocatorDetails.put(values[2], values);
			}
			recordset.close();
			connection.close();
		} catch (Exception e) {
			recordset.close();
			connection.close();
			System.out.println(e.toString());
		}

		return getLocatorDetails;
	}

	/**
	 * Function to switch the control into frame
	 * 
	 * @param by The {@link WebDriver} locator used to identify the element
	 * 
	 */
	public void switchToFrame(String frameName) {
		try {
			waitFor(2000);
			final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			System.out.println(iframes.size());
			waitFor(1000);
			driver.switchTo().frame(frameName);
			waitFor(1000);
			System.out.println(frameName);
		} catch (Exception e) {
			System.out.println(e.toString());

		}

	}

	/**
	 * Function to switch the control from frame to actual page
	 * 
	 */
	public void defaultContent() {
		try {
			waitFor(2000);
			driver.switchTo().defaultContent();
			waitFor(2000);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	/**
	 * Function to double click on element
	 * 
	 * @param by The {@link WebDriver} locator used to identify the element
	 * 
	 */

	public void doubleClick(String element) {
		try {
			By by = By.xpath(element);
			Actions actions = new Actions(driver);
			waitFor(5000);
			WebElement elementLocator = driver.findElement(by);
			waitFor(2000);
			actions.doubleClick(elementLocator).perform();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Function to hover over element
	 * 
	 * @param by The {@link WebDriver} locator used to identify the element
	 * 
	 */

	public void hovermenu(String element) {
		try {
			By by = By.xpath(element);
			Actions actions = new Actions(driver);
			waitFor(2000);
			WebElement elementLocator = driver.findElement(by);
			waitFor(2000);
			actions.moveToElement(elementLocator).perform();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Function to upload medical report
	 * 
	 * @param
	 * 
	 */
	public void uploadFile(String element) {
		try {

			By by = By.xpath(element);
			waitFluentElementPresence(element, 30, 5);
			waitFor(2000);
			driver.findElement(by).sendKeys(Settings.getInstance().getProperty("UploadMedicalReport"));
			waitFor(2000);

		} catch (Exception e) {
			System.out.println("Unable to load the file" + e.toString());
		}
	}

	/**
	 * Function to upload new medical report
	 * 
	 * @param
	 * 
	 */
	public void uploadNewMedicalReport(String element) {
		try {

			By by = By.xpath(element);
			waitFluentElementPresence(element, 30, 5);
			waitFor(2000);
			driver.findElement(by).sendKeys(Settings.getInstance().getProperty("UploadNewMedicalReport"));
			waitFor(2000);

		} catch (Exception e) {
			System.out.println("Unable to load the file" + e.toString());
		}
	}

	/**
	 * Function to upload Revised medical report
	 * 
	 * @param
	 * 
	 */
	public void uploadRevisedMR(String element) {
		try {

			By by = By.xpath(element);
			waitFluentElementPresence(element, 30, 5);
			waitFor(2000);
			driver.findElement(by).sendKeys(Settings.getInstance().getProperty("UploadRevisedMR"));
			waitFor(2000);

		} catch (Exception e) {
			System.out.println("Unable to load the file" + e.toString());
		}
	}

	/* pagination for Unrep */
	@SuppressWarnings("unused")
	public void unrepOIC(String element) {

		List<WebElement> pagination = driver.findElements(By.xpath(
				"//*[@id='gridTableBody']//*[normalize-space(text())='Claim Reference Number']//ancestor::*[@id='PEGA_GRID_CONTENT']//preceding-sibling::*[normalize-space(@class)='paging-gadget-top']//*/a"));

		if (pagination.size() > 0) {
			// click on pagination link
			boolean flag = false;
			for (WebElement ele : pagination) {
				try {
					waitFor(5000);
					if (driver.findElement(By.xpath(element)).isDisplayed()) {
						findByClick(element);
						flag = true;
						break;
					}
				} catch (Exception e) {
					e.toString();
					driver.findElement(By.xpath(
							"//*[@id='gridTableBody']//*[normalize-space(text())='Claim Reference Number']//ancestor::*[@id='PEGA_GRID_CONTENT']//preceding-sibling::*[normalize-space(@class)='paging-gadget-top']//*/a[normalize-space(text())='Next']"))
							.click();
					;
					continue;
				}
			}
		} else {
			findByClick(element);
		}
	}

	/* pagination for DME login */
	@SuppressWarnings("unused")
	public void dmePage(String element) {
		List<WebElement> pagination = driver.findElements(By.xpath(
				"//*[contains(@class,'content-item content-field item-1 remove-all-spacing   dataValueWrite flex flex-row ')]/a"));
		if (pagination.size() > 0) {
			boolean flag = false;
			for (WebElement ele : pagination) {
				try {
					if (driver.findElement(By.linkText(element)).isDisplayed()) {
						// waitFor(5000);
						clickLink(element);
						flag = true;
						break;
					}
				} catch (Exception e) {
					e.toString();
					driver.findElement(
							By.xpath("//*[@id='pyGridActivePage']//following-sibling::*[contains(text(),'2')]"))
							.click();
					continue;

				}
			}
		} else {
			clickLink(element);
		}
	}

	/**
	 * Function to upload document
	 * 
	 * @param
	 * 
	 */
	public void uploadDoc(String element) {
		try {

			By by = By.xpath(element);
			waitFluentElementPresence(element, 30, 5);
			waitFor(2000);
			driver.findElement(by).sendKeys(Settings.getInstance().getProperty("UploadDoc"));
			waitFor(2000);

		} catch (Exception e) {
			System.out.println("Unable to load the file" + e.toString());
		}
	}

	/*
	 * Author: Sourav Dutta Purpose: Search Claim for pro user
	 */
	/*
	 * public void SearchClaim() { waitFor(500);
	 * switchToFrame(locators.get("FRAME0"));
	 * findByClick(plocators.get("MYTEAMWORK"));
	 * findByClick(plocators.get("SHOW_FILTER"));
	 * findBySendKeys(plocators.get("FILTER_PORTAL_REF_NO"), claimNumber);
	 * findByClick(plocators.get("FILTER_BUTTON")); }
	 */

	/*
	 * Author: Sourav Dutta Purpose: Clear Search Claim for pro user
	 */
	/*
	 * public void clearSearch() { waitFor(500);
	 * switchToFrame(locators.get("FRAME0"));
	 * findByClick(plocators.get("CLEAR_FILTER"));
	 * findByClick(plocators.get("HIDE_FILTER")); defaultContent(); }
	 * 
	 * 
	 * Author: Sourav Dutta Purpose: For go to details screen
	 * 
	 * public void GoToDetails() { try { waitFor(1000);
	 * doubleClick(plocators.get("CLAIM_STATUS").replace("$claimNumber",
	 * claimNumber)); }catch(NoSuchElementException e) {
	 * System.out.println("Unable to goto Claim overview page.."); }
	 * defaultContent(); switchToFrame(locators.get("FRAME1")); }
	 */
	/*
	 * Author: Sourav Dutta Purpose: Check element present or not
	 */

	public Boolean isElementPresent(String element) {
		waitFor(100);
		By by = By.xpath(element);
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * Author: Sourav Dutta Purpose: Check element present or not
	 */

	public Boolean isLinktextPresent(String linktext) {
		waitFor(100);
		By by = By.linkText(linktext);
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * Author: Sourav Dutta Purpose: clear element value
	 */

	public void ClearTextbox(String textbox) {

		By by = By.xpath(textbox);
		try {

			waitFluentElementPresence(by, 60, 5);
			waitFor(1000);
			WebElement webElement = driver.findElement(by);
			waitFor(1000);
			webElement.clear();
		} catch (Exception e) {
			System.out.println("Unable to clear element - ClearTextbox" + by);
		}

	}

	public void browserRefresh() {

		try {

			driver.navigate().refresh();
			waitFor(2000);

		} catch (Exception e) {
			System.out.println("Unable to refresh");
		}
	}

	public void AddLog(String log) {

		try {

			Reporter.addStepLog(log);
			System.out.println(log);

		} catch (Exception e) {
			System.out.println("Unable to add log in report");
		}
	}

}