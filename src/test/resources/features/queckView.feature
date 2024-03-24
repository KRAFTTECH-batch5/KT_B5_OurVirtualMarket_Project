@mhmmdincs
Feature: Quick View and Updating Cart Charge

  Scenario: User adds a product to the cart and sees the updated charge
    Given the user must be logged in and on the home page with at least one product in their cart
    When the user hovers over a product and clicks quick view
    And adds the product to the cart
    Then the cart total should be updated correctly in the pop-up
    And the user sees the updated total on the home page