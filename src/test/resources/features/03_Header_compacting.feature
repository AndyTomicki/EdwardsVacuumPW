Feature: 03 Header compacting

  Background:
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies

  @Device:Windows
  Scenario: Header compacting
    Given top part of the header is visible
    And bottom part of the header is visible
    When user scrolls down by 1500 pixels
    Then top part of the header is not visible
    And bottom part of the header is visible


  @Device:Pixel5
  Scenario: Header compacting on mobile
    Given top part of the header is visible
    And bottom part of the header is visible
    When user scrolls down by 1500 pixels
    Then top part of the header is visible
    And bottom part of the header is not visible