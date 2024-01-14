 @unrep
Feature: Journey 23


Scenario Outline: Unrep submits claim as owner
		Given unrep logins into whiplash application
		And claimant exits before submitting the claim
		When user continues for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
		Then claim reference number for unrep claim is created
		Examples:
		 | owner| involvement_type_v | ct_preference|multivrn|location|					
		 | YES	|	I was the driver | EMAIL|NO|Inside UK|
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA 
	 
 Scenario: TPA  Accepts full liability
	Given the claim  has been sent to the TPA workbasket
 	 When TPA accepts full liability
  	Then claims acceptance and liability information is passed to claimant

Scenario: unrep Claimant makes medical provider selection (DME) and adds losses and documents
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME
	Then medical preferences are sent to Independent Expert

Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis
  
Scenario Outline: Claimant add losses and fee
  	Given DME uploads medical report
 	 When '<claimant>' add losses and fee
 	 Then claim will proceed to upload medical reports
Examples:
  | claimant|
  | unrep|
  
 	
Scenario: Claimant decides to proceed with offer                                                                
	Given claimant reviews medical report when uploaded by DME
	When Claimant reviews report and proceed to offer
	Then claim will be sent to compensator for review

Scenario: Claimant should not be able to add losses/fee
  	Given claimant has proceeded with offer
  	When Claimant tries to add loss or fee
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
	Given TPA has given replacement offer
	When Claimant accept the replacement offer
	Then claim is resolved
 
 
  
 