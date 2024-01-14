@prouser
Feature: Journey 35

Scenario Outline: Prouser Submit a Claim as passenger in a car
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|		owner|	multivrn|					
	 |	A passenger in a car/van/lorry|NO| YES|

Scenario: CSR allocates claim to  compensator
	Given Claim received by csr and eligible for assigning to compensator
	When CSR assigns compensator
	Then Claim is sent to respective compensator	 
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA

Scenario: TPA denies liability
	Given the claim  has been sent to the TPA workbasket
  When TPA dispute claim liability
  Then claims acceptance and liability information is passed to claimant


Scenario: Prouser challenge decision and go to court and submit documents
	Given Prouser claim liability has been rejected
	When prouser wants to challenge decision and decided to go to court
	Then the claimant goes to court
	 
Scenario Outline: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-LiabilityListReview|

Scenario: prouser Claimant acknowledges TPA doc selection and case is resolved
	Given prouser receives claim for acknowledgement
	When prouser claimant acknowledge for liability challenge
	Then case is closed at court stage	 
	
Scenario: Claimant decides to reopen the claim with court decision as part liability
	 Given Prouser claim was resolved at court
	 When Prouser reopens liability disputed claim
	 Then Prouser reopens the claims sucessfully
	 

Scenario: Claimant should not be able to challenge liability
 	Given Prouser has reopened the claim
 	When Prouser tries to challenge liability
 	Then the link should not be present
 	
Scenario: TPA should not be able change liability decision
	Given the claim is reopened by the claimant
	When TPA tries to change the liability decision
	Then the link should not be present 
	
Scenario Outline: Prouser  uploads medical Report
  Given '<claimant>' receives claim   
  When  claimant uploads medical report at '<status>'
  Then report is uploaded and sent to compensator
 
  Examples:
  | claimant|status|
  | prouser|Pending-MedicalAfterCourt|
  
Scenario: Compensator disputes causation at offer and makes final offer
 	Given claimant has request for an offer
 	When TPA disputes causation and make final offer
 	Then claim is sent to claimant

 Scenario: Claimant accepts the decision and no offer is made
	Given TPA has disputed causation for prouser
	When Prouser reject the dispute causation final offer
	Then claim moves to Resolved-FinalOfferRejected
 	
 Scenario Outline: The claim is moved to 'Resolved-FinalOfferRejected'
 	Given '<claimant>' goes to court
 	When prouser claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|prouser|Resolved-FinalOfferRejected|
  