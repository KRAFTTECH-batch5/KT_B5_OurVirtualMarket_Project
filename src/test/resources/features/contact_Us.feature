@ContactUs
Feature: Sending a complaint message via "Contact Us" Page

  Background:
    * The user is on the home page
    * The user closes the pop-up
    * The user clicks on the login button on the home page
    * The user logins with valid credentials :
      | email    | rgosling@gmail.com |
      | password | test123#           |
    * The user clicks on the home button
    * The user lands on the bottom of the site
    * The user clicks on the Contact Us Button
    * The user's name and email should be pre-filled

  Scenario: Sending a complaint message successfully
    When The user submits a complaint message with valid length
    Then The user should see a success message confirming the message has been sent

  Scenario: Sending a complaint message containing fewer than 10 characters
    When The user sends a complaint message containing fewer than ten characters
    Then The user sees fail message

  Scenario: Sending a complaint message containing more than 3000 characters
    When The user sends a complaint message containing more than three thousand characters
    Then The user sees fail message