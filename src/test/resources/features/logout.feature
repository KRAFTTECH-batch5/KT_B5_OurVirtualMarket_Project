Feature: Logout Functionality

    # As a user, I should be able to log out smoothly.

  Background:
    * The user is on the home page
    * The user closes the pop-up
    * The user clicks on the login button on the home page
    * The user provides valid credentials

  @Logout
  Scenario: The user should be able to logout
    Then The user verifies that logout button is displayed
    When The user clicks to Logout button
    Then The user verifies Logout page with following messages
      | Account Logout                                                                                                   |
      | You have been logged off your account. It is now safe to leave the computer.                                     |
      | Your shopping cart has been saved, the items inside it will be restored whenever you log back into your account. |
      | CONTINUE                                                                                                         |
    When The user clicks on page-back button
    Then The user verifies that can not back to his personal page

