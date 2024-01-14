package com.cucumbercraft.stepdefinitions;

import com.cucumbercraft.pages.ClaimantActionsPage;
import com.cucumbercraft.pages.CsrPage;
import com.cucumbercraft.pages.MIBLoginPage;
import com.cucumbercraft.pages.MIBProActionsPage;
import com.cucumbercraft.pages.ProUserActionsPage;
import com.cucumbercraft.pages.ProUserClaimCreationPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class ProUserActionsStepDefs

{

	/* Prouser claim creation */

	@Given("^prouser logins into whiplash application$")
	public void prouser_logins_into_whiplash_applicataion_using() throws Throwable {
		MIBLoginPage.login("prouser");

	}

	@When("^prouser enter all mandatory details for claim creation as '(.*)' and '(.*)' and '(.*)'$")
	public void prouser_Enter_All_Mandatory_Details_For_Claim_Creation(String involvement_type_v, String owner,
			String multivrn) throws Throwable {
		ProUserClaimCreationPage claim = new ProUserClaimCreationPage();
		claim.proClaimCreation(involvement_type_v, owner, multivrn);
	}

	@Then("^claim is created for prouser$")
	public void claim_Is_Created() throws Throwable {
		ProUserClaimCreationPage claim = new ProUserClaimCreationPage();
		claim.endOfSubmitClaim();

	}

	@Then("^prouser exits before submitting claim$")
	public void prouser_exits_before_submitting_claim() throws Throwable {
		ProUserClaimCreationPage claim = new ProUserClaimCreationPage();
		claim.exitBeforeSubmitClaim();
	}
	
	@Then("^prouser submits the claim successfully$")
	public void prouser_submits_claim_successfully()throws Throwable
	{
		ProUserClaimCreationPage claim = new ProUserClaimCreationPage();
		claim.continueClaimSubmission();
		
	}

	/* prouser uploads medical report */

	@When("^prouser uploads the medical report with waitout prognosis '(.*)'$")
	public void claimant_upload_medical_report_waitout(String status) throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.uploadMRWaitoutPrognosis(status);

	}

	@When("^prouser uploads the medical report with waitout prognosis '(.*)' and decides to waitout$")
	public void claimant_upload_medical_report(String status) throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.uploadMRWaitoutPrognosisAndWaits(status);

	}

	/* Prouser reject offer and goes to court */
	@When("Prouser rejects offer and goes to court")
	public void prouser_rejects_offer_and_goes_to_court() throws Throwable {
		ProUserActionsPage court = new ProUserActionsPage();
		court.rejectOfferGoesToCourt();
	}

	@Then("^claim is rejected by claimant$")
	public void claim_is_rejected_by_claimant() throws Throwable {
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.logout();
	}

	/* prouser selects court documents after rejecting offer */
	@Given("^Claimant and rejected the offer and goes to court$")
	public void claimant_reject_offer_go_to_court() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("prouser selects court documents for reject offer")
	public void prouser_selects_court_docs_for_reject_offer() throws Throwable {
		ProUserActionsPage court = new ProUserActionsPage();
		court.rejectOfferselectCourtDoc();
	}

	@Then("court documents are sent to TPA")
	public void court_documents_are_sent_to_tpa() throws Throwable {
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.logout();
	}

	/* Prouser proceeds with offer during prognosis period */
	@Given("^claimant is in prognosis period$")
	public void claimant_is_in_prognosis_period() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^claimant decides to proceed with offer during prognosis period$")
	public void claimant_decides_to_proceed_with_offer_during_prognosis_period() {
		ProUserActionsPage offer = new ProUserActionsPage();
		offer.waitoutPrognosisProceedOffer();
	}

	@Then("first offer is sent to TPA")
	public void first_offer_is_sent_to_tpa() throws Throwable {
		ProUserActionsPage exit = new ProUserActionsPage();
		exit.logout();
	}

	/* claimant decides to wait out during offer and upload new report */
	@When("^claimant indicates completion of waitout period and upload new report$")
	public void claimant_decides_to_waitout_and_upload_new_report() throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.waitoutNewReportAtOffer();
	}

	/* verify resolved claim status */
	@When("^prouser claim status is '(.*)'$")
	public void claim_goes_to_dispute_at_court(String status) throws Throwable {
		ProUserActionsPage stat = new ProUserActionsPage();
		stat.resolvedStatus(status);
	}

	@When("^prouser claim goes to dispute at court at '(.*)'$")
	public void prouser_claim_goes_to_dispute_at_court(String status) throws Throwable {
		ProUserActionsPage stat = new ProUserActionsPage();
		stat.resolvedStatus(status);
	}

	@Then("^report is uploaded and sent to compensator$")
	public void report_sent_to_compensator() throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.logout();

	}

	/*
	 * Claimant decides waitout at offer stage and uploads new medical report and
	 * proceeds with offer
	 */
	@When("^claimant decides to waitout period and upload new report$")
	public void claimant_decides_waitout_period_upload_new_report() throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.waitoutAtOffer();
		report.waitoutNewReportProceedOffer();

	}

	@When("^claimant decides to proceed with offer during prognosis period with new medical report$")
	public void claimant_offer_waitout_prognosis() throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.offerAtWaitoutAddedLoss();

	}

	/* Prouser decides wait out and adds loss */
	@When("^Claimant decides to waitout$")
	public void claimant_decides_to_waitout() throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.waitoutAtOffer();
	}

	@And("^Prouser adds loss$")
	public void prouser_adds_loss() throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.addLoss();
	}

	@Then("^Prouser is is in waitout period$")
	public void prouser_waitout_period() throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.logout();
	}

	/* Prouser withdraws claim */
	@When("^the claimant then decides to withdraw the claim at '(.*)'$")
	public void prosuer_claimant_withdraw_claim(String status) throws Throwable {
		ProUserActionsPage withdraw = new ProUserActionsPage();
		withdraw.withDrawClaim(status);
	}

	/* Prouser challenge liability decision and goes to court */

	@Given("^Prouser claim liability has been rejected$")
	public void prouser_claim_liability_rejected() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^prouser wants to challenge decision and decided to go to court$")
	public void prouser_challenge_decision_go_to_court() throws Throwable {
		ProUserActionsPage decision = new ProUserActionsPage();
		decision.prouserGoToCourtRejectLiability();
	}

	/*
	 * prouser Claimant acknowledges Compensators doc selection and case is resolved
	 */
	@Given("^prouser receives claim for acknowledgement$")
	public void prouser_receives_the_claim_for_acknowledgement() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^prouser claimant acknowledge for liability challenge$")
	public void prouser_acknowledge_liability_challenge() throws Throwable {
		ProUserActionsPage ack = new ProUserActionsPage();
		ack.prouserDisputeAckLiability();
	}

	/* Claimant decides to reopen the claim */
	@Given("^Prouser claim was resolved at court$")
	public void court_has_resolved() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^Prouser reopens liability disputed claim$")
	public void claimant_reopens_liability_disputed_claim() throws Throwable {
		ProUserActionsPage reopen = new ProUserActionsPage();
		reopen.prouserReopenClaimLiability();
	}

	@Then("^Prouser reopens the claims sucessfully$")
	public void prouser_reopens_the_claim() throws Throwable {
		MIBProActionsPage unrep = new MIBProActionsPage();
		unrep.logout();
	}

	/* prouser withdraw and replace offer */
	@Given("^Prouser has rejected offer to TPA$")
	public void compensatoe_doesnot_accept_the_offer_for_more_than_days() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@Then("^Prouser withdraw the offer and replace with new offer$")
	public void prouser_withdraw_the_offer_and_replace_with_new_offer() throws Throwable {
		ProUserActionsPage offer = new ProUserActionsPage();
		offer.prouserWithdrawAndReplaceOffer();
	}

	/* prouser Claimant requests for revised offer */
	@Given("^prouser claimant received first offer from TPA$")
	public void prouserclaimant_received_first_offer_from_compensator() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^prouser Claimant requests for revised offer$")
	public void prouser_requests_for_revised_offer() throws Throwable {
		ProUserActionsPage offer = new ProUserActionsPage();
		offer.prouserRequestForRevisedOffer();
	}

	/* prouser goes to court for claim settlement pending OCS3 */
	@Given("^SLA is breached for non-payment$")
	public void sla_breached_non_payment() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^prouser decides to go to court for claim settlement pending$")
	public void prouser_go_to_court_select_court_document() throws Throwable {
		ProUserActionsPage court = new ProUserActionsPage();
		court.prouserGotoCourtOptionOCS3();
	}

	@When("^prouser decides to go to court for fee settlement pending$")
	public void prouser_go_to_court_fee_nonpayment_document() throws Throwable {
		ProUserActionsPage court = new ProUserActionsPage();
		court.gotoCourtFeeSettlement();
	}

	/* prouser Claimant select court docs */
	@Given("^prouser Claimant receives the claim for document selection$")
	public void prouser_receives_the_claim_for_document_selection() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@Then("^claim sent to compensator for reviewing documents selected$")
	public void prouser_claim_sent_to_compensator_for_review_court_docs() throws Throwable {
		ClaimantActionsPage docs = new ClaimantActionsPage();
		docs.logout();
	}

	/*
	 * Compensator doesnot respond to the counter offer request made by claimant and
	 * claimant goes to court
	 */
	@Given("^TPA doesnot respond to the claimant counter offer request$")
	public void compensator_does_not_respond_to_the_counter_offer() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^prouser claimant goes to court$")
	public void prouser_goes_to_court() throws Throwable {
		ProUserActionsPage court = new ProUserActionsPage();
		court.prouserGotoCourtOcs2();
	}

	@Then("^claim will be sent to TPA with revised offer$")
	public void mibprouser_sent_claim_to_compensator_for_revised_offer() throws Throwable {
		ProUserActionsPage exit = new ProUserActionsPage();
		exit.logout();
	}

	/* Claimant acknowledges court documents */
	@When("^prouser submit the claim for court and select witness at '(.*)$")
	public void claimant_submit_claim_to_court_add_witness(String status) throws Throwable {
		ProUserActionsPage ack = new ProUserActionsPage();
		ack.prouserWitnessAckCourtDocs(status);

	}

	@When("^prouser submit the claim for NVC court and select witness at '(.*)$")
	public void claimant_submit_claim_NVC_court_add_witness(String status) throws Throwable {
		ProUserActionsPage ack = new ProUserActionsPage();
		ack.prouserNVCAckCourtDocs(status);

	}

	/* Claimant accepts Denial & case resolved */
	@When("^Claimant accepts denial$")
	public void claimant_Accepts_Denial() throws Throwable {
		ProUserActionsPage user = new ProUserActionsPage();
		user.acceptDenial();
	}

	/* Prouser goes to court for fee proposal */
	@Given("^Prouser reject fee proposal$")
	public void prouser_reject_fee_proposal() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^prouser claimant goes to court over fee proposal$")
	public void prouser_goes_to_court_for_fee_proposal() throws Throwable {
		ProUserActionsPage court = new ProUserActionsPage();
		court.prouserGotoCourtOcs4();
	}

	/* Prouser rejects fees and goes to court */
	@When("^prouser reject fee offer and goes to court$")
	public void prouser_reject_fee_proposal_go_to_court() throws Throwable {
		ProUserActionsPage court = new ProUserActionsPage();
		court.RejectFeeOfferAndGoToCourt();
	}

	/* Prouser Accept Offer and Reject fee proposal */

	@Given("^prouser review fee proposal$")
	public void mibpro_review_fee_proposal() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^prouser accepts offer and makes counter fees proposal$")
	public void mibpro_accepts_offer_reject_fees_proposal() throws Throwable {
		ProUserActionsPage counterfee = new ProUserActionsPage();
		counterfee.prouserAcceptOfferRejectfee();
	}

	@Then("^pro counter offer sent to compensator$")
	public void mibpro_counter_offer_sent_compensator() throws Throwable {
		ClaimantActionsPage counterfee = new ClaimantActionsPage();
		counterfee.slaBreached();
	}

	@Then("^case is closed at court stage$")
	public void claim_sent_to_prouser_acknowledgement() throws Throwable {
		ProUserActionsPage exit = new ProUserActionsPage();
		exit.logout();
	}

	/* prouser upload medical report */
	@When("^claimant uploads medical report and requests an UPLIFT due to EXCEPTIONAL CIRCUMSTANCES$")
	public void medical_report_with_uplift() throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.uploadReport("UPLIFT_YES");
	}

	@When("^claimant uploads only medical report at '(.*)'$")
	public void prouser_medical_report_only(String status) throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.uploadReportOnly(status);
	}

	@When("^claimant uploads medical report at '(.*)'$")
	public void medical_report_prouser(String status) throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.uploadReport(status);
	}

	@When("^claimant uploads medical report and submits an UPLIFT due to EXCEPTIONAL CIRCUMSTANCES$")
	public void medical_report_with_uplift_submitted() throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.uploadReport("UPLIFT_YES_SUBMIT");
	}

	/* MIBpro accepts the decision and no offer is made */
	@Given("^TPA has disputed causation for prouser$")
	public void compensator_has_disputed_causation() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^Prouser accepts the dispute causation no offer$")
	public void mibpro_accepts_the_dispute_no_offer() throws Throwable {
		ProUserActionsPage dispute = new ProUserActionsPage();
		dispute.prouserCausationDisputeOffer();
	}

	@When("^Prouser reject the dispute causation final offer$")
	public void mibpro_reject_the_dispute_final_offer() throws Throwable {
		ProUserActionsPage dispute = new ProUserActionsPage();
		dispute.prouserRejectcausationDisputeFinalOffer();
	}

	/* prouser Claimant reviews medical report and proceed to offer */
	@Given("^claimant has upload the medical report successfully$")
	public void prouser_received_the_reports_from_dme() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^claimant reviews medical report and proceed to offer$")
	public void prouse_reviews_rmedical_report_and_proceed_to_offer() throws Throwable {
		ProUserActionsPage report = new ProUserActionsPage();
		report.prouserReviewmedReportandProceedOffer();
	}

	@Then("^claim will be sent to TPA for offer$")
	public void prouser_sent_claim_for_first_offer() throws Throwable {
		ClaimantActionsPage offer = new ClaimantActionsPage();
		offer.logout();
	}

	/* Prouser challenge liability decision */
	@Given("^Prouser claim liability has been partially accepted by TPA$")
	public void liability_accepeted_by_tpa() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^Prouser challenges Liability$")
	public void claimant_challenges_liability() throws Throwable {
		ProUserActionsPage liability = new ProUserActionsPage();
		liability.ChallengeLiabilityDecision();

	}

	@Then("^Prouser claim will be sent to TPA to update liability$")
	public void claim_will_be_sent_to_tpa_update_liability() throws Throwable {
		ClaimantActionsPage liability = new ClaimantActionsPage();
		liability.logout();
	}

	/* Claimant should not be able to challenge liability */
	@Given("^Prouser has reopened the claim$")
	public void mibpro_has_reopened_the_claim() throws Throwable {
		MIBLoginPage.login("prouser");
	}

	@When("^Prouser tries to challenge liability$")
	public void claimant_tries_to_challenge_liability() {
		ProUserActionsPage link = new ProUserActionsPage();
		link.proVerifyChallengeLiability();
	}
	
	@When("^prouser claimant acknowledge for Interim$")
	public void prouser_claimant_acknowledge_for_Interim() {
		ProUserActionsPage court = new ProUserActionsPage();
		court.prouserCourtform();
	}
	
	
	@When("^prouser reject fee offer decided to go to court$")
	public void prouser_reject_fee_offer_decided_to_go_to_court() throws Throwable {
		ProUserActionsPage court = new ProUserActionsPage();
		court.prouserRejectFeeOffer();
	}
	
	@Then("^pro counter offer sent to compensator for review$")
	public void mibpro_counter_offer_sent_compensator_for_review() throws Throwable {
		ClaimantActionsPage sent = new ClaimantActionsPage();
		sent.logout(); 
	}
	

}