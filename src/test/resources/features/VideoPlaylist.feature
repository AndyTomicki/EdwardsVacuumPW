
Feature: Verify the functionalities of Video Playlist page

  @Device:iPadPro11 @Current
  Scenario: Verify colour of SEMICONDUCTOR menu item
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
    Then user clicks on element by locator "//span[.='Semiconductor']"
    And verify that colour of "//span[.='Semiconductor']/../.." element is "rgb(196, 38, 46)"

  @Device:Pixel5
  Scenario: Verify User is able to perform actions on Web Elements in Video Playlist page on Pixel5
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
    Then user clicks on element with text "MENU"
