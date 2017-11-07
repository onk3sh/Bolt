Feature: Compare two sites created from Muse
  
Scenario Outline: Open Muse site and scrub browser to check responsiveness for the complete site

	Given Compare sites from URL1 = "<URL1>" and URL2 = "<URL2>" using Java

Examples:
|URL1													 |URL2													    |
|file:///C:/Users/obansal/Documents/MuseExport/index.html|file:///C:/Users/obansal/Documents/MuseExport/index.html |
|http://test-nov62017-125.businesscatalyst.com/index.html|http://test-nov62017-125.businesscatalyst.com/index.html  |