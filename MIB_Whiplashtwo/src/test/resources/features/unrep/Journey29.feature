@unrep
Feature: Journey 29

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |location|							
	 | NO|	I was a passenger on a bus	| BOTH| NO	|Inside UK|
	 							
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
	 
	
Scenario: TPA  Denies Claim and claim Liability
	Given the claim  has been sent to the TPA workbasket
  	When  TPA dispute claim liability
 	 Then  claims acceptance and liability information is passed to claimant
 
Scenario: Claimant Challenge Decision and goes to court
	Given Claimant claim liability has been rejected
	When claimant wants to challenge decision and decided to go to court
	Then the claimant goes to court

Scenario: TPA disagree for document selection
	Given Uploaded documents for court cofirmed by Claimant
	When TPA disagrees to court documents uploaded by Claimant
	Then claimant need to review the documents uploaded by TPA

Scenario Outline: Unrep Claimant acknowledges TPA doc selection and case is resolved
	Given '<Claimant>' checks the documents uploaded by TPA  
  	When claimant submits the court documents for liability                        
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|unrep| 
	
Scenario: Claimant decides to reopen the claim with court decision as part liability
	 Given Court has resolved the claim
	 When Claimant reopens liability disputed claim
	 Then unrep reopens the claims sucessfully

Scenario: Claimant should not be able to challenge liability
 	Given claimant has reopened the claim
 	When claimant tries to challenge liability
 	Then the link should not be present
 	
Scenario: TPA should not be able change liability decision
	Given the claim is reopened by the claimant
	When TPA tries to change the liability decision
	Then the link should not be present 
	
Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis



Scenario Outline: Claimant proceeds with offer
	Given '<claimant>' has uploaded medical report
	When claimant reviews medical report and acknowledges the report
	Then claim proceeds to offer
Examples:
|claimant|
|unrep|

Scenario: Compensator disputes causation at offer and makes final offer
 	Given claimant has request for an offer
 	When Compensator disputes causation and make final offer
 	Then claim is sent to claimant

 Scenario: Claimant accepts the decision and no offer is made
	Given compensator has disputed causation
	When claimant reject the dispute causation final offer
	Then claim moves to Resolved-FinalOfferRejected
 	

  