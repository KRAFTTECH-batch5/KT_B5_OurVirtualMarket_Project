@searchFunc
Feature: Search Functionality

  Background:
    * User is on the home page
    * User closes the subscribe popup

  @TC01
  Scenario: The user verifying the presence of a search bar on the homepage
    Then The user should be able to see if there is a search bar and search button on the top middle of the page.


  @TC02
  Scenario: The user verifying the Default Text on the search bar
    Then The user should be able to see the search bar contains the text 'Search' by default.

  @TC03
  Scenario: The user should Searching for a Valid Order
    When The user should enter a valid keyword 'cable' in the search bar and click on the search button.
    Then The user should be directed to the search page related to 'cable'.

  @TC04
  Scenario: The user should Searching for a invalid Order
    When The user should enter a invalid keyword 'phone' in the search bar and click on the search button.
    Then The user should see 'There is no product that matches the search criteria.' message
