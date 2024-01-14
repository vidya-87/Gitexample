Feature: Journey 1

Scenario Outline: User Enters details in your details page
		Given unrep logins into whiplash application
		When user enter all mandatory details for claim creation as '<involvement_type_v>' and '<ct_preference>'
		Then claim reference number for unrep claim is created
		Examples:
		 | username			  				| involvement_type_v | ct_preference|								
		 | vandana@cognizant.com	|	I was a passenger on a bus | EMAIL|

	 
	 ####Involvement type
	 ####I was the driver
	 ####I was a passenger in a Car/Lorry/Van
	 ####I was a passenger in a bus
	