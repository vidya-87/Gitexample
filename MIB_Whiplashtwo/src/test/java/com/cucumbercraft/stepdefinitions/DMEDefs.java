package com.cucumbercraft.stepdefinitions;



import com.cucumbercraft.pages.DMEpage;
import com.cucumbercraft.pages.MIBLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
public class DMEDefs{
	
	/* DME uploads report No prognosis */
	
	@Given("^claimant selects DME$")
	public void claimant_selects_dme() throws Throwable
	{
		MIBLoginPage.login("dme");
	}
	
	@When("^claimant visits DME and completes checkup$")
	public void claimant_visits_dme_complete_checkup()throws Throwable
	{
		DMEpage dme=new DMEpage();
		dme.dmeUploadMedicalReportWithoutPrognosis();
				
	}
	@Then("^DME uploads report no prognosis$")
	public void dme_upload_report_no_prognosis()throws Throwable
	{
		DMEpage report = new DMEpage();
		report.logout();
		
	}
	
	/*DME uploads report before waitout prognosis*/
	@When("^DME uploads the medical report with waitout period before prognosis$")
	public void upload_report_waitout_period()throws Throwable
	{
		DMEpage waitout=new DMEpage();
		waitout.dmeUploadMedicalReportWithWaitOutPeriod();
	}
	
	/*DME uploads report with waitout prognosis*/
	@Then("DME upload medical report with prognois time")
	public void dme_upload_medical_report_with_prognosis_time()throws Throwable
	{
		DMEpage waitout=new DMEpage();
		waitout.dmeUploadMedicalReportWithWaitOutPeriod();
	}
	
	@Then("^Report is sent to claimant$")
	public void report_is_sent_to_claimant()throws Throwable
	{
		DMEpage report = new DMEpage();
		report.logout();
	}
	
	
	/* Medical provider selects claimant didnot attend the examination */
	@Given("^Claimant did not attend the examination with DME$")
	public void claimant_did_not_attend_examination_with_dme()throws Throwable
	{
		MIBLoginPage.login("dme");
		
	}
	@When("^Medical provider selects claimant didnot attend the examination$")
	public void medical_provides_selects_claimant_didnot_attend_examination()throws Throwable
	{
		DMEpage exam = new DMEpage();
		exam.claimantDidnNotAttendMedicalExam();
	}
	@Then("^claim will be routed to compensator$")
	public void claim_will_routed_to_compensator()throws Throwable
	{

		DMEpage exam = new DMEpage();
		exam.logout();
	}
	
	/* DME selects option unable to upload report */

	@When("^DME selects option unable to upload report$")
	public void dme_selects_unable_to_upload_report()throws Throwable
	{

		DMEpage report = new DMEpage();
		report.dmeUnabletoUploadReport();
	}
	@Then("^compensator gets the option to upload report$")
	public void compensator_gets_option_to_upload_report()throws Throwable
	{

		DMEpage report = new DMEpage();
		report.logout();
	}
	/*DME upload further medical report*/
	@Given("^Claimant requests further medical report after marking factually incorrect$")
	public void claimant_requests_further_medical_report_factually_incorrect()throws Throwable
	{
		MIBLoginPage.login("dme");
	}
	@When("^DME upload further report$")
	public void dme_uploads_further_report()throws Throwable
	{
		DMEpage report = new DMEpage();
		report.mrpReportUpload();
	}
	
	@When("^DME reject further report$")
	public void dme_reject_mrp_report()throws Throwable
	{
		DMEpage report = new DMEpage();
		report.mrpReportReject();
	}
}