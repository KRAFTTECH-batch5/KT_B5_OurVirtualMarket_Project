Feature: Searching for products with filtering functionality

  Background:
    * The user is on the home page
    * The user closes the pop-up
    * The user clicks on the login button on the home page
    * The user provides valid credentials
    * The user lands on the main product options
    * The user clicks on any 'Television'


  @dincer
  Scenario: Show and hide filtering options
    When I click the first down arrow
    Then the search functionality should be hidden or shown
    When I click the second down arrow
    Then the number of products should be hidden or shown
    When I click the third down arrow
    Then the price range tabs should be hidden or shown