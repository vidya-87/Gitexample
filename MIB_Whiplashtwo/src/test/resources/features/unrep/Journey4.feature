@unrep
Feature: Journey 4

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |	location|							
	 | YES|	I was the driver	| BOTH		| NO	|Inside UK|
	 
	 
Scenario: Compensator Accept Claim and Part claim Liability with causation
Given Claim  is sent to the compensator
When compensator accepts claim and makes part liability
Then the claims acceptance and liability is now sent to the claimant

Scenario: claimant challenge liability decision
Given the claim liability has been accepted by compensator
When claimant challenges Liability
Then claim will be sent to compensator to update liability
  
Scenario: Compensator updates liability with increased liability %
Given the claim liability decision has been challenged by claimant
When compensator updates liability
Then Updated liability information will be sent to claimant

Scenario: Claimant again challenges liability (2nd time)
Given Updated Liability information received by claimant
When claimant review challenge Liability
Then claim will be sent to compensator to update liability

Scenario: Compensator updates liability with increased liability % (2nd time)
Given the claim liability decision has been challenged by claimant
When compensator updates liability
Then Updated liability information will be sent to claimant

Scenario: Claimant again challenges liability (3rd time)
Given Updated Liability information received by claimant
When claimant review challenge Liability
Then claim will be sent to compensator to update liability

Scenario: Compensator updates liability with increased liability % (3rd time)
Given the claim liability decision has been challenged by claimant 
When compensator updates liability
Then Updated liability information will be sent to claimant

Scenario: no challenge liability option and claimant proceeds with medical stage(DME) 
Given Updated Liability information received by claimant
And claimant review and decline Liability
When unrep selects medical preferences  
Then medical preferences are sent to Independent Expert

Scenario: DME uploads report - Recovered -no WOP  
Given claimant selects DME 
When claimant visits DME and completes checkup
Then DME uploads report no prognosis

Scenario: Unrep decides to obtain further report and uploads report with waitout prognosis   
Given Claimant received the reports from DME 
When claimant decides to obtain further report                 
Then claimant uploads further medical report uploaded successfully

Scenario: Claimant decides to waitout prognisis and requests further medical report
Given Claimant accepts waitout prognosis
When Claimant decides to accept waitout prognosis
And claimant requests for further medical 
Then acknowledgment is sent to compensator

Scenario: Compensator accepts claimant to upload further medical report
Given claimant has given a request for further medical report
When Compensator provides the consent for obtaining further medical report
Then Compensator decision is sent to the claimant

Scenario Outline: Claimant upload further medical report without WOP - recovered and Add losses and fee
Given Compensator has acknowledged for further medical report
When claimant uploads the further report
And '<claimant>' add losses and fee
Then medical report is uploaded successfully
Examples:
|claimant|
|unrep|

Scenario: Claimant decides to proceed with offer
Given claimant uploads further medical report
When claimant proceeds to offer
Then offer request is sent to compensator



################Challenge NON whiplash injury added ##############################


Scenario: Compensator decided to make offer and fees proposal with NON WHIPLASH injury
	Given Compensator login for provide offer
	When Compensator decided to make offer with non whiplash injury
	Then compensator sent offer to claimant

Scenario Outline: Claimant challenge NON WHIPLASH injury (1st challenge)
	Given "<Claimant>" login to check offer
	When Claimant challenge NON WHIPLASH injury
	Then Challenge sent back to compensator
Examples:
|Claimant|
|unrep|
	

Scenario: Compensator rejected claimant NON Whiplash 
	Given Compensator login for provide offer
	When Compensator rejected claimant NON Whiplash challenge
	Then compensator sent offer to claimant
	
Scenario Outline: Claimant challenge NON WHIPLASH injury (2nd challenge)
	Given "<Claimant>" login to challenge NON Whiplash decision
	When Claimant rejected compensator NON WHIPLASH injury decision
	Then Challenge sent back to compensator
Examples:
|Claimant|
|unrep|

Scenario: Compensator rejected claimant NON Whiplash 
	Given Compensator login for provide offer
	When Compensator rejected claimant NON Whiplash challenge
	Then compensator sent offer to claimant
	
	
	Scenario Outline: Claimant challenge NON WHIPLASH injury (3rd challenge)
	Given "<Claimant>" login to challenge NON Whiplash decision
	When Claimant rejected compensator NON WHIPLASH injury decision
	Then Challenge sent back to compensator
Examples:
|Claimant|
|unrep|

Scenario: Compensator rejected claimant NON Whiplash 
	Given Compensator login for provide offer
	When Compensator rejected claimant NON Whiplash challenge
	Then compensator sent offer to claimant


	
Scenario Outline: Claimant challenge NON WHIPLASH injury (Accept final rejection)
	Given "<Claimant>" login to challenge NON Whiplash decision
	When Claimant respond after compensator reject final challenge
	Then Challenge sent back to compensator
Examples:
|Claimant|
|unrep|
	

###############

Scenario Outline: Unrep rejects the first offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|unrep|
	

Scenario: Compensator accepts the claimant counter offer
	Given Claimant requested for revised offer
	When Compensator accepts claimant counter offer
	Then counter offer is sent to claimant for review
	
Scenario: Claimant Accepts First Offer and reject fee offer to compensator
	Given claimant accepts first offer
	When Claimant accepts offer and makes counter fees proposal
	Then claimant uploads court document

Scenario: Compensator rejects claimant's fee offer
	Given Claim  is sent to the compensator
	When compensator rejects claimant fee offer
	Then Compensator decision is sent to the claimant
	
Scenario: Claimant rejects Fee proposal and go to court
Given claimant accepts first offer
When claimant rejects fee offer and goes to court
Then claimant uploads court document

 Scenario Outline: Compensator acknowledges documents selected for court
   Given claimant selects court documents compensator
   When Compensator agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-FeesListReview|
   
Scenario Outline: unrep Claimant checks the documents selected by Compensator and submit the claim for court 
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When '<Claimant>' submit the claim for court with claim '<status>' for fee dispute                      
   Then  Case is closed with Go to court at offer stage  	
Examples:
 	|Claimant|status|
 	|unrep|Pending-FeesListAccept|
 
 Scenario Outline: The claim is moved to 'Resolved-CourtFees'
 	Given '<claimant>' goes to court
 	When the claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|unrep|Resolved-CourtFees|








