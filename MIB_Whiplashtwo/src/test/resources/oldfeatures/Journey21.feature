@mibpro
Feature: Journey21

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
     | username                              | involvement_type_v| multivrn |                               
     | vandana@cognizant.com            | A passenger on a bus        | NO    |
	 
	 
Scenario: Compensator  Accept Claim and full Liability
Given Claim  is sent to the compensator
When compensator accepts claim and makes full liability without dispute
Then the claims acceptance and liability is now sent to the claimant

Scenario: MIBpro Provides Medical Preferences 
Given compensator accepts mibprouser claim liability
When mibprouser selects medical preferences for an DME 
Then  mibprouser medical preferences are sent to Independent Expert


Scenario: DME uploads report-No prognosis
Given claimant selects DME 
When claimant visits DME and completes checkup
Then DME uploads report no prognosis

Scenario: MIBpro Claimant reviews and acknowledge medical report and proceed to offer
Given Mibprouserclaimant received the reports from DME 
When MIBpro update the losses and fee from Loss Tile and proceeds with offer                    
Then claim will be sent to compensator for first offer to mibprouser claimant

 Scenario: Compensator makes First Offer with fee proposal
 Given Claim  is sent to the compensator
 When the compensator makes first offer with fee proposal
 Then offer is sent to claimant 
 
Scenario: MIBpro Claimant requests for revised offer
Given Mibprouserclaimant received first offer from compensator
When  Mibprouser Claimant requests for revised offer    
Then  claim will be sent to compensator with revised offer
 
Scenario:  Compensator doesnot respond to the counter offer request made by claimant and claimant goes to court 
Given Compensator doesnot respond to the counter offer request
When mibprouser claimant goes to court            
Then claim will be sent to compensator to review nvc answers

Scenario: compensator agrees the nvc selection 
Given Compensator receives claim to review NVC answers
When Compensator responds to NVC answers
Then claim sent to mib prouser claimant for documents upload

Scenario: mibprouser Claimant select court docs
Given mibprouser Claimant receives the claim for document selection
When mibprouser Claimant selects court docs
Then claim sent to compensator for reviewing docuemnts selected by mibprouser claimant
 	
Scenario: Compensator acknowledges documents selected for court
Given claimant selects court documents compensator
When Compensator agrees to court documents
Then claim will be sent for claimant acknowledgement

Scenario: mibprouser Claimant acknowledges Compensators doc selection and case is resolved
Given mibprouser receives claim for acknowledgement
When mibprouser claimant acknowledge
Then case is closed at court stage for mibprouser claimant
   
   
