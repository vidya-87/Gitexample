@prouser
Feature: Journey 36

Scenario Outline: Prouser Submit a Claim as a owner
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|owner|multivrn|								
	 |	The driver|	YES|NO|
	 
	 
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
	
Scenario: Compensator reject claimant counter offer and makes new offer(third offer)
	Given Login as TPA
	When the TPA send updated offer
	Then offer is sent to claimant
	
Scenario Outline: Prouser rejects offer and goes to court
	Given '<claimant>' receives new offer
	When '<claimant>' decides to go to court after rejecting offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|
	
Scenario Outline: Prouser goes to court and answer NVC
	Given '<claimant>' decided to go to court 
	When '<claimant>' answers NVC questions  
Then claim will be sent to compensator to review nvc answers
Examples:
	|claimant|
	|prouser|

Scenario: TPA agrees the nvc selection 
	Given TPA receives claim to review NVC answers
	When TPA responds to NVC answers
	Then claim should be sent to claimant to select documents for court

Scenario Outline: prouser Claimant selects documents for court     
	Given Compensator responds NVC answers to '<Claimant>'    
 	When '<Claimant>' selects documents for court after NVC  
 	Then documents should be reviewed by Compensator
 Examples:
 	|Claimant|
 	|prouser|
 	
Scenario Outline: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-OfferListReview|
 
 Scenario Outline: prouser Claimant acknowledges TPA doc selection and case is resolved
	Given '<claimant>' checks the documents uploaded by Compensator
	When prouser submit the claim for NVC court and select witness at '<status>'
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

	


