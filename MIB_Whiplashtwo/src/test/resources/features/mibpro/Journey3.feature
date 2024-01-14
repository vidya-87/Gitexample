@mibpro
Feature: Journey 3
Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	 | owner| involvement_type_v| multivrn |location|							
	 | NO|A passenger in a car/van/lorry| NO|Inside UK|
	 
Scenario: Compensator  Accept Claim and full Liability
 	Given Claim  is sent to the compensator
	When compensator accepts claim and makes full liability without dispute
	Then the claims acceptance and liability is now sent to the claimant

Scenario: Claimant makes medical provider selection (DME) and adds losses and documents
	Given compensator accepts mibprouser claim liability
	When mibprouser selects medical preferences for an DME
	And MIBpro claimant update the losses and upload documents
	Then medical preferences are sent to Independent Expert

Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: Claimant adds more losses and proceeds with offer
	Given MIBpro reviews medical report when uploaded by DME
	And MIBpro update the losses from Loss Tile
	When MIBpro requests an UPLIFT due to EXCEPTIONAL CIRCUMSTANCES
	Then claim is sent to compensator

Scenario: compensator make first offer with loss added and disagree uplift
	Given claimant proceed with offer
	When compensator makes first offer with loss added and disagree uplift
	Then offer is sent to claimant 


Scenario Outline: MIBpro rejects the first offer and sends updated offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer with uplift
	Then first offer is sent for revision
	
	Examples:
	|claimant|
	|mibpro|

Scenario: Compensator start updating and clicks on save and exit (doesn't update the offer)
	Given Claim  is sent to the compensator
	Then compensator does not update the offer
	

Scenario: Claimant decides to go to court(OCS2)
	Given Compensator doesnot respond to the counter offer request
	When mibprouser claimant goes to court
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
   Given claimant selects court documents compensator
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
 	|mibpro|   
   

 



	


	