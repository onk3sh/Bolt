Feature: Compare two sites created from Muse

@Ignore
Scenario Outline: Open Muse site and scrub browser to check responsiveness for the complete site

	Given Compare sites from URL1 = "<URL1>" and URL2 = "<URL2>" using Java

Examples:
|URL1|URL2|
|file:///C:/Users/obansal/Documents/MuseExport/index.html|file:///C:/Users/obansal/Documents/MuseExport/index.html  |

@SingleID
Scenario: Open Muse site and scrub in browser. This test is id specific validation.

	Given Compare sites from URL1 = "file:///C:/Users/obansal/Documents/MuseExport/index.html" and URL2 = "file:///C:/Users/obansal/Documents/MuseExport1/index.html" using Java for WebElementID = "u94"
	
