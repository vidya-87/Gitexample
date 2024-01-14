@unrep
Feature: Journey 33

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	|owner | involvement_type_v| ct_preference| multivrn |location|							
	|NO		|	I was the driver | EMAIL 		| NO	|Inside Uk|
	 
	 
Scenario: Compensator accepts part Liability
	Given Claim  is sent to the compensator
	When compensator accepts claim and makes part liability
	Then the claims acceptance and liability is now sent to the claimant


Scenario: unrep Claimant selects medical provider selection (DME)
	Given the unrep claim moves to partial liability
	When unrep selects medical preferences
	Then medical preferences are sent to Independent Expert

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

Scenario: Compensator disputes causation at offer and decides not to make any offer
 	Given claimant proceed with offer
 	When Compensator disputes causation at offer
 	Then claim is sent to claimant
 	
 Scenario: Claimant accepts the decision and no offer is made
	Given compensator has disputed causation
	When claimant accepts the dispute causation no offer
	Then claim moves to Resolved-NoOffer


  
