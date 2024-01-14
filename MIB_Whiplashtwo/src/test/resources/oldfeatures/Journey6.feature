@unrep
Feature: Journey 6

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner | involvement_type_v| ct_preference| multivrn |location|							
	 | NO	|	I was a passenger on a bus| BOTH | NO	|Inside UK|
	 
Scenario: Compensator  Accept Claim and full Liability
	 Given Claim  is sent to the compensator
	 When compensator accepts claim and makes full liability without dispute
	Then the claims acceptance and liability is now sent to the claimant
	
Scenario: Unrep Provides Medical Preferences 
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME 
	Then medical preferences are sent to Independent Expert

#Scenario: CSR route claim to compensator to upload report
#	Given Claim received by csr and eligible for assigning to compensator
#	When CSR assigns compensator to upload medical report
#	Then Claim is sent to respective compensator


#Scenario: Compensator uploads medical report without wait out prognosis
#	Given claim routed to compensator to upload medical reports      
#	When Compensator uploads medical report without wait out prognosis
#	Then report will be sent for claimant approval 	
Scenario: DME  uploads medical Report with no prognosis
	Given claimant selects DME 
	When DME uploads the medical report with waitout period before prognosis
	Then Report is sent to claimant

Scenario: Claimant accepts wait out prognosis
	Given Medical report received by claimant with wait out prognosis
	When claimant proceeds with offer
	Then claimant need to wait until waitout prognosis period ends

Scenario: compensator receives the claim with Losses added by claimant after WOP
	Given Claim  is sent to the compensator
	When the compensator makes first offer
	Then offer is sent to claimant


Scenario: Compensator removes the claim from portal
  Given compensator makes first offer to claimant
  When the compensator removes the claim from portal
  Then the claim is removed from portal and closed

 Scenario: The removed claim should be sent to resolved claim
 	Given the compensator has removed the claim
 	When claim is moved to resolved
 	Then claim is successfully removed