package com.cucumbercraft.stepdefinitions;

import com.cucumbercraft.pages.ClaimantActionsPage;
import com.cucumbercraft.pages.CompensatorDecisionPage;
import com.cucumbercraft.pages.MIBLoginPage;
import com.cucumbercraft.pages.MIBProActionsPage;
import com.cucumbercraft.pages.MIBProUserClaimCreationPage;
import com.cucumbercraft.pages.ProUserClaimCreationPage;
import com.cucumbercraft.pages.SuperUserLoginPage;
import com.cucumbercraft.pages.UnrepClaimCreationPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
public class MIBProActionsStepDefs{
	
	
	
/*  mibProuser claim creation */
	
	@Given("^MIBpro logins into whiplash application$")
    public void mibpro_logins_into_whiplash_applicataion_using() throws Throwable 
	{
		SuperUserLoginPage.mibProLogin();
		
	}      
    	
	@When("^MIBpro enter all mandatory details for claim creation as '(.*)' with '(.*)' and '(.*)' and '(.*)'$")
    public void mibprouser_Enter_All_Mandatory_Details_For_Claim_Creation (String involvement_type_v, String multivrn,String owner, String location) throws Throwable {
        MIBProUserClaimCreationPage claim = new MIBProUserClaimCreationPage();
        claim.MIBproClaimCreation(involvement_type_v,multivrn,owner,location);
	}
	@Then("^claim is created for MIBpro$")
	public void mibpro_claim_Is_Created() throws Throwable
	{
		MIBProUserClaimCreationPage claim = new MIBProUserClaimCreationPage();
		claim.endOfSubmitClaim();
		claim.logout();	
	}
	
	@Then("^MIBpro exits before submitting claim$")
	public void prouser_exits_before_submitting_claim() throws Throwable {
		MIBProUserClaimCreationPage claim = new MIBProUserClaimCreationPage();
		claim.exitBeforeSubmitClaim();
	}
	
	@Then("^MIBpro submits the claim successfully$")
	public void prouser_submits_claim_successfully()throws Throwable
	{
		MIBProUserClaimCreationPage claim = new MIBProUserClaimCreationPage();
		claim.continueClaimSubmission();
		
	}
	
	@Given("^mibpro claim is pending and SLA breached$")
	public void claim_pending_sla_breached()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	
	/* MIB prouser Claimant request for another report */
	
	@Given("^medical report is sent to mibprouser claimant for review from compensator$")
    public void medical_report_sent_to_mibprouser_for_review_compensator()throws Throwable
    {
      SuperUserLoginPage.mibProLogin();
    }
	
	@Given("^medical report is sent to mibprouser claimant for review$")
    public void medical_report_sent_to_mibprouser_for_review()throws Throwable
    {
      SuperUserLoginPage.mibProLogin();
    }
	
	@When("^mibprouser Claimant reviews report and  selects option Report not factually correct and request for another report$")
    public void Mibprouser_claimant_reviews_report_and_request_for_another_report()throws Throwable
    {
        MIBProActionsPage revised = new MIBProActionsPage();
        revised.mibProuserRequestForSecondMedicalReport();
    }
	
	@When("^MiBpro requests for second report$")
    public void Mibprouser_request_for_second_report()throws Throwable
    {
        MIBProActionsPage revised = new MIBProActionsPage();
        revised.mibProuserRequestForSecondMedicalReport();
    }
	
	/*Mibprouser Claimant accepts wop and proceed to offer*/
    @Given("^Compensator sent revised report with WOP$")
    public void Compensator_sent_revised_report_with_wop()throws Throwable
    {
      SuperUserLoginPage.mibProLogin();
    }
    @When("^Mibprouser accepts wop and proceed to offer after wop$")
       public void Mibprouser_claimant_accept_wop_proceed_to_offer()throws Throwable
       {
           MIBProActionsPage mibprouseracceptwop = new MIBProActionsPage();
           mibprouseracceptwop.mibProuserAcceptPrognosis();
       }
    
    @When("^Mibprouser accepts wop in revised report and proceed to offer after wop$")
    public void Mibprouser_claimant_accept_wop_in_revised_report_proceed_to_offer()throws Throwable
    {
        MIBProActionsPage mibprouseracceptwop = new MIBProActionsPage();
        mibprouseracceptwop.mibProuserAcceptPrognosisAfterSecondReport();
    }
    /*Claimant accepts replacement offer from TPA*/
	@Given("^TPA has given replacement offer for MIBpro$")
	public void tpa_has_given_replacement_offer_mibpro()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@When("^MIBpro accept the replacement offer$")
	public void claimant_accepts_the_final_offer()throws Throwable
	{
		 MIBProActionsPage mibprouseracceptoffer = new MIBProActionsPage();
         mibprouseracceptoffer.mibprouserAcceptoffer();
	}
    
    /*Mibprouser Claimant Accept Offer  and Fees proposal*/
    @Given("^MIBpro review offer and fee proposal$")
    public void mibpro_review_offer_and_fee_proposal()throws Throwable
    {
    	 SuperUserLoginPage.mibProLogin();
    }
    
    @When("^mibprouser claimant accept first offer and fees proposal$")
       public void Mibprouser_claimant_accept_first_offer()throws Throwable
       {
           MIBProActionsPage mibprouseracceptoffer = new MIBProActionsPage();
           mibprouseracceptoffer.mibprouserAcceptoffer();
       }
    @When("^mibprouser claimant accepts final offer$")
    public void Mibprouser_claimant_accept_final_offer()throws Throwable
    {
        MIBProActionsPage mibprouseracceptoffer = new MIBProActionsPage();
        mibprouseracceptoffer.mibprouserAcceptFinalOffer();
    }
    @Then("^first offer acceptance by mibprouser is sent to compensator for acknowledgement$")
    public void claim_sent_to_compensator_for_acknowledgement()throws Throwable
    {
     ClaimantActionsPage mibprouserofferacknowledgement = new ClaimantActionsPage();
     mibprouserofferacknowledgement.logout();
    }
    
    /*mibprouser Claimant go to court for claim settlement pending */
    @When("^mibprouser Claimant goes to court for claim settlement pending and select documents$")
       public void Mibprouser_claimant_go_to_court_ocs5()throws Throwable
       {
           MIBProActionsPage mibprouserOCS5 = new MIBProActionsPage();
           mibprouserOCS5.mibprouserReopenandGoToCourtOCS5();
       }
    /*MIBpro Claimant reviews and acknowledge medical report and proceed to offer with uplift*/
    @When("^Mibprouser Claimant reviews medical report and proceed to offer with uplift$")
    public void Mibprouserclaimant_reviews_medical_report_and_proceed_to_offer_with_uplift()throws Throwable
    {
        MIBProActionsPage mibreviewreport = new MIBProActionsPage();
        mibreviewreport.mibprouserReviewmedReportandProceedOfferwithuplift();
    }
    
    @When("^Mibprouser Claimant requests for revised offer with uplift$")
    public void Mibprouserclaimant_Requests_For_Revised_Offer_With_Uplift()throws Throwable
    {
       MIBProActionsPage mibrevisedoffer = new MIBProActionsPage();
        mibrevisedoffer.mibprouserRequestForRevisedOfferIncludingUplift();
    }

	/* MIBpro decides to accept the reject offer */
    @Given("^MIBpro has rejected the first offer$")
    public void mibpro_has_rejected_the_first_offer()throws Throwable
    {
    	SuperUserLoginPage.mibProLogin();
    }
    @When("^MIBpro decides to accept the rejected offer$")
    public void minpro_decides_to_accept_the_rejected_offer()throws Throwable
    {
    	MIBProActionsPage offer = new MIBProActionsPage();
    	offer.acceptRejectedOffer();
    }
    @Then("^the claim is resolved after offer acceptance$")
    public void the_claim_is_resolved_after_offer_acceptance()throws Throwable
    {
    	MIBProActionsPage logout = new MIBProActionsPage();
        logout.logout();
    }
    
    @Given("^Mibprouserclaimant received second offer from compensator$")    
    public void mibprouserclaimant_Received_Second_Offer_From_Compensator()throws Throwable
    {
      SuperUserLoginPage.mibProLogin();
    }
    
    /*MIB pro add losses and documents*/
    @And("^MIBpro claimant update the losses from Loss Tile and upload documents$")
	public void add_loss_upload_document() throws Throwable
	{
		MIBProActionsPage loss = new MIBProActionsPage();
		loss.addLossAndFee();
		loss.addDocument();

	}
    @And("^MIBpro claimant update the losses and upload documents$")
	public void add_loss_document() throws Throwable
	{
		MIBProActionsPage loss = new MIBProActionsPage();
		loss.addLossOnly();
		loss.addDocument();

	}
    
    @When("^MIBpro claimant update the losses from Loss Tile$")
   	public void add_loss_upload_loss_fee() throws Throwable
   	{
   		MIBProActionsPage loss = new MIBProActionsPage();
   		loss.addLossAndFee();

   	}
    
    @When("^MIBpro update the losses from Loss Tile$")
   	public void add_loss_upload_losS() throws Throwable
   	{
   		MIBProActionsPage loss = new MIBProActionsPage();
   		loss.addLoss();

   	}
    
    @And("^MIBpro claimant adds fee$")
   	public void add_fee() throws Throwable
   	{
   		MIBProActionsPage loss = new MIBProActionsPage();
   		loss.mibproAddFee();

   	}
    
    /*MIBpro accepts partial liability*/
    @Given("^MIBpro claim moves to partial liability$")
	public void claim_partial_liability()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();

	}
    
	/* DME has challenged the medical report */
	@Given("^DME has rejected the MIBpro report request$")
	public void dme_has_rejected_mibpro_report_request()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
		MIBProActionsPage status = new MIBProActionsPage();
		status.mibproUserClaimStatus("Pending-MedicalChallengeRejected");
	}
	@Then("^MIBpro checks the claim status$")
	public void the_claimant_checks_the_claim_status()throws Throwable
	{
		ClaimantActionsPage exit = new ClaimantActionsPage();
		exit.logout();
	}
	
    
    /*MIBpro requests second report*/
    @Given("^medical report is sent to MIBpro for review$")
	public void medical_report_sent_to_mibpro_review()throws Throwable
	{
    	SuperUserLoginPage.mibProLogin();
	}
	@When("^MIBpro requests for second report$")
	public void mibpro_requests_second_report()throws Throwable
	{
		MIBProActionsPage report = new MIBProActionsPage();
   		report.mibproRequestForSecondMedReport();
	}
    
	/* MIBpro removes losses */
	@Given("^MIBpro proceeds with offer$")
	public void mibpro_proceeds_with_offer()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@When("^MIBpro tries to add loss or fee$")
  	public void claimant_tries_to_add_loss_or_fee()throws Throwable
  	{
		MIBProActionsPage link = new MIBProActionsPage();
		link.mibproVerifyAddLoss();
  	}
	 @Given("^MIBpro decides to remove loss$")
	 public void unrep_decides_to_remove_fee()throws Throwable
	 {
		 SuperUserLoginPage.mibProLogin();
	 }
	
	@When("^MIBpro decides to removes losses$")
	public void claimant_decides_to_remove_losses()throws Throwable
	{
		MIBProActionsPage loss = new MIBProActionsPage();
		loss.mibproRemoveLoss();
	}
	@Then("^losses are removed successfully$")
	public void losses_are_removed_successsfully()throws Throwable
	{
		MIBProActionsPage logout = new MIBProActionsPage();
    	 logout.logout();
	}
    
    /*MIBpro Provides Medical Preferences*/
    @Given("^compensator accepts mibprouser claim liability$")
	public void compensator_accepts_mibprouser_claim_liability ()throws Throwable
	{
    	SuperUserLoginPage.mibProLogin();
	}
    @When("^mibprouser selects medical preferences for an DME$")
	public void mibprouser_selects_medical_preferences_for_an_DME ()throws Throwable
	{
    	MIBProActionsPage mibchoosedme = new MIBProActionsPage();
		mibchoosedme.mibprouserChooseDME();
	}
    
	@When("^MIBpro makes medical provider selection '(.*)'$")
	public void claimant_makes_medical_provider_selection(String status)throws Throwable
	{
		MIBProActionsPage mibchoosedme = new MIBProActionsPage();
		mibchoosedme.mibprouserChooseDME(status);
	}
    @Then("^mibprouser medical preferences are sent to Independent Expert$")
	public void mibprouser_medical_preferences_are_sent_to_Independent_Expert()throws Throwable
	{
    	 ClaimantActionsPage mibprodmeselection = new ClaimantActionsPage();
    	 mibprodmeselection.logout();
	}
    
	/* MIBpro acknowledges documents selected by compensator */
	@Given("^compensator confirmed documents selected by MIB PRO$")
	public void compensator_confirmed_documents_selected_by_mibpro()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@When("^MIB PRO acknowledges selected documents$")
	public void mibpro_acknowledges_selected_documents()throws Throwable
	{
		MIBProActionsPage ack = new MIBProActionsPage();
		ack.mibproAckDocsInterim();
	}
	@Then("^Interim case is resolved but go to court main claim carries on$")
	public void interim_case_is_resolved_but_go_to_court_main_claim_carries_on()throws Throwable
	{
		 ClaimantActionsPage exit = new ClaimantActionsPage();
    	 exit .logout();
	}
    
    /*MIBpro Claimant requests for revised offer*/
    @Given("^Mibprouserclaimant received first offer from compensator$")
    	public void mibprouserclaimant_received_first_offer_from_compensator()throws Throwable
    	{
    	  SuperUserLoginPage.mibProLogin();
    	}
    @When("^Mibprouser Claimant requests for revised offer$")
    	public void Mibprouserclaimant_requests_for_revised_offer()throws Throwable
    	{
    	   MIBProActionsPage mibrevisedoffer = new MIBProActionsPage();
    		mibrevisedoffer.mibprouserRequestForRevisedOffer();
    	}
    @Then("^claim will be sent to compensator with revised offer$")
    	public void mibprouser_sent_claim_to_compensator_for_revised_offer()throws Throwable
    	{
    	 ClaimantActionsPage mibrejectfirstoffer = new ClaimantActionsPage();
		 mibrejectfirstoffer.logout();
    	}
    /*mibprouser Claimant select court docs*/
    	@Given("^mibprouser Claimant receives the claim for document selection$")
    	public void mibprouser_claimant_receives_the_claim_for_document_selection()throws Throwable
    	{
    	  SuperUserLoginPage.mibProLogin();
    	}
    	@When("^mibprouser Claimant selects court docs$")
    	public void Mibprouserclaimant_selects_court_docs()throws Throwable
    	{
    	    MIBProActionsPage mibprouserselectdocs = new MIBProActionsPage();
    		mibprouserselectdocs.mibprouserSelectCourtDocsCompensatorResponse();
    	}
    @Then("^claim sent to compensator for reviewing docuemnts selected by mibprouser claimant$")
    	public void claim_sent_to_compensator_for_reviewing_court_docs()throws Throwable
    	{
    	 ClaimantActionsPage mibdocsselected = new ClaimantActionsPage();
		  mibdocsselected.logout();
    	}
    /*mibprouser Claimant acknowledges Compensators doc selection and case is resolved*/
    @Given("^mibprouser receives claim for acknowledgement$")
    	public void mibprouser_claimant_receives_the_claim_for_acknowledgement()throws Throwable
    	{
    	  SuperUserLoginPage.mibProLogin();
    	}
    @When("^mibprouser claimant acknowledge$")
    	public void Mibprouserclaimant_acknowledge()throws Throwable
    	{
    	    MIBProActionsPage mibprouseracknowledge = new MIBProActionsPage();
    		//mibprouseracknowledge.mibprouserDocumentAcknowledgemt();
    	}
    
    @When("^mibprouser claimant acknowledge with witness$")
	public void mibprouserclaimant_acknowledge_witness()throws Throwable
	{
	    MIBProActionsPage mibprouseracknowledge = new MIBProActionsPage();
		mibprouseracknowledge.mibprouserDocumentAcknowledgemtWit();
	}
    @Then("^case is closed at court stage for mibprouser claimant$")
    	public void claim_sent_to_mibprouserclaimant_for_acknowledgement()throws Throwable
    	{
    	 ClaimantActionsPage mibcaseclosed = new ClaimantActionsPage();
		 mibcaseclosed.logout();
    	}
    /*Mibprouser Claimant Challenge liability rejected Decision and goes to court*/
    @Given("^Mibprouser Claimant claim liability has been rejected$")
	public void mibprouser_claimant_claim_liability_rejected()throws Throwable
	{
	  SuperUserLoginPage.mibProLogin();
	}
    @When("^Mibprouser claimant wants to challenge rejected liability decision and decided to go to court$")
	public void Mibprouser_claimant_challenge_rejected_liability_decision_and_go_to_court()throws Throwable
	{
    	MIBProActionsPage mibprouserrejliability = new MIBProActionsPage();
		mibprouserrejliability.mibprouserGotocourtliabilityrej();
	}
    @Then("^claim sent to compensator for reviewing documents selected by mibprouser claimant$")
    public void claim_sent_to_comp_revewing_docs_mibpro()throws Throwable
    {
    	MIBProActionsPage mibprouserrejliability = new MIBProActionsPage();
		mibprouserrejliability.logout();
    }
    
    /*MIbpro uploads own medical report*/

	@When("^MIBpro uploads own medical report '(.*)'$")
	public void claimant_uploads_own_medical_report(String status)throws Throwable
	{
			MIBProActionsPage mr= new MIBProActionsPage();
			mr.mibproUploadOwnReportWithoutPrognosis(status);
	}
    
/*Mibprouser Claimant accepts wait out prognosis*/
    
    @Given("^Medical report received by MIBPro claimant with wait out prognosis$")
    public void medical_report_received_by_MIBPro_claimant_with_wait_out_prognosis() throws Throwable {
		SuperUserLoginPage.mibProLogin();
       
    }


    @When("^MIBPro claimant accepts wait out prognosis$")
    public void mibpro_claimant_accepts_wait_out_prognosis() throws Throwable {
	    MIBProActionsPage acceptwop = new MIBProActionsPage();
	    acceptwop.mibproReviewreportAcceptWOP();
        
    }
    
    @When("^MIBPro claimant accepts wait out prognosis and release to comp$")
    public void mibpro_claimant_accepts_release_to_comp()throws Throwable
    {
    	MIBProActionsPage acceptwop = new MIBProActionsPage();
	    acceptwop.mibproAcceptWaitOutPrognosisReleaseToComp();
    }
    
	@When("^MIBpro accepts wait out prognosis and proceeds to offer$")
	public void claimant_accepts_wait_out_prognosis_and_proceeds_to_offer()throws Throwable
	{
		MIBProActionsPage waitout = new MIBProActionsPage();
		waitout.mibproAcceptWaitoutAddLossProceedtoOffer();
	}
    
    @Then("^MIBPro claimant need to wait until waitout prognosis period ends$")
    public void mibpro_claimant_need_to_wait_until_waitout_prognosis_period_ends() throws Throwable {
    	ClaimantActionsPage acceptwop = new ClaimantActionsPage();
    	acceptwop.logout();
    	
    }
    
    /*MIBPRO Claimant proceeds with offer before prognosis period completes */
    
    @Given("^MIBPro Claimant waitout Prognosis period is not completed$")
    public void mibpro_Claimant_waitout_Prognosis_period_is_not_completed() throws Throwable {
  	  SuperUserLoginPage.mibProLogin();

        
    }

    @When("^MIBPro claimant proceeds with offer before prognosis$")
    public void mibpro_claimant_proceeds_with_offer_before_prognosis() throws Throwable {
    	MIBProActionsPage proceedoffer = new MIBProActionsPage();
	    proceedoffer.mibproProceedOfferBeforeWOP();
    
    }
    
    /*MIBPro Claimant Accepts Revised Offer and fee proposal from TPA*/
    
    @Given("^MIBPro Claimant receives revised offer$")
    public void mibpro_Claimant_receives_revised_offer() throws Throwable {
    	SuperUserLoginPage.mibProLogin();
      
    }
    @Given("^fee offer has been made to MIBpro$")
	public void fee_offer_has_been_made_to_the_claimant()throws Throwable
	{
    	SuperUserLoginPage.mibProLogin();
	}

    @When("^MIBPro claimant accepts fee proposal$")
    public void mibpro_claimant_accepts_offer_and_fee_proposal() throws Throwable
    {
    	MIBProActionsPage reviewfee = new MIBProActionsPage();
	    reviewfee.mibproReviewFeeproposal();
       
    }
    
    /*MIBPRO Claimant decides to go to court (OCS3)*/
    
    @Given("^claim is pending for settlement for MIBPRO$")
    public void claim_is_pending_for_settlement_for_MIBPRO() throws Throwable 
    {
    	SuperUserLoginPage.mibProLogin();
    }

    @When("^MIBPro claimant decides to go to court for claim settlement pending$")
    public void mibpro_claimant_decides_to_go_to_court_for_claim_settlement_pending() throws Throwable 
    {
    	MIBProActionsPage gotocourt = new MIBProActionsPage();
    	gotocourt.mibproGotocourtOCS3();
    }
    
    /*claimant goes to court for interim non-payment*/
    @When("^interim payment is not made to the claimant$")
    public void interim_payment_is_not_made_to_the_claimant()throws Throwable
    {
    	MIBProActionsPage ocs = new MIBProActionsPage();
    	ocs.mibproGotoCourtForInterimNonPayment();
    }
	@Then("^claimant decides to go to court$")
	public void claimant_decides_to_go_to_court()throws Throwable
	{
		MIBProActionsPage exit = new MIBProActionsPage();
    	exit.logout();
	}
    
   /* Accept Offer and Reject fee proposal */
    
    @Given("^MIBpro claimant review fee proposal$")
	public void mibpro_review_fee_proposal()throws Throwable
	{
    	SuperUserLoginPage.mibProLogin();
	}
    @When("^MIBpro requests fee$")
    public void mibpro_request_fee()throws Throwable
    {
    	MIBProActionsPage counterfee = new MIBProActionsPage();
		counterfee.mibproRequestFee();
    }
    
    @When("^MIBpro accepts offer and makes counter fees proposal$")
	public void mibpro_accepts_offer_reject_fees_proposal()throws Throwable
	{
    	MIBProActionsPage counterfee = new MIBProActionsPage();
		counterfee.mibproAcceptOfferRejectfee();
	}
    @Then("^MIBpro counter offer sent to compensator$")
    public void mibpro_counter_offer_sent_compensator()throws Throwable
    {
    	MIBProActionsPage counterfee = new MIBProActionsPage();
		counterfee.slaBreached();
    }
    
    /*Mibprouser Claimant reviews medical report and proceed to offer*/
	@Given("^Mibprouserclaimant received the reports from DME$")
	public void mibprouserclaimant_received_the_reports_from_dme()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
    @When("^Mibprouser Claimant reviews medical report and proceed to offer$")
	public void Mibprouserclaimant_reviews_medical_report_and_proceed_to_offer()throws Throwable
	{
    	MIBProActionsPage mibreviewreport = new MIBProActionsPage();
		mibreviewreport.mibprouserReviewmedReportandProceedOffer();
	}
    @When("^MIBpro proceeds to offer after uploading own medical report$")
	public void claimant_proceeds_to_offer_after_uploading_medical_report()throws Throwable
	{
    	MIBProActionsPage offer = new MIBProActionsPage();
		offer.mibproProceedToOfferAfterReportUpload();
	}
    @When("^Mibprouser Claimant reviews own medical report and proceed to offer$")
   	public void Mibprouserclaimant_reviews_own_medical_report_and_proceed_to_offer()throws Throwable
   	{
       	MIBProActionsPage mibreviewreport = new MIBProActionsPage();
   		mibreviewreport.mibprouserReviewMedicalReport();
   	}
    @Then("^claim will be sent to compensator for first offer to mibprouser claimant$")
	public void mibprouser_sent_claim_for_first_offer()throws Throwable
	{
    	ClaimantActionsPage mibprooffer = new ClaimantActionsPage();
		mibprooffer.logout();
	}
    
   
    /*Compensator doesnot respond to the counter offer request made by claimant and claimant goes to court */
    @Given("^Compensator doesnot respond to the counter offer request$")
    	public void compensator_does_not_respond_to_the_counter_offer_from_mibprouser()throws Throwable
    	{
    	  SuperUserLoginPage.mibProLogin();
    	}
    @When("^mibprouser claimant goes to court$")
    	public void Mibprouserclaimant_goes_to_court()throws Throwable
    	{
    	    MIBProActionsPage mibprousergotocourt = new MIBProActionsPage();
    		mibprousergotocourt.mibprouserGotoCourtOcs2();
    	}
    @When("^mibprouser claimant goes to court over non response fee proposal$")
	public void Mibprouserclaimant_goes_to_court_for_non_response_fee_proposal()throws Throwable
	{
	    MIBProActionsPage mibprousergotocourt = new MIBProActionsPage();
		mibprousergotocourt.mibprouserGotoCourtOcs4();
	}
    
    @When("^MIBpro reject offer and goes to court and answers NVC$")
	public void mibpro_reject_offer_go_to_court_nvc()throws Throwable
	{
    	MIBProActionsPage nvc = new MIBProActionsPage();
		nvc.mibproRejectOfferCounterOfferUpliftCourtNVC();
	}
    
    @When("^MIBpro claimant reject offer and goes to court and answers NVC$")
   	public void mibpro_reject_goes_to_court_nvc()throws Throwable
   	{
       	MIBProActionsPage nvc = new MIBProActionsPage();
   		nvc.mibproRejectOfferCounterOfferCourtNVC();
   	}
    
    @When("^mibprouser claimant goes to court over fee proposal$")
   	public void Mibprouserclaimant_goes_to_court_for_fee_proposal()throws Throwable
   	{
   	    MIBProActionsPage mibprousergotocourt = new MIBProActionsPage();
   		mibprousergotocourt.mibprouserGotoCourtFeeProposal();
   	}
    @Then("^claim will be sent to compensator to review nvc answers$")
    	public void mibprouser_claim_sent_to_compensator_for_review_nvc_answers_mibprouser()throws Throwable
    	{
    	 ClaimantActionsPage mibanswernvc = new ClaimantActionsPage();
		 mibanswernvc.logout();
    	}
    
    @Then("^claim will be sent to compensator$")
	public void mibprouser_claim_sent_to_compensator()throws Throwable
	{
	 ClaimantActionsPage mibanswernvc = new ClaimantActionsPage();
	 mibanswernvc.logout();
	}
    
    /* MIBpro challenge liability decision */
	@Given("^the MIBpro claim liability has been accepted by compensator$")
	public void liability_accepeted_by_compensator()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@Given("^Updated Liability information received by MIBpro$")
	public void updated_liability_information_received_by_claimant() throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@When("^MIBpro claimant challenges Liability$")
	public void claimant_challenges_liability()throws Throwable
	{
		MIBProActionsPage liability = new MIBProActionsPage();
		liability.mibproChallengeLiabilityDecision();

	}
	@When("^MIBpro claimant review challenge Liability$")
	public void claimant_review_challenge_liability()throws Throwable
	{
		MIBProActionsPage liability = new MIBProActionsPage();
		liability.mibproReviewChallengeLiabilityDecision();
	}
	@Then("^MIBpro claim will be sent to compensator to update liability$")
	public void claim_will_be_sent_to_compensator_update_liability()throws Throwable
	{
		ClaimantActionsPage liability = new ClaimantActionsPage();
		liability.logout();
	}
	
	/*MIBpro add losses and proceed to offer*/
	
	 @Given("^Mibprouser Claimant waitout Prognosis period is completed$")
	    public void mibprouser_Claimant_Waitout_Prognosis_Period_Is_Completed()throws Throwable
	    {
	        SuperUserLoginPage.mibProLogin();
	    }
	
	/*claimant adds loss and proceed with offer*/
	@When("^MIBpro update the losses from Loss Tile and proceeds with offer$")
	public void add_loss_upload_proceed_with_offer() throws Throwable
	{
		MIBProActionsPage loss = new MIBProActionsPage();
		loss.mibproAddLossAndProceedToOffer();

	}
	/*claimant add fee and proceed with offer*/
	@When("^MIBpro update fee from Loss Tile and proceeds with offer$")
	public void add_loss_proceed_with_offer() throws Throwable
	{
		MIBProActionsPage loss = new MIBProActionsPage();
		loss.mibproAddFeeAndProceedOffer();

	}
	
	
	/*claimant adds loss, add fee and proceed with offer*/
	@When("^MIBpro update the losses and fee from Loss Tile and proceeds with offer$")
	public void add_loss_add_fee_upload_proceed_with_offer() throws Throwable
	{
		MIBProActionsPage loss = new MIBProActionsPage();
		loss.mibproAddLossAndFeeProceedToOffer();

	}
	
	/*MIBpro request for fee*/
	@Given("^MIBpro received offer details$")
	public void mibpro_received_offer_details()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@When("^MIBpro accepts offer and makes fees request$")
	public void mibpro_accepts_offer_and_makes_fee_request()throws Throwable
	{
		MIBProActionsPage fee = new MIBProActionsPage();
		fee.mibproAcceptOfferAndRequestFee();
	}
	
	/*
	 * MIBpro cannot proceed to court for 2nd interim when 1st interim is in court
	 */
	@Given("^MIBpro goes to court for first interim$")
	public void mibpro_goes_to_court_first_interim()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@When("^mibpro goes to court for second interim over interim rejection$")
	public void mibpro_unable_to_go_to_court_for_interim()throws Throwable
	{
		MIBProActionsPage court = new MIBProActionsPage();
		court.mibproSecondInterimUnableToGotoCourt();
	}
    
	/* MIBpro withdraws the claim */
	@Given("^the compensator makes first offer to the claimant$")
	public void the_compensator_makes_first_offer_to_the_claimant()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@When("^the MIB prouser claimant then decides to withdraw the claim at '(.*)'$")
	public void mibpro_claimant_decides_to_withdraw_the_claim(String status)throws Throwable
	{
		MIBProActionsPage court = new MIBProActionsPage();
		court.mibproWithDrawClaim(status);
	}
	
	/* Claimant accepts Denial & case resolved */

	@When("^MIBpro Claimant accepts denial$")
	public void mibpro_accepts_denial() throws Throwable
	{
		MIBProActionsPage court = new MIBProActionsPage();
		court.acceptDenial();

	}
	/*Claimant reject fee proposal*/
	@Given("^mibpro receives the fee proposal from compensator$")
	public void mibpro_receives_fee_proposal_from_compensator()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@When("^mibpro rejects the fee proposal$")
	public void mibpro_rejects_the_fee_propsal()throws Throwable
	{
		MIBProActionsPage fee = new MIBProActionsPage();
		fee.mibproRejectFeeProposal();
	}
	@When("^mibpro claim goes to dispute at court at '(.*)'$")
	public void claim_goes_to_dispute_at_court(String status)throws Throwable
	{
		MIBProActionsPage stat = new MIBProActionsPage();
		stat.resolvedStatus(status);
	}
	/*Claimant	requests for further medical report */
	@Given("^MIBpro uploaded medical report$")
	public void claimant_uploaded_medical_report()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@When("^MIBpro claimant decides waitout and obtains further medical report$")
	public void claimant_decides_waitout_obtains_further_medical_report()throws Throwable
	{
		MIBProActionsPage report = new MIBProActionsPage();
		report.mibproWaitoutObtainFurtherMedReport();
		report.mibproObtainFurtherReportDuringWOP();
		
	}
	/*MIBpro upload further medical report*/
	@When("^mibpro uploades further medical report$")
	public void mibpro_upload_further_medical_report()throws Throwable
	{
		MIBProActionsPage mr = new MIBProActionsPage();
		mr.mibproUploadRevisedMR();
		
	}
	/*MIBpro proceeds to offer after uploading new report*/

	@Given("^MIBpro waitout Prognosis period is completed$")
	public void MIBpro_waitout_prognosis_period_is_completed()throws Throwable
	{
		SuperUserLoginPage.mibProLogin();
	}
	@When("^MIBpro proceeds with offer after uploading new report$")
	public void mibpro_proceed_with_offer_after_uploading_new_report() throws Throwable
	{
		MIBProActionsPage loss = new MIBProActionsPage();
		loss.mibproProceedAfterNewReport();

	}
	

	/* MIBpro accepts the decision and no offer is made */
		@Given("^compensator has disputed causation for MIBpro$")
		public void compensator_has_disputed_causation()throws Throwable
		{
			SuperUserLoginPage.mibProLogin();
		}
		@When("^MIBpro accepts the dispute causation no offer$")
		public void mibpro_accepts_the_dispute_no_offer()throws Throwable
		{
			MIBProActionsPage dispute = new MIBProActionsPage();
			dispute.mibproCausationDisputeOffer();
		}
		
		@When("^MIBpro reject the dispute causation final offer$")
		public void mibpro_reject_the_dispute_final_offer()throws Throwable
		{
			MIBProActionsPage dispute = new MIBProActionsPage();
			dispute.mibproRejectcausationDisputeFinalOffer();
		}
	
		/*MIBpro challenge liability decision and goes to court*/
		 
		@Given("^MIBpro claim liability has been rejected$")
		public void mibpro_liability_rejected()throws Throwable
		{
			SuperUserLoginPage.mibProLogin(); 
		}
		@When("^MIBpro wants to challenge decision and decided to go to court$")
		public void mibpro_challenge_decision_go_to_court()throws Throwable
		{
			MIBProActionsPage decision = new MIBProActionsPage();
			decision.mibproGoToCourtRejectLiability();
		}
		

		@When("^MIBpro submits the court documents for liability$")
		public void mibprpo_submits_court_documents_for_liability()throws Throwable
		{
			MIBProActionsPage closed = new MIBProActionsPage();
			closed.mibproAckCourtDocsLiability();
		}
		
		/*MIBpro requests and uploads further report*/
		@When("MIBpro decides to obtain further report")
		public void mibpro_decides_to_obtain_further_report()throws Throwable
		{
			MIBProActionsPage mr = new MIBProActionsPage();
			mr.mibproObtainAndUploadFurtherMedReport();
		}
		@Given("MIBpro has uploaded further report")
		public void mibpro_uploaded_further_report()throws Throwable
		{
			SuperUserLoginPage.mibProLogin(); 
		}
		@Given("^Compensator has acknowledged MIBrpo for further medical report$")
		public void compensator_has_acknowledged_mibrpo_for_further_medical_report()throws Throwable
		{
			SuperUserLoginPage.mibProLogin(); 
		}
		@Given("^Compensator has denied MIBpro for further medical report$")
		public void compensator_has_acknowledged_for_further_medical_report()throws Throwable
		{
			SuperUserLoginPage.mibProLogin();
			MIBProActionsPage closed = new MIBProActionsPage();
			closed.mibproUserClaimStatus("Pending-ClaimantFurtherMedical");
		}
		/* Reject fee offer from compensator and goes to court */
		@When("^MIBpro rejects fee offer and goes to court$")
		public void mibpro_rejects_fee_offer_go_to_court()throws Throwable
		{
			MIBProActionsPage offer = new MIBProActionsPage();
			offer.mibproRejectFeeOfferAndGoToCourt();
		}
		@Given("^MIBpro accepts waitout prognosis$")
		public void mibpro_accepts_waitout_prognosis()throws Throwable
		{
			SuperUserLoginPage.mibProLogin();
		}
		/* MIBpro withdraws the offer and makes replacement offer */
		@Given("^MIBpro has made counter offer$")
		public void claimant_has_made_first_offer()throws Throwable
		{
			SuperUserLoginPage.mibProLogin();
		}
		@When("^MIBpro withdraws the current offer$")
		public void claimant_withdraws_the_current_offer()throws Throwable
		{
			MIBProActionsPage replace = new MIBProActionsPage();
			replace.mibproWithdrawOfferReplace();
		}
		
		/* MIBPRO reviews and request for UPLIFT */
		@Given("^MIBpro reviews medical report when uploaded by DME$")
		public void review_medical_report_uploaded_by_dme()throws Throwable
		{
			SuperUserLoginPage.mibProLogin();
		}
		@When("^MIBpro requests an UPLIFT due to EXCEPTIONAL CIRCUMSTANCES$")
		public void unrep_request_uplift()throws Throwable
		{
			MIBProActionsPage review = new MIBProActionsPage();
			review.mibproReviewReportAndProceedWithOfferUplift();
		}
		
		@When("^MIBpro proceeds with offer with uplift$")
		public void mibpro_request_uplift()throws Throwable
		{
			MIBProActionsPage review = new MIBProActionsPage();
			review.mibproReviewMRAndProceedWithOfferUplift();
		}
		
		
	
		/* MIBpro acknowledges documents selected by compensator */
		@Given("^compensator confirmed documents selected by MIBpro$")
		public void compensator_confirmed_documents_selected_mibpro()throws Throwable
		{
			SuperUserLoginPage.mibProLogin();

		}
		@When("^MIBpro acknowledges selected documents$")
		public void claimant_ack_selected_document()throws Throwable
		{
			MIBProActionsPage review = new MIBProActionsPage();
			review.mibproReviewInterimCourtDocs(); 
		}
		/*
		 * Claimant rejects interim payment decision and decides go to court and
		 * selectcourtdocs
		 */
		@Given("^the compensator makes reduced interim payment$")
		public void the_compensator_makes_reduced_interim_payment()throws Throwable
		{
			SuperUserLoginPage.mibProLogin();
		}
		@When("^MIBpro reject interim and goes to court$")
		public void claimant_rejectsinterim_decision()throws Throwable
		{
			MIBProActionsPage rejectInterim = new MIBProActionsPage();
			rejectInterim.mibproRejectInterimAndGoToCourt();

		}
		
		/* Claimant decides to reopen the claim */
		 @Given("^The claim was resolved at court$")
		 public void court_has_resolved()throws Throwable
		 {
			 SuperUserLoginPage.mibProLogin();
		 }
		 @When("^MIBpro reopens liability disputed claim$")
		 public void claimant_reopens_liability_disputed_claim()throws Throwable
		 {
			 MIBProActionsPage reopen = new MIBProActionsPage();
			 reopen.mibproReopenClaimLiability();
		 }
		 @Then("^MIBpro reopens the claims sucessfully$")
		 public void unrep_choose_the_dme_to_upload_medical_report()throws Throwable
		 {
			 MIBProActionsPage unrep = new MIBProActionsPage();
				unrep.logout();
		 }
		 /* Claimant should not be able to challenge liability */
		 	@Given("^MIBpro has reopened the claim$")
		 	public void mibpro_has_reopened_the_claim()throws Throwable
		 	{
		 		SuperUserLoginPage.mibProLogin();
		 	}
		 	@When("^MIBpro tries to challenge liability$")
		 	public void claimant_tries_to_challenge_liability()
		 	{
		 		MIBProActionsPage link = new MIBProActionsPage();
				link.mibproVerifyChallengeLiability();
		 	}
}
