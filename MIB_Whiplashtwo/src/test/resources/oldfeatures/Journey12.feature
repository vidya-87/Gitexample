@mibpro
Feature: Journey 12

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
     | username     | involvement_type_v| multivrn |                               
     | vandana@cognizant.com   | The driver       | NO    |
	 
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
  
 
Scenario Outline: Claimant Request first Interim Payment 
Given claim has been accepted for '<claimant>'
When '<claimant>' requests interim payment
Then interim payment request is sent to compensator
Examples:
|claimant|
|mibpro|
	
Scenario: DME  uploads medical Report with waitout period before prognosis
	Given claimant selects DME 
	When DME uploads the medical report with waitout period before prognosis
	Then Report is sent to claimant

Scenario: TPA makes first interim payment
	Given claimant request interm payment to TPA
	When TPA makes interim payment
	Then claimant receives interim payment from TPA
	
Scenario Outline: Claimant Request second Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews the interim payment and requests another interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|mibpro|

Scenario: Claimant accepts wait out prognosis
Given Medical report received by MIBPro claimant with wait out prognosis
When MIBPro claimant accepts wait out prognosis and release to comp  
Then MIBPro claimant need to wait until waitout prognosis period ends

Scenario: TPA makes second interim payment
	Given claimant request interm payment to TPA
	When TPA makes interim payment
	Then claimant receives interim payment from TPA
	
Scenario Outline: Claimant requests third interim
Given claim has been accepted for '<claimant>'
When '<claimant>' reviews the interim payment and requests another interim payment
Then interim payment request is sent to compensator
Examples:
|claimant|
|mibpro |


Scenario: TPA makes third interim payment
	Given claimant request interm payment to TPA
	When TPA makes interim payment
	Then claimant receives interim payment from TPA
	
Scenario Outline: Claimant reviews and accepts third interim payment decision
Given claim has been accepted for '<claimant>'
When '<claimant>' reviews and accept interim decision 
Then claimant accepts interim decision
Examples:
|claimant|
|mibpro |
	
Scenario: MIBPRO Claimant proceeds with offer before prognosis period completes                                                               
Given MIBPro Claimant waitout Prognosis period is not completed
When MIBPro claimant proceeds with offer before prognosis
Then claim will be sent to compensator for review
	

Scenario: TPA First Offer to MIBpro
Given claimant requests offer to TPA
When the TPA makes first offer with fee proposal
Then claim will be sent for claimant acknowledgement

Scenario Outline: Claimant Reject First Offer to TPA
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision

Examples:
|claimant|
|mibpro|

Scenario: TPA makes revised offer
	Given Claimant requested for revised offer to TPA
	When TPA accepts the claimant revised offer
	Then offer is sent to claimant

Scenario: MIBPro Claimant Accepts Revised Offer and fee proposal from TPA
Given MIBPro Claimant receives revised offer
When MIBPro claimant accepts offer and fee proposal
Then revised offer acceptance is sent


Scenario: TPA acknowledges offer
 	Given claimant accepts the offer
  When TPA acknowledges claimants offer
  Then claim SLA is breached
  
Scenario: MIBPRO Claimant decides to go to court (OCS3)
	Given claim is pending for settlement for MIBPRO
	When MIBPro claimant decides to go to court for claim settlement pending
	Then documents will be sent to TPA

Scenario: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents
   Then claim will be sent for claimant acknowledgement 
   
Scenario Outline: MIBPro Claimant checks the documents selected by Compensator and submit the claim for court 
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When '<Claimant>' submit the claim for court                          
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|mibpro| 
