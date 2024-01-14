
package com.cucumbercraft.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.cucumbercraft.framework.Browser;
import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.Settings;
import com.cucumbercraft.framework.WebDriverFactory;
import com.cucumbercraft.framework.WebDriverUtil;

/**
 * @author 453620
 * 
 *         Creating Claim using MIB prouser credentials
 *
 */



public class MIBProUserClaimCreationPage {


	WebDriver driver = GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);
	Map<String, String> locators = GetDriver.getInstance().getUnrepLocators();
	Map<String, String> plocators = GetDriver.getInstance().getProUserLocators();
	Map<String, String> llocators = GetDriver.getInstance().getLoginLocators();
	Map<String, String> mlocators = GetDriver.getInstance().getMIBproLocators();
	Map<String,String> clocators = GetDriver.getInstance().getClaimantActionsLocators();
	Map<String,String> pslocators= GetDriver.getInstance().getProUserStatusLocators();
	String refoic;

	public void MIBproClaimCreation(String involvement_type_v,String multivrn,String owner,String location)
	{	
		switchClaimsPortal();
		yourClientDetails(involvement_type_v,location);
		yourClientsNIDetails();
		tellUsAboutYourClientsAccident(involvement_type_v,owner);
		vehicleResponsibleForTheAccident(multivrn);
		tellUsAboutTheInjuriesYouSuffered();
		otherItemsToClaim(owner);
		giveUsTheSupportingDocument();
		//endOfSubmitClaim();

	}

	public void switchClaimsPortal()
	{
		wdUtil.findByClick(mlocators.get("CSR_USER_LOGO"));
		wdUtil.hovermenu(mlocators.get("SWITCH_PORTAL"));
		wdUtil.findByClick(mlocators.get("CLAIMS_PORTAL"));
		System.out.println("In Claims Portal");
	}

	public void yourClientDetails(String involvement_type_v,String location) 
	{
		
		wdUtil.findByClick(locators.get("MAKE_CLAIM"));
		wdUtil.switchToFrame(plocators.get("FRAME1"));
		wdUtil.findByClick(locators.get("START_A_NEW_CLAIM"));
		wdUtil.defaultContent();
		refoic = wdUtil.getText(plocators.get("REFOIC_V"));
		System.out.println(refoic);
		GetDriver.getInstance().setOICref(refoic);
		wdUtil.switchToFrame(plocators.get("FRAME1"));
		System.out.println(refoic);
		wdUtil.selectListItem(locators.get("TITLE"), locators.get("TITLE_V"));
		wdUtil.handleStaleElementException(locators.get("FNAME"), 30);
		wdUtil.findBySendKeys(locators.get("FNAME"), locators.get("FNAME_V"));
		wdUtil.findBySendKeys(locators.get("LNAME"), locators.get("LNAME_V"));
		wdUtil.selectListItem(locators.get("DOBDD"), locators.get("DOBDD_V"));
		wdUtil.selectListItem(locators.get("DOBMM"), locators.get("DOBMM_V"));
		wdUtil.selectListItem(locators.get("DOBYY"), locators.get("DOBYY_V"));
		if (location.equalsIgnoreCase("OUTSIDE UK")) 
		{
			wdUtil.clickLink(locators.get("ENTER_ADDR_MANUALLY"));
			wdUtil.selectListItem(locators.get("COUNTRY_DD"), locators.get("COUNTRY_V"));
			wdUtil.findBySendKeys(locators.get("ADDRESSLINE1"), locators.get("ADDRESSLINE1_V"));
			wdUtil.findBySendKeys(locators.get("POSTCODE"), locators.get("POSTCODE_V"));
		} 
		else 
		{
			
			  wdUtil.findBySendKeys(locators.get("POSTCODE_UK"),
			  locators.get("POSTCODE_UK_V"));
			  wdUtil.findByClick(locators.get("FIND_ADDRESS"));
			  wdUtil.waitFluentElementPresence(locators.get("ADDRESS"), 30, 5);
			  wdUtil.selectListItem(locators.get("ADDRESS"), locators.get("ADDRESS_V"));
		}
		wdUtil.findBySendKeys(locators.get("CT_NUM"), locators.get("CT_NUM_V"));
		wdUtil.findBySendKeys(locators.get("EMAILID"), locators.get("EMAILID_V"));
		//involvement_type_v = "I was a passenger in a Car/Lorry/Van";
		switch (involvement_type_v) {
		case "The driver":
			wdUtil.selectListItem(locators.get("INVOLVEMENT_TYPE"), involvement_type_v);
			break;
		case "A passenger in a car/van/lorry":
			wdUtil.selectListItem(locators.get("INVOLVEMENT_TYPE"), involvement_type_v);
			break;
		case "A passenger on a bus":
			wdUtil.selectListItem(locators.get("INVOLVEMENT_TYPE"), involvement_type_v);
			break;
		default:
			System.out.println("Incorrect string entered for involvement_type_v");

		}
		//wdUtil.findBySendKeys(plocators.get("ASKCUEPI"), plocators.get("ASKCUEPI_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//wdUtil.defaultContent();
		GetDriver.getInstance().setDriver(driver);
	}

	public void yourClientsNIDetails() {

		wdUtil.optionButton(locators.get("NO_NI_NUM"));
		wdUtil.selectListItem(locators.get("NI_REASON"),locators.get("NI_REASON_V"));
		wdUtil.selectListItem(locators.get("EMPLOYED_STATUS"),locators.get("EMPLOYED_STATUS_V"));
		wdUtil.findByClick(locators.get("CONTINUE_NI"));
		wdUtil.findByClick(locators.get("CONTINUE_CUEPI"));
		GetDriver.getInstance().setDriver(driver);
	}


	public void tellUsAboutYourClientsAccident(String involvement_type_v, String owner ) 
	{
		wdUtil.selectListItem(locators.get("DTDD"), locators.get("DTDD_V"));
		wdUtil.selectListItem(locators.get("DTMM"), locators.get("DTMM_V"));
		wdUtil.selectListItem(locators.get("DTYY"), locators.get("DTYY_V"));
		wdUtil.selectListItem(locators.get("DTHR"), locators.get("DTHR_V"));
		wdUtil.selectListItem(locators.get("DTMIN"), locators.get("DTMIN_V"));
		wdUtil.findByClick(locators.get("ACCIDENT_TYPE"));
		wdUtil.findBySendKeys(locators.get("ACCIDENT_DESC"), locators.get("ACCIDENT_DESC_V"));
		wdUtil.optionButton(locators.get("PHOTO_NO"));
		wdUtil.findByClick(locators.get("CONTINUE_ABTACC"));
		/*
		 * Location Details
		 */
		wdUtil.waitFluentElementPresence(locators.get("ACCIDENT_LOCATION"), 30, 5);
		wdUtil.findBySendKeys(locators.get("LOCATION_DESC"), locators.get("LOCATION_DESC_V"));
		wdUtil.findByClick(locators.get("CONTINUE_LOC"));
		/*
		 * Police
		 */

		wdUtil.optionButton(locators.get("POlICE_ATTENDED_YES"));
		wdUtil.findByClick(locators.get("CONTINUE_PCATTND"));

		if (!involvement_type_v.equals("The driver"))
		{
			//passenger in a car/lorry/van
			wdUtil.optionButton(locators.get("PASSENGER_RESPONSIBLE_NO"));

		}
		wdUtil.waitFluentElementPresence(locators.get("REG_NUM_YES"), 30, 5);
		wdUtil.optionButton(locators.get("REG_NUM_YES"));
		wdUtil.findBySendKeys(locators.get("CLAIM_REG_NUM"), locators.get("CLAIM_REG_NUM_V"));
		wdUtil.findByClick(locators.get("CLAIM_FIND_VEHICLE"));
		wdUtil.optionButton(locators.get("CLAIM_VEHICLE_YES"));
		wdUtil.findByClick(locators.get("CONTINUE_PASSENGER"));
		/*
		 * seat belt
		 */
		wdUtil.optionButton(locators.get("SEATBELT_YES"));
		wdUtil.selectListItem(locators.get("NUM_OF_PPL"), locators.get("NUM_OF_PPL_4"));
		switch (involvement_type_v) {
		case "The driver":
			if (owner.equalsIgnoreCase("NO")) 
			{
				
				wdUtil.findByClick(plocators.get("CLIENT_OWN_CAR_NO"));
			} 
			else 
			{
				wdUtil.findByClick(plocators.get("CLIENT_OWN_CAR_YES"));
				GetDriver.getInstance().setNVCstatus(true);
			}
			break;
		case "A passenger on a bus":
			wdUtil.findByClick(plocators.get("TRAVEL_EVIDENCE"));
			break;
		default:
			System.out.println("Incorrect string entered for involvement_type_v");
		}
		wdUtil.findByClick(locators.get("CONTINUE_STBLT"));
		/*
		 * Witness
		 */
		wdUtil.optionButton(locators.get("WITNESS_YES"));
		wdUtil.findBySendKeys(locators.get("WITNESS_NAME"), locators.get("WITNESS_NAME_V"));
		wdUtil.scrollDown(locators.get("WITNESS_KNOWN_NO"));
		wdUtil.optionButton(locators.get("WITNESS_KNOWN_NO"));
		wdUtil.findByClick(locators.get("CONTINUE_WTNS"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void vehicleResponsibleForTheAccident(String multivrn) 
	{

		/*
		 * Vehicle reg number
		 */
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		if (multivrn.equalsIgnoreCase("YES"))
		{
			wdUtil.findBySendKeys(locators.get("DEF_REG_NUM"), locators.get("DEF_REG_NUM_MULTIVRN_V"));
			GetDriver.getInstance().setMultiVRNStatus(true);
		}
		else
		{
			wdUtil.findBySendKeys(locators.get("DEF_REG_NUM"), locators.get("DEF_REG_NUM_V"));
		}
		wdUtil.waitFor(500);
		wdUtil.findByClick(locators.get("DEF_FIND_VEHICLE"));
		wdUtil.waitFor(500);
		wdUtil.optionButton(locators.get("DEF_VEHICLE_YES"));
		wdUtil.findByClick(locators.get("CONTINUE_VHDET"));
		/*
		 * Driver Details
		 */
		wdUtil.findBySendKeys(locators.get("DEF_FNAME"), locators.get("DEF_FNAME_V"));
		wdUtil.findBySendKeys(locators.get("DEF_LNAME"), locators.get("DEF_LNAME_V"));
		wdUtil.findBySendKeys(locators.get("DETAILS_DESC"), locators.get("DETAILS_DESC_V"));
		wdUtil.findBySendKeys(locators.get("INVOLVEMENT_DESC"), locators.get("INVOLVEMENT_DESC_V"));
		wdUtil.findByClick(locators.get("CONTINUE_DRIDET"));
		/*
		 * otherVehiclesinvolved
		 */
		wdUtil.optionButton(locators.get("VEHICLE_INVOLVED_N"));
		wdUtil.findByClick(locators.get("CONTINUE_OTHRVEHINV"));

		GetDriver.getInstance().setDriver(driver);
	}

	public void tellUsAboutTheInjuriesYouSuffered() {
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		/*
		 * injury
		 */
		wdUtil.clickLink(locators.get("ADD_INJURY"));
		wdUtil.selectListItem(locators.get("INJURED_PART"), locators.get("INJURED_PART_V"));
		wdUtil.scrollDown(locators.get("BELIEVE_WHIPLASH_YES"));
		wdUtil.optionButton(locators.get("BELIEVE_WHIPLASH_YES"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		
		/*Whiplash injury exceptionally severe*/
		wdUtil.optionButton(locators.get("EXCEPTIONALLY_SEVERE_NO"));
		wdUtil.optionButton(locators.get("EXCEPTIONAL_CIRCUMSTANCE"));
		wdUtil.findByClick(locators.get("CONTINUE"));

		/*
		 * injury-Medical Details
		 */
		//wdUtil.optionButton(locators.get("SHOCK_ANXIETY_N"));
		wdUtil.optionButton(locators.get("MEDICAL_SOUGHT_N"));
		wdUtil.optionButton(locators.get("HOSP_ATTEND_N"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void otherItemsToClaim(String owner) 
	{
		if(owner.equalsIgnoreCase("YES"))
		  {
		  wdUtil.optionButton(locators.get("CLIENT_CAR_REPAIR"));
		  wdUtil.optionButton(locators.get("CLIENT_TEMP_VEH"));
		  wdUtil.findByClick(locators.get("CONTINUE")); 
		  }
		// Properties prop = wdUtil.loadProperty("Elements");
		wdUtil.optionButton(locators.get("CLAIM_ANY_ITEMS_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		 
		GetDriver.getInstance().setDriver(driver);
	}

	public void giveUsTheSupportingDocument() 
	{
		wdUtil.scrollDown(locators.get("CONTINUE"));
		/*
		 * wdUtil.clickLink(locators.get("UPLOAD_LINK"));
		 * wdUtil.uploadFile(locators.get("SELECT_FILE"));
		 * wdUtil.selectListItem(locators.get("CATEGORY"), locators.get("CATEGORY_V"));
		 * wdUtil.findByClick(locators.get("UPLOAD_BUTTON"));
		 */
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		/*
		 * Check your answers before sending your claim
		 */
		wdUtil.clickLink(mlocators.get("UPLOAD_LINK"));
		wdUtil.uploadDoc(locators.get("SELECT_FILE"));
		wdUtil.selectListItem(mlocators.get("CATEGORY"), mlocators.get("CATEGORY_V"));
		wdUtil.findByClick(locators.get("UPLOAD_BUTTON"));
		wdUtil.checkBox(mlocators.get("SIGNED_SCR"));
		wdUtil.checkBox(mlocators.get("SIGNED_SCR_ACCCURATE"));
		wdUtil.findByClick(locators.get("CONTINUE"));

	}

	public void endOfSubmitClaim() 
	{
		/*
		 * Statement of truth
		 */
		wdUtil.defaultContent();
		wdUtil.switchToFrame(clocators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPT_SEND_CLAIM"));
		GetDriver.getInstance().setOICref(wdUtil.getText(locators.get("REFOIC")));
		String refoic = wdUtil.getText(locators.get("REFOIC"));
		System.out.println(refoic);
		wdUtil.findByClick(locators.get("CLOSE"));
		
		//VideoRecorderUtil.stopRecord();// video recording
	}
	public void logout()
	{
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("LOGOUT"));
		System.out.println("MIBprouser created claim successfully");
	}
	
	public void exitBeforeSubmitClaim()
	{
		wdUtil.findByClick(locators.get("SAVE_EXIT"));
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("LOGOUT"));
		System.out.println("exit before submitting claim");
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void continueClaimSubmission()
	{
		wdUtil.findByClick(mlocators.get("CSR_USER_LOGO"));
		wdUtil.hovermenu(mlocators.get("SWITCH_PORTAL"));
		wdUtil.findByClick(mlocators.get("CLAIMS_PORTAL"));
		System.out.println("In Claims Portal");
		String claimNumber=GetDriver.getInstance().getOICref();
		System.out.println(claimNumber);
		wdUtil.waitFor(5000);
		wdUtil.defaultContent();
		wdUtil.switchToFrame(clocators.get("FRAME0"));
		wdUtil.clickLink(clocators.get("SHOWFILTERS"));
		wdUtil.findBySendKeys(clocators.get("PORTALREF"), claimNumber);
		wdUtil.findByClick(clocators.get("FILTER"));
		wdUtil.claimantStatus(mlocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", "Pending-New"),"Pending-New");
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(clocators.get("FRAME1"));
		wdUtil.claimantStatusMSG(mlocators.get("CLAIM_STATUS_MSG"), pslocators.get("Pending-New"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		endOfSubmitClaim();
		
	}

}
