@regression
Feature: E-mail Subscription Test

  Background:
    * The user is on the home page
    * The user closes the pop-up without checkbox
    * The user should see the login button at the top right corner
    * The user clicks on the login button on the home page
    * The user should see the "SIGN IN OR REGISTER" pop-up
    * The user should see the email address bar
    * The user should see the password bar
    * The user should see the "Login with your social account" bar with options such as google, Facebook, Twitter, LinkedIn
    * The user should see the Login button
    * The user should see the "CREATE AN ACCOUNT" button
    * The user should see the exit button at the top right corner
    * The user enters the e-mail and password information and clicks the LOGIN button
    * The user should be able to log in

  @getNewsLetterSc1
  Scenario: Cancel Subscription Popup | Positive Test
    When The user clicks to HOME button
    Then The user should verify a pop-up message offering to subscribe to the mailing list
    When The user clicks on the X close button on the pop-up
    Then The user should verify that the pop-up window disappears
    Then The user should be able to continue subscribing using the banner at the bottom

  @getNewsLetterSc2
  Scenario: Valid Subscription | Positive Test
    When The user clicks to HOME button
    Then The user should verify a pop-up message offering to subscribe to the mailing list
    When The user enters a valid email address in the subscription form and clicks Subscribe button
    Then The user verifies that message Subscription was successful is displayed
    Then The user should verify that the pop-up window disappears

  @getNewsLetterSc3
  Scenario: Empty Email Subscription | Negative Test
    When The user scrolls down the page to the bottom
    Then The user verifies a subscription option is present
    When The user enters the email address "cumlirefyo@gufum.com" previously subscribed and clicks subscribe
    Then The user verifies that a message saying Email has already exist is displayed



