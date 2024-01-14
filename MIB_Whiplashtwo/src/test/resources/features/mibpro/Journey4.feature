@mibpro
Feature: Journey 4

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	 | owner| involvement_type_v| multivrn |	location|							
	 | YES|	The driver	| NO	|Inside UK|
	 
	 
Scenario: Compensator Accept Claim and Part claim Liability
Given Claim  is sent to the compensator
When compensator accepts claim and makes part liability
Then the claims acceptance and liability is now sent to the claimant

Scenario: MIBpro claimant challenge liability decision
	Given the MIBpro claim liability has been accepted by compensator
	When MIBpro claimant challenges Liability
	Then claim will be sent to compensator to update liability
  
Scenario: compensator updates liability
	Given the claim liability decision has been challenged by claimant
	When compensator updates liability
	Then Updated liability information will be sent to claimant

Scenario: MIBpro Claimant again challenges liability (2nd time)
Given Updated Liability information received by MIBpro
When MIBpro claimant review challenge Liability
Then claim will be sent to compensator to update liability

Scenario: compensator updates liability (2nd time)
	Given the claim liability decision has been challenged by claimant
	When compensator updates liability
	Then Updated liability information will be sent to claimant

Scenario: MIBpro Claimant again challenges liability (3rd time)
	Given Updated Liability information received by MIBpro
	When MIBpro claimant review challenge Liability
	Then claim will be sent to compensator to update liability

Scenario: compensator updates liability (3rd time)
	Given the claim liability decision has been challenged by claimant 
	When compensator updates liability
	Then Updated liability information will be sent to claimant

Scenario: no challenge liability option and claimant proceeds with medical stage(DME) 
	Given Updated Liability information received by MIBpro
	When mibprouser selects medical preferences for an DME  
	Then medical preferences are sent to Independent Expert

Scenario: DME uploads report - Recovered -no WOP  
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: MIBPRO decides to obtain further report and uploads report with waitout prognosis   
	Given Mibprouserclaimant received the reports from DME 
	When MIBpro decides to obtain further report                
	Then claimant uploads further medical report uploaded successfully

Scenario: Claimant decides to waitout prognosis and requests further medical report
	Given MIBpro accepts waitout prognosis
	When MIBpro claimant decides waitout and obtains further medical report
	Then acknowledgment is sent to compensator


Scenario: Compensator accepts claimant to upload further medical report
	Given claimant has given a request for further medical report
	When Compensator provides the consent for obtaining further medical report
	Then Compensator decision is sent to the claimant

Scenario: Claimant upload further medical report without WOP - recovered and Add losses and fee
	Given Compensator has acknowledged MIBrpo for further medical report
	When mibpro uploades further medical report
	Then medical report is uploaded successfully

Scenario: Claimant Add losses and fee decides to proceed with offer
	Given MIBpro has uploaded further report
	When MIBpro update the losses and fee from Loss Tile and proceeds with offer
	Then offer request is sent to compensator

Scenario: Compensator makes First Offer with fee proposal
	Given claimant requests offer
	When the compensator makes first offer with fee proposal
	Then offer is sent to claimant

Scenario Outline: MIBpro rejects the first offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|mibpro|
	

Scenario: Compensator accepts the claimant counter offer
	Given Claimant requested for revised offer
	When Compensator accepts claimant counter offer
	Then counter offer is sent to claimant for review
	
Scenario: Claimant reject fee offer to compensator
	Given MIBpro claimant review fee proposal
	When mibpro rejects the fee proposal
	Then MIBpro counter offer sent to compensator


Scenario: Compensator rejects claimant's fee offer
	Given Claim  is sent to the compensator
	When compensator rejects claimant fee offer
	Then Compensator decision is sent to the claimant
	
Scenario: Claimant rejects Fee proposal and go to court
	Given MIBpro claimant review fee proposal
	When MIBpro rejects fee offer and goes to court
	Then claimant uploads court document

 Scenario Outline: Compensator acknowledges documents selected for court
   Given claimant selects court documents compensator
   When Compensator agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-FeesListReview|
   
Scenario Outline: Claimant checks the documents selected by Compensator and submit the claim for court 
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When '<Claimant>' submit the claim for court with claim '<status>' for fee dispute                      
   Then  Case is closed with Go to court at offer stage  	
Examples:
 	|Claimant|status|
 	|mibpro|Pending-FeesListAccept|
 
 Scenario Outline: The claim is moved to 'Resolved-CourtFees'
 Given '<claimant>' goes to court
 	When mibpro claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|mibpro|Resolved-CourtFees|

