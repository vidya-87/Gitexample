package com.cucumbercraft.pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.tools.ant.launch.Locator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
 * @author Vandana Balamurugan
 * 
 *
 */



public class ProUserCreationPage 
{
	WebDriver driver = GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);

	Map<String, String> ulocators = GetDriver.getInstance().getULocators();

	String caseid= GetDriver.getInstance().getOICref();


	public void ProUserRegister()
	{

		wdUtil.clickLink(ulocators.get("REG_ORG")); 
		//page1
		wdUtil.findBySendKeys(ulocators.get("ORG_NAME"), ulocators.get("ORG_NAME_V"));
		wdUtil.selectListItem(ulocators.get("ORG_TYPE"),ulocators.get("ORG_TYPE_V")); 
		wdUtil.findByClick(ulocators.get("CONTINUE"));
		//page2 
		wdUtil.findBySendKeys(ulocators.get("COMPANY_WEB_ADDR"),ulocators.get("COMPANY_WEB_ADDR_V"));
		wdUtil.findBySendKeys(ulocators.get("ICO_REG_NUM"),ulocators.get("ICO_REG_NUM_V"));
		wdUtil.findBySendKeys(ulocators.get("SRA_NUM"),	ulocators.get("SRA_NUM_V"));
		wdUtil.selectListItem(ulocators.get("BASE_LOCATION"),ulocators.get("BASE_LOCATION_V"));
		wdUtil.findByClick(ulocators.get("CONTINUE")); 
		//PAGE 3
		wdUtil.findBySendKeys(ulocators.get("JOB_TITLE"),ulocators.get("JOB_TITLE_V")); 
		wdUtil.findBySendKeys(ulocators.get("PH_NUM"), ulocators.get("PH_NUM_V")); wdUtil.findByClick(ulocators.get("CONTINUE"));
		//page 4 
		wdUtil.findBySendKeys(ulocators.get("OFFICE_NAME"),ulocators.get("OFFICE_NAME_V"));
		wdUtil.findBySendKeys(ulocators.get("PH_NUM"), ulocators.get("PH_NUM_V"));
		wdUtil.findBySendKeys(ulocators.get("POSTCODE_UK"),ulocators.get("POSTCODE_UK_V"));
		wdUtil.findByClick(ulocators.get("FIND_ADDRESS"));
		wdUtil.waitFluentElementPresence(ulocators.get("ADDRESS"), 30, 5);
		wdUtil.selectListItem(ulocators.get("ADDRESS"), ulocators.get("ADDRESS_V"));
		wdUtil.findBySendKeys(ulocators.get("SRA_NUM"),	ulocators.get("SRA_NUM_V"));
		wdUtil.findByClick(ulocators.get("CONTINUE"));
		//Select Default office
		wdUtil.optionButton(ulocators.get("DEFAULT_OFFICE"));
		wdUtil.findByClick(ulocators.get("CONTINUE"));
		//Connection Type
		wdUtil.optionButton(ulocators.get("CONNECT_TYPE"));
		wdUtil.findByClick(ulocators.get("CONTINUE"));

		//EMAIL DOMAIN
		wdUtil.findBySendKeys(ulocators.get("DOMAIN_EMAIL_1"), ulocators.get("DOMAIN_EMAIL_1_V"));
		wdUtil.findByClick(ulocators.get("CONTINUE"));
		//FINISH
		wdUtil.findByClick(ulocators.get("FINISH"));
		//Case Id/
		String caseid = wdUtil.getText(ulocators.get("CASE_ID"));
		//CONFIRM
		wdUtil.findByClick(ulocators.get("CONFIRM"));
		GetDriver.getInstance().setOICref(caseid);
		System.out.println(caseid);
		System.out.println("Prouser created successfully");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void csrRegApproval()
	{
		wdUtil.findByClick(ulocators.get("CSR_USER_LOGO"));
		wdUtil.hovermenu(ulocators.get("SWITCH_PORTAL"));
		wdUtil.doubleClick(ulocators.get("INTERACTION_PORTAL"));
		System.out.println("In Interaction Portal");
		wdUtil.switchToFrame(ulocators.get("FRAME0"));
		wdUtil.findByClick(ulocators.get("MYWORKBASKET"));
		wdUtil.selectListItem(ulocators.get("VIEWQFOR"),ulocators.get("VIEWQFOR_V"));
		wdUtil.findByClick(ulocators.get("MYWORKBASKET"));
		wdUtil.findByClick(ulocators.get("CASEID").replace("$CASEID", caseid));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(ulocators.get("FRAME1"));
		wdUtil.selectListItem(ulocators.get("ICO_VERIFY"), ulocators.get("ICO_VERIFY_V"));
		wdUtil.selectListItem(ulocators.get("SRA_VERIFY"), ulocators.get("SRA_VERIFY_V"));
		wdUtil.selectListItem(ulocators.get("EXISTING_PORTAL_USER"), ulocators.get("EXISTING_PORTAL_USER_V"));
		wdUtil.scrollUntilVisibleElement(ulocators.get("APPROVE"));
		wdUtil.findByClick(ulocators.get("APPROVE"));
		wdUtil.findByClick(ulocators.get("SUBMITCSR"));
		wdUtil.waitFor(3000);
		System.out.println("CSR has approved the registration for" + caseid);
	}
	
	public void signAgreement()
	{	
		String sign = wdUtil.getText(ulocators.get("SIGN_AGREE"));
		if(sign.equalsIgnoreCase("Sign Agreement"))
		{
			System.out.println("Successfully registered as prouser");
		wdUtil.findByClick(ulocators.get("CASEID").replace("$CASEID", caseid));
		System.out.println("prouser able to sign agreement");
		}
		else
		{
			System.out.println("Not registered");
		}
	}

	public void csrlogout() 
	{             

		wdUtil.defaultContent();
		wdUtil.findByClick(ulocators.get("CSR_USER_LOGO"));
		wdUtil.findByClick(ulocators.get("CSR_LOGOUT"));
		Alert alert = driver.switchTo().alert();
		alert.accept();
		wdUtil.waitFor(1000);

	}

	public void prouserlogout() 
	{             

		wdUtil.defaultContent();
		wdUtil.waitFor(1000);
		wdUtil.findByClick(ulocators.get("LOGOUT"));

	}

}