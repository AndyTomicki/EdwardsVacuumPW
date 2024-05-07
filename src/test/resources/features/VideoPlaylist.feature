@Current
Feature: Verify the functionalities of Video Playlist page

  @Device=Windows
  Scenario: Verify User is able to perform actions on Web Elements in Video Playlist page
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
    Then user clicks on element with text "MENU"

  @Device=Pixel5
  Scenario: Verify User is able to perform actions on Web Elements in Video Playlist page on Pixel5
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
    Then user clicks on element with text "MENU"
