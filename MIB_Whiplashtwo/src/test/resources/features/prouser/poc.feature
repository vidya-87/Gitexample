@prouser
Feature: poc

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>' and '<owner>' and '<multivrn>'
	Then prouser exits before submitting claim
	Examples:
	 |involvement_type_v|	owner|multivrn|
	 |A passenger in a car/van/lorry|NO|NO|