@prouser
Feature: Journey 11

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|		owner|multivrn|						
	 |	A passenger on a bus| NO|NO|

Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA 
	 
Scenario: TPA makes liability decision
  Given the claim  has been sent to the TPA workbasket
  When TPA accepts full liability
  Then the claims acceptance and liability is now sent to the claimant

Scenario Outline: Prouser  uploads medical Report
  Given '<claimant>' receives claim   
  When prouser uploads the medical report with waitout prognosis '<status>' and decides to waitout
  Then report is uploaded and sent to compensator
 
  Examples:
  | claimant|status|
  | prouser|Pending-Medical|
 
 Scenario: Prouser decides to proceed ahead though client is still suffering with injuries
 	Given claimant is in prognosis period
 	When claimant decides to proceed with offer during prognosis period
 	Then first offer is sent to TPA
  
 Scenario: TPA First Offer to Prouser
	Given claimant requests offer to TPA
	When the TPA makes first offer
	Then offer is sent to claimant

Scenario Outline: Claimant decides waitout at offer stage and uploads new medical report and proceeds with offer
	 Given '<claimant>' receives claim 
	 When claimant decides to waitout period and upload new report
	 Then report is uploaded and sent to compensator
Examples:
  | claimant|
  | prouser|
  
 Scenario: TPA makes updated offer to claimant
	Given claimant requests offer to TPA
	When TPA makes updated first offer
	Then offer is sent to claimant

Scenario: Prouser indicates waitout and adds losses
	Given claimant is in prognosis period
	Then Claimant decides to waitout
	And Prouser adds loss
	Then Prouser is is in waitout period

Scenario: Prouser decides to proceed with offer
  Given claimant is in prognosis period
   When claimant decides to proceed with offer during prognosis period with new medical report
  Then claim will be sent to TPA for offer	
 
	
Scenario Outline: Prouser withdraws claim
  Given '<claimant>' has uploaded medical report
  When the claimant then decides to withdraw the claim at '<status>' 
  Then the claimant has withdrawn claim and Compensator to acknowledge this
  
  Examples:
  | claimant|status|
  | prouser| Pending-UpdateOfferFinancial|
  


Scenario: Compensator  Acknowledge claimant claim withdrawal
  Given Login as TPA
  When TPA acknowledges claimants withdrawal 
  Then the claim can be Resolved
  

