package com.cucumbercraft.pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.tools.ant.launch.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.cucumbercraft.framework.Browser;
import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.Settings;
import com.cucumbercraft.framework.WebDriverFactory;
import com.cucumbercraft.framework.WebDriverUtil;

/**
 * @author Krishna Chaitanya
 * 
 *
 */



public class CsrPage {
	
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
	  Map<String, String> locators = GetDriver.getInstance().getCSRLocators();
	  Map<String, String> llocators =GetDriver.getInstance().getSuperUserLocators(); 
	  String claimNumber= GetDriver.getInstance().getOICref();
	
	
	public void switchInteractionPortal()
	{
			
			wdUtil.findByClick(locators.get("CSR_USER_LOGO"));
			wdUtil.hovermenu(locators.get("SWITCH_PORTAL"));
			wdUtil.doubleClick(locators.get("INTERACTION_PORTAL"));
			System.out.println("In Interaction Portal");
	}
	
	
	public void routeToCompensatorToUploadMedicalReport()
	{
		wdUtil.clickLink(locators.get("NEW"));
		wdUtil.clickLink(locators.get("PHONECALL"));
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("EMAIL"));
		wdUtil.findBySendKeys(locators.get("SEARCH_EMAIL"),locators.get("SEARCH_EMAIL_V"));
		driver.findElement(By.xpath("//input[contains(@name,'SearchStringEmail')]")).sendKeys(Keys.ENTER);
		System.out.println("pressed enter key");
		wdUtil.scrollUntilVisibleElement(locators.get("SEARCH"));
	    wdUtil.findByClick(locators.get("SEARCH"));
		System.out.println("DME searched");
		wdUtil.doubleClick(locators.get("SELECT_DME"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ADD_TASK"));
		wdUtil.scrollDown(locators.get("MOVE_MEDICAL_CLAIM"));
		wdUtil.doubleClick(locators.get("MOVE_MEDICAL_CLAIM"));
		wdUtil.checkBox(locators.get("SELECT_CLAIM").replace("$claimNumber", claimNumber));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		GetDriver.getInstance().setDriver(driver);		

	}
	
	public void routeToCompensator()
	{
		switchInteractionPortal();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("MYWORKBASKET"));
		wdUtil.selectListItem(locators.get("VIEWQFOR"),locators.get("VIEWQFOR_V"));
		wdUtil.waitFor(5000);
		Actions actions = new Actions(driver);
		// Page Down
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		actions.keyUp(Keys.CONTROL).build().perform();
		wdUtil.scrollUntilVisibleElement(locators.get("OIC_ID").replace("$claimNumber", claimNumber.trim()));
		wdUtil.findByClick(locators.get("OIC_ID").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("CHSDIFCOMPL"));
		wdUtil.optionButton(locators.get("COMPOPTION"));
		wdUtil.findBySendKeys(locators.get("CHSCOMPFRMLIST"),locators.get("CHSCOMPFRMLIST_V"));
		wdUtil.findByClick(locators.get("CHOOSECOMP"));
		wdUtil.findBySendKeys(locators.get("JUSTIFICATION"),locators.get("JUSTIFICATION_V"));
		wdUtil.findByClick(locators.get("SUBMITCSR"));
		System.out.println("Routed to compensator");
		GetDriver.getInstance().setDriver(driver);		
		
	}
	
	
	
	public void logout() {             
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CSR_USER_LOGO"));
		wdUtil.findByClick(locators.get("LOGOUT"));
		
	}

}