/**
 * 
 */
package com.cucumbercraft.pages;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.cucumbercraft.framework.Browser;
import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.Settings;
import com.cucumbercraft.framework.WebDriverFactory;
import com.cucumbercraft.framework.WebDriverUtil;


/**
 * @author Vandana Balamurugan
 *
 */

public class SuperUserLoginPage  {


	
	public static void mibProLogin() {

		WebDriver driver = DriverManager.getWebDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		Map<String,String> locators=new HashMap<String,String>();
		GetDriver.getInstance().setUnrepLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"),"Unrep"));
		GetDriver.getInstance().setProUserLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"),"ProUser"));
		GetDriver.getInstance().setMIBproLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"),"MIBpro"));
		GetDriver.getInstance().setCSRLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"),"CSR"));
		GetDriver.getInstance().setClaimantActionsLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "ClaimantActions"));
		GetDriver.getInstance().setProUserStatusLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "ProUserStatus"));
		GetDriver.getInstance().setSuperUserLocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"),"SuperUser"));
		locators=GetDriver.getInstance().getSuperUserLocators();
		//driver.get(Settings.getInstance().getProperty("PortalURL"));//STAGING
		driver.get(Settings.getInstance().getProperty("PPM2PORTAL"));//PPM2
		driver.manage().window().maximize();
		wdUtil.findBySendKeys(locators.get("CSR_USERNAME"), locators.get("CSR_USERNAME_V"));
		wdUtil.findBySendKeys(locators.get("CSR_PASSWORD"), locators.get("CSR_PASSWORD_V"));
		wdUtil.findByClick(locators.get("LOGIN"));
		GetDriver.getInstance().setDriver(driver);

	}
}
