package com.cucumbercraft.stepdefinitions;

import com.cucumbercraft.pages.CompensatorDecisionPage;
import com.cucumbercraft.pages.CompensatorOfferPage;
import com.cucumbercraft.pages.CompensatorPage;
import com.cucumbercraft.pages.MIBLoginPage;
import com.cucumbercraft.pages.TPApage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
public class TPAStepDefs{




	@Given("^Login as TPA$")
	public void login_As_TPA() throws Throwable
	{
		MIBLoginPage.login("tpa");

	}

	@Given("^the claim  has been sent to the TPA workbasket$")
	public void claim_has_been_sent_to_TPA()throws Throwable
	{

		MIBLoginPage.login("tpa");
	}
	/* TPA Denies Claim and claim Liability */
	@When("^TPA dispute claim liability$")
	public void tpa_accepts_claim__denies_claim_liability()throws Throwable
	{
		/*
		 * TPApage tpa = new TPApage(); tpa.disputeLiability();
		 */
		CompensatorDecisionPage tpa = new CompensatorDecisionPage();
		tpa.deniedLiability();
	}
	@When("^TPA accepts full liability$")
	public void tpa_accepts_full_liability()throws Throwable
	{
		CompensatorDecisionPage tpa = new CompensatorDecisionPage();
			tpa.full_Liability_Wo_Dispute();
	}
	/* TPA Accept Claim and makes full liability with dispute */
	
	@When("^TPA accepts claim and makes part liability with dispute$")
	public void tpa_part_liability_without_dispute()throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.partialLiabilityCausation();
		
	}
	
	/* TPA disputes causation at offer */
	@When("^TPA disputes causation at offer$")
	public void compensator_disputes_causation_at_offer()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.disputeCausationOffer();
	}
	
	/*TPA partial liability*/
	@When("^TPA accepts claim and makes part liability$")
	public void TPA_part_liability()throws Throwable
	{
		TPApage comp = new TPApage();
		comp.partialLiabilityWODispute();

	}
	
	/*TPA rejects claimants fee offer*/
	@Given("^Prouser rejects fee offer$")
	public void prouser_rejects_fee_offer()throws Throwable
	{
		MIBLoginPage.login("tpa");
	}
	
	@When("^TPA rejects claimant fee offer$")
	public void tpa_rejects_claimant_fee_offer()throws Throwable
	{
		CompensatorOfferPage reject = new CompensatorOfferPage();
		reject.rejectFeeProposal();
	}
	
	@Then("^TPA sends the updated fee offer to prouser$")
	public void tpa_sends_updated_fee_offer()throws Throwable
	{
		CompensatorDecisionPage tpa = new CompensatorDecisionPage();
		tpa.logout();	
	}
	/*TPA send the liability information to claimant*/
	@Then("^claims acceptance and liability information is passed to claimant$")
	public void claims_Acceptance_Denied_Liability_passedto_claimant()throws Throwable
	{
		CompensatorDecisionPage tpa = new CompensatorDecisionPage();
		tpa.logout();	
	}

	/* TPA Accept Claim and makes no claim Liability and SLA breached */
	@When("^TPA accepts claim and makes no liability decision$")
	public void tpa_accept_claim_makes_no_liability_decision() throws Throwable
	{
		//TPApage claim = new TPApage();
		// claim.acceptclaim();
		//CompensatorDecisionPage claim = new CompensatorDecisionPage();
				//claim.full_Liability_Wo_Dispute();
		

	}
	@Then("^claim SLA is breached and claim is moved to full liability$")
	public void claim_sla_breached_moved_full_liability()throws Throwable
	{
		TPApage sla = new TPApage();
		sla.slaBreached();
	}

	/*TPA rejects UPLIFT request and makes First offer to claimant*/
	@When("^TPA disagrees to an UPLIFT and makes first offer$")
	public void tpa_disagree_uplift_makes_offer() throws Throwable
	{
		TPApage offer = new TPApage();
			offer.disagreeUpliftAndMakeOffer();


	}
	@Then("^uplift rejected first offer is sent to the claimant$")
	public void first_offer_sent_claimant()throws Throwable 
	{
		TPApage offer = new TPApage();
		offer.logout();
	}

	/* TPA send second offer made with no UPLIFT consideration */   
	@When ("^TPA decides not to include  UPLIFT amount in second offer$")
	public void no_uplift_second_offer()throws Throwable
	{
		TPApage offer = new TPApage();
			offer.secondOfferWithNoUplift();
	}

	@Then("^second offer without UPLIFT will be sent to claimant$")
	public void second_offer_no_uplift_sent_claimant()throws Throwable
	{
		TPApage offer = new TPApage();
			offer.logout();
	}
	
	@Given("^TPA has made first offer to claimant$")
	public void tpa_has_made_first_offer_to_claimant()throws Throwable
	{
		MIBLoginPage.login("tpa");
	}
	/*TPA removes claim*/
	@Given("^TPA does not respond to NVC$")
	public void tpa_does_not_respond_nvc()throws Throwable
	{
		MIBLoginPage.login("tpa");
	}
	@When("^TPA removes the claim from portal$")
	public void compensator_terminates_the_claim()throws Throwable
	{
		TPApage terminate = new TPApage();
		terminate.removeClaim();
	}
	
	/*TPA withdraws and reject the offer*/
	@Then("^claim offer is sent to claimant review$")
	public void claim_offer_is_sent_to_claimant_review()throws Throwable
	{
		TPApage sla = new TPApage();
		sla.slaBreached();
	}
	@When("^TPA withdraws the offer at claim '(.*)'$")
	public void tpa_withdraws_the_offer_and_rejects_the_offer(String status)throws Throwable
	{
		TPApage withdraw = new TPApage();
		withdraw.tpaWithdrawOffer(status);
	}
	@Then("^TPA gets an option to replace the offer$")
	public void stpa_gets_an_option_to_replace_the_offer()throws Throwable
	{
		TPApage offer = new TPApage();
			offer.logout();
	}
	
	/* TPA Accepts counter offer from claimant*/
	

	@When("^TPA accepts claimant counter offer$")
	public void compensator_accepts_counter_offer()throws Throwable
	{
		CompensatorOfferPage counter = new CompensatorOfferPage();
		counter.acceptCounterOffer();
	}
	
	/* TPA responds to NVC questions */ 
	@Given("^TPA receives claim to review NVC answers$")
	public void tpa_review_nvc_answers()throws Throwable
	{
		MIBLoginPage.login("tpa");
	}
	@When("^TPA responds to NVC answers$")
	public void tpa_respond_nvc_answers()throws Throwable
	{
		TPApage nvc = new TPApage();
		nvc.respondNVC();
	}
	@Then("^claim should be sent to claimant to select documents for court$")
	public void claim_sent_to_claimant_to_select_court_document()throws Throwable
	{
		TPApage nvc = new TPApage();
		nvc.logout();
	}
	 /*TPA makes interim payment*/
	 
	 @Given("^claimant request interm payment to TPA$")
	 public void request_interim_payment_tpa() throws Throwable
	 {
		 MIBLoginPage.login("tpa"); 
	 }
	 @When("^TPA makes interim payment$")
	 public void tpa_makes_interim_payment()throws Throwable
	 {
		 CompensatorDecisionPage pay = new CompensatorDecisionPage();
		 pay.makeInterimPayment();
	 }
	 @Then("^claimant receives interim payment from TPA$")
	 public void claimant_receives_interim_payment() throws Throwable
	 {
			TPApage pay = new TPApage();
			pay.logout();
	 }


	/* TPA disagrees to court documents uploaded & claim closed */ 
	@Given("^Uploaded documents for court cofirmed by Claimant$")
	public void court_documents_confirmed_claimant()throws Throwable
	{
		MIBLoginPage.login("tpa");
	}
	@When("^TPA disagrees to court documents uploaded by Claimant at '(.*)'$")
	public void tpa_disagrees_court_document_from_claimant(String status)throws Throwable
	{
		TPApage disagree = new TPApage();
		disagree.tpaDisagreeCourtDocs(status);
	}


	@Then("^claimant need to review the documents uploaded by TPA$")
	public void claimant_review_the_documents_uploaded_tpa()throws Throwable
	{
		TPApage disagree = new TPApage();
		disagree.logout();
	}
	
	/*TPA makes first offer to claimant*/

	@When("^the TPA makes first offer$")
	public void tpa_makes_first_offer()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.compFirstOffer();
		
	}
	
	@When("^TPA makes updated first offer$")
	public void tpa_updated_first_offer()throws Throwable
	{
		TPApage offer = new TPApage();
		offer.updatedOffer();
	}

	@When("^the TPA send updated offer$")
	public void tpa_send_updated_offer()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.revisedOfferToClaimant();

		
	}
	
	/* TPA acknowledges documents selected for court */
	@Given("^claimant selects court documents TPA$")
	public void claimant_select_court_docs_tpa()throws Throwable
	{
		MIBLoginPage.login("tpa");
	}
	@When("^TPA agrees to court documents when claim is in '(.*)'$")
	public void tpa_agree_court_documents(String status)throws Throwable
	{
		TPApage agree = new TPApage();
		agree.agreeCourtDocs(status);

	}
	
/* Compensator make first offer with fee prop */
	
	@Given("^claimant requests offer to TPA$")
	public void claimant_requests_offer()
	{
		MIBLoginPage.login("tpa");
	}
	@When("^the TPA makes first offer with fee proposal$")
	public void compensator_first_offer_fee_proposal()throws Throwable
	{
		CompensatorOfferPage offerWithFee = new CompensatorOfferPage();
		offerWithFee.compFirstOfferWithFeeProposal();
	}
	@Then("^claim will be sent for claimant acknowledgement$")
	public void claim_sent_for_claimant_ack()throws Throwable
	{
		TPApage sla = new TPApage();
		sla.logout();
	}
	
	 /*TPA Accepts revised offer from claimant*/
	 @Given("^Claimant requested for revised offer to TPA$")
	 public void claimant_requested_revised_offer()throws Throwable
	 {
		 MIBLoginPage.login("tpa"); 
	 }
	 @When("^TPA agrees to 'UPLIFT' and  makes revised offer with UPLIFT taken in to consideration$")
	 public void tpa_uplift_accepts_revised_offer()throws Throwable
	 {
		 CompensatorOfferPage revised = new CompensatorOfferPage();
		 revised.acceptCounterOffer();
	 }
	 @When("^TPA accepts the claimant revised offer$")
	 public void tpa_accepts_revised_offer()throws Throwable
	 {
		TPApage revised = new TPApage();
		 revised.acceptRevisedOffer();
	 }
	 
	 /* TPA reopens claim and accepts full claim liability */
		@Given("^Claim is resolved at court$")
		public void claimant_uploads_court_documents()throws Throwable
		{
			MIBLoginPage.login("tpa");
		}
		@When("^TPA reopens liability disputed claim$")
		public void tpa_repoens_liability_disputed_claim()throws Throwable
		{
			CompensatorPage reopen = new CompensatorPage();
			reopen.reopenClaimAfterCourt();
			/*
			 * CompensatorDecisionPage liability = new CompensatorDecisionPage();
			 * liability.full_Liability_Wo_Dispute();
			 */
		}
		@Then("^TPA accepts full liability after reopening the claim$")
		public void tpa_accepts_full_liability_after_reopen()throws Throwable
		{
			CompensatorDecisionPage reopen = new CompensatorDecisionPage();
			reopen.logout();
		
		}
	 
	 
	 /* TPA Acknowledges Offer*/
	 @Given("^claimant accepts the offer$")
	 public void claimant_accepts_the_offer_from_tpa()throws Throwable
	 {
		 MIBLoginPage.login("tpa"); 
	 }
	 
	 /*TPA rejects interim request*/
	 
	 @When("^TPA reject interim payment$")
	 public void tpa_reject_interim_payment()throws Throwable
	 {
		 TPApage interim = new TPApage();
		 interim.rejectInterim();
	 }
	 @Then("^claimant will review the interim decision$")
	 public void claimant_will_review_the_interim_decision() throws Throwable
	 {
		 TPApage exit = new TPApage();
		 exit.logout();
	 }
	 
	 @When("^TPA acknowledges claimants offer with claim '(.*)'$")
		public void TPA_acknowledges_claimants_offer(String status)throws Throwable
		{
			CompensatorDecisionPage ack = new CompensatorDecisionPage();
			ack.compensatorACK(status);
		}
	 
	 @When("^TPA acknowledges claimants withdrawal$")
		public void tpa_acknowledges_claimants_withdrawal()throws Throwable
		{
			CompensatorDecisionPage ack = new CompensatorDecisionPage();
			ack.compensatorACKWithdraw();
		}
	 
	 /* TPA reviews court document for secondary action(Interim) */
		@Given("^claimant goes to court for interim non payment$")
		public void claimant_goes_to_court()throws Throwable
		{
			MIBLoginPage.login("tpa");
		}
		/*
		 * @When("^TPA reviews court document$") public void
		 * compensator_reviews_court_document()throws Throwable {
		 * 
		 * CompensatorDecisionPage review = new CompensatorDecisionPage();
		 * review.compReviewSelectCourtDocs(); }
		 */
		
		/* TPA should not be able change liability decision */
		@Given("^the claim is reopened by the claimant$")
		public void the_claim_is_reopened_by_the_claimant()throws Throwable
		{
			MIBLoginPage.login("tpa");
		}
		@When("^TPA tries to change the liability decision$")
		public void tpa_tries_to_change_the_liability_decision()throws Throwable
		{
			TPApage link = new TPApage();
			 link.verifyLiabilityLink();
		}		
		@Then("^the link should not be present$")
		public void the_link_should_not_be_present()throws Throwable
		{
			TPApage exit = new TPApage();
			 exit.logout();
		}
		
		/* TPA should not be able to add losses/fee */
		@When("^TPA tries to add loss/fee$")
		public void tpa_tries_to_add_loss_fee()throws Throwable
		{
			TPApage link = new TPApage();
			 link.verifyAddLoss();
		}
		@Then("^TPA should not be allowed to add loss/fee$")
		public void tpa_should_not_be_allowed_to_add_loss_fee()throws Throwable
		{
			TPApage exit = new TPApage();
			 exit.logout();
		}
		
		/* TPA makes replacement offer */
		@Given("^TPA has withdrawn the first offer$")
		public void tpa_has_withdrawn_the_first_offer()throws Throwable
		{
			MIBLoginPage.login("tpa");
		}
		@When("^replacement offer is made to claimant$")
		public void replacement_offer_is_made_to_claimant()throws Throwable
		{
			TPApage replace = new TPApage();
			 replace.replaceOffer();
		}
		
		/* TPA accepts the request for further medical report */
		@Given("^claimant has given a request medical report$")
		public void claimant_has_given_a_request_medical_report()throws Throwable
		{
			MIBLoginPage.login("tpa");
		}
		@When("^TPA provides the consent for obtaining further medical report$")
		public void tpa_provides_the_consent_for_obtaining_further_medical_report()throws Throwable
		{
			TPApage mr = new TPApage();
			mr.reviewFurtherMedReportReq();
		}
		@Then("^TPA decision is sent to the claimant$")
		public void tpa_decision_is_sent_to_the_claimant()throws Throwable
		{
			TPApage exit = new TPApage();
			 exit.logout();
		}
		
		
		/* TPA provides updated financial offer */
		@Given("^claimant has added more losses and proceeds to offer$")
		public void claimant_has_added_more_losses_and_proceeds_to_offer()throws Throwable
		{
			MIBLoginPage.login("tpa");
		}
		@When("^TPA provides updated financial offer$")
		public void tpa_provides_updated_financial_offer()throws Throwable
		{
			CompensatorOfferPage fin = new CompensatorOfferPage();
			 fin.compUpdateOfferFinancial();
		}
		
		
		@Given("^TPA has acknowledged$")
		public void tpa_has_acknowledged()throws Throwable
		{
			MIBLoginPage.login("tpa");		
		}
		/* Compensator disputes causation at offer */
		
		@Given("^claimant has request for an offer$")
		public void claimant_requested_for_an_offer()throws Throwable
		{
			MIBLoginPage.login("tpa");
		}
		@When("^TPA disputes causation and make final offer$")
		public void compensator_disputes_causation_make_final_offer()throws Throwable
		{
			CompensatorOfferPage fin = new CompensatorOfferPage();
			 fin.disputeCausationFinalOffer();
		}

}

