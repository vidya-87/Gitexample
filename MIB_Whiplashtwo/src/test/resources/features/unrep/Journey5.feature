@unrep
Feature: Journey 5

Scenario Outline: User Enters details in your details page
		Given unrep logins into whiplash application
		When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
		Then claim reference number for unrep claim is created
		Examples:
		 | owner| involvement_type_v | ct_preference|multivrn|location|					
		 | YES	|	I was the driver | EMAIL|NO|Inside UK|
		 
Scenario: CompensatorA transfers claim to CompensatorB
	 Given Claim  is sent to the compensator
	 When compensator transfer claim to compensatorB
	Then the claim is sent to CompensatorB	
	
Scenario: CompensatorB rejects transfer request
	Given Transfer request sent to CompensatorB
	When compensatorB rejects transfer request
	Then claim not moved to CompensatorB workbasket		 
	 
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


Scenario Outline: Claimant Request Second Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|unrep|	
	
Scenario: Compensator makes Second interim reduced payment
	Given claimant request interm payment to compensator
	When compensator accepts reduced interim payment
	Then claimant receives interim payment

Scenario: Claimant goes to court for reduced interim payment
	Given the compensator makes interim payment
	When claimant goes to court for interim 
	Then claim will be sent to compensator for review

Scenario: Compensator reviews court document for second Interim
		Given claimant goes to court
		When Compensator reviews court document for interim
		Then court docs sent for review to claimant

Scenario: Unrep acknowledges documents selected by compensator
	Given compensator confirmed documents selected by claimant
	When claimant acknowledges selected documents   
	Then Interim case is resolved at court but the main claim carries on



Scenario:  Unrep reviews medical report and proceeds with offer
	Given DME uploads medical report
	And Claimant Adds fee from losses tile
	When claimant reviews medical report and acknowledges the report
	Then claim is sent to compensator

Scenario: Compensator makes First Offer with fee proposal
	Given Claim  is sent to the compensator
	When the compensator makes first offer with fee proposal
	Then offer is sent to claimant
	
Scenario Outline: Claimant dispute offer and goes to court and answers NVC questions
	Given '<claimant>' decided to go to court
	When '<claimant>' reject offer and answers NVC
	Then Claimant selection to go to court is confirmed	

Examples:
|claimant|
|unrep|

Scenario: Compensator responds to NVC questions
   Given Compensator receives claim to review NVC answers
   When Compensator responds to NVC answers
   Then claim should be sent to claimant to select documents for court
  
  
Scenario Outline: unrep Claimant selects documents for court     
 	Given Compensator responds NVC answers to '<Claimant>'    
 	When '<Claimant>' selects documents for court after NVC
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
   
Scenario Outline: Claimant decides to withdraw claim 
  Given '<claimant>' receives claim
  When the unrep claimant then decides to withdraw the claim at '<status>'
  Then the claimant has withdrawn claim and Compensator to acknowledge this
 Examples:
 |claimant|status|
 |unrep|Pending-OfferListAccept|
  
 Scenario: Compensator acknowledges the withdrawl and claim resolved
  Given Claim  is sent to the compensator
  When Compensator acknowledges claimants withdrawal
  Then the claim can be Resolved
	
Scenario Outline: Verify the claim is moved to Resolved status
	Given the compensator has acknowledged
	When claim '<status>' is verified
	Then claim is moved to resolved status successfully
Examples:
|status|
|Resolved-Withdrawn|
	


	