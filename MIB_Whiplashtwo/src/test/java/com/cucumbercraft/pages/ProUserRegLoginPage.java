/**
 * 
 */
package com.cucumbercraft.pages;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.Settings;
import com.cucumbercraft.framework.WebDriverUtil;

/**
 * @author Vandana Balamurugan
 *
 */

public class ProUserRegLoginPage 
{
	WebDriver driver = DriverManager.getWebDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);
	
		

	public void proUserlogin(String username, String password)
	{	
		GetDriver.getInstance().setULocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "ProUserCreation"));
		Map<String, String> ulocators = GetDriver.getInstance().getULocators();
		driver.manage().deleteAllCookies();
		driver.get(Settings.getInstance().getProperty("PPM1WHIPLASH"));
		driver.manage().window().maximize();
		wdUtil.findBySendKeys(ulocators.get("USERNAME"), username);
		System.out.println(username);
		wdUtil.findBySendKeys(ulocators.get("PASSWORD"),password);
		wdUtil.findByClick(ulocators.get("LOGIN_SUBMIT"));
		GetDriver.getInstance().setDriver(driver);

	}
	public void proUserRelogin(String username, String password)
	{	
		GetDriver.getInstance().setULocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "ProUserCreation"));
		Map<String, String> ulocators = GetDriver.getInstance().getULocators();
		driver.manage().deleteAllCookies();
		driver.get(Settings.getInstance().getProperty("PPM1WHIPLASH"));
		driver.manage().window().maximize();
		wdUtil.findByClick(ulocators.get("LOGOUT"));
		wdUtil.waitFor(1000);
		wdUtil.findBySendKeys(ulocators.get("USERNAME"), username);
		System.out.println(username);
		wdUtil.findBySendKeys(ulocators.get("PASSWORD"),password);
		wdUtil.findByClick(ulocators.get("LOGIN_SUBMIT"));
		GetDriver.getInstance().setDriver(driver);

	}
	public void csrlogin()
	{	
		GetDriver.getInstance().setULocators(wdUtil.readExcelData(Settings.getInstance().getProperty("LocatorDatabase"), "ProUserCreation"));
		Map<String, String> ulocators = GetDriver.getInstance().getULocators();
		driver.get(Settings.getInstance().getProperty("PPM1PORTAL"));
		driver.manage().window().maximize();
		wdUtil.findBySendKeys(ulocators.get("CSR_USERNAME"), ulocators.get("CSR_USERNAME_V"));
		wdUtil.findBySendKeys(ulocators.get("CSR_PASSWORD"),ulocators.get("CSR_PASSWORD_V"));
		wdUtil.findByClick(ulocators.get("LOGIN")); 
	}




}
