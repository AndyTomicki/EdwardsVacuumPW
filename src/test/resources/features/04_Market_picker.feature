Feature: 04 Market picker test

  Background:
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies

  @Device:Desktop @Current
  Scenario: Market picker modal shows when there is a page available for selected market
    Given Market Picker is not visible
    And verify that cookie "preferred-locale" is not set
    When user refreshes the page
    Then Market Picker is visible
    And user selects "Česká republika" as a preferred market
    Then page url should contain "cs-cz"
    Then verify that cookie "preferred-locale" is stored as "cs-cz"
    Then Market Picker is not visible
    And user selects "Brasil" as a market
    Then page url should contain "pt-br"
    Then Market Picker is visible
    And user clicks on GO TO PAGE button
    Then page url should contain "cs-cz"



