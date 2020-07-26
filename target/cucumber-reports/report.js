$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/wikipedia_features/b.feature");
formatter.feature({
  "name": "",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "a",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@t"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "a\u003ca\u003e",
  "rows": [
    {
      "cells": [
        "data2"
      ]
    },
    {
      "cells": [
        "row2"
      ]
    },
    {
      "cells": [
        "data3"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "StudentsListAPI_stepDefs.a_a(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "djjddjj",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentsListAPI_stepDefs.djjddjj()"
});
formatter.result({
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat step_definitions.cybertekTraining_stepDefs.StudentsListAPI_stepDefs.djjddjj(StudentsListAPI_stepDefs.java:168)\n\tat ✽.djjddjj(src/test/resources/features/wikipedia_features/b.feature:30)\n",
  "status": "pending"
});
formatter.after({
  "status": "passed"
});
});