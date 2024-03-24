#User Story: As a user, I should be able to shop successfully.
#
#Precondition:
#
#User should be logged in.
#
#User should put some products into his/her shopping cart.
#
#Acceptance Criteria:
#
#When the user is landed on the shopping cart page, there are products that have been put before.
#
#There is a "Checkout" button at the right-bottom of the page.
#
#When the user clicks on the "Checkout" button s/he is navigated to the Billing Details menu.
#
#After the user fills in all the necessary menus and clicks on the "Continue" button, s/he is directed to the "Delivery Details" menu.
#
#Once the user is on the "Delivery Details" menu, there are 2 different options for delivery address:
# 5.1. The current address is shown selected as default,
# 5.2. The address can be updated by tapping on the second button.
#
#After the user selects the delivery address and clicks on the "Continue" button, s/he is directed to the "Delivery Method" menu.
#
#Once the user is on the "Delivery Method" menu, there are 2 sections under it,
# 7.1. Flat Shipping Rate7.2. A space that allows the user can add some comments about the order
#
#After the user clicks on the "Continue" button, s/he is directed to the "Payment Method" menu.
#
#Once the user is on the "Payment Method" menu, there are sections under it such as,
# 9.1. "Cash on Delivery" option that is selected as default,
# 9.2. A space that allows the user can add some comments about the order
# 9.3. "Terms and Conditions" button
#
#After the user accepts "Terms & Conditions" and clicks on the "Continue" button, s/he is directed to the "Confirm Order" menu.
#
#When the user is on Confirm Order menu, there are sections under it such as,
# 11.1. The product names,
# 11.2. The product models,
# 11.3. Quantities,
# 11.4. Unit Prices,
# 11.5. Total price for each different product,
# 11.6. Sub-Total,
# 11.7. Flat Shipping Rate,
# 11.8. Total,
# 11.9. "Confirm Order" button.
#
#After the user clicks on the "Confirm Order" button, the product(s) have been successfully ordered and the page is having messages such as:Your order has been placed!Your order has been successfully processed!You can view your order history by going to my account page and by clicking on history.If your purchase has an associated download, you can go to the account downloads page to view them.Please direct any questions you have to the store owner.Thanks for shopping with us online!
#
#When the user goes to the home page, there is a "Track Your Order" button that allows following the product.
#
#If the user goes to the order history page, s/he will see the status and details of shopping.
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
    And  The user verifies that "Checkout" button at the right-bottom of the page
    When The user clicks on the "Checkout" button
    Then The user is navigated to the "Billing Details" menu
    When The user fills in all the necessary menus and clicks on the "Continue" button
    Then The user is navigated to the "Delivery Details" menu
    And The user verifies that the current address is shown selected as default
    And  The user verifies that the address can be updated by tapping on the second button
    When The user selects the delivery address and clicks on the "Continue" button
    Then The user is navigated to the "Delivery Method" menu
    And The user verifies that "Flat Shipping Rate"
    And The user verifies that a space that allows the user can add some comments about the order
    When The user clicks on the "Continue" button
    Then The user is navigated to the "Payment Method" menu
    And The user verifies that "Cash on Delivery" option that is selected as default
    And The user verifies that a space that allows the user can add some comments about the order
    And The user verifies that "Terms and Conditions" button
    When The user accepts "Terms & Conditions" and clicks on the "Continue" button
    Then The user is navigated to the "Confirm Order" menu
    And The user verifies that the product names, models, quantities, unit prices, total price for each different product, sub-total, flat shipping rate, total
    When The user clicks on the "Confirm Order" button
    Then The user verifies the following messages:
      | Your order has been placed!                                                                         |
      | Your order has been successfully processed!                                                         |
      | You can view your order history by going to my account page and by clicking on history.             |
      | If your purchase has an associated download, you can go to the account downloads page to view them. |
      | Please direct any questions you have to the store owner.                                            |
      | Thanks for shopping with us online!                                                                 |
    When The user goes to the home page
    Then The user verifies that there is a "Track Your Order" button that allows following the product
    When The user goes to the order history page
    Then The user verifies the status and details of shopping