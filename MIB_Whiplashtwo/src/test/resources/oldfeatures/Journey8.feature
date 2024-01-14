@prouser
Feature: Journey 8(Sprint 28)

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|owner|multivrn|								
	 |	The driver|	NO|NO|
	 
	 
Scenario: Compensator makes liability decision
  Given Claim  is sent to the compensator
  When compensator makes full liability with causation and seatbelt dispute
  Then the claims acceptance and liability is now sent to the claimant
  
Scenario: Claimant add losses and documents
  Given claim liability is accepted
  When claimant update the losses from Loss Tile and upload documents
  Then claim will proceed to upload medical reports

Scenario Outline: Prouser  uploads medical Report with waitout prognosis
  Given '<claimant>' receives claim   
  When claimant uploads the medical report with waitout prognosis
  Then report is uploaded and sent to compensator
 
  Examples:
  | claimant|
  | prouser|
  
 Scenario Outline: Prouser indicates completion of wait out period and upload new report
  Given '<claimant>' receives claim   
  When claimant completes waitout period and upload new report
  Then report is uploaded and sent to compensator
  
    Examples:
  | claimant|
  | prouser|
  
 Scenario: Compensator First Offer to Prouser
	Given Claim  is sent to the compensator
	When the compensator makes first offer
	Then offer is sent to claimant
	
Scenario Outline: Prouser rejects the first offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|
	
	 Scenario: Compensator reject claimant counter offer and makes new offer(Second offer)
	Given Claim  is sent to the compensator
	When the compensator makes new offer
	Then offer is sent to claimant
	
	Scenario Outline: Prouser rejects the Second offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|
	
Scenario: Compensator reject claimant counter offer and makes new offer(third offer)
	Given Claim  is sent to the compensator
	When the compensator makes new offer
	Then offer is sent to claimant
	
Scenario Outline: Prouser rejects the third offer to Compensator
	Given '<claimant>' receives new offer
	When '<claimant>' decides to go to court 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|

Scenario: prouser Claimant select court docs
	Given prouser Claimant receives the claim for document selection
	When prouser Claimant selects court docs
	Then claim sent to compensator for reviewing documents selected
 	
Scenario: Compensator acknowledges documents selected for court
	Given claimant selects court documents compensator
	When Compensator agrees to court documents
	Then claim will be sent for claimant acknowledgement

Scenario: prouser Claimant acknowledges Compensators doc selection and case is resolved
	Given prouser receives claim for acknowledgement
	When prouser confirm going to court
	Then case is closed at court stage
	

	


