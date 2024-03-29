@Comparison
Feature: Product Comparison


  Background:
    * The user is on the home page
    * The user closes the pop-up
    * The user clicks on the login button on the home page
    * The user provides valid credentials
    * The user navigates to "Television" category
    * The user adds two products on the product comparison list


  Scenario Outline: The user should be able to add products to Compare list
    When The user is able to put any product into the comparison list
    Then The user verifies the "<message>" message on the top of page
    Examples:
      | message                 |
      | Success: You have added |

  Scenario: The user should be able to click Compare button
    When The user clicks on the Compare button
    Then The user verifies that the Compare page is displayed


  Scenario: The user should be able to verify Compare page's compare terms
    When The user clicks on the Compare button
    Then The user verifies that the Compare page is displayed
    Then The user verifies that the products are compared to each other in the following ways
      | Product                |
      | Image                  |
      | Price                  |
      | Model                  |
      | Brand                  |
      | Availability           |
      | Rating                 |
      | Summary                |
      | Weight                 |
      | Dimensions (L x W x H) |


  @sonson
  Scenario Outline: The user should be able to verify comparing more than 4 items together is not allowed
    When The user adds third product to Comparison list
    When The user adds fourth product to Comparison list
    When The user tries add to fifth product to Comparison list
    Then The user verifies the warning "<message>" that product fifth cannot be added to the Comparison list
    Examples:
      | message                                                                                      |
      | Maximum products to compare is 4. First added product has been removed from comparison list. |




