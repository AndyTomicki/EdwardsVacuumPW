
Feature: 07 Video playlist [WIP]

  Background:
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies

  @Device:Desktop
  Scenario: Video playlist
    Then after clicking "Video Title - 2" the response status should be 206 with video file "Edwards-E2S-2-0x480-1800k.mp4"
    And after clicking "Video Title - 1" the response status should be 404 with video file "Edwards-E2S-1-0x480-1800k.mp4"


  @Device:Pixel5
  Scenario: [Mobile] Video playlist
    Then after clicking "Video Title - 2" the response status should be 206 with video file "Edwards-E2S-2-0x480-1800k.mp4"
    Then user closes video
    And after clicking "Video Title - 1" the response status should be 404 with video file "Edwards-E2S-1-0x480-1800k.mp4"
