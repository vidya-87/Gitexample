/**
 * 
 */
package com.cucumbercraft.pages;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.WebDriverUtil;

/**
 * @author 453620
 * 
 *         Creating Claim using unrep credentials
 *
 */

public class UnrepClaimCreationPage {

	Map<String, String> locators = GetDriver.getInstance().getUnrepLocators();
	Map<String, String> clocators = GetDriver.getInstance().getClaimantActionsLocators();
	Map<String, String> plocators = GetDriver.getInstance().getProUserLocators();
	Map<String, String> slocators = GetDriver.getInstance().getStatusLocators();
	
	WebDriver driver = GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);
	String refoic;
	public void ClaimCreation(String owner, String involvement_type_v, String ct_preference, String multivrn,
			String location) {

		newClaim();
		yourDetails(involvement_type_v, location);
		yourDetailsNI();
		reviewYourDetails();
		askCUEPICheck();
		tellUsAboutTheAccident(involvement_type_v, owner, location);
		vehicleResponsibleForTheAccident(multivrn);
		tellUsAboutTheInjuriesYouSuffered(owner,involvement_type_v);
		otherItemsToClaim();
		giveUsTheSupportingDocument();
		contactPreference(ct_preference);
		// endOfSubmitClaim();

	}
	
	public void continueClaim(String owner, String involvement_type_v, String ct_preference, String multivrn,
			String location) {
		continueClaim();
		yourDetails(involvement_type_v, location);
		yourDetailsNI();
		reviewYourDetails();
		askCUEPICheck();
		tellUsAboutTheAccident(involvement_type_v, owner, location);
		vehicleResponsibleForTheAccident(multivrn);
		tellUsAboutTheInjuriesYouSuffered(owner,involvement_type_v);
		otherItemsToClaim();
		giveUsTheSupportingDocument();
		contactPreference(ct_preference);
	}

	public void newClaim() {

		wdUtil.findByClick(locators.get("MAKE_CLAIM"));
		wdUtil.findByClick(locators.get("START_A_NEW_CLAIM")); 
		// Properties prop = wdUtil.loadProperty("Elements");

		GetDriver.getInstance().setDriver(driver);
	}
	
	public void continueClaim()
	{
		refoic=wdUtil.getText(clocators.get("SUBMIT_OIC"));
		wdUtil.claimantStatusMSG(locators.get("CLAIM_STATUS_MSG"), slocators.get("Pending-New"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		System.out.println("continue claimcreation");
	}

	public void yourDetails(String involvement_type_v, String location) {
		
		// Properties prop = wdUtil.loadProperty("Elements");
		wdUtil.selectListItem(locators.get("TITLE").trim(), locators.get("TITLE_V").trim());
		wdUtil.handleStaleElementException(locators.get("FNAME").trim(), 30);
		wdUtil.findBySendKeys(locators.get("FNAME"), locators.get("FNAME_V"));
		wdUtil.findBySendKeys(locators.get("LNAME"), locators.get("LNAME_V"));
		wdUtil.selectListItem(locators.get("DOBDD"), locators.get("DOBDD_V"));
		wdUtil.selectListItem(locators.get("DOBMM"), locators.get("DOBMM_V"));
		wdUtil.selectListItem(locators.get("DOBYY"), locators.get("DOBYY_V"));
		if (location.equalsIgnoreCase("OUTSIDE UK")) {
			wdUtil.clickLink(locators.get("ENTER_ADDR_MANUALLY"));
			wdUtil.selectListItem(locators.get("COUNTRY_DD"), locators.get("COUNTRY_V"));
			wdUtil.findBySendKeys(locators.get("ADDRESSLINE1"), locators.get("ADDRESSLINE1_V"));
			wdUtil.findBySendKeys(locators.get("POSTCODE"), locators.get("POSTCODE_V"));
		} else {
			
			  wdUtil.findBySendKeys(locators.get("POSTCODE_UK"),
			  locators.get("POSTCODE_UK_V"));
			  wdUtil.findByClick(locators.get("FIND_ADDRESS"));
			  wdUtil.waitFluentElementPresence(locators.get("ADDRESS"), 30, 5);
			  wdUtil.selectListItem(locators.get("ADDRESS"), locators.get("ADDRESS_V"));
		}
		wdUtil.findBySendKeys(locators.get("CT_NUM"), locators.get("CT_NUM_V"));
		wdUtil.findBySendKeys(locators.get("EMAILID"), locators.get("EMAILID_V"));
		switch (involvement_type_v) {
		case "I was the driver":
			wdUtil.selectListItem(locators.get("INVOLVEMENT_TYPE"), involvement_type_v);
			GetDriver.getInstance().setNVCstatus(true);
			break;
		case "I was a passenger in a Car/Lorry/Van":
			wdUtil.selectListItem(locators.get("INVOLVEMENT_TYPE"), involvement_type_v);
			break;
		case "I was a passenger on a bus":
			wdUtil.selectListItem(locators.get("INVOLVEMENT_TYPE"), involvement_type_v);
			break;
		default:
			System.out.println("Incorrect string entered for involvement_type_v");
			break;

		}
		// wdUtil.selectListItem(locators.get("INVOLVEMENT_TYPE"),locators.get("INVOLVEMENT_TYPE_V"));
		wdUtil.findByClick(locators.get("CONTINUE_YRDET"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void yourDetailsNI() {
		wdUtil.optionButton(locators.get("NO_NI_NUM"));
		wdUtil.selectListItem(locators.get("NI_REASON"), locators.get("NI_REASON_V"));
		wdUtil.selectListItem(locators.get("EMPLOYED_STATUS"), locators.get("EMPLOYED_STATUS_V"));

		wdUtil.findByClick(locators.get("CONTINUE_NI"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void reviewYourDetails() {
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		// Properties prop = wdUtil.loadProperty("Elements");
		wdUtil.findByClick(locators.get("ACCEPT"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void askCUEPICheck() {
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		// Properties prop = wdUtil.loadProperty("Elements");
		wdUtil.findByClick(locators.get("CONTINUE_CUEPI"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void tellUsAboutTheAccident(String involvement_type_v, String owner, String location) {
		// Properties prop = wdUtil.loadProperty("Elements");
		wdUtil.selectListItem(locators.get("DTDD"), locators.get("DTDD_V"));
		wdUtil.selectListItem(locators.get("DTMM"), locators.get("DTMM_V"));
		wdUtil.selectListItem(locators.get("DTYY"), locators.get("DTYY_V"));
		wdUtil.selectListItem(locators.get("DTHR"), locators.get("DTHR_V"));
		wdUtil.selectListItem(locators.get("DTMIN"), locators.get("DTMIN_V"));
		wdUtil.findByClick(locators.get("ACCIDENT_TYPE"));
		wdUtil.findBySendKeys(locators.get("ACCIDENT_DESC"), locators.get("ACCIDENT_DESC_V"));
		wdUtil.optionButton(locators.get("PHOTO_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		/*
		 * Location Details
		 */
		if (location.equalsIgnoreCase("OUTSIDE UK")) {
			wdUtil.findBySendKeys(locators.get("LOCATION_DESC"), locators.get("LOCATION_DESC_V"));
			wdUtil.findByClick(locators.get("CONTINUE"));
		} else {
			wdUtil.waitFluentElementPresence(locators.get("ACCIDENT_LOCATION"), 30, 5);
			wdUtil.findBySendKeys(locators.get("LOCATION_DESC"), locators.get("LOCATION_DESC_UK_V"));
			wdUtil.findByClick(locators.get("CONTINUE"));
		}
		/*
		 * Police
		 */

		wdUtil.optionButton(locators.get("POlICE_ATTENDED_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));

		/*
		 * I am the Driver
		 */
		if (!involvement_type_v.equals("I was the driver")) {
			// passenger in a car/lorry/van
			wdUtil.optionButton(locators.get("PASSENGER_RESPONSIBLE_NO"));

		}
		// wdUtil.optionButton(locators.get("PASSENGER_RESPONSIBLE_NO"));
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
		//GetDriver.getInstance().setNVCstatus(false);
		switch (involvement_type_v) 
		{
		case "I was the driver":
			if (owner.equalsIgnoreCase("NO")) 
			{
				
				wdUtil.findByClick(plocators.get("CLIENT_OWN_CAR_NO"));
				} 
			else {
				wdUtil.findByClick(plocators.get("CLIENT_OWN_CAR_YES"));
				GetDriver.getInstance().setNVCstatus(true);
			}
			break;
		case "I was a passenger on a bus":
			wdUtil.findByClick(plocators.get("TRAVEL_EVIDENCE"));
			break;
		case "I was a passenger in a Car/Lorry/Van":
			wdUtil.findBySendKeys(locators.get("OTHER_OWNER"), locators.get("OTHER_OWNER_V"));
			break;
		default:
			System.out.println("Incorrect string entered for involvement_type_v");
		}
		wdUtil.findByClick(locators.get("CONTINUE"));
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

	public void vehicleResponsibleForTheAccident(String multivrn) {

		/*
		 * Vehicle reg number
		 */
		// Properties prop = wdUtil.loadProperty("Elements");
		if (multivrn.equalsIgnoreCase("YES")) {
			wdUtil.findBySendKeys(locators.get("DEF_REG_NUM"), locators.get("DEF_REG_NUM_MULTIVRN_V"));
			GetDriver.getInstance().setMultiVRNStatus(true);
		} else {
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

	public void tellUsAboutTheInjuriesYouSuffered(String owner, String involvement_type_v) {
		// Properties prop = wdUtil.loadProperty("Elements");
		/*
		 * injury
		 */
		wdUtil.clickLink(locators.get("ADD_INJURY"));
		wdUtil.selectListItem(locators.get("INJURED_PART"), locators.get("INJURED_PART_V"));
		// wdUtil.selectListItem(locators.get("INJURY_TYPE"),
		// locators.get("INJURY_TYPE_V"));
		wdUtil.scrollDown(locators.get("BELIEVE_WHIPLASH_YES"));
		wdUtil.optionButton(locators.get("BELIEVE_WHIPLASH_YES"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("EXCEPTIONALLY_SEVERE_NO"));
		wdUtil.optionButton(locators.get("EXCEPTIONAL_CIRCUMSTANCE"));
		wdUtil.findByClick(locators.get("CONTINUE"));

		/*
		 * injury-Medical Details
		 */
		// wdUtil.optionButton(locators.get("SHOCK_ANXIETY_Y"));
		wdUtil.optionButton(locators.get("MEDICAL_SOUGHT_Y"));
		wdUtil.waitFor(1000);
		wdUtil.checkBox(locators.get("DID_YOU_SEE_GP"));
		wdUtil.optionButton(locators.get("ADDLN_REHAB_Y"));
		wdUtil.optionButton(locators.get("HOSP_ATTEND_Y"));
		wdUtil.findBySendKeys(locators.get("HOSP_NAME"), locators.get("HOSP_NAME_V"));
		wdUtil.optionButton(locators.get("STAY_HOSP_1to3"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		if(involvement_type_v.equalsIgnoreCase("I was the driver"))
		{
		  if(owner.equalsIgnoreCase("YES"))
		  {
		  wdUtil.optionButton(locators.get("CLIENT_CAR_REPAIR"));
		  wdUtil.optionButton(locators.get("CLIENT_TEMP_VEH"));
		  wdUtil.findByClick(locators.get("CONTINUE")); 
		  }
		}
		 
		GetDriver.getInstance().setDriver(driver);
	}

	public void otherItemsToClaim() {
		// Properties prop = wdUtil.loadProperty("Elements");
		wdUtil.optionButton(locators.get("CLAIM_ANY_ITEMS_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void giveUsTheSupportingDocument() {
		/*
		 * UPload medical document wdUtil.scrollDown(locators.get("UPLOAD_LINK"));
		 * wdUtil.clickLink(locators.get("UPLOAD_LINK"));
		 * wdUtil.uploadFile(locators.get("SELECT_FILE"));
		 * wdUtil.selectListItem(locators.get("CATEGORY"), locators.get("CATEGORY_V"));
		 * wdUtil.findByClick(locators.get("UPLOAD_BUTTON"));
		 */
		wdUtil.findByClick(locators.get("CONTINUE"));

	}

	public void contactPreference(String ct_preference) {
		/*
		 * tellUsAboutYourContactPreference
		 */
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		switch (ct_preference.toUpperCase()) {
		case "EMAIL":
			wdUtil.checkBox(locators.get("CT_EMAIL"));
			break;
		case "SMS":
			wdUtil.checkBox(locators.get("CT_SMS"));
			break;
		case "BOTH":
			wdUtil.checkBox(locators.get("CT_EMAIL"));
			wdUtil.checkBox(locators.get("CT_SMS"));
			break;
		}

		wdUtil.findByClick(locators.get("CONTINUE"));
		/*
		 * Check your answers before sending your claim
		 */
		wdUtil.findByClick(locators.get("CONTINUE"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void endOfSubmitClaim() 
	{
		

		/*
		 * Statement of truth
		 */
		// wdUtil.checkBox(locators.get("CLAIMANT_YES"));
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPT_SEND_CLAIM"));
		refoic = wdUtil.getText(locators.get("REFOIC"));
		GetDriver.getInstance().setOICref(refoic);
		System.out.println(refoic);
		
		wdUtil.AddLog("Claim created with reference number : "+refoic);
		
		GetDriver.getInstance().setDriver(driver);
		// VideoRecorderUtil.stopRecord();// video recording
	}
	
	public void exitBeforeSubmit()
	{
		wdUtil.findByClick(locators.get("SAVE_EXIT"));
		System.out.println("exit before submitting the claim");
		
	}

}
