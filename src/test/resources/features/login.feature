Feature: Login Functionality

  # As a user, I should be able to log in with valid credentials.

  @loginPositive
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