@mibpro
Feature: Journey 26

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	 | owner| involvement_type_v| multivrn |	location|							
	 | YES	|	The driver	| NO	| Inside UK|
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
	 
Scenario: TPA  Accepts full liability
	Given the claim  has been sent to the TPA workbasket
  When TPA accepts full liability
  Then claims acceptance and liability information is passed to claimant

Scenario Outline: Claimant add losses and fee
  Given claim has been accepted for '<claimant>'
  When '<claimant>' add losses and fee
  Then claim will proceed to upload medical reports
Examples:
  | claimant|
  | mibpro|
 
 Scenario Outline: Claimant Request first Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|mibpro|	

Scenario: Compensator makes first interim payment
	Given claimant request interm payment to TPA
	When TPA makes interim payment
	Then claimant receives interim payment
  

Scenario: Claimant makes medical provider selection (DME) and adds losses and documents
	Given compensator accepts mibprouser claim liability
	When mibprouser selects medical preferences for an DME
	Then medical preferences are sent to Independent Expert


Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: unrep decides to remove fee
		Given MIBpro decides to remove loss
		When MIBpro decides to removes losses
		Then the loss should be removed successfully

Scenario: MIBpro Claimant reviews and request for UPLIFT
	Given MIBpro reviews medical report when uploaded by DME
	When MIBpro proceeds with offer with uplift
	Then claim is sent to compensator


Scenario: TPA make first offer with loss added and disagree uplift
	Given the claim  has been sent to the TPA workbasket
	When TPA disagrees to an UPLIFT and makes first offer
	Then offer is sent to claimant 


Scenario Outline: MIBpro disputes the offer and goes to court and answers NVC
	Given '<claimant>' receives the offer
	When MIBpro reject offer and goes to court and answers NVC
	Then counter offer is sent for revision
	
	Examples:
	|claimant|
	|mibpro|

	
Scenario Outline: TPA withdraws the offer at 'Pending-NVCResponse' status
 	Given TPA receives claim to review NVC answers
 	When TPA withdraws the offer at claim '<status>'
 	Then the claim moves to withdrawal status
Examples:
|status|
|Pending-NVCResponse|



	


	