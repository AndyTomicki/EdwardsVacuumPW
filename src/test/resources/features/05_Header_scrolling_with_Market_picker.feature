
Feature: 05 Header scrolling with Market picker

  Background:
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies

  Scenario: Header scrolling with Market picker
    Given user refreshes the page
    And top part of the header is visible
    And bottom part of the header is visible
    And Market Picker is visible
    Then user scrolls down by 1200 pixels
    And Favicon Edwards Logo is visible
    And bottom part of the header is visible
    And Market Picker is visible
    Then user scrolls up by 1200 pixels
    And top part of the header is visible
    And bottom part of the header is visible
    And Market Picker is visible


  @Device:Pixel5
  Scenario: Header scrolling with Market picker
    Given user refreshes the page
    And top part of the header is visible
    And bottom part of the header is visible
    And Market Picker is visible
    Then user scrolls down by 1200 pixels