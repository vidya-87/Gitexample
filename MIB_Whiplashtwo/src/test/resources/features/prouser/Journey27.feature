@prouser
Feature: Journey 27

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|owner|multivrn|								
	 |	A passenger on a bus|NO|NO|
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA

Scenario: TPA accepts full liability
	Given Login as TPA
  When TPA accepts full liability
  Then claims acceptance and liability information is passed to claimant
  
Scenario Outline: Claimant add losses and fee
  Given claim liability is accepted
  When '<claimant>' add losses and fee
  Then claim will proceed to upload medical reports
Examples:
  | claimant|
  | prouser|


Scenario Outline: Prouser  uploads medical Report
  Given '<claimant>' receives claim   
  When  claimant uploads medical report at '<status>'
  Then report is uploaded and sent to compensator
 
  Examples:
  | claimant|status|
  | prouser|Pending-Medical|
  
 Scenario: TPA disputes causation at offer and decides not to make any offer
 	Given claimant requests offer to TPA
 	When TPA disputes causation at offer
 	Then claim is sent to claimant
 	
 Scenario: Claimant accepts the decision and no offer is made
	Given TPA has disputed causation for prouser
	When Prouser accepts the dispute causation no offer
	Then claim moves to Resolved-NoOffer

 Scenario Outline: The claim is moved to 'Resolved-NoOffer'
 	Given '<claimant>' goes to court
 	When prouser claim status is '<status>'
 	Then claim is resolved
 	Examples:
	|claimant|status|
 	|prouser|Resolved-NoOffer|