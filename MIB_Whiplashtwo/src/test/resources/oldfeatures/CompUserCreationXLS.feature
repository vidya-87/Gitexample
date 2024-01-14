##For large data
Feature: Compensator User creation

Scenario Outline: Register Compensator Users


Given compensator from '<orgname>' logins to register with '<emailid>' and '<password>'
	When resgiteration is approved by CSR and valid '<mid>' is assigned to the compensator
	Then compensator is resgistered successfully with '<emailid>' and '<password>'

Examples:
|emailid|password|orgname|mid|