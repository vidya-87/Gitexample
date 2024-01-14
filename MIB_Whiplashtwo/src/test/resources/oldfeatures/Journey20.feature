@prouser
Feature: Journey 20



Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|owner|multivrn|					
	 |	A passenger on a bus|NO|NO|
	 
	 
Scenario: Compensator  Accept Claim and full Liability
	Given Claim  is sent to the compensator
	When compensator accepts claim and makes full liability without dispute
	Then the claims acceptance and liability is now sent to the claimant

Scenario Outline: Prouser uploads medical report and submits an uplift
	Given upload medical report is enabled for '<claimant>'
	And '<claimant>' adds fee
	When claimant uploads medical report
	Then medical report is uploaded and offer request is sent to compensator

	Examples:
		|claimant|
		|prouser|  

 Scenario: Compensator makes First Offer with fee proposal
 	Given Claim  is sent to the compensator
 	When the compensator makes first offer with fee proposal
 	Then offer is sent to claimant 
 
 Scenario: prouser accepts offer and rejects fee proposal
  	Given prouser review fee proposal
  	When prouser accepts offer and makes counter fees proposal
  	Then pro counter offer sent to compensator
 
 Scenario:  Compensator doesnot respond to the counter fee proposal and claimant goes to court 
	Given Compensator doesnot respond to the claimant counter offer request
	When prouser claimant goes to court over fee proposal            
	Then claim will be sent to compensator to review nvc answers
 	
Scenario: Compensator acknowledges documents selected for court
	Given claimant selects court documents compensator
	When Compensator agrees to court documents
	Then claim will be sent for claimant acknowledgement

Scenario: prouser Claimant acknowledges Compensators doc selection and case is resolved
	Given prouser receives claim for acknowledgement
	When prouser confirm going to court
	Then case is closed at court stage
	
	