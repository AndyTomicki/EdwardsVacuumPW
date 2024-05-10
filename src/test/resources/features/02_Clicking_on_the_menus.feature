Feature: 02 Clicking on the menus

  Background:
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies

  @Device:Windows @Current
  Scenario: Menu closes when needed
    Given main menu is not visible
    And location menu is not visible

    When user clicks on the main menu
    And user clicks on the location menu
    Then main menu is not visible

    When user clicks on the main menu
    And user clicks on Search Input Field
    Then main menu is not visible
    And location menu is not visible

    When user clicks on the location menu
    And user clicks on Search Input Field
    Then main menu is not visible
    And location menu is not visible