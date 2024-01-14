package com.cucumbercraft.pages;

import java.util.List;
import java.util.Map;

import org.apache.tools.ant.launch.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.WebDriverUtil;
import com.itextpdf.text.log.SysoCounter;

public class ProUserActionsPage {

	Map<String, String> plocators = GetDriver.getInstance().getProUserLocators(); 
	Map<String,String> locators= GetDriver.getInstance().getClaimantActionsLocators();
	Map<String,String> pslocators= GetDriver.getInstance().getProUserStatusLocators();
	String claimNumber=GetDriver.getInstance().getOICref();
	WebDriver driver=GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil=new WebDriverUtil(driver);

	public void proUserClaim()

	{

		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void proUserClaimStatus(String status)
	{
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.myTeamsWorkLink(plocators.get("MYTEAMWORK"));
		wdUtil.claimantStatus(plocators.get("CLAIM_STATUS").replace("$claimNumber",claimNumber),status);
		wdUtil.myTeamsWorkLink(plocators.get("MYWORK"));
		wdUtil.doubleClick(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(plocators.get("CLAIM_STATUS_MSG"), pslocators.get(status));
		GetDriver.getInstance().setDriver(driver);
	}

	public void reqInterimPayment() 
	{
		proUserClaim();
		System.out.println("Text - " + locators.get("REQ_INT_PYMT"));
		wdUtil.clickLink(locators.get("REQ_INT_PYMT"));
		wdUtil.findBySendKeys(locators.get("INTAMTREQ"), locators.get("INTAMTREQ_VALUE"));
		wdUtil.findBySendKeys(locators.get("EXPLAINREASON"), locators.get("EXPLAINREASON_VALUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CLOSE"));
		wdUtil.defaultContent();
		GetDriver.getInstance().setDriver(driver);
	}



	public void prouserGotoCourtOcs2()
	{
		/*
		 * Updated in Sprint 41 
		 * Author P Vidya
		 */
		proUserClaim();
		wdUtil.clickLink(locators.get("GOTOCOURTLINK"));
		wdUtil.optionButton(locators.get("COURT_VALUE_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("SELECT_DOC"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		ClaimantActionsPage proceeding=new ClaimantActionsPage();
		proceeding.courtProceedingNo();
		wdUtil.findByClick(locators.get("CONTINUE"));

		if(GetDriver.getInstance().getNVCStatus()==true)
		{
			wdUtil.optionButton(locators.get("TEMPVEHPROVIDED"));
			wdUtil.optionButton(locators.get("TEMPVEHCOSTPAID"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.optionButton(locators.get("VEHDRIVENTOGARAGE"));
			wdUtil.optionButton(locators.get("VEHHELDINSTORAGE"));
			wdUtil.findByClick(locators.get("CONTINUE"));
			wdUtil.checkBox(locators.get("HASUPLOADNVCDOC"));
			wdUtil.findByClick(locators.get("CONTINUE"));

		}

		/*wdUtil.optionButton(locators.get("ISVEHICLEDAMAGED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClear(locators.get("DOCS_COURT"));*/
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		/*	wdUtil.findByClick(locators.get("COURT_VAL"));
		wdUtil.checkBox(locators.get("COURT_VAL_CHKBOX"));*/
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
		System.out.println("NVC skipped");
		System.out.println("claimant proceed with court");
		GetDriver.getInstance().setDriver(driver);		
	}

	public void prouserSelectCourtDocs() 
	{
		proUserClaimStatus("Pending-OfferCourtList");
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
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.defaultContent();
		System.out.println("prouser court documents submitted successfully");
		GetDriver.getInstance().setDriver(driver);
	}
	public void prouserReviewInterimPayment()
	{
		proUserClaim();
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
		System.out.println("prouser review and accepts interim payment");
		GetDriver.getInstance().setDriver(driver);
	}
	public void acceptDenial() 
	{
		proUserClaimStatus("Pending-LiabilityRejected");
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ACCEPT_DECISION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Claimant Decision accepted");
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void prouserGotoCourtOcs4() 
	{
		proUserClaim();
		wdUtil.clickLink(locators.get("GOTOCOURTLINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("COURT_DECIDE_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		// select court documents
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
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
		System.out.println("claimant proceed with court over fee proposal");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void ChallengeLiabilityDecision() 
	{
		proUserClaim();
		wdUtil.clickLink(locators.get("CHALLENGEPARTLBLTY"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CLAIMANTCHALLANGECOMMENT"), locators.get("CLAIMANTCHALLANGECOMMENT_V"));
		wdUtil.optionButton(locators.get("DRIVER_RESPONSIBLE"));
		wdUtil.findBySendKeys(locators.get("CHALLENGE_PERCENTAGE"), locators.get("CHALLENGE_PERCENTAGE_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("prouser Challenge Liability Decision");
		GetDriver.getInstance().setDriver(driver);		
	}
	
	public void prouserAcceptOfferRejectfee() {

		proUserClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("OFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("REVIEW_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
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
		System.out.println("Prouser accepts offer and Reject fees proposal");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void acceptRevisedFeeOffer() 
	{
		proUserClaimStatus("Pending-ReviewFeesOffer");
		wdUtil.findByClick(locators.get("REVIEW_FEE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ACCEPT_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("prouser accept revised");
		GetDriver.getInstance().setDriver(driver);
	}

	public void RejectFeeOfferAndGoToCourt()
	{
		proUserClaimStatus("Pending-DecideFeesOffer");
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
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Prouser Reject Fee proposal and upload court documents");
		GetDriver.getInstance().setDriver(driver);
	}

	public void acceptDecision() 
	{
		proUserClaim();
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ACCEPT_DECISION"));
		wdUtil.findByClick(locators.get("CONTINUE_DECISION"));
		wdUtil.findByClick(locators.get("CONFIRM_FINISH"));
		System.out.println("Claimant Decision accepted");
		GetDriver.getInstance().setDriver(driver);

	}

	public void uploadMRWaitoutPrognosisAndWaits(String status)
	{
		proUserClaimStatus(status);//Journey10
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findBySendKeys(locators.get("MEDCOSEARCHREF"), locators.get("MEDCOSEARCHREF_V"));

		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadFile(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"),locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(10000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.selectListItem(locators.get("PROG_PERIOD"), locators.get("PROG_PERIOD_24"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("FROM_MED_EXAM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//wait out prognosis
		wdUtil.scrollDown(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.optionButton(locators.get("RELEASEMEDREPTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("Prouser uploaded medical report with waitout prognosis");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void gotoCourtFinalOffer()
	{
		proUserClaimStatus("Pending-FinalWithdrawn");
		wdUtil.clickLink(locators.get("GO_TO_COURT_LINK"));
		wdUtil.optionButton(locators.get("COURT_VALUE_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		System.out.println("prouser goes to court");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void answerNVC() {

		proUserClaimStatus("Pending-NVCClaimant");
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

	
	public void waitoutAtOffer()
	{
		proUserClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("WAITOUTPROGOPTION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		System.out.println("Prouser decides to waitout at offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void offerAtWaitoutAddedLoss()
	{
		proUserClaimStatus("Pending-WaitPrognosisOffer");
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("ISSTILLSUFFERING_YES"));
		wdUtil.optionButton(locators.get("ADDITIONALREPORT"));
		wdUtil.optionButton(locators.get("PROCEEDOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		//wdUtil.findByClick(locators.get("FINISH"));
		//Updated in Sprint41
		wdUtil.findByClick(locators.get("CONFIRM"));
		proUserClaimStatus("Pending-UpdateOfferFinancial");
		System.out.println("Prouser proceeds with offer during waitout");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void waitoutNewReportProceedOffer()
	{
		proUserClaimStatus("Pending-WaitPrognosisOffer");
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ISSTILLSUFFERING_YES"));
		wdUtil.findByClick(locators.get("ADDITIONALREPORT_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("FINISH"));
		// upload new medical report
		// New REPORT
		System.out.println("uploading new medical report");
		proUserClaimStatus("Pending-Medical");
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadNewMedicalReport(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));

		// Proceed with offer
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("PROCEED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		// New REPORT
		System.out.println("uploading new medical report");
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		// uplift
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Proceed with offer");
	}
	
	public void rejectFirstOffer()
	{
		proUserClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		//statement of truth
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), plocators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("claimant rejected offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void rejectOfferGoesToCourt()
	{
		proUserClaimStatus("Pending-ReviewOffer");
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.scrollDown(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("prouser go to court");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void uploadMRWaitoutPrognosis(String status)
	{
		proUserClaimStatus(status);
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findBySendKeys(locators.get("MEDCOSEARCHREF"), locators.get("MEDCOSEARCHREF_V"));

		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadFile(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"),locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(10000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.selectListItem(locators.get("PROG_PERIOD"), locators.get("PROG_PERIOD_V"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("FROM_MED_EXAM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		System.out.println("Prouser uploaded medical report with waitout prognosis");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void addLoss() 
	{
		proUserClaim();
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

	public void waitoutPrognosisProceedOffer() 
	{
		proUserClaimStatus("Pending-WaitPrognosisMedical");
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("ISSTILLSUFFERING_YES"));
		wdUtil.findByClick(locators.get("ADDITIONALREPORT_NO"));
		wdUtil.findByClick(locators.get("PROCEEDOFFER"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM")); // Updated in sprint 41
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("ISUPLIFTJUSTIFIED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(plocators.get("CLAIMANT_CONSENT_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), plocators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Prouser proceeds with offer during wait out prognosis ");
		GetDriver.getInstance().setDriver(driver);
	}

	public void prouserDisputeAckCourtDocsClaim(String status) 
	{
		proUserClaimStatus(status);
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("PRO_DIFF_ADDR"));
		wdUtil.findBySendKeys(locators.get("FIXED_LEGAL_COST"),locators.get("FIXED_LEGAL_COST_V"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"),locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"),locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("prouser acknowledge court docs");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void prouserWitnessAckCourtDocs(String status) 
	{
		proUserClaimStatus(status);
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("PRO_DIFF_ADDR"));
		wdUtil.findBySendKeys(locators.get("FIXED_LEGAL_COST"),locators.get("FIXED_LEGAL_COST_V"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"),locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"),locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("HEARING_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("ADD_WITNESS"));
		wdUtil.findBySendKeys(locators.get("ADDLN_WITNESS_NAME"), locators.get("WITNESS_NAME_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("prouser acknowledge court docs");
		GetDriver.getInstance().setDriver(driver);
	}
	
	
	public void prouserNVCAckCourtDocs(String status) 
	{
		proUserClaimStatus(status);
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("PRO_DIFF_ADDR"));
		wdUtil.findBySendKeys(locators.get("FIXED_LEGAL_COST"),locators.get("FIXED_LEGAL_COST_V"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"),locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"),locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("ADD_WITNESS"));
		wdUtil.findBySendKeys(locators.get("ADDLN_WITNESS_NAME"), locators.get("WITNESS_NAME_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(plocators.get("NVC_COURT"));
		wdUtil.findBySendKeys(plocators.get("NVC_COURT_DIR"),plocators.get("NVC_COURT_DIR_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("prouser acknowledge court docs");
		GetDriver.getInstance().setDriver(driver);
	}
	

	public void uploadReportwithUplift() 
	{
		proUserClaimStatus("Pending-Medical");
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findBySendKeys(locators.get("MEDCOSEARCHREF"), locators.get("MEDCOSEARCHREF_V"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadFile(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(5000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Summary
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.scrollDown(locators.get("PROCEED"));
		wdUtil.optionButton(locators.get("PROCEED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_YES"));
		
		wdUtil.findByClick(locators.get("SUPPORT_GREATERVALUE"));
		wdUtil.findByClick(locators.get("WHIPLASH_INJURY"));
		
		wdUtil.findBySendKeys(locators.get("EXCEPTIONALLY_SEVERE"), locators.get("EXCEPTIONALLY_SEVERE_V"));		
		wdUtil.optionButton(locators.get("EXCEPTIONAL_YES"));
		wdUtil.findBySendKeys(locators.get("EXCEPTIONAL_CIRCUM"), locators.get("EXCEPTIONAL_CIRCUM_V"));
		wdUtil.findBySendKeys(locators.get("UPLIFT_PERCENT"), locators.get("UPLIFT_PERCENT_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		
		
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		wdUtil.findByClick(locators.get("CLAIMANT_CONSENT_NO"));		
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), plocators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Prouser uploaded medical report with uplift");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void uploadReportOnly(String status)
	{

		proUserClaimStatus(status);
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findBySendKeys(locators.get("MEDCOSEARCHREF"), locators.get("MEDCOSEARCHREF_V"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadFile(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(5000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Summary
		wdUtil.findByClick(locators.get("CONTINUE"));
		System.out.println("Prouser uploaded medical report only");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void uploadReport(String status) 
	{
		proUserClaimStatus(status);
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findBySendKeys(locators.get("MEDCOSEARCHREF"), locators.get("MEDCOSEARCHREF_V"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadFile(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(5000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Summary
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.scrollDown(locators.get("PROCEED"));
		wdUtil.optionButton(locators.get("PROCEED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(plocators.get("CLAIMANT_CONSENT_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), plocators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Prouser uploaded medical report without waitout prognosis");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void prouserRequestForRevisedOffer() 
	{
		proUserClaim();
		wdUtil.findByClick(locators.get("VIEWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("OFFER_DISPUTE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("BACKTOCOMP"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_V"));
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
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), plocators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("pro user request for revised offer sent to compensator");
		GetDriver.getInstance().setDriver(driver);

	}
	public void prouserReviewmedReportandProceedOffer() 
	{
		proUserClaim();
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("PROCEED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(plocators.get("CLAIMANT_CONSENT_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), plocators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("Prouser proceeds with offer");
		GetDriver.getInstance().setDriver(driver);
	}
	public void prouserDisputeFeeCourt(String status)
	{
		proUserClaimStatus(status);
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("PRO_DIFF_ADDR"));
		wdUtil.findBySendKeys(locators.get("FIXED_LEGAL_COST"),locators.get("FIXED_LEGAL_COST_V"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"),locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"),locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("FEE_LINK"));
		wdUtil.checkBox(locators.get("FEE_CHKBOX"));
		wdUtil.findBySendKeys(locators.get("INVOICE_PROVIDER"), locators.get("INVOICE_PROVIDER_V"));
		wdUtil.selectListItem(locators.get("FEE_DATE"), locators.get("FEE_DATE_V"));
		wdUtil.selectListItem(locators.get("FEE_MONTH"), locators.get("FEE_MONTH_V"));
		wdUtil.selectListItem(locators.get("FEE_YEAR"), locators.get("FEE_YEAR_V"));
		wdUtil.checkBox(locators.get("DISPUTE_FEE_AMT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("prouser acknowledge court docs");
		GetDriver.getInstance().setDriver(driver);
	}




	public void waitoutNewReportAtOffer()
	{
		proUserClaimStatus("Pending-WaitPrognosisMedical");
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("ISSTILLSUFFERING"));
		wdUtil.findByClick(locators.get("ADDITIONALREPORT_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		// upload new medical report
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
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
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Summary
		wdUtil.findByClick(locators.get("CONTINUE"));
		System.out.println("Proceed with offer");
		// Proceed with offer
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("PROCEED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(plocators.get("CLAIMANT_CONSENT_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), plocators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		System.out.println("prouser uploads new report and proceeds with off");
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void rejectOfferselectCourtDoc() {

		proUserClaimStatus("Pending-OfferCourtList");
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.scrollDown(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));	
		wdUtil.findByClick(locators.get("COURT_VAL"));
		wdUtil.checkBox(locators.get("COURT_VAL_CHKBOX"));
		wdUtil.findByClick(locators.get("CLAIMANT_LOSS"));
		wdUtil.checkBox(locators.get("CLAIMANT_LOSS_CHKBOX"));
		wdUtil.findByClick(locators.get("SUPPORT_CLAIM"));
		wdUtil.checkBox(locators.get("SUPPORT_CLAIM_CHKBOX"));
		wdUtil.findByClick(locators.get("MEDICALREPORT"));
		wdUtil.checkBox(locators.get("MEDICALREPORT_CHKBOX"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("prouser select court docs");
		GetDriver.getInstance().setDriver(driver);
	}

	public void prouserGoToCourtRejectLiability() 
	{
		proUserClaimStatus("Pending-LiabilityRejected");
		wdUtil.findByClick(locators.get("VIEWMOREDETREP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("GOTOCOURTOPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("ANYOTHERCLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("COMPENSATOR_RESPONSE"));
		wdUtil.checkBox(locators.get("COMPENSATOR_RESPONSE_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("prouser go to court and reject liability");
		GetDriver.getInstance().setDriver(driver);

	}

	public void prouserDisputeAckLiability() 
	{

		proUserClaim();
		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("PRO_DIFF_ADDR"));
		wdUtil.findBySendKeys(locators.get("FIXED_LEGAL_COST"),locators.get("FIXED_LEGAL_COST_V"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"),locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"),locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.checkBox(locators.get("ADD_WITNESS"));
		wdUtil.findBySendKeys(locators.get("ADDLN_WITNESS_NAME"), locators.get("WITNESS_NAME_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("COURT_PACK_EVIDENCE_YES"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.optionButton(locators.get("COURT_PAY"));
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		System.out.println("prouser acknowledge court docs for liability dispute");
		GetDriver.getInstance().setDriver(driver);
	}

	
	public void prouserReopenClaimLiability()
	{
		
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("RESOLVED_CLAIM"));
		wdUtil.clickLink(locators.get("SHOWFILTERS"));
		wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
		wdUtil.findByClick(locators.get("FILTER"));
		wdUtil.claimantStatus(plocators.get("RESOLVED_CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", "Resolved-CourtLiability"),"Resolved-CourtLiability");
		wdUtil.doubleClick(plocators.get("RESOLVED_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(locators.get("CLAIM_STATUS_MSG"), pslocators.get("Resolved-CourtLiability"));
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
		System.out.println("prouser reopen the claim and select DME");
		GetDriver.getInstance().setDriver(driver);

	}
	
	public void prouserWithdrawAndReplaceOffer() {
		proUserClaimStatus("Pending-RespondCounter");
		wdUtil.clickLink(locators.get("WITHDRAWOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.checkBox(locators.get("WITHDRAWOFFER_ACCEPT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("WITHDRAW_OFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		// Make Replacement offer
		wdUtil.findByClick(locators.get("REPLACEMENTOFFER"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("INJURYTARIFF"));
		wdUtil.optionButton(locators.get("TARIFF"));
		wdUtil.scrollUntilVisibleElement(locators.get("DURATION_INJURY"));
		wdUtil.selectListItem(locators.get("DURATION_INJURY"),locators.get("DURATION_INJURY_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("PROPERTYOTHERITEMS"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_V"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"), locators.get("COUNTEROFFER_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("INJURYNONTARIFF"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER"), locators.get("COUNTEROFFER_NONINJURY"));
		wdUtil.findBySendKeys(locators.get("COUNTEROFFER_COMMENT"),locators.get("COUNTEROFFERNONINJURY_COMMENT_VALUE"));
		wdUtil.findByClick(locators.get("SAVEANDCONTINUE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CLOSE"));
		System.out.println("Prouser withdraw and replace with new offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void gotoCourtFeeSettlement()
	{
		proUserClaimStatus("Pending-Acknowledgement");
		wdUtil.clickLink(locators.get("GO_TO_COURT_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("NO_PAY_FEE"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
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
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Prouser goes to court non-payment of fee");
		GetDriver.getInstance().setDriver(driver);
	}
	
	
	public void prouserGotoCourtOptionOCS3() {
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("RESOLVED_CLAIM"));
		wdUtil.clickLink(locators.get("SHOWFILTERS"));
		wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
		wdUtil.findByClick(locators.get("FILTER"));
		wdUtil.doubleClick(plocators.get("RESOLVED_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("GO_TO_COURT_LINK"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("NO_PAY_CLAIM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		
		
		
		
		/* Added in Sprint 41*/
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("SELECT_DOC"));
		
		ClaimantActionsPage proceeding=new ClaimantActionsPage();
		proceeding.courtProceedingNo();
		
		//wdUtil.defaultContent();
		//wdUtil.switchToFrame(locators.get("FRAME1"));
		//wdUtil.findByClick(locators.get("DOCS_COURT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("ACCEPT_OFFER"));
		wdUtil.checkBox(locators.get("ACCEPT_OFFER_CHKBOX"));
		wdUtil.findByClick(locators.get("SCNF"));
		wdUtil.checkBox(locators.get("SCNF_CHKBOX"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		System.out.println("Prouser goes to court non-payment of offer");
		GetDriver.getInstance().setDriver(driver);
	}
	public void prouserAddFee() 
	{

		proUserClaim();
		wdUtil.clickLink(locators.get("ADD_LOSS_LINK"));
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
		System.out.println("Claimant adds Fee");
		GetDriver.getInstance().setDriver(driver);
	}

	public void resolvedStatus(String status)
	{
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.findByClick(locators.get("RESOLVED_CLAIM"));
		//wdUtil.clickLink(locators.get("SHOWFILTERS"));
		//wdUtil.findBySendKeys(locators.get("PORTALREF"), claimNumber);
		//wdUtil.findByClick(locators.get("FILTER"));
		wdUtil.claimantStatus(plocators.get("RESOLVED_CLAIM_STATUS").replace("$claimNumber", claimNumber).replace("$status", status),status);
		wdUtil.doubleClick(plocators.get("RESOLVED_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.claimantStatusMSG(plocators.get("CLAIM_STATUS_MSG"), pslocators.get(status));	
		System.out.println("Claim is moved to "+status);
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void prouserCausationDisputeOffer()
	{
		proUserClaimStatus("Pending-CausationNoOffer");
		wdUtil.findByClick(locators.get("CHECK_REQUEST"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("claimant accepts dispute decision");
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("CLOSE_TAB"));
		System.out.println("prouser accepts final offer");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void prouserRejectcausationDisputeFinalOffer()
	{
		proUserClaimStatus("Pending-CausationFinalOffer");
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
	
	public void withDrawClaim(String status) 
	{
		proUserClaimStatus(status);
		wdUtil.clickLink(locators.get("WITHDRAWCLAIM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("WITHDRAW_OPTION"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("WITHDRAW"));
		System.out.println("prouser withdraws claim");
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void proVerifyChallengeLiability()
	{
		proUserClaim();
		wdUtil.assertLink(locators.get("CHALLENGEPARTLBLTY"));
		GetDriver.getInstance().setDriver(driver);
	}

	public void logout()
	{

		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("LOGOUT"));
	}

	
	/*
	 * Author: Sourav Dutta 
	 * Comment: Sprint 41 changes
	 */
	
	public void prouserFirstOfferGoToCourt(String loss,String tariff, String Uplift, String NonTariff)
	{
		proUserClaim();
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		
		wdUtil.findByClick(locators.get("VIEW_OFFER"));
		
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
	
	/*
	 *Author: Sourav Dutta
	 *Sprint 41 changes for 2nd time court proceeding
	 */
	
	public void selectDocumentOtherThanInterim(String Evidence_support ,String Other_Medical,String Court_Valuation,String SCNF, String Comp_Response, String Signed_doc,String Evidence_fees,String list_loss,String Medical_report, String Def_Documents,String Def_V_Events,String ROOA) {
		wdUtil.defaultContent();
		try {
			wdUtil.waitFor(2000);
			final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			System.out.println(iframes.size());
			if (iframes.size()==2) {
				wdUtil.defaultContent();
				wdUtil.switchToFrame(locators.get("FRAME1"));
				System.out.println(locators.get("FRAME1"));
			}else if(iframes.size()==3) {
				wdUtil.defaultContent();
				wdUtil.switchToFrame(locators.get("FRAME2"));
				System.out.println(locators.get("FRAME2"));
			}			
		} catch (Exception e) {
			System.out.println(e.toString());

		}	
		
		
		
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
		wdUtil.defaultContent();
		GetDriver.getInstance().setDriver(driver);
	}
	
	public void selectDocumentInterim(String ROOA_Interim,String Interim_Request,String Interim_payment,String Acceptance_Interim_Payment) {
		wdUtil.defaultContent();
		try {
			wdUtil.waitFor(2000);
			final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			System.out.println(iframes.size());
			if (iframes.size()==2) {
				wdUtil.defaultContent();
				wdUtil.switchToFrame(locators.get("FRAME1"));
				System.out.println(locators.get("FRAME1"));
			}else if(iframes.size()==3) {
				wdUtil.defaultContent();
				wdUtil.switchToFrame(locators.get("FRAME2"));
				System.out.println(locators.get("FRAME2"));
			}			
		} catch (Exception e) {
			System.out.println(e.toString());

		}	

		
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
		wdUtil.defaultContent();
		GetDriver.getInstance().setDriver(driver);
	}


	public void visibilityAdditionalCourtFeePayable() {
		
		boolean link=wdUtil.isElementPresent(locators.get("ADD_COURT_FEE_PAYABLE"));
		if (link== true) {			
			wdUtil.AddLog("Additional court fee payable screen is displayed..");
		}else {
			wdUtil.AddLog("Additional court fee payable screen is NOT displayed.. Not working as expected");
		}
		

	}
	
	
	public void courtScreen(String Claimant_represent,String Defendant_details,String GotoCourt,String Oral_hearing,String Witnesses,String CourtPackEvidence,String NVC,String Fees,String CourtFeePayable,String AddCourtFeePayable ) 
	{
		proUserClaim();
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
		System.out.println("prouser acknowledge court docs");
		GetDriver.getInstance().setDriver(driver);
	}
	
	
	public void prouserCourtform() 
	{

		proUserClaim();
		wdUtil.findByClick(locators.get("CONTINUE_TO_REQUEST"));
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("VIEWMOREDET"));
		
		//Confirmation of Court Pack list
		wdUtil.defaultContent(); 
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		
		wdUtil.optionButton(locators.get("PRO_DIFF_ADDR"));
		wdUtil.findBySendKeys(locators.get("FIXED_LEGAL_COST"),locators.get("FIXED_LEGAL_COST_V"));
		wdUtil.findByClick(locators.get("CONTINUE")); 
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		
		//Defendant’s details
		wdUtil.optionButton(locators.get("DEF_ADDR_NO"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		//Going to court
		wdUtil.findBySendKeys(locators.get("COUNTY_COURT"),locators.get("COUNTY_COURT_V"));
		wdUtil.optionButton(locators.get("COURT_PROCEED_YES"));
		wdUtil.findBySendKeys(locators.get("EXISTING_CLAIM"),locators.get("EXISTING_CLAIM_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		//Court fee payable
		wdUtil.checkBox(locators.get("CLAIMANT_ACK"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		wdUtil.scrollDown(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("CONFIRMANDSEND"));
		wdUtil.findByClick(locators.get("RETURN"));
		
		System.out.println("prouser acknowledge court docs for Interim");
		wdUtil.AddLog("Prouser acknowledge court docs for Interim");
		GetDriver.getInstance().setDriver(driver);
	}
	
	
	public void prouserRejectFeeOffer()
	{
		proUserClaimStatus("Pending-DecideFeesOffer");
		wdUtil.findByClick(locators.get("REVIEW_FEE_PROPOSAL"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("REJECTFEEPROPOSAL"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Go to court over fee offer
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.findByClick(locators.get("CLOSE"));
		
		System.out.println("Prouser Reject Fee proposal and goes to court");
		wdUtil.defaultContent();
		GetDriver.getInstance().setDriver(driver);
	}
	
	
	public void uploadReportwithoutUplift() 
	{
		proUserClaim();
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findBySendKeys(locators.get("MEDCOSEARCHREF"), locators.get("MEDCOSEARCHREF_V"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadFile(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(5000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(5000);
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Summary
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.scrollDown(locators.get("PROCEED"));
		wdUtil.optionButton(locators.get("PROCEED"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.findByClick(locators.get("UPLOAD_MED_REP"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.checkBox(locators.get("MEDCHKBOX"));
		GetDriver.getInstance().setMedrep(true);
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		
		wdUtil.optionButton(locators.get("UPLIFTJUSTIFIED_NO"));	
		
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME2"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		
		
		wdUtil.findByClick(locators.get("CONTINUE"));
		
		wdUtil.findByClick(locators.get("CLAIMANT_CONSENT_NO"));		
		wdUtil.findByClick(locators.get("CONTINUE"));
		//Statement of truth
		wdUtil.findBySendKeys(locators.get("CFNAME"), locators.get("CFNAME_V"));
		wdUtil.findBySendKeys(locators.get("CLNAME"), locators.get("CLNAME_V"));
		wdUtil.findBySendKeys(locators.get("JOBTITLE"), plocators.get("JOBTITLE_V"));
		wdUtil.findByClick(locators.get("ACCEPTANDSEND"));
		wdUtil.AddLog("Prouser uploaded medical report without uplift");
		GetDriver.getInstance().setDriver(driver);
	}

}