package com.cucumbercraft.pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.tools.ant.launch.Locator;
import org.openqa.selenium.By;
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
 * @author Krishna Chaitanya
 * 
 *
 */



public class DMEpage {

	WebDriver driver = GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);
	Map<String, String> locators = GetDriver.getInstance().getDMELocators();

	String claimNumber=GetDriver.getInstance().getOICref();
	
	public void dme()
	{	
		wdUtil.switchToFrame(locators.get("FRAME0"));
		//pagination
		wdUtil.dmePage(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
	//	wdUtil.clickLink(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
	}
	
	
	
	public void dmeUploadMedicalReportWithWaitOutPeriod()
	{ 
		dme();
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.clickLink(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadFile(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(10000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(10000);
		wdUtil.optionButton(locators.get("ADDITIONALREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.selectListItem(locators.get("PROG_PERIOD"), locators.get("PROG_PERIOD_24"));
		wdUtil.optionButton(locators.get("FROM_MED_EXAM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		GetDriver.getInstance().setDriver(driver); 
		}
	
	public void mrpReportUpload()
	{
		dme();
		wdUtil.optionButton(locators.get("AMENDMENTNEEDED"));
		wdUtil.findByClick(locators.get("SUBMIT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.clickLink(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadRevisedMR(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(10000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(10000);
		wdUtil.optionButton(locators.get("ADDITIONALREPORT"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.selectListItem(locators.get("PROG_PERIOD"), locators.get("PROG_PERIOD_24"));
		wdUtil.optionButton(locators.get("FROM_MED_EXAM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("CONFIRM"));
		System.out.println("DME upload second report");
		GetDriver.getInstance().setDriver(driver);
		
	}
	
	public void mrpReportReject()
	{
		dme();
		wdUtil.optionButton(locators.get("AMENDMENTNEEDED_NO"));
		wdUtil.findBySendKeys(locators.get("REPORT_FINAL"), locators.get("REPORT_FINAL_V"));
		wdUtil.findByClick(locators.get("SUBMIT"));
		System.out.println("DME rejects further report request");
		GetDriver.getInstance().setDriver(driver);
	}

	public void dmeUploadMedicalReportWithoutPrognosis() 
	{

		dme();
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.clickLink(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		//upload medical report
		wdUtil.switchToFrame(locators.get("FRAME1"));
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
		System.out.println("dme medical report with no waitout prognosis");
		GetDriver.getInstance().setDriver(driver);		

	}

	public void claimantDidnNotAttendMedicalExam()
	{
		dme();
		wdUtil.optionButton(locators.get("AMENDMENTNEEDED"));
		wdUtil.optionButton(locators.get("REMOVECURRENTREP"));
		wdUtil.findByClick(locators.get("SUBMIT"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.clickLink(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("NOTABLETOUPLOADMR"));
		wdUtil.selectListItem(locators.get("REASONFORNOMR"),locators.get("REASONFORNOMR_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("claimant didnot attend medical exam, route to compensator");
		GetDriver.getInstance().setDriver(driver);		

	}
	
	public void dmeUploadMRwithWOPBeforeProg() 
	{
		dme();
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.clickLink(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
	//	wdUtil.optionButton(locators.get("CONTINUEUPLOADREPORT"));
	//	wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		//upload medical report
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.clickLink(locators.get("UPLOAD_MED_REP_LINK"));
		wdUtil.uploadFile(locators.get("SELECT_FILE_MED"));
		wdUtil.selectListItem(locators.get("CATEGORYPROMED"), locators.get("CATEGORYPROMED_V"));
		wdUtil.findByClick(locators.get("UPLOADREP_BUTTON"));
		wdUtil.waitFor(10000);
		wdUtil.selectListItem(locators.get("MED_EXAM_DATE"), locators.get("MED_EXAM_DATE_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_MONTH"), locators.get("MED_EXAM_MONTH_V"));
		wdUtil.selectListItem(locators.get("MED_EXAM_YEAR"), locators.get("MED_EXAM_YEAR_V"));
		wdUtil.waitFor(15000);
		wdUtil.optionButton(locators.get("ADDITIONALREPORT"));
		wdUtil.selectListItem(locators.get("PROG_PERIOD"), locators.get("PROG_PERIOD_V"));
		wdUtil.scrollDown(locators.get("FROM_MED_EXAM"));
		wdUtil.waitFor(7000);
		wdUtil.optionButton(locators.get("FROM_MED_EXAM"));
		wdUtil.findByClick(locators.get("CONTINUE"));
//		wdUtil.defaultContent();
//		wdUtil.switchToFrame(locators.get("FRAME1"));
//		wdUtil.findByClick(locators.get("VIEW_MORE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
	//	wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("upload medical report with waitout before prognosis");
		GetDriver.getInstance().setDriver(driver);		
		
	}

	public void dmeUnabletoUploadReport()
	{
		dme();
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME0"));
		wdUtil.clickLink(locators.get("REFRESH"));
		wdUtil.clickLink(locators.get("CHK_OIC").replace("$claimNumber", claimNumber));
		wdUtil.defaultContent();
		wdUtil.switchToFrame(locators.get("FRAME1"));
		wdUtil.optionButton(locators.get("NOTABLETOUPLOADMR"));
		wdUtil.selectListItem(locators.get("REASONFORNOMR"), locators.get("REASONFORNOMR_V"));
		wdUtil.findByClick(locators.get("CONTINUE"));
		wdUtil.findByClick(locators.get("FINISH"));
		System.out.println("dme unable to upload report");
		GetDriver.getInstance().setDriver(driver);		
	}

	public void logout()
	{
		wdUtil.defaultContent();
		wdUtil.findByClick(locators.get("LOGOUT"));
	}

}