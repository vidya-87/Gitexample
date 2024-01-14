@unrep
Feature: Journey 32

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	|owner | involvement_type_v| ct_preference| multivrn |location|							
	|NO		|	I was the driver | EMAIL 		| NO	|Outside Uk|
	 
	 
Scenario: Compensator accepts full Liability
	Given Claim  is sent to the compensator
	When compensator accepts claim and makes full liability without dispute
	Then the claims acceptance and liability is now sent to the claimant

Scenario Outline: Claimant uploads medical report
	Given '<claimant>' receives claim
	When '<claimant>' uploads own medical report
	Then medical report is uploaded successfully
Examples:
|claimant|
|unrep|


Scenario Outline: Claimant proceeds with offer
	Given '<claimant>' has uploaded medical report
	When Claimant proceeds to offer 
	Then claim is sent to compensator
Examples:	
|claimant|
|unrep|


Scenario: compensator makes first offer
	Given Claim  is sent to the compensator
	When the compensator makes first offer
	Then offer is sent to claimant
	
Scenario Outline: Claimant reject first offer and make 1st counter offer
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer
	Then counter offer is sent for revision
Examples:
|claimant|
|unrep|

Scenario: Compensator makes second offer
	Given compensator rejects counter offer
	When revised offer is sent to the claimant
	Then offer is sent to claimant

Scenario Outline: Unrep makes 2nd counter offer
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|unrep|

Scenario: Claimant accepts rejected offer (Compensators second offer)
	Given claimant has made counter offer
	Then claimant accepts rejected offer
	
Scenario: Claimant Request fee
	Given claimant accepts offer without fee
	When claimant requests fee
	Then fee request is sent to the compensator

Scenario: Compensator makes fee proposal
	Given claimant has requested for fee
	When compensator make fee proposal
	Then fee proposal is sent to claimant

Scenario: Claimant accepts fee proposal
	Given fee offer has been made to the claimant
	When claimant accepts the fee proposal
	Then Acknowledgement for offer acceptance will be sent to compensator
	
Scenario Outline: Compensator acknowledges offer
 Given Claim  is sent to the compensator
 When Compensator acknowledges claimants offer with claim '<status>'
 Then claim SLA is breached
 Examples:
 |status|
 | Pending-Acknowledgement|
  
Scenario: Claimant goes to court on Non payment for fees(OCS5)
 Given Claimant claim liability has been rejected
 When claimant wants to go to court on Non payment for fees
 Then the claimant goes to court

 	
 Scenario Outline: Compensator review and agrees to claimant court document
  Given claimant selects court documents compensator
  When Compensator agrees to court documents when claim is in '<status>'
  Then claim will be sent for claimant acknowledgement
 Examples:
 |status|
 |Pending-FeesListReview|
  
 
 Scenario Outline: unrep Claimant checks the documents selected by compensator and submit the claim for court    
  Given '<Claimant>' checks the documents uploaded by Compensator   
  When '<Claimant>' submit the claim for court with claim '<status>'                          
  Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|status|
 	|unrep|  Pending-FeesListAccept|

	