@failed @mibpro
Feature: Journey 24(Sprint 28 - Journey12)

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
                 | involvement_type_v| multivrn |                               
                 | The driver       | NO    |
	 
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
 
 
Scenario: DME  uploads medical Report with waitout period before prognosis
	Given claimant selects DME 
	When DME uploads the medical report with waitout period before prognosis
	Then Report is sent to claimant
 
Scenario Outline: Claimant Request first Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|mibpro|

Scenario: TPA makes first interim payment
	Given claimant request interm payment to TPA
	When TPA makes interim payment
	Then claimant receives interim payment from TPA
	
	Scenario Outline: Claimant accepts first interim payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews and accept interim decision
	Then payment is not received by the claimant
Examples:
|claimant|
|mibpro|


Scenario Outline: Claimant Request second Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|mibpro|


Scenario Outline: MIBpro decides to go to court over interim non-payment
	Given '<claimant>' interim non-payment SLA is breached
	When Go to court for non-payment option is enabled for '<claimant>'
	Then claimant decides to go to court over interim non-payment
Examples:
|claimant|
|mibpro|


Scenario Outline: MIBpro select court document for interim non-payment
	Given '<claimant>' goes to court over interim
	When '<claimant>' selects document for court for interim non-payment
	Then court document are sent to compensator 
Examples:
|claimant|
|mibpro|	



Scenario: TPA rejects 2nd interim payment of claimant
Given the claim  has been sent to the TPA workbasket
When TPA reject interim payment
Then claimant will review the interim decision


Scenario: Claimant cannot proceed to court for 2nd interim when 1st interim is in court
	Given MIBpro goes to court for first interim
	When mibpro goes to court for second interim over interim rejection
	Then error message is displayed and will not allow the claimant to proceed
	
Scenario: TPA agrees the court document for non-payment of first interim payment
	Given claimant goes to court for interim non payment
	When TPA reviews court document
	Then court docs sent for review to claimant

Scenario Outline: Claimant Acknowledges Court documents for first interim
	Given '<claimant>' checks the documents uploaded by Compensator
	When 	'<claimant>' submit the documents for court for interim
	Then first interim is closed at court stage
Examples:
|claimant|
|mibpro|

Scenario Outline: MIBpro go to court for rejected second interim payment
	Given '<claimant>' goes to court over interim
	When '<claimant>' go to court and selects document for court for interim payment
	Then court document are sent to compensator 
Examples:
|claimant|
|mibpro|

Scenario: TPA agrees the court document for rejection of second interim payment
	Given claimant goes to court for interim non payment
	When TPA reviews court document
	Then court docs sent for review to claimant

Scenario Outline: Claimant Acknowledges Court documents for second interim
	Given '<claimant>' checks the documents uploaded by Compensator
	When 	'<claimant>' submit the documents for court for interim
	Then first interim is closed at court stage
Examples:
|claimant|
|mibpro|
	
Scenario Outline: Claimant Request third Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|mibpro|

Scenario: TPA makes first third payment
	Given claimant request interm payment to TPA
	When TPA makes interim payment
	Then claimant receives interim payment from TPA
	

	Scenario Outline: Claimant accepts third interim payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews and accept interim decision
	Then payment is not received by the claimant
Examples:
|claimant|
|mibpro|


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







