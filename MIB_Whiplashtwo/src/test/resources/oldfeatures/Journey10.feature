 @prouser
Feature: Journey 10

Scenario Outline: Prouser Submit a Claim as passenger in a car
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|		owner|	multivrn|	
	 |	A passenger in a car/van/lorry|	NO|NO|
	 
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
	 
Scenario: TPA dispute partial liability
	Given the claim  has been sent to the TPA workbasket
  When TPA dispute claim liability
  Then claims acceptance and liability information is passed to claimant


Scenario: Prouser challenge decision and go to court and submit documents
	Given Prouser claim liability has been rejected
	When prouser wants to challenge decision and decided to go to court
	Then the claimant goes to court
	
Scenario: TPA disagree for document selection
	Given Uploaded documents for court cofirmed by Claimant
	When TPA disagrees to court documents uploaded by Claimant
	Then claimant need to review the documents uploaded by TPA

Scenario: prouser Claimant acknowledges TPA doc selection and case is resolved
	Given prouser receives claim for acknowledgement
	When prouser claimant acknowledge for liability challenge
	Then case is closed at court stage	 
	
Scenario: TPA reopens claim and make full liability to claimant
	 Given Claim is resolved at court
	 When TPA reopens liability disputed claim
	 Then TPA accepts full liability after reopening the claim
	 
Scenario Outline: Prouser  uploads medical Report with waitout prognosis
  Given '<claimant>' receives claim   
  And '<claimant>' adds fee
  When claimant uploads the medical report with waitout prognosis
  Then report is uploaded and sent to compensator
 
  Examples:
  | claimant|
  | prouser|
  
Scenario: Prouser decides to proceed with offer
  Given claimant is in prognosis period
   When claimant decides to proceed with offer during prognosis period
  Then claim will be sent to compensator for first offer
  
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

Scenario: TPA acknowledge claimant offer
 	Given claimant accepts the offer
  When TPA acknowledges claimants offer
  Then claim SLA is breached
  
Scenario: Claimant decides to go to court (OCS3)
	Given SLA is breached for non-payment
	When prouser decides to go to court for claim settlement pending
	Then documents will be sent to TPA

Scenario: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents
   Then claim will be sent for claimant acknowledgement 
   
Scenario Outline: Claimant checks the documents selected by Compensator and proceeds the claim for court 
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When '<Claimant>' submit the claim for court                          
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|prouser| 

  

 
 	