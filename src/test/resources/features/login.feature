@login
Feature: Login Functionality

  # As a user, I should be able to log in with valid credentials.

  @loginpositive
  Scenario: Positive Login Scenario
    Given The user is on the home page
    And The user closes the pop-up
    Then The user should see the login button at the top right corner
    When The user clicks on the login button on the home page
    Then The user should see the "SIGN IN OR REGISTER" pop-up
    And The user should see the email address bar
    And The user should see the password bar
    And The user should see the "Login with your social account" bar with options such as google, Facebook, Twitter, LinkedIn
    And The user should see the Login button
    And The user should see the "CREATE AN ACCOUNT" button
    And The user should see the exit button at the top right corner
    When The user provides valid credentials
    Then The user should be able to log in

  @loginnegative
  Scenario: Negative Login Scenario
    Given The user is on the home page
    And The user closes the pop-up
    Then The user should see the login button at the top right corner
    When The user clicks on the login button on the home page
    Then The user should see the "Sign in Or Register" pop-up
    And The user should see the email address bar
    And The user should see the password bar
    And The user should see the "Login with your social account" bar with options such as google, Facebook, Twitter, LinkedIn
    And The user should see the Login button
    And The user should see the "Create an account" button
    And The user should see the exit button at the top right corner
    When The user provides invalid credentials
    Then The user should not be able to log in
    And The user should see the "Warning: No match for E-mail Address and/or Password" message
    And The user should see the New Customer table
    And The user should see the Returning Customer table


