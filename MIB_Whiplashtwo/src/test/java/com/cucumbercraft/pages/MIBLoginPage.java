/**
 * 
 */
package com.cucumbercraft.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.launch.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.testng.annotations.Test;

import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.Settings;
import com.cucumbercraft.framework.WebDriverUtil;
import com.itextpdf.text.log.SysoCounter;

/**
 * @author Vandana Balamurugan
 *
 */

public class MIBLoginPage {

	public static void login(String username)
	{

		WebDriver driver = DriverManager.getWebDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		Map<String, String> locators = new HashMap<String, String>();
		GetDriver.getInstance()
		.setLoginLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "PPM2"));
		GetDriver.getInstance()
		.setUnrepLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "Unrep"));
		GetDriver.getInstance().setProUserLocators(
				wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "ProUser"));
		GetDriver.getInstance().setCompensatorLocators(
				wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "Compensator"));
		GetDriver.getInstance().setClaimantActionsLocators(
				wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "ClaimantActions"));
		GetDriver.getInstance()
		.setTPALocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "TPA"));
		GetDriver.getInstance()
		.setDMELocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "DME"));
		GetDriver.getInstance()
		.setStatusLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "ClaimantStatus"));
		GetDriver.getInstance()
		.setProUserStatusLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "ProUserStatus"));
		GetDriver.getInstance()
		.setCompStatusLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "CompStatus"));
		locators = GetDriver.getInstance().getLoginLocators();
		// VideoRecorderUtil.startRecord("Unrep-ClaimCreation");
driver.get(Settings.getInstance().getProperty("WhiplashURL"));  // Staging
	//	driver.get(Settings.getInstance().getProperty("PPM2WHIPLASH"));  // PPM2
		
		driver.manage().window().maximize();
		switch (username)
		{
		case "compensator":
			if (!GetDriver.getInstance().getCompensatorStatus()) 
			{
				wdUtil.findBySendKeys(locators.get("USERNAME"), locators.get("COMP_USERNAME_V"));
				wdUtil.findBySendKeys(locators.get("PASSWORD"),locators.get("COMP_PASSWORD_V"));
				  wdUtil.findByClick(locators.get("LOGIN_SUBMIT")); 
				  wdUtil.AddLog("Username : "+ locators.get("COMP_USERNAME_V") +"\nPassword : "+locators.get("COMP_PASSWORD_V"));
			} else
				wdUtil.findBySendKeys(locators.get("USERNAME"), locators.get("REASSIGN_COMP_USERNAME_V"));
			break;
		case "compensatorB":
			wdUtil.findBySendKeys(locators.get("USERNAME"), locators.get("COMPB_USERNAME_V"));
			wdUtil.findBySendKeys(locators.get("PASSWORD"),locators.get("COMPB_PASSWORD_V"));
			  wdUtil.findByClick(locators.get("LOGIN_SUBMIT")); 
			break;	
		case "tpa":
			wdUtil.findBySendKeys(locators.get("USERNAME"), locators.get("TPA_USERNAME_V"));
			wdUtil.findBySendKeys(locators.get("PASSWORD"),locators.get("TPA_PASSWORD_V"));
			  wdUtil.findByClick(locators.get("LOGIN_SUBMIT")); 
			  wdUtil.AddLog("Username : "+ locators.get("TPA_USERNAME_V") +"\nPassword : "+locators.get("TPA_PASSWORD_V"));
			break;
		case "prouser":
			wdUtil.findBySendKeys(locators.get("USERNAME"), locators.get("PROUSER_USERNAME_V"));
			wdUtil.findBySendKeys(locators.get("PASSWORD"),locators.get("PRO_PASSWORD_V"));
			  wdUtil.findByClick(locators.get("LOGIN_SUBMIT")); 
			  wdUtil.AddLog("Username : "+ locators.get("PROUSER_USERNAME_V") +"\nPassword : "+locators.get("PRO_PASSWORD_V"));
			break;
		case "unrep":
			
			System.out.println("Username : "+ locators.get("UNREP_USERNAME_V") +"\nPassword : "+locators.get("UNREP_PASSWORD_V"));
			wdUtil.findBySendKeys(locators.get("USERNAME"), locators.get("UNREP_USERNAME_V"));
			wdUtil.findBySendKeys(locators.get("PASSWORD"),locators.get("UNREP_PASSWORD_V"));
			wdUtil.findByClick(locators.get("LOGIN_SUBMIT")); 	  
			  
			//wdUtil.findBySendKeys(locators.get("PASSWORD"),locators.get("UNREP_PASSWORD_V"));
			break;
		case "dme":
			wdUtil.findBySendKeys(locators.get("USERNAME"), locators.get("DME_USERNAME_V"));
			 wdUtil.findBySendKeys(locators.get("PASSWORD"),locators.get("DME_PASSWORD_V"));
			  wdUtil.findByClick(locators.get("LOGIN_SUBMIT")); 
			  wdUtil.waitFor(1000);
			//Staging 
			driver.get("https://motins-mibpro-stg2.pegacloud.net/prweb/PRAuth/whiplash");
			break;
		default:
			System.out.println("user not specified to login");
			break;
		}
		
		GetDriver.getInstance().setDriver(driver);
	}

}
