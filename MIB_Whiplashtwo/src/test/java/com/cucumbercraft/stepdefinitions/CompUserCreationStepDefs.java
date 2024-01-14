package com.cucumbercraft.stepdefinitions;



import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.WebDriverUtil;
import com.cucumbercraft.pages.CompUserRegLoginPage;
import com.cucumbercraft.pages.CompensatorUserCreationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
public class CompUserCreationStepDefs

{
	WebDriver driver = GetDriver.getInstance().getDriver();
	WebDriverUtil wdUtil = new WebDriverUtil(driver);
	/* Register Compensator Users*/

	@Given("^'(.*)' logins to register$")
	public void comp_logins_to_register(String user)throws Throwable
	{
		//CompUserRegLoginPage.login("compensator");
	}
	@Given("^'(.*)' logins to register with '(.*)'$")
	public void comp_logins_to_register_with_username1(String user,String username)throws Throwable
	{
		//CompUserRegLoginPage.login("compensator", username);
	}
	@When("^compensators enter all the required details for registration$")
	public void compensators_enter_all_the_required_details_for_registration()throws Throwable
	{
		
		//CompensatorUserCreationPage reg = new CompensatorUserCreationPage();
		//reg.compUserRegister();
	}
	@Then("^approval for registration is sent to the CSR$")
	public void approval_for_registeration_is_sent_to_csr()throws Throwable
	{
		CompensatorUserCreationPage exit = new CompensatorUserCreationPage();
		exit.complogout();
	}
	
	/* Registeration Allocation and MID ID */	

	  @Given("^the registeration is approved by the '(.*)'$")
	  public void the_registeration_is_approved_by_csr(String user)throws Throwable
	  {
		 // CompUserRegLoginPage.login("CSR");
	  }
	  @When("^the '(.*)' number is assigned to the compensator$")
	  public void mid_id_number_is_assigned_to_the_compensator(String mid)throws Throwable
	  {
		  CompensatorUserCreationPage reg = new CompensatorUserCreationPage();
			reg.csrRegApproval(mid);
	  }
	  @Then("^compensator registration is done successfully$")
	  public void compensator_registration_is_done_successfully()throws Throwable
	  {
		  CompensatorUserCreationPage exit = new CompensatorUserCreationPage();
			exit.csrlogout();
	  }
	  @Given("^'(.*)' was registered successfully$")
	 	public void user_was_registered_successfully(String user)throws Throwable
	 	{
	 		//CompUserRegLoginPage.login("compensator");
	 	}
	 	
		@When("^the compensator logins$")
		public void the_compensator_logins()throws Throwable
		{
			 CompensatorUserCreationPage sign = new CompensatorUserCreationPage();
			 sign.signAgreement();
		}
	 	@Then("^compensator should be able to sign agreement$")
	 	public void compensator_should_be_able_to_sign_agreement()throws Throwable
	 	{
	 		CompensatorUserCreationPage exit = new CompensatorUserCreationPage();
			exit.complogout();
	 	}
	 			
	
	  /*Register multiple compensators*/	
	 	@Given("^compensator from '(.*)' logins to register with '(.*)' and '(.*)'$")
	 	public void compensator_from_Comptwo_logins_to_register_with_Pm_comp_mailinator_com_and_Password(String org, String emailid, String password) throws Throwable
	 	{
	 		CompUserRegLoginPage log = new CompUserRegLoginPage();
	 		log.complogin(emailid,password);
	 		CompensatorUserCreationPage reg = new CompensatorUserCreationPage();
		 reg.compUserRegister(org);
			 reg.complogout();
	 	}

	 	@When("^resgiteration is approved by CSR and valid '(.*)' is assigned to the compensator$")
	 	public void resgiteration_is_approved_by_CSR_and_valid_mid_is_assigned_to_the_compensator(String midid) throws Throwable {
	 		CompUserRegLoginPage log = new CompUserRegLoginPage();
	 		log.csrlogin();
	 		CompensatorUserCreationPage mid= new CompensatorUserCreationPage();
			 mid.csrRegApproval(midid);
			 mid.csrlogout();
	 	}

	 	@Then("^compensator is resgistered successfully with '(.*)' and '(.*)'$")
	 	public void compensator_is_resgistered_successfully(String emailid, String password) throws Throwable {
	 		CompUserRegLoginPage log = new CompUserRegLoginPage();
	 		log.compRelogin(emailid,password);
	 		CompensatorUserCreationPage sign= new CompensatorUserCreationPage();
	 		sign.signAgreement();
	 		sign.complogout();
	 		
	 	}
	 	
}