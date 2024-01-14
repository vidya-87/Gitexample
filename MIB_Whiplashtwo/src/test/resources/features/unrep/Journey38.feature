@unrep
Feature: Journey 38

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |	location|							
	 | YES|	I was the driver	| BOTH		| NO	|Inside UK|


Scenario: Compensator Accept Claim and Part claim Liability with causation
Given Claim  is sent to the compensator
When compensator accepts claim and makes part liability
Then the claims acceptance and liability is now sent to the claimant	

Scenario Outline: Claimant Request first Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|unrep|	

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
|unrep |


Scenario Outline: Claimant decides to go to court for interim over non-payment 
	Given '<claimant>' interim non-payment SLA is breached
	When Go to court for non-payment option is enabled for '<claimant>'
	Then claimant decides to go to court over interim non-payment
Examples:
|claimant|
|unrep|	
 
 Scenario Outline: Claimant select court docs for interim non-payment
	Given '<claimant>' goes to court over interim
	When '<claimant>' selects document for court for interim non-payment
	Then court document are sent to compensator

Examples:
|claimant|
|unrep|	

Scenario: Compensator reviews court document for Interim non-payment
		Given claimant goes to court
		When Compensator reviews court document for interim
		Then court docs sent for review to claimant

Scenario: Unrep acknowledges documents selected by compensator
	Given compensator confirmed documents selected by claimant
	When claimant acknowledges selected documents   
	Then Interim case is resolved at court
	
Scenario Outline: Unrep Provides Medical Preferences 
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME in '<status>'
	Then medical preferences are sent to Independent Expert

Examples:
|status|
|Pending-MedicalPartLiable|	

Scenario: DME uploads report-No prognosis
	Given claimant selects DME
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: unrep Claimant adds more losses and proceeds with offer
	Given claimant reviews medical report when uploaded by DME
	And Claimant Adds losses from losses tile
	When Claimant requests an UPLIFT due to EXCEPTIONAL CIRCUMSTANCES
	Then claim is sent to compensator

		
Scenario: Compensator First Offer to Unrep
	Given Claim  is sent to the compensator
	When Compensator makes first offer with NON whiplash injury with uplift
	Then offer is sent to claimant	
	
	
Scenario Outline: unrep rejects offer and goes to court
	Given '<claimant>' receives new offer
	When "<claimant>" decided to go to court after rejecting first offer 
	And '<claimant>' answers NVC
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|unrep|
	
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
	|unrep|
 
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
 	|unrep|

Scenario Outline: The claim is moved to 'Resolved-CourtOffer'
 	Given '<claimant>' goes to court
 	When the claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|unrep|Resolved-CourtOffer|