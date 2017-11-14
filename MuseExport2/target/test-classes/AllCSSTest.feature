#File contains test for one ids against specific css properties
@all @id @allCSS
Feature: Validating all ids and all CSS between two URLs

	Scenario: Open Muse site and scrub in browser. This test is for all IDs and all CSS.

	#Compare sites from URL1 = \"([^\"]*)\" and URL2 = \"([^\"]*)\" using Java for WebElementID =\"([^\"]*)\" .$")
	#Given Compare sites from URL1 = "file:///C:/Users/obansal/Documents/MuseExport/index.html" and URL2 = "file:///C:/Users/obansal/Documents/MuseExport1/index.html" using Java, ALL IDs ALL CSS
	Given Compare sites from URL1 = "http://muse-php.com/BoltTestData/set1/1/index.html" and URL2 = "http://muse-php.com/BoltTestData/set1/2/index.html" using Java, ALL IDs ALL CSS
