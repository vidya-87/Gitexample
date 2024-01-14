Feature: Compensator User creation

Scenario Outline: Register prouser Users

	
	Given prouser from logins to register with '<emailid>' and '<password>'
	When resgitration is approved by CSR
	Then prouser is resgistered successfully with '<emailid>' and '<password>'

Examples:
|emailid|password|
|pro_user@pryers.co.uk|Training!343|
|pro_user@claimsandhire.co.uk|Training!344|
|pro_user@rangesolicitors.co.uk|Training!345|
|pro_user@llbsolicitors.co.uk|Training!346|
|pro_user@expertclaims.co.uk|Training!347|
|pro_user@sjlaw.co.uk|Training!348|
|pro_user@kaizenlaw.co.uk|Training!349|
|pro_user@halsalls.com|Training!350|
|pro_user@battens.co.uk|Training!351|
|pro_user@rileyhayessolicitors.co.uk|Training!352|
|pro_user@parkviewsolicitors.co.uk|Training!353|
|pro_user@synergysolicitors.com|Training!354|
|pro_user@gbtpa.com|Training!355|
|pro_user@Chattertons.com|Training!356|
|pro_user@maliklegal.co.uk|Training!357|
|pro_user@coynelearmonth.co.uk|Training!358|
|pro_user@ppsolicitors.com|Training!359|
|pro_user@maidstonelaw.co.uk|Training!360|
|pro_user@askews.com|Training!361|
|pro_user@advantagesolicitors.com|Training!362|
|pro_user@wardhadaway.com|Training!363|
|pro_user@edwardhughes.biz|Training!364|
|pro_user@sbgl.co.uk|Training!365|
|pro_user@kblawsolicitors.com|Training!366|
|pro_user@smartaccidentclaims.com|Training!367|
|pro_user@fosters-solicitors.co.uk|Training!368|
|pro_user@keoghs.co.uk|Training!369|
|pro_user@pisupport.co.uk|Training!370|
|pro_user@ktpsolicitors.net|Training!371|
|pro_user@trentbarton.co.uk|Training!372|
|pro_user@coplus.co.uk|Training!373|
|pro_user@regentlaw.co.uk|Training!374|
|pro_user@devonalds.co.uk|Training!375|
|pro_user@pursuitclaims.com|Training!376|
|pro_user@mckayssolicitors.com|Training!377|
|pro_user@quantumlegal.co.uk|Training!378|
|pro_user@first4lawyers.com|Training!379|
|pro_user@farnworthrose.co.uk|Training!380|
|pro_user@brown-barron.co.uk|Training!381|
|pro_user@SpencersSolicitors.com|Training!382|
|pro_user@dwharris.co.uk|Training!383|
|pro_user@mymsolicitors.co.uk|Training!384|
|pro_user@vanameyde.com|Training!385|
|pro_user@barcankirby.co.uk|Training!386|
|pro_user@inaayasolicitors.com|Training!387|
|pro_user@awhsolicitors.co.uk|Training!388|
|pro_user@lambbrooks.com|Training!389|
|pro_user@heptonstalls.co.uk|Training!390|
