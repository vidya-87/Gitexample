Feature: MIBprouserClaimCreation

Scenario Outline: MIBProuser claim creation
    Given MIBpro logins into whiplash application
    When MIBpro enter all mandatory details for claim creation as '<involvement_type_v>' with '<multivrn>'
    Then claim is created for MIBpro
    
    Examples:
     | 				involvement_type_v| multivrn 	|                               
     | 								The driver| 	NO    	|