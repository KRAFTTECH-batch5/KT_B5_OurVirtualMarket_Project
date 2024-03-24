Feature: Wish List Functionality

  Background:
    * The user is on the home page
    * The user is logged in with valid credentials

  @TK01
  Scenario: Adding Product to Wish List
    When The user hovers the mouse over an item of interest,small buttons appear next to the item.
    Then The user clicks on the Add to my wishlist button among the small buttons.
    And  The user sees a success message at the top of the page confirming that the item has been added to the wishlist.

  @TK02
  Scenario: Accessing Wish List
    When The user clicks on the Heart Icon in the upper right corner of the page
    Then The user is redirected to the My Wishlist page.
    And The user sees the products that have already been added to the wish list.