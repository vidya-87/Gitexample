@prouser
Feature: Journey 25

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|	owner	|multivrn|					
	 |The driver|YES|NO|

Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
  
Scenario: TPA disputes causation and admits part liability
	Given Login as TPA
  When TPA accepts full liability
  Then claims acceptance and liability information is passed to claimant
 
Scenario Outline: Prouser  uploads medical Report with waitout prognosis and release report to TPA
  Given '<claimant>' receives claim   
  When prouser uploads the medical report with waitout prognosis '<status>' and decides to waitout
  Then report is uploaded and sent to compensator
 
  Examples:
  | claimant|status|
  | prouser|Pending-Medical|
  
  Scenario: Prouser proceeds with offer during prognosis period
  Given claimant is in prognosis period  
  When claimant decides to proceed with offer during prognosis period
  Then medical report is uploaded and offer request is sent to compensator
  
  
 Scenario: TPA First Offer to Prouser
	Given Login as TPA
	When the TPA makes first offer
	Then offer is sent to claimant
	
	  
Scenario Outline: Prouser rejects the first offer to Compensator
	Given '<claimant>' receives new offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|
	
	
Scenario: TPA reject claimant counter offer and makes new offer(Second offer)
	Given Login as TPA
	When the TPA send updated offer
	Then offer is sent to claimant 
 
 
Scenario Outline: Prouser rejects the second offer to Compensator
	Given '<claimant>' receives new offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|	
	

Scenario: TPA reject claimant counter offer and makes new offer(Third offer)
	Given Login as TPA
	When the TPA send updated offer
	Then offer is sent to claimant 
	

 
Scenario Outline: Prouser rejects the third offer to Compensator
	Given '<claimant>' receives new offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|	
	
Scenario Outline: TPA decides to withdraw the offer
	Given TPA has made first offer to claimant
	When TPA withdraws the offer at claim '<status>'
	Then TPA gets an option to replace the offer
Examples:
|status|
|Pending-RespondCounter|
	

Scenario: TPA rejects final offer
	Given Login as TPA 
	When final counter offer is reject
	Then offer is sent to claimant
	
Scenario Outline: Claimant goes to court to value claim
	Given '<claimant>' decided to go to court
	When '<claimant>' goes to court for final offer
	Then Claimant selection to go to court is confirmed
Examples:
|claimant|
|prouser|

Scenario Outline: Claimant answers NVC
	Given '<claimant>' decided to go to court
	When '<claimant>' answers NVC questions
	Then Acknowledgement will be sent to compensator
Examples:
|claimant|
|prouser|		


Scenario: Compensator removes the claim from portal
  Given TPA does not respond to NVC
  When TPA removes the claim from portal
  Then the claim is removed from portal and closed  
 	
 Scenario Outline: The claim is moved to 'Resolved-Removed'
 	Given '<claimant>' goes to court
 	When prouser claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|prouser|Resolved-Removed|	
	
