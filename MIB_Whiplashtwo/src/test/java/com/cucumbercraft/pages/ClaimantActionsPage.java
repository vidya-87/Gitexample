package com.cucumbercraft.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.WebDriverUtil;

public class ClaimantActionsPage 
{

	Map<String, String> locators = GetDriver.getInstance().getClaimantActionsLocators();
	Map<String, String> slocators = GetDriver.getInstance().getStatusLocators();
	Map<String, String> plocators = GetDriver.getInstance().getProUserLocators();
	
	String claimNumber = GetDriver.getInstance().getOICref();
	//PPMOICREF
	String unrepOIC = locators.get("PPM2_OICREF").replace("$claimNumber", claimNumber);
	//Staging
	//String unrepOIC = locators.get("OICREF").replace("$claimNumber", claimNumber);
	WebDriver driver = GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);
	
	

	public void unrepClaim() 
	{
		wdUtil.findByClick(locators.get("LISTREP")); //STAGING
		//wdUtil.unrepOIC(unrepOIC);--pagination
		wdUtil.findByClick(unrepOIC);
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepClaimStatus(String status) 
	{
		wdUtil.findByClick(locators.get("LISTREP")); //STAGING
		//wdUtil.unrepOIC(unrepOIC);--pagination
		wdUtil.claimantStatus(locators.get("UNREP_CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", status),status);
		//wdUtil.claimantStatus(locators.get("PPM2_STATUS").replace("$claimNumber", claimNumber).replace("$status", status),status);
		wdUtil.findByClick(unrepOIC);
		wdUtil.claimantStatusMSG(locators.get("CLAIM_STATUS_MSG"), slocators.get(status));
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepClaimStatusEnd(String status)
	{
		//wdUtil.scrollDown(locators.get("CLOSE"));
		//wdUtil.findByClick(locators.get("CLOSE"));
		wdUtil.findByClick(locators.get("LISTREP")); //STAGING
		wdUtil.claimantStatus(locators.get("UNREP_CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", status),status);

		//wdUtil.claimantStatus(locators.get("PPM2_STATUS").replace("$claimNumber", claimNumber).replace("$status", status),status);
		wdUtil.findByClick(unrepOIC);
		wdUtil.claimantStatusMSG(locators.get("CLAIM_STATUS_MSG"), slocators.get(status));
		wdUtil.findByClick(locators.get("CLOSE"));
	}

	public void proUserClaim()
	{
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepAcceptDecision() 
	{
		unrepClaimStatus("Pending-LiabilityRejected");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.optionButton(locators.get("ACCEPT_DECISION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		unrepClaimStatusEnd("Pending-RejectedLiability");
		System.out.println("Unrep Decision accepted");
		GetDriver.getInstance().setDriver(driver);
	}
	public void unrepUploadOwnReportWithoutPrognosis() 
	{
		unrepClaimStatus("Pending-UploadOwnMedical");
		wdUtil.findByClick(locators.get("PROCEED_MEDICAL"));
		wdUtil.waitFor(7000);
		wdUtil.optionButton(locators.get("EXAM_PLACE_OUTSIDE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//upload medical report
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
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
		System.out.println("Unrep uploads own medical report");
		GetDriver.getInstance().setDriver(driver);		
	}

	public void unrepUploadRevisedMR()
	{
		unrepClaimStatus("Pending-FurtherReport");
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
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
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("SAVE_EXIT"));
		System.out.println("Unrep uploads revised medical report");
		GetDriver.getInstance().setDriver(driver);	
	}

	public void unrepUploadRevisedMedReport()
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadRevisedMR(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(5000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("ADDITIONALREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("SAVE_EXIT"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Unrep uploads revised medical report");
		GetDriver.getInstance().setDriver(driver);	
	}
	public void unrepUploadOwnReportAddlnRepFromComp() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("PROCEED_MEDICAL"));
		wdUtil.waitFor(7000);
		wdUtil.optionButton(locators.get("EXAM_PLACE_OUTSIDE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPT_CONTINUE"));
		//upload medical report
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
		wdUtil.selectListItem(locators.get("PROG_PERIOD"), locators.get("PROG_PERIOD_V"));
		wdUtil.scrollDown(locators.get("FROM_MED_REPORT"));
		wdUtil.waitFor(7000);
		wdUtil.optionButton(locators.get("FROM_MED_REPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.optionButton(locators.get("FURTHER_MEDREPORT_COMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("REQ_FURTHER_REPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.selectListItem(locators.get("MED_JUSTI_ADDLN"), locators.get("MED_JUSTI_ADDLN_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.optionButton(locators.get("RELCOMCOMP"));
		wdUtil.findBySendKeys(locators.get("INJURY_DESC"), locators.get("INJURY_DESC_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("ISUPLIFTJUSTIFIED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("Unrep uploads revised medical report and proceed to offer");
		GetDriver.getInstance().setDriver(driver);		
	}

	public void unrepProceedToOfferAfterReportUpload()
	{
		unrepClaimStatus("Pending-CheckMedical");
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("ISUPLIFTJUSTIFIED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Unrep proceed to offer after adding loss and fee");
		GetDriver.getInstance().setDriver(driver);		
	}


	
	

	public void prouserAcceptOfferAndFee() {
		proUserClaim();
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("OFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		System.out.println();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEW_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ACCEPT_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Prouser Accept Offer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void prouserChallengeLiabilityDecision() {
		proUserClaim();
		wdUtil.clickLink(locators.get("CHALLENGEPARTLBLTY"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CHALLENGE_PERCENTAGE"), locators.get("CHALLENGE_PERCENTAGE_V"));
		wdUtil.findBySendKeys(locators.get("CLAIMANTCHALLANGECOMMENT"), locators.get("CLAIMANTCHALLANGECOMMENT_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("prouser Challenge Liability Decision");
		GetDriver.getInstance().setDriver(driver);
	}

	public void prouserReviewChallengeLiabilityDecision() {
		proUserClaim();
		wdUtil.findByClick(locators.get("REVIEW_LIABILITY_CHALLENGE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("PROCESS_THIS_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.optionButton(locators.get("CHALLENGE_LIABILITY_DECISION"));
		wdUtil.findBySendKeys(locators.get("CHALLENGE_PERCENTAGE"), locators.get("CHALLENGE_PERCENTAGE_V"));
		wdUtil.findBySendKeys(locators.get("CLAIMANTCHALLANGECOMMENT"), locators.get("CLAIMANTCHALLANGECOMMENT_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("prouser review and challenge liability decision");
		GetDriver.getInstance().setDriver(driver);
	}

	public void waitoutNewReportAtOffer() {
		proUserClaim();
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("WAITOUTPROGOPTION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("SUBMIT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		//wdUtil.findByClick(locators.get("ISSTILLSUFFERING"));
		wdUtil.findByClick(locators.get("ADDITIONALREPORT_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("FINISH"));
		// upload new medical report
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		System.out.println("uploading new medical report");
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadNewMedicalReport(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		// uplift
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		System.out.println("Proceed with offer");
		// Proceed with offer
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("PROCEED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("FINISH"));

	}

	

	public void uploadMedicalReportWithWaitOutPeriod(String uplift) {
		proUserClaim();
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findBySendKeys(locators.get("MEDCOSEARCHREF"), locators.get("MEDCOSEARCHREF_V"));

		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadFile(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"),
				locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));

		//wdUtil.optionButton(locators.get("MEDCOIDUSED_YES"));
		wdUtil.waitFor(10000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(5000);
		wdUtil.selectListItem(locators.get("PROG_PERIOD"), locators.get("PROG_PERIOD_24"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("FROM_MED_EXAM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		switch (uplift) 
		{
		case "UPLIFT_NO":
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("VIEW_MORE"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME2"));
			wdUtil.optionButton(locators.get("ISSTILLSUFFERING"));
			wdUtil.findByClick(locators.get("SAVE_EXIT"));
			wdUtil.defaultContent();
			break;
		case "UPLIFT_YES":
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME2"));
			wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_YES"));
			wdUtil.findByClick(locators.get("WHIPLASH_INJURY"));
			wdUtil.findByClick(locators.get("SUPPORT_GREATERVALUE"));
			wdUtil.findBySendKeys(locators.get("EXCEPTIONAL_CIRCUM"), locators.get("EXCEPTIONAL_CIRCUM_V"));
			wdUtil.findBySendKeys(locators.get("UPLIFT_PERCENT"), locators.get("UPLIFT_PERCENT_V"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME2"));
			wdUtil.scrollDown(locators.get("WAITOUTPROGOPTION"));
			wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
			wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME2"));
			wdUtil.findByClick(locators.get("FINISH"));
			break;
		}
		System.out.println("Prouser uploaded medical report with waitout prognosis");
		GetDriver.getInstance().setDriver(driver);
	}

	public void upliftSubmit() {
		proUserClaim();
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		GetDriver.getInstance().setDriver(driver);
	}


	

	public void unrepGotoCourtForInterimNonPayment() 
	{
		unrepClaim();
		wdUtil.clickLink(locators.get("GOTOCOURTINTERIM"));
		wdUtil.checkBox(locators.get("NOT_RECEIVED_PAYMENT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("CONFIRM"));
		System.out.println("Unrep goes to court for interim non payment");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepselectCourtDocsForInterimNonPayment() {
		unrepClaim();
		wdUtil.findByClick(locators.get("DOCS_COURT_AT_INTERIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("INTERIM"));
		wdUtil.checkBox(locators.get("INTERIM_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("FINISH"));
		wdUtil.findByClick(locators.get("CLOSE"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void prouserselectCourtDocsForInterimNonPayment() {
		proUserClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		
		wdUtil.findByClick(locators.get("DOCS_COURT_AT_INTERIM"));
		
		//wdUtil.findByClick(locators.get("INTERIM_RESPONSE"));
		//wdUtil.checkBox(locators.get("INTERIM_RESPONSE_CHKBOX").replace("$claimNumber", claimNumber));
		
		//Preparing for court
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.scrollDown(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		//Document selection
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		
		wdUtil.findByClick(locators.get("ACCEPT_INTERIM_PAYMENT"));
		wdUtil.checkBox(locators.get("ACCEPT_INTERIM_PAYMENT_CHKBOX"));
		
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		//wdUtil.checkBox(locators.get("REVDOCSCOURTCHK"));
		
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CLOSE"));
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		System.out.println("prouser select court docs for interim nonpayment");
		wdUtil.AddLog("Prouser select court docs for interim nonpayment");
		
		GetDriver.getInstance().setDriver(driver);
	}

	public void prouserGotoCourtForInterimNonPayment() {
		proUserClaim();
		wdUtil.clickLink(locators.get("GOTOCOURTINTERIM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("NOT_RECEIVED_PAYMENT"));
		wdUtil.optionButton(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("CONFIRM"));
		System.out.println("pro user goes to court for Interim non-payment");
		GetDriver.getInstance().setDriver(driver);
	}

	
	public void addLoss() {

		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.selectListItem(locators.get("LOSS_TYPE"), locators.get("LOSS_TYPE_V"));
		wdUtil.waitFor(3000);
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("Losses Added");
		GetDriver.getInstance().setDriver(driver);
	}
	public void addLossAndFee() 
	{

		proUserClaim();
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

	public void unrepAddFee() 
	{

		unrepClaim();
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		// Add Fee
		wdUtil.selectListItem(locators.get("ADD_FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("FEE_EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("FEE_EVIDENCE_AVAILABLE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Claimant adds Fee");
		GetDriver.getInstance().setDriver(driver);
	}



	public void unrepAddLossAndFee() {

		unrepClaim();
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
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

	public void removeLoss() {
		proUserClaim();
		wdUtil.clickLink(locators.get("REMOVE_LOSS_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REMOVE_LOSS"));
		wdUtil.checkBox(locators.get("REMOVE_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("Losses removed");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRemoveLoss() {
		unrepClaim();
		wdUtil.clickLink(locators.get("REMOVE_LOSS_FEE"));
		wdUtil.findByClick(locators.get("REMOVE_LOSS"));
		wdUtil.checkBox(locators.get("REMOVE_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("Losses removed");
		GetDriver.getInstance().setDriver(driver);
	}

	public void removeFee() {
		proUserClaim();
		wdUtil.clickLink(locators.get("REMOVE_LOSS_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		//wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("REMOVE_FEE"));
		wdUtil.checkBox(locators.get("REMOVE_FEE_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("fee removed");
		GetDriver.getInstance().setDriver(driver);
	}

	public void addDocument() {
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("UPLOAD_DOC_LINK"));
		wdUtil.uploadDoc(locators.get("SELECT_FILE"));
		wdUtil.selectListItem(locators.get("CATEGORYPRODOC"), locators.get("CATEGORYPRODOC_V"));
		wdUtil.findByClick(locators.get("UPLOAD_BUTTON"));
		System.out.println("Documents Added");
		GetDriver.getInstance().setDriver(driver);

	}

	
	public void prouserRejectFeeProposalAndGoToCourt() {
		proUserClaim();
		wdUtil.findByClick(locators.get("REVIEW_FEE_PROPOSAL"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("REJECTFEEPROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		/*
		 * wdUtil.findByClick(locators.get("CONFIRMANDSEND")); wdUtil.defaultContent();
		 * wdUtil.switchToFrame(locators.get("FRAME1"));
		 * wdUtil.findByClick(locators.get("VIEWMOREDET")); wdUtil.defaultContent();
		 * wdUtil.switchToFrame(locators.get("FRAME1"));
		 * wdUtil.findByClick(locators.get("ANYOTHERCLAIM"));
		 * wdUtil.findByClick(locators.get("CONTINUE"));
		 */
		/*
		 * wdUtil.findByClick(locators.get("MEDICALREPORT"));
		 * wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		 */
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		//preparing for court
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("COURT_VAL"));
		wdUtil.checkBox(locators.get("COURT_VAL_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Prouser Reject Fee proposal and upload court documents");
		GetDriver.getInstance().setDriver(driver);
	}

	
	
	
	public void unrepDisputeAckCourtDocsClaim(String status)
	{
		unrepClaimStatus(status);		
		wdUtil.findByClick(locators.get("VIEW_MORE"));
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
		System.out.println("unrep acknowledge court docs for claim");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepDisputeFeeCourt(String status)
	{
		unrepClaimStatus(status);		
		wdUtil.findByClick(locators.get("VIEW_MORE"));
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



	public void unrepAckCourtDocswithWitness() 
	{
		unrepClaimStatus("Pending-OfferListAccept");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
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

	public void unrepAckCourtDocsLiability() 
	{
		//below line Updated in Sprint41
		unrepClaimStatus("Pending-LiabilityListAccept");
		/*unrepClaimStatus("Pending-LiabilityListAmend");*/
		wdUtil.findByClick(locators.get("VIEW_MORE"));
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
		visibilityCourtFeePayable();
		wdUtil.optionButton(locators.get("COURT_PAY"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("unrep acknowledge court docs for claim");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepAckCourtDocNVC() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("VIEW_MORE"));
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
		wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("NVC_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("FINISH"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("unrep acknowledge court docs for claim");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepAcknCourtDocsInterim()
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEW_COMP_RESPONSE"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("unrep acknowledge court docs for interim");
		GetDriver.getInstance().setDriver(driver);
	}


	public void unrepChooseDME(String status)
	{

		unrepClaimStatus(status);
		wdUtil.findByClick(locators.get("PROCEED_MEDICAL"));
		wdUtil.optionButton(locators.get("EXAM_PLACE"));
		wdUtil.waitFor(2000);
		wdUtil.optionButton(locators.get("TRAVELLING_FROM_DME"));
		//wdUtil.findBySendKeys(locators.get("LOCATIONTYPE"), locators.get("LOCATIONTYPE_V"));
		wdUtil.clickLink(locators.get("ENTER_ADDRESS_LINK"));
		wdUtil.selectListItem(locators.get("COUNTRY"), locators.get("COUNTRY_V"));
		wdUtil.findBySendKeys(locators.get("ADDRESS1"), locators.get("ADDRESS1_V"));
		wdUtil.findBySendKeys(locators.get("ADDRESS2"), locators.get("ADDRESS2_V"));
		wdUtil.findBySendKeys(locators.get("CITY"), locators.get("CITY_V"));
		wdUtil.findBySendKeys(locators.get("POSTAL"), locators.get("POSTAL_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("PREFERRED_TYPE_DME"));
		wdUtil.optionButton(locators.get("MILES"));
		wdUtil.optionButton(locators.get("GENDER"));
		wdUtil.optionButton(locators.get("APPOINTMENT_REQ"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CHOOSE_DME"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("unrep claim case routed to DME");
		unrepClaimStatusEnd("Pending-MedAppointment");
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepRequestAdditionalMedReport() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.optionButton(locators.get("ADDITIONALMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("JUSTIFICATIONADDITIONAL"), locators.get("JUSTIFICATIONADDITIONAL_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("unrep requested for additional medical report");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRequestForSecondMedReport() 
	{
		unrepClaimStatus("Pending-CheckMedical");
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT_NO"));
		wdUtil.scrollDown(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("FACTUALLYINCORRECT"), locators.get("FACTUALLYINCORRECT_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		unrepClaimStatusEnd("Pending-MRPReportReject");
		System.out.println("unrep requested for further medical report after factually incorrect");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepObtainFurtherMedReport() 
	{
		unrepClaimStatus("Pending-CheckMedical");
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Obtain Further Medical Report
		wdUtil.optionButton(locators.get("FURTHER_MEDREPORT_COMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("REQ_FURTHER_REPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.selectListItem(locators.get("MED_JUSTI_ADDLN"), locators.get("MED_JUSTI_ADDLN_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findBySendKeys(locators.get("INJURY_DESC"), locators.get("INJURY_DESC_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("unrep obtain further medical report from compensator");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepWaitoutObtainFurtherMedReport() 
	{
		unrepClaimStatus("Pending-CheckMedical");
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Waitout prognosis
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("unrep decides waitout before obtaining further medical report from compensator");
		GetDriver.getInstance().setDriver(driver);
	}
	public void unrepObtainAndUploadFurtherMedReport() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//	n Further Medical Report
		wdUtil.optionButton(locators.get("FURTHER_MEDREPORT_COMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("OBTAIN_OWN_REPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.optionButton(locators.get("UPLOAD_OWN_REP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//Upload own further report
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
		wdUtil.selectListItem(locators.get("PROG_PERIOD"), locators.get("PROG_PERIOD_V"));
		wdUtil.optionButton(locators.get("FROM_MED_EXAM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("SAVE_EXIT"));
		System.out.println("unrep obtain and upload own further medical report with waitout prognosis");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepAcceptWOP() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("PROCEED_BUTTON"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("unrep accept wait out prognosis");
		GetDriver.getInstance().setDriver(driver);
	}
	public void unrepObtainFurtherReportDuringWOP() 
	{
		unrepClaimStatus("Pending-WaitPrognosisMedical");
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING_YES"));
		wdUtil.optionButton(locators.get("OBTAIN_FURTHER_REP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("REQ_FURTHER_REPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.selectListItem(locators.get("MED_JUSTI_ADDLN"), locators.get("MED_JUSTI_ADDLN_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("INJURY_DESC"), locators.get("INJURY_DESC_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("unrep accept wait out prognosis and proceed to additional report");
		GetDriver.getInstance().setDriver(driver);
	}



	public void unrepGotoCourtOptionOCS3() 
	{
		unrepClaim();
		wdUtil.clickLink(locators.get("GO_TO_COURT_INTERIM"));
		wdUtil.checkBox(locators.get("NO_PAYMT_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.findByClick(locators.get("SEL_COURT_DOCS_INTERIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("INTERIM"));
		wdUtil.checkBox(locators.get("INTERIM_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Unrep goes to court OCS3");
		GetDriver.getInstance().setDriver(driver);
	}
	public void unrepGotoCourtSettleOfferFee() 
	{
		unrepClaimStatus("Resolved-Completed");
		wdUtil.clickLink(locators.get("GO_TO_COURT_LINK"));
		wdUtil.optionButton(locators.get("NO_PAY_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPT_OFFER"));
		wdUtil.checkBox(locators.get("ACCEPT_OFFER_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Unrep goes to court OCS3");
		GetDriver.getInstance().setDriver(driver);
	}

	

	public void unrepGotocourtocs5()
	{
		unrepClaim();
		wdUtil.clickLink(locators.get("GO_TO_COURT_LINK"));
		wdUtil.optionButton(locators.get("COURT_DECIDE_NONPAYMENTFORFEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPT_OFFER"));
		wdUtil.checkBox(locators.get("ACCEPT_OFFER_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.waitFor(3000);
		System.out.println(("Unrep go to court OCS5"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepGoToCourtRejectLiability() 
	{
		unrepClaimStatus("Pending-LiabilityRejected");
		wdUtil.findByClick(locators.get("VIEWMOREDETREP"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("ANYOTHERCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("unrep go to court and reject liability");
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepCourtRejectLiability() 
	{
		unrepClaimStatus("Pending-LiabilityRejected");
		wdUtil.findByClick(locators.get("VIEWMOREDETREP"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("ANYOTHERCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("unrep go to court and reject liability");
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepReopenClaimLiability()
	{
		unrepClaimStatus("Resolved-CourtLiability");
		wdUtil.clickLink(locators.get("REOPEN_LIABILITY"));
		wdUtil.optionButton(locators.get("COURT_LIABILITY_DECISION"));
		wdUtil.selectListItem(locators.get("LIABILITY_DECISION"), locators.get("LIABILITY_DECISION_PART_V"));
		wdUtil.findBySendKeys(locators.get("LIABILITY_PERCENTAGE"), locators.get("LIABILITY_PERCENTAGE_V"));
		wdUtil.findBySendKeys(locators.get("COURT_CLAIM_NO"), locators.get("COURT_CLAIM_NO_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_ORDER_YES"));
		wdUtil.clickLink(locators.get("UPLOAD_COURT_DOC"));
		wdUtil.uploadDoc(locators.get("SELECT_FILE"));
		wdUtil.selectListItem(locators.get("CATEGORYCOURT"), locators.get("CATEGORYCOURT_V"));
		wdUtil.findByClick(locators.get("UPLOAD_BUTTON"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("unrep reopen the claim and select DME");
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepGotoCourtOption_OCS2() 
	{
		unrepClaim();
		wdUtil.clickLink(locators.get("GO_TO_COURT_LINK"));
		wdUtil.optionButton(locators.get("COURT_VALUE_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		// answerNVC

		if(GetDriver.getInstance().getNVCStatus()==true)
		{
			System.out.println("NVC claim");
			wdUtil.optionButton(locators.get("ISVEHICLEDAMAGED_YES"));
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
			wdUtil.selectListItem(locators.get("CATEGORY_NVC"),locators.get("CATEGORY_NVC_V"));
			wdUtil.findBySendKeys(locators.get("NVC_DESCRIPTION"),locators.get("NVC_DESCRIPTION_V"));
			wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_NVC"),locators.get("LOSS_AMOUNT_NVC_V"));
			wdUtil.checkBox(locators.get("UPLOADED_DOC_CHECK"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		}
		else
		{
			wdUtil.optionButton(locators.get("ISVEHICLEDAMAGED"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
			wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
			wdUtil.findByClick(locators.get("MEDICALREPORT"));
			wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
			wdUtil.findByClick(locators.get("SUPPORT_CLAIM"));
			wdUtil.checkBox(locators.get("SUPPORT_CLAIM_CHKBOX"));
			wdUtil.findByClick(locators.get("SCNF"));
			wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
			wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
			wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
			System.out.println("NVC skipped");
		}


		System.out.println("Unrep go to court OCS2");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepAddDocument() {
		unrepClaim();
		wdUtil.clickLink(locators.get("UPLOAD_DOC_LINK"));
		wdUtil.uploadDoc(locators.get("SELECT_FILE"));
		wdUtil.selectListItem(locators.get("CATEGORYPRODOC"), locators.get("CATEGORYPRODOC_V"));
		wdUtil.findByClick(locators.get("UPLOAD_BUTTON"));
		System.out.println("Unrep Documents Added");
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepAddLoss() {

		unrepClaim();
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
		wdUtil.selectListItem(locators.get("LOSS_TYPE"), locators.get("LOSS_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("EVIDENCE_AVAILABLE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.scrollDown(locators.get("CLOSE"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Unrep Losses Added");
		GetDriver.getInstance().setDriver(driver);
	}

	public void claimantChallengeLiabilityDecision() 
	{
		unrepClaim();
		wdUtil.clickLink(locators.get("CHALLENGEPARTLBLTY"));
		wdUtil.findBySendKeys(locators.get("CLAIMANTCHALLANGECOMMENT"), locators.get("CLAIMANTCHALLANGECOMMENT_V"));
		wdUtil.optionButton(locators.get("DRIVER_RESPONSIBLE"));
		wdUtil.findBySendKeys(locators.get("CHALLENGE_PERCENTAGE"), locators.get("CHALLENGE_PERCENTAGE_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Challenge Liability Decision");
		GetDriver.getInstance().setDriver(driver);
	}
	public void claimantReviewChallengeLiabilityDecision() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEW_LIABILITY_CHALLENGE"));
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.optionButton(locators.get("CHALLENGE_LIABILITY_PROPOSAL"));
		wdUtil.findBySendKeys(locators.get("CHALLENGE_PERCENTAGE"), locators.get("CHALLENGE_PERCENTAGE_V"));
		wdUtil.findBySendKeys(locators.get("CLAIMANTCHALLANGECOMMENT"), locators.get("CLAIMANTCHALLANGECOMMENT_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("review and challenge liability decision");
		GetDriver.getInstance().setDriver(driver);
	}
	public void claimantReviewDeclineLiabilityDecision()
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEW_LIABILITY_CHALLENGE"));
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.optionButton(locators.get("DECLINE_LIABILITY_PROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Decline liability decision");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRejectOfferCourtNVC()
	{
		unrepClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Summary
		wdUtil.findByClick(locators.get("CONFIRM"));
		//answer NVC
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
		unrepClaimStatusEnd("Pending-NVCResponse");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRejectOfferCounterOfferCourtNVC()
	{
		unrepClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		//if condition added in sprint41
		if(wdUtil.isElementPresent(locators.get("COUNTEROFFER")))
		{
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_V"));
		}
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		
		if(wdUtil.isElementPresent(locators.get("INJURYTARIFF")))
			{
				wdUtil.findByClick(locators.get("INJURYTARIFF"));
				wdUtil.optionButton(locators.get("TARIFF"));
				wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
				wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
				wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
				wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
			}
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
		//answer NVC
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
		unrepClaimStatusEnd("Pending-NVCResponse");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRejectOfferGoToCourt()
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//offer not accepted
		wdUtil.findByClick(locators.get("CONTINUE"));
		//offers you disagree
		wdUtil.findByClick(locators.get("CONTINUE"));
		//preparing for court
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CLOSE"));
		//Going to court
		wdUtil.findByClick(locators.get("VIEW_DET"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("COURT_VAL"));
		wdUtil.checkBox(locators.get("COURT_VAL_CHKBOX"));
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("INTERIM_REQUEST"));
		wdUtil.checkBox(locators.get("INTERIM_REQUEST_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));

		System.out.println("Unrep goes to court and answer NVC");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRejectOfferGoToCourtClaimNotSubmitted()
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//offer not accepted
		wdUtil.findByClick(locators.get("CONTINUE"));
		//offers you disagree
		wdUtil.findByClick(locators.get("CONTINUE"));
		//preparing for court
		wdUtil.findByClick(locators.get("SAVEANDEXIT"));
		System.out.println("Unrep goes to court and answer NVC");
		GetDriver.getInstance().setDriver(driver);
	}



	public void unrepRejectFirstOffer() 
	{
		unrepClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),
				locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		//statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));

		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("claimant rejected first offer");
		wdUtil.findByClick(locators.get("CLOSE"));
		unrepClaimStatusEnd("Pending-RespondCounter");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRejectFirstOfferWithUplift() {
		unrepClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("TARIFFUPLIFT"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFERUPLIFT_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFERUPLIFT_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),
				locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("claimant rejected first offer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepReviewReportAndProceedWithOfferUplift() {
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		// UPLIFT
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_YES"));
		//wdUtil.optionButton(locators.get("MEDREPSUPPORTAMT"));
		wdUtil.findByClick(locators.get("SUPPORT_GREATERVALUE"));
		wdUtil.findByClick(locators.get("WHIPLASH_INJURY"));
		wdUtil.findBySendKeys(locators.get("SEVERE_INJURY"),locators.get("SEVERE_INJURY_V"));
		wdUtil.findByClick(locators.get("EXCEPTIONAL_CIRCUMSTANCE"));
		wdUtil.findBySendKeys(locators.get("EXCEPTIONAL_CIRCUM"),locators.get("EXCEPTIONAL_CIRCUM_V"));
		/*
		 * wdUtil.optionButton(locators.get("UPLIFTCAUSE"));
		 * wdUtil.optionButton(locators.get("MEDREPSUPPORTAMT"));
		 * wdUtil.findBySendKeys(locators.get("CIRCUMSTANCESDESC"),
		 * locators.get("CIRCUMSTANCESDESC_V"));
		 */
		wdUtil.findBySendKeys(locators.get("UPLIFTPERCENTAGE"), locators.get("UPLIFTPERCENTAGE_V"));
		//wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//Review Loss
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("unrep review medical report with uplift");
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepReviewReportAndProceedWithOffer() {
		unrepClaimStatus("Pending-CheckMedical");
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
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
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("unrep review medical report and proceed with offer");
		unrepClaimStatusEnd("Pending-FirstOffer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepProceedWithOffer() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("PROCEED_BUTTON"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
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
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("unrep proceed with offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void unrepProceedOffer() 
	{
		unrepClaimStatus("Pending-NewMedReportReject");
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
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
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("unrep proceed with offer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepReviewReportWithoutUplift() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		// UPLIFT
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		//Review loss
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Review fee
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("unrep review medical report without uplift");
		GetDriver.getInstance().setDriver(driver);

	}

	public void causationDisputeOffer()
	{
		unrepClaimStatus("Pending-CausationNoOffer");
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("claimant accepts dispute decision");
		wdUtil.findByClick(locators.get("CLOSE"));
		unrepClaimStatusEnd("Resolved-NoOffer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void causationDisputeFinalOffer()
	{
		unrepClaimStatus("Pending-CausationFinalOffer");
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.findByClick(locators.get("OFFER_FINAL_REJECT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("claimant rejects dispute decision");
		unrepClaimStatusEnd("Resolved-FinalOfferRejected");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepReviewInterimCourtDocs() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.findByClick(locators.get("VIEW_MORE"));
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
		System.out.println("unrep review interim court docs");
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepAcceptOfferAndRequestFee() 
	{
		unrepClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.findByClick(locators.get("OFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.optionButton(locators.get("REQUEST_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Add Loss
		wdUtil.selectListItem(locators.get("ADD_FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("FEE_EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("FEE_EVIDENCE_AVAILABLE"));		
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Unrep Accept Offer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRequestFee() 
	{
		unrepClaimStatus("Pending-ReviewFeesOffer");
		wdUtil.findByClick(locators.get("REVIEW_FEE_PROPOSAL"));
		wdUtil.optionButton(locators.get("REQUEST_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Add Loss
		wdUtil.selectListItem(locators.get("ADD_FEE_TYPE"), locators.get("FEE_TYPE_V"));
		wdUtil.optionButton(locators.get("FEE_EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_FEE_V"));
		wdUtil.findBySendKeys(locators.get("FEE_LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_FEE_V"));
		wdUtil.optionButton(locators.get("FEE_EVIDENCE_AVAILABLE"));		
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Unrep Request Fee");
		GetDriver.getInstance().setDriver(driver);
	}


	public void unrepAcceptFee() 
	{
		unrepClaimStatus("Pending-ReviewFeesOffer");
		wdUtil.findByClick(locators.get("REVIEW_FEE_PROPOSAL"));
		wdUtil.optionButton(locators.get("ACCEPT_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Unrep Accepts Fee");
		GetDriver.getInstance().setDriver(driver);
	}



	public void unrepAcceptFinalOfferAndFee() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.findByClick(locators.get("OFFER_FINAL_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		wdUtil.optionButton(locators.get("ACCEPT_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Unrep Accept Final Offer");
		GetDriver.getInstance().setDriver(driver);
	}



	public void unrepRejectFeeProposal()
	{
		unrepClaimStatus("Pending-ReviewFeesOffer");
		wdUtil.findByClick(locators.get("REVIEW_FEE"));
		wdUtil.optionButton(locators.get("REJECTFEEPROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMPFEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("MEDICALFEE_COUNTER"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_FEE_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Unrep Reject fee offer back to compensator");
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepGotoCourtOcs4() {
		unrepClaim();
		wdUtil.clickLink(locators.get("GOTOCOURTLINK"));
		wdUtil.optionButton(locators.get("COURT_DECIDE_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.findByClick(locators.get("COURT_VALIDATION"));
		wdUtil.checkBox(locators.get("COURT_VALIDATION_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("claimant proceed with court over fee proposal");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepAcceptOfferAndFee() 
	{
		unrepClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.findByClick(locators.get("OFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.optionButton(locators.get("ACCEPT_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Unrep Accept Offer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRejectFeeProposalAndGoToCourt()
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEW_FEE_PROPOSAL"));
		wdUtil.optionButton(locators.get("REJECTFEEPROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("MEDICAL_REPORT"));
		//wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		//select documents
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		//Preparing for court
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Court documents
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
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Unrep Reject Fee proposal and upload court documents");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRejectFeeOfferAndGoToCourt()
	{
		unrepClaimStatus("Pending-DecideFeesOffer");
		wdUtil.findByClick(locators.get("REVIEW_FEE_PROPOSAL"));
		wdUtil.optionButton(locators.get("REJECTFEEPROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Go to court over fee offer
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		//select documents
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		//Preparing for court
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Court documents
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
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Unrep Reject Fee proposal and upload court documents");
		GetDriver.getInstance().setDriver(driver);
	}


	public void unrepRevisedtOfferFeeProposal() {
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEW_FEE"));
		wdUtil.findByClick(locators.get("ACCEPTFEEPROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("accepts revised offer fee proposal");
		GetDriver.getInstance().setDriver(driver);

	}

	public void gotocourtOption() {
		unrepClaim();
		for (int i = 0; i <= 8000; i++) {
			if (driver.findElements(By.xpath(locators.get("GO_TO_COURT_LINK"))).size() > 0) {
				System.out.println("Go to court link available");
				break;
			}
			System.out.println("Go to court link clicked");

		}

		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepGoToCourt() {
		WebDriver driver = GetDriver.getInstance().getDriver();
		WebDriverUtil wdUtil = new WebDriverUtil(driver);
		wdUtil.findByClick(locators.get("LISTREP"));
		wdUtil.unrepOIC(unrepOIC);
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("unrep go to court");
		GetDriver.getInstance().setDriver(driver);
	}


	public void unrepselectCourtDocumentsForInterimNonPayment() {
		unrepClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.findByClick(locators.get("DOCS_COURT_AT_INTERIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPT_INTERIM_PAYMENT"));
		wdUtil.checkBox(locators.get("ACCEPT_INTERIM_PAYMENT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("unrep select docs for interim payment");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepSecondInterimUnableToGotoCourt() {
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEW_INTERIM_DECISION"));
		wdUtil.findByClick(locators.get("PROCESS_THIS_REQUEST"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		String msg = driver.findElement(By.xpath("//*[@id='PegaRULESErrorFlag']")).getText();
		System.out.println("Error message is displayed" + msg);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='PegaRULESErrorFlag']")).isDisplayed(), true);
		System.out.println("unrep unable go to court when first interim in court");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepSelectCourtDocs() {
		unrepClaim();
		wdUtil.findByClick(locators.get("VIEW_DET"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//	wdUtil.findByClick(locators.get("COURT_VAL"));
		//wdUtil.checkBox(locators.get("COURT_VAL_CHKBOX"));
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("SUPPORT_CLAIM"));
		wdUtil.checkBox(locators.get("SUPPORT_CLAIM_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("unrep select court docs");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepSelectCourtDocsNVC() 
	{
		unrepClaimStatus("Pending-OfferCourtList");
		wdUtil.findByClick(locators.get("DOCS_COURT"));
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
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("unrep select court docs");
		unrepClaimStatusEnd("Pending-OfferListReview");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepRejectInterimAndGoToCourt() {
		unrepClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("INTERIM_REQUEST"));
		wdUtil.checkBox(locators.get("INTERIM_REQUEST_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("unrep reject interim and go to court");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepAnswerNVC() 
	{
		unrepClaimStatus("NVCClaimant");
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.optionButton(locators.get("ISVEHICLEDAMAGED_YES"));
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
		wdUtil.selectListItem(locators.get("CATEGORY_NVC"),locators.get("CATEGORY_NVC_V"));
		wdUtil.findBySendKeys(locators.get("NVC_DESCRIPTION"),locators.get("NVC_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT_NVC"),locators.get("LOSS_AMOUNT_NVC_V"));
		wdUtil.checkBox(locators.get("UPLOADED_DOC_CHECK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Unrep answered NVC");
		GetDriver.getInstance().setDriver(driver);

	}
	
	
	public void unrepgoToCourtFinalOffer() 
	{
		unrepClaimStatus("Pending-FinalWithdrawn");
		wdUtil.clickLink(locators.get("GO_TO_COURT_LINK"));
		wdUtil.checkBox(locators.get("COURT_VALUE_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		System.out.println("Unrep goes to court for final offer");
		GetDriver.getInstance().setDriver(driver);		
	}

	
	
	

	public void prouserAcceptOffer() {
		proUserClaim();
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ACCEPT_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("Prouser accepts offer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void claimantAcceptWaitOutPrognosisReleaseToComp() {
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("unrep accept wait out prognosis");
		GetDriver.getInstance().setDriver(driver);

	}

	public void claimantAcceptWaitOutPrognosis() {
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("unrep accept wait out prognosis");
		GetDriver.getInstance().setDriver(driver);

	}

	public void claimantAcceptWaitOutPrognosisFromComp() {
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		// wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("SUBMITMEDREPCHOICES"));
		System.out.println("unrep accept wait out prognosis");
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepAcceptWaitoutPrognosisandProceedtoOffer() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("SUBMITMEDREPCHOICES"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING"));
		wdUtil.optionButton(locators.get("PROCEEDTOOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("ISUPLIFTJUSTIFIED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("unrep accept wait out prognosis and proceed to offer");
		GetDriver.getInstance().setDriver(driver);
	}


	public void unrepAcceptWaitoutAddLossProceedtoOffer() 
	{
		unrepClaimStatus("Pending-WaitPrognosisOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
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
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING_YES"));
		wdUtil.findByClick(locators.get("ADDITIONALREPORT_NO"));
		wdUtil.findByClick(locators.get("PROCEEDOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("unrep accept wait out prognosis and proceed to offer");
		GetDriver.getInstance().setDriver(driver);
	}
	public void unrepAcceptWaitoutAndProceedtoOffer() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING"));
		wdUtil.optionButton(locators.get("PROCEEDTOOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("ISUPLIFTJUSTIFIED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("unrep accept wait out prognosis and proceed to offer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepReqInterimPayment()
	{
		unrepClaim();
		wdUtil.clickLink(locators.get("REQ_INT_PYMT"));
		driver.findElement(By.xpath(locators.get("INTAMTREQ"))).clear();
		wdUtil.findBySendKeys(locators.get("INTAMTREQ"), locators.get("INTAMTREQ_VALUE"));
		wdUtil.findBySendKeys(locators.get("EXPLAINREASON"), locators.get("EXPLAINREASON_VALUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("UNREP requests for interim payment");
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepReviewInterimPayment() {
		unrepClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.optionButton(locators.get("ACCEPT_INTERIM_OFFER"));
		wdUtil.scrollDown(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("RETURN"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("unrep review and accepts interim payment");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepWithdrawClaim(String status) {
		unrepClaimStatus(status);
		wdUtil.clickLink(locators.get("WITHDRAWCLAIM"));
		wdUtil.optionButton(locators.get("WITHDRAWREASON_PRO_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("WITHDRAW"));
		System.out.println("unrep withdraw claim");
		wdUtil.findByClick(locators.get("CLOSE"));
		unrepClaimStatusEnd("Pending-Withdrawal");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepAddLossAndProceedToOffer() {
		unrepClaim();
		wdUtil.clickLink(locators.get("ADDLOSS"));
		wdUtil.selectListItem(locators.get("LOSS_TYPE"), locators.get("LOSS_TYPE_V"));
		wdUtil.optionButton(locators.get("EXPECT_LOSS_ONGOING"));
		wdUtil.findBySendKeys(locators.get("LOSS_DESCRIPTION"), locators.get("LOSS_DESCRIPTION_V"));
		wdUtil.findBySendKeys(locators.get("LOSS_AMOUNT"), locators.get("LOSS_AMOUNT_V"));
		wdUtil.optionButton(locators.get("NOEVIDENCETOUPLOAD"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("VIEWMOREDETREP"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING"));
		wdUtil.optionButton(locators.get("PROCEEDTOOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		GetDriver.getInstance().setDriver(driver);

	}

	public void unrepProceedToOffer() {
		unrepClaimStatus("Pending-CheckMedical");
		wdUtil.findByClick(locators.get("REVIEWMEDREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("MEDEXAMREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("PROCEEDWITHCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("claimant proceed with offer");
		GetDriver.getInstance().setDriver(driver);
	}

	public void acceptOfferRejectfee() {

		unrepClaimStatus("Pending-ReviewFeesOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		//wdUtil.findByClick(locators.get("OFFER_ACCEPT"));
		//wdUtil.findByClick(locators.get("CONTINUE"));
		//wdUtil.findByClick(locators.get("CONFIRM"));
		// wdUtil.findByClick(locators.get("REVIEW_FEE"));
		wdUtil.optionButton(locators.get("REJECTFEEPROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMPFEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("MEDICALFEE_COUNTER"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void unrepAcceptRejectedOffer()
	{
		unrepClaimStatus("Pending-RespondCounter");
		wdUtil.clickLink(locators.get("ACCEPT_REJECT_OFFER"));
		wdUtil.checkBox(locators.get("ACCEPT_THIS_OFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPT"));
		wdUtil.findByClick(locators.get("SAVE_EXIT"));
		System.out.println("claimant accept rejected offer");
		GetDriver.getInstance().setDriver(driver);
		
	}
	public void  unrepWithdrawOfferReplace()
	{
		unrepClaimStatus("Pending-RespondCounter");
		wdUtil.clickLink(locators.get("WITHDRAWOFFER"));
		wdUtil.checkBox(locators.get("WITHDRAWOFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("WITHDRAW_OFFER"));
		wdUtil.findByClick(locators.get("CLOSE"));
		// Make Replacement offer
		unrepClaimStatus("Pending-ReplaceCounter");
		wdUtil.findByClick(locators.get("REPLACEMENTOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Claimant withdraw and replace offer");
		GetDriver.getInstance().setDriver(driver);
	
	}
	
	

	public void unrepProceedAfterNewReport()
	{
		unrepClaimStatus("Pending-ProceedClaim");
		wdUtil.findByClick(locators.get("PROCEED_BUTTON"));
		wdUtil.optionButton(locators.get("PROCEED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Unrep proceeds with offer");
		GetDriver.getInstance().setDriver(driver);
	}

	

	public void gotocourtOption_OCS4() {

		unrepClaimStatus("Pending-RespondCounterFees");
		wdUtil.clickLink(locators.get("GO_TO_COURT_LINK"));
		wdUtil.optionButton(locators.get("COURT_DECIDE_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("unrep goes to court and select court docs");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepVerifyAddLoss()
	{
		unrepClaim();
		wdUtil.assertLink(locators.get("ADD_LOSS_LINK"));
		GetDriver.getInstance().setDriver(driver);
	}


	public void unrepVerifyChallengeLiability()
	{
		unrepClaim();
		wdUtil.assertLink(locators.get("CHALLENGEPARTLBLTY"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void slaBreached() {

		// SLA breach setup for 5 mins
		driver.navigate().refresh();
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("LOGOUT"));
		wdUtil.waitFor(360000);
	}
	public void resolvedStatus(String status)
	{
		unrepClaimStatus(status);
	}

	public void logout() {
		wdUtil.defaultContent();
		wdUtil.waitFor(3000);
		wdUtil.findByClick(locators.get("LOGOUT"));
	}
	
	/*
	 * Author: Sourav Dutta
	 * Purpose: Search Claim for pro user
	 */
	public void SearchClaimPro() {
		//claimNumber="OIC-54178";
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(plocators.get("MYTEAMWORK"));		
		wdUtil.findByClick(plocators.get("SHOW_FILTER"));
		wdUtil.findBySendKeys(plocators.get("FILTER_PORTAL_REF_NO"), claimNumber);
		wdUtil.findByClick(plocators.get("FILTER_BUTTON"));
	}

	/*
	 * Author: Sourav Dutta
	 * Purpose: Clear Search Claim for pro user
	 */
	public void clearSearchPro() {
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(plocators.get("CLEAR_FILTER"));		
		wdUtil.findByClick(plocators.get("HIDE_FILTER"));
		wdUtil.defaultContent();
	}


	public void prouserGotoDetails() {

		wdUtil.doubleClick(plocators.get("CLAIM_STATUS").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
	}

	/*
	 * Author: Sourav Dutta
	 * Purpose: Get the claim status and verify greenbox
	 */

	/*
	 * public void verifyClaimStatus(String status) {
	 * 
	 * String claimStatus
	 * =wdUtil.getText(plocators.get("CLAIM_STATUS").replace("$claimNumber",
	 * claimNumber));
	 * 
	 * 
	 * if (claimStatus.matches(status)) {
	 * System.out.println(status+" Status macthed");
	 * wdUtil.doubleClick(plocators.get("CLAIM_STATUS").replace("$claimNumber",
	 * claimNumber)); wdUtil.defaultContent();
	 * wdUtil.switchToFrame(plocators.get("FRAME1")); String
	 * ExlGreenbox=PGreenBoxtext.get(status).replaceAll("\n",
	 * " ").replaceAll("\\s+", " ").replaceAll("^ +| +$|( )+", " ").trim();
	 * System.out.println("Excel green box text: "+ExlGreenbox); String
	 * greenboxtext=wdUtil.getText(locators.get("CLAIM_STATUS_MSG")).
	 * replace("What you need to do\n", "");
	 * System.out.println("System green box text: "+greenboxtext);
	 * 
	 * if(ExlGreenbox.matches(greenboxtext)) {
	 * System.out.println("Greenbox text matched for "+status); }else {
	 * System.out.println("Greenbox text doesn't matched for "+status +
	 * "\nExcel green box text: "+ExlGreenbox
	 * +"\nSystem green box text: "+greenboxtext); }
	 * 
	 * }else {
	 * System.out.println("Status doesn't matched.. Status should be :"+status
	 * +"\nSystem status: "+claimStatus); }
	 * 
	 * wdUtil.findByClick(plocators.get("CLOSE")); clearSearchPro();
	 * wdUtil.browserRefresh();
	 * 
	 * 
	 * }
	 */

	/*
	 * public void proProccedforOfferduringPrognosis() { String uplift="UPLIFT_NO";
	 * switch (uplift) { case "UPLIFT_NO": wdUtil.defaultContent();
	 * SearchClaimPro(); //wdUtil.switchToFrame(locators.get("FRAME1"));
	 * prouserGotoDetails(); wdUtil.findByClick(locators.get("VIEW_MORE"));
	 * wdUtil.defaultContent(); wdUtil.switchToFrame(locators.get("FRAME2"));
	 * wdUtil.optionButton(locators.get("ISSTILLSUFFERING"));
	 * wdUtil.optionButton(locators.get("ADDITIONALREPORT_NO"));
	 * wdUtil.optionButton(locators.get("PROCEEDOFFER"));
	 * wdUtil.findByClick(locators.get("CONTINUE"));
	 * wdUtil.findByClick(locators.get("FINISH"));
	 * 
	 * wdUtil.defaultContent(); wdUtil.switchToFrame(locators.get("FRAME1"));
	 * wdUtil.findByClick(locators.get("VIEW_MORE"));
	 * 
	 * wdUtil.defaultContent(); wdUtil.switchToFrame(locators.get("FRAME2"));
	 * wdUtil.findByClick(locators.get("CONTINUE"));
	 * wdUtil.optionButton(locators.get("ISUPLIFTJUSTIFIED"));
	 * wdUtil.findByClick(locators.get("CONTINUE"));
	 * 
	 * wdUtil.findByClick(locators.get("CONFIRM"));
	 * 
	 * wdUtil.findByClick(locators.get("CONTINUE"));
	 * 
	 * wdUtil.optionButton(locators.get("SIGN_DOC_NO"));
	 * wdUtil.findByClick(locators.get("CONTINUE"));
	 * 
	 * proUserSOT();
	 * 
	 * wdUtil.defaultContent(); wdUtil.switchToFrame(locators.get("FRAME1"));
	 * wdUtil.findByClick(plocators.get("CLOSE"));
	 * 
	 * wdUtil.defaultContent(); clearSearchPro(); SearchClaimPro();
	 * verifyClaimStatus("Pending-FirstOffer");
	 * 
	 * break; case "UPLIFT_YES": wdUtil.defaultContent();
	 * wdUtil.switchToFrame(locators.get("FRAME2"));
	 * wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_YES"));
	 * wdUtil.findByClick(locators.get("WHIPLASH_INJURY"));
	 * wdUtil.findByClick(locators.get("SUPPORT_GREATERVALUE"));
	 * wdUtil.findBySendKeys(locators.get("EXCEPTIONAL_CIRCUM"),
	 * locators.get("EXCEPTIONAL_CIRCUM_V"));
	 * wdUtil.findBySendKeys(locators.get("UPLIFT_PERCENT"),
	 * locators.get("UPLIFT_PERCENT_V"));
	 * wdUtil.findByClick(locators.get("CONTINUE")); wdUtil.defaultContent();
	 * wdUtil.switchToFrame(locators.get("FRAME2"));
	 * wdUtil.scrollDown(locators.get("WAITOUTPROGOPTION"));
	 * wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
	 * wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
	 * wdUtil.findByClick(locators.get("CONTINUE")); wdUtil.defaultContent();
	 * wdUtil.switchToFrame(locators.get("FRAME2"));
	 * wdUtil.findByClick(locators.get("FINISH")); break; }
	 * 
	 * }
	 */

	public void proUserSOT() {
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), locators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPT_SEND_CLAIM"));
	}

	public void challengeNonWhipInjury() {
		
		unrepClaimStatus("Pending-ReviewOffer");
		wdUtil.clickLink(locators.get("CHALLENGE_NONWHIP"));

		wdUtil.findBySendKeys(locators.get("CHALLENGE_NONWHIP_DISAGREE"), locators.get("CHALLENGE_NONWHIP_DISAGREE_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		
		wdUtil.AddLog("Claimant challenged NON Whiplash injury decision.");

	}

	public void ClaimantRespondNonWhipInjury(String decision) {
		
		unrepClaimStatus("Pending-DecideNonWhiplash");

		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));

		wdUtil.findByClick(locators.get("CHECK_COMP_RESPONSE"));


		if (decision.equalsIgnoreCase("Reject")) {			

			wdUtil.optionButton(locators.get("NONWHIPDECISION_REJECT"));

			wdUtil.findBySendKeys(locators.get("DISAGREE_REASON"), locators.get("DISAGREE_REASON_V"));
			wdUtil.findByClick(locators.get("CONTINUE"));

		}else {

			wdUtil.optionButton(locators.get("NONWHIPDECISION_ACCEPT"));			

			wdUtil.findByClick(locators.get("CONTINUE"));

		}
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));	
		wdUtil.findByClick(locators.get("RETURN"));


	}

	public void acceptFinalRejectionNonWhipInjury() {
		
		unrepClaimStatus("Pending-DecideNonWhiplash");
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.findByClick(locators.get("CHECK_COMP_RESPONSE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));

		wdUtil.findByClick(locators.get("RETURN"));
		wdUtil.browserRefresh();
		Boolean link=wdUtil.isLinktextPresent(locators.get("CHALLENGE_NONWHIP"));
		if (link== false) {
			//System.out.println(locators.get("CHALLENGE_NONWHIP") + "link is not present.. working as expected.");
			wdUtil.AddLog(locators.get("CHALLENGE_NONWHIP") + "link is not present.. working as expected.");
		}else {
			//System.out.println(locators.get("CHALLENGE_NONWHIP") + "link is present.. Not working as expected.");
			wdUtil.AddLog(locators.get("CHALLENGE_NONWHIP") + "link is present.. Not working as expected.");
		}
		wdUtil.findByClick(locators.get("CLOSE"));

	}
	
	
	

	/*
	 *Author: Sourav Dutta
	 *Function: Reject first offer with tariff as parameter
	 */

	public void unrepRejectFirstOfferTariff(String Tariff) 
	{
		unrepClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));

		if(Tariff.equalsIgnoreCase("Tariff_Yes")) {
			wdUtil.findByClick(locators.get("INJURYTARIFF"));
			wdUtil.optionButton(locators.get("TARIFF"));
			wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
			wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
			wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
			wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		}		


		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		//statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));

		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("claimant rejected first offer");
		wdUtil.findByClick(locators.get("CLOSE"));
		unrepClaimStatusEnd("Pending-RespondCounter");
		GetDriver.getInstance().setDriver(driver);
	}	
	
	/*
	 *Author: P Vidya
	 *Function: Sprint 41 changes
	 */
	public void unrepselectCourtDocsForInterimNonPaymentsecondtime() {
		unrepClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.findByClick(locators.get("DOCS_COURT_AT_INTERIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		courtProceedingYes();
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPT_INTERIM_PAYMENT"));
		wdUtil.checkBox(locators.get("ACCEPT_INTERIM_PAYMENT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("unrep select docs for interim payment");
		GetDriver.getInstance().setDriver(driver);
	}

	public void unrepSelectCourtDocsthirdtimeNVC() 
	{
		unrepClaimStatus("Pending-OfferCourtList");
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
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
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("unrep select court docs");
		unrepClaimStatusEnd("Pending-OfferListReview");
		GetDriver.getInstance().setDriver(driver);
	}




	public void unrepReviewInterimCourtDocsSecondtime() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"), locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"), locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		visibilityCourtFeePayable();
		visibilityAdditionalCourtFeePayable();
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("unrep review interim court docs");
		GetDriver.getInstance().setDriver(driver);

	}
	public void unrepAckCourtDocThirdtimeNVC() 
	{
		unrepClaim();
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.findByClick(locators.get("CONTINUE"));

		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("NVC_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//court fee payable and additional court fee payable screen
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.AddLog("Court fee payable screen displayed");
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.AddLog("Additional Court fee payable screen displayed");
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("unrep acknowledge court docs for claim");
		GetDriver.getInstance().setDriver(driver);
	}
	
	/*
	 *Author: Sourav Dutta
	 *Sprint 41 changes for 2nd time court proceeding
	 */

	public void courtProceedingYes() {
		wdUtil.optionButton(locators.get("COURT_PROCEEDING_YES"));
		wdUtil.selectListItem(locators.get("COURT_PROCEEDING_DATE"),locators.get("COURT_PROCEEDING_DATE_V"));
		wdUtil.waitFor(1000);
		wdUtil.selectListItem(locators.get("COURT_PROCEEDING_MONTH"),locators.get("COURT_PROCEEDING_MONTH_V"));
		wdUtil.waitFor(1000);
		wdUtil.selectListItem(locators.get("COURT_PROCEEDING_YEAR"),locators.get("COURT_PROCEEDING_YEAR_V"));
		wdUtil.waitFor(1000);			
		wdUtil.findBySendKeys(locators.get("CLAIM_NUMBER"), locators.get("CLAIM_NUMBER_V"));

		wdUtil.AddLog("Did you start court proceedings? selected as Yes..");
	}

	public void courtProceedingNo() {
		
		wdUtil.optionButton(locators.get("COURT_PROCEEDING_NO"));
		wdUtil.findBySendKeys(locators.get("COURT_REASON"), locators.get("COURT_REASON_V"));
		wdUtil.AddLog("Did you start court proceedings? selected as No..");
	}

	public void courtProceeding(String claimant,String decision) {

		// Yes for court proceeding started and No for court proceeding not started
		switch (claimant) {
		case "unrep":	
			unrepClaim();
			wdUtil.findByClick(locators.get("SELECT_DOC"));
			if(decision.equalsIgnoreCase("Yes")) {
				courtProceedingYes();

			}else if(decision.equalsIgnoreCase("No")) {
				courtProceedingNo();
			}

			wdUtil.findByClick(locators.get("CONTINUE"));	
			//Additonal info for court

			boolean addinfoscreen=wdUtil.isElementPresent(locators.get("ADDITIONAL_INFO_TITLE"));
			if (addinfoscreen == true) {			
				wdUtil.AddLog("Additional info screen is displayed..");
				wdUtil.optionButton(locators.get("RELATED_CLAIM_NO"));
				wdUtil.findByClick(locators.get("CONTINUE"));

			}

			//Preparing for court screen

			wdUtil.findByClick(locators.get("CONTINUE"));

			break;

		case "prouser":
			proUserClaim();

			wdUtil.findByClick(locators.get("SELECT_DOC"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			if(decision.equalsIgnoreCase("Yes")) {
				courtProceedingYes();

			}else if(decision.equalsIgnoreCase("No")) {
				courtProceedingNo();
			}

			wdUtil.findByClick(locators.get("CONTINUE"));			

			//Preparing for court screen
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.defaultContent();
			break;

		case "mibpro":
			MIBProActionsPage mibpro=new MIBProActionsPage();
			mibpro.mibproUserClaim();

			wdUtil.findByClick(locators.get("SELECT_DOC"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			if(decision.equalsIgnoreCase("Yes")) {
				courtProceedingYes();

			}else if(decision.equalsIgnoreCase("No")) {
				courtProceedingNo();
			}

			wdUtil.findByClick(locators.get("CONTINUE"));
			//Additonal info for court
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			boolean addinfo=wdUtil.isElementPresent(locators.get("ADDITIONAL_INFO_TITLE"));
			if (addinfo == true) {			
				wdUtil.AddLog("Additional info screen is displayed..");
				wdUtil.optionButton(locators.get("RELATED_CLAIM_NO"));
				wdUtil.findByClick(locators.get("CONTINUE"));

			}


			//Preparing for court screen
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.defaultContent();
			break;
			
		}
		GetDriver.getInstance().setDriver(driver);
	}


	public void courtProceedingInterim(String claimant,String decision) {

		// Yes for court proceeding started and No for court proceeding not started
		switch (claimant) {
		case "unrep":	
			unrepClaim();			
			wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));			
			wdUtil.findByClick(locators.get("SELECT_DOC"));			
			if(decision.equalsIgnoreCase("Yes")) {
				courtProceedingYes();

			}else if(decision.equalsIgnoreCase("No")) {
				courtProceedingNo();
			}
			wdUtil.findByClick(locators.get("CONTINUE"));		

			//Preparing for court screen

			wdUtil.findByClick(locators.get("CONTINUE"));

			break;

		case "prouser":
			proUserClaim();
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME1"));
			wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME2"));
			wdUtil.findByClick(locators.get("SELECT_DOC"));
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME2"));
			if(decision.equalsIgnoreCase("Yes")) {
				courtProceedingYes();

			}else if(decision.equalsIgnoreCase("No")) {
				courtProceedingNo();
			}

			wdUtil.findByClick(locators.get("CONTINUE"));			

			//Preparing for court screen
			wdUtil.defaultContent();
			wdUtil.switchToFrame(locators.get("FRAME2"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.defaultContent();
			break;

		case "mibpro":

			
			break;
		}
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void unrepNoCourtProccedingDocsForInterimNonPaymentsecondtime() {
		unrepClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.findByClick(locators.get("DOCS_COURT_AT_INTERIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		courtProceedingNo();
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPT_INTERIM_PAYMENT"));
		wdUtil.checkBox(locators.get("ACCEPT_INTERIM_PAYMENT_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("unrep select docs for interim payment");
		GetDriver.getInstance().setDriver(driver);
	}

	public void visibilityAdditionalCourtFeePayable() {
		
		boolean page=wdUtil.isElementPresent(locators.get("ADD_COURT_FEE_PAYABLE"));
		if (page== true) {			
			wdUtil.AddLog("Additional court fee payable screen is displayed..");
		}else {
			wdUtil.AddLog("Additional court fee payable screen is NOT displayed.. ");
		}
	}

	public void visibilityCourtFeePayable() {

		boolean page=wdUtil.isElementPresent(locators.get("COURT_FEE_PAYABLE"));
		if (page== true) {			
			wdUtil.AddLog("Court fee payable screen is displayed..");
		}else {
			wdUtil.AddLog("Court fee payable screen is NOT displayed.. ");
		}
	}
	
	/* Sprint 41 changes*/
	

public void unrepselectDocumentOtherThanInterim(String Evidence_support ,String Other_Medical,String Court_Valuation,String SCNF, String Comp_Response, String Signed_doc,String Evidence_fees,String list_loss,String Medical_report, String Def_Documents,String Def_V_Events,String ROOA) {
	
	
	
	if(Evidence_support.equalsIgnoreCase("Yes")) {			
		wdUtil.findByClick(locators.get("SUPPORT_CLAIM"));
		wdUtil.checkBox(locators.get("SUPPORT_CLAIM_CHKBOX"));

	}

	if(Other_Medical.equalsIgnoreCase("Yes")) {

	}

	if(Court_Valuation.equalsIgnoreCase("Yes")) {
		wdUtil.findByClick(locators.get("COURT_VAL"));
		wdUtil.checkBox(locators.get("COURT_VAL_CHKBOX"));
	}

	if(SCNF.equalsIgnoreCase("Yes")) {

		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
	}

	if(Comp_Response.equalsIgnoreCase("Yes")) {

		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));

	}

	if(Signed_doc.equalsIgnoreCase("Yes")) {

	}

	if(Evidence_fees.equalsIgnoreCase("Yes")) {

	}

	
	if(list_loss.equalsIgnoreCase("Yes")) {
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));

	}

	if(Medical_report.equalsIgnoreCase("Yes")) {
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));

	}

	if(Def_Documents.equalsIgnoreCase("Yes")) {

	}

	if(Def_V_Events.equalsIgnoreCase("Yes")) {

	}
	
	if(ROOA.equalsIgnoreCase("Yes")) {			
		wdUtil.findByClick(locators.get("ACCEPT_OFFER"));
		wdUtil.checkBox(locators.get("ACCEPT_OFFER_CHKBOX"));
	}
	
	wdUtil.findByClick(locators.get("CONTINUE"));
	wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
	
	GetDriver.getInstance().setDriver(driver);
}


public void unrepcourtScreen(String Claimant_represent,String Defendant_details,String GotoCourt,String Oral_hearing,String Witnesses,String CourtPackEvidence,String NVC,String Fees,String CourtFeePayable,String AddCourtFeePayable ) 
{
	unrepClaim();
	wdUtil.findByClick(locators.get("VIEW_MORE"));
		
	//Confirmation of Court Pack list
	wdUtil.findByClick(locators.get("CONTINUE")); 
	
	if (Claimant_represent.equalsIgnoreCase("Yes")) {
	wdUtil.optionButton(locators.get("PRO_DIFF_ADDR"));
	wdUtil.findBySendKeys(locators.get("FIXED_LEGAL_COST"),locators.get("FIXED_LEGAL_COST_V"));
	wdUtil.findByClick(locators.get("CONTINUE")); 
	}
		
	if (Defendant_details.equalsIgnoreCase("Yes")) {
	wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
	wdUtil.findByClick(locators.get("CONTINUE"));
	}
	
	if (GotoCourt.equalsIgnoreCase("Yes")) {
	wdUtil.findBySendKeys(locators.get("COUNTY_COURT"),locators.get("COUNTY_COURT_V"));
	wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
	wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"),locators.get("EXISTING_CLAIM_V"));
	wdUtil.findByClick(locators.get("CONTINUE"));
	}
	
	if (Oral_hearing.equalsIgnoreCase("Yes")) {
	wdUtil.findByClick(locators.get("HEARING_YES"));
	wdUtil.findByClick(locators.get("CONTINUE"));
	}
	
	
	if (Witnesses.equalsIgnoreCase("Yes")) {
	wdUtil.checkBox(locators.get("ADD_WITNESS"));
	wdUtil.findBySendKeys(locators.get("ADDLN_WITNESS_NAME"), locators.get("WITNESS_NAME_V"));
	wdUtil.findByClick(locators.get("CONTINUE"));
	}
	
	if (CourtPackEvidence.equalsIgnoreCase("Yes")) {
		wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
	}
	
	

	if (NVC.equalsIgnoreCase("Yes")) {
		wdUtil.optionButton(locators.get("NVC_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));

	}
	
	if (Fees.equalsIgnoreCase("Yes")) {

	}
	
	if (CourtFeePayable.equalsIgnoreCase("Yes")) {
					
		boolean link=wdUtil.isElementPresent(locators.get("COURT_FEE_PAYABLE"));
		if (link== true) {			
			wdUtil.AddLog("Additional court fee payable screen is displayed..");
			wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		}else {
			wdUtil.AddLog("Additional court fee payable screen is NOT displayed.. Not working as expected");
		}
		
		wdUtil.findByClick(locators.get("CONTINUE"));

	}

	if (AddCourtFeePayable.equalsIgnoreCase("Yes")) {
				
		boolean link=wdUtil.isElementPresent(locators.get("ADD_COURT_FEE_PAYABLE"));
		if (link== true) {			
			wdUtil.AddLog("Additional court fee payable screen is displayed..");
			boolean ackcheckbox=wdUtil.isElementPresent(locators.get("CLAIMANT_ACK"));
			if(ackcheckbox==true) {
				wdUtil.checkBox(locators.get("CLAIMANT_ACK"));

	
			}
		}else {
			wdUtil.AddLog("Additional court fee payable screen is NOT displayed.. Not working as expected");
		}
		
		wdUtil.findByClick(locators.get("CONTINUE"));
	}
	
	
	
	wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
	wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
	wdUtil.findByClick(locators.get("RETURN"));
	System.out.println("Unrep acknowledge court docs");
	GetDriver.getInstance().setDriver(driver);
}


public void unrepFirstOfferGoToCourt(String loss,String tariff, String Uplift, String NonTariff)
{
	unrepClaim();
	wdUtil.findByClick(locators.get("VIEW_OFFER"));
	wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
	wdUtil.findByClick(locators.get("CONTINUE"));
	wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
	wdUtil.findByClick(locators.get("CONTINUE"));
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
	
	wdUtil.findByClick(locators.get("CONFIRM"));
	GetDriver.getInstance().setDriver(driver);
}




public void unrepselectDocumentInterim(String ROOA_Interim,String Interim_Request,String Interim_payment,String Acceptance_Interim_Payment) {
			
	
	if(ROOA_Interim.equalsIgnoreCase("Yes")) {
		wdUtil.findByClick(locators.get("ACCEPT_INTERIM_PAYMENT"));
		wdUtil.checkBox(locators.get("ACCEPT_INTERIM_PAYMENT_CHKBOX"));
	}
	
	if(Interim_Request.equalsIgnoreCase("Yes")) {			
		wdUtil.findByClick(locators.get("INTERIM_REQUEST"));
		wdUtil.checkBox(locators.get("INTERIM_REQUEST_CHKBOX"));

	}
	
	if(Interim_payment.equalsIgnoreCase("Yes")) {			
		wdUtil.findByClick(locators.get("INTERIM"));
		wdUtil.checkBox(locators.get("INTERIM_CHKBOX"));

	}
	
	if(Acceptance_Interim_Payment.equalsIgnoreCase("Yes")) {			
		wdUtil.findByClick(locators.get("ACCEPT_INTERIM_PAYMENT"));
		wdUtil.checkBox(locators.get("ACCEPT_INTERIM_PAYMENT_CHKBOX"));

	}
	
	GetDriver.getInstance().setDriver(driver);
}

public void unrepRequestNVC()
{
	//answer NVC
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
			unrepClaimStatusEnd("Pending-NVCResponse");
			GetDriver.getInstance().setDriver(driver);
}


	

}
