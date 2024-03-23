Feature: Searching for products with filtering functionality

  Background:
    * The user is on the home page
    * The user closes the pop-up
    * The user clicks on the login button on the home page
    * The user provides valid credentials
    * The user lands on the main product options
    * The user clicks on any 'Television'


  Scenario: Show and hide filtering options
    When I click the first down arrow
    Then the search functionality should be hidden or shown
    When I click the second down arrow
    Then the number of products should be hidden or shown
    When I click the third down arrow
    Then the price range tabs should be hidden or shown

  @Filtering
  Scenario: Filter products by text
    When The user searches any product on the search bar as "TV"
#    Then The user should be redirected to the search page related to "TV".
    Then The user should be redirected to a page containing "TV"
