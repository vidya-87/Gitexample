@mibpro
Feature: Journey 22


Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
            | involvement_type_v  | multivrn |                               
     				| A passenger on a bus| NO       |
	 
	 
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
	When MIBpro update the losses and fee from Loss Tile and proceeds with offer                    
	Then claim will be sent to compensator for first offer to mibprouser claimant
#
#Scenario: MIBpro Claimant reviews and acknowledge medical report and proceed to offer
#	Given Mibprouserclaimant received the reports from DME 
#	When  Mibprouser Claimant reviews medical report and proceed to offer
#	Then claim will be sent to compensator for first offer to mibprouser claimant

Scenario: Compensator makes First Offer with fee proposal
 	Given Claim  is sent to the compensator
 	When the compensator makes first offer with fee proposal
 	Then offer is sent to claimant 
 
Scenario: MIBpro claimant accepts offer and rejects fee proposal
  Given MIBpro claimant review fee proposal
  When MIBpro accepts offer and makes counter fees proposal
  Then MIBpro counter offer sent to compensator
 
Scenario:  Compensator doesnot respond to the counter fee proposal and claimant goes to court(OCS4)
	Given Compensator doesnot respond to the counter offer request
	When mibprouser claimant goes to court over non response fee proposal            
	Then claim will be sent to compensator
 	
Scenario: Compensator acknowledges documents selected for court
	Given claimant selects court documents compensator
	When Compensator agrees to court documents
	Then claim will be sent for claimant acknowledgement

Scenario: mibprouser Claimant acknowledges Compensators doc selection and case is resolved
Given mibprouser receives claim for acknowledgement
When mibprouser claimant acknowledge
Then case is closed at court stage for mibprouser claimant
	
	