
Feature: 06 Menu opens at correct level

  Background:
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/semiconductor/knowledge/innovation-hub/carbon-capture-and-storage"
    Then user accepts cookies

  @Device:Desktop
  Scenario: Semiconductor knowledge active
  - rgb(196, 38, 46) - highlighted red
  - rgb(87, 94, 97)  - grey
    And verify that background colour of "//span[.='Semiconductor']/../.." element is "rgb(196, 38, 46)"
    Then user clicks on the main menu
    Then verify that colour of "Innovation Hub" main menu sub item is "rgb(87, 94, 97)"
    And user clicks on "Back" main menu sub item
    Then verify that "Semiconductor knowledge" main menu sub item is visible
    Then verify that colour of "Semiconductor knowledge" main menu sub item is "rgb(196, 38, 46)"
    Then user clicks on "Semiconductor knowledge" main menu sub item
    Then verify that "Innovation Hub" main menu sub item is visible
    Then verify that colour of "Innovation Hub" main menu sub item is "rgb(87, 94, 97)"
    And user clicks on "Back" main menu sub item
    Then verify that colour of "Semiconductor knowledge" main menu sub item is "rgb(196, 38, 46)"
    Then verify that colour of "Products for the semiconductor industry" main menu sub item is "rgb(87, 94, 97)"



  @Device:Pixel5
  Scenario: Semiconductor knowledge active
    Then user clicks on the main menu on mobile
    And user clicks on "Back" main menu sub item
    Then verify that "Innovation Hub" main menu sub item is visible
    And user clicks on "Back" main menu sub item
    Then verify that "Semiconductor" main menu sub item is visible