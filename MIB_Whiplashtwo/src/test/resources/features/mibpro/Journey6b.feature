@mibpro
Feature: Journey 6b

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<location>'
    Then claim is created for MIBpro
    
    Examples:
    |owner|  involvement_type_v| multivrn |  location|                             
    |YES | The driver| NO  |OUTSIDE UK|
	 
	 
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
|mibpro|

Scenario: Claimant proceeds to offer
	Given MIBpro uploaded medical report
	And MIBpro update the losses from Loss Tile
	When MIBpro proceeds to offer after uploading own medical report
	Then offer request is sent to compensator

Scenario: compensator receives the claim with Losses added by claimant after WOP
	Given Claim  is sent to the compensator
	When the compensator makes first offer
	Then offer is sent to claimant

Scenario Outline: MIBpro makes 1st counter offer
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then claimant offer is sent for revision
	Examples:
	|claimant|
	|mibpro|
	
Scenario: Claimant withdraw offer and makes replacement offer
	Given MIBpro has made counter offer
	When MIBpro withdraws the current offer
	Then replaces with another offer

Scenario: Compensator rejects 1st counter offer and sends to claimant
	Given compensator rejects counter offer
	When revised offer is sent to the claimant
	Then offer is sent to claimant

Scenario Outline: MIbpro makes 2nd counter offer
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|mibpro|

Scenario: Compensator rejects 2nd counter offer and sends to claimant
	Given compensator rejects counter offer
	When revised offer is sent to the claimant
	Then offer is sent to claimant

Scenario Outline: MIBpro makes 3rd counter offer
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|mibpro|
	

Scenario: Compensator withdraws rejects 3rd counter offer and sends to claimant
	Given compensator rejects counter offer
	When compensator withdraws the offer and rejects the offer
	Then offer is sent to claimant

Scenario Outline: Claimant goes to court to value claim
	Given '<claimant>' decided to go to court
	When '<claimant>' goes to court for final offer
	Then Claimant selection to go to court is confirmed
Examples:
|claimant|
|mibpro|

Scenario Outline: Claimant answers NVC
	Given '<claimant>' decided to go to court
	When '<claimant>' answers NVC questions
	Then Claimant selection to go to court is confirmed
Examples:
|claimant|
|mibpro|
	
	
Scenario: Compensator responds to NVC questions
	Given Compensator receives claim to review NVC answers
   	When Compensator responds to NVC answers
    Then claim should be sent to claimant to select documents for court
  
  
Scenario Outline: mibpro Claimant selects documents for court     
	Given Compensator responds NVC answers to '<Claimant>'    
 	When '<Claimant>' selects documents for court after NVC  
 	Then documents should be reviewed by Compensator
 Examples:
 	|Claimant|
 	|mibpro|
 	
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
 	|mibpro|   
   
