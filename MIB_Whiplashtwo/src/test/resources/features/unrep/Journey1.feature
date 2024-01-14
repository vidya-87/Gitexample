@unrep
Feature: Journey 1


Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |location|							
	 | NO	|I was the driver	| EMAIL    | NO	|Inside UK|
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
	 
Scenario: TPA  Accepts full liability
	Given the claim  has been sent to the TPA workbasket
 	 When TPA accepts full liability
  	Then claims acceptance and liability information is passed to claimant
  
Scenario Outline: Unrep Provides Medical Preferences 
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME
	And '<claimant>' adds fee
	Then medical preferences are sent to Independent Expert
 Examples:
 |claimant|
 |unrep|
 
Scenario Outline: Claimant Request  Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|unrep|	
	
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
|unrep|

Scenario: Unrep requests decides to waitout and request for further medical report
	Given medical report is sent to claimant for review
	When Claimant decides waitout and obtains further medical report
	Then request is sent to compensator

Scenario: TPA accepts the request for further medical report
	Given claimant has given a request medical report
	When TPA provides the consent for obtaining further medical report
	Then TPA decision is sent to the claimant

Scenario Outline: Unrep uploads further medical report
	Given '<claimant>' receives claim
	When unrep uploades further medical report
	Then medical report is uploaded successfully
Examples:
|claimant|
|unrep|

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
|unrep |


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
|unrep |
	
Scenario: Claimant proceeds with offer after prognosis                                                                 
	Given Claimant waitout Prognosis period is completed
	When claimant proceeds with offer after uploading new report
	Then claim will be sent to compensator for review
	

Scenario: TPA First Offer to Unrep
	Given claimant requests offer to TPA
	When the TPA makes first offer with fee proposal
	Then offer is sent to claimant

Scenario Outline: Claimant Reject First Offer to TPA
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer
	Then counter offer is sent for revision
Examples:
|claimant|
|unrep|

Scenario: TPA makes revised offer
	Given Claimant requested for revised offer to TPA
	When revised offer is sent to the claimant
	Then offer is sent to claimant

Scenario Outline: Claimant accepts waitout, adds losses and proceeds to offer
	Given '<claimant>' receives the offer
	When Claimant accepts wait out prognosis and proceeds to offer
	Then claim will be routed to TPA
Examples:
|claimant|
|unrep|	
	
Scenario: TPA provides updated financial offer
	Given claimant has added more losses and proceeds to offer
	When TPA provides updated financial offer
	Then offer is sent to claimant

Scenario Outline: Claimant accepts the offer and fee proposal
	Given '<claimant>' receives the revised offer
	When '<claimant>' accepts revised offer
	Then revised offer acceptance is sent
Examples:
|claimant|
|unrep|	
	


Scenario Outline: TPA acknowledges offer
 	Given claimant accepts the offer
  When TPA acknowledges claimants offer with claim '<status>'
  Then claimant offer is sent for revision
  
 Examples:
 |status|
 |Pending-Acknowledgement|
  
Scenario: Claimant decides to go to court (OCS3)
	Given claim is pending and SLA breached
	When claimant decides to go to court for settlement of offer and fee
	Then documents will be sent to TPA

Scenario Outline: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-OfferListReview|
   
Scenario Outline: unrep Claimant checks the documents selected by Compensator and submit the claim for court 
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When '<Claimant>' submit the claim for court with claim '<status>'                      
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|status|
 	|unrep|Pending-OfferListAccept|
 
 Scenario Outline: The claim is moved to 'Resolved-NonPayment'
 	Given '<claimant>' goes to court
 	When the claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|unrep|Resolved-NonPayment|
 
