@prouser
Feature: Journey 8

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|owner|multivrn|								
	 |	A passenger on a bus|	NO|NO|
	 
	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
  
Scenario: TPA disputes causation and admits part liability
	Given Login as TPA
  When TPA accepts full liability
  Then claims acceptance and liability information is passed to claimant
  
Scenario: Claimant add losses and documents
  Given claim liability is accepted
  When claimant update the losses from Loss Tile and upload documents
  Then claim will proceed to upload medical reports

Scenario Outline: Prouser  uploads medical Report with waitout prognosis
  Given '<claimant>' receives claim   
  When prouser uploads the medical report with waitout prognosis '<status>' and decides to waitout
  Then report is uploaded and sent to compensator
 
  Examples:
  | claimant|status|
  | prouser|Pending-Medical|
  
 Scenario Outline: Prouser indicates completion of wait out period and upload new report
  Given '<claimant>' receives claim   
  When claimant indicates completion of waitout period and upload new report
  Then report is uploaded and sent to compensator
  
    Examples:
  | claimant|
  | prouser|
  
 Scenario: TPA First Offer to Prouser
	Given Login as TPA
	When the TPA makes first offer
	Then offer is sent to claimant
	
Scenario Outline: Prouser rejects the first offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|
	
Scenario: TPA reject claimant counter offer and makes new offer(Second offer)
	Given Login as TPA
	When the TPA send updated offer
	Then offer is sent to claimant
	
	Scenario Outline: Prouser rejects the Second offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|
	
Scenario: TPA reject claimant counter offer and makes new offer(third offer)
	Given Login as TPA
	When the TPA send updated offer
	Then offer is sent to claimant
	
Scenario Outline: Prouser rejects the third offer to Compensator
	Given '<claimant>' receives new offer
	When Prouser rejects offer and goes to court 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|

Scenario: Prouser selects court documents
	Given Claimant and rejected the offer and goes to court
	When prouser selects court documents for reject offer
	Then court documents are sent to TPA
 	
Scenario Outline: TPA disagree for document selection
	Given Uploaded documents for court cofirmed by Claimant
	When TPA disagrees to court documents uploaded by Claimant at '<status>'
	Then claimant need to review the documents uploaded by TPA
Examples:
|status|
|Pending-OfferListReview|

Scenario Outline: Claimant checks the documents selected by TPA and proceeds the claim for court 
   Given '<claimant>' checks the documents uploaded by Compensator   
   When prouser submit the claim for court and select witness at '<status>'                          
   Then  Case is closed with Go to court at offer stage  	
Examples:
 	|claimant|status|
 	|prouser|Pending-OfferListAmend|
	
Scenario Outline: The claim is moved to 'Resolved-CourtOffer'
 	Given '<claimant>' goes to court
 	When prouser claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|prouser|Resolved-CourtOffer|

	


