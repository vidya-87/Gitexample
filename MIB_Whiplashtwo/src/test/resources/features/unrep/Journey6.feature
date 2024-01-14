@unrep
Feature: Journey 6

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner | involvement_type_v| ct_preference| multivrn |location|							
	 | NO	|	I was a passenger in a Car/Lorry/Van| BOTH | NO	|Inside UK|
	 
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

Scenario: Claimant proceeds with offer
	Given Medical report received by claimant with no prognosis
	When claimant proceeds with offer
	Then claim will be routed to compensator for first offer

Scenario: compensator receives the claim with Losses added by claimant after WOP
	Given Claim  is sent to the compensator
	When the compensator makes first offer
	Then offer is sent to claimant


Scenario: Compensator removes the claim from portal
  Given compensator makes first offer to claimant
  When the compensator removes the claim from portal
  Then the claim is removed from portal and closed

 Scenario: The removed claim should be sent to resolved claim
 	Given the compensator has removed the claim
 	When claim is moved to resolved
 	Then claim is successfully removed
 	