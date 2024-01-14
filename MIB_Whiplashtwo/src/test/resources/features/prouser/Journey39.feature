@prouser
Feature: Journey 39


Scenario Outline: Prouser Submit a Claim as passenger in a car
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|		owner|	multivrn|	
	 |	A passenger on a bus|	NO|NO|
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA	 
	 
Scenario: TPA disputes causation and admits full liability
	Given Login as TPA
  When TPA accepts full liability
  Then claims acceptance and liability information is passed to claimant


Scenario Outline: Claimant Request first Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|prouser|	

Scenario: Compensator makes first interim payment
	Given Login as TPA
	When compensator makes interim payment
	Then claimant receives interim payment

Scenario Outline: Claimant reviews and accepts first interim payment
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews and accept interim decision 
	Then payment is not received by the claimant
Examples:
|claimant|
|prouser|


Scenario Outline: Claimant decides to go to court for interim over non-payment 
	Given '<claimant>' interim non-payment SLA is breached
	When Go to court for non-payment option is enabled for '<claimant>'
	Then claimant decides to go to court over interim non-payment
Examples:
|claimant|
|prouser|

Scenario Outline: Claimant select court docs for interim non-payment
	Given '<claimant>' goes to court over interim
	When '<claimant>' selects document for court for interim non-payment
	Then court document are sent to compensator

Examples:
|claimant|
|prouser|	

Scenario: Compensator reviews court document for Interim non-payment
		Given Login as TPA
		When Compensator reviews court document for interim
		Then court docs sent for review to claimant
		
Scenario: prouser Claimant acknowledges TPA doc selection and case is resolved
	Given prouser receives claim for acknowledgement
	When prouser claimant acknowledge for Interim
	Then case is closed at court stage	 


Scenario Outline: Prouser uploads medical report
	Given upload medical report is enabled for '<claimant>'
	When "<claimant>" uploads medical report with Uplift request
	Then medical report is uploaded and offer request is sent to compensator
	Examples:
	|claimant|
	|prouser|	
		
		
Scenario: TPA First Offer to Prouser
	Given Login as TPA
	When the TPA makes first offer with NON whiplash injury with uplift
	Then offer is sent to claimant
	
Scenario Outline: Prouser rejects offer and goes to court
	Given '<claimant>' receives new offer
	When "<claimant>" decided to go to court after rejecting first offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|
	
	
Scenario Outline: Prouser selected Court proceeding started and selected documents for court
	Given "<claimant>" started court proceeding
	When "<claimant>" selected Court proceeding started as Yes
	And "<claimant>" selected documents for court
	Then documents sent to TPA
	Examples:
	|claimant|
	|prouser|
	
Scenario Outline: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-OfferListReview|	
	
Scenario Outline: Claimant checks the documents selected by TPA and proceeds the claim for court 
   Given '<claimant>' checks the documents uploaded by Compensator   
   When "<claimant>" entered details in court screen                       
   Then  Case is closed with Go to court at offer stage  	
Examples:
 	|claimant|
 	|prouser|
	
