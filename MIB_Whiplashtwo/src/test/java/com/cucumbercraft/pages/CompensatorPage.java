package com.cucumbercraft.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.WebDriverUtil;

public class CompensatorPage 
{


	Map<String, String> locators = GetDriver.getInstance().getCompensatorLocators();
	Map<String, String> tlocators = GetDriver.getInstance().getTPALocators();
	Map<String, String> clocators = GetDriver.getInstance().getCompStatusLocators();
	String claimNumber=GetDriver.getInstance().getOICref();
	WebDriver driver=GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil=new WebDriverUtil(driver);	

	/**
	 * 
	 * 
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
			wdUtil.clickLink(locators.get("SHOWFILTERS"));
			wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
			wdUtil.findByClick(locators.get("FILTER"));
			wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber",claimNumber));
		}
		else
		{
			wdUtil.myTeamsWorkLink(locators.get("MYTEAMWORK"));
			wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber",claimNumber));
		}
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
	}
	public void compClaimStatus(String status)
	{
		wdUtil.closeClaim(locators.get("CLOSE_TAB"));
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
		wdUtil.claimantStatus(locators.get("CLAIM_STATUS").replace("$claimNumber",claimNumber),status);
		wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber",claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(locators.get("CLAIM_STATUS_MSG"), clocators.get(status));
		GetDriver.getInstance().setDriver(driver);
	}
	public void compStatusEnd(String status)
	{
		wdUtil.claimantStatusMSG(locators.get("CLAIM_STATUS_MSG"), clocators.get(status));
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.claimantStatus(locators.get("CLAIM_STATUS").replace("$claimNumber",claimNumber),status);
	}
	public void rejectInterim()
	{
		compClaim();
		wdUtil.findByClick(locators.get("REVIEW_INTERIM_REQUEST"));
		wdUtil.defaultContent();	
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("PROCESSINTERIM"));
		wdUtil.defaultContent();	
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("REJECTINTERIM"));
		wdUtil.findBySendKeys(locators.get("DECISIONCMT"),locators.get("DECISIONCMT_V"));
		wdUtil.findByClick(locators.get("SUBMIT"));
		System.out.println("Interim payment Rejected");
		GetDriver.getInstance().setDriver(driver);
	}
	
	
	public void agreeCourtDocs(String status)
	{
		compClaimStatus(status);
		wdUtil.findByClick(tlocators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.optionButton(tlocators.get("AGREEDOCS"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("LEGAL_REP"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.findByClick(tlocators.get("CONFIRMANDSEND"));
		System.out.println("Agree court docs");
		GetDriver.getInstance().setDriver(driver);
		
	}

	public void reopenClaimAfterCourt() 
	{ 
		//wdUtil.closeClaim(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("RESOLVEDCLAIMLIST"));
		wdUtil.clickLink(locators.get("SHOWFILTERS"));
		wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
		wdUtil.findByClick(locators.get("FILTER"));
		wdUtil.doubleClick(locators.get("RESOLVED_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("REOPENLINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("COURT_LIABILITY_DECISION"));
		wdUtil.selectListItem(locators.get("LIABILITY_DECISION"),locators.get("LIABILITY_DECISION_V"));
		wdUtil.findBySendKeys(locators.get("COURT_CLAIM_NO"), locators.get("COURT_CLAIM_NO_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_ORDER_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("comp reopen claim after court and makes full liability to claimant");
		GetDriver.getInstance().setDriver(driver);	
	}



	public void logout()
	{
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.defaultContent();
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("LOGOUT"));
	}


}
