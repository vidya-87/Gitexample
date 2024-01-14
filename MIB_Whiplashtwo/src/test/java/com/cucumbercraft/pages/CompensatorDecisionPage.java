package com.cucumbercraft.pages;

import java.time.Duration;
import java.util.Map;

import org.apache.tools.ant.launch.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.WebDriverUtil;
import com.itextpdf.text.log.SysoCounter;

public class CompensatorDecisionPage {


	Map<String, String> locators = GetDriver.getInstance().getCompensatorLocators();
	Map<String, String> clocators = GetDriver.getInstance().getCompStatusLocators();
	Map<String, String> tlocators = GetDriver.getInstance().getTPALocators();
	String claimNumber=GetDriver.getInstance().getOICref();
	WebDriver driver = GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);

	/**
	 * @author Vidya
	 * 
	 *         Compensatory flow
	 *
	 */

	public void compClaim()
	{
		wdUtil.closeClaim(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		if(GetDriver.getInstance().getMultiVRNStatus())
		{
			wdUtil.myTeamsWorkLink(locators.get("MYORGWORK"));
			//wdUtil.clickLink(locators.get("SHOWFILTERS"));
			//wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
			//wdUtil.findByClick(locators.get("FILTER"));
			wdUtil.doubleClick(tlocators.get("CHK_OIC").replace("$claimNumber",claimNumber));
		
		}
		else
		{
			wdUtil.myTeamsWorkLink(locators.get("MYTEAMWORK"));
		}
		wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber",claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		GetDriver.getInstance().setDriver(driver);
	}
	public void compClaimStatus(String message)
	{
		wdUtil.closeClaim(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		if(GetDriver.getInstance().getMultiVRNStatus())
		{
			wdUtil.myTeamsWorkLink(locators.get("MYORGWORK"));
			//wdUtil.clickLink(locators.get("SHOWFILTERS"));
			//wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
			//wdUtil.findByClick(locators.get("FILTER"));
			wdUtil.claimantStatus(tlocators.get("CLAIM_STATUS").replace("$claimNumber",claimNumber),message);
			wdUtil.doubleClick(tlocators.get("CHK_OIC").replace("$claimNumber",claimNumber));
		
		}
		else
		{
			wdUtil.myTeamsWorkLink(locators.get("MYTEAMWORK"));
			wdUtil.claimantStatus(locators.get("CLAIM_STATUS").replace("$claimNumber",claimNumber),message);
			wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber",claimNumber));
		}
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(locators.get("CLAIM_STATUS_MSG"), clocators.get(message));
		GetDriver.getInstance().setDriver(driver);
	}
	public void compStatusEnd(String message)
	{
		wdUtil.claimantStatusMSG(locators.get("CLAIM_STATUS_MSG"), clocators.get(message));
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.claimantStatus(locators.get("CLAIM_STATUS").replace("$claimNumber",claimNumber),message);
	}
	public void tpaTransfer() 
	{
		wdUtil.switchToFrame(locators.get("FRAME0"));
		if(GetDriver.getInstance().getMultiVRNStatus())
		{
			wdUtil.myTeamsWorkLink(locators.get("MYORGWORK"));
			wdUtil.clickLink(locators.get("SHOWFILTERS"));
			wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
			wdUtil.findByClick(locators.get("FILTER"));
		
		}
		else
		{
			wdUtil.myTeamsWorkLink(locators.get("MYTEAMWORK"));
		}
		wdUtil.checkBox(locators.get("CHK_OIC").replace("$claimNumber",claimNumber));
		wdUtil.clickLink(locators.get("BULK_ACTION"));
		wdUtil.optionButton(locators.get("TPA_YES"));
		wdUtil.selectListItem(locators.get("TPA_LIST"), locators.get("TPA_LIST_V"));
		wdUtil.findByClick(locators.get("TPA_SUBMIT"));
		wdUtil.waitFor(5000);
		System.out.println("Claim transferred to TPA");
		GetDriver.getInstance().setDriver(driver);
	}

	
	public void compTransfer() {
		wdUtil.closeClaim(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.myTeamsWorkLink(locators.get("MYTEAMWORK"));
		wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber",claimNumber));
		//wdUtil.doubleClick(locators.get("CHK_OIC_DUMMY"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.scrollDown(locators.get("TRANSFER_ANOTHER_COMP"));
		wdUtil.clickLink(locators.get("TRANSFER_ANOTHER_COMP"));
		wdUtil.findBySendKeys(locators.get("CHOOSE_COMP"), locators.get("CHOOSE_COMP_V"));
		wdUtil.findByClick(locators.get("ORG_SELECTION"));
		wdUtil.findBySendKeys(locators.get("TRANSFER_REASON"), locators.get("TRANSFER_REASON_V"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.waitFor(5000);
		System.out.println("Claim transferred to CompB");
		
		GetDriver.getInstance().setDriver(driver);
	}
	public void acceptTransfer() {
		wdUtil.closeClaim(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.myTeamsWorkLink(locators.get("TRANSFER_REQUEST_TAB"));
	wdUtil.doubleClick(locators.get("TRANSFERRED_OIC").replace("$claimNumber",claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("TRANSFER_COMMENTS"), locators.get("ACCEPT_COMMENTS_V"));
	    wdUtil.findByClick(locators.get("ACCEPT_TRANSFER"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.waitFor(5000);
		System.out.println("Claim accepted by Comp B");
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		String transferstatus=wdUtil.getText(locators.get("TRANSFER_STATUS").replace("$claimNumber",claimNumber));
		System.out.println("Transfer status is:" +transferstatus);
		if(!transferstatus.contentEquals("Open-Transferred"))
		{
			System.out.println("Stop the program");
		}
		
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void rejectTransfer() {
		wdUtil.closeClaim(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.myTeamsWorkLink(locators.get("TRANSFER_REQUEST_TAB"));
		wdUtil.doubleClick(locators.get("TRANSFERRED_OIC").replace("$claimNumber",claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("TRANSFER_COMMENTS"), locators.get("REJECT_COMMENTS_V"));
	    wdUtil.findByClick(locators.get("REJECT_TRANSFER"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.waitFor(5000);
		System.out.println("Claim transfer rejected by Comp B");
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		GetDriver.getInstance().setDriver(driver);
	}
	
	
	public void Liability_Decision() 
	{
		compClaimStatus("Pending-Liability");
		wdUtil.findByClick(locators.get("MAKE_DECISION"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CLAIM_REF_NO"), locators.get("CLAIM_REF_NO_V").replace("$claimnumber",claimNumber));
		//wdUtil.findBySendKeys(locators.get("CLAIM_HANDLER_NAME"), locators.get("CLAIM_HANDLER_NAME_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		GetDriver.getInstance().setDriver(driver);

	}
	public void fullLiabilityCausation() 
	{
		Liability_Decision();
		wdUtil.selectListItem(locators.get("LIABILITY_DECISION"), locators.get("LIABILITY_DECISION_DISPUTE_V"));
		wdUtil.optionButton(locators.get("CAUSATION_FULL"));
		wdUtil.selectListItem(locators.get("INSURER_CAPACITY"), locators.get("INSURER_CAPACITY_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_VER_YES"));
		wdUtil.findBySendKeys(locators.get("DEF_VER_JUSTI"), locators.get("DEF_VER_JUSTI_V"));
		wdUtil.checkBox(locators.get("CONFIRM_SUMMARY"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		compStatusEnd("Pending-MedCausation");
		System.out.println("Causation Dispute in Full");
		GetDriver.getInstance().setDriver(driver);
	}

	public void full_Liability_Wo_Dispute() 
	{
		Liability_Decision();
		wdUtil.selectListItem(locators.get("LIABILITY_DECISION"), locators.get("LIABILITY_DECISION_FULL_V"));
		wdUtil.selectListItem(locators.get("INSURER_CAPACITY"), locators.get("INSURER_CAPACITY_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		// dispute seat belt no
		wdUtil.findByClick(locators.get("SEATBELT_DISPUTE_YES"));

		// Defendant version no
		wdUtil.findByClick(locators.get("DEFENDANT_VERSION_NO"));
		//wdUtil.findBySendKeys(locators.get("DEF_VER_JUSTI"), locators.get("DEF_VER_JUSTI_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Full liability accepted without dispute");
		compStatusEnd("Pending-Medical");
		GetDriver.getInstance().setDriver(driver);

	}
	

	public void partialLiabilityWODispute()
	{
		Liability_Decision();
		wdUtil.selectListItem(locators.get("LIABILITY_DECISION"), locators.get("LIABILITY_DECISION_PART_V"));
		wdUtil.selectListItem(locators.get("INSURER_CAPACITY"), locators.get("INSURER_CAPACITY_V"));
		wdUtil.findBySendKeys(locators.get("LIABILITY_PERCENT"), locators.get("LIABILITY_PERCENT_V"));
		wdUtil.checkBox(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("SEATBELT_DISPUTE_NO"));
		wdUtil.optionButton(locators.get("DEF_VER_NO"));
		wdUtil.findBySendKeys(locators.get("DEF_VER_JUSTI"), locators.get("DEF_VER_JUSTI_V"));
		wdUtil.checkBox(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("CONTINUE"));
		//Statement of truth

		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("partial liability accepted");
		GetDriver.getInstance().setDriver(driver);

	}

	public void partialLiabilityCausation()
	{
		Liability_Decision();
		wdUtil.selectListItem(locators.get("LIABILITY_DECISION"), locators.get("LIABILITY_DECISION_DISPUTE_V"));
		wdUtil.optionButton(locators.get("CAUSATION_PART"));
		wdUtil.findBySendKeys(locators.get("CAUSATION_FAULT_PERCENT"), locators.get("CAUSATION_FAULT_PERCENT_V"));
		wdUtil.selectListItem(locators.get("INSURER_CAPACITY"), locators.get("INSURER_CAPACITY_V"));
		//wdUtil.findBySendKeys(locators.get("CAUSATION_DISPUTE_JUSTI"), locators.get("CAUSATION_DISPUTE_JUSTI_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_VER_NO"));
		wdUtil.findBySendKeys(locators.get("DEF_VER_JUSTI"), locators.get("DEF_VER_JUSTI_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth

		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Causation Dispute in part");
		GetDriver.getInstance().setDriver(driver);		
	}
	

	public void deniedLiability()
	{
		Liability_Decision();
		wdUtil.selectListItem(locators.get("LIABILITY_DECISION"), locators.get("LIABILITY_DECISION_DENIED_V"));
		wdUtil.selectListItem(locators.get("INSURER_CAPACITY"), locators.get("INSURER_CAPACITY_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_VER_NO"));
		wdUtil.findBySendKeys(locators.get("DEF_VER_JUSTI"), locators.get("DEF_VER_JUSTI_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth

		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("liability denied");
		System.out.println("Liability is denied");
		GetDriver.getInstance().setDriver(driver);

	}

	public void review_liabilitychallenge() 
	{
		compClaim();
		wdUtil.findByClick(locators.get("REVIEW_LIABILITY_CHALLENGE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("LIABILITY_RESPONSE"));
		wdUtil.selectListItem(locators.get("UPDATE_LIABILITY_DECISION"), locators.get("LIABILITY_DECISION_PART_V"));
		wdUtil.findBySendKeys(locators.get("LIABILITY_PERCENT_UPDATE"),locators.get("LIABILITY_PERCENT_UPDATE_V"));
		wdUtil.findByClick(locators.get("SUBMIT"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("comp review liability challenge");
		GetDriver.getInstance().setDriver(driver);	
	}

	public void makeInterimPayment()
	{
		compClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.defaultContent();	
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.defaultContent();	
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("ACCEPTINTERIM"));
		wdUtil.findByClick(locators.get("OFFERAMT"));
		wdUtil.findBySendKeys(locators.get("OFFERAMT"),locators.get("OFFERAMT_V"));
		wdUtil.findBySendKeys(locators.get("DECISIONCMT"),locators.get("DECISIONCMT_V"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Interim payment made successfully");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void reducedInterimPayment()
	{
		compClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.defaultContent();	
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.defaultContent();	
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("ACCEPTINTERIM"));
		wdUtil.findByClick(locators.get("OFFERAMT"));
		wdUtil.findBySendKeys(locators.get("OFFERAMT"),locators.get("REDUCED_OFFERAMT_V"));
		wdUtil.findBySendKeys(locators.get("DECISIONCMT"),locators.get("DECISIONCMT_V"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Reduced Interim payment made successfully");
		GetDriver.getInstance().setDriver(driver);
	}
	

	public void compensatorACKWithdraw() 
	{
		compClaimStatus("Pending-Withdrawal");
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();	
		driver.switchTo().frame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.waitFor(3000);
		System.out.println("Compensator has acknowledged");
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("RESOLVED_CLAIM"));
		wdUtil.clickLink(locators.get("SHOWFILTERS"));
		wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
		wdUtil.findByClick(locators.get("FILTER"));
		wdUtil.doubleClick(locators.get("RESOLVED_OIC").replace("$claimNumber", claimNumber));
		wdUtil.claimantStatusMSG(locators.get("CLAIM_STATUS_MSG"), clocators.get("Resolved-Withdrawn"));
		GetDriver.getInstance().setDriver(driver);

	}
	public void compensatorACK(String status) 
	{
		compClaimStatus(status);
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();	
		driver.switchTo().frame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.waitFor(3000);
		System.out.println("Compensator has acknowledged");
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		GetDriver.getInstance().setDriver(driver);
	}


	public void compReviewSelectCourtDocsInterim()
	{
		compClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("AGREEDOCS"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("LEGAL_REP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Compensator agree to selected court docs for interim");
		GetDriver.getInstance().setDriver(driver);
	}


	public void removeClaim()
	{

		compClaimStatus("Pending-ReviewOffer");
		wdUtil.clickLink(locators.get("REMOVE_CLAIM_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("REMOVE_CONFIRM"));
		wdUtil.optionButton(locators.get("REMOVE_REASON"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REMOVE"));
		wdUtil.defaultContent();
		System.out.println("Compensator remove claim from portal");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void verifyResolvedClaim(String status)
	{
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("RESOLVED_CLAIM"));
		wdUtil.clickLink(locators.get("SHOWFILTERS"));
		wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
		wdUtil.findByClick(locators.get("FILTER"));
		wdUtil.doubleClick(locators.get("RESOLVED_OIC").replace("$claimNumber", claimNumber));	
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(locators.get("CLAIM_STATUS_MSG"), clocators.get(status));
		System.out.println("claim is in resolved status");
		GetDriver.getInstance().setDriver(driver);
	}


	public void logout()
	{
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.defaultContent();
		wdUtil.waitFor(2000);
		wdUtil.findByClick(locators.get("LOGOUT"));
		GetDriver.getInstance().setDriver(driver);
	}


}
