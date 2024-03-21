Feature: Alternative Search Button Functionality

  Background:
    * The user is on the home page
    * The user closes the pop-up

  Scenario: Visibility of the Alternative Search Button
    When The user observes the alternative search button on the page
    Then The alternative search button is visible at the middle-right

  Scenario: Hovering over the Alternative Search Button
    When The user hovers the mouse over the alternative search button
    Then The "Search" text appears next to the button when the mouse hovers over it

  Scenario: Clicking on the Alternative Search Button
    When The user clicks on the alternative search button
    Then A search bar where the user can enter any product name
    And A search button that navigates the user to the page with product-related items
    And An 'X' button at the top-right corner that returns the user to the homepage


  Scenario: Searching with the Alternative Search Button
    When The user clicks on the alternative search button
    And The user enters a product name "Network"
    And The user clicks on the search button
    Then The user should be redirected to a page containing "Network"

  @altsearchbtn
  Scenario: Searching with Invalid Product Name through the Alternative Search Button
    When The user clicks on the alternative search button
    And The user enters an invalid product name "Networking"
    And The user clicks on the search button
    Then The user should see an error message or notification indicating the invalid search attempt.



