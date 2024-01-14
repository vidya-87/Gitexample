@mibpro
Feature: Journey 18

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>' and '<owner>' and '<locations>'
    Then claim is created for MIBpro
	Examples:
	 | owner| involvement_type_v| multivrn |	location|						
	 | NO	|	The driver		|NO		|Inside UK|
	
	Scenario: Compensator  Accept Claim and full Liability
  Given Claim  is sent to the compensator
  When compensator accepts claim and makes full liability without dispute
  Then the claims acceptance and liability is now sent to the claimant

  
Scenario: MIBpro Provides Medical Preferences 
	Given compensator accepts mibprouser claim liability
	When mibprouser selects medical preferences for an DME 
	Then  mibprouser medical preferences are sent to Independent Expert

 Scenario: DME uploads report-with Wait out prognosis more than twenty four months 
  	Given claimant selects DME 
  	When DME upload medical report with prognois time
  	Then Report is sent to claimant
  
 Scenario Outline: Claimant decides to withdraw claim based on threshold message indicating claim can be withdrawn if needed.
  	Given medical report is sent to mibprouser claimant for review
  	When the MIB prouser claimant then decides to withdraw the claim at '<status>'
  	Then the claimant has withdrawn claim and Compensator to acknowledge this
  Examples:
  |status|
  |Pending-CheckMedical|
  
  Scenario: Compensator acknowledges the withdrawl and claim resolved
  Given Claim  is sent to the compensator
  When Compensator acknowledges claimants withdrawal
  Then the claim can be Resolved
  