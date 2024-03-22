@wip1
Feature: Currency Conversion As a user, I should be able to choose different currency payment options such as dollars, euros, or pounds to purchase items.


  Background:
    * the user is logged in with valid credentials

  Scenario: Verify Dollars as a default currency type
    When Default currency must be Dollar

  Scenario: Change currency to Euro
    When the user clicks on the currency button
    And selects Euro
    Then all prices should be displayed in Euro


  Scenario: Change currency to Pound Sterling
    When the user clicks on the currency button
    And selects Pound Sterling
    Then all prices should be displayed in Pound Sterling