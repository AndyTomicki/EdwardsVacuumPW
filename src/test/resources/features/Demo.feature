
Feature: Just a demo of the framework

  Scenario: Verify colour of SEMICONDUCTOR menu item
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
    Then user clicks on "Semiconductor" quick links menu item
    And verify that background colour of "//span[.='Semiconductor']/../.." element is "rgb(196, 38, 46)"
    Then user clicks on the main menu
    And user clicks on "Back" main menu sub item
    Then verify that colour of "Semiconductor" main menu sub item is "rgb(196, 38, 46)"
    Then user clicks on "Semiconductor" main menu sub item
    And user clicks on "Back" main menu sub item
    Then user clicks on "General Industries, Research & Development" main menu sub item
    And user clicks on "Back" main menu sub item
    Then user clicks on "Service Solutions" main menu sub item
    Then user clicks on the main menu
    And user clicks on "Talk to us" main menu sub item
    Then user clicks on the main menu
    Then user clicks on "General Industries, Research & Development" main menu sub item
    Then user clicks on "Our Markets" main menu sub item
    Then user clicks on "Carbon Capture, Utilisation and Storage" main menu sub item


  @Device:Pixel5
  Scenario: Click around on Pixel5
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
    And user clicks on the main menu on mobile
    Then user clicks on "Semiconductor" main menu sub item
    And user clicks on "Back" main menu sub item
    Then user clicks on "General Industries, Research & Development" main menu sub item
    Then user clicks on "Our Markets" main menu sub item
    Then user clicks on "Carbon Capture, Utilisation and Storage" main menu sub item
    And user clicks on the main menu on mobile


    
