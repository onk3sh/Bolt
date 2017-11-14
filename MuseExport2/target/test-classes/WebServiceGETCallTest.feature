#File contains test for one ids against specific css properties
@all @id @allCSS @json @get
Feature: Validating all ids and all CSS between two URLs using Webservice

	Scenario Outline: Open Muse site and scrub in browser. This test is for all IDs and all CSS.

	Given Compare sites from URL1 = "<URL1>" and URL2 = "<URL2>" using WebService

	Examples:
	|URL1|URL2|
	|http://muse-php.com/BoltTestData/set1/1/index.html|http://muse-php.com/BoltTestData/set1/2/index.html|