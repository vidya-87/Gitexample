Feature: Prouser claim creation

Scenario Outline: Prouser Submit a Claim as passenger in bus
	Given prouser logins into whiplash application
	When prouser enter all mandatory details for claim creation as '<involvement_type_v>'
	Then claim is created for prouser
	 
	Examples:
	 | involvement_type_v|								
	 |	A passenger on a bus|