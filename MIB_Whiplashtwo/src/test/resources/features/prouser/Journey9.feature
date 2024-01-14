@prouser
Feature: Journey 9


Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|	owner|multivrn|						
	 |	A passenger on a bus|NO|YES|

Scenario: CSR allocates claim to  compensator
	Given Claim received by csr and eligible for assigning to compensator
	When CSR assigns compensator
	Then Claim is sent to respective compensator
	
Scenario: Compensator receives claim and claim liability sent to TPA
	Given Claim  is sent to the compensator
	When  compensator receives claim and send to TPA
	Then claims acceptance and liability decision is now sent to TPA
  
Scenario: TPA disputes causation and admits part liability
	Given Login as TPA
  When TPA accepts claim and makes part liability
  Then claims acceptance and liability information is passed to claimant
  
Scenario: Prouser challenge liability
	Given Prouser claim liability has been partially accepted by TPA
	When Prouser challenges Liability
	Then Prouser claim will be sent to TPA to update liability 
  
#Scenario Outline: Claimant Request first Interim Payment 
#	Given claim has been accepted for '<claimant>'
#	When '<claimant>' requests interim payment
#	Then interim payment request is sent to compensator
#Examples:
#|claimant|
#|prouser|


#Scenario: TPA makes first interim payment
#	Given claimant request interm payment to TPA
#	When TPA makes interim payment
#	Then claimant receives interim payment from TPA
#	
#Scenario Outline: Claimant accepts first interim payment 
#	Given claim has been accepted for '<claimant>'
#	When '<claimant>' reviews and accept interim decision
#	Then interim payment request is sent to compensator
#Examples:
#|claimant|
#|prouser|
#
#Scenario Outline: Prouser decides to go to court over interim non-payment
#	Given '<claimant>' interim non-payment SLA is breached
#	When Go to court for non-payment option is enabled for '<claimant>'
#	Then claimant decides to go to court over interim non-payment
#Examples:
#|claimant|
#|prouser|
#
#
#
#Scenario Outline: Pro user select court document for interim non-payment
#	Given '<claimant>' goes to court over interim
#	When '<claimant>' selects document for court for interim non-payment
#	Then court document are sent to compensator 
#Examples:
#|claimant|
#|prouser|	
#


Scenario Outline: Claimant Request second Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|prouser|

Scenario Outline: Prouser uploads medical report
	Given upload medical report is enabled for '<claimant>'
	And '<claimant>' adds fee
	When claimant uploads only medical report at '<status>'
	Then medical report is uploaded and offer request is sent to compensator

	Examples:
		|claimant|status|
		|prouser|Pending-MedicalPartLiable|

Scenario: TPA makes second interim payment
	Given claimant request interm payment to TPA
	When TPA makes interim payment
	Then claimant receives interim payment from TPA

Scenario Outline: Claimant accepts second interim and requests third interim
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews the interim payment and requests another interim payment
	Then claimant accepts interim decision
	#Then payment is not received by the claimant
	
Examples:
|claimant|
|prouser |


Scenario: Compensator makes third interim payment
	Given claimant request interm payment to TPA
	When TPA makes interim payment
	Then claimant receives interim payment from TPA


	
Scenario Outline: Claimant accepts third interim payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews and accept interim decision
	Then claimant accepts interim decision
Examples:
|claimant|
|prouser|

Scenario: Prouser proceeds with offer
	Given claimant has upload the medical report successfully
	When claimant reviews medical report and proceed to offer
	Then claim will be sent to TPA for offer 

		
 Scenario: TPA makes First Offer with fee proposal
	 Given claimant requests offer to TPA
	When the TPA makes first offer with fee proposal
	Then claim will be sent for claimant acknowledgement
 
Scenario Outline: Prouser rejects the first offer to Compensator
	Given '<claimant>' receives new offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|
	
Scenario: TPA reject claimant counter offer and makes new offer(second offer)
	Given Login as TPA
	When the TPA send updated offer
	Then offer is sent to claimant
	
Scenario Outline: Prouser rejects the second offer to Compensator
	Given '<claimant>' receives new offer
	When '<claimant>' reject the offer 
	Then counter offer is sent for revision
	Examples:
	|claimant|
	|prouser|

Scenario: TPA reject claimant counter offer and makes new offer(third offer)
	Given Login as TPA
	When the TPA send updated offer
	Then offer is sent to claimant
	
Scenario: prouser accepts offer and rejects fee proposal
  Given prouser review fee proposal
  When prouser accepts offer and makes counter fees proposal
  Then pro counter offer sent to compensator

Scenario: TPA rejects claimants fee offer
	Given Prouser rejects fee offer
	When TPA rejects claimant fee offer
	Then TPA sends the updated fee offer to prouser

Scenario: prouser go to court for fee proposal
  Given Prouser reject fee proposal
  When prouser reject fee offer and goes to court
  Then the claimant goes to court
		
Scenario Outline: TPA acknowledges documents selected for court
   Given claimant selects court documents TPA
   When TPA agrees to court documents when claim is in '<status>'
   Then claim is sent to claimant 
 Examples:
 |status|
 |Pending-FeesListReview|

Scenario Outline: prouser Claimant acknowledges Compensators doc selection and case is resolved
	Given '<claimant>' checks the documents uploaded by Compensator
	When '<claimant>' submit the claim for court with claim '<status>' for fee dispute
	Then case is closed at court stage
Examples:
|claimant|status|
 |prouser|Pending-FeesListAccept|
 
 
 Scenario Outline: The claim is moved to 'Resolved-CourtFees'
 	Given '<claimant>' goes to court
 	When prouser claim goes to dispute at court at '<status>'
 	Then the claim will be resolved at court
 	Examples:
	|claimant|status|
 	|prouser|Resolved-CourtFees|
	
