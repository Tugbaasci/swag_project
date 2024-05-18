Feature: As a user, I want to reset app to reload the page to turn back default

  Scenario: As a user, I want to be able to revert the page its initial state with a reset link
    And user navigates to the URL
    When user enters username to login
    Then user enters password to login
    And user enters login button
    Then user adds a product
    When user clicks the menu
    Then user clicks on the reset app store
    When user checks the remove changed into add after reset
    Then closes the app
