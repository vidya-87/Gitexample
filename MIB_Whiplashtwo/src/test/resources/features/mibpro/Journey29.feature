@mibpro
Feature: Journey 29

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	 | owner| involvement_type_v|  multivrn |location|							
	 | NO|	A passenger in a car/van/lorry	|  NO	|Inside UK|
	 							

	 
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
	 
	
Scenario: TPA  Denies Claim and claim Liability
	Given the claim  has been sent to the TPA workbasket
  	When  TPA dispute claim liability
 	 Then  claims acceptance and liability information is passed to claimant
 
Scenario: Claimant Challenge Decision and goes to court
	Given MIBpro claim liability has been rejected
	When MIBpro wants to challenge decision and decided to go to court
	Then the claimant goes to court

Scenario: TPA disagree for document selection
	Given Uploaded documents for court cofirmed by Claimant
	When TPA disagrees to court documents uploaded by Claimant
	Then claimant need to review the documents uploaded by TPA

Scenario Outline: mibpro Claimant acknowledges TPA doc selection and case is resolved
	Given '<Claimant>' checks the documents uploaded by TPA   
   When MIBpro submits the court documents for liability                        
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|mibpro| 
	
Scenario: Claimant decides to reopen the claim with court decision as part liability
	 Given The claim was resolved at court
	 When MIBpro reopens liability disputed claim
	 Then MIBpro reopens the claims sucessfully
	 
Scenario Outline: mibpro Provides Medical Preferences 
	Given compensator accepts mibprouser claim liability
	When MIBpro makes medical provider selection '<status>'
	Then medical preferences are sent to Independent Expert
Examples:
|status|
|Pending-MedicalAfterCourt|

Scenario: Claimant should not be able to challenge liability
 	Given MIBpro has reopened the claim
 	When MIBpro tries to challenge liability
 	Then the link should not be present
 	
Scenario: TPA should not be able change liability decision
	Given the claim is reopened by the claimant
	When TPA tries to change the liability decision
	Then the link should not be present 
	
Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis



Scenario: MIBpro Claimant reviews and acknowledge medical report and proceed to offer
	Given Mibprouserclaimant received the reports from DME 
	When Mibprouser Claimant reviews medical report and proceed to offer                    
	Then claim will be sent to compensator for first offer to mibprouser claimant
	
	
Scenario: Compensator disputes causation at offer and makes final offer
 	Given claimant has request for an offer
 	When Compensator disputes causation and make final offer
 	Then claim is sent to claimant

 Scenario: Claimant accepts the decision and no offer is made
	Given compensator has disputed causation for MIBpro
	When MIBpro reject the dispute causation final offer
	Then claim moves to Resolved-FinalOfferRejected
 	
 Scenario Outline: The claim is moved to 'Resolved-FinalOfferRejected'
 	Given '<claimant>' goes to court
 	When mibpro claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|mibpro|Resolved-FinalOfferRejected|
  