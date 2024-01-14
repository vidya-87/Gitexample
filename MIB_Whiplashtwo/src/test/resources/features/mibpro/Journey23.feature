 @mibpro
Feature: Journey 23

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then MIBpro exits before submitting claim
		Examples:
		 | owner| involvement_type_v | ct_preference|multivrn|location|					
		 | NO	|	The driver | EMAIL|NO|Inside UK|

Scenario: MIBpro continues claim submission
	Given MIBpro logins into whiplash application
	Then MIBpro submits the claim successfully	
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA 
	 
 Scenario: TPA  Accepts full liability
	Given the claim  has been sent to the TPA workbasket
 	 When TPA accepts full liability
  	Then claims acceptance and liability information is passed to claimant

Scenario: MIBpro Provides Medical Preferences 
	Given compensator accepts mibprouser claim liability
	When mibprouser selects medical preferences for an DME 
	Then  mibprouser medical preferences are sent to Independent Expert

Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis
  
Scenario Outline: Claimant add losses and fee
  	Given medical report is sent to mibprouser claimant for review
 	 When '<claimant>' add losses and fee
 	 Then claim will proceed to upload medical reports
Examples:
  | claimant|
  | mibpro|
  
 	
Scenario: MIBpro Claimant reviews and acknowledge medical report and proceed to offer
	Given Mibprouserclaimant received the reports from DME 
	When Mibprouser Claimant reviews medical report and proceed to offer                    
	Then claim will be sent to compensator for first offer to mibprouser claimant

Scenario: Claimant should not be able to add losses/fee
  	Given MIBpro proceeds with offer
  	When MIBpro tries to add loss or fee
  	Then claimant should not be allowed to add loss/fee

Scenario: TPA should not be able to add losses/fee
	Given claimant requests offer to TPA
	When TPA tries to add loss/fee
	Then TPA should not be allowed to add loss/fee
	
Scenario: TPA provides first offer with fee proposal
	Given claimant requests offer to TPA
	When the TPA makes first offer with fee proposal
	Then claim will be sent for claimant acknowledgement

Scenario Outline: TPA decides to withdraw the offer
	Given TPA has made first offer to claimant
	When TPA withdraws the offer at claim '<status>'
	Then TPA gets an option to replace the offer
Examples:
|status|
|Pending-ReviewOffer|
	
Scenario: TPA makes replacement offer
	Given TPA has withdrawn the first offer
	When replacement offer is made to claimant
	Then claim offer is sent to claimant review
	
Scenario: Claimants accepts final offer from TPA
	Given TPA has given replacement offer for MIBpro
	When MIBpro accept the replacement offer
	Then claim is resolved
 
 
  
 