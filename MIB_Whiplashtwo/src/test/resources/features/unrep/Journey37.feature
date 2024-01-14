@unrep
Feature: Journey 37

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |	location|							
	 | YES|	I was the driver	| BOTH		| NO	|Inside UK|

	 
Scenario: Compensator  Accept Claim and denies Liability
	Given Claim  is sent to the compensator
	When compensator denies full liability
	Then the claims acceptance and liability is now sent to the claimant	

Scenario: Claimant Challenge Decision and goes to court
Given Claimant claim liability has been rejected
When claimant challenges and goes to court
Then the claimant goes to court

 	
   Scenario Outline: Compensator review and agrees to claimant court document
 	Given claimant selects court documents compensator
  When Compensator agrees to court documents when claim is in '<status>'
  Then the claim can be Resolved
  
 Examples:
 |status|
 |Pending-LiabilityListReview|
 
 Scenario Outline: unrep Claimant checks the documents selected by compensator and submit the claim for court    
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When claimant submits the court documents for liability                        
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|unrep|     
 	
Scenario: Compensator reopens claim and accepts full claim liability
	Given claimant uploads court documents
	When compensator reopens liability disputed claim
	Then compensator accepts full liability
	
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
	When '<claimant>' selects interim docs for court with Court proceeding Yes
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
	When claimant acknowledges selected documents with proceeding yes
	Then Interim case is resolved at court


Scenario: Unrep Provides Medical Preferences 
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME in Pending-MedicalAfterCourt
	Then medical preferences are sent to Independent Expert

Scenario: DME uploads report-No prognosis
	Given claimant selects DME
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: unrep Claimant adds more losses and proceeds with offer
	Given claimant reviews medical report when uploaded by DME
	And Claimant Adds losses from losses tile
	When Claimant requests an UPLIFT due to EXCEPTIONAL CIRCUMSTANCES
	Then claim is sent to compensator

	
Scenario: Compensator decided to make offer with NON WHIPLASH injury
	Given Claim  is sent to the compensator
	When Compensator decided to make offer with non whiplash injury and disagree uplift
	Then compensator sent offer to claimant
	

	
Scenario Outline: Claimant dispute offer and goes to court and answers NVC questions
	Given '<claimant>' decided to go to court
	When Claimant reject offer and goes to court and answers NVC
	Then Claimant selection to go to court is confirmed	

Examples:
|claimant|
|unrep|

Scenario: Compensator responds to NVC questions
   Given Compensator receives claim to review NVC answers
   When Compensator responds NVC 
   Then claim should be sent to claimant to select documents for court
  
  
Scenario Outline: unrep Claimant selects documents for court     
 	Given Compensator responds NVC answers to '<Claimant>'    
 	When '<Claimant>' selects documents for court third time after NVC
 	Then documents should be reviewed by Compensator
 	Examples:
 	|Claimant|
 	|unrep|
 
 Scenario Outline: Compensator acknowledges documents selected for court
   Given claimant selects court documents compensator
   When Compensator agrees to court documents when claim is in '<status>'
   Then claim will be sent for claimant acknowledgement
 Examples:
 |status|
 |Pending-OfferListReview| 	
 
 
Scenario Outline: unrep Claimant checks the documents selected by Compensator and submit the claim for court 
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When '<Claimant>' submit the claim for court third time for NVC                          
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|unrep|      