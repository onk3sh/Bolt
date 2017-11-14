#File contains test for one ids against specific css properties
@params
Feature: Validating values between two URLs on basis of params

	Scenario: Open Muse site and scrub in browser.

	Given List of WebElement ids to test
	|pamphletu97|
	Given List of Breakpoint values to test
	|960|
	Given List of CSS values to test
	|width|
	|height|
	#Then Compare sites from URL1 = "file:///C:/Users/obansal/Documents/MuseExport/index.html" and URL2 = "file:///C:/Users/obansal/Documents/MuseExport1/index.html" using Java for WebElementID = "u94"
	Then Compare URL1 = "http://muse-php.com/BoltTestData/set1/1/index.html" and URL2 = "http://muse-php.com/BoltTestData/set1/1/index.html"