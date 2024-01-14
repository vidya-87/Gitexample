package com.cucumbercraft.stepdefinitions;



import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.cucumbercraft.framework.GetDriver;
import com.cucumbercraft.framework.WebDriverUtil;
import com.cucumbercraft.pages.ClaimantActionsPage;
import com.cucumbercraft.pages.CompUserRegLoginPage;
import com.cucumbercraft.pages.CompensatorUserCreationPage;
import com.cucumbercraft.pages.MIBLoginPage;
import com.cucumbercraft.pages.ProUserCreationPage;
import com.cucumbercraft.pages.ProUserRegLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
public class ProUserCreationStepDefs

{
	@Given("^prouser from logins to register with '(.*)' and '(.*)'$")
	public void prouser_from_logins_to_register_with_prouser_pm_mailinator_com_and_Password(String username, String password) throws Throwable
	{
		
		  ProUserRegLoginPage log = new ProUserRegLoginPage();
		  log.proUserlogin(username, password); ProUserCreationPage reg = new  ProUserCreationPage(); 
		  reg.ProUserRegister(); 
		  reg.prouserlogout();
		 
	}

	@When("^resgitration is approved by CSR$")
	public void resgitration_is_approved_by_CSR() throws Throwable
	{
		ProUserRegLoginPage log = new ProUserRegLoginPage();
		log.csrlogin();
		ProUserCreationPage reg = new ProUserCreationPage();
		reg.csrRegApproval();
		reg.csrlogout();
	}

	@Then("^prouser is resgistered successfully with '(.*)' and '(.*)'$")
	public void prouser_is_resgistered_successfully_with_prouser_pm_mailinator_com_and_Password(String username, String password) throws Throwable
	{
		ProUserRegLoginPage log = new ProUserRegLoginPage();
 		log.proUserRelogin(username,password);
 		ProUserCreationPage reg = new ProUserCreationPage();
		reg.signAgreement();
		reg.prouserlogout();
		
	}
	
	 	
}