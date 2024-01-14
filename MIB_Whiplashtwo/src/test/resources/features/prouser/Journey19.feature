@prouser
Feature: Journey19

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|	owner|multivrn|						
	 |	A passenger on a bus|NO|NO|
	 
	 
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
	
Scenario Outline: TPA disagree for document selection
	Given Uploaded documents for court cofirmed by Claimant
	When TPA disagrees to court documents uploaded by Claimant at '<status>'
	Then claimant need to review the documents uploaded by TPA
Examples:
|status|
|Pending-LiabilityListReview|

Scenario: prouser Claimant acknowledges TPA doc selection and case is resolved
	Given prouser receives claim for acknowledgement
	When prouser claimant acknowledge for liability challenge
	Then case is closed at court stage	 
	
Scenario: TPA reopens claim and make full liability to claimant
	 Given Claim is resolved at court
	 When TPA reopens liability disputed claim
	 Then TPA accepts full liability after reopening the claim

Scenario Outline: Prouser uploads medical report and adds fee
	Given upload medical report is enabled for '<claimant>'
	And '<claimant>' adds fee
	When claimant uploads medical report at '<status>'
	Then medical report is uploaded and offer request is sent to compensator

	Examples:
		|claimant|status|
		|prouser|Pending-MedicalAfterCourt| 

 Scenario: TPA makes First Offer with fee proposal
 Given claimant requests offer to TPA
	When the TPA makes first offer with fee proposal
	Then claim will be sent for claimant acknowledgement
 
Scenario: prouser requests for revised offer
Given prouser claimant received first offer from TPA
When  prouser Claimant requests for revised offer    
Then  claim will be sent to compensator with revised offer
 
Scenario:  TPA doesnot respond to the counter offer and claimant goes to court (OCS2)
Given TPA doesnot respond to the claimant counter offer request
When prouser claimant goes to court            
Then claim is sent to TPA

 	
Scenario Outline: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-OfferListReview|

Scenario Outline: prouser Claimant acknowledges TPA doc selection and case is resolved
	Given '<claimant>' checks the documents uploaded by Compensator
	When prouser submit the claim for court and select witness at '<status>'
	Then case is closed at court stage
Examples:
|claimant|status|
 |prouser|Pending-OfferListAccept|

Scenario Outline: The claim is moved to 'Resolved-CourtOffer'
 	Given '<claimant>' goes to court
 	When prouser claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|prouser|Resolved-CourtOffer|
   
   
