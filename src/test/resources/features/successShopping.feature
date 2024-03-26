@successshopping
Feature: Success Shopping

    # As a user, I should be able to shop successfully.

  Background:
    * The user is on the home page
    * The user closes the pop-up
    * The user clicks on the login button on the home page
    * The user provides valid credentials
    * The user puts product or products into his or her shopping cart

  Scenario: User should be able to shop successfully

    When The user is landed on the shopping cart page
    Then The user verifies that the products displayed on the cart page match the items previously added to the shopping cart.
    And  The user verifies that Checkout button at the right-bottom of the page
    When The user clicks on the Checkout button
    Then The user is navigated to the "Billing Details" menu
    When The user fills in all the necessary menus and clicks on the Continue button
    Then The user is navigated to the "Delivery Details" menu
    And The user verifies that the current address is shown selected as default
    And  The user verifies that the address can be updated by tapping on the second button
    When The user selects the delivery address and clicks on the Continue button
    Then The user is navigated to the "Delivery Method" menu
    And The user verifies that "Flat Shipping Rate"
    And The user verifies that a space that allows the user can add some comments about the order
    When The user clicks on the Continue button
    Then The user is navigated to the "Payment Method" menu
    And The user verifies that "Cash On Delivery" option that is selected as default
    And The user verifies that a space that allows the user can add some comments about the order
    And The user verifies that Terms and Conditions button
    When The user accepts Terms & Conditions and clicks on the Continue button
    Then The user is navigated to the "Confirm Order" menu
    And The user verifies that the product names, models, quantities, unit prices, total price for each different product, sub-total, flat shipping rate, total
    When The user clicks on the Confirm Order button
    Then The user verifies the following messages:
      | Your order has been placed!                                            |
      | Your order has been successfully processed!                            |
      | You can view your order history by going to the |
      | my account                                                             |
      |  page and by clicking on |
      | history                                                                |
      | .                                                                      |
      | If your purchase has an associated download, you can go to the account |
      | downloads                                                              |
      | page to view them.                                                     |
      | Please direct any questions you have to the                            |
      | store owner                                                            |
      | .                                                                      |
      | Thanks for shopping with us online!                                    |
    When The user goes to the home page
    Then The user verifies that there is a "Track Your Order" button that allows following the product
    When The user goes to the order history page
    Then The user verifies the status and details of shopping