Feature: Wish List Functionality

  Background:
    * The user is on the home page
    * The user is logged in with valid credentials

  @TK01
  Scenario: Adding Product to Wish List
    When The user hovers the mouse over an item of interest, small buttons appear next to the item and clicks on the wishlist button.
    Then The user sees a success message at the top of the page confirming that the item has been added to the wishlist and clicks on the Heart Icon in the upper right corner of the page.
    And The user is redirected to the My Wishlist page and sees the products that have already been added to the wish list.
#  @TK02
#  Scenario: Accessing Wish List