@prouser
Feature: Journey 40


Scenario Outline: Prouser Submit a Claim as passenger in a car
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|		owner|	multivrn|	
	 |	The driver|	YES|NO|
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA	 
	 
Scenario: TPA  Denies Claim and claim Liability
	Given the claim  has been sent to the TPA workbasket
  When  TPA dispute claim liability
  Then  claims acceptance and liability information is passed to claimant
  
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
	 
	 
	 
Scenario Outline: Claimant Request first Interim Payment and added fees
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	And '<claimant>' adds fee
	Then interim payment request is sent to compensator
Examples:
|claimant|
|prouser|	

Scenario: Compensator makes first interim payment
	Given Login as TPA
	When compensator makes interim payment
	Then claimant receives interim payment

Scenario Outline: Claimant reviews and accepts first interim payment
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews and accept interim decision 
	Then payment is not received by the claimant
Examples:
|claimant|
|prouser|


Scenario Outline: Claimant decides to go to court for interim over non-payment 
	Given '<claimant>' interim non-payment SLA is breached
	When Go to court for non-payment option is enabled for '<claimant>'
	Then claimant decides to go to court over interim non-payment
Examples:
|claimant|
|prouser|

Scenario Outline: Claimant select court docs for interim non-payment
	Given '<claimant>' goes to court over interim
	When "<claimant>" selected Court proceeding started as No
	And "<claimant>" selected documents for court NON payment of Interim
	Then court document are sent to compensator

Examples:
|claimant|
|prouser|	

Scenario: TPA reviews court document for Interim non-payment
		Given Login as TPA
		When Compensator reviews court document for interim
		Then court docs sent for review to claimant
		
Scenario: prouser Claimant acknowledges TPA doc selection and case is resolved
	Given prouser receives claim for acknowledgement
	When prouser claimant acknowledge for Interim
	Then case is closed at court stage	 


Scenario Outline: Prouser uploads medical report
	Given upload medical report is enabled for '<claimant>'
	When "<claimant>" uploads medical report without Uplift request
	Then medical report is uploaded and offer request is sent to compensator
	Examples:
	|claimant|
	|prouser|	
	


		
 Scenario: TPA makes First Offer with fee proposal
	 Given claimant requests offer to TPA
	When the TPA makes first offer with fee proposal
	Then claim will be sent for claimant acknowledgement
 
Scenario: prouser accepts offer and rejects fee proposal
  Given prouser review fee proposal
  When prouser accepts offer and makes counter fees proposal
  Then pro counter offer sent to compensator for review
####

Scenario: TPA rejects claimants fee offer
	Given Prouser rejects fee offer
	When TPA rejects claimant fee offer
	Then TPA sends the updated fee offer to prouser

Scenario Outline: prouser go to court for fee proposal
  Given Prouser reject fee proposal
  When prouser reject fee offer decided to go to court
  And "<claimant>" selected Court proceeding started as Yes
	And "<claimant>" selected documents for court fees disagreement
  Then the claimant goes to court
	Examples:
	|claimant|
	|prouser|	

Scenario Outline: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-FeesListReview|

Scenario Outline: prouser Claimant acknowledges Compensators doc selection and case is resolved
	Given '<claimant>' checks the documents uploaded by Compensator
	When "<claimant>" submit the claim for court with claim for fee dispute subsequent court applications
	Then case is closed at court stage
Examples:
|claimant|
 |prouser|
 
 
 