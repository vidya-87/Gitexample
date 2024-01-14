====WHIPLASH REGRESSION AUTOMATION=====


===Softwares needed
Install latest versions of the below softwares

-	Selenium 3.0
-	Latest Eclipse IDE
-	Java 8
-	TESTNG
-	Cucumber
-	Maven
-	Chromedriver


===How to run
Step 1:Mention the Journey number in "RunCucumberTests_WhiplashRegression.java" file under com.cucumbercraft.runners folder
Step 2:Run "TestNGRunRegressionTests.xml" as TESTNG suite

===Locators database
*Only use XPATH as locators
*LocatorDatabase.xls is placed under "resources" folder

===FolderStructure
MIBworkspace/MIB_Whiplash(framework folder)

==com.cumcumberbercraft.framework
GetDriver.java - Data setup details are present
WebDriverUtil.java - Contains webdriver utility functions

===Documents to upload
MedicalReport, REVISEDMEDICAL,NewMedicalReport and Document for uploading in application are placed under "resources" folder

==UserLogins
*All user logins for different testing environment are placed under "resources" folder
*VRN for Staging environment is mentioned in the "Unrep" sheet in LocatorDatabase.xls
*VRN for PPM1 and PPM2 are mentioned in UserLogins.xls
Note: CSR, DME users are not available for PPM1 environment

==Switching environments
*Verify URL in "Global Settings.properties" under "resources" folder
*Update the MIBLoginPage,ClaimsActionsPage(check for UNREP claim reference)
*Update the corresponding environment password for SuperUser in "SuperUser" sheet in LocatorDatabase.xls




