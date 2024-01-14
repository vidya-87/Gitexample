package com.cucumbercraft.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cucumbercraft.framework.DriverManager;
import com.cucumbercraft.framework.Util;

import cucumber.api.java.en.Given;

public class GeneralStepDefs extends MasterStepDefs {
	
	static Logger log = Logger.getLogger(GeneralStepDefs.class);

	WebDriver driver = DriverManager.getWebDriver();

	@Given("^I am in the login page of the application$")
	public void i_am_in_login_page() {
		driver.get(properties.getProperty("ApplicationUrl"));
		
	assertTrue(driver.getTitle().contains("Pega Platform") ||
						driver.getTitle().contains("Sign-on"));
	}

	@Given("^I am in the login page of the Pega Platform application$")
	public void i_am_in_login_page_pega_platform_application() {
		driver.get(properties.getProperty("PegaPlatformApplicationUrl"));
        driver.manage().window().maximize();
		currentScenario.embed(Util.takeScreenshot(driver), "image/png");

		assertTrue(driver.getTitle().contains("Pega Platform") ||
				driver.getTitle().contains("Sign-on"));
	}


	@Given("^I am in the login page of the Mib claim service$")
	public void i_am_in_the_login_page_of_the_Mib_claim_service() throws Throwable {
		driver.get(properties.getProperty("MibClaimsServiceUrl"));
		driver.manage().window().maximize();
		currentScenario.embed(Util.takeScreenshot(driver), "image/png");

		assertTrue(driver.getTitle().contains("MIB Claims Service - Sign In"));

	}


	@Given("^I am in the login page of the Mib Manager Portal$")
	public void i_am_in_the_login_page_of_the_Mib_Manager_Portal() throws Throwable {
		driver.get(properties.getProperty("MTManagerUrl"));
		driver.manage().window().maximize();
		currentScenario.embed(Util.takeScreenshot(driver), "image/png");

		assertTrue(driver.getTitle().contains("Pega Platform") ||
				driver.getTitle().contains("Sign-on"));

	}



}