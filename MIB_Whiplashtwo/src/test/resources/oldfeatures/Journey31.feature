@prouser
Feature: Journey 31(Sprint 29a)

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|	owner|							
	 |	A passenger on a bus|NO|
	 
	 
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
	
	
Scenario Outline: Prouser rejects the first offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision and SLA is breached
	Examples:
	|claimant|
	|prouser|
	
	
Scenario: Prouser withdraw the offer and replaces with new offer

	Given Compensator doesnot accept/dispute the offer for more than 10 days
	Then Prouser withdraw the offer and replace with new offer
	Then counter offer is sent for revision

Scenario: Compensator accepts prouser counter offer

  Given Claimant requested for revised offer
  When Compensator accepts claimant counter offer
  Then claim is sent to claimant
  
