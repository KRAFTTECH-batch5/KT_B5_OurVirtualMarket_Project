@return
Feature: Return Product


  Background:
    * The user is on the home page
    * The user closes the pop-up
    * The user clicks on the login button on the home page
    * The user provides valid credentials
    * The user puts "Nicky Clarke NHD146 Hair Therapy Touch Control Hair Dryer" into his or her shopping cart
    * The user is landed on the shopping cart page
    * The user clicks on the Checkout button
    * The user is navigated to the "Billing Details" menu
    * The user fills in all the necessary menus and clicks on the Continue button
    * The user is navigated to the "Delivery Details" menu
    * The user selects the delivery address and clicks on the Continue button
    * The user is navigated to the "Delivery Method" menu
    * The user clicks on the Continue button
    * The user is navigated to the "Payment Method" menu
    * The user accepts Terms & Conditions and clicks on the Continue button
    * The user is navigated to the "Confirm Order" menu
    * The user clicks on the Confirm Order button
    * The user clicks Contınue button and completes the purchase


  Scenario: user should be able to create a return request.
    Given The user goes to end of the home page
    Then   The user should verify that the two Returns and Orders and Returns links are visible at the bottom of the page
    And   The user clicks on the Returns button and should navigate to Product Returns page
    Then  The user should Verify that First Name , Last Name, and E-Mail fields are automatically filled with the customer's information.
    And   The user should fill in all necessary information correctly
    And   The user should choose reason for return "Dead On Arrival"
    And   The user should click on the Submit button.
    Then  The user should verify the message 'Thank you for submitting your return request. Your request has been sent to the relevant department for processing. You will be notified via e-mail as to the status of your request.'








