@mibpro
Feature: Journey 6a

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
    
    Examples:
    |owner|  involvement_type_v| multivrn |  location|                             
    |NO | A passenger in a car/van/lorry| NO  |OUTSIDE UK|
	 							
	 
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
  When  MIBpro Claimant accepts denial
  Then  claim will be resolved
  Examples:
  |claimant|
  |mibpro|
  
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