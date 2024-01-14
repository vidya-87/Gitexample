@unrep
Feature: Journey 3

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |location|							
	 | NO|I was a passenger in a Car/Lorry/Van| BOTH| NO|Inside UK|
	 
Scenario: CompensatorA transfers claim to another CompensatorB
	 Given Claim  is sent to the compensator
	 When compensator transfer claim to compensatorB
	Then the claim is sent to CompensatorB	
	
Scenario: CompensatorB accepts transfer request
	Given Transfer request sent to CompensatorB
	When compensatorB accepts transfer request
	Then claim moved to CompensatorB workbasket	 
	 
Scenario: CompensatorB  Accept Claim and full Liability
 	Given Claim in compensatorB workbasket
	When compensator accepts claim and makes full liability without dispute
	Then the claims acceptance and liability is now sent to the claimant

Scenario: unrep Claimant makes medical provider selection (DME) and adds losses and documents
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME
	And Claimant Adds losses from losses tile
	And Claimant uploads document from Doc tile
	Then medical preferences are sent to Independent Expert

Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: unrep Claimant adds more losses and proceeds with offer
	Given claimant reviews medical report when uploaded by DME
	And Claimant Adds losses from losses tile
	When Claimant requests an UPLIFT due to EXCEPTIONAL CIRCUMSTANCES
	Then claim is sent to compensator

Scenario: compensator make first offer with loss added and disagree uplift
	Given Claim in compensatorB workbasket
	When compensator makes first offer with loss added and disagree uplift
	Then offer is sent to claimant 
	
################# new added for NON whiplash injury challenge ##########################
	
Scenario: Compensator decided to make offer with NON WHIPLASH injury
	Given Claim in compensatorB workbasket
	When Compensator decided to make offer with non whiplash injury and disagree uplift
	Then compensator sent offer to claimant

Scenario Outline: Claimant challenge NON WHIPLASH injury (1st challenge)
	Given "<Claimant>" login to check offer
	When Claimant challenge NON WHIPLASH injury
	Then Challenge sent back to compensator
Examples:
|Claimant|
|unrep|	

Scenario: Compensator Accepted claimant NON Whiplash 
	Given Claim in compensatorB workbasket
	When Compensator accepted claimant NON Whiplash challenge
	And Compensator make replacement offer with tariff amount
	Then compensator sent offer to claimant
	
#############################################################################
	


Scenario Outline: Unrep rejects the first offer and sends updated offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer with uplift
	Then first offer is sent for revision
	
	Examples:
	|claimant|
	|unrep|

Scenario: Compensator start updating and clicks on save and exit (doesn't update the offer)
	Given Claim in compensatorB workbasket
	Then compensator does not update the offer
	

Scenario: Claimant decides to go to court(OCS2)
	Given Compensator didn’t respond to claimant updated offer
	When claimant decided to go to court and answerNVC
	Then the claimant goes to court

#Scenario: Compensator responds to NVC questions
#   Given Compensator receives claim to review NVC answers
#   When Compensator responds to NVC answers
#   Then claim should be sent to claimant to select documents for court
#  
#  
#Scenario Outline: unrep Claimant selects documents for court     
# 	Given Compensator responds NVC answers to '<Claimant>'    
# 	When '<Claimant>' selects documents for court  
# 	Then documents should be reviewed by Compensator
# 	Examples:
# 	|Claimant|
# 	|unrep|
 	
  Scenario Outline: Compensator acknowledges documents selected for court
   Given Claim in compensatorB workbasket
   When Compensator agrees to court documents when claim is in '<status>'
   Then claim will be sent for claimant acknowledgement 
 Examples:
 |status|
 |Pending-OfferListReview|
   
Scenario Outline: unrep Claimant checks the documents selected by Compensator and submit the claim for court 
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When '<Claimant>' submit the claim for court and select witness                          
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|unrep|   
   

 



	


	