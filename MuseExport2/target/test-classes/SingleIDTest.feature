#File contains test for one ids against specific css properties
@single @id
Feature: Validating single id between two URLs

	Scenario: Open Muse site and scrub in browser. This test is id specific validation.

	#Compare sites from URL1 = \"([^\"]*)\" and URL2 = \"([^\"]*)\" using Java for WebElementID =\"([^\"]*)\" .$")
	#Given Compare sites from URL1 = "file:///C:/Users/obansal/Documents/MuseExport/index.html" and URL2 = "file:///C:/Users/obansal/Documents/MuseExport1/index.html" using Java for WebElementID = "u94"
	Given Compare sites from URL1 = "http://muse-php.com/BoltTestData/set1/1/index.html" and URL2 = "http://muse-php.com/BoltTestData/set1/2/index.html" using Java for WebElementID = "pamphletu97"
