package com.cucumbercraft.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.WebDriverUtil;

public class CompensatorOfferPage {

	Map<String, String> locators = GetDriver.getInstance().getCompensatorLocators();
	Map<String, String> clocators = GetDriver.getInstance().getCompStatusLocators();
	Map<String, String> tlocators = GetDriver.getInstance().getTPALocators();
	String claimNumber=GetDriver.getInstance().getOICref();
	WebDriver driver = GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);

	public void compClaim()
	{
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
	public void compWithdrawOfferAndReject()
	{
		compClaimStatus("Pending-RespondCounter");
		wdUtil.clickLink(locators.get("WITHDRAWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("WITHDRAWOFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("WITHDRAWOFFER"));
		System.out.println("withdraw offer");
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REJECT_COUNTER_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Compensator withdraw and reject the offer");
		GetDriver.getInstance().setDriver(driver);
	} 
	
	
	public void compFirstOffer()
	{
		compClaimStatus("Pending-FirstOffer");
		wdUtil.findByClick(locators.get("MAKEOFFER"));

		if(GetDriver.getInstance().getMedrep()==true)
		{
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.optionButton(locators.get("MEDREP_OFFER_YES"));
			wdUtil.optionButton(locators.get("MEDREP_WHIPLASH"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONFIRM"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("MAKEOFFER"));
		}

		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CRUREFERENCE"),locators.get("CRUREFERENCE_V"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFERNONIT"),locators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("OTHER_ITEMS"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		// Round Offer
		wdUtil.optionButton(locators.get("ROUNDOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//offer summary
		wdUtil.findByClick(locators.get("CONTINUE"));
		// Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("First offer sent to claimant");

		GetDriver.getInstance().setDriver(driver);
	}
	public void compFirstOfferMIBpro()
	{
		compClaimStatus("Pending-FirstOffer");
		wdUtil.findByClick(locators.get("MAKEOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CRUREFERENCE"),locators.get("CRUREFERENCE_V"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFERNONIT"),locators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("OTHER_ITEMS"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		// Round Offer
		wdUtil.optionButton(locators.get("ROUNDOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//offer summary
		wdUtil.findByClick(locators.get("CONTINUE"));
		// Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("SAVEANDSEND"));
		System.out.println("First offer sent to MIBpro");
		GetDriver.getInstance().setDriver(driver);
	}


	public void acceptCounterOffer()
	{

		compClaimStatus("Pending-RespondCounter");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ACCEPT_COUNTER_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Compensator accepts counter offer from claimant");
		GetDriver.getInstance().setDriver(driver);	
	}

	public void revisedOfferToClaimant()
	{
		compClaimStatus("Pending-RespondCounter");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REJECT_COUNTER_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		//Revised Offer
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFERNONIT"),locators.get("UPDATE_OFFER_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Round Offer
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Offer Summary
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Compensator reject claimant counter offer and provideS new offer");
		GetDriver.getInstance().setDriver(driver);	
	}

	public void rejectFinalCounterOffer()
	{
		compClaimStatus("Pending-RespondCounter");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REJECT_COUNTER_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void compFirstOfferWithUplift(String uplift) {
		compClaimStatus("Pending-FirstOffer");
		wdUtil.findByClick(locators.get("MAKEOFFER"));
		if(GetDriver.getInstance().getMedrep()==true)
		{
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.optionButton(locators.get("MEDREP_OFFER_YES"));
			wdUtil.optionButton(locators.get("MEDREP_WHIPLASH"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONFIRM"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("MAKEOFFER"));
		}
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if(uplift.equalsIgnoreCase("ACCEPT"))
		{
			wdUtil.findByClick(locators.get("APPLY_LIFT"));
			wdUtil.optionButton(locators.get("AGREEUPLIFT"));
			wdUtil.findBySendKeys(locators.get("UPLIFT_PERCENT"),locators.get("UPLIFT_PERCENT_V"));

		}
		else
		{		
			wdUtil.findByClick(locators.get("APPLY_LIFT"));
			wdUtil.optionButton(locators.get("DISAGREEUPLIFT"));
		}
		wdUtil.findBySendKeys(locators.get("UPLIFTDESCRIPTION"),locators.get("UPLIFTDESCRIPTION_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("TARIFFUPLIFT"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("ENTEROFFERUPLIFT_V")); 
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("OTHER_ITEMS"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Round up offer
		wdUtil.optionButton(locators.get("ROUNDOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));

		// Statement of truth
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Comp first offer with uplift decision");	
		GetDriver.getInstance().setDriver(driver);
	}

	public void compFirstOfferWithFeeProposal() 
	{
		compClaimStatus("Pending-FirstOffer");
		wdUtil.findByClick(locators.get("MAKEOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if(GetDriver.getInstance().getMedrep()==true)
		{
			wdUtil.optionButton(locators.get("MEDREP_OFFER_YES"));
			wdUtil.optionButton(locators.get("MEDREP_WHIPLASH"));

			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONFIRM"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("MAKEOFFER"));
		}
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.scrollUntilVisibleElement(locators.get("INJURYTARIFF"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFERNONIT"),locators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("OTHER_ITEMS"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Round up offer
		wdUtil.optionButton(locators.get("ROUNDOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));

		//Fee proposal

		wdUtil.defaultContent(); wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("MEDICAL_REPORT"));
		wdUtil.findBySendKeys(locators.get("ENTERFEE"),locators.get("ENTERFEE_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));

		// Statement of truth
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Comp first offer with fee proposal");
		GetDriver.getInstance().setDriver(driver);
	}

	public void compUpdateOfferFinancial() 
	{
		compClaimStatus("Pending-UpdateOfferFinancial");
		wdUtil.findByClick(locators.get("MAKEOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("OTHER_ITEMS"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("UPDATE_OFFER_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Round up offer
		wdUtil.findByClick(locators.get("CONTINUE"));
		//offer summary
		wdUtil.findByClick(locators.get("CONTINUE"));

		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Comp updates financiaL offer after adding losses");
		compStatusEnd("Pending-ReviewOffer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void disputeCausationOffer()
	{
		compClaimStatus("Pending-FirstOffer");
		wdUtil.findByClick(locators.get("MAKEOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("MEDREP_OFFER_NO"));
		wdUtil.findBySendKeys(locators.get("DISPUTE_OFFER_REASON"), locators.get("DISPUTE_OFFER_REASON_V"));
		wdUtil.checkBox(locators.get("DISPUTE_CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DISPUTE_NO_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		compStatusEnd("Pending-CausationNoOffer");
		System.out.println("Compensator has disputed causation");
		GetDriver.getInstance().setDriver(driver);
	}

	public void disputeCausationFinalOffer()
	{
		compClaimStatus("Pending-FirstOffer");
		wdUtil.findByClick(locators.get("MAKEOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("MEDREP_OFFER_NO"));
		wdUtil.findBySendKeys(locators.get("DISPUTE_OFFER_REASON"), locators.get("DISPUTE_OFFER_REASON_V"));
		wdUtil.checkBox(locators.get("DISPUTE_CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DISPUTE_FINAL_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CLAIM_OFFER"));
		wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("ENTEROFFERNONIT_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		compStatusEnd("Pending-CausationFinalOffer");
		System.out.println("Compensator has disputed causation final offer");
		GetDriver.getInstance().setDriver(driver);
	}
	public void compFeeProposal()
	{
		compClaimStatus("Pending-FeesOffer");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		//Fee proposal
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("MEDICAL_REPORT"));
		wdUtil.findBySendKeys(locators.get("ENTERFEE"),locators.get("ENTERFEE_V"));
		wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("comp make fee proposal");
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void offerNotUpdated()
	{
		compClaimStatus("Pending-RespondCounter");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REJECT_COUNTER_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("SAVE_EXIT"));
		compStatusEnd("Pending-UpdateOffer");
		System.out.println("Comp exits before updating the offer");
		GetDriver.getInstance().setDriver(driver);
	}


	public void rejectFeeProposal()
	{
		compClaimStatus("Pending-RespondCounterFees");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		//Fee proposal
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("REJECT_COUNTER_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Comp reject claimant's counter fee offer");
		GetDriver.getInstance().setDriver(driver);
	}
	public void logout()
	{
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("LOGOUT"));
		wdUtil.waitFor(12000);
	}
	
	
	// Author: Sourav Dutta
	
		public void comInjurytype(String injurytype) {
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			if (injurytype.matches("WHIPLASH")) {
				wdUtil.optionButton(locators.get("MEDREP_OFFER_YES"));
				wdUtil.optionButton(locators.get("MEDREP_WHIPLASH"));

				wdUtil.findByClick(locators.get("CONTINUE"));
				wdUtil.findByClick(locators.get("CONFIRM"));	
				wdUtil.AddLog("Compensator selected Whiplash as Injury type for offer");
			}else {
				wdUtil.optionButton(locators.get("MEDREP_OFFER_YES"));
				wdUtil.optionButton(locators.get("MEDREP_NON_WHIPLASH"));

				wdUtil.findByClick(locators.get("CONTINUE"));
				wdUtil.findByClick(locators.get("CONFIRM"));
				wdUtil.AddLog("Compensator selected NON Whiplash as Injury type for offer");
			}
			//wdUtil.findByClick(locators.get("CLOSE"));
			wdUtil.defaultContent();
			
		}
		
		public void CompRespondChallengeNONWhip(String decision) {
			
			
			compClaimStatus("Pending-DecideNonWhiplash");
			//wdUtil.SearchClaim();
			//wdUtil.GoToDetails();
			
			if (wdUtil.isElementPresent(locators.get("MAKEOFFER"))== false) {
				System.out.println("Make offer button is not present.. working as expected.");	
				wdUtil.AddLog("Make offer not available as Claimant challenge NON Whiplash injury..");
			}else {
				System.out.println("Make offer button is present.. not working as expected.");
				wdUtil.AddLog("Make offer available even after Claimant challenge NON Whiplash injury..Not working as expected.");
			}
			
			if (decision.equalsIgnoreCase("Reject")) {
				wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
				wdUtil.defaultContent();
				wdUtil.switchToFrame(locators.get("FRAME2"));
				
				wdUtil.findByClick(locators.get("CONTINUE"));
				
				wdUtil.defaultContent();
				wdUtil.switchToFrame(locators.get("FRAME2"));
				wdUtil.optionButton(locators.get("NONWHIPCHALLENGE_REJECT"));
				wdUtil.findBySendKeys(locators.get("REJECT_REASON"), locators.get("REJECT_REASON_V"));
				wdUtil.AddLog("Compensator Rejected claimant's NON Whiplash challenge.");
				
			}else if(decision.equalsIgnoreCase("Accept")){
				wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
				wdUtil.defaultContent();
				wdUtil.switchToFrame(locators.get("FRAME2"));
				
				wdUtil.findByClick(locators.get("CONTINUE"));
				
				wdUtil.defaultContent();
				wdUtil.switchToFrame(locators.get("FRAME2"));
				wdUtil.optionButton(locators.get("NONWHIPCHALLENGE_ACCEPT"));
				wdUtil.AddLog("Compensator Accepted claimant's NON Whiplash challenge.");
				
			}else {
				wdUtil.AddLog("Appropriate option  not provided.. You can select Accept or Reject..");
			}
			
			wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
			wdUtil.findByClick(locators.get("CLOSE"));
			
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("CLOSE"));
			
			wdUtil.defaultContent();
			
			//wdUtil.clearSearch();	
			
			
		}
		
		public void OfferwithNonWhiplash() {
			
			
			
			compClaimStatus("Pending-FirstOffer");
			wdUtil.findByClick(locators.get("MAKEOFFER"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));

			comInjurytype("NON WHIPLASH");		
			
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("MAKEOFFER"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			
				
			wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
			wdUtil.findBySendKeys(locators.get("ENTEROFFERNONIT"),locators.get("ENTEROFFERNONIT_V"));
			wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
			
			wdUtil.findByClick(locators.get("OTHER_ITEMS"));
			wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("ENTEROFFERNONIT_V"));
			wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			//Round up offer
			wdUtil.optionButton(locators.get("ROUNDOFFER"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONTINUE"));

			//Fee proposal

			wdUtil.defaultContent(); wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("MEDICAL_REPORT"));
			wdUtil.findBySendKeys(locators.get("ENTERFEE"),locators.get("ENTERFEE_V"));
			wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONTINUE"));

			// Statement of truth
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
			wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
			wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
			wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
			System.out.println("Comp first offer with fee proposal");

			wdUtil.findByClick(locators.get("CLOSE"));

			GetDriver.getInstance().setDriver(driver);

		}

		public void CompReplaceofferNonWhip() {

			

			compClaimStatus("Pending-ReplaceOffer");
			wdUtil.findByClick(locators.get("REPLACEMENTOFFER"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));


			wdUtil.scrollUntilVisibleElement(locators.get("INJURYTARIFF"));
			wdUtil.findByClick(locators.get("INJURYTARIFF"));
			wdUtil.optionButton(locators.get("TARIFF"));
			wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
			wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));



			wdUtil.findByClick(locators.get("CONTINUE"));
			//Round up offer
			wdUtil.optionButton(locators.get("ROUNDOFFER"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONTINUE"));


			// Statement of truth
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));

			wdUtil.ClearTextbox(locators.get("CFNAME"));
			wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
			wdUtil.ClearTextbox(locators.get("CLNAME"));
			wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
			wdUtil.ClearTextbox(locators.get("JOBTITLE"));
			wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
			wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
			System.out.println("Compensator placed replacement offer after accepting injury as Whiplash");

			wdUtil.findByClick(locators.get("CLOSE"));

			GetDriver.getInstance().setDriver(driver);

		}

		public void OfferwithNonWhiplashUplift(String uplift, String fees) {

			

			compClaimStatus("Pending-FirstOffer");
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			
			wdUtil.findByClick(locators.get("MAKEOFFER"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));

			comInjurytype("NON WHIPLASH");		

			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("MAKEOFFER"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));

			if(uplift.equalsIgnoreCase("ACCEPT"))
			{
				wdUtil.findByClick(locators.get("APPLY_LIFT"));
				wdUtil.optionButton(locators.get("AGREEUPLIFT"));
				wdUtil.findBySendKeys(locators.get("UPLIFT_PERCENT"),locators.get("UPLIFT_PERCENT_V"));

			}
			else
			{		
				wdUtil.findByClick(locators.get("APPLY_LIFT"));
				wdUtil.optionButton(locators.get("DISAGREEUPLIFT"));
			}
			wdUtil.findBySendKeys(locators.get("UPLIFTDESCRIPTION"),locators.get("UPLIFTDESCRIPTION_VALUE"));
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
			
			wdUtil.findByClick(locators.get("TARIFFUPLIFT"));
			wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("ENTEROFFERUPLIFT_V")); 
			wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));

			wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
			wdUtil.findBySendKeys(locators.get("ENTEROFFERNONIT"),locators.get("ENTEROFFERNONIT_V"));
			wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));

			wdUtil.findByClick(locators.get("OTHER_ITEMS"));
			wdUtil.findBySendKeys(locators.get("ENTEROFFER"),locators.get("ENTEROFFERNONIT_V"));
			wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			//Round up offer
			wdUtil.optionButton(locators.get("ROUNDOFFER"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONTINUE"));

			//Fee proposal
			if(uplift.equalsIgnoreCase("Yes")) {
				wdUtil.defaultContent(); 
				wdUtil.switchToFrame(locators.get("FRAME1"));
				wdUtil.findByClick(locators.get("MEDICAL_REPORT"));
				wdUtil.findBySendKeys(locators.get("ENTERFEE"),locators.get("ENTERFEE_V"));
				wdUtil.findBySendKeys(locators.get("COMMENT"),locators.get("COMMENT_V"));
				wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
				wdUtil.findByClick(locators.get("CONTINUE"));
				wdUtil.findByClick(locators.get("CONTINUE"));	
				System.out.println("Comp first offer with fee proposal");
				wdUtil.AddLog("Comp first offer with fee proposal");
			}
			

			// Statement of truth
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
			wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
			wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
			wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
			

			wdUtil.findByClick(locators.get("CLOSE"));

			GetDriver.getInstance().setDriver(driver);

		}

}
