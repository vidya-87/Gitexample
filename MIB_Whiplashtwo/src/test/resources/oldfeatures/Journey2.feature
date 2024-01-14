@unrep
Feature: Journey 2

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |location|							
	 | NO|	I was the driver	| BOTH		| YES	|Inside UK|
	 
Scenario: CSR allocates claim to  compensator
Given Claim received by csr and eligible for assigning to compensator
When CSR assigns compensator
Then Claim is sent to respective compensator
	 
Scenario: Compensator  Accept Claim and denies Liability
	Given Claim  is sent to the compensator
	When compensator denies full liability
	Then the claims acceptance and liability is now sent to the claimant

Scenario: Claimant Challenge Decision and goes to court
Given Claimant claim liability has been rejected
When claimant wants to challenge decision and decided to go to court
Then the claimant goes to court

 	
 Scenario: Compensator review and agrees to claimant court document
   Given claimant selects court documents compensator
   When Compensator agrees to court documents
   Then claim will be sent for claimant acknowledgement 
 
 Scenario Outline: unrep Claimant checks the documents selected by compensator and submit the claim for court    
   Given '<Claimant>' checks the documents uploaded by Compensator   
   When '<Claimant>' submit the claim for court and select witness                         
   Then  Case is closed with Go to court at offer stage  	
		Examples:
 	|Claimant|
 	|unrep|   
 	
Scenario: Compensator reopens claim and accepts full claim liability
	Given claimant uploads court documents
	When compensator reopens liability disputed claim
	Then compensator accepts full liability


Scenario: Unrep Provides Medical Preferences 
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME
	Then medical preferences are sent to Independent Expert


Scenario: DME selects option unable to upload report
Given claimant selects DME
When  DME selects option unable to upload report
Then compensator gets the option to upload report

Scenario: Compensator uploads medical report with wait out prognosis
Given claim routed to compensator to upload medical reports      
When Compensator uploads medical report with wait out prognosis
Then report will be sent for claimant approval  

Scenario: Claimant request for another report
Given medical report is sent to claimant for review 
When Claimant requests for second report                   
Then request is sent to compensator 

Scenario: Compensator uploads revised medical report with wait out prognosis
Given claim routed to compensator to upload medical reports      
When Compensator uploads revised medical report with wait out prognosis
Then report will be sent for claimant approval  

Scenario: Unrep Claimant accepts wait out prognosis and proceed to offer after prognosis ends
Given Medical report received by claimant with wait out prognosis
When Claimant accepts wait out prognosis and proceeds to offer after prognosis ends 
Then claim will be routed to compensator for first offer

Scenario: compensator receives the claim by claimant after WOP
Given Claim  is sent to the compensator
When the compensator makes first offer with fee proposal
Then offer is sent to claimant

Scenario: Unrep Claimant accepts offer
Given Claimant received offer details 
When Claimant accepts offer     
Then Acknowledgement for offer acceptance will be sent to compensator

Scenario: Compensator acknowledges offer
 Given Claim  is sent to the compensator
 When Compensator acknowledges claimants offer
 Then the claim can be Resolved
# Then claim SLA is breached
  
#Scenario: Claimant goes to court on Non payment for fees(OCS5)
 #Given Claimant claim liability has been rejected
 #When claimant wants to go to court on Non payment for fees
 #Then the claimant goes to court
#
 #	
 #Scenario: Compensator review and agrees to claimant court document
  #Given claimant selects court documents compensator
  #When Compensator agrees to court documents
  #Then claim will be sent for claimant acknowledgement 
 #
 #Scenario Outline: unrep Claimant checks the documents selected by compensator and submit the claim for court    
  #Given '<Claimant>' checks the documents uploaded by Compensator   
  #When '<Claimant>' submit the claim for court                          
  #Then  Case is closed with Go to court at offer stage  	
#		Examples:
 #	|Claimant|
 #	|unrep|  
#
