@unrep
Feature: Journey 17

Scenario Outline: Unrep claim creation as car owner
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |	location|							
	 | NO|	I was the driver	| BOTH			|NO|Inside UK|
	
	Scenario: Compensator  Accept Claim and full Liability
  Given Claim  is sent to the compensator
  When compensator accepts claim and makes full liability without dispute
  Then the claims acceptance and liability is now sent to the claimant
  
  Scenario: Unrep Provides Medical Preferences 
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME
	Then medical preferences are sent to Independent Expert

  Scenario: DME uploads report-No prognosis
  Given claimant selects DME 
  When claimant visits DME and completes checkup
  Then DME uploads report no prognosis
  
  Scenario:  Unrep reviews medical report and proceeds with offer
  Given DME uploads medical report
  When claimant reviews medical report and acknowledges the report
  Then claim is sent to compensator
  
  Scenario: Compensator makes First Offer
  Given Claim  is sent to the compensator
  When the compensator makes first offer
  Then offer is sent to claimant
  
  Scenario: Unrep Claimant accepts offer and makes counter fees proposal.
  Given Claimant received offer details 
  When Claimant accepts offer and makes fees request    
  Then Acknowledgement for offer acceptance will be sent to compensator
  
  
 Scenario: Compensator makes fee proposal
  Given claimant has requested for fee
  When compensator make fee proposal
  Then fee proposal is sent to claimant
 
 Scenario: Claimant makes counter fees proposal
 	Given Claimant receives the fee proposal from compensator
 	When Claimant rejects the fee proposal
 	Then counter fee proposal is sent back to the compensator
  
  Scenario: Compensator does not respond to counter fees proposal and claimant goes to court
  Given Compensator didn’t respond to claimant updated offer
  When claimant decides to challenge fee decision and decided to go to court
  Then the claimant goes to court
  
  Scenario Outline: Compensator review and agrees to claimant court document
  Given claimant selects court documents compensator
  When Compensator agrees to court documents when claim is in '<status>'
  Then claim will be sent for claimant acknowledgement
  Examples:
  |status|
  |Pending-FeeListReview|
 
  Scenario Outline: unrep Claimant checks the documents selected by compensator and submit the claim for court    
  Given '<Claimant>' checks the documents uploaded by Compensator   
  When '<Claimant>' submit the claim for court with claim '<status>' for fee dispute              
  Then  Case is closed with Go to court at offer stage  	
	Examples:
 	 |Claimant|status|
 	 |unrep|Pending-FeeListAccept|
Scenario Outline: Verify the claim is in Resolved status
	Given '<claimant>' goes to court
	When the claim goes to dispute at court at '<status>'
	Then the claim will be resolved at court
Examples:
	|claimant|status|
 	 |unrep|Resolved-CourtFees|
  
  
