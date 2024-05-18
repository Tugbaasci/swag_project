
Feature: User should be able to do shopping
  Background:
    When user navigates to the URL
    Then user enters username to login
    Then user enters password to login
    And user enters login button

  Scenario: As a user I can buy product(s) and give an order

    Then user adds products to cart
    Then user goes to cart
    And user clicks on the checkout button
    Given user enters the necessary information and continues
    Then user checks the informations and products are added correctly
    Then user clicks on the finish button
    And user clicks on the back home button
    Then user verifies the homepage
    And closes the app

  Scenario: As a user I can buy product(s) and leave ordering

    Then user adds products to cart
    Then user goes to cart
    And user clicks on the checkout button
    Given user enters the necessary information and continues
    Then user checks the informations and products are added correctly
    Then user clicks on the cancel button
    And closes the app

