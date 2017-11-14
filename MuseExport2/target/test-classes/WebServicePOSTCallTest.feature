#File contains test for one ids against specific css properties
@json @post
Feature: Validating values between two URLs on basis of params

	Scenario: Open Muse site and scrub in browser.

	Given List of WebElement ids for JSON Object
	|pamphletu97|
	And List of Breakpoint values for JSON Object
	|960|
	And List of CSS values for JSON Object
	|width|
	|height|
	Then Compare URL1 = "http://muse-php.com/BoltTestData/set1/1/index.html" and URL2 = "http://muse-php.com/BoltTestData/set1/1/index.html" via POST