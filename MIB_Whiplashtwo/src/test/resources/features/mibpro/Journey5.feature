@mibpro
Feature: Journey 5

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
		Examples:
		 | owner| involvement_type_v |multivrn|location|					
		 | YES	|The driver |NO|Inside UK|
	 
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


Scenario Outline: Claimant Request Second Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|mibpro|	
	
Scenario: Compensator makes Second interim reduced payment
	Given claimant request interm payment to compensator
	When compensator accepts reduced interim payment
	Then claimant receives interim payment

Scenario: Claimant goes to court for reduced interim payment
	Given the compensator makes reduced interim payment
	When MIBpro reject interim and goes to court 
	Then claim will be sent to compensator for review

Scenario: Compensator reviews court document for second Interim
		Given claimant goes to court
		When Compensator reviews court document for interim
		Then court docs sent for review to claimant

Scenario: MIBpro acknowledges documents selected by compensator
	Given compensator confirmed documents selected by MIBpro
	When MIBpro acknowledges selected documents    
	Then Interim case is resolved at court but the main claim carries on



Scenario:  MIbpro reviews medical report and proceeds with offer
	Given Mibprouserclaimant received the reports from DME
	When MIBpro update fee from Loss Tile and proceeds with offer
	Then claim is sent to compensator

Scenario: Compensator makes First Offer with fee proposal
	Given Claim  is sent to the compensator
	When the compensator makes first offer with fee proposal
	Then offer is sent to claimant
	
Scenario Outline: Claimant dispute offer and goes to court and answers NVC questions
	Given '<claimant>' decided to go to court
	When MIBpro claimant reject offer and goes to court and answers NVC
	Then Claimant selection to go to court is confirmed	

Examples:
|claimant|
|mibpro|

Scenario: Compensator responds to NVC questions
   Given Compensator receives claim to review NVC answers
   When Compensator responds to NVC answers
   Then claim should be sent to claimant to select documents for court
  
  
Scenario Outline: MIBpro Claimant selects documents for court     
 	Given Compensator responds NVC answers to '<Claimant>'    
 	When '<Claimant>' selects documents for court after NVC
 	Then documents should be reviewed by Compensator
 	Examples:
 	|Claimant|
 	|mibpro|
 	
 Scenario Outline: Compensator acknowledges documents selected for court
   Given claimant selects court documents compensator
   When Compensator agrees to court documents when claim is in '<status>'
   Then claim will be sent for claimant acknowledgement
 Examples:
 |status|
 |Pending-OfferListReview| 
   
Scenario Outline: Claimant decides to withdraw claim 
  Given '<claimant>' receives claim
  When the MIB prouser claimant then decides to withdraw the claim at '<status>'
  Then the claimant has withdrawn claim and Compensator to acknowledge this
 Examples:
 |claimant|status|
 |mibpro|Pending-OfferListAccept|
  
 Scenario: Compensator acknowledges the withdrawl and claim resolved
  Given Claim  is sent to the compensator
  When Compensator acknowledges claimants withdrawal
  Then the claim can be Resolved
	
 Scenario Outline: The claim is moved to 'Resolved-Withdrawn'
 	Given '<claimant>' goes to court
 	When mibpro claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
Examples:
|status|
|Resolved-Withdrawn|
	


	