package com.cucumbercraft.stepdefinitions;



import com.cucumbercraft.pages.SuperUserLoginPage;
import com.cucumbercraft.pages.CsrPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
public class CSRStepDefs{
	
	
	/* CSR route claims to compensator */
	
	 @Given("^Claim received by csr and eligible for assigning to compensator$")
	  public void claim_received_by_csr() throws Throwable
	  {
		 //Thread.sleep(5000);
		 SuperUserLoginPage.mibProLogin();
	  }
	@When("^CSR assigns to another compensator$")
	public void csr_assign_to_compensator() throws Throwable
	{
		CsrPage csr = new CsrPage();
		csr.switchInteractionPortal();
		csr.routeToCompensator();
	}
	
	@When("^CSR assigns compensator$")
	public void csr_assigns_compensator() throws Throwable
	{
		CsrPage csr = new CsrPage();
		csr.switchInteractionPortal();
		csr.routeToCompensator();
	}

	/* CSR assigns compensator to upload medical report */
	@When("^CSR assigns compensator to upload medical report$")
	public void csr_assigns_comp_upload_medical_report()throws Throwable
	{
		CsrPage csr = new CsrPage();
		csr.switchInteractionPortal();
		csr.routeToCompensatorToUploadMedicalReport();
	}
	@Then("^Claim is sent to respective compensator$")
	public void claim_sent_to_compensator()throws Throwable
	{
		CsrPage csr = new CsrPage();
		csr.logout();
	}
	
}