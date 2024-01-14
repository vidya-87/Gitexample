@unrep
Feature: function

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	|owner | involvement_type_v| multivrn |location|							
	|Yes	|The driver | No	|Outside Uk|	 
	
Scenario: Compensator Accept Claim and Part claim Liability
Given Claim  is sent to the compensator
When compensator accepts claim and makes part liability
Then the claims acceptance and liability is now sent to the claimant

Scenario: MIBpro claimant challenge liability decision
	Given the MIBpro claim liability has been accepted by compensator
	When MIBpro claimant challenges Liability
	Then claim will be sent to compensator to update liability

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
	
	
	
	
	
	

