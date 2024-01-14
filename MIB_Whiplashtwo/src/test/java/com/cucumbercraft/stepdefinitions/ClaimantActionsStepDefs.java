package com.cucumbercraft.stepdefinitions;

import com.cucumbercraft.pages.ClaimantActionsPage;
import com.cucumbercraft.pages.CompensatorDecisionPage;
import com.cucumbercraft.pages.CsrPage;
import com.cucumbercraft.pages.MIBLoginPage;
import com.cucumbercraft.pages.MIBProActionsPage;
import com.cucumbercraft.pages.ProUserActionsPage;
import com.cucumbercraft.pages.SuperUserLoginPage;
import com.cucumbercraft.pages.TPApage;
import com.cucumbercraft.pages.UnrepClaimCreationPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
public class ClaimantActionsStepDefs{

	
/* Unrep Claim Creation */
	
	@Given("^unrep logins into whiplash application$")
    public void user_logins_into_whiplash_applicataion_using() throws Throwable {
		MIBLoginPage.login("unrep");
		
	}      
	@When("^user enter all mandatory details for claim creation as '(.*)' , '(.*)' and '(.*)' with '(.*)','(.*)'$")
	public void user_Enter_All_Mandatory_Details_For_Claim_Creation (String owner,String involvement_type_v, String ct_preference, String multivrn, String location) throws Throwable {
		UnrepClaimCreationPage claim = new UnrepClaimCreationPage();
		claim.ClaimCreation(owner,involvement_type_v, ct_preference,multivrn,location);
	}
	
	@Then("^claim reference number for unrep claim is created$")
	public void claim_Reference_Number_Unrep_Is_Created_Successfully() throws Throwable {
		UnrepClaimCreationPage logout = new UnrepClaimCreationPage();
		logout.endOfSubmitClaim();
		 ClaimantActionsPage exit = new ClaimantActionsPage();
		 exit.logout();
		 }
	@And("^claimant exits before submitting the claim$")
	public void claimant_exit_before_submitting_claim()throws Throwable
	{
		UnrepClaimCreationPage logout = new UnrepClaimCreationPage();
		logout.newClaim();
		logout.exitBeforeSubmit();
	}
	
	@When("^user continues for claim creation as '(.*)' , '(.*)' and '(.*)' with '(.*)','(.*)'$")
	public void user_continues_For_Claim_Creation (String owner,String involvement_type_v, String ct_preference, String multivrn, String location) throws Throwable {
		UnrepClaimCreationPage claim = new UnrepClaimCreationPage();
		claim.continueClaim(owner,involvement_type_v, ct_preference,multivrn,location);
	}
	

	/* Claimant accepts Denial & case resolved */

	@Given("^TPA denied claim liability to '(.*)'$")
	public void tpa_Denied_Claim_Liability(String claimant) throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");
			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;	
		}
	}
	@When("^unrep accepts denial$")
	public void unrep_accepts_denial() throws Throwable
	{
		ClaimantActionsPage user = new ClaimantActionsPage();
		user.unrepAcceptDecision();
	}
	@Then("^claim will be resolved$")
	public void claim_resolved()throws Throwable
	{
		/*
		 * ClaimantActionsPage user = new ClaimantActionsPage();
		 * user.unrepAcceptFinalOfferAndFee();
		 */
		ClaimantActionsPage user = new ClaimantActionsPage();
		user.logout();
	}
	
	/*Claimant accepts replacement offer from TPA*/
	@Given("^TPA has given replacement offer$")
	public void tpa_has_given_replacement_offer()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^Claimant accept the replacement offer$")
	public void claimant_accepts_the_final_offer()throws Throwable
	{
		ClaimantActionsPage user = new ClaimantActionsPage();
		user.unrepAcceptOfferAndFee();
	}
	
	@Then("^claim is resolved$")
	public void claim_is_resolved()throws Throwable
	{
		ClaimantActionsPage exit = new ClaimantActionsPage();
		exit.logout();
	}
	
	/* prouser remove fee */
	 @Given("^claimant accepts the offer from compensator$")
	 public void claimant_accepts_offer_from_compensator()throws Throwable
	 {
		 MIBLoginPage.login("prouser");
	 }
	 @When("^claimant removes fee$")
	 public void claimant_removes_fees()throws Throwable
	 {
		 ClaimantActionsPage fee = new ClaimantActionsPage();
		 fee.removeFee();
	 }
	 @Then("^claimant review fee proposal from compensator$")
	 public void claimant_review_fee_proposal_from_compensator()throws Throwable
	 {
		 ClaimantActionsPage user = new ClaimantActionsPage();
			user.logout();
	 }
	 
	 /*unrep remove fee*/
	 
	 @Given("^unrep decides to remove loss$")
	 public void unrep_decides_to_remove_fee()throws Throwable
	 {
		 MIBLoginPage.login("unrep");
	 }
	 @When("^unrep removes the loss$")
	 public void unrep_removes_the_fees()throws Throwable
	 {
		 ClaimantActionsPage loss = new ClaimantActionsPage();
			loss.unrepRemoveLoss();
	 }
	 @Then("^the loss should be removed successfully$")
	 public void fee_should_be_removed_successfully()throws Throwable
	 {
		 ClaimantActionsPage user = new ClaimantActionsPage();
			user.logout();
	 }

	/* Claimant Upload medical report with no upift */

	@Given("^'(.*)' receives claim$")
	public void user_Receives_Claim(String claimant) throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");
			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}
		

	}
	
	
	@When("^'(.*)' uploads own medical report$")
	public void claimant_uploads_own_medical_report(String claimant)throws Throwable
	{
		if(claimant.equalsIgnoreCase("mibpro"))
		{
			MIBProActionsPage mr= new MIBProActionsPage();
			mr.mibproUploadOwnReportWithoutPrognosis("Pending-MedCausation");
		}
		else
		{
			ClaimantActionsPage mr = new ClaimantActionsPage();
			mr.unrepUploadOwnReportWithoutPrognosis();
		}
	}
	@When("^unrep uploades further medical report$")
	public void unrep_upload_further_medical_report()throws Throwable
	{
		ClaimantActionsPage mr = new ClaimantActionsPage();
		mr.unrepUploadRevisedMR();
		
	}
	
	
	@When("claimant decides to obtain further report")
	public void claimant_decides_to_obtain_further_report()throws Throwable
	{
		ClaimantActionsPage mr = new ClaimantActionsPage();
		mr.unrepObtainAndUploadFurtherMedReport();
	}
	@Then("^claimant uploads further medical report uploaded successfully$")
	public void medical_further_report_uploaded_successfully()throws Throwable
	{
		MIBProActionsPage mr= new MIBProActionsPage();
		mr.logout();
	}
	@Then("^medical report is uploaded successfully$")
	public void medical_report_uploaded_successfully()throws Throwable
	{
		MIBProActionsPage mr= new MIBProActionsPage();
		mr.logout();
	}

	
	
	
	
	  		

	/*Claimant uploads medical report and requests uplift*/

	@Given("^upload medical report is enabled for '(.*)'$")
	public void claimant_option_upload_medical_report(String claimant) throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");
			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;	
		}

	}
	


	@Then("^medical report is uploaded and offer request is sent to compensator$")
	public void uploaded_report_uplift_request_to_compensator()throws Throwable
	{
		ClaimantActionsPage report = new ClaimantActionsPage(); 
		report.logout();	
	}

	/* Claimant withdraws claim*/

	@Given("^'(.*)' has uploaded medical report$")
	public void claimant_has_uploaded_medical_report(String claimant) throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");
			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;	
		}
	}

	@Given("^the first offer sent to claimant$")
	public void first_offer_sent_to_claimant() throws Throwable
	{
		MIBLoginPage.login("unrep");	  
	}

	@When("^the unrep claimant then decides to withdraw the claim at '(.*)'$")
	public void unrep_claimant_withdraw_claim(String status)throws Throwable
	{
		ClaimantActionsPage withdraw = new ClaimantActionsPage();
		withdraw.unrepWithdrawClaim(status);
	}
	
	
	@Then("^the claimant has withdrawn claim and Compensator to acknowledge this$")
	public void  claimant_withdrawn_claim_compensator_acknowledge()throws Throwable
	{
		ClaimantActionsPage withdraw = new ClaimantActionsPage();
		withdraw.logout();
	}

	/*Claimant Request Interim Payment and submit uplift*/

	@Given("^claim has been accepted for '(.*)'$")
	public void claim_has_been_accepted(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "unrep":
			MIBLoginPage.login("unrep");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}
	}
	@When("^'(.*)' requests interim payment$")
	public void claimant_first_interim_payment(String claimant)throws Throwable
	{

		switch(claimant)
		{
		case "prouser":
			ProUserActionsPage pro = new ProUserActionsPage();
			pro.reqInterimPayment();
			break;

		case "unrep":
			ClaimantActionsPage unrep = new ClaimantActionsPage();
			unrep.unrepReqInterimPayment();
			break;
		case "mibpro":
			MIBProActionsPage mib = new MIBProActionsPage();
			mib.mibproReqInterimPayment();
			break;
		}


	}
	@When("^'(.*)' reviews the interim payment and requests another interim payment$")
	public void review_request_another_payment(String claimant) throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			ClaimantActionsPage interim = new ClaimantActionsPage();
			interim.unrepReviewInterimPayment(); 
			interim.unrepReqInterimPayment();	
			break;
		case "prouser":
			ProUserActionsPage prointerim = new ProUserActionsPage();
			prointerim.prouserReviewInterimPayment();
			prointerim.reqInterimPayment();
			break;
		case "mibpro":
			MIBProActionsPage mibprointerim = new MIBProActionsPage();
			mibprointerim.mibproReviewAndRequestInterimPayment();
			break;
		}


	}
	@When("^'(.*)' reviews and accept interim decision$")
	public void claimant_reviews_accept_interim_decision(String claimant)throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			ClaimantActionsPage accept = new ClaimantActionsPage();
			accept.unrepReviewInterimPayment();	
			break;
		case "prouser":
			
			ProUserActionsPage interim = new ProUserActionsPage();
			interim.prouserReviewInterimPayment();	
			break;
		case "mibpro":
			MIBProActionsPage mibprointerim = new MIBProActionsPage();
			mibprointerim.mibproReviewInterimPayment();
			break;
		}

	}
	@Then("^payment is not received by the claimant")
	public void payment_not_received_the_claimant()throws Throwable
	{
		ClaimantActionsPage interim = new ClaimantActionsPage();
		interim.slaBreached();
	}
	@Then("^claimant accepts interim decision$")
	public void claimant_accepts_interim_decision()throws Throwable
	{
		ClaimantActionsPage interim = new ClaimantActionsPage();
		interim.logout();
	}
	@And("^submit UPLIFT due to EXCEPTIONAL CIRCUMSTANCES$")
	public void submit_uplift_during_interim()throws Throwable
	{
		ClaimantActionsPage uplift = new ClaimantActionsPage();
		uplift.upliftSubmit();
	}
	@Then("^interim payment request is sent to compensator$")
	public void interim_payment_request_compensator() throws Throwable
	{
		ClaimantActionsPage interim = new ClaimantActionsPage();
		interim.logout();
	}

	/*Claimant Reject First Offer back to compensator/TPA*/

	@Given("^'(.*)' receives the offer$")
	public void receives_first_offer(String username) throws Throwable
	{
		switch (username)
		{
		case "unrep":
			MIBLoginPage.login("unrep");

			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}


	}
	@When("^'(.*)' reject the offer$")
	public void reject_first_offer(String claimant) throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			ClaimantActionsPage offerwithouttariff = new ClaimantActionsPage();
			offerwithouttariff.unrepRejectFirstOfferTariff("Tariff_No");
			break;
		case "prouser":
			ProUserActionsPage prooffer = new ProUserActionsPage();
			prooffer.rejectFirstOffer();
			break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			mibpro.mibproRejectoffer();
			break;
		}
	}
		
		@When("^'(.*)' reject the offer with uplift$")
		public void reject_first_offer_with_uplift(String claimant) throws Throwable
		{
			switch (claimant)
			{
			case "unrep":
				ClaimantActionsPage offer = new ClaimantActionsPage();
				offer.unrepRejectFirstOfferWithUplift();
				break;
			case "prouser":
				ClaimantActionsPage prooffer = new ClaimantActionsPage();
			//	prooffer.rejectFirstOffer();
				break;
			case "mibpro":
				MIBProActionsPage mibpro = new MIBProActionsPage();
				mibpro.mibproRejectOfferWithUplift();
				break;
			}
		

	}

	/*Claimant reject new offer from compensator*/

	@Given("^'(.*)' receives new offer$")
	public void receives_new_offer(String username) throws Throwable
	{
		switch (username)
		{
		case "unrep":
			MIBLoginPage.login("unrep");

			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}


	}
	@When("^'(.*)' accept the offer$")
	public void reject_new_offer(String claimant) throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			ClaimantActionsPage offer = new ClaimantActionsPage();
			//offer
			break;
		case "prouser":
			ClaimantActionsPage prooffer = new ClaimantActionsPage();
			prooffer.prouserAcceptOffer();
			break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			//mibpro.mibproRejectoffer();
			break;
		}

	}
	@Then("^counter offer is sent for revision$")
	public void counter_offer_sent_for_revision()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.logout();
	}
	@Then("^first offer is sent for revision$")
	public void offer_sent_to_revision_to_compensator() throws Throwable
	{
		TPApage sla = new TPApage();
		sla.slaBreached();
	}
	
	@Then("^claimant offer is sent for revision$")
	public void claimant_offer_sent_to_revision_to_compensator() throws Throwable
	{
		TPApage sla = new TPApage();
		sla.slaBreached();
	}
	
	@Then("^claim is reject to claimant$")
	public void claim_is_rejected_to_claimant() throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.logout();
	}
	
	


	/*Claimant Accepts revised offer from compensator*/


	@Given("^'(.*)' receives the revised offer$")
	public void claimant_receives_revised_offer_from_compensator(String claimant)throws Throwable
	{
		switch(claimant)
		{
			case "unrep":
				MIBLoginPage.login("unrep");
				break;
			case "prouser":
				MIBLoginPage.login("prouser");
				break;
			case "mibpro":
				SuperUserLoginPage.mibProLogin();
				break;
		}

	}
	@When("^'(.*)' accepts revised offer$")
	public void claimant_accepts_revised_fee_offer(String claimant)throws Throwable
	{
		switch(claimant)
		{
			case "unrep":
				ClaimantActionsPage accept = new ClaimantActionsPage();
				accept.unrepAcceptOfferAndFee();
				break;
			case "prouser":
				ProUserActionsPage fee = new ProUserActionsPage();
				fee.acceptRevisedFeeOffer();
				break;
			case "mibpro":
				MIBProActionsPage fees = new MIBProActionsPage();
				fees.mibproAcceptOfferAndFee();
				
		}
	}


	@Then("^revised offer acceptance is sent$")
	public void revised_offer_acceptance_sent_to_compensator()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.logout();
	}
	
	/* offer is sent to compensator and acceptance SLA is breached*/
	@Then("^counter offer is sent for revision and SLA is breached$")
	public void counter_offer_is_sent_for_revision_sla_breached()throws Throwable
	{
	TPApage sla = new TPApage();
	sla.slaBreached();
	}

	/* Claimant accepts offer from compensator */
	@Given("^Claimant received offer details$")
	public void claimant_received_offer_details()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	
	@When("^Claimant accepts offer$")
	public void claimant_accepts_offer()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.unrepAcceptOfferAndFee();
	}
	
	@When("^Prousuer accepts offer$")
	public void prouser_accepts_offer()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.prouserAcceptOfferAndFee();
	}
	@Then("^Acknowledgement will be sent to compensator$")
	public void ack_sent_to_compensator()throws Throwable
	{
		TPApage sla = new TPApage();
		sla.slaBreached();
	}
	@Then("^Acknowledgement for offer acceptance will be sent to compensator$")
	public void acknowledgement_for_offer_acceptance_will_be_sent_to_compensator()throws Throwable
	{
		ClaimantActionsPage offeraccepted = new ClaimantActionsPage();
		offeraccepted.logout();
	}
	/* Compensator breaches SLA&Claim goes to court */ 
	@Given("^claimant accepted offer and acknowledgement sent to compensator$")
	public void claimant_accepted_offer_and_ack_sent_to_compensator()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^Compensator breaches SLA$")
	public void compensator_breaches_sla()throws Throwable
	{
		ClaimantActionsPage sla = new ClaimantActionsPage();
		sla.gotocourtOption();
	}
	@Then("^Claim goes to court$")
	public void claim_goes_to_court() throws Throwable
	{
		ClaimantActionsPage sla = new ClaimantActionsPage();
		sla.logout();
	}

	/* Claimant update loss and uploads supporting docs */  

	@Given("^claim liability is accepted$")
	public void claim_liability_accepted()throws Throwable
	{
		MIBLoginPage.login("prouser");
	}
	@When("^claimant update the losses from Loss Tile and upload documents$")
	public void add_loss_upload_document() throws Throwable
	{
		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.addLoss();
		loss.addDocument();

	}
	
	/*Claimant adds new loss/fee*/
	
	@When("^'(.*)' add losses and fee$")
	public void claimants_add_losses_fee(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			ClaimantActionsPage unrep = new ClaimantActionsPage();
			unrep.unrepAddLossAndFee();
			break;
			
		case "prouser":
			ClaimantActionsPage loss = new ClaimantActionsPage();
			loss.addLossAndFee();
			break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			mibpro.addLossAndFeeFromTile();
			break;
		}
		
	}
	
	@When("^'(.*)' adds fee$")
	public void claimants_add_fee(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			ClaimantActionsPage unrep = new ClaimantActionsPage();
			unrep.unrepAddFee();
			break;
			
		case "prouser":
			ProUserActionsPage loss = new ProUserActionsPage();
			loss.prouserAddFee();
			break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			mibpro.mibproAddFee();
			break;
		}
		
	}
	
	

	/*claimant adds loss and proceed with offer*/
	@When("^claimant update the losses from Loss Tile and proceeds with offer$")
	public void mibpro_add_loss_upload_proceed_with_offer() throws Throwable
	{
		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.unrepAddLossAndProceedToOffer();

	}
	/*Claimant proceed with offer after waitout*/
	@When("^claimant proceeds with offer$")
	public void proceed_with_offer() throws Throwable
	{
		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.unrepReviewReportAndProceedWithOffer();

	}
	@Given("^claimant uploads further medical report$")
	public void claimant_uploads_further_medical_report()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^claimant proceeds to offer$")
	public void claimant_proceeds_with_offer()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.unrepProceedWithOffer();
	}
	
	@When("^unrep proceeds to offer$")
	public void unrep_proceeds_to_offer()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.unrepProceedOffer();
	}
	@Then("offer request is sent to compensator")
	public void offer_request_is_sent_to_compensator()throws Throwable
	{
		ClaimantActionsPage exit = new ClaimantActionsPage();
		exit.logout();
	}
	
	@When("^claimant proceeds with offer after uploading new report$")
	public void proceed_with_offer_after_uploading_new_report() throws Throwable
	{
		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.unrepProceedAfterNewReport();

	}

	@And("^unrep claimant proceeds with offer$")
	public void unrep_proceed_with_offer() throws Throwable
	{
		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.unrepProceedToOffer();

	}

	@Then("^claim will proceed to upload medical reports$")
	public void proceed_to_upload_medical_reports()throws Throwable
	{
		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.logout();
	}



	@Given("^Claimant waitout Prognosis period is completed$")
	public void claimant_waitout_prognosis_period_is_completed()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@Then("^claim will be sent to compensator to review the losses added$")
	public void claim_will_be_sent_to_compensator_to_review_lossed_added()throws Throwable
	{
		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.logout();
	}

	/* Claimant rejects offer and decides to go to court */ 

	@Given("^Second offer without UPLIFT  received by '(.*)'$")
	public void second_offer_without_uplift(String username)throws Throwable
	{
		if(username.equalsIgnoreCase("prouser"))
		{
			MIBLoginPage.login("prouser");
		}
		else
		{
			MIBLoginPage.login("unrep");
		}

	}
	@When("^'(.*)' decides to go to court after rejecting offer$")
	public void claimant_decides_to_go_to_court(String claimant)throws Throwable
	{
		if(claimant.equalsIgnoreCase("prouser"))
		{
			ProUserActionsPage court = new ProUserActionsPage();
			court.rejectOfferGoesToCourt();
		}
		else
		{
			ClaimantActionsPage court = new ClaimantActionsPage();
			court.unrepRejectOfferGoToCourt();
		}
	}
	@Then("^Claimant selection to go to court is confirmed$")
	public void go_to_court_confirmed()throws Throwable
	{
		ClaimantActionsPage court = new ClaimantActionsPage();
		court.logout(); 
	}

	/* Claimant(prouser) answer NVC questions */
	@Given("^'(.*)' decided to go to court$")
	public void claimant_go_to_court(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");
			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;		
			
		}
	}
	@When("^'(.*)' answers NVC questions$")
	public void claimant_answers_nvc_questions(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			ClaimantActionsPage nvc = new ClaimantActionsPage();
			nvc.unrepAnswerNVC();
			break;
		case "prouser":
			ProUserActionsPage nvc1 = new ProUserActionsPage();
			nvc1.answerNVC();
			break;
		case "mibpro":
			MIBProActionsPage nvc2 = new MIBProActionsPage();
			nvc2.mibproAnswerNVC();
			break;		
			
		}

	}
	@Then("^claim should be sent to TPA$")
	public void claim_sent_to_tpa()throws Throwable
	{
		ClaimantActionsPage nvc = new ClaimantActionsPage();
		nvc.logout(); 
	}
	/*Claimant reject offer, goes to court and answers NVC*/
	@When("^'(.*)' reject offer and answers NVC$")
	public void cliamant_reject_offer_and_answers_nvc(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			ClaimantActionsPage nvc = new ClaimantActionsPage();
			nvc.unrepRejectOfferCourtNVC();
			break;
		case "mibpro":
			MIBProActionsPage mnvc = new MIBProActionsPage();
			mnvc.mibproRejectOfferCourtNVC();
			break;
		}
	}
	
	/*Claimant go to court for final withdrawn offer*/
	@When("^'(.*)' goes to court for final offer$")
	public void claimant_goes_to_coutr_for_final_offer(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			ClaimantActionsPage nvc = new ClaimantActionsPage();
			nvc.unrepgoToCourtFinalOffer();
			break;
		case "prouser":
			ProUserActionsPage court = new ProUserActionsPage();
			court.gotoCourtFinalOffer();
			break;
		case "mibpro":
			MIBProActionsPage nvcourt = new MIBProActionsPage();
			nvcourt.mibproGotoCourtFinalOffer();
		}
	}

	@When("^Claimant reject offer and goes to court and answers NVC$")
	public void claimant_reject_offer_go_to_court_nvc()throws Throwable
	{
		ClaimantActionsPage nvc = new ClaimantActionsPage();
		nvc.unrepRejectOfferCounterOfferCourtNVC();
	}
	/* Claimant selects documents for court */     
	@Given("^TPA responds NVC answers to '(.*)'$")
	public void tpa_responds_nvc_answers(String username)throws Throwable
	{
		if(username.equalsIgnoreCase("prouser"))
		{
			MIBLoginPage.login("prouser");
		}
		else
		{
			MIBLoginPage.login("unrep");
		}

	}
	@Given("^Compensator responds NVC answers to '(.*)'$")
	public void compensator_responds_nvc_answers(String claimant)throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");

			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}

	}
	@Given("^claimant rejects fee proposal$")
	public void claimant_rejects_fee_proposal()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^'(.*)' selects documents for court$")
	public void claimant_upload_court_document(String claimant)throws Throwable
	{
		if(claimant.equalsIgnoreCase("prouser"))
		{
			/*
			 * ClaimantActionsPage uploaddoc = new ClaimantActionsPage();
			 * uploaddoc.selectCourtDoc();
			 */
		}
		else
		{
			ClaimantActionsPage uploaddoc = new ClaimantActionsPage();
			uploaddoc.unrepSelectCourtDocs();
		}
	}
	
	@When("^'(.*)' selects documents for court after NVC$")
	public void claimant_upload_court_document_after_nvc(String claimant)throws Throwable
	{
		switch(claimant)
		{
			case "prouser":
				ProUserActionsPage uploaddoc = new ProUserActionsPage();
				uploaddoc.prouserSelectCourtDocs();
				break;
			case "unrep":
				ClaimantActionsPage upload = new ClaimantActionsPage();
				upload.unrepSelectCourtDocsNVC();
				break;
			case "mibpro":
				MIBProActionsPage nvc = new MIBProActionsPage();
				nvc.mibproSelectCourtDocsNVC();
				break;
		}
	}
	
	@Then("^documents should be reviewed by TPA$")
	public void document_sent_to_tpa_review()throws Throwable
	{
		ClaimantActionsPage uploaddoc = new ClaimantActionsPage();
		uploaddoc.logout(); 
	}
	@Then("^documents should be reviewed by Compensator$")
	public void document_sent_to_compensator_review()throws Throwable
	{
		ClaimantActionsPage uploaddoc = new ClaimantActionsPage();
		uploaddoc.logout(); 
	}

	/*Claimant checks the documents selected by TPA/Compensator and submit the claim for court*/ 
	@Given("^'(.*)' checks the documents uploaded by Compensator$")
	public void claimant_verifies_documents_from_compensator(String claimant)throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");

			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}

	}
	@Given("^'(.*)' checks the documents uploaded by TPA$")
	public void claimant_verifies_documents_from_tpa(String claimant)throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");

			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}

	}

	@When("^'(.*)' submit the claim for court and select witness$")
	public void claimant_submit_claim_to_court_add_witness(String claimant)throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			ClaimantActionsPage closed = new ClaimantActionsPage();
			closed.unrepAckCourtDocswithWitness();
			break;
		case "prouser":
			ClaimantActionsPage proclosed = new ClaimantActionsPage();
			//proclosed.prouserAckCourtDocs();
			break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			mibpro.mibproAckCourtDocswithWitness();
			break;
		}

	}
	
	@When("^claimant submits the court documents for liability$")
	public void claimant_submits_court_documents_for_liability()throws Throwable
	{
		ClaimantActionsPage closed = new ClaimantActionsPage();
		closed.unrepAckCourtDocsLiability();
	}
	
	
	@When("^'(.*)' submit the claim for court for NVC$")
	public void claimant_submit_claim_to_court_for_NVC(String claimant)throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			ClaimantActionsPage closed = new ClaimantActionsPage();
			closed.unrepAckCourtDocNVC();
			break;
		case "prouser":
			ClaimantActionsPage proclosed = new ClaimantActionsPage();
			//proclosed.prouserAckCourtDocs();
			break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			//mibpro.mibprouserDocumentAcknowledgemt();
			break;
		}

	}
	
	@When("^'(.*)' submit the claim for court with claim '(.*)'$")
	public void claimant_submit_claim_to_court(String claimant, String status)throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			ClaimantActionsPage closed = new ClaimantActionsPage();
			closed.unrepDisputeAckCourtDocsClaim(status);
			break;
		case "prouser":
			ProUserActionsPage proclosed = new ProUserActionsPage();
			proclosed.prouserDisputeAckCourtDocsClaim(status);
			break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			mibpro.mibprouserDisputeAckCourtDocsClaim(status);
			break;
		}

	}
	@When("^'(.*)' submit the claim for court with claim '(.*)' for fee dispute$")
	public void claimant_submit_claim_to_court_fee_dispute(String claimant, String status)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			ClaimantActionsPage closed = new ClaimantActionsPage();
			closed.unrepDisputeFeeCourt(status);
		break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			mibpro.mibproDisputeFeeCourt(status);
		case "prouser":
			ProUserActionsPage fee = new ProUserActionsPage();
			fee.prouserDisputeFeeCourt(status);
		break;
		
		}
	}
	  
	
	@When("^'(.*)' submit the documents for court for interim$")
	public void claimant_submit_document_for_interim(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			ClaimantActionsPage court = new ClaimantActionsPage();
			court.unrepAcknCourtDocsInterim();
			break;
		case "prouser":
			ClaimantActionsPage proclosed = new ClaimantActionsPage();
			break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			mibpro.mibproAckDocsInterim();
			break;
		}
	}

	@Then("^first interim is closed at court stage$")
	public void first_interim_closed_at_court_stage()throws Throwable
	{
		ClaimantActionsPage closed = new ClaimantActionsPage();
		closed.logout();
	}

	@Then("^Case is closed with Go to court at offer stage$")
	public void go_to_court_claim_closed()throws Throwable
	{
		ClaimantActionsPage closed = new ClaimantActionsPage();
		closed.logout();
	}
	@Then("^Interim Case is closed with Go to court and main claim proceeds to offer stage$")
	public void interim_go_to_court_claim_closed_main_claim_first_offer()throws Throwable
	{
		ClaimantActionsPage closed = new ClaimantActionsPage();
		closed.logout();
	}

	/*
	 * Claimant (unrep) makes medical provider selection (DME) and adds losses and documents
	 */
	@Given("^the unrep claim moves to full liability due to SLA breach$")
	public void claim_full_liability_sla_breach()throws Throwable
	{
		MIBLoginPage.login("unrep");

	}
	@Given("^the unrep claim moves to full liability$")
	public void claim_full_liability()throws Throwable
	{
		MIBLoginPage.login("unrep");

	}
	@Given("^the unrep claim moves to partial liability$")
	public void claim_partial_liability()throws Throwable
	{
		MIBLoginPage.login("unrep");

	}
	@When("^unrep selects medical preferences for an DME$")
	public void unrep_medical_preference_dme()throws Throwable
	{
		ClaimantActionsPage unrep = new ClaimantActionsPage();
		unrep.unrepChooseDME("Pending-Medical");
	}
	@When("^unrep chooses DME after reopening claim$")
	public void unrep_choose_dme_after_reopeing_claim()throws Throwable
	{
		ClaimantActionsPage unrep = new ClaimantActionsPage();
		unrep.unrepChooseDME("Pending-MedicalAfterCourt");
	}
	
	@When("^unrep selects medical preferences$")
	public void unrep_selects_dme()throws Throwable
	{
		ClaimantActionsPage unrep = new ClaimantActionsPage();
		unrep.unrepChooseDME("Pending-MedicalPartLiable");
	}
	@When("^Claimant makes medical provider selection '(.*)'$")
	public void claimant_makes_medical_provider_selection(String status)throws Throwable
	{
		ClaimantActionsPage unrep = new ClaimantActionsPage();
		unrep.unrepChooseDME(status);
	}
	@And("^Claimant Adds losses from losses tile$")
	public void unrep_add_loss_tile() 
	{
		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.unrepAddLoss();

	}
	@And("^Claimant Adds fee from losses tile$")
	public void unrep_add_fee_loss_tile() 
	{
		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.unrepAddFee();
	}
	@And("^Claimant uploads document from Doc tile$")
	public void unrep_upload_document_from_doc_tile()
	{
		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.unrepAddDocument();
	}
	@Then("^medical preferences are sent to Independent Expert$")
	public void medical_preferences_sent_experts()throws Throwable
	{
		ClaimantActionsPage closed = new ClaimantActionsPage();
		closed.logout();

	}
	
	/* Claimant decides to reopen the claim */
	 @Given("^Court has resolved the claim$")
	 public void court_has_resolved_the_claim()throws Throwable
	 {
		 MIBLoginPage.login("unrep");
	 }
	 @When("^Claimant reopens liability disputed claim$")
	 public void claimant_reopens_liability_disputed_claim()throws Throwable
	 {
		 ClaimantActionsPage reopen = new ClaimantActionsPage();
		 reopen.unrepReopenClaimLiability();
	 }
	 @Then("^unrep reopens the claims sucessfully$")
	 public void unrep_choose_the_dme_to_upload_medical_report()throws Throwable
	 {
		 ClaimantActionsPage unrep = new ClaimantActionsPage();
		 	unrep.unrepChooseDME("Pending-MedicalAfterCourt");
			unrep.logout();
	 }

	
	 /* prouser challenge liability decision */
		@Given("^claim liability has been partially disputed$")
		public void claim_liability_accepted_by_compensator()throws Throwable
		{
			MIBLoginPage.login("prouser");
		}
		@Given("^Updated Liability information received from TPA$")
		public void updated_liability_information_received_from_tpa() throws Throwable
		{
			MIBLoginPage.login("prouser");
		}
		@When("^prouser challenges Liability$")
		public void prouser_challenges_liability()throws Throwable
		{
			ClaimantActionsPage liability = new ClaimantActionsPage();

			liability.prouserChallengeLiabilityDecision();

		}
		@When("^prouser review challenge Liability$")
		public void prouser_review_challenge_liability()throws Throwable
		{
			ClaimantActionsPage liability = new ClaimantActionsPage();
			liability.prouserReviewChallengeLiabilityDecision();
		}
		@Then("^claim will be sent to TPA to update liability$")
		public void claim_will_be_sent_to_tpa_update_liability()throws Throwable
		{
			ClaimantActionsPage liability = new ClaimantActionsPage();
			liability.logout();
		}
		

	/* Unrep reviews and request for UPLIFT */
	@Given("^claimant reviews medical report when uploaded by DME$")
	public void review_medical_report_uploaded_by_dme()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^Claimant requests an UPLIFT due to EXCEPTIONAL CIRCUMSTANCES$")
	public void unrep_request_uplift()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.unrepReviewReportAndProceedWithOfferUplift();
	}
	
	@When("^Claimant reviews report and proceed to offer$")
	public void claimant_review_report_and_proceed_to_offer()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.unrepReviewReportAndProceedWithOffer();
	}
	@When("^Claimant proceeds to offer$")
	public void claimant_proceeds_to_offer()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.unrepProceedWithOffer();
	}
	@Then("^claim is sent to TPA$")
	public void unrep_claim_sent_to_tpa()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.logout();
	}
	/*Claimant reviews and acknowledge medical report*/

	@Given("^DME uploads medical report$")
	public void dme_uploads_medical_report()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^claimant reviews medical report and acknowledges the report$")
	public void claimant_review_medical_report_acknowledge()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.unrepReviewReportWithoutUplift();

	}
	@Then("^claim is sent to compensator$")
	public void cliam_sent_to_compensator()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.logout();
	}
	@Then("^claim proceeds to offer$")
	public void claim_proceeds_to_offer()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.logout();
	}

	/* claimant challenge liability decision */
	@Given("^the claim liability has been accepted by compensator$")
	public void liability_accepeted_by_compensator()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@Given("^Updated Liability information received by claimant$")
	public void updated_liability_information_received_by_claimant() throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^claimant challenges Liability$")
	public void claimant_challenges_liability()throws Throwable
	{
		ClaimantActionsPage liability = new ClaimantActionsPage();
		liability.claimantChallengeLiabilityDecision();

	}
	@When("^claimant review challenge Liability$")
	public void claimant_review_challenge_liability()throws Throwable
	{
		ClaimantActionsPage liability = new ClaimantActionsPage();
		liability.claimantReviewChallengeLiabilityDecision();
	}
	@When("^claimant review and decline Liability$")
	public void claimant_review_decline_liability()throws Throwable
	{
		ClaimantActionsPage liability = new ClaimantActionsPage();
		liability.claimantReviewDeclineLiabilityDecision();
	}
	@Then("^claim will be sent to compensator to update liability$")
	public void claim_will_be_sent_to_compensator_update_liability()throws Throwable
	{
		ClaimantActionsPage liability = new ClaimantActionsPage();
		liability.logout();
	}

	/* Claimant asks for 2nd report */    
	@Given("^Claimant received the reports from DME$")
	public void claimant_received_the_reports_from_dme()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@Given("^medical report is sent to claimant for review$")
	public void medical_report_sent_to_claimant_review()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^Claimant requests for second report$")
	public void unrep_requests_second_report()throws Throwable
	{
		ClaimantActionsPage report = new ClaimantActionsPage();
		report.unrepRequestForSecondMedReport();
	}
	@When("^Claimant requests for additional report$")
	public void claimant_requests_additional_report()throws Throwable
	{
		ClaimantActionsPage report = new ClaimantActionsPage();
		report.unrepRequestAdditionalMedReport();
		
	}
	@When("^Claimant obtains further medical report$")
	public void claimant_obtains_further_medical_report()throws Throwable
	{
		ClaimantActionsPage report = new ClaimantActionsPage();
		report.unrepObtainFurtherMedReport();
		
	}
	
	@When("^Claimant decides waitout and obtains further medical report$")
	public void claimant_decides_waitout_obtains_further_medical_report()throws Throwable
	{
		ClaimantActionsPage report = new ClaimantActionsPage();
		report.unrepWaitoutObtainFurtherMedReport();
		report.unrepObtainFurtherReportDuringWOP();
		
	}
	@Then("^Claimant need to visit DME for medical examination again$")
	public void claimant_need_to_visit_dme()throws Throwable
	{
		ClaimantActionsPage report = new ClaimantActionsPage();
		report.logout();
	}
	@Then("^request is sent to compensator$")
	public void reques_sent_to_compensator()throws Throwable
	{
		ClaimantActionsPage report = new ClaimantActionsPage();
		report.logout();
	}


	/* Claimant accepts wait out prognosis */
	@Given("^Medical report received by claimant with wait out prognosis$")
	public void medical_report_received_by_claimant_with_wait_out_pprognosis()throws Throwable
	{
		MIBLoginPage.login("unrep"); 
	}
	@Given("^Medical report received by claimant with no prognosis$")
	public void medical_report_received_by_claimant_no_prognosis()throws Throwable
	{
		MIBLoginPage.login("unrep"); 
	}
	@When("^Claimant accepts wait out prognosis from compensator$")
	public void claimant_accepts_wait_out_prognosis_comp()throws Throwable
	{
		ClaimantActionsPage waitout = new ClaimantActionsPage();
		waitout.claimantAcceptWaitOutPrognosisFromComp();
	}

	@When("^Claimant accepts wait out prognosis$")
	public void claimant_accepts_wait_out_prognosis()throws Throwable
	{
		ClaimantActionsPage waitout = new ClaimantActionsPage();
		waitout.claimantAcceptWaitOutPrognosis();
	}

	@When("^Claimant accepts wait out prognosis and release the report$")
	public void claimant_release_report_to_compensator()throws Throwable
	{
		ClaimantActionsPage waitout = new ClaimantActionsPage();
		waitout.claimantAcceptWaitOutPrognosisReleaseToComp();
	}
	@When("^Claimant accepts wait out prognosis and proceeds to offer after prognosis ends$")
	public void claimant_accepts_wait_out_prognosis_and_proceeds_to_offer_after_prognosis_ends()throws Throwable
	{
		ClaimantActionsPage waitout = new ClaimantActionsPage();
		waitout.unrepAcceptWaitoutPrognosisandProceedtoOffer();
	}
	
	@When("^Claimant accepts wait out prognosis and proceeds to offer$")
	public void claimant_accepts_wait_out_prognosis_and_proceeds_to_offer()throws Throwable
	{
		ClaimantActionsPage waitout = new ClaimantActionsPage();
		waitout.unrepAcceptWaitoutAddLossProceedtoOffer();
	}

	@Then("^claimant need to wait until waitout prognosis period ends$")
	public void claimant_wait_unti_waitout_prognosis_period_ends()throws Throwable
	{
		ClaimantActionsPage waitout = new ClaimantActionsPage();
		waitout.logout(); 
	}
	@Then("^claim will be routed to compensator for first offer$")
	public void claim_will_be_routed_to_compensator_for_first_offer()throws Throwable
	{
		ClaimantActionsPage waitout = new ClaimantActionsPage();
		waitout.logout(); 
	}
	@Then("^claim will be routed to TPA$")
	public void claim_will_be_routed_to_tpa()throws Throwable
	{
		ClaimantActionsPage waitout = new ClaimantActionsPage();
		waitout.logout(); 
	}

	/*
	 * Claimant rejects interim payment decision and decides go to court and
	 * selectcourtdocs
	 */
	@Given("^the compensator makes interim payment$")
	public void the_compensator_makes_interim_payment()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^claimant goes to court for interim$")
	public void claimant_rejects_first_interim_decision()throws Throwable
	{
		ClaimantActionsPage rejectInterim = new ClaimantActionsPage();
		rejectInterim.unrepRejectInterimAndGoToCourt();

	}
	@Then("^claim will be sent to compensator for review$")
	public void claim_sent_to_compensator_for_review()throws Throwable
	{
		ClaimantActionsPage rejectInterim = new ClaimantActionsPage();
		rejectInterim.logout(); 
	}

	/* Unrep acknowledges documents selected by compensator */
	@Given("^compensator confirmed documents selected by claimant$")
	public void compensator_confirmed_documents_selected_claimant()throws Throwable
	{
		MIBLoginPage.login("unrep");

	}
	@When("^claimant acknowledges selected documents$")
	public void claimant_ack_selected_docs()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.unrepReviewInterimCourtDocs(); 
	}
	@Then("^Interim case is resolved at court but the main claim carries on$")
	public void interim_case_resolved_main_claim_carries_on()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.logout(); 
	}
	
	@Then("^Interim case is resolved at court$")
	public void interim_case_resolved()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.logout(); 
	}

	/* Claimant decides to go to court(OCS2) */
	@Given("^Compensator didn’t respond to claimant updated offer$")
	public void compensator_didnt_respond_to_offer()throws Throwable
	{
		MIBLoginPage.login("unrep"); 
	}
	@Given("^TPA didn’t respond to claimant updated offer$")
	public void tpa_didnt_respond_to_offer()throws Throwable
	{
		MIBLoginPage.login("unrep"); 
	}
	@When("^claimant decided to go to court and answerNVC$")
	public void claimant_decided_to_go_to_court_answer_nvc()throws Throwable
	{
		ClaimantActionsPage ocs = new ClaimantActionsPage();
		ocs.unrepGotoCourtOption_OCS2();
	}
	@Then("^the claimant goes to court$")
	public void the_claimant_goes_to_court()throws Throwable
	{
		ClaimantActionsPage ocs = new ClaimantActionsPage();
		ocs.logout(); 
	}

	/*Claimant goes to court on Non payment for fees OCS5*/ 
	@When("^claimant wants to go to court on Non payment for fees$")
	public void claimant_wants_to_go_to_court_on_Non_payment_for_fees()throws Throwable
	{

		ClaimantActionsPage court = new ClaimantActionsPage();
		court.unrepGotocourtocs5();
	}

	/*Unrep challenge liability decision and goes to court*/
	 
	@Given("^Claimant claim liability has been rejected$")
	public void claim_liability_rejected()throws Throwable
	{
		MIBLoginPage.login("unrep"); 
	}
	@When("^claimant wants to challenge decision and decided to go to court$")
	public void claimant_challenge_decision_go_to_court()throws Throwable
	{
		ClaimantActionsPage decision = new ClaimantActionsPage();
		decision.unrepGoToCourtRejectLiability();
	}
	
	@When("^claimant challenges and goes to court$")
	public void claimant_challenges_go_to_court()throws Throwable
	{
		ClaimantActionsPage decision = new ClaimantActionsPage();
		decision.unrepGoToCourtRejectLiability();
	}
	
	/*unrep goes to court for claim settlement pending OCS3*/
	@Given("^claim is pending and SLA breached$")
	public void claim_pending_sla_breached()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^claimant decides to go to court for interim non-payment$")
	public void claimant_go_to_court_select_court_document()throws Throwable
	{
		ClaimantActionsPage court = new ClaimantActionsPage();
		court.unrepGotoCourtOptionOCS3();
	}
	@When("^claimant decides to go to court for settlement of offer and fee$")
	public void claimant_go_to_court_offer_fee()throws Throwable
	{
		ClaimantActionsPage court = new ClaimantActionsPage();
		court.unrepGotoCourtSettleOfferFee();
	}
	@Then("^documents will be sent to TPA$")
	public void documents_will_be_sent_tpa()throws Throwable
	{

		ClaimantActionsPage oc5 = new ClaimantActionsPage();
		oc5.logout();
	}
	
	

	/*
	 * Claimant Accepts First Offer to compensator and rejects Fee proposal and go
	 * to court
	 */

	@Given("^claimant accepts first offer$")
	public void claimant_accepts_first_offer()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@Given("^claimant review fee proposal$")
	public void claimant_review_fee_proposal()throws Throwable
	{
		MIBLoginPage.login("prouser");
	}
	@When("^claimant rejects fee proposal and goes to court$")
	public void claimant_rejects_fee_proposal_go_to_court()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.unrepRejectFeeProposalAndGoToCourt();
	}
	@When("^claimant rejects fee offer and goes to court$")
	public void claimant_rejects_fee_offer_go_to_court()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.unrepRejectFeeOfferAndGoToCourt();
	}
	
	
	@When("^Prouser reject fee proposal and goes to court$")
	public void prouser_reject_fee_proposal_and_goes_to_court()throws Throwable
	{
		ClaimantActionsPage fee = new ClaimantActionsPage();
		fee.prouserRejectFeeProposalAndGoToCourt();
	}
	@Then("^claimant uploads court document$")
	public void claimant_uploads_court_document()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.logout();
	}
	/*Claimant Accepts Offer and fee proposal*/
	@When("^claimant accepts offer and fee proposal$")
	public void claimant_accepts_offer_fee_proposal()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.unrepRevisedtOfferFeeProposal();
	}
	/*Claimant accepts offer and makes counter fees proposal*/
	@When("^Claimant accepts offer and makes counter fees proposal$")
	public void Claimant_accepts_offer_and_makes_counter_fees_proposal()throws Throwable
	{
		ClaimantActionsPage counterfee = new ClaimantActionsPage();
		counterfee.acceptOfferRejectfee();
	}
	
	@When("^Claimant accepts offer and makes fees request$")
	public void Claimant_accepts_offer_and_makes_fee_request()throws Throwable
	{
		ClaimantActionsPage counterfee = new ClaimantActionsPage();
		counterfee.unrepAcceptOfferAndRequestFee();
	}
	
	/*claimant decides to challenge fee decision and decided to go to court*/
	@When("^claimant decides to challenge fee decision and decided to go to court$")
	public void claimant_decides_to_challenge_fee_decision()throws Throwable
	{
		ClaimantActionsPage OCS4 = new ClaimantActionsPage();
		OCS4.gotocourtOption_OCS4();
	}

	/* claimant decides to go to court over interim non-payment */
	@Given("^'(.*)' interim non-payment SLA is breached$")
	public void interim_payment_sla_breached(String claimant)throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");

			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}
	}
	@When("^Go to court for non-payment option is enabled for '(.*)'$")
	public void gotocourt_non_payment_option(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			ClaimantActionsPage court = new ClaimantActionsPage();
			court.unrepGotoCourtForInterimNonPayment();
			break;
		case "prouser":
			ClaimantActionsPage prouser = new ClaimantActionsPage();
			prouser.prouserGotoCourtForInterimNonPayment();
			break;
		case "mibpro":
			MIBProActionsPage mib = new MIBProActionsPage();
			mib.mibproGotoCourtForInterimNonPayment();
			break;
		}
	}
	@Then("^claimant decides to go to court over interim non-payment$")
	public void claimant_goto_court_for_non_payment()throws Throwable
	{
		ClaimantActionsPage court = new ClaimantActionsPage();
		court.logout();
	}

	/*claimant select court document for interim non-payment*/
	@Given("^'(.*)' goes to court over interim$")
	public void claimant_goes_to_court_over_interim(String claimant)throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");

			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}
	}

	@When("^'(.*)' selects document for court for interim non-payment$")
	public void claimant_submits_document_for_court(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			ClaimantActionsPage court = new ClaimantActionsPage();
			court.unrepselectCourtDocumentsForInterimNonPayment();
			break;
		case "prouser":
			ClaimantActionsPage prouser = new ClaimantActionsPage();
			prouser.prouserselectCourtDocsForInterimNonPayment();
			break;
		case "mibpro":
			MIBProActionsPage mib = new MIBProActionsPage();
			mib.mibproselectCourtDocsForInterimNonPayment();
			break;

		}
	}
	@Then("^court document are sent to compensator$")
	public void court_documents_are_to_compensator()throws Throwable
	{
		ClaimantActionsPage court = new ClaimantActionsPage();
		court.logout();
	}
	
	/*
	 * Claimant cannot proceed to court for 2nd interim when 1st interim is in court
	 */
	@Given("^claimant goes to court for first interim$")
	public void claimant_goes_to_court_first_interim()throws Throwable
	{
		MIBLoginPage.login("unrep");

	}
	@When("^claimant goes to court for second interim over reduced payment$")
	public void claimant_goes_to_court_second_interim()throws Throwable
	{
		ClaimantActionsPage court = new ClaimantActionsPage();
		court.unrepSecondInterimUnableToGotoCourt();
	}
	@Then("^error message is displayed and will not allow the claimant to proceed$")
	public void error_message_displayed()throws Throwable
	{
		ClaimantActionsPage court = new ClaimantActionsPage();
		court.logout();
	}
	

	
	
	
	
	/*Claimant reject fee proposal*/
	@Given("^Claimant receives the fee proposal from compensator$")
	public void claimant_receives_fee_proposal_from_compensator()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^Claimant rejects the fee proposal$")
	public void claimant_rejects_the_fee_propsal()throws Throwable
	{
		ClaimantActionsPage fee = new ClaimantActionsPage();
		fee.unrepRejectFeeProposal();
	}
	@Then("^counter fee proposal is sent back to the compensator$")
	public void counter_fee_proposa_is_sent_back_to_compensator()throws Throwable
	{
		ClaimantActionsPage counterfee = new ClaimantActionsPage();
		counterfee.slaBreached();
	}
	
	
	
	/* Claimant should not be able to add losses/fee */
  	@Given("^claimant has proceeded with offer$")
  	public void claimant_has_proceeded_with_offer()throws Throwable
  	{
  		MIBLoginPage.login("unrep");
  	}
  	@When("^Claimant tries to add loss or fee$")
  	public void claimant_tries_to_add_loss_or_fee()throws Throwable
  	{
  		ClaimantActionsPage link = new ClaimantActionsPage();
		link.unrepVerifyAddLoss();
  	}
  	@Then("^claimant should not be allowed to add loss/fee$")
  	public void claimant_should_not_be_allowd_to_add_loss_fee()throws Throwable
  	{
  		ClaimantActionsPage loss = new ClaimantActionsPage();
		loss.logout();
  		
  	}
  	
	/* Claimant should not be able to challenge liability */
 	@Given("^claimant has reopened the claim$")
 	public void claimant_has_reopened_the_claim()throws Throwable
 	{
 		MIBLoginPage.login("unrep");
 	}
 	@When("^claimant tries to challenge liability$")
 	public void claimant_tries_to_challenge_liability()
 	{
 		ClaimantActionsPage link = new ClaimantActionsPage();
		link.unrepVerifyChallengeLiability();
 	}
 	
	/* Claimant Request fee */
	@Given("^claimant accepts offer without fee$")
	public void claimant_accepts_offer_without_fee()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^claimant requests fee$")
	public void claimant_requests_fee()throws Throwable
	{
		ClaimantActionsPage fee = new ClaimantActionsPage();
		fee.unrepRequestFee();
	}
	@Then("^fee request is sent to the compensator$")
	public void fee_request_is_sent_to_the_compensator()throws Throwable
	{
		ClaimantActionsPage exit = new ClaimantActionsPage();
		exit.logout();
	}

	/* Claimant accepts fee proposal */
	@Given("^fee offer has been made to the claimant$")
	public void fee_offer_has_been_made_to_the_claimant()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^claimant accepts the fee proposal$")
	public void claimant_accepts_the_fee_proposal()throws Throwable
	{
		ClaimantActionsPage fee = new ClaimantActionsPage();
		fee.unrepAcceptFee();
		
	}

	/* Claimant decides to waitout prognisis and requests further medical report */
	@Given("^Claimant accepts waitout prognosis$")
	public void claimant_accepts_waitout_prognosis()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^Claimant decides to accept waitout prognosis$")
	public void claimant_decides_to_get_further_medical_report_during_wop()throws Throwable
	{
		ClaimantActionsPage wop = new ClaimantActionsPage();
		wop.unrepAcceptWOP();
	}
	
	@And("^claimant requests for further medical$") 
	public void claimant_requests_for_further_medicals()throws Throwable
	{
		ClaimantActionsPage wop = new ClaimantActionsPage();
		wop.unrepObtainFurtherReportDuringWOP();
		
	}
	 
		
	@Then("^acknowledgment is sent to compensator$")
	public void acknowledgment_is_sent_to_compensator()throws Throwable
	{
		ClaimantActionsPage exit = new ClaimantActionsPage();
		exit.logout();
	}
	
	/* Claimant upload further medical report without WOP - recovered */
	@Given("^Compensator has acknowledged for further medical report$")
	public void compensator_has_acknowledged_for_further_medical_report()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@Given("^Compensator has denied for further medical report$")
	public void compensator_has_denied_for_further_medical_report()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^claimant uploads the further report$")
	public void claimant_uploads_further_report()throws Throwable
	{
		ClaimantActionsPage rep = new ClaimantActionsPage();
		rep.unrepUploadRevisedMedReport();
	}
	
	/*Verify the claim is in Resolved status*/
	@Given("'(.*)' goes to court$")
	public void claimant_goes_to_court(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "unrep":
			MIBLoginPage.login(claimant);
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		case "prouser":
			MIBLoginPage.login(claimant);
		}
	}
	@When("^the claim goes to dispute at court at '(.*)'$")
	public void claim_goes_to_dispute_at_court(String status)throws Throwable
	{
		ClaimantActionsPage stat = new ClaimantActionsPage();
		stat.resolvedStatus(status);
	}
	@Then("^the claim will be resolved at court$")
	public void the_claim_will_resolved_at_court()throws Throwable
	{
		ClaimantActionsPage exit = new ClaimantActionsPage();
		exit.logout();
	}
	
	/* Claimant accepts the decision and no offer is made */
		@Given("^compensator has disputed causation$")
		public void compensator_has_disputed_causation()throws Throwable
		{
			MIBLoginPage.login("unrep");
		}
		@When("^claimant accepts the dispute causation no offer$")
		public void claimant_accepts_the_dispute_no_offer()throws Throwable
		{
			ClaimantActionsPage dispute = new ClaimantActionsPage();
			dispute.causationDisputeOffer();
		}
		@Then("^claim moves to Resolved-NoOffer$")
		public void claim_moves_to_resolved_no_offer()throws Throwable
		{
			ClaimantActionsPage exit = new ClaimantActionsPage();
			exit.logout();
		}
		@When("^claimant reject the dispute causation final offer$")
		public void claimant_reject_the_dispute_final_offer()throws Throwable
		{
			ClaimantActionsPage dispute = new ClaimantActionsPage();
			dispute.causationDisputeFinalOffer();
		}
		@Then("^claim moves to Resolved-FinalOfferRejected$")
		public void claim_moves_to_resolved_final_offer_rejected()throws Throwable
		{
			ClaimantActionsPage exit = new ClaimantActionsPage();
			exit.logout();
		}
		
		/* DME has challenged the medical report */
		@Given("^DME has rejected the report request$")
		public void dme_has_rejected_the_report_request()throws Throwable
		{
			MIBLoginPage.login("unrep");
			ClaimantActionsPage status = new ClaimantActionsPage();
			status.unrepClaimStatus("Pending-MedicalChallengeRejected");
		}
		@Then("^the claimant checks the claim status$")
		public void the_claimant_checks_the_claim_status()throws Throwable
		{
			ClaimantActionsPage exit = new ClaimantActionsPage();
			exit.logout();
		}
		

		/* Claimant proceeds to offer after uploading own medical report*/
	@Given("^claimant uploaded medical report$")
	public void claimant_uploaded_medical_report()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^claimant proceeds to offer after uploading own medical report$")
	public void claimant_proceeds_to_offer_after_uploading_medical_report()throws Throwable
	{
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.unrepProceedToOfferAfterReportUpload();
	}
	
	/* unrep withdraws the offer and makes replacement offer */
	@Given("^claimant has made first offer$")
	public void claimant_has_made_first_offer()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@When("^claimant withdraws the current offer$")
	public void claimant_withdraws_the_current_offer()throws Throwable
	{
		ClaimantActionsPage replace = new ClaimantActionsPage();
		replace.unrepWithdrawOfferReplace();
	}
	@Then("^replaces with another offer$")
	public void replaces_with_another_offer()throws Throwable
	{
		ClaimantActionsPage exit = new ClaimantActionsPage();
		exit.logout();
	}
	/* claimants accepts rejected offer */
	@Given("^claimant has made counter offer$")
	public void claimant_has_made_counter_offer()throws Throwable
	{
		MIBLoginPage.login("unrep");
	}
	@Then("^claimant accepts rejected offer$")
	public void claimant_accepts_rejected_offer()throws Throwable
	{
		ClaimantActionsPage reject = new ClaimantActionsPage();
		reject.unrepAcceptRejectedOffer();
		reject.logout();
	}
	
	// Author: Sourav Dutta
	
	@Given("^\"([^\"]*)\" login to check offer$")
	public void login_to_check_offer(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");

			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}
	}

	@When("^Claimant challenge NON WHIPLASH injury$")
	public void claimant_challenge_NON_WHIPLASH_injury() throws Throwable {
	    
		ClaimantActionsPage challenge=new ClaimantActionsPage();
		challenge.challengeNonWhipInjury();
	}

	@Then("^Challenge sent back to compensator$")
	public void challenge_sent_back_to_compensator() throws Throwable {
		ClaimantActionsPage user = new ClaimantActionsPage();
		user.logout();
	}

	
	@Given("^\"([^\"]*)\" login to challenge NON Whiplash decision$")
	public void login_to_challenge_NON_Whiplash_decision(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");

			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}
	}
	
	@When("^Claimant rejected compensator NON WHIPLASH injury decision$")
	public void claimant_rejected_compensator_NON_WHIPLASH_injury_decision() throws Throwable {
		ClaimantActionsPage challenge=new ClaimantActionsPage();
		challenge.ClaimantRespondNonWhipInjury("Reject");
	}
	
	@When("^Claimant respond after compensator reject final challenge$")
	public void claimant_respond_after_compensator_reject_final_challenge() throws Throwable {
		
		ClaimantActionsPage finalreject=new ClaimantActionsPage();
		finalreject.acceptFinalRejectionNonWhipInjury();
		
	}	
	
	/*
	 * Author: Sourav Dutta 
	 * Comment: Sprint 41 changes
	 */
	
	@When("^\"([^\"]*)\" uploads medical report with Uplift request$")
	public void uploads_medical_report_with_Uplift_request(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":			

			break;
		case "prouser":
			ProUserActionsPage medical=new ProUserActionsPage();
			medical.uploadReportwithUplift();
			break;
		case "mibpro":
			
			break;
		}
	    
	}
	
	@When("^\"([^\"]*)\" decided to go to court after rejecting first offer$")
	public void decided_to_go_to_court_after_rejecting_first_offer(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":			
			ClaimantActionsPage rejectoffer=new ClaimantActionsPage();
			rejectoffer.unrepFirstOfferGoToCourt("Yes", "No", "Yes", "Yes");
			break;
			
		case "prouser":
			ProUserActionsPage offer=new ProUserActionsPage();
			offer.prouserFirstOfferGoToCourt("No", "No", "Yes", "Yes");
			break;
		case "mibpro":
			MIBProActionsPage mibrejectoffer=new MIBProActionsPage();
			mibrejectoffer.mibFirstOfferGoToCourt("Yes", "No", "Yes", "Yes");
			break;
			
		}
	}
	
	@Given("^\"([^\"]*)\" started court proceeding$")
	public void started_court_proceeding(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":
			MIBLoginPage.login("unrep");

			break;
		case "prouser":
			MIBLoginPage.login("prouser");
			break;
		case "mibpro":
			SuperUserLoginPage.mibProLogin();
			break;
		}
	}
	
	@When("^\"([^\"]*)\" selected Court proceeding started as Yes$")
	public void selected_Court_proceeding_started_as_Yes(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":			
			ClaimantActionsPage unrepcourtproceeding=new ClaimantActionsPage();
			unrepcourtproceeding.courtProceeding(claimant,"Yes");
			break;
			
		case "prouser":
			ClaimantActionsPage courtproceeding=new ClaimantActionsPage();
			courtproceeding.courtProceeding(claimant,"Yes");
			break;
		case "mibpro":
			ClaimantActionsPage mibprocourtproceeding=new ClaimantActionsPage();
			mibprocourtproceeding.courtProceeding(claimant,"Yes");
			break;
		}
	}
	
	/*
	 *Author: P Vidya
	 *Sprint 41 changes 
	 */

	@When("^'(.*)' selects interim docs for court with Court proceeding Yes$")
	public void unrep_selects_interim_docs_for_court_with_Court_proceeding_Yes(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":            
			ClaimantActionsPage courtdocs=new ClaimantActionsPage();
			courtdocs.unrepselectCourtDocsForInterimNonPaymentsecondtime();
			break;
		case "prouser":

			break;
		case "mibpro":
			break;
		}
	}




	@When("^claimant acknowledges selected documents with proceeding yes$")
	public void claimant_ack_selected_docs_with_proceeding_yes()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.unrepReviewInterimCourtDocsSecondtime(); 
	}
	@When("^unrep selects medical preferences for an DME in Pending-MedicalAfterCourt$")
	public void unrep_selects_medical_preferences_for_an_DME_in_Pending_MedicalAfterCourt() throws Throwable {
		ClaimantActionsPage unrep = new ClaimantActionsPage();
		unrep.unrepChooseDME("Pending-MedicalAfterCourt");
	}
	

	@When("^'(.*)' selects documents for court third time after NVC$")
	public void claimant_upload_court_document_thirdtimeafter_nvc(String claimant)throws Throwable
	{
		switch(claimant)
		{
		case "prouser":

			break;
		case "unrep":
			ClaimantActionsPage upload = new ClaimantActionsPage();
			upload.unrepSelectCourtDocsthirdtimeNVC();
			break;
		case "mibpro":
			MIBProActionsPage nvc = new MIBProActionsPage();
			nvc.MIBProuserSelectCourtDocsthirdtimeNVC();
			break;
		}
	}

	/*Added sprint41 for going to court third time*/
	@When("^'(.*)' submit the claim for court third time for NVC$")
	public void claimant_submit_claim_to_court_third_time_for_NVC(String claimant)throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			ClaimantActionsPage closed = new ClaimantActionsPage();
			closed.unrepAckCourtDocThirdtimeNVC();
			break;
		case "prouser":
			ClaimantActionsPage proclosed = new ClaimantActionsPage();
			//proclosed.prouserAckCourtDocs();
			break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			mibpro.MIBProcourtScreen("No","Yes","Yes","No","Yes","Yes","Yes","No","Yes","Yes");
			break;
		}
	}
	
	/*
	 *Author: Sourav Dutta
	 *Sprint 41 changes for 2nd time court proceeding
	 */
	
	@When("^\"([^\"]*)\" selected documents for court$")
	public void selected_documents_for_court(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":			
			ClaimantActionsPage unrepdoc=new ClaimantActionsPage();
			unrepdoc.unrepselectDocumentInterim("Yes", "No", "No", "No");
			unrepdoc.unrepselectDocumentOtherThanInterim("No", "No", "Yes", "Yes", "Yes", "No", "No", "Yes", "Yes", "No", "No", "No");
			break;
		case "prouser":
			ProUserActionsPage selectdoc=new ProUserActionsPage();
			selectdoc.selectDocumentInterim("Yes", "No", "No", "No");
			selectdoc.selectDocumentOtherThanInterim("No", "No", "Yes", "Yes", "Yes", "No", "No", "Yes", "Yes", "No", "No", "No");
			break;
		case "mibpro":
			ProUserActionsPage mibprodoc=new ProUserActionsPage();
			mibprodoc.selectDocumentInterim("Yes", "No", "No", "No");
			mibprodoc.selectDocumentOtherThanInterim("No", "No", "Yes", "Yes", "Yes", "No", "No", "Yes", "Yes", "No", "No", "No");
			break;			
		}	
		
	}
	
	
	
	@When("^\"([^\"]*)\" entered details in court screen$")
	public void entered_details_in_court_screen(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":			

			ClaimantActionsPage courtpage=new ClaimantActionsPage();
            courtpage.unrepcourtScreen("No", "Yes", "Yes", "No", "Yes", "Yes", "Yes", "No", "Yes", "Yes");
			break;
		case "prouser":
			ProUserActionsPage court=new ProUserActionsPage();
			court.courtScreen("Yes", "Yes", "Yes", "No", "Yes", "Yes", "No", "No", "No", "Yes");
			break;
		case "mibpro":
			MIBProActionsPage mibcourt=new MIBProActionsPage();
			mibcourt.courtScreen("No", "Yes", "Yes", "No", "Yes", "Yes", "Yes", "No", "Yes", "Yes");
			break;
		}	
	}
	
	
	@When("^\"([^\"]*)\" selected Court proceeding started as No$")
	public void selected_Court_proceeding_started_as_No(String claimant) throws Throwable {
		ClaimantActionsPage courtproceeding=new ClaimantActionsPage();
		courtproceeding.courtProceedingInterim(claimant,"No");
	}
	
	@When("^\"([^\"]*)\" selected documents for court fees disagreement$")
	public void selected_documents_for_court_fees_disagreement(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":			

			break;
		case "prouser":
			ProUserActionsPage selectdoc=new ProUserActionsPage();
			selectdoc.selectDocumentOtherThanInterim("No", "No", "Yes", "Yes", "Yes", "No", "No", "Yes", "Yes", "No", "No", "No");
			break;
		case "mibpro":
			
			break;
		}
	}
	
	@When("^\"([^\"]*)\" selected documents for court NON payment of Interim$")
	public void selected_documents_for_court_NON_payment_of_Interim(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":			

			break;
		case "prouser":
			ProUserActionsPage selectdoc=new ProUserActionsPage();
			selectdoc.selectDocumentInterim("Yes","No","No","No");
			selectdoc.selectDocumentOtherThanInterim("No", "No", "No", "Yes", "No", "No", "No", "No", "No", "No", "No", "No");
			break;
		case "mibpro":
			
			break;
		}
	}
	
	
	@When("^\"([^\"]*)\" submit the claim for court with claim for fee dispute subsequent court applications$")
	public void submit_the_claim_for_court_with_claim_for_fee_dispute_subsequent_court_applications(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":			

			break;
		case "prouser":
			ProUserActionsPage court=new ProUserActionsPage();
			court.courtScreen("Yes","Yes","Yes","No","No","No","No","Yes","No","Yes");
			
			break;
		case "mibpro":
			
			break;
		}
	}
	@When("^\"([^\"]*)\" uploads medical report without Uplift request$")
	public void uploads_medical_report_without_Uplift_request(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":			

			break;
		case "prouser":
			ProUserActionsPage medical=new ProUserActionsPage();
			medical.uploadReportwithoutUplift();
			break;
		case "mibpro":
			
			break;
		}
	    
	}
	
	@When("^'(.*)' selects interim docs for court with Court proceeding No$")
	public void unrep_selects_interim_docs_for_court_with_Court_proceeding_No(String claimant) throws Throwable {
		switch (claimant)
		{
		case "unrep":            
			ClaimantActionsPage courtdocs=new ClaimantActionsPage();
			courtdocs.unrepNoCourtProccedingDocsForInterimNonPaymentsecondtime();
			break;
		case "prouser":

			break;
		case "mibpro":
			MIBProActionsPage mibcourt=new MIBProActionsPage();
			mibcourt.mibproselectCourtDocsSecondtimeForInterimNonPayment();
			break;
		}
	}
	
	@When("^claimant acknowledges selected documents with proceeding No$")
	public void claimant_ack_selected_docs_with_proceeding_No()throws Throwable
	{
		ClaimantActionsPage review = new ClaimantActionsPage();
		review.unrepReviewInterimCourtDocsSecondtime(); 
	}


	@When("^'(.*)' answers NVC$")
	public void claimant_answers_NVC(String claimant)throws Throwable{
		switch (claimant)
		{
		case "unrep":			
			ClaimantActionsPage nvc=new ClaimantActionsPage();
			nvc.unrepRequestNVC();
			break;
		case "prouser":

			break;
		case "mibpro":
			MIBProActionsPage mib=new MIBProActionsPage();
			mib.mibproAnswerNVC();
			break;
			
		}	
	}


	@When("^unrep selects medical preferences for an DME in (.*)'$")
	public void unrep_medical_preference_dme_in_status(String status)throws Throwable
	{
		ClaimantActionsPage unrep = new ClaimantActionsPage();
		unrep.unrepChooseDME(status);
	}
	
	
	@Given("^MIBProuser reviews medical report when uploaded by DME$")
	public void MIBProuser_review_medical_report_uploaded_by_dme()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}

	@When("^mibpro acknowledges selected documents with proceeding No$")
	public void mibpro_ack_selected_docs_with_proceeding_No()throws Throwable
	{
		MIBProActionsPage review = new MIBProActionsPage();
		review.mibproReviewInterimCourtDocsSecondtime(); 
	}
	
	
	/* 
	 * Author: P Vidya 	 
	  */
	@When("^'(.*)' reject the offer with tariff$")
	public void reject_first_offer_with_tariff(String claimant) throws Throwable
	{
		switch (claimant)
		{
		case "unrep":
			ClaimantActionsPage offerwithouttariff = new ClaimantActionsPage();
			offerwithouttariff.unrepRejectFirstOfferTariff("Tariff_Yes");
			break;
		case "prouser":
			ProUserActionsPage prooffer = new ProUserActionsPage();
			prooffer.rejectFirstOffer();
			break;
		case "mibpro":
			MIBProActionsPage mibpro = new MIBProActionsPage();
			mibpro.mibproRejectoffer();
			break;
		}
	}
		
}