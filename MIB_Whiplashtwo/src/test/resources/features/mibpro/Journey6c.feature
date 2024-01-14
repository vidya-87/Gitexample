@mibpro
Feature: Journey 6c

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	 | owner| involvement_type_v| multivrn |location|							
	 | NO|	The driver| NO	|Inside UK|
	 
	 
Scenario: Compensator dispute causation along with part liability
	Given Claim  is sent to the compensator
	When compensator accepts claim and makes part liability with dispute
	Then the claims acceptance and liability is now sent to the claimant


Scenario Outline: MIBpro Provides Medical Preferences
	Given MIBpro claim moves to partial liability
	When MIBpro makes medical provider selection '<status>'
	And MIBpro claimant update the losses from Loss Tile and upload documents
	Then medical preferences are sent to Independent Expert
Examples:
|status|
|Pending-MedPartCausation|

Scenario: DME uploads report-No prognosis
	Given claimant selects DME 
	When claimant visits DME and completes checkup
	Then DME uploads report no prognosis

Scenario: Claimant selects option 'No' for the question "Do you believe the facts in the medical report are complete and correct?" and request for further medical
	Given medical report is sent to MIBpro for review
	When MIBpro requests for second report
	Then Claimant need to visit DME for medical examination again

Scenario: DME rejects the requests and finalise the report
	Given Claimant requests further medical report after marking factually incorrect 
	When DME reject further report
	Then Report is sent to claimant
	
Scenario: DME has challenged the medical report
	Given DME has rejected the MIBpro report request
	Then MIBpro checks the claim status
