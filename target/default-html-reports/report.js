$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Contacts.feature");
formatter.feature({
  "name": "Contacts page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Contacts test with email",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@wip"
    },
    {
      "name": "@db"
    }
  ]
});
formatter.step({
  "name": "the user logged in as \"store manager\"",
  "keyword": "Given "
});
formatter.step({
  "name": "the user navigates \"Customers\" \"Contacts\"",
  "keyword": "And "
});
formatter.step({
  "name": "the user clicks the \"\u003cemail\u003e\" from contacts",
  "keyword": "When "
});
formatter.step({
  "name": "the information \"\u003cemail\u003e\" should be same with database",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email"
      ]
    },
    {
      "cells": [
        "mbrackstone9@example.com"
      ]
    },
    {
      "cells": [
        "mike.jorden@hotmail.com"
      ]
    },
    {
      "cells": [
        "dragana.ivanovic@gmail.com"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Contacts test with email",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@wip"
    },
    {
      "name": "@db"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user logged in as \"store manager\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepsDef.the_user_logged_in_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates \"Customers\" \"Contacts\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.vytrack.step_definitions.NavigationMenuStepDefs.the_user_navigates(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks the \"mbrackstone9@example.com\" from contacts",
  "keyword": "When "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepsDef.the_user_clicks_the_from_contacts(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the information \"mbrackstone9@example.com\" should be same with database",
  "keyword": "Then "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepsDef.the_information_should_be_same_with_database(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Contacts test with email",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@wip"
    },
    {
      "name": "@db"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user logged in as \"store manager\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepsDef.the_user_logged_in_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates \"Customers\" \"Contacts\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.vytrack.step_definitions.NavigationMenuStepDefs.the_user_navigates(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks the \"mike.jorden@hotmail.com\" from contacts",
  "keyword": "When "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepsDef.the_user_clicks_the_from_contacts(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the information \"mike.jorden@hotmail.com\" should be same with database",
  "keyword": "Then "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepsDef.the_information_should_be_same_with_database(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Contacts test with email",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@wip"
    },
    {
      "name": "@db"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user logged in as \"store manager\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepsDef.the_user_logged_in_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates \"Customers\" \"Contacts\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.vytrack.step_definitions.NavigationMenuStepDefs.the_user_navigates(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks the \"dragana.ivanovic@gmail.com\" from contacts",
  "keyword": "When "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepsDef.the_user_clicks_the_from_contacts(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the information \"dragana.ivanovic@gmail.com\" should be same with database",
  "keyword": "Then "
});
formatter.match({
  "location": "com.vytrack.step_definitions.ContactsStepsDef.the_information_should_be_same_with_database(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});