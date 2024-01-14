@mibpro
Feature: Journey 17

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	 | owner| involvement_type_v| multivrn |	location|							
	 | NO|	The driver|NO|Inside UK|
	
	Scenario: Compensator  Accept Claim and full Liability
  Given Claim  is sent to the compensator
  When compensator accepts claim and makes full liability without dispute
  Then the claims acceptance and liability is now sent to the claimant
  
Scenario: MIBpro Provides Medical Preferences 
	Given compensator accepts mibprouser claim liability
	When mibprouser selects medical preferences for an DME 
	Then  mibprouser medical preferences are sent to Independent Expert

Scenario: DME uploads report-No prognosis
  Given claimant selects DME 
  When claimant visits DME and completes checkup
  Then DME uploads report no prognosis
  
Scenario: MIBpro Claimant reviews and acknowledge medical report and proceed to offer
	Given Mibprouserclaimant received the reports from DME 
	When Mibprouser Claimant reviews medical report and proceed to offer                    
	Then claim will be sent to compensator for first offer to mibprouser claimant
  
  Scenario: Compensator makes First Offer
  Given Claim  is sent to the compensator
  When the compensator makes first offer
  Then offer is sent to claimant
  
  Scenario: MIBpro Claimant accepts offer and makes counter fees proposal.
  Given MIBpro received offer details 
  When MIBpro accepts offer and makes fees request    
  Then Acknowledgement for offer acceptance will be sent to compensator
  
  
 Scenario: Compensator makes fee proposal 
  Given claimant has requested for fee
  When compensator make fee proposal
  Then fee proposal is sent to claimant
 
 Scenario: Claimant makes counter fees proposal
 	Given mibpro receives the fee proposal from compensator
 	When mibpro rejects the fee proposal
 	Then counter fee proposal is sent back to the compensator
  
  Scenario: Compensator does not respond to counter fees proposal and claimant goes to court
  Given Compensator doesnot respond to the counter offer request
  When mibprouser claimant goes to court over non response fee proposal
  Then the claimant goes to court
  
  Scenario Outline: Compensator review and agrees to claimant court document
  Given claimant selects court documents compensator
  When Compensator agrees to court documents when claim is in '<status>'
  Then claim will be sent for claimant acknowledgement
  Examples:
  |status|
  |Pending-FeesListReview|
 
  Scenario Outline: unrep Claimant checks the documents selected by compensator and submit the claim for court    
  Given '<Claimant>' checks the documents uploaded by Compensator   
  When '<Claimant>' submit the claim for court with claim '<status>' for fee dispute              
  Then  Case is closed with Go to court at offer stage  	
	Examples:
 	 |Claimant|status|
 	 |mibpro|Pending-FeesListAccept|
 	 
Scenario Outline: Verify the claim is in Resolved status
	Given '<claimant>' goes to court
	When mibpro claim goes to dispute at court at '<status>'
	Then the claim will be resolved at court
Examples:
	|claimant|status|
 	 |mibpro|Resolved-CourtFees|
  
  
