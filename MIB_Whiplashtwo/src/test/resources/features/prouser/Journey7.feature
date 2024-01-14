@prouser
Feature: Journey 7

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then prouser exits before submitting claim
	Examples:
	 |involvement_type_v|	owner|multivrn|
	 |A passenger in a car/van/lorry|NO|NO|
	 
Scenario: Prouser continues claim submission
	Given prouser logins into whiplash application
	Then prouser submits the claim successfully
	 							
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
	 
	
Scenario: TPA  Denies Claim and claim Liability
	Given the claim  has been sent to the TPA workbasket
  When  TPA dispute claim liability
  Then  claims acceptance and liability information is passed to claimant
  
Scenario Outline: Claimant accepts Denial & case resolved
  Given TPA denied claim liability to '<claimant>'
  When  Claimant accepts denial
  Then  claim will be resolved
  Examples:
  |claimant|
  |prouser|
  
Scenario Outline: Compensator acknowledges the claimant decision
	 Given Login as TPA
	 When TPA acknowledges claimants offer with claim '<status>'
 	Then the claim can be Resolved
Examples:
|status|
|Pending-RejectedLiability|

Scenario Outline: The claim is moved to ' Resolved-RejectedLiability'
 	Given '<claimant>' goes to court
 	When prouser claim status is '<status>'
 	Then claim is resolved
 	Examples:
	|claimant|status|
 	|prouser|Resolved-RejectedLiability|