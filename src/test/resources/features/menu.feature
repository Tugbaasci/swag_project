Feature: As regitered user, I should be able to access the website, then see the menu and the links in the menu can be visible and interactive
@wip
  Scenario: User can access the website and the links in the menu can be visible and active
    And user navigates to the URL
    Then user enters username to login
    Then user enters password to login
    When user enters login button
    And user clicks the menu
    Then checks the links are visible and enabled
    Given user clicks All Items and checks the url
    Given user clicks About and checks the url
    Then user clicks Logout and checks the url
    Then clicks the reset app state and checks the url
    When closes the app