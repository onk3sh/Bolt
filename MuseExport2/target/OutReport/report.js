$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("WebServicePOSTCallTest.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#File contains test for one ids against specific css properties"
    }
  ],
  "line": 3,
  "name": "Validating values between two URLs on basis of params",
  "description": "",
  "id": "validating-values-between-two-urls-on-basis-of-params",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@json"
    },
    {
      "line": 2,
      "name": "@post"
    }
  ]
});
formatter.before({
  "duration": 2373287,
  "status": "passed"
});
formatter.before({
  "duration": 98689,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Open Muse site and scrub in browser.",
  "description": "",
  "id": "validating-values-between-two-urls-on-basis-of-params;open-muse-site-and-scrub-in-browser.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "List of WebElement ids for JSON Object",
  "rows": [
    {
      "cells": [
        "pamphletu97"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "List of Breakpoint values for JSON Object",
  "rows": [
    {
      "cells": [
        "960"
      ],
      "line": 10
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "List of CSS values for JSON Object",
  "rows": [
    {
      "cells": [
        "width"
      ],
      "line": 12
    },
    {
      "cells": [
        "height"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 14,
      "value": "#Then Compare sites from URL1 \u003d \"file:///C:/Users/obansal/Documents/MuseExport/index.html\" and URL2 \u003d \"file:///C:/Users/obansal/Documents/MuseExport1/index.html\" using Java for WebElementID \u003d \"u94\""
    }
  ],
  "line": 15,
  "name": "Compare URL1 \u003d \"http://muse-php.com/BoltTestData/set1/1/index.html\" and URL2 \u003d \"http://muse-php.com/BoltTestData/set1/1/index.html\" via POST",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitionJSON.get_id_list(String\u003e)"
});
formatter.result({
  "duration": 213895495,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionJSON.get_BP_list(String\u003e)"
});
formatter.result({
  "duration": 102637,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitionJSON.get_css_list(String\u003e)"
});
formatter.result({
  "duration": 88426,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://muse-php.com/BoltTestData/set1/1/index.html",
      "offset": 16
    },
    {
      "val": "http://muse-php.com/BoltTestData/set1/1/index.html",
      "offset": 80
    }
  ],
  "location": "StepDefinitionJSON.compare_two_urls_idList_BpList_cssList(String,String)"
});
formatter.result({
  "duration": 1404156,
  "status": "passed"
});
formatter.after({
  "duration": 26054,
  "status": "passed"
});
});