@regression
Feature: E-mail Subscription

  Background:

    @wip
    Scenario: Cancel Subscription Popup | Positive
      When The user should be logged in
      Then The user should verify a pop-up message offering to subscribe to the mailing list
      When The user should click on the X close button on the pop-up
      Then The user should verify that the pop-up window disappears
      Then The user should be able to continue subscribing using the banner at the bottom

