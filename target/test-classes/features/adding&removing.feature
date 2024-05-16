Feature: User should be able to add a product to the shopping cart and remove
  @wip
  Scenario: User adds a product and removes
    Then user navigates to the URL
    When user enters username to login
    Then user enters password to login
    And user enters login button
    Then user adds a product and checks the difference in shopping cart
    When user checks the product is correctly added to the cart
    Then user removes the product and checks the difference in the cart
    When closes the app
