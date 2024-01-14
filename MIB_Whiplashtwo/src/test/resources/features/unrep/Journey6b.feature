@unrep
Feature: Journey 6b

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |location|							
	 | YES|	I was the driver	| BOTH		| NO	|Outside UK|
	 
	 
Scenario: Compensator dispute causation along with full liability
	Given Claim  is sent to the compensator
	When compensator accepts claim and makes full liability with dispute
	Then the claims acceptance and liability is now sent to the claimant


Scenario Outline: Claimant uploads own medical report
	Given '<claimant>' receives claim
	When  '<claimant>' uploads own medical report
	Then medical report is uploaded successfully
Examples:
|claimant|
|unrep|

Scenario: Claimant proceeds to offer
	Given claimant uploaded medical report
	And Claimant Adds losses from losses tile
	When claimant proceeds to offer after uploading own medical report
	Then offer request is sent to compensator

Scenario: compensator receives the claim with Losses added by claimant after WOP
	Given Claim  is sent to the compensator
	When the compensator makes first offer
	Then offer is sent to claimant

Scenario Outline: Unrep makes 1st counter offer
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then claimant offer is sent for revision
	Examples:
	|claimant|
	|unrep|
Scenario: Claimant withdraw offer and makes replacement offer
	Given claimant has made first offer
	When claimant withdraws the current offer
	Then replaces with another offer

Scenario: Compensator rejects 1st counter offer and sends to claimant
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

Scenario: Compensator rejects 2nd counter offer and sends to claimant
	Given compensator rejects counter offer
	When revised offer is sent to the claimant
	Then offer is sent to claimant

Scenario Outline: Unrep makes 3rd counter offer
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|unrep|
	

Scenario: Compensator withdraw and rejects 3rd counter offer and sends to claimant
	Given compensator rejects counter offer
	When compensator withdraws the offer and rejects the offer
	Then offer is sent to claimant

Scenario Outline: Claimant goes to court to value claim
	Given '<claimant>' decided to go to court
	When '<claimant>' goes to court for final offer
	Then Claimant selection to go to court is confirmed
Examples:
|claimant|
|unrep|

Scenario Outline: Claimant answers NVC
	Given '<claimant>' decided to go to court
	When '<claimant>' answers NVC questions
	Then Claimant selection to go to court is confirmed
Examples:
|claimant|
|unrep|	

Scenario: Compensator responds to NVC questions
	Given Compensator receives claim to review NVC answers
   	When Compensator responds to NVC answers
    Then claim should be sent to claimant to select documents for court
  
  
Scenario Outline: unrep Claimant selects documents for court     
	Given Compensator responds NVC answers to '<Claimant>'    
 	When '<Claimant>' selects documents for court after NVC  
 	Then documents should be reviewed by Compensator
 Examples:
 	|Claimant|
 	|unrep|
 	
 Scenario Outline: Compensator acknowledges documents selected for court
   Given claimant selects court documents compensator
   When Compensator agrees to court documents when claim is in '<status>'
   Then claim will be sent for claimant acknowledgement 
 Examples:
 |status|
 |Pending-OfferListReview|
   
Scenario Outline: unrep Claimant checks the documents selected by Compensator and submit the claim for court 
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When '<Claimant>' submit the claim for court and select witness                          
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|unrep|   
   
