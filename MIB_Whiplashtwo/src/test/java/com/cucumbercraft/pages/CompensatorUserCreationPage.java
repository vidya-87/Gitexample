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



public class CompensatorUserCreationPage 
{
	WebDriver driver = GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);

	Map<String, String> ulocators = GetDriver.getInstance().getULocators();

	String caseid= GetDriver.getInstance().getOICref();


	public void compUserRegister(String org)
	{

		wdUtil.clickLink(ulocators.get("REG_ORG")); 
		//page1
		wdUtil.findBySendKeys(ulocators.get("ORG_NAME"), org);
		wdUtil.selectListItem(ulocators.get("ORG_TYPE"),ulocators.get("ORG_TYPE_V")); 
		wdUtil.findByClick(ulocators.get("CONTINUE"));
		//page2 
		wdUtil.findBySendKeys(ulocators.get("COMPANY_WEB_ADDR"),ulocators.get("COMPANY_WEB_ADDR_V"));
		wdUtil.findBySendKeys(ulocators.get("ICO_REG_NUM"),ulocators.get("ICO_REG_NUM_V"));
		wdUtil.findBySendKeys(ulocators.get("FCA_REG_NUM"),
				ulocators.get("FCA_REG_NUM_V"));
		wdUtil.findBySendKeys(ulocators.get("MIB_MEMBER_NUM"),ulocators.get("MIB_MEMBER_NUM_V"));
		wdUtil.selectListItem(ulocators.get("BASE_LOCATION"),
				ulocators.get("BASE_LOCATION_V"));
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
		wdUtil.findByClick(ulocators.get("CONTINUE"));
		//Select Default office
		wdUtil.optionButton(ulocators.get("DEFAULT_OFFICE"));
		wdUtil.findByClick(ulocators.get("CONTINUE"));
		//Connection Type
		wdUtil.optionButton(ulocators.get("CONNECT_TYPE"));
		wdUtil.findByClick(ulocators.get("CONTINUE"));

		//EMAIL DOMAIN
		wdUtil.findBySendKeys(ulocators.get("DOMAIN_EMAIL_1"), ulocators.get("DOMAIN_EMAIL_1_V"));
		wdUtil.clickLink(ulocators.get("ADD_DOMAIN"));
		wdUtil.findBySendKeys(ulocators.get("DOMAIN_EMAIL_2"), ulocators.get("DOMAIN_EMAIL_2_V"));
		wdUtil.clickLink(ulocators.get("ADD_DOMAIN"));
		wdUtil.findBySendKeys(ulocators.get("DOMAIN_EMAIL_3"), ulocators.get("DOMAIN_EMAIL_3_V"));
		wdUtil.findByClick(ulocators.get("CONTINUE"));
		//FINISH
		wdUtil.findByClick(ulocators.get("FINISH"));
		//CONFIRM
		wdUtil.findByClick(ulocators.get("CONFIRM"));
		//Case Id/
		String caseid = wdUtil.getText(ulocators.get("CASE_ID"));
		GetDriver.getInstance().setOICref(caseid);
		System.out.println(caseid);
		System.out.println("Compensator created successfully");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void csrRegApproval(String midid)
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
		wdUtil.selectListItem(ulocators.get("FCA_VERIFY"), ulocators.get("FCA_VERIFY_V"));
		wdUtil.selectListItem(ulocators.get("MIB_VERIFY"), ulocators.get("MIB_VERIFY_V"));
		wdUtil.selectListItem(ulocators.get("EXISTING_PORTAL_USER"), ulocators.get("EXISTING_PORTAL_USER_V"));
		wdUtil.scrollUntilVisibleElement(ulocators.get("APPROVE"));
		wdUtil.findByClick(ulocators.get("APPROVE"));
		wdUtil.findByClick(ulocators.get("SUBMITCSR"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(ulocators.get("FRAME0"));
		wdUtil.findByClick(ulocators.get("MYWORKBASKET"));
		wdUtil.selectListItem(ulocators.get("VIEWQFOR"),ulocators.get("VIEWQFOR_CLAIM_V"));
		wdUtil.findByClick(ulocators.get("MYWORKBASKET"));
		wdUtil.findByClick(ulocators.get("CASEID").replace("$CASEID", caseid));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(ulocators.get("FRAME1"));
		wdUtil.findBySendKeys(ulocators.get("MID_ID"), midid);
		wdUtil.findByClick(ulocators.get("SUBMITCSR"));
		wdUtil.waitFor(3000);
		System.out.println("CSR has approved the registration for" + caseid);
	}
	
	public void signAgreement()
	{	
		String sign = wdUtil.getText(ulocators.get("SIGN_AGREE"));
		if(sign.equalsIgnoreCase("Sign Agreement"))
		{
			System.out.println("Successfully registered as compensator");
		wdUtil.findByClick(ulocators.get("CASEID").replace("$CASEID", caseid));
		System.out.println("compensator able to sign agreement");
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

	public void complogout() 
	{             

		wdUtil.defaultContent();
		wdUtil.waitFor(1000);
		wdUtil.findByClick(ulocators.get("LOGOUT"));

	}

}