@mibpro
Feature: Journey 38 mibpro

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	 | owner| involvement_type_v| multivrn |	location|							
	 | YES	|	The driver	| NO	| Inside UK|
	 
Scenario: Compensator Accept Claim and Part claim Liability
Given Claim  is sent to the compensator
When compensator accepts claim and makes part liability
Then the claims acceptance and liability is now sent to the claimant	

Scenario Outline: Claimant Request first Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|mibpro|	

Scenario: Compensator makes first interim payment
	Given claimant request interm payment to compensator
	When compensator makes interim payment
	Then claimant receives interim payment

Scenario Outline: Claimant reviews and accepts first interim payment
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews and accept interim decision 
	Then payment is not received by the claimant
Examples:
|claimant|
|mibpro|

Scenario Outline: Claimant decides to go to court for interim over non-payment 
	Given '<claimant>' interim non-payment SLA is breached
	When Go to court for non-payment option is enabled for '<claimant>'
	Then claimant decides to go to court over interim non-payment
Examples:
|claimant|
|mibpro|	
 
 Scenario Outline: Claimant select court docs for interim non-payment
	Given '<claimant>' goes to court over interim
	When '<claimant>' selects document for court for interim non-payment
	Then court document are sent to compensator

Examples:
|claimant|
|mibpro|	

Scenario: Compensator reviews court document for Interim non-payment
		Given claimant goes to court
		When Compensator reviews court document for interim
		Then court docs sent for review to claimant

Scenario: MIBpro acknowledges documents selected by compensator
	Given compensator confirmed documents selected by MIBpro
	When MIBpro acknowledges selected documents   
	Then Interim case is resolved at court	
	
	
Scenario: MIBpro Provides Medical Preferences 
	Given compensator accepts mibprouser claim liability
	When mibprouser selects medical preferences for an DME 
	Then  mibprouser medical preferences are sent to Independent Expert

Scenario: DME uploads report-No prognosis
	Given claimant selects DME
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis		
	
Scenario: Claimant adds more losses and proceeds with offer
	Given MIBpro reviews medical report when uploaded by DME
	And MIBpro update the losses from Loss Tile
	When MIBpro requests an UPLIFT due to EXCEPTIONAL CIRCUMSTANCES
	Then claim is sent to compensator	
	
	
Scenario: Compensator First Offer to MIBPRO
	Given Claim  is sent to the compensator
	When Compensator makes first offer with NON whiplash injury with uplift
	Then offer is sent to claimant	
	
	
Scenario Outline: mibpro rejects offer and goes to court
	Given '<claimant>' receives new offer
	When "<claimant>" decided to go to court after rejecting first offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|mibpro|	
	
	
	
	
Scenario Outline: mibpro answers NVC
	Given '<claimant>' receives new offer
	And '<claimant>' answers NVC
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|mibpro|	
	
Scenario: Compensator responds to NVC questions
   Given Compensator receives claim to review NVC answers
   When Compensator responds NVC 
   Then claim should be sent to claimant to select documents for court
   
   
     Scenario Outline: Unrep selected Court proceeding started and selected documents for court
	Given "<claimant>" started court proceeding
	When "<claimant>" selected Court proceeding started as Yes
	And "<claimant>" selected documents for court
	Then documents should be reviewed by Compensator
	Examples:
	|claimant|
	|mibpro|
 
 Scenario Outline: Compensator acknowledges documents selected for court
   Given claimant selects court documents compensator
   When Compensator agrees to court documents when claim is in '<status>'
   Then claim will be sent for claimant acknowledgement
 Examples:
 |status|
 |Pending-OfferListReview| 	
	
		
 
  Scenario Outline: Claimant checks the documents selected by compensator and proceeds the claim for court 
   Given '<claimant>' checks the documents uploaded by Compensator   
   When "<claimant>" entered details in court screen                       
   Then  Case is closed with Go to court at offer stage  	
Examples:
 	|claimant|
 	|mibpro|
 	
 	
Scenario Outline: The claim is moved to 'Resolved-CourtOffer'
 	Given '<claimant>' goes to court
 	When mibpro claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|mibpro|Resolved-CourtOffer|