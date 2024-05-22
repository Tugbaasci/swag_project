Feature: As a registered user I want to access the social medias
@social
  Scenario: I can access the social medias and the links should navigate to the correct address
    Then user navigates to the URL
    When user enters username to login
    Then user enters password to login
    And user enters login button
    Given user clicks on the facebook icon
    Given user verifies the url includes "facebook"
    When user clicks on the x icon
    Given user verifies the url includes "x"
    When user clicks on the linkedin icon
    Given user verifies the url includes "linkedin"
    Then quits the app

