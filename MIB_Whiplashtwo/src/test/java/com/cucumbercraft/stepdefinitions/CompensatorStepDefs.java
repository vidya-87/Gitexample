package com.cucumbercraft.stepdefinitions;

import com.cucumbercraft.pages.CompensatorDecisionPage;
import com.cucumbercraft.pages.CompensatorOfferPage;
import com.cucumbercraft.pages.CompensatorPage;
import com.cucumbercraft.pages.MIBLoginPage;
import com.cucumbercraft.pages.TPApage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
public class CompensatorStepDefs{

	//static Logger Log = Logger.getLogger(GeneralStepDefs.class);


	/* Compensator Login */

	@Given("^Claim  is sent to the compensator$")
	public void claim_is_sent_to_the_compensator() throws Throwable 
	{

		MIBLoginPage.login("compensator");

	}
	/*Compensator withdraws and reject the offer*/
	@When("^compensator withdraws the offer and rejects the offer$")
	public void compensator_withdraws_the_offer_and_rejects_the_offer()throws Throwable
	{
		CompensatorOfferPage withdraw = new CompensatorOfferPage();
		withdraw.compWithdrawOfferAndReject();
	}
	@Then("^the claim moves to withdrawal status$")
	public void the_claim_moves_to_withdrawal_status()throws Throwable
	{
		CompensatorOfferPage logout = new CompensatorOfferPage();
		logout.logout();

	}
	/*Compensator reassigned login*/
	@Given("^Claim  is reassigned to another compensator$")
	public void claim_reassigned_to_another_compensator() throws Throwable
	{
		MIBLoginPage.login("compensator");
	}

	/* Compensator receives Claim and claim Liability transferred to TPA */

	@When("^compensator receives claim and send to TPA$")
	public void compensator_receives_claim_send_TPA()throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.tpaTransfer();

	}
	@Then("^claims acceptance and liability decision is now sent to TPA$")
	public void claims_acceptance_liability_decision_sent_TPA() throws Throwable
	{ 
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.logout();
		System.out.println("The claim is transferred to TPA for decision");
	}

	/* Compensator Accept Claim and makes full liability with dispute */


	@Then("^the claims acceptance and liability is now sent to the claimant$")
	public void claim_full_liability_sent_claimant() throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.logout();
	}

/* Compensator transfers claim to Another compensator */
	
	@When("^compensator transfer claim to compensatorB$")
	public void compensator_transfer_claim_to_compensatorB() throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.compTransfer();

	}
	
	@Then("^the claim is sent to CompensatorB$")
	public void the_claim_is_sent_to_CompensatorB() throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.logout();
	}
	
	
	
	/*Compensator B accepts transfer request */
	
	@Given("^Transfer request sent to CompensatorB$")
	public void transfer_request_sent_to_CompensatorB() throws Throwable {
		MIBLoginPage.login("compensatorB");

	   
	}

	@When("^compensatorB accepts transfer request$")
	public void compensatorb_accepts_transfer_request() throws Throwable {
		
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.acceptTransfer();

	}

	@Then("^claim moved to CompensatorB workbasket$")
	public void claim_moved_to_CompensatorB_workbasket() throws Throwable {
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.logout();
	    
	}
	
	/*Compensator B rejects transfer request */
	
	@When("^compensatorB rejects transfer request$")
	public void compensatorb_rejects_transfer_request() throws Throwable {
		
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.rejectTransfer();
	}
	
	@Then("^claim not moved to CompensatorB workbasket$")
	public void claim_not_moved_to_CompensatorB_workbasket() throws Throwable {
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.logout();
	    
	}
	
	
	/* Compensator Accept Claim and makes full liability without dispute */

	@When("^compensator accepts claim and makes full liability without dispute$")
	public void compensator_liability_without_dispute()throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.full_Liability_Wo_Dispute();

	}
	
	 /*Compensator B accepts liability*/
	
	
		@Given("^Claim in compensatorB workbasket$")
		public void Claim_in_compensatorB_workbasket() throws Throwable {
			MIBLoginPage.login("compensatorB");
		}

	/* Compensator Accept Claim and makes full liability with dispute */

	@When("^compensator accepts claim and makes part liability with dispute$")
	public void compensator_part_liability_with_dispute()throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.partialLiabilityCausation();

	}
	@When("^compensator accepts claim and makes full liability with dispute$")
	public void compensator_full_liability_with_dispute()throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.fullLiabilityCausation();

	}
	@When("^compensator accepts claim and makes part liability$")
	public void compensator_part_liability()throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.partialLiabilityWODispute();

	}

	/* Compensator denies full liability */
	@When("^compensator denies full liability$")
	public void compensator_denies_full_liability()throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.deniedLiability();

	}

	/* Compensator makes first offer to claimant */


	@When("^the compensator makes first offer$")
	public void the_compensator_makes_first_offer()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.compFirstOffer();

	}
	@When("^the compensator makes first offer to MIBpro$")
	public void the_compensator_makes_first_offer_mibpro()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.compFirstOfferMIBpro();
	}
	/* compensator reject claimant counter and makes new offer */
	@Given("^compensator rejects counter offer$")
	public void compensator_rejects_counter_offer()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}
	@When("^the compensator makes new offer$")
	public void the_compensator_makes_new_offer()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.revisedOfferToClaimant();

	}
	
	@When("^revised offer is sent to the claimant$")
	public void the_compensator_send_revised_offer()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.revisedOfferToClaimant();

	}
	@When("^final counter offer is reject$")
	public void reject_final_counter_offer()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.rejectFinalCounterOffer();
	}
	@Then("^offer is sent to claimant$")
	public void first_offer_claimant()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.logout();

	}
	@Then("^claim is sent to claimant$")
	public void claim_sent_to_claimant()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.logout();

	}
	@Then("^claim SLA is breached$")
	public void claim_sla_breached()throws Throwable
	{
		TPApage sla = new TPApage();
		sla.slaBreached();
	}

	@Given("^claimant proceed with offer$")
	public void claimant_proceed_with_offer()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}
	
	/* Compensator disputes causation at offer */
	@When("^Compensator disputes causation at offer$")
	public void compensator_disputes_causation_at_offer()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.disputeCausationOffer();
	}
	
	
	/* Make offer with uplift rejected*/
	@When("^compensator makes first offer with loss added and disagree uplift$")
	public void compensator_makes_first_offer_with_loss_disagree_uplift()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.compFirstOfferWithUplift("REJECT");
	}

	/* Make offer with uplift Accepted*/
	@When("^compensator makes first offer with loss uplift$")
	public void compensator_makes_first_offer_with_loss_uplift()throws Throwable
	{
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.compFirstOfferWithUplift("ACCEPT");
	}


	/* Compensator make first offer with fee prop */

	@Given("^claimant requests offer$")
	public void unrep_selected_documents()
	{
		MIBLoginPage.login("compensator");
	}
	@When("^the compensator makes first offer with fee proposal$")
	public void compensator_makes_first_offer_with_fee_proposal_mibprouser()throws Throwable
	{
		CompensatorOfferPage firtsofferwithfee = new CompensatorOfferPage();
		firtsofferwithfee.compFirstOfferWithFeeProposal();
	}

	/* Compensator Acknowledge claim withdrawal */

	@Given("^the MIB prouser claimant has withdrawn claim$")
	public void mibpro_has_withdrawn_the_claim()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}

	@When("^Compensator acknowledges claimants withdrawal$")
	public void compensator_acknowledges_claimants_withdrawal()throws Throwable
	{
		CompensatorDecisionPage ack = new CompensatorDecisionPage();
		ack.compensatorACKWithdraw();
	}


	@When("^Compensator acknowledges claimants offer with claim '(.*)'$")
	public void compensator_acknowledges_claimants_offer(String status)throws Throwable
	{
		CompensatorDecisionPage ack = new CompensatorDecisionPage();
		ack.compensatorACK(status);
	}

	@Then("^the claim can be Resolved$")
	public void claim_resolved()throws Throwable
	{
		CompensatorDecisionPage ack = new CompensatorDecisionPage();
		ack.logout();
	}

	/*Compensator reject claim*/
	@When("^compensator rejects claim to '(.*)'$")
	public void compensator_reject_claim_csr(String user)throws Throwable
	{
		CompensatorDecisionPage reject = new CompensatorDecisionPage();
		// reject.rejectclaim(user);

	}
	@Then("^claim sent to CSR$")
	public void claim_sent_CSR()throws Throwable
	{
		CompensatorDecisionPage reject = new CompensatorDecisionPage();
		reject.logout();
	}

	/*Compensator reject interim payment*/
	@When("^Compensator reject interim payment$")
	public void compensator_reject_interim_payment()throws Throwable
	{
		CompensatorPage interim = new CompensatorPage();
		interim.rejectInterim();
	}

	/*Compensator makes interim payment*/

	@Given("^claimant request interm payment to compensator$")
	public void request_interim_payment_compensator() throws Throwable
	{
		MIBLoginPage.login("compensator"); 
	}
	@When("^compensator makes interim payment$")
	public void compensator_makes_interim_payment()throws Throwable
	{
		CompensatorDecisionPage pay = new CompensatorDecisionPage();
		pay.makeInterimPayment();
	}

	@When("^compensator accepts reduced interim payment$")
	public void compensator_accepts_reduced_interim_payment()throws Throwable
	{
		CompensatorDecisionPage pay = new CompensatorDecisionPage();
		pay.reducedInterimPayment();
	}
	@Then("^claimant receives interim payment$")
	public void claimant_receives_interim_payment() throws Throwable
	{
		CompensatorDecisionPage pay = new CompensatorDecisionPage();
		pay.logout();
	}

	/*Compensator Accepts revised offer from claimant*/

	@Given("^Claimant requested for revised offer$")
	public void claimant_requested_revised_offer()throws Throwable
	{
		MIBLoginPage.login("compensator"); 
	}

	/* Compensator Accepts counter offer with uplift*/
	@When("^Compensator agrees to 'UPLIFT' and  makes revised offer with UPLIFT taken in to consideration$")
	public void compensator_accepts_revised_offer()throws Throwable
	{
		CompensatorOfferPage revised = new CompensatorOfferPage();
		revised.acceptCounterOffer();
	}
	/* Compensator Accepts counter offer from claimant*/
	@When("^Compensator accepts claimant counter offer$")
	public void compensator_accepts_counter_offer()throws Throwable
	{
		CompensatorOfferPage counter = new CompensatorOfferPage();
		counter.acceptCounterOffer();
	}

	@Then("^counter offer is sent to claimant for review$")
	public void second_offer_no_uplift_sent_claimant()throws Throwable
	{
		CompensatorOfferPage counter = new CompensatorOfferPage();
		counter.logout();
	}

	/* Compensator Accept Claim and makes no claim Liability and SLA breached */
	@When("^compensator accepts claim and makes no liability decision$")
	public void tpa_accept_claim_makes_no_liability_decision() throws Throwable
	{
		TPApage claim = new TPApage();
		claim.acceptclaim();		
	}

	/*Compensator rejects UPLIFT request and makes First offer to claimant*/
	@When("^Compensator disagrees to an UPLIFT and makes first offer$")
	public void tpa_disagree_uplift_makes_offer() throws Throwable
	{
		TPApage offer = new TPApage();
		offer.disagreeUpliftAndMakeOffer();


	}

	/* Compensator send second offer made with no UPLIFT consideration */   
	@When ("^Compensator decides not to include  UPLIFT amount in second offer$")
	public void no_uplift_second_offer()throws Throwable
	{
		TPApage offer = new TPApage();
		offer.secondOfferWithNoUplift();
	}

	/* Compensator responds to NVC questions */ 
	@Given("^Compensator receives claim to review NVC answers$")
	public void tpa_review_nvc_answers()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}
	@When("^Compensator responds to NVC answers$")
	public void tpa_respond_nvc_answers()throws Throwable
	{
		TPApage nvc = new TPApage();
		nvc.respondNVC();
		nvc.slaBreached();
	}
	/* Compensator agrees to court documents uploaded & claim closed */

	@Given("^claimant selects court documents compensator$")
	public void claimant_select_court_docs()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}

	@When("^Compensator agrees to court documents when claim is in '(.*)'$")
	public void compensator_agree_court_documents(String status)throws Throwable
	{
		CompensatorPage agree = new CompensatorPage();
		agree.agreeCourtDocs(status);

	}

	/* compensator updates liability */
	@Given("^the claim liability decision has been challenged by claimant$")
	public void claim_liability_decision_claimant()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}
	@When("^compensator updates liability$")
	public void compensator_updates_liability()throws Throwable
	{
		CompensatorDecisionPage liability = new CompensatorDecisionPage();
		liability.review_liabilitychallenge();
	}

	@Then("^Updated liability information will be sent to claimant$")
	public void liability_information_sent_to_claimant()throws Throwable
	{
		CompensatorDecisionPage liability = new CompensatorDecisionPage();
		liability.logout();
	}


	/* TPA updates liability */
	@Given("^liability decision was challenged by claimant$")
	public void liability_decision_was_challenged_by_claimant()throws Throwable
	{
		MIBLoginPage.login("tpa");
	}
	@When("^TPA updates liability$")
	public void tpa_updates_liability()throws Throwable
	{
		CompensatorDecisionPage liability = new CompensatorDecisionPage();
		liability.review_liabilitychallenge();
	}

	@Then("^TPA sends changed liability decision to claimant$")
	public void tpa_sends_changed_liability_decision_to_claimant()throws Throwable
	{
		CompensatorDecisionPage liability = new CompensatorDecisionPage();
		liability.logout();
	}




	@Then("^report will be sent for claimant approval$")
	public void report_will_be_sent_for_claimant_approval()throws Throwable
	{
		CompensatorDecisionPage upload = new CompensatorDecisionPage();
		upload.logout();
	}



	/* Compensator reviews court document for secondary action(Interim) */
	@Given("^claimant goes to court$")
	public void claimant_goes_to_court()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}

	/*
	 * @When("^Compensator reviews court document$") public void
	 * compensator_reviews_court_document()throws Throwable {
	 * 
	 * CompensatorDecisionPage review = new CompensatorDecisionPage();
	 * review.compReviewSelectCourtDocs(); }
	 */
	@When("^Compensator reviews court document for interim$")
	public void compensator_reviews_court_document_interim()throws Throwable
	{

		CompensatorDecisionPage review = new CompensatorDecisionPage();
		review.compReviewSelectCourtDocsInterim();
	}
	@Then("^court docs sent for review to claimant$")
	public void court_sent_for_review_to_claimant()throws Throwable
	{
		CompensatorDecisionPage review = new CompensatorDecisionPage();
		review.logout();
	}

	/* Compensator reopens claim and accepts full claim liability */
	@Given("^claimant uploads court documents$")
	public void claimant_uploads_court_documents()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}
	@When("^compensator reopens liability disputed claim$")
	public void compensator_repoens_liability_disputed_claim()throws Throwable
	{
		CompensatorPage reopen = new CompensatorPage();
		reopen.reopenClaimAfterCourt();
	}
	@Then("^compensator accepts full liability$")
	public void compensator_accepts_full_liability()throws Throwable
	{
		CompensatorDecisionPage reopen = new CompensatorDecisionPage();
		reopen.logout();

	}
	@Then("^claim sent to mib prouser claimant for documents upload$")
	public void claim_sent_to_mibprouser()throws Throwable
	{
		CompensatorDecisionPage comp = new CompensatorDecisionPage();
		comp.logout();
	}

	public void claim_sent_to_mibprouserclaimant_for_acknowledgement()throws Throwable
	{
		CompensatorDecisionPage mibcourtdocsapproved = new CompensatorDecisionPage();
		mibcourtdocsapproved.logout();
	}

	/* Compensator terminates the claim */

	@Given("^compensator makes first offer to claimant$")
	public void compensator_makes_first_offer_to_claimant()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}
	@When("^the compensator removes the claim from portal$")
	public void compensator_terminates_the_claim()throws Throwable
	{
		CompensatorDecisionPage terminate = new CompensatorDecisionPage();
		terminate.removeClaim();
	}
	@Then("^the claim is removed from portal and closed$")
	public void claim_removed_from_portal()throws Throwable
	{
		CompensatorDecisionPage terminate = new CompensatorDecisionPage();
		terminate.logout();
	}
	
	/* The removed claim should be sent to resolved claim */
 	@Given("^the compensator has removed the claim$")
 	public void the_compensator_has_removed_the_claim()throws Throwable
 	{
 		MIBLoginPage.login("compensator");
 	}
 	@When("^claim is moved to resolved$")
 	public void claim_is_moved_to_resolved()throws Throwable
 	{
 		CompensatorDecisionPage closed = new CompensatorDecisionPage();
		closed.verifyResolvedClaim("Resolved-Removed");
 		
 	}
 	
 	@When("^claimant has accepted the rejected liability$")
 	public void claim_is_in_resolved()throws Throwable
 	{
 		CompensatorDecisionPage closed = new CompensatorDecisionPage();
		closed.verifyResolvedClaim("Resolved-RejectedLiability");
 		
 	}
 	@Then("^claim is successfully removed$")
 	public void claim_is_successfully_removed()throws Throwable
 	{
 		CompensatorDecisionPage terminate = new CompensatorDecisionPage();
		terminate.logout();
 	}
 	
 	@Then("^claim is successfully resolved$")
 	public void claim_is_successfully_resolved()throws Throwable
 	{
 		CompensatorDecisionPage terminate = new CompensatorDecisionPage();
		terminate.logout();
 	}
 	

	/* Verify the claim is moved to Resolved status */
	@Given("^the compensator has acknowledged$")
	public void compensator_has_acknowledged()throws Throwable
	{
		MIBLoginPage.login("compensator");		
	}
	@When("^claim '(.*)' is verified$")
	public void claim_status_is_verified(String status)
	{
		CompensatorDecisionPage closed = new CompensatorDecisionPage();
		closed.verifyResolvedClaim(status);
 		
	}
	@Then("^claim is moved to resolved status successfully$")
	public void claim_is_moved_to_resolved_status_successfully()throws Throwable
	{
		
	}

	/* Compensator makes fee proposal */
	@Given("^claimant has requested for fee$")
	public void claimant_has_requested_for_fee()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}
	@When("^compensator make fee proposal$")
	public void compensator_make_fee_proposal()throws Throwable
	{
		CompensatorOfferPage revised = new CompensatorOfferPage();
		revised.compFeeProposal();
	}
	@Then("^fee proposal is sent to claimant$")
	public void fee_proposal_is_sent_to_claimant()throws Throwable
	{
		CompensatorDecisionPage exit = new CompensatorDecisionPage();
		exit.logout();
	}
	
	/* TPA accepts the request for further medical report */
	@Given("^claimant has given a request for further medical report$")
	public void claimant_has_given_a_request_medical_report()throws Throwable
	{
		MIBLoginPage.login("compensator");
	}
	@When("^Compensator provides the consent for obtaining further medical report$")
	public void tpa_provides_the_consent_for_obtaining_further_medical_report()throws Throwable
	{
		TPApage mr = new TPApage();
		mr.reviewFurtherMedReportReq();
	}
	
	@When("^Compensator denies the consent for obtaining further medical report$")
	public void tpa_denies_the_consent_for_obtaining_further_medical_report()throws Throwable
	{
		TPApage mr = new TPApage();
		mr.rejectFurtherMedReportReq();
	}
	@Then("^Compensator decision is sent to the claimant$")
	public void tpa_decision_is_sent_to_the_claimant()throws Throwable
	{
		TPApage exit = new TPApage();
		 exit.logout();
	}
	/*Compensator rejects claimants fee offer*/
	@When("^compensator rejects claimant fee offer$")
	public void compensator_rejects_claimant_fee_offer()throws Throwable
	{
		CompensatorOfferPage reject = new CompensatorOfferPage();
		reject.rejectFeeProposal();
	}
	
	/*compensator does not update the offer*/
	@Then("^compensator does not update the offer$")
	public void compensator_does_not_update_the_offer()throws Throwable
	{
		CompensatorOfferPage update = new CompensatorOfferPage();
		update.offerNotUpdated();
	}
	
	
	/*
	 * Author: Sourav Dutta
	 */
	
	@Given("^Compensator login for provide offer$")
	public void compensator_login_for_provide_offer() throws Throwable {
		MIBLoginPage.login("compensator");
	    
	}

	@When("^Compensator decided to make offer with non whiplash injury$")
	public void compensator_decided_to_make_offer_with_non_whiplash_injury() throws Throwable {
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.OfferwithNonWhiplash();
	}

	@Then("^compensator sent offer to claimant$")
	public void compensator_sent_offer_to_claimant() throws Throwable {
		CompensatorDecisionPage exit = new CompensatorDecisionPage();
		exit.logout();
	}
	
	@When("^Compensator rejected claimant NON Whiplash challenge$")
	public void compensator_rejected_claimant_NON_Whiplash_challenge() throws Throwable {
		CompensatorOfferPage challenge = new CompensatorOfferPage();
		challenge.CompRespondChallengeNONWhip("Reject");
		
	}
	
	@When("^Compensator accepted claimant NON Whiplash challenge$")
	public void compensator_accepted_claimant_NON_Whiplash_challenge() throws Throwable {
		CompensatorOfferPage challengeAccept = new CompensatorOfferPage();
		challengeAccept.CompRespondChallengeNONWhip("Accept");
		
	}

	@When("^Compensator make replacement offer with tariff amount$")
	public void compensator_make_replacement_offer_with_tariff_amount() throws Throwable {
		CompensatorOfferPage replace = new CompensatorOfferPage();
		replace.CompReplaceofferNonWhip();
	}

	@When("^Compensator decided to make offer with non whiplash injury and disagree uplift$")
	public void compensator_decided_to_make_offer_with_non_whiplash_injury_and_disagree_uplift() throws Throwable {
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.OfferwithNonWhiplashUplift("REJECT","No");
	}
	
	/*
	 * Author: Sourav Dutta 
	 * Comment: Sprint 41 changes
	 */
	
	@When("^the TPA makes first offer with NON whiplash injury with uplift$")
	public void the_TPA_makes_first_offer_with_NON_whiplash_injury_with_uplift() throws Throwable {
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.OfferwithNonWhiplashUplift("ACCEPT","No");
	}
	
	@Then("^documents sent to TPA$")
	public void documents_sent_to_TPA() throws Throwable {
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.logout();
	}
	
	/*
	 *Author: P Vidya
	 *Sprint 41 changes 
	 */
	
	@When("^Compensator responds NVC$")
	public void tpa_respond_nvc()throws Throwable
	{
		TPApage nvc = new TPApage();
		nvc.respondNVC();
	}
	
	@When("^Compensator makes first offer with NON whiplash injury with uplift$")
	public void Compensator_makes_first_offer_with_NON_whiplash_injury_with_uplift() throws Throwable {
		CompensatorOfferPage offer = new CompensatorOfferPage();
		offer.OfferwithNonWhiplashUplift("ACCEPT","No");
	}	

}