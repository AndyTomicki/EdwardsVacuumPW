@Device:Windows
Feature: Verify the functionalities of Video Playlist page

  @Current
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



  Scenario: Verify User is able to perform actions on Web Elements in Video Playlist page on Pixel5
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
    Then user clicks on element with text "MENU"
