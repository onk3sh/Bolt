$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SampleTest.feature");
formatter.feature({
  "line": 1,
  "name": "Compare two sites created from Muse",
  "description": "",
  "id": "compare-two-sites-created-from-muse",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Open Muse site and scrub browser to check responsiveness for the complete site",
  "description": "",
  "id": "compare-two-sites-created-from-muse;open-muse-site-and-scrub-browser-to-check-responsiveness-for-the-complete-site",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "Compare sites from URL1 \u003d \"\u003cURL1\u003e\" and URL2 \u003d \"\u003cURL2\u003e\" using Java",
  "keyword": "Given "
});
formatter.examples({
  "line": 7,
  "name": "",
  "description": "",
  "id": "compare-two-sites-created-from-muse;open-muse-site-and-scrub-browser-to-check-responsiveness-for-the-complete-site;",
  "rows": [
    {
      "cells": [
        "URL1",
        "URL2"
      ],
      "line": 8,
      "id": "compare-two-sites-created-from-muse;open-muse-site-and-scrub-browser-to-check-responsiveness-for-the-complete-site;;1"
    },
    {
      "cells": [
        "file:///C:/Users/obansal/Documents/MuseExport/index.html",
        "file:///C:/Users/obansal/Documents/MuseExport/index.html"
      ],
      "line": 9,
      "id": "compare-two-sites-created-from-muse;open-muse-site-and-scrub-browser-to-check-responsiveness-for-the-complete-site;;2"
    },
    {
      "cells": [
        "http://test-nov62017-125.businesscatalyst.com/index.html",
        "http://test-nov62017-125.businesscatalyst.com/index.html"
      ],
      "line": 10,
      "id": "compare-two-sites-created-from-muse;open-muse-site-and-scrub-browser-to-check-responsiveness-for-the-complete-site;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 9,
  "name": "Open Muse site and scrub browser to check responsiveness for the complete site",
  "description": "",
  "id": "compare-two-sites-created-from-muse;open-muse-site-and-scrub-browser-to-check-responsiveness-for-the-complete-site;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "Compare sites from URL1 \u003d \"file:///C:/Users/obansal/Documents/MuseExport/index.html\" and URL2 \u003d \"file:///C:/Users/obansal/Documents/MuseExport/index.html\" using Java",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "file:///C:/Users/obansal/Documents/MuseExport/index.html",
      "offset": 27
    },
    {
      "val": "file:///C:/Users/obansal/Documents/MuseExport/index.html",
      "offset": 97
    }
  ],
  "location": "StepDefinitionMain.compare_two_url(String,String)"
});
formatter.result({
  "duration": 14398321093,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Open Muse site and scrub browser to check responsiveness for the complete site",
  "description": "",
  "id": "compare-two-sites-created-from-muse;open-muse-site-and-scrub-browser-to-check-responsiveness-for-the-complete-site;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "Compare sites from URL1 \u003d \"http://test-nov62017-125.businesscatalyst.com/index.html\" and URL2 \u003d \"http://test-nov62017-125.businesscatalyst.com/index.html\" using Java",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "http://test-nov62017-125.businesscatalyst.com/index.html",
      "offset": 27
    },
    {
      "val": "http://test-nov62017-125.businesscatalyst.com/index.html",
      "offset": 97
    }
  ],
  "location": "StepDefinitionMain.compare_two_url(String,String)"
});
formatter.result({
  "duration": 117891023391,
  "status": "passed"
});
});