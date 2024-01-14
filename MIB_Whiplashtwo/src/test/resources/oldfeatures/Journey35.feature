@prouser
Feature: Journey 35

Scenario Outline: Prouser Submit a Claim as passenger in a car
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|		owner|	multivrn|					
	 |	A passenger in a car/van/lorry|NO| YES|
	 
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
	 
Scenario: TPA accepts full liability
	Given the claim  has been sent to the TPA workbasket
  When TPA accepts full liability
  Then claims acceptance and liability information is passed to claimant
  
 Scenario Outline: Claimant add losses and fee
  Given claim liability is accepted
  When '<claimant>' add losses and fee
  Then claim will proceed to upload medical reports
Examples:
  | claimant|
  | prouser|
	 
Scenario Outline: Prouser  uploads medical Report with waitout prognosis
  Given '<claimant>' receives claim
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

  

 
 	