@mibpro
Feature: Journey 2

 
Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	|owner | involvement_type_v| multivrn |location|							
	|NO	|A passenger in a car/van/lorry | YES	|Inside Uk|
	 
Scenario: CSR allocates claim to  compensator
	Given Claim received by csr and eligible for assigning to compensator
	When CSR assigns compensator
	Then Claim is sent to respective compensator
	 
Scenario: Compensator  Accept Claim and denies Liability
	Given Claim  is sent to the compensator
	When compensator denies full liability
	Then the claims acceptance and liability is now sent to the claimant

Scenario: Claimant Challenge Decision and goes to court
	Given MIBpro claim liability has been rejected
	When MIBpro wants to challenge decision and decided to go to court
	Then the claimant goes to court

 	
Scenario Outline: Compensator review and agrees to claimant court document
 	Given claimant selects court documents compensator
  	When Compensator agrees to court documents when claim is in '<status>'
  	Then the claim can be Resolved
  
 Examples:
 |status|
 |Pending-LiabilityListReview|
 
 Scenario Outline: Claimant checks the documents selected by compensator and submit the claim for court    
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When MIBpro submits the court documents for liability                        
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|mibpro|   
 	
Scenario: Compensator reopens claim and accepts full claim liability
	Given claimant uploads court documents
	When compensator reopens liability disputed claim
	Then compensator accepts full liability
	
	
	###########Sprint 41####################
	
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
	When '<claimant>' selects interim docs for court with Court proceeding No
	Then court document are sent to compensator

Examples:
|claimant|
|mibpro|



Scenario: Compensator reviews court document for Interim non-payment
		Given claimant goes to court
		When Compensator reviews court document for interim
		Then court docs sent for review to claimant

Scenario: mibpro acknowledges documents selected by compensator
	Given compensator confirmed documents selected by MIBpro
	When mibpro acknowledges selected documents with proceeding No
	Then Interim case is resolved at court
	
	###############################################


Scenario Outline: Unrep Provides Medical Preferences
	Given MIBpro claim moves to partial liability
	When MIBpro makes medical provider selection '<status>'
	Then medical preferences are sent to Independent Expert
Examples:
	|status|
	|Pending-MedicalAfterCourt|

Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario Outline: Claimant selects option 'No' for the question "Do you believe the facts in the medical report are complete and correct?" and request for further medical
	Given medical report is sent to MIBpro for review
	When MIBpro requests for second report
	And '<claimant>' adds fee
	Then Claimant need to visit DME for medical examination again
Examples:
|claimant|
|mibpro|

Scenario: DME  uploads medical Report with waitout period before prognosis
	Given Claimant requests further medical report after marking factually incorrect 
	When DME upload further report
	Then Report is sent to claimant
	
Scenario: Claimants proceeds to offer
 	Given Mibprouserclaimant received the reports from DME
 	When Mibprouser Claimant reviews medical report and proceed to offer
 	Then claim will be sent to compensator for review
 	
Scenario: Compensator makes First Offer with fee proposal
	Given Claim  is sent to the compensator
	When the compensator makes first offer with fee proposal
	Then offer is sent to claimant

Scenario: Claimant accepts offer
	Given MIBpro review offer and fee proposal 
	When mibprouser claimant accept first offer and fees proposal     
	Then Acknowledgement for offer acceptance will be sent to compensator

Scenario Outline: Compensator acknowledges offer
	 Given Claim  is sent to the compensator
	 When Compensator acknowledges claimants offer with claim '<status>'
 	Then the claim can be Resolved
Examples:
|status|
|Pending-Acknowledgement|


