@unrep
Feature: Journey 6a

Scenario Outline: User Enters details in your details page
		Given unrep logins into whiplash application
		When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
		Then claim reference number for unrep claim is created
		Examples:
		 | owner| involvement_type_v | ct_preference|multivrn|location|					
		 | NO	|I was a passenger in a Car/Lorry/Van | EMAIL|NO|Inside UK|
	 							
	 
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
  When  unrep accepts denial
  Then  claim will be resolved
  Examples:
  |claimant|
  |unrep|
  
  Scenario Outline: TPA acknowledges the claimant decision
 	Given claimant accepts the offer
  When TPA acknowledges claimants offer with claim '<status>'
  Then the claim can be Resolved
  
 Examples:
 |status|
 |Pending-RejectedLiability|
  
  
  
 Scenario: The claim moves to 'Resolved-RejectedLiability'
 	Given TPA has acknowledged
 	When claimant has accepted the rejected liability
 	Then claim is successfully resolved