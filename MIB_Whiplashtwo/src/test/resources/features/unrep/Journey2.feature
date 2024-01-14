@unrep
Feature: Journey 2

 
Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |location|							
	 | NO|	I was a passenger in a Car/Lorry/Van	| BOTH		| YES	|Inside UK|
	 
Scenario: CSR allocates claim to  compensator
Given Claim received by csr and eligible for assigning to compensator
When CSR assigns compensator
Then Claim is sent to respective compensator
	 
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
	
	
	
	#################### Sprint 41 #########################
	
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
	When '<claimant>' selects interim docs for court with Court proceeding No
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
	When claimant acknowledges selected documents with proceeding No
	Then Interim case is resolved at court
	
	###########################################################


Scenario: Unrep Provides Medical Preferences
	Given the unrep claim moves to partial liability
	When unrep chooses DME after reopening claim
	Then medical preferences are sent to Independent Expert

Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: Claimant selects option 'No' for the question "Do you believe the facts in the medical report are complete and correct?" and request for further medical
	Given medical report is sent to claimant for review
	And Claimant Adds fee from losses tile
	When Claimant requests for second report
	Then Claimant need to visit DME for medical examination again

Scenario: DME  uploads medical Report with waitout period before prognosis
	Given Claimant requests further medical report after marking factually incorrect 
	When DME upload further report
	Then Report is sent to claimant
	
Scenario: Claimants proceeds to offer
 	Given Claimant waitout Prognosis period is completed
 	When unrep claimant proceeds with offer
 	Then claim will be sent to compensator for review
 	
Scenario: Compensator makes First Offer with fee proposal
	Given Claim  is sent to the compensator
	When the compensator makes first offer with fee proposal
	Then offer is sent to claimant

Scenario: Unrep Claimant accepts offer
	Given Claimant received offer details 
	When Claimant accepts offer     
	Then Acknowledgement for offer acceptance will be sent to compensator

Scenario Outline: Compensator acknowledges offer
	 Given Claim  is sent to the compensator
	 When Compensator acknowledges claimants offer with claim '<status>'
 	Then the claim can be Resolved
Examples:
|status|
|Pending-Acknowledgement|

	

