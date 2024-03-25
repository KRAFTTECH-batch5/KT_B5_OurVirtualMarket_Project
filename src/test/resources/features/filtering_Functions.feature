
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


  Scenario: Filter products by text
    When The user searches any product on the search bar as "Cello"
    Then The user should navigate to a page containing "Cello"


  Scenario: Viewing Total Number of Items under the Manufacturer Tab
    Then The user expects to see the total number of items displayed without any filtering applied as default

  @Filtering
  Scenario: Filter products by price range
    When The user sets the price range from minPrice to maxPrice
    Then The user sees the results should only contain products within the specified price range

    burada deneme yapiyoruz olur oyle seyler arada deneriz biz