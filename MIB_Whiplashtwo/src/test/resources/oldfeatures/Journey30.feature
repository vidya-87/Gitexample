@mibpro
Feature: Journey30(Sprint 29a)

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
     | username      				| involvement_type_v						| multivrn |                               
     | vandana@cognizant.com| A passenger in a car/van/lorry| NO    |

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
  
Scenario: MIBpro Claimant reviews and acknowledge medical report and proceed to offer with uplift
	Given Mibprouserclaimant received the reports from DME 
	When  Mibprouser Claimant reviews medical report and proceed to offer with uplift                   
	Then claim will be sent to compensator for first offer to mibprouser claimant

Scenario: Compensator makes First Offer with fee proposal
 	Given Claim  is sent to the compensator
 	When Compensator disagrees to an UPLIFT and makes first offer
 	Then offer is sent to claimant 
 
Scenario: MIBpro Claimant requests for revised offer
	Given Mibprouserclaimant received first offer from compensator
	When  Mibprouser Claimant requests for revised offer with uplift   
	Then  claim will be sent to compensator with revised offer

Scenario: Compensator makes revised offer
 Given Claim  is sent to the compensator
 When Compensator decides not to include  UPLIFT amount in second offer
 Then offer is sent to claimant
 
 Scenario: MIBpro Claimant requests for revised offer
	Given Mibprouserclaimant received first offer from compensator
	When  Mibprouser Claimant requests for revised offer with uplift   
	Then  claim will be sent to compensator with revised offer
 
Scenario: MIBpro decides to accept the reject offer
  Given MIBpro has rejected the first offer
  When MIBpro decides to accept the rejected offer
  Then the claim is resolved after offer acceptance