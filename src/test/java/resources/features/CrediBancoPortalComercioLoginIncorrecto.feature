Feature: Login failed to Commerce Portal


  Scenario: login failed with valid credentials
    Given the user is on the login page
    When user enters incorrect credentials
    Then the user validates the incorrect login message
