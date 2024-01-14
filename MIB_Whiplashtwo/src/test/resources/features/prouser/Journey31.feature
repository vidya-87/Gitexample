@prouser
Feature: Journey 31

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
  

Scenario Outline: Prouser uploads medical report 
	Given upload medical report is enabled for '<claimant>'
	And '<claimant>' adds fee
	When claimant uploads medical report at '<status>'
	Then medical report is uploaded and offer request is sent to compensator

	Examples:
		|claimant|status|
		|prouser| Pending-Medical| 

Scenario: TPA makes First Offer with fee proposal
 	Given claimant requests offer to TPA
	When the TPA makes first offer with fee proposal
	Then claim offer is sent to claimant review
	
	
Scenario Outline: TPA withdraws the first offer
	Given Login as TPA
	When TPA withdraws the offer at claim '<status>'
	Then TPA gets an option to replace the offer
Examples:
|status|
|Pending-ReviewOffer|

Scenario: TPA replace offer
	Given TPA has withdrawn the first offer
	When replacement offer is made to claimant
	Then claim will be sent for claimant acknowledgement
	
Scenario Outline: Prouser rejects the first offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision and SLA is breached
	Examples:
	|claimant|
	|prouser|

Scenario: Prouser withdraw the offer and replaces with new offer

	Given Prouser has rejected offer to TPA
	Then Prouser withdraw the offer and replace with new offer
	Then counter offer is sent for revision

Scenario: TPA accepts prouser counter offer

  Given claimant request interm payment to TPA
  When TPA accepts claimant counter offer
  Then claim is sent to claimant
  
Scenario Outline: Prouser accepts Fee 
	Given prouser review fee proposal
	When '<claimant>' accepts revised offer
	Then Acknowledgement will be sent to compensator
Examples:
|claimant|
|prouser|

Scenario: Claimant goes to court for fees non-payment
	Given SLA is breached for non-payment
	When prouser decides to go to court for fee settlement pending
	Then claim sent to compensator for reviewing documents selected
  
 Scenario Outline: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-FeesListReview|

Scenario Outline: prouser Claimant acknowledges Compensators doc selection and case is resolved
	Given '<claimant>' checks the documents uploaded by Compensator
	When '<claimant>' submit the claim for court with claim '<status>'
	Then case is closed at court stage
Examples:
|claimant|status|
 |prouser|Pending-FeesListAccept|
 
 Scenario Outline: The claim is moved to 'Resolved-NonPayment'
 	Given '<claimant>' goes to court
 	When prouser claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|prouser|Resolved-NonPayment|
	