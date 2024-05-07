Feature: Verify the functionalities of Video Playlist page

  @Current
  Scenario: Verify User is able to perform actions on Web Elements in Video Playlist page
    Given user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    When user accepts cookies
    #And closes location bar
    Then user clicks on element with text "MENU"
    #Then user clicks on element by locator "xpath=//nav[@class='mobile-v2-nav']//button[@class='cmp-header__explore-btn cmp-header__toggle-btn open']//span[.='Close']"