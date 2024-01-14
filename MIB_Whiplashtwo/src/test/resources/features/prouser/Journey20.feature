@prouser
Feature: Journey 20



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

Scenario: TPA disputes causation and admits part liability
	Given Login as TPA
  When TPA accepts claim and makes part liability with dispute
  Then claims acceptance and liability information is passed to claimant

Scenario Outline: Prouser uploads medical report 
	Given upload medical report is enabled for '<claimant>'
	And '<claimant>' adds fee
	When claimant uploads medical report at '<status>'
	Then medical report is uploaded and offer request is sent to compensator

	Examples:
		|claimant|status|
		|prouser| Pending-MedPartCausation| 

Scenario: TPA makes First Offer with fee proposal
 	Given claimant requests offer to TPA
	When the TPA makes first offer with fee proposal
	Then claim will be sent for claimant acknowledgement
 
 Scenario: prouser accepts offer and rejects fee proposal
  	Given prouser review fee proposal
  	When prouser accepts offer and makes counter fees proposal
  	Then pro counter offer sent to compensator
 
 Scenario:  TPA doesnot respond to the counter fee proposal and claimant goes to court 
	Given TPA doesnot respond to the claimant counter offer request
	When prouser claimant goes to court over fee proposal            
	Then claim will be sent to compensator to review nvc answers
 	
Scenario Outline: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-FeesListReview|

Scenario Outline: prouser Claimant acknowledges Compensators doc selection and case is resolved
	Given '<claimant>' checks the documents uploaded by Compensator
	When '<claimant>' submit the claim for court with claim '<status>' for fee dispute
	Then case is closed at court stage
Examples:
|claimant|status|
 |prouser|Pending-FeesListAccept|
 
 Scenario Outline: The claim is moved to 'Resolved-CourtFees'
 	Given '<claimant>' goes to court
 	When prouser claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|prouser|Resolved-CourtFees|
	
	