Feature: Compensator User creation

Scenario Outline: Register Compensator Users

	Given '<user>' logins to register
	When compensators enter all the required details for registration
	Then approval for registration is sent to the CSR

Examples:
|user|
|compensator|

Scenario Outline: Registeration Allocation and MID ID	

  Given the registeration is approved by the '<CSR>'
  When the '<MID-ID>' number is assigned to the compensator
  Then compensator registration is done successfully
  
 Examples:
 |MID-ID|CSR| 
 |PNYAD|CSR|

Scenario Outline: Successfull registration	
 	Given '<user>' was registered successfully
	 When the compensator logins 
 	Then compensator should be able to sign agreement
 	
Examples:
|user|
|compensator|


