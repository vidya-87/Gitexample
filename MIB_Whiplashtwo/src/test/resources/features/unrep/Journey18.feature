@unrep
Feature: Journey 18

Scenario Outline: Unrep claim creation as car owner
	Given unrep logins into whiplash application
	When user enter all mandatory details for claim creation as '<owner>' , '<involvement_type_v>' and '<ct_preference>' with '<multivrn>','<location>'
	Then claim reference number for unrep claim is created
	Examples:
	 | owner| involvement_type_v| ct_preference| multivrn |	location|						
	 | NO|	I was the driver	| BOTH			|NO|Inside UK|
	
	Scenario: Compensator  Accept Claim and full Liability
  Given Claim  is sent to the compensator
  When compensator accepts claim and makes full liability without dispute
  Then the claims acceptance and liability is now sent to the claimant

  Scenario: Unrep Provides Medical Preferences 
	Given the unrep claim moves to full liability
	When unrep selects medical preferences for an DME 
	Then medical preferences are sent to Independent Expert

  Scenario: DME uploads report-with Wait out prognosis more than twenty four months 
  Given claimant selects DME 
  When DME upload medical report with prognois time
  Then Report is sent to claimant
  
  Scenario Outline: Claimant decides to withdraw claim based on threshold message indicating claim can be withdrawn if needed.
  Given claimant reviews medical report when uploaded by DME
  When the unrep claimant then decides to withdraw the claim at '<status>'
  Then the claimant has withdrawn claim and Compensator to acknowledge this
  Examples:
  |status|
  |Pending-CheckMedical|
  
  Scenario: Compensator acknowledges the withdrawl and claim resolved
  Given Claim  is sent to the compensator
  When Compensator acknowledges claimants withdrawal
  Then the claim can be Resolved