@unrep
Feature: Journey 33

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	|owner | involvement_type_v| ct_preference| multivrn |location|							
	|NO		|	I was the driver | EMAIL 		| NO	|Inside Uk|
	 
	 
Scenario: Compensator accepts full Liability
	Given Claim  is sent to the compensator
	When compensator accepts claim and makes part liability
	Then the claims acceptance and liability is now sent to the claimant

Scenario Outline: Claimant uploads medical report
	Given '<claimant>' receives claim
	When '<claimant>' uploads own medical report
	Then medical report is uploaded successfully
Examples:
|claimant|
|unrep|


Scenario: Claimant proceeds with offer
	Given '<claimant>' has uploaded medical report
	When Claimant proceeds to offer
	Then claim is sent to compensator
|claimant|
|unrep|


Scenario: compensator receives the claim by claimant after WOP
	Given Claim  is sent to the compensator
	When the compensator makes first offer
	Then offer is sent to claimant

Scenario: Unrep Claimant accepts offer
Given Claimant received offer details 
When Claimant accepts offer     
Then Acknowledgement for offer acceptance will be sent to compensator

Scenario: Compensator acknowledges offer
 Given Claim  is sent to the compensator
 When Compensator acknowledges claimants offer
 Then claim SLA is breached
  
Scenario: Claimant goes to court on Non payment for fees(OCS5)
 Given Claimant claim liability has been rejected
 When claimant wants to go to court on Non payment for fees
 Then the claimant goes to court

 	
 Scenario: Compensator review and agrees to claimant court document
  Given claimant selects court documents compensator
  When Compensator agrees to court documents
  Then claim will be sent for claimant acknowledgement 
 
 Scenario Outline: unrep Claimant checks the documents selected by compensator and submit the claim for court    
  Given '<Claimant>' checks the documents uploaded by Compensator   
  When '<Claimant>' submit the claim for court                          
  Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|unrep|  
