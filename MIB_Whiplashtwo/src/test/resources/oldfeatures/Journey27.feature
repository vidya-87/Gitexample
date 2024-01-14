@prouser
Feature: Journey 27(Sprint 29)

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|owner|multivrn|								
	 |	A passenger on a bus|NO|NO|
	 
	 
Scenario: Compensator makes liability decision
  Given Claim  is sent to the compensator
  When compensator makes full liability with causation and seatbelt dispute
  Then the claims acceptance and liability is now sent to the claimant
  
Scenario Outline: Claimant add losses and fee
  Given claim liability is accepted
  When '<claimant>' add losses and fee
  Then claim will proceed to upload medical reports
Examples:
  | claimant|
  | prouser|


Scenario: Prouser remove fees added
  Given claimant accepts the offer from compensator
  When claimant removes fee
  Then claimant review fee proposal from compensator 

Scenario Outline: Prouser  uploads medical Report with waitout prognosis
  Given '<claimant>' receives claim   
  When claimant uploads the medical report
  Then report is uploaded and sent to compensator
 
  Examples:
  | claimant|
  | prouser|

 
 Scenario: Compensator makes First Offer with fee proposal
 	Given Claim  is sent to the compensator
 	When the compensator makes first offer
 	Then offer is sent to claimant 
	
Scenario Outline: Prouser accepts the offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' accept the offer
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|
	

#Scenario: Prouser goes to court for fee proposal
#   Given claimant review fee proposal
#   When Prouser reject fee proposal and goes to court
#   Then claimant uploads court document
#   
#Scenario: Compensator acknowledges documents selected for court
#	Given claimant selects court documents compensator
#	When Compensator agrees to court documents
#	Then claim will be sent for claimant acknowledgement
#
#Scenario: prouser Claimant acknowledges Compensators doc selection and case is resolved
#	Given prouser receives claim for acknowledgement
#	When prouser confirm going to court
#	Then case is closed at court stage
# 
 
  
 