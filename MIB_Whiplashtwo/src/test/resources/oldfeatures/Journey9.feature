@prouser
@prouser @failed
Feature: Journey 9(Sprint 28)

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|	owner|							
	 |	A passenger on a bus|NO|
	 
Scenario: Compensator  Accept Claim and full Liability
 	Given Claim  is sent to the compensator
 	When compensator accepts claim and makes full liability without dispute
	Then the claims acceptance and liability is now sent to the claimant
  
Scenario Outline: Claimant Request first Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|prouser|


Scenario: Compensator makes first interim payment
	Given claimant request interm payment to compensator
	When compensator makes interim payment
	Then claimant receives interim payment
	
Scenario Outline: Claimant accepts first interim payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews and accept interim decision
	Then interim payment request is sent to compensator
Examples:
|claimant|
|prouser|


Scenario Outline: Claimant Request second Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|prouser|

Scenario: Compensator makes second interim payment
	Given claimant request interm payment to compensator
	When compensator makes interim payment
	Then claimant receives interim payment

Scenario Outline: Claimant accepts second interim and requests third interim
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews the interim payment and requests another interim payment
	Then payment is not received by the claimant
	
Examples:
|claimant|
|prouser |

Scenario Outline: Prouser decides to go to court over interim non-payment
	Given '<claimant>' interim non-payment SLA is breached
	When Go to court for non-payment option is enabled for '<claimant>'
	Then claimant decides to go to court over interim non-payment
Examples:
|claimant|
|prouser|



Scenario Outline: Pro user select court document for interim non-payment
	Given '<claimant>' goes to court over interim
	When '<claimant>' selects document for court for interim non-payment
	Then court document are sent to compensator 
Examples:
|claimant|
|prouser|	

Scenario: Compensator makes third interim payment
	Given claimant request interm payment to compensator
	When compensator makes interim payment
	Then claimant receives interim payment


	
Scenario Outline: Claimant accepts third interim payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews and accept interim decision
	Then claimant accepts interim decision
Examples:
|claimant|
|prouser|

Scenario Outline: Prouser uploads medical report and proceeds with offer
	Given upload medical report is enabled for '<claimant>'
	When claimant uploads medical report
	Then medical report is uploaded and offer request is sent to compensator

	Examples:
		|claimant|
		|prouser| 
		
 Scenario: Compensator makes First Offer with fee proposal
 Given Claim  is sent to the compensator
 When the compensator makes first offer with fee proposal
 Then offer is sent to claimant 
 
Scenario Outline: Prouser rejects the first offer to Compensator
	Given '<claimant>' receives new offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|
	
Scenario: Compensator reject claimant counter offer and makes new offer(second offer)
	Given Claim  is sent to the compensator
	When the compensator makes new offer
	Then offer is sent to claimant
	
Scenario Outline: Prouser rejects the second offer to Compensator
	Given '<claimant>' receives new offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|

Scenario: Compensator reject claimant counter offer and makes new offer(third offer)
	Given Claim  is sent to the compensator
	When the compensator makes new offer
	Then offer is sent to claimant
	
Scenario: prouser accepts offer and rejects fee proposal
  Given prouser review fee proposal
  When prouser accepts offer and makes counter fees proposal
  Then pro counter offer sent to compensator


Scenario: prouser go to court for fee proposal
  Given Prouser reject fee proposal
  When prouser claimant goes to court over fee proposal
  Then the claimant goes to court
		
Scenario: Compensator acknowledges documents selected for court
	Given claimant selects court documents compensator
	When Compensator agrees to court documents
	Then claim will be sent for claimant acknowledgement

Scenario: prouser Claimant acknowledges Compensators doc selection and case is resolved
	Given prouser receives claim for acknowledgement
	When prouser claimant acknowledge
	Then case is closed at court stage

