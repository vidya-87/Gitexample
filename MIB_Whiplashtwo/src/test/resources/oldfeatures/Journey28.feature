@mibpro
Feature: Journey28(Sprint29)

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
     | username                              | involvement_type_v| multivrn |                               
     | vandana@cognizant.com            | A passenger on a bus        | NO    |
	 
	 
Scenario: Compensator  Accept Claim and full Liability
	Given Claim  is sent to the compensator
	When compensator accepts claim and makes full liability without dispute
	Then the claims acceptance and liability is now sent to the claimant

	
Scenario Outline: Claimant add losses and fee
  Given compensator accepts mibprouser claim liability
  When '<claimant>' add losses and fee
  Then claim will proceed to upload medical reports
Examples:
  | claimant|
  | mibpro|
  
  
Scenario: MIBpro Provides Medical Preferences 
	Given compensator accepts mibprouser claim liability
	When mibprouser selects medical preferences for an DME 
	Then  mibprouser medical preferences are sent to Independent Expert


Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: MIBpro removes losses
	Given MIBpro proceeds with offer
  When claimant decides to removes losses
  Then losses are removed successfully

Scenario: MIBpro Claimant reviews and acknowledge medical report and proceed with offer
	Given Mibprouserclaimant received the reports from DME 
	When  Mibprouser Claimant reviews medical report and proceed to offer                    
	Then claim will be sent to compensator for first offer to mibprouser claimant

 Scenario: Compensator makes First Offer with fee proposal
 	Given Claim  is sent to the compensator
 	When the compensator makes first offer with fee proposal
 	Then offer is sent to claimant 

 Scenario: MIBpro accepts offer and fee proposal
 
   Given MIBpro review offer and fee proposal
   When mibprouser claimant accept first offer and fees proposal
   Then first offer acceptance by mibprouser is sent to compensator for acknowledgement

