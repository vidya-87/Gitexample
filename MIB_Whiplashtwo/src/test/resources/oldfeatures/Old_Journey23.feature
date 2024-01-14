@failed @unrep
Feature: Journey 23(Sprint 28)

Scenario Outline: User Enters details in your details page
		Given unrep logins into whiplash application
		When user enter all mandatory details for claim creation as '<involvement_type_v>' and '<ct_preference>' with '<multivrn>'
		Then claim reference number for unrep claim is created
		Examples:
		 | username			  				| involvement_type_v | ct_preference|multivrn|						
		 | vandana@cognizant.com	|	I was a passenger on a bus | EMAIL|NO|
	 
Scenario: Compensator  Accept Claim and full Liability
 	Given Claim  is sent to the compensator
 	When compensator accepts claim and makes full liability without dispute
	Then the claims acceptance and liability is now sent to the claimant

Scenario: Unrep Provides Medical Preferences
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME
	Then medical preferences are sent to Independent Expert


Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario Outline: Claimant Request first Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|unrep|	

Scenario: Compensator makes first interim payment
Given claimant request interm payment to compensator
When compensator makes interim payment
Then claimant receives interim payment

Scenario Outline: Claimant accepts first interim payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' reviews and accept interim decision
	Then payment is not received by the claimant
Examples:
|claimant|
|unrep|

Scenario Outline: Claimant Request second Interim Payment 
	Given claim has been accepted for '<claimant>'
	When '<claimant>' requests interim payment
	Then interim payment request is sent to compensator
Examples:
|claimant|
|unrep|	


Scenario Outline: unrep decides to go to court over interim non-payment
	Given '<claimant>' interim non-payment SLA is breached
	When Go to court for non-payment option is enabled for '<claimant>'
	Then claimant decides to go to court over interim non-payment
Examples:
|claimant|
|unrep|




Scenario Outline: unrep select court document for interim non-payment
	Given '<claimant>' goes to court over interim
	When '<claimant>' selects document for court for interim non-payment
	Then court document are sent to compensator 
Examples:
|claimant|
|unrep|	


Scenario: Compensator makes second interim with reduced payment
Given claimant request interm payment to compensator
When compensator makes interim payment
Then claimant receives interim payment

Scenario: Claimant cannot proceed to court for 2nd interim when 1st interim is in court
	Given claimant goes to court for first interim
	When claimant goes to court for second interim over reduced payment
	Then error message is displayed and will not allow the claimant to proceed

Scenario: Compensator agrees the court document for non-payment of first interim payment
	Given claimant goes to court
	When Compensator reviews court document
	Then court docs sent for review to claimant

Scenario Outline: Claimant Acknowledges Court documents for first interim
	Given '<claimant>' checks the documents uploaded by Compensator
	When 	'<claimant>' submit the documents for court for interim
	Then first interim is closed at court stage
Examples:
|claimant|
|unrep|

           
Scenario Outline: unrep go to court for reduced interim payment
	Given '<claimant>' goes to court over interim
	When '<claimant>' go to court and selects document for court for interim payment
	Then court document are sent to compensator 
Examples:
|claimant|
|unrep|

Scenario: Compensator agrees the court document for non-payment of first interim payment
	Given claimant goes to court
	When Compensator reviews court document
	Then court docs sent for review to claimant


Scenario Outline: Claimant Acknowledges Court documents for Second interim
	Given '<claimant>' checks the documents uploaded by Compensator
	When 	'<claimant>' submit the documents for court for interim
	Then Interim Case is closed with Go to court and main claim proceeds to offer stage
Examples:
|claimant|
|unrep|


Scenario: Claimant reviews and acknowledge medical report                                                                
	Given DME uploads medical report
	When claimant reviews medical report and acknowledges the report
	Then claim will be sent to compensator for review


Scenario: Compensator make first offer to unrep
	Given Claim  is sent to the compensator
	When the compensator makes first offer
	Then offer is sent to claimant

Scenario: Claimant withdraws the claim
  Given claimant reviews medical report when uploaded by DME
  When the unrep claimant then decides to withdraw the claim
  Then the claimant has withdrawn claim and Compensator to acknowledge this
  
  Scenario: Compensator acknowledges the withdrawl and claim resolved
  Given Claim  is sent to the compensator
  When Compensator acknowledges claimants withdrawal
  Then the claim can be Resolved













	
	