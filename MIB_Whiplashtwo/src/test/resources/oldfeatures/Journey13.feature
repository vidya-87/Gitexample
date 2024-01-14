@mibpro
Feature: Journey13

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
     | username                              | involvement_type_v| multivrn |                               
     | vandana@cognizant.com            | The driver        | YES    |

Scenario: CSR allocates claim to  compensator
Given Claim received by csr and eligible for assigning to compensator
When CSR assigns compensator
Then Claim is sent to respective compensator
	 
Scenario: Compensator  Accept Claim and denies Liability
Given Claim  is sent to the compensator
When compensator denies full liability
Then the claims acceptance and liability is now sent to the claimant

Scenario: Mibprouser Claimant Challenge liability rejected Decision and goes to court
Given Mibprouser Claimant claim liability has been rejected
When Mibprouser claimant wants to challenge rejected liability decision and decided to go to court
Then claim sent to compensator for reviewing documents selected by mibprouser claimant

Scenario: Compensator acknowledges documents selected for court
Given claimant selects court documents compensator
When Compensator agrees to court documents
Then claim will be sent for claimant acknowledgement

Scenario: mibprouser Claimant acknowledges Compensators doc selection and case is resolved
Given mibprouser receives claim for acknowledgement
When mibprouser claimant acknowledge with witness
Then case is closed at court stage for mibprouser claimant

Scenario: Compensator reopens claim and accepts full claim liability
Given claimant uploads court documents
When compensator reopens liability disputed claim
Then compensator accepts full liability
	
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
When  Mibprouser Claimant reviews medical report and proceed to offer                    
Then claim will be sent to compensator for first offer to mibprouser claimant

#Scenario: DME selects option unable to upload report
#Given claimant selects DME
#When  DME selects option unable to upload report
#Then compensator gets the option to upload report
#
#
#
##Scenario: Compensator uploads medical report with wait out prognosis
##Given claim routed to compensator to upload medical reports      
##When Compensator uploads medical report with wait out prognosis
##Then report will be sent for claimant approval  
#
#Scenario:  MIB prouser Claimant request for another report
#Given medical report is sent to mibprouser claimant for review from compensator
#When mibprouser Claimant reviews report and  selects option Report not factually correct and request for another report
#Then request is sent to compensator
#
#Scenario: Compensator uploads revised medical report with wait out prognosis
#Given claim routed to compensator to upload medical reports      
#When Compensator uploads revised medical report with wait out prognosis
#Then report will be sent for claimant approval

#Scenario: MIBprouser Claimant accepts wop and proceed to offer
#Given Compensator sent revised report with WOP
#When  Mibprouser accepts wop in revised report and proceed to offer after wop
#Then claim will be sent to compensator for first offer to mibprouser claimant

Scenario: compensator receives the claim by claimant after WOP
Given Claim  is sent to the compensator
When the compensator makes first offer to MIBpro
Then offer is sent to claimant

Scenario: Mibprouser Claimant Accept Offer  and Fees proposal
Given Mibprouserclaimant received first offer from compensator
When mibprouser claimant accept first offer and fees proposal
Then first offer acceptance by mibprouser is sent to compensator for acknowledgement

Scenario: Compensator acknowledges offer
 Given Claim  is sent to the compensator
 When Compensator acknowledges claimants offer
 Then the claim can be Resolved
 
 Scenario: mibprouser Claimant go to court for claim settlement pending 
Given mibprouser Claimant receives the claim for document selection
When mibprouser Claimant goes to court for claim settlement pending and select documents
Then claim sent to compensator for reviewing documents selected by mibprouser claimant
 	
Scenario: Compensator acknowledges documents selected for court
Given claimant selects court documents compensator
When Compensator agrees to court documents
Then claim will be sent for claimant acknowledgement

Scenario: mibprouser Claimant acknowledges Compensators doc selection and case is resolved
Given mibprouser receives claim for acknowledgement
When mibprouser claimant acknowledge
Then case is closed at court stage for mibprouser claimant 