@prouser
Feature: Journey 11

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|		owner|multivrn|						
	 |	A passenger on a bus| NO|NO|
	 
	 
Scenario: Compensator makes liability decision
  Given Claim  is sent to the compensator
  When compensator makes full liability with causation and seatbelt dispute
  Then the claims acceptance and liability is now sent to the claimant

Scenario Outline: Prouser  uploads medical Report
  Given '<claimant>' receives claim   
  When claimant uploads the medical report
  Then report is uploaded and sent to compensator
 
  Examples:
  | claimant|
  | prouser|
  
 Scenario: Compensator First Offer to Prouser
	Given Claim  is sent to the compensator
	When the compensator makes first offer
	Then offer is sent to claimant
	

	
Scenario Outline: Prouser withdraws claim
  Given '<claimant>' has uploaded medical report
  When the claimant then decides to withdraw the claim 
  Then the claimant has withdrawn claim and Compensator to acknowledge this
  
  Examples:
  | claimant|
  | prouser| 
  


Scenario: Compensator  Acknowledge claimant claim withdrawal
  Given Claim  is sent to the compensator
  When Compensator acknowledges claimants withdrawal 
  Then the claim can be Resolved
  

