@prouser
Feature: Journey 7

Scenario Outline: Prouser Submit a Claim as passenger in car
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	Examples:
	 |involvement_type_v|	owner|multivrn|
	 |A passenger in a car/van/lorry|NO|NO|
	 							
	 
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
  |unrep|
  
  