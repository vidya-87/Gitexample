@unrep
Feature: Journey 26

Scenario Outline: Unrep claim creation
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |	location|							
	 | YES	|	I was the driver	| BOTH		| NO	| Inside UK|
	 
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
  | unrep|
 
 Scenario Outline: Claimant Request first Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|unrep|	

Scenario: Compensator makes first interim payment
	Given claimant request interm payment to TPA
	When TPA makes interim payment
	Then claimant receives interim payment
  

Scenario: Unrep Provides Medical Preferences 
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME 
	Then medical preferences are sent to Independent Expert

Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: unrep decides to remove loss
		Given unrep decides to remove loss
		When unrep removes the loss
		Then the loss should be removed successfully

Scenario: unrep Claimant reviews and request for UPLIFT
	Given claimant reviews medical report when uploaded by DME
	When Claimant requests an UPLIFT due to EXCEPTIONAL CIRCUMSTANCES
	Then claim is sent to compensator


Scenario: TPA make first offer with loss added and disagree uplift
	Given the claim  has been sent to the TPA workbasket
	When TPA disagrees to an UPLIFT and makes first offer
	Then offer is sent to claimant 


Scenario Outline: Unrep disputes the offer and goes to court and answers NVC
	Given '<claimant>' receives the offer
	When Claimant reject offer and goes to court and answers NVC
	Then counter offer is sent for revision
	
	Examples:
	|claimant|
	|unrep|

	
Scenario Outline: TPA withdraws the offer at 'Pending-NVCResponse' status
 	Given TPA receives claim to review NVC answers
 	When TPA withdraws the offer at claim '<status>'
 	Then the claim moves to withdrawal status
Examples:
|status|
|Pending-NVCResponse|



	


	