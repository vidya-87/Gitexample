package com.cucumbercraft.pages;

import java.util.Map;

import org.apache.tools.ant.launch.Locator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.WebDriverUtil;
import com.itextpdf.text.log.SysoCounter;

public class TPApage {

	WebDriver driver = GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);
	Map<String, String> locators = GetDriver.getInstance().getCompensatorLocators();
	Map<String, String> clocators = GetDriver.getInstance().getCompStatusLocators();
	Map<String, String> tlocators = GetDriver.getInstance().getTPALocators();
	String claimNumber=GetDriver.getInstance().getOICref();

	/**
	 * @author Vidya
	 * 
	 *         Compensatory flow
	 *
	 */


	public void tpaClaim()
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
			wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber",claimNumber));
		}

		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		GetDriver.getInstance().setDriver(driver);
	}
	public void tpaClaimStatus(String message)
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

	public void tpaStatusEnd(String message)
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
		wdUtil.checkBox(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.optionButton(locators.get("TPA_YES"));
		wdUtil.selectListItem(locators.get("TPA_LIST"), locators.get("TPA_LIST_V"));
		wdUtil.findByClick(locators.get("TPA_SUBMIT"));
		wdUtil.waitFor(5000);
		System.out.println("claim is transferred to TPA");
		//wdUtil.findByClick(locators.get("Logout"));
	}


	public void disputeLiability()
	{
		Liability_Decision();
		wdUtil.selectListItem(locators.get("LIABILITY_DECISION"), locators.get("LIABILITY_DECISION_DISPUTE_V"));
		wdUtil.selectListItem(locators.get("INSURER_CAPACITY"), locators.get("INSURER_CAPACITY_V"));
		wdUtil.findBySendKeys(locators.get("DISPUTE_JUSTI"), locators.get("DISPUTE_JUSTI_V"));
		wdUtil.findByClick(locators.get("SUBMIT"));
		System.out.println("liability disputed");
		GetDriver.getInstance().setDriver(driver);

	}

	public void claimDecision() throws InterruptedException {
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		GetDriver.getInstance().setDriver(driver);

	}

	public void acceptclaim()
	{
		tpaClaim();
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CLAIM_ACCEPT"));
		wdUtil.findByClick(locators.get("CONFIRM_RTA"));
		wdUtil.findByClick(locators.get("CLAIM_SUBMIT"));
		System.out.println("claim Accepted");
		GetDriver.getInstance().setDriver(driver);
	}

	public void rejectInterim()
	{
		tpaClaim();
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

	public void Liability_Decision() 
	{
		tpaClaimStatus("Pending-Liability");
		wdUtil.findByClick(locators.get("MAKE_DECISION"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CLAIM_REF_NO"), locators.get("CLAIM_REF_NO_V").replace("$claimnumber",claimNumber));
		//wdUtil.findBySendKeys(locators.get("CLAIM_HANDLER_NAME"), locators.get("CLAIM_HANDLER_NAME_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		GetDriver.getInstance().setDriver(driver);

	}

	public void Full_liability() {
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);

		wdUtil.selectListItem(locators.get("LIABILITY_DECISION"), locators.get("LIABILITY_DECISION_FULL_V"));
		wdUtil.selectListItem(locators.get("INSURER_CAPACITY"), locators.get("INSURER_CAPACITY_V"));

		// dispute seat belt yes
		wdUtil.findByClick(locators.get("SEATBELT_DISPUTE_YES"));
		wdUtil.findBySendKeys(locators.get("SEATBELT_DISPUTE_JUSTI"), locators.get("SEATBELT_DISPUTE_JUSTI_V"));

		// dispute causation yes
		wdUtil.findByClick(locators.get("CAUSATION_DISPUTE_YES"));
		wdUtil.findBySendKeys(locators.get("CAUSATION_DISPUTE_JUSTI"), locators.get("CAUSATION_DISPUTE_JUSTI_V"));

		wdUtil.findByClick(locators.get("LIABILITY_SUBMIT"));

		System.out.println("Full liability accepted");
		GetDriver.getInstance().setDriver(driver);

	}

	public void acceptRevisedOffer()
	{

		tpaClaim();
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ACCEPT_COUNTER_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		/*
		 * wdUtil.findByClick(locators.get("ACCEPT_FEE_PROPOSAL"));
		 * wdUtil.findByClick(locators.get("CONTINUE"));
		 * wdUtil.findByClick(locators.get("CONFIRM_SEND"));
		 */
		System.out.println("Revised offer with fee proposal sent to claimant");
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
	

	public void slaBreached()
	{

		//SLA breach setup for 5 mins
		driver.navigate().refresh();
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("LOGOUT"));
		wdUtil.waitFor(360000);
	}
	
	public void updatedOffer()
	{
		tpaClaimStatus("Pending-FirstOffer");
		wdUtil.findByClick(tlocators.get("MAKEOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("TPA sends updated offer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void disagreeUpliftAndMakeOffer()
	{
		tpaClaimStatus("Pending-FirstOffer");
		wdUtil.findByClick(tlocators.get("MAKEOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.optionButton(locators.get("MEDREP_OFFER_YES"));
		wdUtil.optionButton(locators.get("MEDREP_WHIPLASH"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("MAKEOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(tlocators.get("APPLY_LIFT"));
		wdUtil.optionButton(tlocators.get("DISAGREEUPLIFT"));
		wdUtil.findBySendKeys(tlocators.get("UPLIFTDESCRIPTION"),tlocators.get("UPLIFTDESCRIPTION_VALUE"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(tlocators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(tlocators.get("ENTEROFFER"),tlocators.get("ENTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(tlocators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(tlocators.get("ENTEROFFER"),tlocators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(tlocators.get("TARIFFUPLIFT"));
		wdUtil.findBySendKeys(tlocators.get("ENTEROFFER"),tlocators.get("ENTEROFFERUPLIFT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));                       
		// Round Offer
		wdUtil.findByClick(locators.get("ROUNDOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.findByClick(tlocators.get("FEEMEDICALREPORT"));
		wdUtil.findBySendKeys(tlocators.get("ENTEROFFER"),tlocators.get("ENTERFEEMEDREPORT"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));

		wdUtil.findByClick(tlocators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("TPA disagree UPLIFT and make offer to claimant");
		GetDriver.getInstance().setDriver(driver);
	}

	public void disagreeUpliftAndMakeOfferMibpro()
	{
		tpaClaim();
		wdUtil.findByClick(tlocators.get("MAKEOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.optionButton(locators.get("MEDREP_OFFER_YES"));
		wdUtil.optionButton(locators.get("MEDREP_WHIPLASH"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("MAKEOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(tlocators.get("APPLY_LIFT"));
		wdUtil.optionButton(tlocators.get("DISAGREEUPLIFT"));
		wdUtil.findBySendKeys(tlocators.get("UPLIFTDESCRIPTION"),tlocators.get("UPLIFTDESCRIPTION_VALUE"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(tlocators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(tlocators.get("ENTEROFFER"),tlocators.get("ENTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(tlocators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(tlocators.get("ENTEROFFER"),tlocators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(tlocators.get("TARIFFUPLIFT"));
		wdUtil.findBySendKeys(tlocators.get("ENTEROFFER"),tlocators.get("ENTEROFFERUPLIFT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));                       
		/*
		 * // Round Offer wdUtil.findByClick(locators.get("ROUNDOFFER"));
		 * wdUtil.findByClick(locators.get("CONTINUE"));
		 * wdUtil.findByClick(tlocators.get("FEEMEDICALREPORT"));
		 * wdUtil.findBySendKeys(tlocators.get("ENTEROFFER"),tlocators.get(
		 * "ENTERFEEMEDREPORT"));
		 * wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		 * wdUtil.findByClick(tlocators.get("SAVEANDCONTINUE"));
		 * wdUtil.findByClick(tlocators.get("CONTINUE"));
		 * 
		 * wdUtil.findByClick(tlocators.get("CONTINUE"));
		 */
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(tlocators.get("FEESPROPOSALSUM"));
		System.out.println("TPA disagree UPLIFT and make offer to claimant");
		GetDriver.getInstance().setDriver(driver);
	}

	public void secondOfferWithNoUplift()
	{
		tpaClaim();
		wdUtil.findByClick(tlocators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.optionButton(tlocators.get("REJCOUNTEROFFER"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.scrollDown(tlocators.get("FEESPROPOSALSUM"));
		wdUtil.findByClick(tlocators.get("FEESPROPOSALSUM"));
		System.out.println("TPA disagree uplift and send second offer to claimant");
		GetDriver.getInstance().setDriver(driver);
	}

	public void tpaWithdrawOffer(String status)
	{
		tpaClaimStatus(status);
		wdUtil.clickLink(locators.get("WITHDRAWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("WITHDRAWOFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("WITHDRAW_OFFER"));
		System.out.println("TPA withdraws the offer");
		//tpaStatusEnd("Pending-ReplaceOffer");
		GetDriver.getInstance().setDriver(driver);
	} 
	public void respondNVC()
	{
		tpaClaimStatus("Pending-NVCResponse");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();    
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DISPUTE_NVC_NO"));
		//wdUtil.checkBox(locators.get("NVC_UPLOAD_CHECK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		GetDriver.getInstance().setDriver(driver);    
		System.out.println("NVC responded");

	}
	
	public void makeInterimPayment()
	{
		tpaClaim();
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
	public void tpaDisagreeCourtDocs(String status) 
	{
		tpaClaimStatus(status);
		wdUtil.findByClick(tlocators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.optionButton(tlocators.get("DISAGREEDOCS"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("LEGAL_REP"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.findByClick(tlocators.get("CONFIRMANDSEND"));
		System.out.println("Disagree with claimant court document");
		GetDriver.getInstance().setDriver(driver);
	}
	public void agreeCourtDocs(String status)
	{
		tpaClaimStatus(status);
		wdUtil.findByClick(tlocators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.optionButton(tlocators.get("AGREEDOCS"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.optionButton(locators.get("LEGAL_REP"));
		wdUtil.findByClick(tlocators.get("CONTINUE"));
		wdUtil.findByClick(tlocators.get("CONFIRMANDSEND"));
		System.out.println("Agree court docs");
		GetDriver.getInstance().setDriver(driver);

	}
	public void verifyLiabilityLink()
	{
		tpaClaim();
		wdUtil.assertLink(locators.get("CHNG_LIABILITY_RESPONSE"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void verifyAddLoss()
	{
		tpaClaim();
		wdUtil.assertLink(locators.get("ADD_LOSS_LINK"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void replaceOffer()
	{
		tpaClaimStatus("Pending-ReplaceOffer");
		wdUtil.findByClick(locators.get("REPLACEMENTOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//offer summary
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Replacement offer is sent to claimant");
		GetDriver.getInstance().setDriver(driver);
	}

	public void reviewFurtherMedReportReq()
	{
		tpaClaimStatus("Pending-DecideNewMedical");
		wdUtil.findByClick(tlocators.get("REVIEW_REQ"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME2"));
		wdUtil.optionButton(tlocators.get("OBJ_MED_REP_NO"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("TPA gives consent for obtaining medical report");
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void removeClaim()
	{

		tpaClaimStatus("Pending-OfferNVCDecision");
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
		System.out.println("TPA remove claim from portal");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void rejectFurtherMedReportReq()
	{
		tpaClaimStatus("Pending-DecideNewMedical");
		wdUtil.findByClick(tlocators.get("REVIEW_REQ"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(tlocators.get("FRAME2"));
		wdUtil.optionButton(tlocators.get("OBJ_MED_REP_YES"));
		wdUtil.findBySendKeys(tlocators.get("REASON_AADLN_MEDREP"), tlocators.get("REASON_AADLN_MEDREP_V"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("TPA gives consent for obtaining medical report");
		GetDriver.getInstance().setDriver(driver);

	}
	public void logout()
	{
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("LOGOUT"));
	}


}
