Feature: Verify the functionalities of Video Playlist page

  @Current
  Scenario: Verify User is able to perform actions on Web Elements in Video Playlist page
    Given user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    When user accepts cookies
    #And closes location bar
    Then user clicks on element with text "EXPLORE"
    Then user clicks on element with text "//button[@id='azZ4Gi8Ysd5D3oiM']"