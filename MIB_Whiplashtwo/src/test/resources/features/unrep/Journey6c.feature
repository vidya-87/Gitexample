@unrep
Feature: Journey 6c

Scenario Outline: Unrep claim creation with Multi VRN
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |location|							
	 | NO|	I was the driver	| BOTH		| NO	|Inside UK|
	 
	 
Scenario: Compensator dispute causation along with part liability
	Given Claim  is sent to the compensator
	When compensator accepts claim and makes part liability with dispute
	Then the claims acceptance and liability is now sent to the claimant


Scenario Outline: Unrep Provides Medical Preferences
	Given the unrep claim moves to partial liability
	When Claimant makes medical provider selection '<status>'
	And Claimant Adds losses from losses tile
	And Claimant uploads document from Doc tile
	Then medical preferences are sent to Independent Expert
Examples:
|status|
|Pending-MedPartCausation|

Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: Claimant selects option 'No' for the question "Do you believe the facts in the medical report are complete and correct?" and request for further medical
	Given medical report is sent to claimant for review
	When Claimant requests for second report
	Then Claimant need to visit DME for medical examination again

Scenario: DME rejects the requests and finalise the report
	Given Claimant requests further medical report after marking factually incorrect 
	When DME reject further report
	Then Report is sent to claimant
	
Scenario: DME has challenged the medical report
	Given DME has rejected the report request
	Then the claimant checks the claim status
