@mibpro
Feature: Journey34

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
     | username      				| involvement_type_v						| multivrn |                               
     | vandana@cognizant.com| A passenger in a car/van/lorry| NO    |

Scenario: Compensator  Accept Claim and full Liability
  Given Claim  is sent to the compensator
  When compensator accepts claim and makes full liability without dispute
  Then the claims acceptance and liability is now sent to the claimant
  
Scenario Outline: Claimant selects and select ‘Outside England or Wales’ and uploads own medical report
   Given upload medical report is enabled for '<claimant>'
   When '<claimant>' uploads own medical report
   Then medical report is uploaded successfully
   
  Examples:
  |claimant|
  |mibpro|
  
Scenario: MIBpro Claimant reviews after uploading Medical report and proceeds with offer
	Given Mibprouserclaimant received the reports from DME 
	When  Mibprouser Claimant reviews own medical report and proceed to offer
	Then claim will be sent to compensator for first offer to mibprouser claimant

Scenario: Compensator makes First Offer with fee proposal
 	Given Claim  is sent to the compensator
 	When the compensator makes first offer with fee proposal
 	Then offer is sent to claimant 
 
Scenario: MIBpro claimant accepts offer and fee proposal
  Given MIBpro claimant review fee proposal
  When mibprouser claimant accept first offer and fees proposal
  Then MIBpro counter offer sent to compensator


Scenario: Compensator acknowledge claimant offer
 	Given Claim  is sent to the compensator
  When Compensator acknowledges claimants offer
  Then claim SLA is breached
 
Scenario: MIBpro goes to court for non-payment of offer (OCS3)
	Given claim is pending for settlement for MIBPRO
	When MIBPro claimant decides to go to court for claim settlement pending
	Then documents should be reviewed by Compensator

 	
Scenario: Compensator acknowledges documents selected for court
	Given claimant selects court documents compensator
	When Compensator agrees to court documents
	Then claim will be sent for claimant acknowledgement

Scenario: mibprouser Claimant acknowledges Compensators doc selection
Given mibprouser receives claim for acknowledgement
When mibprouser claimant acknowledge
Then case is closed at court stage for mibprouser claimant  