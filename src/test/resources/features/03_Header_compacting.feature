Feature: 03 Header compacting

  Background:
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies

  @Device:Desktop
  Scenario: Header compacting
    - rgb(45, 54, 58) - --grey: #2d363a; - darker grey
    - rgb(87, 94, 97) - #575e61 - light grey
    Given top part of the header is visible
    And bottom part of the header is visible
    And bottom part of the header is on the top of the page
    And Full Edwards Logo is visible
    And Favicon Edwards Logo is not visible
    Then verify that background colour of Header is "rgb(45, 54, 58)"
    When user scrolls down by 1500 pixels
    Then top part of the header is not visible
    And bottom part of the header is visible
    And Full Edwards Logo is not visible
    And Favicon Edwards Logo is visible
    Then verify that background colour of Header is "rgb(87, 94, 97)"
    When user scrolls up by 1500 pixels
    Given top part of the header is visible
    And bottom part of the header is visible
    Then verify that background colour of Header is "rgb(45, 54, 58)"
    And Full Edwards Logo is visible
    And Favicon Edwards Logo is not visible

  @Device:Pixel5
  Scenario: Header compacting on mobile
    Given top part of the header is visible
    And bottom part of the header is visible
    And bottom part of the header is on the bottom of the page
    When user scrolls down by 1500 pixels
    Then top part of the header is visible
    And bottom part of the header is not visible