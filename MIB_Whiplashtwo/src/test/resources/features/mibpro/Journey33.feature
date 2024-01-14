@mibpro
Feature: Journey 33

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	|owner | involvement_type_v| ct_preference| multivrn |location|							
	|NO	|The driver | EMAIL 		| YES	|Inside Uk|
	
Scenario: CSR allocates claim to  compensator
	Given Claim received by csr and eligible for assigning to compensator
	When CSR assigns compensator
	Then Claim is sent to respective compensator
	 
	 
Scenario: Compensator accepts part Liability
	Given Claim  is sent to the compensator
	When compensator accepts claim and makes part liability
	Then the claims acceptance and liability is now sent to the claimant

  
Scenario Outline: mibpro Provides Medical Preferences 
	Given compensator accepts mibprouser claim liability
	When MIBpro makes medical provider selection '<status>'
	Then medical preferences are sent to Independent Expert
Examples:
|status|
|Pending-MedicalPartLiable|

Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis


Scenario: MIBpro Claimant reviews and acknowledge medical report and proceed to offer
	Given Mibprouserclaimant received the reports from DME 
	When Mibprouser Claimant reviews medical report and proceed to offer                    
	Then claim will be sent to compensator for first offer to mibprouser claimant

Scenario: Compensator disputes causation at offer and decides not to make any offer
 	Given claimant proceed with offer
 	When Compensator disputes causation at offer
 	Then claim is sent to claimant
 	
 Scenario: Claimant accepts the decision and no offer is made
	Given compensator has disputed causation for MIBpro
	When MIBpro accepts the dispute causation no offer
	Then claim moves to Resolved-NoOffer


  
