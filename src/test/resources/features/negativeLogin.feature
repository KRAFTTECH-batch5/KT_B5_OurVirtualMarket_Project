@loginNegative
Feature: Negative Login Functionality

  # As a user, I should not be able to login with invalid credentials

  Background:
    * The user is on the home page
    * The user closes the pop-up
    * The user clicks on the login button on the home page

  @loginNegativeBlank1
  Scenario Outline: Negative Login and Blank Credentials Scenario
    When The user provides invalid credentials that "<email>" and "<password>"
    Then The user should not be able to log in
    And The user should see the "Warning: No match for E-Mail Address and/or Password." message
    And The user should see the New Customer table
    And The user should see the Returning Customer table
    Examples:
      | email | password |
      |       |          |

  @loginNegativeBlank2
  Scenario Outline: Negative Login and Blank Credentials Scenario
    When The user provides invalid credentials that "<email>" and "<password>"
    Then The user should not be able to log in
    And The user should see the "Warning: No match for E-Mail Address and/or Password." message
    And The user should see the New Customer table
    And The user should see the Returning Customer table
    Examples:
      | email | password      |
      |       | ahmedserhendi |

  @loginNegativeBlank3
  Scenario Outline: Negative Login and Blank Credentials Scenario
    When The user provides invalid credentials that "<email>" and "<password>"
    Then The user should not be able to log in
    And The user should see the "Warning: No match for E-Mail Address and/or Password." message
    And The user should see the New Customer table
    And The user should see the Returning Customer table
    Examples:
      | email                   | password |
      | ahmedserhendi@gmail.com |          |

  @loginNegative1
  Scenario Outline: Negative Login and Blank Credentials Scenario
    When The user provides invalid credentials that "<email>" and "<password>"
    Then The user should not be able to log in
    And The user should see the "Warning: No match for E-Mail Address and/or Password." message
    And The user should see the New Customer table
    And The user should see the Returning Customer table
    Examples:
      | email               | password |
      | invalid@gmail.com | invalid  |

  @loginNegative2
  Scenario Outline: Negative Login and Blank Credentials Scenario
    When The user provides invalid credentials that "<email>" and "<password>"
    Then The user should not be able to log in
    And The user should see the "Warning: No match for E-Mail Address and/or Password." message
    And The user should see the New Customer table
    And The user should see the Returning Customer table
    Examples:
      | email                   | password |
      | ahmedserhendi@gmail.com | invalid  |

  @loginNegative3
  Scenario Outline: Negative Login and Blank Credentials Scenario
    When The user provides invalid credentials that "<email>" and "<password>"
    Then The user should not be able to log in
    And The user should see the "Warning: No match for E-Mail Address and/or Password." message
    And The user should see the New Customer table
    And The user should see the Returning Customer table
    Examples:
      | email               | password      |
      | invalid@gmail.com | ahmedserhendi |