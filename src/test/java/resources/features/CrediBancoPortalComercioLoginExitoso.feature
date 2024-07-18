Feature: Login to Commerce Portal
  As a registered user
  I want to log in to the commerce portal
  So that I can access my account

 Scenario:Successful login with valid credentials
   Given the user is on the login page
    When the user enters username and password
    And the user submits the login form
    Then the user should see the dashboard page
