Feature: Register Functionality

  Background:
    * User is on the home page
    * User closes the subscribe popup
    * User navigates to registration page


  Scenario: The user should be able to create new account
    When User fills form and clicks continue
    Then User should be able to create a new account

  @wip
  Scenario Outline: If the user not fills necessary fields then error messages appear
    When User fills form with "<firstname>", "<lastname>","<email>", "<telNumber>", "<password>", "<passwordConfirm>", "<privacy>"
    Then User verifies that error messages is displayed
    Examples:
      | firstname                               | lastname                                | email       | telNumber                                      | password                                     | passwordConfirm                              | privacy |
      |                                         |                                         |             |                                                |                                              |                                              | false   |
      | lee                                     | roy                                     | lee@roy.com | 5551112233                                     | 1234asdf                                     | 1234asdf                                     | false   |
      |                                         | roy                                     | lee@roy.com | 5551112233                                     | 1234asdf                                     | 1234asdf                                     | false   |
      | lee                                     |                                         | lee@roy.com | 5551112233                                     | 1234asdf                                     | 1234asdf                                     | false   |
      | lee                                     | roy                                     |             | 5551112233                                     | 1234asdf                                     | 1234asdf                                     | false   |
      | lee                                     | roy                                     | lee@roy.com |                                                | 1234asdf                                     | 1234asdf                                     | false   |
      | lee                                     | roy                                     | lee@roy.com | 5551112233                                     |                                              | 1234asdf                                     | false   |
      | lee                                     | roy                                     | lee@roy.com | 5551112233                                     | 1234asdf                                     |                                              | false   |
      | lee                                     | roy                                     | lee@roy.com | 5551112233                                     | 1234asdf                                     | asdf1234                                     | false   |
      | lee123456789123456798123456789123456789 | roy                                     | lee@roy.com | 5551112233                                     | 1234asdf                                     | 1234asdf                                     | false   |
      | lee                                     | roy123456789123456798123456789123456789 | lee@roy.com | 5551112233                                     | 1234asdf                                     | 1234asdf                                     | false   |
      | lee                                     | roy                                     | lee@roy.com | 5551112233123456789123456798123456789123456789 | 1234asdf                                     | 1234asdf                                     | false   |
      | lee                                     | roy                                     | lee@roy.com | 5551112233                                     | 1234asdf123456789123456798123456789123456789 | 1234asdf123456789123456798123456789123456789 | false   |
      | lee                                     | roy                                     | lee@roy.com | 5551112233                                     | 123                                          | 123                                          | false   |
      | lee                                     | roy                                     | leeroy      | 5551112233                                     | 1234asdf                                     | 1234asdf                                     | true       |
      | lee                                     | roy                                     | @leeroy     | 5551112233                                     | 1234asdf                                     | 1234asdf                                     | true    |
      | lee                                     | roy                                     | leeroy@     | 5551112233                                     | 1234asdf                                     | 1234asdf                                     | true    |

Scenario: negative scenario
