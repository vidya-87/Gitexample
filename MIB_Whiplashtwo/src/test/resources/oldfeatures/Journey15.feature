@mibpro
Feature: Journey 15

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
     | username                              | involvement_type_v| multivrn |                               
     | vandana@cognizant.com            | The driver        | NO    |
	 
	 
Scenario: Compensator Accept Claim and Part claim Liability
Given Claim  is sent to the compensator
When compensator accepts claim and makes part liability
Then the claims acceptance and liability is now sent to the claimant

Scenario: MIBpro claimant challenge liability decision
Given the MIBpro claim liability has been accepted by compensator
When MIBpro claimant challenges Liability
Then claim will be sent to compensator to update liability
  
Scenario: compensator updates liability
Given the claim liability decision has been challenged by claimant
When compensator updates liability
Then Updated liability information will be sent to claimant

Scenario: MIBpro Claimant again challenges liability (2nd time)
Given Updated Liability information received by MIBpro
When MIBpro claimant review challenge Liability
Then claim will be sent to compensator to update liability

Scenario: compensator updates liability (2nd time)
	Given the claim liability decision has been challenged by claimant
	When compensator updates liability
	Then Updated liability information will be sent to claimant

Scenario: MIBpro Claimant again challenges liability (3rd time)
	Given Updated Liability information received by MIBpro
	When MIBpro claimant review challenge Liability
	Then claim will be sent to compensator to update liability

Scenario: compensator updates liability (3rd time)
	Given the claim liability decision has been challenged by claimant 
	When compensator updates liability
	Then Updated liability information will be sent to claimant

Scenario: no challenge liability option and claimant proceeds with medical stage(DME) 
	Given Updated Liability information received by MIBpro
	When mibprouser selects medical preferences for an DME  
	Then medical preferences are sent to Independent Expert

Scenario: DME uploads report - Recovered -no WOP  
	Given claimant selects DME 
#	When claimant visits DME and completes checkup
	When DME uploads the medical report with waitout period before prognosis
	Then DME uploads report no prognosis

#Scenario: Mibpro Claimant asks for Second report    
#	Given medical report is sent to mibprouser claimant for review from compensator 
#	When MiBpro requests for second report                    
#	Then Claimant need to visit DME for medical examination again  
#
#Scenario: Medical provider selects claimant didnot attend the examination
#	Given Claimant did not attend the examination with DME
#	When Medical provider selects claimant didnot attend the examination
#	Then claim will be routed to compensator
#
#Scenario: Compensator uploads medical report with wait out prognosis
#	Given claim routed to compensator to upload medical reports      
#	When Compensator uploads medical report with WOP
#	Then report will be sent for claimant approval  


Scenario: MIBpro accepts wait out prognosis
	Given Medical report received by MIBPro claimant with wait out prognosis
	When MIBPro claimant accepts wait out prognosis
	Then claimant need to wait until waitout prognosis period ends

Scenario: MIBpro adds New losses after waitout prognosis                                                                 
	Given Mibprouser Claimant waitout Prognosis period is completed
	When MIBpro update the losses and fee from Loss Tile and proceeds with offer
	Then claim will be sent to compensator to review the losses added

Scenario: Compensator makes First Offer with fee proposal
	Given claimant requests offer
	When the compensator makes first offer with fee proposal
	Then offer is sent to claimant

Scenario Outline: MIBpro rejects the first offer to Compensator
	Given '<claimant>' receives the offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|mibpro|
	

Scenario: Compensator accepts the claimant counter offer
Given Claimant requested for revised offer
When Compensator accepts claimant counter offer
Then counter offer is sent to claimant for review


Scenario: Claimant Accepts First Offer to compensator and rejects Fee proposal and go to court
Given MIBpro claimant review fee proposal
When mibprouser claimant goes to court over fee proposal
Then claimant uploads court document

 Scenario: compensator agrees the nvc selection 
Given Compensator receives claim to review NVC answers
When Compensator responds to NVC answers
Then claim sent to mib prouser claimant for documents upload

Scenario: mibprouser Claimant select court docs
Given mibprouser Claimant receives the claim for document selection
When mibprouser Claimant selects court docs
Then claim sent to compensator for reviewing documents selected by mibprouser claimant
 	
Scenario: Compensator acknowledges documents selected for court
Given claimant selects court documents compensator
When Compensator agrees to court documents
Then claim will be sent for claimant acknowledgement

Scenario: mibprouser Claimant acknowledges Compensators doc selection and case is resolved
Given mibprouser receives claim for acknowledgement
When mibprouser claimant acknowledge
Then case is closed at court stage for mibprouser claimant 










                 

                          


