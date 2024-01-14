@mibpro
Feature: Journey 6

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	 | owner | involvement_type_v| multivrn |location|							
	 | NO	|	A passenger in a car/van/lorry| NO	|Inside UK|
	 
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


Scenario: MIBpro Claimant reviews and acknowledge medical report and proceed to offer
	Given Mibprouserclaimant received the reports from DME 
	When Mibprouser Claimant reviews medical report and proceed to offer                    
	Then claim will be sent to compensator for first offer to mibprouser claimant

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
 	