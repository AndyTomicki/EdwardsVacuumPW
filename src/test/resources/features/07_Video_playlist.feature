
Feature: 07 Video playlist [WIP]

  Background:
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies

  @Device:Desktop  @Current
  Scenario: Video playlist elements positions and visibility
    Then after clicking "Video Title - 2" the response status should be 206 with video file "Edwards-E2S-2-0x480-1800k.mp4"
    Then verify that ".cmp-video-playlist__card__info__duration--total" is below ".cmp-video-playlist__card__info__title"
    Then verify that ".cmp-video-playlist__card__info__title" is above ".cmp-video-playlist__card__info__bottom"
    Then verify that ".cmp-video-playlist__video" is on the left of ".cmp-video-playlist__list"
    And verify that ".cmp-video-playlist__card__info__icons" is on the right of ".cmp-video-playlist__card__info__duration--current"
    And verify that ".cmp-video-playlist__load-more__button" element is not visible
    Then verify that "//div[@data-videotitle='Video Title - 1']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 2']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 3']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 4']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 5']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 6']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 7']" element is loaded in the page


  @Device:Desktop
  Scenario: Videos loading/not loading to the player
    Then after clicking "Video Title - 2" the response status should be 206 with video file "Edwards-E2S-2-0x480-1800k.mp4"
    And verify that background colour of "//div[@data-videotitle='Video Title - 2']" element is "rgb(45, 54, 58)"
    And after clicking "Video Title - 1" the response status should be 404 with video file "Edwards-E2S-1-0x480-1800k.mp4"
    And verify that background colour of "//div[@data-videotitle='Video Title - 2']" element is "rgb(255, 255, 255)"
    Then after clicking "Video Title - 4" the response status should be 206 with video file "COVID-19-April-2020-Update-English-captions-0x480-1800k.mp4"
    Then after clicking "Video Title - 7" the response status should be 206 with video file "treatment-0x480-1800k.mp4"


  @Device:Pixel5
  Scenario: [Mobile] Video playlist elements positions and visibility
    Then after clicking "Video Title - 2" the response status should be 206 with video file "Edwards-E2S-2-0x480-1800k.mp4"
    Then user closes video
    Then verify that ".cmp-video-playlist__card__info__duration--total" is below ".cmp-video-playlist__card__info__title"
    Then verify that ".cmp-video-playlist__card__info__title" is above ".cmp-video-playlist__card__info__bottom"
    And verify that ".cmp-video-playlist__video" element is not visible
    Then verify that "//div[@data-videotitle='Video Title - 1']" is above "//div[@data-videotitle='Video Title - 2']"
    Then user scrolls to ".cmp-video-playlist__load-more__button" element
    And verify that ".cmp-video-playlist__load-more__button" element is currently visible
    Then user clicks on ".cmp-video-playlist__load-more__button" element
    Then verify that "//div[@data-videotitle='Video Title - 1']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 2']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 3']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 4']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 5']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 6']" element is loaded in the page
    Then verify that "//div[@data-videotitle='Video Title - 7']" element is loaded in the page


  @Device:Pixel5
  Scenario: [Mobile] Videos loading/not loading to the player
    Then after clicking "Video Title - 2" the response status should be 206 with video file "Edwards-E2S-2-0x480-1800k.mp4"
    Then user closes video
    And verify that background colour of "//div[@data-videotitle='Video Title - 2']" element is "rgb(45, 54, 58)"
    And after clicking "Video Title - 1" the response status should be 404 with video file "Edwards-E2S-1-0x480-1800k.mp4"
    And verify that background colour of "//div[@data-videotitle='Video Title - 2']" element is "rgb(255, 255, 255)"

