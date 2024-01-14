@failed @mibpro
Feature: Journey 16


Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
            | involvement_type_v  | multivrn |                               
     				| A passenger on a bus| NO       |

Scenario: Compensator  Accept Claim and full Liability
  Given Claim  is sent to the compensator
  When compensator accepts claim and makes full liability without dispute
  Then the claims acceptance and liability is now sent to the claimant

Scenario Outline: claimant proceeds with medical stage(DME) 
	Given compensator accepts mibprouser claim liability
	When mibprouser selects medical preferences for an DME  
	And '<claimant>' adds fee
	Then medical preferences are sent to Independent Expert
Examples:
	|claimant|
	|mibpro|

Scenario: DME uploads report - Recovered -no WOP  
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario Outline: Claimant Request first Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|mibpro|	

Scenario: Compensator makes first interim payment
	Given claimant request interm payment to compensator
	When compensator makes interim payment
	Then claimant receives interim payment

Scenario Outline: Claimant rejects interim payment decision and decides go to court and selectcourtdocs
	Given '<claimant>' goes to court over interim
	When '<claimant>' go to court and selects document for court for interim payment
	Then court document are sent to compensator 
Examples:
|claimant|
|mibpro|

Scenario: Compensator Selects court document for secondary action ( Interim).
	Given claimant goes to court
	When Compensator reviews court document
	Then court docs sent for review to claimant

Scenario: MIBpro acknowledges documents selected by compensator
	Given compensator confirmed documents selected by MIB PRO
	When MIB PRO acknowledges selected documents
	Then Interim case is resolved but go to court main claim carries on

Scenario: MIBpro Claimant reviews and acknowledge medical report and proceed to offer
Given Mibprouserclaimant received the reports from DME 
When  Mibprouser Claimant reviews medical report and proceed to offer                    
Then claim will be sent to compensator for first offer to mibprouser claimant

Scenario: Compensator makes First Offer with fee proposal
	Given claimant requests offer
	When the compensator makes first offer with fee proposal
	Then offer is sent to claimant


Scenario: MIB prouser withdraws claim
	Given the compensator makes first offer to the claimant
	When the MIB prouser claimant then decides to withdraw the claim 
	Then the claimant has withdrawn claim and Compensator to acknowledge this


Scenario: Compensator  Acknowledge withdrawal
	Given the MIB prouser claimant has withdrawn claim
	When Compensator acknowledges claimants withdrawal 
	Then the claim can be Resolved

