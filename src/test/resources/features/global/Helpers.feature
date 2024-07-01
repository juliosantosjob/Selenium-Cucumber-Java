#language:en

Feature: Support Steps
  - This feature aims to provide support for all scenarios that require being logged in to achieve their objective

  Background:
    Given the user accesses the site
    And accesses the login page

  Scenario: Login support
    And log in with email "" and password ""
    And log out
