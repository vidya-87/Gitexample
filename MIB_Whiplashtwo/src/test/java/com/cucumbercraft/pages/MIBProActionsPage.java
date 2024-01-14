package com.cucumbercraft.pages;

import java.util.Map;

import org.apache.tools.ant.launch.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.WebDriverUtil;
import com.itextpdf.text.log.SysoCounter;

public class MIBProActionsPage {

	Map<String,String> locators= GetDriver.getInstance().getClaimantActionsLocators(); 
	Map<String,String> mlocators= GetDriver.getInstance().getMIBproLocators();
	Map<String,String> pslocators= GetDriver.getInstance().getProUserStatusLocators();
	String claimNumber=GetDriver.getInstance().getOICref();
	WebDriver driver=GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil=new WebDriverUtil(driver);
	
	ClaimantActionsPage claimant=new ClaimantActionsPage();

	public void mibproUserClaim()

	{
		switchClaimsPortal();
		//wdUtil.closeClaim(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void mibproUserClaimStatus(String status)

	{
		switchClaimsPortal();
		//wdUtil.closeClaim(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.claimantStatus(mlocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", status),status);
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(mlocators.get("CLAIM_STATUS_MSG"), pslocators.get(status));		
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void mibproUserClaimStatusEnd(String status)

	{
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(mlocators.get("CLAIM_STATUS_MSG"), pslocators.get(status));
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.claimantStatus(mlocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", status),status);
		GetDriver.getInstance().setDriver(driver);

	}
	public void switchClaimsPortal()
	{
		wdUtil.findByClick(mlocators.get("CSR_USER_LOGO"));
		wdUtil.hovermenu(mlocators.get("SWITCH_PORTAL"));
		wdUtil.findByClick(mlocators.get("CLAIMS_PORTAL"));
		System.out.println("In Claims Portal");
	}

	public void mibprouserReviewmedReportandProceedOffer()
	{
		mibproUserClaimStatus("Pending-CheckMedical");
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS_ACCURATE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		mibproUserClaimStatusEnd("Pending-FirstOffer");
		System.out.println("MIBpro review medical report after DME uploads and proceed with offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproAddFeeAndProceedOffer()
	{
		mibproUserClaimStatus("Pending-CheckMedical");
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));

		// Add Fee
		wdUtil.selectListItem(locators.get("ADD_FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("FEE_EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("FEE_EVIDENCE_AVAILABLE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//Proceed with offer
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS_ACCURATE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		mibproUserClaimStatusEnd("Pending-FirstOffer");
		System.out.println("MIBpro review medical report after DME uploads and proceed with offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	
	public void mibproProceedToOfferAfterReportUpload()
	{
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));	
		wdUtil.optionButton(locators.get("ISUPLIFTJUSTIFIED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS_ACCURATE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Unrep proceed to offer after adding loss and fee");
		GetDriver.getInstance().setDriver(driver);		
	}

	public void mibprouserReviewMedicalReport()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));	
		wdUtil.optionButton(locators.get("ISUPLIFTJUSTIFIED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS_ACCURATE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("MIBpro review medical report and proceed with offer");
		GetDriver.getInstance().setDriver(driver);		
	}


	public void mibproRemoveLoss()
	{
		mibproUserClaim();
		wdUtil.clickLink(locators.get("REMOVE_LOSS_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REMOVE_LOSS"));
		wdUtil.checkBox(locators.get("REMOVE_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("Losses removed");
		GetDriver.getInstance().setDriver(driver);	
	}
	public void mibproReviewInterimPayment()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("ACCEPT_INTERIM_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		wdUtil.defaultContent();
		System.out.println("MIBpro review and accepts interim payment");
		GetDriver.getInstance().setDriver(driver);
	}

	public void mibproReviewAndRequestInterimPayment()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("ACCEPT_INTERIM_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		System.out.println("MIBpro review and accepts interim payment");
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("REQ_INT_PYMT"));
		wdUtil.findBySendKeys(locators.get("INTAMTREQ"),locators.get("INTAMTREQ_VALUE"));
		wdUtil.findBySendKeys(locators.get("EXPLAINREASON"),locators.get("EXPLAINREASON_VALUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Request interim payment");
		GetDriver.getInstance().setDriver(driver);
	}
	public void mibproRejectoffer()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("BACKTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		
		
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		 wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		 wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro rejects offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproRejectOfferWithUplift()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("BACKTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("TARIFFUPLIFT"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFERUPLIFT_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFERUPLIFT_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		 wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		 wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro reject offer");
		GetDriver.getInstance().setDriver(driver);
	}


	public void mibproRejectInterimAndGoToCourt() 
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("COURT_VAL"));
		wdUtil.checkBox(locators.get("COURT_VAL_CHKBOX"));
		wdUtil.findByClick(locators.get("INTERIM_REQUEST"));
		wdUtil.checkBox(locators.get("INTERIM_REQUEST_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(mlocators.get("SIGNED_DOC"));
		wdUtil.checkBox(mlocators.get("SIGNED_DOC_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("unrep reject interim and go to court");
		GetDriver.getInstance().setDriver(driver);
	}


	public void mibproReqInterimPayment()
	{
		mibproUserClaim();
		System.out.println("Text - "+locators.get("REQ_INT_PYMT"));
		wdUtil.clickLink(locators.get("REQ_INT_PYMT"));
		wdUtil.findBySendKeys(locators.get("INTAMTREQ"),locators.get("INTAMTREQ_VALUE"));
		wdUtil.findBySendKeys(locators.get("EXPLAINREASON"),locators.get("EXPLAINREASON_VALUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Request interim payment");
		GetDriver.getInstance().setDriver(driver);
	}

	public void mibprouserChooseDME() 
	{
		mibproUserClaimStatus("Pending-Medical");
		wdUtil.findByClick(locators.get("PROCEED_MEDICAL"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("EXAM_PLACE"));
		wdUtil.waitFor(2000);
		wdUtil.optionButton(locators.get("TRAVELLING_FROM_DME"));
		wdUtil.waitFor(2000);
		wdUtil.findBySendKeys(locators.get("POSTAL"), locators.get("POSTAL_V"));
		//wdUtil.findBySendKeys(locators.get("LOCATIONTYPE"), locators.get("LOCATIONTYPE_V"));
		wdUtil.clickLink(locators.get("ENTER_ADDRESS_LINK"));
		wdUtil.selectListItem(locators.get("COUNTRY"), locators.get("COUNTRY_V"));
		wdUtil.findBySendKeys(locators.get("ADDRESS1"), locators.get("ADDRESS1_V"));
		wdUtil.findBySendKeys(locators.get("ADDRESS2"), locators.get("ADDRESS2_V"));
		wdUtil.findBySendKeys(locators.get("CITY"), locators.get("CITY_V"));
		wdUtil.findBySendKeys(locators.get("POSTAL"), locators.get("POSTAL_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("PREFERRED_TYPE_DME"));
		wdUtil.optionButton(locators.get("MILES"));
		wdUtil.optionButton(locators.get("GENDER"));
		wdUtil.optionButton(locators.get("APPOINTMENT_REQ"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CHOOSE_DME"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		mibproUserClaimStatusEnd("Pending-MedAppointment");
		System.out.println("claimant selected dme");
		GetDriver.getInstance().setDriver(driver);		
	}
	
	public void mibproUploadRevisedMR()
	{
		mibproUserClaimStatus("Pending-FurtherReport");
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadRevisedMR(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(5000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(5000);
		wdUtil.optionButton(locators.get("ADDITIONALREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("mibpro uploads revised medical report");
		GetDriver.getInstance().setDriver(driver);	
	}
	
	public void mibproProceedAfterNewReport()
	{
		mibproUserClaimStatus("Pending-ProceedClaim");
		
		wdUtil.findByClick(locators.get("PROCEED_BUTTON"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("PROCEED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("PROCEED_BUTTON"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS_ACCURATE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("mibpro proceeds with offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproObtainAndUploadFurtherMedReport() 
	{
		mibproUserClaimStatus("Pending-CheckMedical");
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Further Medical Report
		wdUtil.optionButton(locators.get("FURTHER_MEDREPORT_COMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("OBTAIN_OWN_REPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.optionButton(locators.get("UPLOAD_OWN_REP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//Check status
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.claimantStatus(mlocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", "Pending-ClaimantFurtherMedical"),"Pending-ClaimantFurtherMedical");
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.claimantStatusMSG(mlocators.get("CLAIM_STATUS_MSG"), pslocators.get("Pending-ClaimantFurtherMedical"));
		//Upload own further report
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadNewMedicalReport(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(5000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(5000);
		wdUtil.optionButton(locators.get("ADDITIONALREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.selectListItem(locators.get("PROG_PERIOD"), locators.get("PROG_PERIOD_24"));
		wdUtil.optionButton(locators.get("FROM_MED_EXAM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("unrep obtain and upload own further medical report with waitout prognosis");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproObtainFurtherReportDuringWOP() 
	{
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.claimantStatus(mlocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", "Pending-WaitPrognosisMedical"),"Pending-WaitPrognosisMedical");
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(mlocators.get("CLAIM_STATUS_MSG"), pslocators.get("Pending-WaitPrognosisMedical"));		
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING_YES"));
		wdUtil.optionButton(locators.get("OBTAIN_FURTHER_REP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("REQ_FURTHER_REPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.selectListItem(locators.get("MED_JUSTI_ADDLN"), locators.get("MED_JUSTI_ADDLN_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("INJURY_DESC"), locators.get("INJURY_DESC_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("mibpro accept wait out prognosis and proceed to offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproWaitoutObtainFurtherMedReport() 
	{
		mibproUserClaimStatus("Pending-ProceedClaim");
		wdUtil.findByClick(locators.get("PROCEED_BUTTON"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		//Waitout prognosis
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		System.out.println("mibpro decides waitout before obtaining further medical report from compensator");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibprouserChooseDME(String status) 
	{
		mibproUserClaimStatus(status);
		wdUtil.findByClick(locators.get("PROCEED_MEDICAL"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("EXAM_PLACE"));
		wdUtil.waitFor(2000);
		wdUtil.optionButton(locators.get("TRAVELLING_FROM_DME"));
		wdUtil.waitFor(2000);
		wdUtil.findBySendKeys(locators.get("POSTAL"), locators.get("POSTAL_V"));
		//wdUtil.findBySendKeys(locators.get("LOCATIONTYPE"), locators.get("LOCATIONTYPE_V"));
		wdUtil.clickLink(locators.get("ENTER_ADDRESS_LINK"));
		wdUtil.selectListItem(locators.get("COUNTRY"), locators.get("COUNTRY_V"));
		wdUtil.findBySendKeys(locators.get("ADDRESS1"), locators.get("ADDRESS1_V"));
		wdUtil.findBySendKeys(locators.get("ADDRESS2"), locators.get("ADDRESS2_V"));
		wdUtil.findBySendKeys(locators.get("CITY"), locators.get("CITY_V"));
		wdUtil.findBySendKeys(locators.get("POSTAL"), locators.get("POSTAL_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("PREFERRED_TYPE_DME"));
		wdUtil.optionButton(locators.get("MILES"));
		wdUtil.optionButton(locators.get("GENDER"));
		wdUtil.optionButton(locators.get("APPOINTMENT_REQ"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CHOOSE_DME"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		mibproUserClaimStatusEnd("Pending-MedAppointment");
		System.out.println("claimant selected dme");
		GetDriver.getInstance().setDriver(driver);		
	}



	public void mibproUploadOwnReportWithoutPrognosis(String status) 
	{
		mibproUserClaimStatus(status);
		wdUtil.findByClick(locators.get("PROCEED_MEDICAL"));
		wdUtil.defaultContent();
		wdUtil.waitFor(7000);
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("EXAM_PLACE_OUTSIDE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//upload medical report
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadFile(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(7000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(15000);
		wdUtil.optionButton(locators.get("ADDITIONALREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("MIBpro uploads own medical report");
		GetDriver.getInstance().setDriver(driver);		
	}

	public void mibprouserRequestForRevisedOffer() 
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWOFFER_MIB"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("SOF"));
		wdUtil.optionButton(locators.get("DISPUTEOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("request for revised offer sent to compensator");
		GetDriver.getInstance().setDriver(driver);		

	}

	public void mibproAcceptOfferRejectfee()  
	{

		mibproUserClaimStatus("Pending-ReviewFeesOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ACCEPT_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEW_FEE_PROPOSAL"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("REJECTFEEPROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMPFEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("MEDICALFEE_COUNTER"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		GetDriver.getInstance().setDriver(driver);		


	}

	public void mibproRejectFeeProposal()
	{
		mibproUserClaimStatus("Pending-ReviewFeesOffer");
		wdUtil.findByClick(locators.get("REVIEW_FEE_PROPOSAL"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("REJECTFEEPROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMPFEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("MEDICALFEE_COUNTER"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_FEE_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("MIBproReject fee offer back to compensator");
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void mibproDisputeFeeCourt(String status)
	{
		mibproUserClaimStatus(status);		
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"), locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"), locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FEE_LINK"));
		wdUtil.checkBox(locators.get("FEE_CHKBOX"));
		wdUtil.findBySendKeys(locators.get("INVOICE_PROVIDER"), locators.get("INVOICE_PROVIDER_V"));
		wdUtil.selectListItem(locators.get("FEE_DATE"), locators.get("FEE_DATE_V"));
		wdUtil.selectListItem(locators.get("FEE_MONTH"), locators.get("FEE_MONTH_V"));
		wdUtil.selectListItem(locators.get("FEE_YEAR"), locators.get("FEE_YEAR_V"));
		wdUtil.checkBox(locators.get("DISPUTE_FEE_AMT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("unrep acknowledge court docs for claim");
		GetDriver.getInstance().setDriver(driver);
	}

	public void mibproGotoCourtForInterimNonPayment()
	{
		mibproUserClaim();
		wdUtil.clickLink(locators.get("GOTOCOURTINTERIM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("NOT_RECEIVED_PAYMENT"));
		wdUtil.optionButton(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("CONFIRM"));
		System.out.println("MIBpro goes to court for Interim non-payment");
		GetDriver.getInstance().setDriver(driver);
	}

	public void mibproselectCourtDocsForInterimNonPayment()
	{
		mibproUserClaim();		
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("DOCS_COURT_AT_INTERIM"));
		//added switch frame in sprint41
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		//end
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("ACCEPT_INTERIM_PAYMENT"));
		wdUtil.checkBox(locators.get("ACCEPT_INTERIM_PAYMENT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(mlocators.get("SIGNED_DOC"));
		wdUtil.checkBox(mlocators.get("SIGNED_DOC_CHKBOX"));
		//below line newly added in sprint41
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("CONFIRMANDSEND"));
		//below line updated in sprint41
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro selects court documents");
		GetDriver.getInstance().setDriver(driver);
	}

	public void mibproSecondInterimUnableToGotoCourt()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEW_INTERIM_DECISION"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("PROCESS_THIS_REQUEST"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		String msg= driver.findElement(By.xpath("//*[@id='PegaRULESErrorFlag']")).getText();
		System.out.println("Error message is displayed" + msg);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='PegaRULESErrorFlag']")).isDisplayed(),true);
		System.out.println("MIBpro unable go to court when first interim in court");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void acceptDenial() 
	{
		mibproUserClaimStatus("Pending-LiabilityRejected");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ACCEPT_DECISION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		mibproUserClaimStatusEnd("Pending-RejectedLiability");
		System.out.println("Unrep Decision accepted");
		GetDriver.getInstance().setDriver(driver);

	}

	public void mibproWithDrawClaim(String status) 
	{
		mibproUserClaimStatus(status);
		wdUtil.clickLink(locators.get("WITHDRAWCLAIM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("WITHDRAW_OPTION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("WITHDRAW"));
		System.out.println("mibpro withdraws claim");
		mibproUserClaimStatusEnd("Pending-Withdrawal");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void  mibproWithdrawOfferReplace()
	{
		mibproUserClaimStatus("Pending-RespondCounter");
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("WITHDRAWOFFER"));
		wdUtil.checkBox(locators.get("WITHDRAWOFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("WITHDRAW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		// Make Replacement offer
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.claimantStatus(mlocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", "Pending-ReplaceCounter"),"Pending-ReplaceCounter");
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(mlocators.get("CLAIM_STATUS_MSG"), pslocators.get("Pending-ReplaceCounter"));	
		wdUtil.findByClick(locators.get("REPLACEMENTOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Claimant withdraw and replace offer");
		GetDriver.getInstance().setDriver(driver);
	
	}
	
	public void mibproRejectFeeOfferAndGoToCourt()
	{
		mibproUserClaimStatus("Pending-DecideFeesOffer");
		wdUtil.findByClick(locators.get("REVIEW_FEE_PROPOSAL"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("REJECTFEEPROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Go to court over fee offer
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		//select documents
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		//Preparing for court
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Court documents
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("COURT_VAL"));
		wdUtil.checkBox(locators.get("COURT_VAL_CHKBOX"));
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(mlocators.get("SIGNED_DOC"));
		wdUtil.checkBox(mlocators.get("SIGNED_DOC_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("MIBPRO Reject Fee proposal and upload court documents");
		GetDriver.getInstance().setDriver(driver);
	}
	public void mibprouserGotoCourtOcs2()
	{
		mibproUserClaimStatus("Pending-UpdateOffer");
		wdUtil.clickLink(locators.get("GOTOCOURTLINK"));
		wdUtil.checkBox(locators.get("COURT_VALUE_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		//answer nvc questions
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ISVEHICLEDAMAGED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("COURT_VAL"));
		wdUtil.checkBox(locators.get("COURT_VAL_CHKBOX"));
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(mlocators.get("SIGNED_DOC"));
		wdUtil.checkBox(mlocators.get("SIGNED_DOC_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("NVC skipped");
		System.out.println("claimant proceed with court");
		GetDriver.getInstance().setDriver(driver);		
	}
	
	public void mibproSelectCourtDocsNVC() 
	{
		mibproUserClaimStatus("Pending-OfferCourtList");
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("ACCEPT_INTERIM_PAYMENT"));
		wdUtil.checkBox(locators.get("ACCEPT_INTERIM_PAYMENT_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(mlocators.get("SIGNED_DOC"));
		wdUtil.checkBox(mlocators.get("SIGNED_DOC_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIbpro select court docs");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproAckCourtDocswithWitness() 
	{
		mibproUserClaimStatus("Pending-OfferListAccept");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"), locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"), locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("ADD_WITNESS"));
		wdUtil.findBySendKeys(locators.get("ADDLN_WITNESS_NAME"), locators.get("WITNESS_NAME_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//wdUtil.optionButton(locators.get("COURT_PAY"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("unrep acknowledge court docs for claim");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproRejectOfferCourtNVC()
	{
		mibproUserClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Summary
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		//answer NVC
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("VEHICLE_DAMAGE"));
		wdUtil.optionButton(locators.get("VEHICLE_WRITTENOFF"));
		wdUtil.optionButton(locators.get("LOSS_PAID"));
		wdUtil.optionButton(locators.get("INCLUDE_VEH_REPAIR"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("TEMP_VEHICLE"));
		wdUtil.optionButton(locators.get("TEMP_VEH_COST"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DRIVE_TO_GARAGE"));
		wdUtil.optionButton(locators.get("VEHICLE_STORAGE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ADD_NVC_COST"));
		wdUtil.selectListItem(locators.get("CATEGORY_NVC"), locators.get("CATEGORY_NVC_V"));
		wdUtil.findBySendKeys(locators.get("NVC_DESCRIPTION"), locators.get("NVC_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_NVC"), locators.get("LOSS_AMOUNT_NVC_V"));
		wdUtil.checkBox(locators.get("UPLOADED_DOC_CHECK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Unrep goes to court and answer NVC");
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.claimantStatus(mlocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", "Pending-NVCResponse"),"Pending-NVCResponse");
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(mlocators.get("CLAIM_STATUS_MSG"), pslocators.get("Pending-NVCResponse"));	
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproRejectOfferCounterOfferUpliftCourtNVC()
	{
		mibproUserClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("TARIFFUPLIFT"));
		wdUtil.findBySendKeys(locators.get("VALUATION"), locators.get("COUNTEROFFERUPLIFT_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFERUPLIFT_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("VALUATION"), locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Summary
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		//answer NVC
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("VEHICLE_DAMAGE"));
		wdUtil.optionButton(locators.get("VEHICLE_WRITTENOFF"));
		wdUtil.optionButton(locators.get("LOSS_PAID"));
		wdUtil.optionButton(locators.get("INCLUDE_VEH_REPAIR"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("TEMP_VEHICLE"));
		wdUtil.optionButton(locators.get("TEMP_VEH_COST"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DRIVE_TO_GARAGE"));
		wdUtil.optionButton(locators.get("VEHICLE_STORAGE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ADD_NVC_COST"));
		wdUtil.selectListItem(locators.get("CATEGORY_NVC"), locators.get("CATEGORY_NVC_V"));
		wdUtil.findBySendKeys(locators.get("NVC_DESCRIPTION"), locators.get("NVC_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_NVC"), locators.get("LOSS_AMOUNT_NVC_V"));
		wdUtil.checkBox(locators.get("UPLOADED_DOC_CHECK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro goes to court and answer NVC");
		GetDriver.getInstance().setDriver(driver);
	}

	public void mibproRejectOfferCounterOfferCourtNVC()
	{
		mibproUserClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("VALUATION"), locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Summary
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		//answer NVC
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("VEHICLE_DAMAGE"));
		wdUtil.optionButton(locators.get("VEHICLE_WRITTENOFF"));
		wdUtil.optionButton(locators.get("LOSS_PAID"));
		wdUtil.optionButton(locators.get("INCLUDE_VEH_REPAIR"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("TEMP_VEHICLE"));
		wdUtil.optionButton(locators.get("TEMP_VEH_COST"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DRIVE_TO_GARAGE"));
		wdUtil.optionButton(locators.get("VEHICLE_STORAGE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ADD_NVC_COST"));
		wdUtil.selectListItem(locators.get("CATEGORY_NVC"), locators.get("CATEGORY_NVC_V"));
		wdUtil.findBySendKeys(locators.get("NVC_DESCRIPTION"), locators.get("NVC_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_NVC"), locators.get("LOSS_AMOUNT_NVC_V"));
		wdUtil.checkBox(locators.get("UPLOADED_DOC_CHECK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro goes to court and answer NVC");
		GetDriver.getInstance().setDriver(driver);
	}



	public void mibprouserGotoCourtOcs4()
	{
		mibproUserClaimStatus("Pending-RespondCounterFees");
		wdUtil.clickLink(locators.get("GOTOCOURTLINK"));
		wdUtil.optionButton(locators.get("COURT_DECIDE_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		// select court documents
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("claimant proceed with court over fee proposal");
		GetDriver.getInstance().setDriver(driver);		
	}
	

	public void mibprouserGotoCourtFeeProposal()
	{
		mibproUserClaim();
		wdUtil.clickLink(locators.get("GOTOCOURTLINK"));
		wdUtil.optionButton(locators.get("COURT_VALUE_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		//select court documents		
		wdUtil.optionButton(locators.get("VEHICLE_DAMAGE"));
		wdUtil.optionButton(locators.get("VEHICLE_WRITTENOFF"));
		wdUtil.optionButton(locators.get("LOSS_PAID"));
		wdUtil.optionButton(locators.get("INCLUDE_VEH_REPAIR"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("TEMP_VEHICLE"));
		wdUtil.optionButton(locators.get("TEMP_VEH_COST"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DRIVE_TO_GARAGE"));
		wdUtil.optionButton(locators.get("VEHICLE_STORAGE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ADD_NVC_COST"));
		wdUtil.selectListItem(locators.get("CATEGORY_NVC"), locators.get("CATEGORY_NVC_V"));
		wdUtil.findBySendKeys(locators.get("NVC_DESCRIPTION"),locators.get("NVC_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_NVC"),locators.get("LOSS_AMOUNT_NVC_V"));
		wdUtil.checkBox(locators.get("UPLOADED_DOC_CHECK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.scrollDown(locators.get("FINISH"));
		wdUtil.findByClick(locators.get("FINISH"));
		GetDriver.getInstance().setDriver(driver);	
		System.out.println("MIBProuser answered NVC");	
	}

	public void mibprouserSelectCourtDocs()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("SUBMIT"));
		wdUtil.findByClick(locators.get("DEFENDANTCLAIM"));
		wdUtil.checkBox(locators.get("DEFENDANTCLAIMCHECKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("DOCSCLAIMANTCONFIRMED"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.defaultContent();
		System.out.println("claimant court documents submitted successfully");
		GetDriver.getInstance().setDriver(driver);		

	}
	public void mibprouserSelectCourtDocsCompensatorResponse()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		//Preparing for court
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Documents for court
		wdUtil.findByClick(locators.get("COURT_VAL"));
		wdUtil.checkBox(locators.get("COURT_VAL_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		/*
		 * wdUtil.findByClick(locators.get("ANYOTHERCLAIM_YES"));
		 * wdUtil.findByClick(locators.get("COURTPROCEEDING"));
		 * wdUtil.findByClick(locators.get("COURTDECISION"));
		 * wdUtil.findBySendKeys((locators.get("COURTNOTE")),locators.get("COURTNOTE_V")
		 * ); wdUtil.findByClick(locators.get("CONTINUE")); wdUtil.defaultContent();
		 * wdUtil.switchToFrame(locators.get("FRAME1"));
		 * wdUtil.findByClick(locators.get("MEDICALREPORT"));
		 * wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		 * wdUtil.findByClick(locators.get("CONTINUE")); wdUtil.defaultContent();
		 * wdUtil.switchToFrame(locators.get("FRAME1"));
		 * wdUtil.checkBox(locators.get("DOCSCLAIMANTCONFIRMED"));
		 * wdUtil.findByClick(locators.get("FINISH")); wdUtil.defaultContent();
		 */
		System.out.println("claimant court documents submitted successfully");
		GetDriver.getInstance().setDriver(driver);		
	}

	public void mibprouserDocumentAcknowledgemtWit() 
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"), locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"), locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("ADD_WITNESS"));
		wdUtil.findBySendKeys(locators.get("ADDLN_WITNESS_NAME"),
				locators.get("WITNESS_NAME_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));

		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("claimant acknowledged the docs");
		GetDriver.getInstance().setDriver(driver);		

	}

	public void mibproAckDocsInterim() 
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEWCOMPRESPONSE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("mibpro review interim court docs");
		GetDriver.getInstance().setDriver(driver);

	}

	public void mibprouserDisputeAckCourtDocsClaim(String status) 
	{
		mibproUserClaimStatus(status);
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"), locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"), locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("claimant acknowledged the docs");
		GetDriver.getInstance().setDriver(driver);		
	}
	public void mibproReviewInterimCourtDocs() 
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"), locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"), locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("MIBPRO review interim court docs");
		GetDriver.getInstance().setDriver(driver);

	}
	


	public void mibprouserGotocourtliabilityrej()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ANYOTHERCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		GetDriver.getInstance().setDriver(driver);		
	}

	public void mibproChallengeLiabilityDecision() 
	{
		mibproUserClaim();
		wdUtil.clickLink(locators.get("CHALLENGEPARTLBLTY"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CLAIMANTCHALLANGECOMMENT"), locators.get("CLAIMANTCHALLANGECOMMENT_V"));
		wdUtil.optionButton(locators.get("DRIVER_RESPONSIBLE"));
		wdUtil.findBySendKeys(locators.get("CHALLENGE_PERCENTAGE"), locators.get("CHALLENGE_PERCENTAGE_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("MIBpro Challenge Liability Decision");
		GetDriver.getInstance().setDriver(driver);		
	}

	public void mibproReviewChallengeLiabilityDecision() 
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEW_LIABILITY_CHALLENGE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("CHALLENGE_LIABILITY_PROPOSAL"));
		wdUtil.findBySendKeys(locators.get("CHALLENGE_PERCENTAGE"), locators.get("CHALLENGE_PERCENTAGE_V"));
		wdUtil.findBySendKeys(locators.get("CLAIMANTCHALLANGECOMMENT"), locators.get("CLAIMANTCHALLANGECOMMENT_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro review and challenge liability decision");
		GetDriver.getInstance().setDriver(driver);		
	}
	

	public void mibproVerifyChallengeLiability()
	{
		mibproUserClaim();
		wdUtil.assertLink(locators.get("CHALLENGEPARTLBLTY"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void mibProuserAcceptPrognosis()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("SUBMIT"));
		wdUtil.defaultContent();
		//ADD LOSS METHOD
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING"));
		wdUtil.optionButton(locators.get("PROCEEDTOOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("ISUPLIFTJUSTIFIED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		GetDriver.getInstance().setDriver(driver);    
	}

	public void mibProuserRequestForSecondMedicalReport()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT_NO"));
		wdUtil.findBySendKeys(locators.get("FACTUALLYINCORRECT"),locators.get("FACTUALLYINCORRECT_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("Mib claimant request for another medical report");
		GetDriver.getInstance().setDriver(driver);
	}

	public void mibProuserAcceptPrognosisAfterSecondReport()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("SUBMIT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING"));
		wdUtil.optionButton(locators.get("ADDITIONALREPORT"));
		wdUtil.optionButton(locators.get("PROCEEDTOOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		GetDriver.getInstance().setDriver(driver);       

	}
	
	public void mibproGotoCourtFinalOffer()
	{
		mibproUserClaimStatus("Pending-FinalWithdrawn");
		wdUtil.clickLink(locators.get("GO_TO_COURT_LINK"));
		wdUtil.optionButton(locators.get("COURT_VALUE_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		System.out.println("MIBpro goes to court");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproAnswerNVC() {

		mibproUserClaimStatus("Pending-NVCClaimant");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("VEHICLE_DAMAGE"));
		wdUtil.optionButton(locators.get("VEHICLE_WRITTENOFF"));
		wdUtil.optionButton(locators.get("LOSS_PAID"));
		wdUtil.optionButton(locators.get("INCLUDE_VEH_REPAIR"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("TEMP_VEHICLE"));
		wdUtil.optionButton(locators.get("TEMP_VEH_COST"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DRIVE_TO_GARAGE"));
		wdUtil.optionButton(locators.get("VEHICLE_STORAGE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ADD_NVC_COST"));
		wdUtil.selectListItem(locators.get("CATEGORY_NVC"), locators.get("CATEGORY_NVC_V"));
		wdUtil.findBySendKeys(locators.get("NVC_DESCRIPTION"), locators.get("NVC_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_NVC"), locators.get("LOSS_AMOUNT_NVC_V"));
		wdUtil.checkBox(locators.get("UPLOADED_DOC_CHECK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		GetDriver.getInstance().setDriver(driver);
		System.out.println("Prouser answered NVC");

	}


	public void mibprouserAcceptFinalOffer()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_FINAL_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWFEESPROPOSAL"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ACCEPT_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("MIBpro accepts offer and fee proposal");
		GetDriver.getInstance().setDriver(driver);       

	}
	public void mibprouserAcceptoffer()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEW_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ACCEPT_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro accepts offer and fee proposal");
		GetDriver.getInstance().setDriver(driver);       

	}
	public void mibprouserReopenandGoToCourtOCS5()
	{
		switchClaimsPortal();
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("RESOLVEDCLAIMLIST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		//wdUtil.clickLink(locators.get("SHOWFILTERS"));
		//wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
		//wdUtil.findByClick(locators.get("FILTER"));
		wdUtil.doubleClick(mlocators.get("RESOLVED_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("GOTOCOURTLINK"));
		wdUtil.optionButton(locators.get("COURT_DECIDE_NONPAYMENTFORFEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("MIBpro proceeds to select documents");
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPT_OFFER"));
		wdUtil.checkBox(locators.get("ACCEPT_OFFER_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(mlocators.get("SIGNED_DOC"));
		wdUtil.checkBox(mlocators.get("SIGNED_DOC_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("MIBpro goes to court");
		GetDriver.getInstance().setDriver(driver);       

	}
	
	public void mibproCausationDisputeOffer()
	{
		mibproUserClaimStatus("Pending-CausationNoOffer");
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("claimant accepts dispute decision");
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("RESOLVED_CLAIM"));
		//wdUtil.clickLink(locators.get("SHOWFILTERS"));
		//wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
		//wdUtil.findByClick(locators.get("FILTER"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.claimantStatus(mlocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", "Resolved-NoOffer"),"Resolved-NoOffer");
		wdUtil.doubleClick(locators.get("RESOLVED_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(mlocators.get("CLAIM_STATUS_MSG"), pslocators.get("Resolved-NoOffer"));	
		System.out.println("Claim is moved to Resolved-NoOffer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproRejectcausationDisputeFinalOffer()
	{
		mibproUserClaimStatus("Pending-CausationFinalOffer");
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("OFFER_FINAL_REJECT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("claimant rejects dispute decision");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproAckCourtDocsLiability() 
	{
		mibproUserClaimStatus("Pending-LiabilityListAccept");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"), locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"), locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("ADD_WITNESS"));
		wdUtil.findBySendKeys(locators.get("ADDLN_WITNESS_NAME"), locators.get("WITNESS_NAME_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_PAY"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("unrep acknowledge court docs for claim");
		GetDriver.getInstance().setDriver(driver);
	}

	
	public void mibproGoToCourtRejectLiability() 
	{
		mibproUserClaimStatus("Pending-LiabilityRejected");
		wdUtil.findByClick(locators.get("VIEWMOREDETREP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("DOCS_COURT"));;
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ANYOTHERCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(mlocators.get("SIGNED_DOC"));
		wdUtil.checkBox(mlocators.get("SIGNED_DOC_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("unrep go to court and reject liability");
		GetDriver.getInstance().setDriver(driver);

	}

	public void acceptRejectedOffer()
	{
		mibproUserClaim();
		wdUtil.clickLink(locators.get("ACCEPT_REJECT_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("ACCEPT_THIS_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPT"));
		GetDriver.getInstance().setDriver(driver);

	}

	public void mibprouserReviewmedReportandProceedOfferwithuplift()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_YES"));
		wdUtil.findByClick(locators.get("SUPPORT_GREATERVALUE"));
		wdUtil.findByClick(locators.get("WHIPLASH_INJURY"));
		wdUtil.findBySendKeys(locators.get("SEVERE_INJURY"),locators.get("SEVERE_INJURY_V"));
		wdUtil.findByClick(locators.get("EXCEPTIONAL_CIRCUMSTANCE"));
		wdUtil.findBySendKeys(locators.get("EXCEPTIONAL_CIRCUM"),locators.get("EXCEPTIONAL_CIRCUM_V"));
		wdUtil.findBySendKeys(locators.get("UPLIFT_PERCENT"),locators.get("UPLIFT_PERCENT_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("MIBpro Review medical report with uplift");
		GetDriver.getInstance().setDriver(driver);  
	}
	public void mibproVerifyAddLoss()
	{
		mibproUserClaim();
		wdUtil.assertLink(locators.get("ADD_LOSS_LINK"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void addLossAndFee() 
	{
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		// Add Loss
		wdUtil.selectListItem(locators.get("LOSS_TYPE"), locators.get("LOSS_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE"));
		// Add Fee
		wdUtil.findByClick(locators.get("ADDANOTHERLOSS"));
		wdUtil.selectListItem(locators.get("FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING_FEE"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION_FEE"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_FEE"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("Losses and Fee are Added");
		GetDriver.getInstance().setDriver(driver);
	}
	public void addLossAndFeeFromTile() 
	{
		mibproUserClaim();
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		// Add Loss
		wdUtil.selectListItem(locators.get("LOSS_TYPE"), locators.get("LOSS_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE"));
		// Add Fee
		wdUtil.findByClick(locators.get("ADDANOTHERLOSS"));
		wdUtil.selectListItem(locators.get("FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING_FEE"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION_FEE"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_FEE"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("Losses and Fee are Added");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproRequestForSecondMedReport() 
	{
		mibproUserClaimStatus("Pending-CheckMedical");
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT_NO"));
		wdUtil.findBySendKeys(locators.get("FACTUALLYINCORRECT"), locators.get("FACTUALLYINCORRECT_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		mibproUserClaimStatusEnd("Pending-MRPReportReject");
		System.out.println("MIBpro requested for further medical report after factually incorrect");
		GetDriver.getInstance().setDriver(driver);
	}


	public void addLoss()
	{

		mibproUserClaimStatus("Pending-CheckMedical");
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.selectListItem(locators.get("LOSS_TYPE"),locators.get("LOSS_TYPE_V"));
		wdUtil.waitFor(5000);
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"),locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"),locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("MIBpro Losses Added");
		GetDriver.getInstance().setDriver(driver);		
	}
	public void addLossOnly()
	{

		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.selectListItem(locators.get("LOSS_TYPE"),locators.get("LOSS_TYPE_V"));
		wdUtil.waitFor(5000);
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"),locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"),locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("MIBpro Losses Added");
		GetDriver.getInstance().setDriver(driver);		
	}

	public void addDocument()
	{
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("UPLOAD_DOC_LINK"));
		wdUtil.uploadDoc(locators.get("SELECT_FILE"));
		wdUtil.selectListItem(locators.get("CATEGORYPRODOC"), locators.get("CATEGORYPRODOC_V"));
		wdUtil.findByClick(locators.get("UPLOAD_BUTTON"));
		System.out.println("MIBpro Documents Added");
		GetDriver.getInstance().setDriver(driver);	

	}
	
	public void mibproReviewReportAndProceedWithOfferUplift() {
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		// UPLIFT
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_YES"));
		wdUtil.findByClick(locators.get("SUPPORT_GREATERVALUE"));
		wdUtil.findByClick(locators.get("WHIPLASH_INJURY"));
		wdUtil.findBySendKeys(locators.get("SEVERE_INJURY"),locators.get("SEVERE_INJURY_V"));
		wdUtil.findByClick(locators.get("EXCEPTIONAL_CIRCUMSTANCE"));
		wdUtil.findBySendKeys(locators.get("EXCEPTIONAL_CIRCUM"),locators.get("EXCEPTIONAL_CIRCUM_V"));
		wdUtil.findBySendKeys(locators.get("UPLIFTPERCENTAGE"), locators.get("UPLIFTPERCENTAGE_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//Review Loss
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS_ACCURATE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("MIBPRO review medical report with uplift");
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void mibproReviewMRAndProceedWithOfferUplift() {
		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		// UPLIFT
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_YES"));
		wdUtil.findByClick(locators.get("SUPPORT_GREATERVALUE"));
		wdUtil.findByClick(locators.get("WHIPLASH_INJURY"));
		wdUtil.findBySendKeys(locators.get("SEVERE_INJURY"),locators.get("SEVERE_INJURY_V"));
		wdUtil.findByClick(locators.get("EXCEPTIONAL_CIRCUMSTANCE"));
		wdUtil.findBySendKeys(locators.get("EXCEPTIONAL_CIRCUM"),locators.get("EXCEPTIONAL_CIRCUM_V"));
		wdUtil.findBySendKeys(locators.get("UPLIFTPERCENTAGE"), locators.get("UPLIFTPERCENTAGE_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//Review Loss
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS_ACCURATE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("MIBPRO review medical report with uplift");
		GetDriver.getInstance().setDriver(driver);

	}



	public void mibprouserRequestForRevisedOfferIncludingUplift()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWOFFER_MIB"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DISPUTEOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("TARIFFUPLIFT"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFERUPLIFT_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("request for revised offer sent to compensator");
		GetDriver.getInstance().setDriver(driver);       

	}

	public void mibproProceedOfferBeforeWOP()
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWMOREDETREP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ISSTILLSUFFERING"));
		//wdUtil.findByClick(locators.get("FURTHER_MEDREPORT"));
		wdUtil.findByClick(locators.get("PROCEEDTOOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Remove losses screen
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("MIBpro proceeds with offer");
	}
	
	public void mibproReviewreportAcceptWOP() 
	{

		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		//wdUtil.findByClick(locators.get("SUBMITMEDREPCHOICES"));
		System.out.println("Report reviewed");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproAcceptWaitoutAddLossProceedtoOffer() 
	{
		mibproUserClaimStatus("Pending-WaitPrognosisOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		//ADD LOSS
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		wdUtil.selectListItem(locators.get("LOSS_TYPE"), locators.get("LOSS_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//Proceed to offer
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING_YES"));
		wdUtil.findByClick(locators.get("ADDITIONALREPORT_NO"));
		wdUtil.findByClick(locators.get("PROCEEDOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("MIBPRO accept wait out prognosis and proceed to offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproAcceptOfferAndFee() 
	{
		mibproUserClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("OFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("REVIEW_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ACCEPT_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Unrep Accept Offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproAcceptOfferAndRequestFee() 
	{
		mibproUserClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("OFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEW_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("REQUEST_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Add Fee
		wdUtil.selectListItem(locators.get("ADD_FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("FEE_EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("FEE_EVIDENCE_AVAILABLE"));		
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro Accept Offer and request for fee");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproRequestFee()
	{
		mibproUserClaimStatus(" Pending-ReviewFeesOffer");
		wdUtil.findByClick(locators.get("REVIEW_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("REQUEST_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Add Fee
		wdUtil.selectListItem(locators.get("ADD_FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("FEE_EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("FEE_EVIDENCE_AVAILABLE"));		
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro request for fee");
		
	}

	public void mibproAcceptWaitOutPrognosisReleaseToComp()
	{

		mibproUserClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("SUBMITMEDREPCHOICES"));
		System.out.println("Report reviewed");
		GetDriver.getInstance().setDriver(driver);
	}

	public void mibproAddLossAndFeeProceedToOffer()
	{
		mibproUserClaimStatus("Pending-ProceedClaim");
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		// Add Loss
		wdUtil.selectListItem(locators.get("LOSS_TYPE"), locators.get("LOSS_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE"));
		// Add Fee
		wdUtil.findByClick(locators.get("ADDANOTHERLOSS"));
		wdUtil.selectListItem(locators.get("FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING_FEE"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION_FEE"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_FEE"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("Losses and Fee are Added");
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("PROCEED_BUTTON"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("PROCEED_BUTTON"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		//Check Medical Report
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		// NO UPLIFT
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//Review loss
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Review Fee
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS"));
		wdUtil.checkBox(mlocators.get("LIST_LOSS_ACCURATE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("MIBpro Add losses and proceed with offer successfully");
	}
	

	public void mibproAddLossAndProceedToOffer() 
	{
		mibproUserClaim();
		wdUtil.clickLink(locators.get("ADDLOSS"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.selectListItem(locators.get("LOSS_TYPE"), locators.get("LOSS_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("NOEVIDENCETOUPLOAD"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEWMOREDETREP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING"));
		//wdUtil.optionButton(locators.get("ADDITIONALREPORT_NO"));
		wdUtil.optionButton(locators.get("PROCEEDTOOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("MIBpro Add losses and proceed with offer successfully");
		GetDriver.getInstance().setDriver(driver);		

	}

	public void mibproAddLossAndFeeAndProceedToOffer() 
	{
		mibproUserClaim();
		wdUtil.clickLink(locators.get("ADDLOSS"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.selectListItem(locators.get("LOSS_TYPE"), locators.get("LOSS_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("NOEVIDENCETOUPLOAD"));
		// Add Fee
		wdUtil.findByClick(locators.get("ADDANOTHERLOSS"));
		wdUtil.selectListItem(locators.get("FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING_FEE"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION_FEE"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_FEE"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEWMOREDETREP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING"));
		//wdUtil.optionButton(locators.get("ADDITIONALREPORT_NO"));
		wdUtil.optionButton(locators.get("PROCEEDTOOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("MIBpro Add losses and proceed with offer successfully");
		GetDriver.getInstance().setDriver(driver);		

	}

	public void mibproReviewFeeproposal()
	{
		mibproUserClaimStatus("Pending-ReviewFeesOffer");
		wdUtil.findByClick(locators.get("REVIEW_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ACCEPT_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		GetDriver.getInstance().setDriver(driver);

	}

	public void mibproGotocourtOCS3()   
	{

		mibproUserClaim();
		wdUtil.clickLink(locators.get("GO_TO_COURT_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("NO_PAYMT_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("VIEWMOREDETREP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("INTERIM"));
		wdUtil.checkBox(locators.get("INTERIM_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("MIBpro goes to court and select court documents for interim");
		GetDriver.getInstance().setDriver(driver);

	}
	public void mibproAddFee() 
	{
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.doubleClick(mlocators.get("MIB_CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));

		// Add Fee
		wdUtil.selectListItem(locators.get("ADD_FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("FEE_EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("FEE_EVIDENCE_AVAILABLE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		System.out.println("Mibpro adds Fee");
		GetDriver.getInstance().setDriver(driver);
	}

	public void slaBreached() {

		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		// SLA breach setup for 5 mins
		driver.navigate().refresh();
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("LOGOUT"));
		wdUtil.waitFor(360000);
	}
	
	public void mibproReopenClaimLiability()
	{
		switchClaimsPortal();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("RESOLVED_CLAIM"));
		wdUtil.clickLink(locators.get("SHOWFILTERS"));
		wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
		wdUtil.findByClick(locators.get("FILTER"));
		wdUtil.claimantStatus(mlocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", "Resolved-CourtLiability"),"Resolved-CourtLiability");
		wdUtil.doubleClick(locators.get("RESOLVED_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(mlocators.get("CLAIM_STATUS_MSG"), pslocators.get("Resolved-CourtLiability"));
		wdUtil.clickLink(locators.get("REOPEN_LIABILITY"));
		wdUtil.optionButton(locators.get("COURT_LIABILITY_DECISION"));
		wdUtil.selectListItem(locators.get("LIABILITY_DECISION"), locators.get("LIABILITY_DECISION_PART_V"));
		wdUtil.findBySendKeys(locators.get("LIABILITY_PERCENTAGE"), locators.get("LIABILITY_PERCENTAGE_V"));
		wdUtil.findBySendKeys(locators.get("COURT_CLAIM_NO"), locators.get("COURT_CLAIM_NO_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_ORDER_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro reopen the claim and select DME");
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void resolvedStatus(String status)
	{
		switchClaimsPortal();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("RESOLVED_CLAIM"));
		wdUtil.clickLink(locators.get("SHOWFILTERS"));
		wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
		wdUtil.findByClick(locators.get("FILTER"));
		wdUtil.claimantStatus(mlocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", status),status);
		wdUtil.doubleClick(locators.get("RESOLVED_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(mlocators.get("CLAIM_STATUS_MSG"), pslocators.get(status));	
		System.out.println("Claim is moved to "+status);
		GetDriver.getInstance().setDriver(driver);
	}

	public void logout()
	{

		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("LOGOUT"));
	}
	
	public void MIBProuserSelectCourtDocsthirdtimeNVC() 
	{
		mibproUserClaim();
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		wdUtil.findByClick(locators.get("COURT_VALIDATION"));
		wdUtil.checkBox(locators.get("COURT_VALIDATION_CHKBOX"));
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("ACCEPT_INTERIM_PAYMENT"));
		wdUtil.checkBox(locators.get("ACCEPT_INTERIM_PAYMENT_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBPro select court docs");
		
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void MIBProcourtScreen(String Claimant_represent,String Defendant_details,String GotoCourt,String Oral_hearing,String Witnesses,String CourtPackEvidence,String NVC,String Fees,String CourtFeePayable,String AddCourtFeePayable ) 
	{
		mibproUserClaim();
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		//Confirmation of Court Pack list
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		if (Claimant_represent.equalsIgnoreCase("Yes")) {
		wdUtil.optionButton(locators.get("PRO_DIFF_ADDR"));
		wdUtil.findBySendKeys(locators.get("FIXED_LEGAL_COST"),locators.get("FIXED_LEGAL_COST_V"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		}
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		if (Defendant_details.equalsIgnoreCase("Yes")) {
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		if (GotoCourt.equalsIgnoreCase("Yes")) {
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"),locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"),locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if (Oral_hearing.equalsIgnoreCase("Yes")) {
		wdUtil.findByClick(locators.get("HEARING_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if (Witnesses.equalsIgnoreCase("Yes")) {
		wdUtil.findByClick(locators.get("ADD_WITNESS"));
		wdUtil.findBySendKeys(locators.get("ADDLN_WITNESS_NAME"), locators.get("WITNESS_NAME_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if (CourtPackEvidence.equalsIgnoreCase("Yes")) {
			wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_YES"));
			wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));

		if (NVC.equalsIgnoreCase("Yes")) {
			wdUtil.optionButton(locators.get("NVC_CLAIM"));
			wdUtil.findByClick(locators.get("CONTINUE"));
		}
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if (Fees.equalsIgnoreCase("Yes")) {
			wdUtil.findByClick(locators.get("FEE_LINK"));
			wdUtil.checkBox(locators.get("FEE_CHKBOX"));
			wdUtil.findBySendKeys(locators.get("INVOICE_PROVIDER"), locators.get("INVOICE_PROVIDER_V"));
			wdUtil.selectListItem(locators.get("FEE_DATE"), locators.get("FEE_DATE_V"));
			wdUtil.selectListItem(locators.get("FEE_MONTH"), locators.get("FEE_MONTH_V"));
			wdUtil.selectListItem(locators.get("FEE_YEAR"), locators.get("FEE_YEAR_V"));
			wdUtil.checkBox(locators.get("DISPUTE_FEE_AMT"));
			wdUtil.findByClick(locators.get("CONTINUE"));
		}
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if (CourtFeePayable.equalsIgnoreCase("Yes")) {
						
			boolean page=wdUtil.isElementPresent(locators.get("COURT_FEE_PAYABLE"));
			if (page== true) {			
				wdUtil.AddLog("Additional court fee payable screen is displayed..");
				wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
			}else {
				wdUtil.AddLog("Additional court fee payable screen is NOT displayed.. Not working as expected");
			}
			
			wdUtil.findByClick(locators.get("CONTINUE"));

		}

		if (AddCourtFeePayable.equalsIgnoreCase("Yes")) {
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			
			boolean page=wdUtil.isElementPresent(locators.get("ADD_COURT_FEE_PAYABLE"));
			if (page== true) {			
				wdUtil.AddLog("Additional court fee payable screen is displayed..");
				wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
			}else {
				wdUtil.AddLog("Additional court fee payable screen is NOT displayed.. Not working as expected");
			}
			
			wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		wdUtil.AddLog("MIBprouser acknowledge court docs");
		GetDriver.getInstance().setDriver(driver);
	}
	
	
	
	public void mibproselectCourtDocsSecondtimeForInterimNonPayment()
	{
		ClaimantActionsPage claimant=new ClaimantActionsPage();
		mibproUserClaim();		
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("DOCS_COURT_AT_INTERIM"));
		//added switch frame in sprint41
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		//end
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		claimant.courtProceedingNo();
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("ACCEPT_INTERIM_PAYMENT"));
		wdUtil.checkBox(locators.get("ACCEPT_INTERIM_PAYMENT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(mlocators.get("SIGNED_DOC"));
		wdUtil.checkBox(mlocators.get("SIGNED_DOC_CHKBOX"));
		//below line newly added in sprint41
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("CONFIRMANDSEND"));
		//below line updated in sprint41
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro selects court documents");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproReviewInterimCourtDocsSecondtime() 
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
                wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("VIEW_MORE"));
                wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
                wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
                wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"), locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"), locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
                wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		claimant.visibilityCourtFeePayable();
		claimant.visibilityAdditionalCourtFeePayable();
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
                wdUtil.findByClick(locators.get("CONTINUE"));
                wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("unrep review interim court docs");
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void mibFirstOfferGoToCourt(String loss,String tariff, String Uplift, String NonTariff)
	{
		mibproUserClaim();
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("SOF"));
		wdUtil.findByClick(locators.get("CONTINUE"));

		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));		
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
				
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		if(loss.equalsIgnoreCase("Yes")) {
			wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
			wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE") );
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		}
		
		if(tariff.equalsIgnoreCase("Yes")) {
			wdUtil.findByClick(locators.get("INJURYTARIFF"));
			wdUtil.findBySendKeys(locators.get("VALUATION"),locators.get("COUNTEROFFER_V") );
			wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE") );
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		}
		if(Uplift.equalsIgnoreCase("Yes")) {
			wdUtil.findByClick(locators.get("TARIFFUPLIFT"));
			wdUtil.findBySendKeys(locators.get("VALUATION"),locators.get("COUNTEROFFER_V") );
			wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE") );
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		}
		if(NonTariff.equalsIgnoreCase("Yes")) {
			wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
			wdUtil.findBySendKeys(locators.get("VALUATION"),locators.get("COUNTEROFFER_V") );
			wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE") );
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		}
		
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		//Summary screen
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		GetDriver.getInstance().setDriver(driver);

	}

	public void courtScreen(String Claimant_represent,String Defendant_details,String GotoCourt,String Oral_hearing,String Witnesses,String CourtPackEvidence,String NVC,String Fees,String CourtFeePayable,String AddCourtFeePayable ) 
	{
		mibproUserClaim();
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		//Confirmation of Court Pack list
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		if (Claimant_represent.equalsIgnoreCase("Yes")) {
		wdUtil.optionButton(locators.get("PRO_DIFF_ADDR"));
		wdUtil.findBySendKeys(locators.get("FIXED_LEGAL_COST"),locators.get("FIXED_LEGAL_COST_V"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		}
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		if (Defendant_details.equalsIgnoreCase("Yes")) {
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		if (GotoCourt.equalsIgnoreCase("Yes")) {
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"),locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"),locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if (Oral_hearing.equalsIgnoreCase("Yes")) {
		wdUtil.findByClick(locators.get("HEARING_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if (Witnesses.equalsIgnoreCase("Yes")) {
		/*wdUtil.findByClick(locators.get("ADD_WITNESS"));
		wdUtil.findBySendKeys(locators.get("ADDLN_WITNESS_NAME"), locators.get("WITNESS_NAME_V"));*/
		wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if (CourtPackEvidence.equalsIgnoreCase("Yes")) {
			wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_YES"));
			wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));

		if (NVC.equalsIgnoreCase("Yes")) {
			wdUtil.optionButton(locators.get("NVC_CLAIM"));
			wdUtil.findByClick(locators.get("CONTINUE"));
		}
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if (Fees.equalsIgnoreCase("Yes")) {
			wdUtil.findByClick(locators.get("FEE_LINK"));
			wdUtil.checkBox(locators.get("FEE_CHKBOX"));
			wdUtil.findBySendKeys(locators.get("INVOICE_PROVIDER"), locators.get("INVOICE_PROVIDER_V"));
			wdUtil.selectListItem(locators.get("FEE_DATE"), locators.get("FEE_DATE_V"));
			wdUtil.selectListItem(locators.get("FEE_MONTH"), locators.get("FEE_MONTH_V"));
			wdUtil.selectListItem(locators.get("FEE_YEAR"), locators.get("FEE_YEAR_V"));
			wdUtil.checkBox(locators.get("DISPUTE_FEE_AMT"));
			wdUtil.findByClick(locators.get("CONTINUE"));
		}
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		if (CourtFeePayable.equalsIgnoreCase("Yes")) {
						
			boolean page=wdUtil.isElementPresent(locators.get("COURT_FEE_PAYABLE"));
			if (page== true) {			
				wdUtil.AddLog("Additional court fee payable screen is displayed..");
				wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
			}else {
				wdUtil.AddLog("Additional court fee payable screen is NOT displayed.. Not working as expected");
			}
			
			wdUtil.findByClick(locators.get("CONTINUE"));

		}

		if (AddCourtFeePayable.equalsIgnoreCase("Yes")) {
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			
			boolean page=wdUtil.isElementPresent(locators.get("ADD_COURT_FEE_PAYABLE"));
			if (page== true) {			
				wdUtil.AddLog("Additional court fee payable screen is displayed..");
				boolean ackcheckbox=wdUtil.isElementPresent(locators.get("CLAIMANT_ACK"));
				if(ackcheckbox==true) {
					wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
				
				}
				else
				{
					System.out.println("checkbox not displayed");
				}
				
			}else {
				wdUtil.AddLog("Additional court fee payable screen is NOT displayed.. Not working as expected");
			}
			wdUtil.scrollDown(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONTINUE"));
		}
		
		wdUtil.defaultContent();		
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("mibprouser acknowledge court docs");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void mibproRejectoffer(String loss,String tariff, String Uplift, String NonTariff)
	{
		mibproUserClaim();
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(mlocators.get("SOT_SIGNED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("BACKTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		if(NonTariff.equalsIgnoreCase("Yes")) {
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		}
		
		if(loss.equalsIgnoreCase("Yes")) {
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		}
		
		if(NonTariff.equalsIgnoreCase("Yes")) {
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"),locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		}
		
		if(Uplift.equalsIgnoreCase("Yes")) {
			wdUtil.findByClick(locators.get("TARIFFUPLIFT"));
			wdUtil.findBySendKeys(locators.get("VALUATION"),locators.get("COUNTEROFFER_V") );
			wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE") );
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		}
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		 wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		 wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("MIBpro rejects offer");
		GetDriver.getInstance().setDriver(driver);
	}

}