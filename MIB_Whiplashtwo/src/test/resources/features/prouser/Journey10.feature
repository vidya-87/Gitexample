 @prouser
Feature: Journey 10

Scenario Outline: Prouser Submit a Claim as passenger in a car
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|		owner|	multivrn|	
	 |	A passenger in a car/van/lorry|	NO|YES|

	 
Scenario: CSR allocates claim to  compensator
	Given Claim received by csr and eligible for assigning to compensator
	When CSR assigns compensator
	Then Claim is sent to respective compensator	 
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
	 
Scenario: TPA dispute denies liability
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
	 
Scenario Outline: Prouser  uploads medical Report with waitout prognosis and decides waitout and release report to TPA
  Given '<claimant>' receives claim   
  And '<claimant>' adds fee
  When prouser uploads the medical report with waitout prognosis '<status>' and decides to waitout
  Then report is uploaded and sent to compensator
 
  Examples:
  | claimant|status|
  | prouser|Pending-MedicalAfterCourt|
  
Scenario: Prouser decides to proceed with offer
  Given claimant is in prognosis period
   When claimant decides to proceed with offer during prognosis period
  Then claim will be sent to TPA for offer
  
Scenario: TPA First Offer to Prouser
	Given claimant requests offer to TPA
	When the TPA makes first offer with fee proposal
	Then claim will be sent for claimant acknowledgement

Scenario Outline: Claimant Accepts First Offer to TPA
	Given '<claimant>' receives the offer
	When Prousuer accepts offer
	Then Acknowledgement for offer acceptance will be sent to compensator
Examples:
|claimant|
|prouser|

Scenario Outline: TPA acknowledge claimant offer
 	Given claimant accepts the offer
  When TPA acknowledges claimants offer with claim '<status>'
  Then claim SLA is breached
 Examples:
 |status|
 |Pending-Acknowledgement|
 
Scenario: Claimant decides to go to court (OCS3)
	Given SLA is breached for non-payment
	When prouser decides to go to court for claim settlement pending
	Then documents will be sent to TPA

Scenario Outline: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-OfferListReview|
   
Scenario Outline: Claimant checks the documents selected by Compensator and proceeds the claim for court 
   Given '<claimant>' checks the documents uploaded by Compensator   
   When '<claimant>' submit the claim for court with claim '<status>'                          
   Then  Case is closed with Go to court at offer stage  	
Examples:
 	|claimant|status|
 	|prouser| Pending-OfferListAccept|

Scenario Outline: The claim is moved to 'Resolved-NonPayment'
 	Given '<claimant>' goes to court
 	When prouser claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|prouser|Resolved-NonPayment|

 
 	