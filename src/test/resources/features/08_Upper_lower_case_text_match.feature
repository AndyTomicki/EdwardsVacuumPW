
Feature: 08 Upper / lower text match

  Background:
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies

  @Device:Desktop
  Scenario: Verify Upper Case and Lower Case matching
    Then verify Upper Case and Lower Case matching for ".cmp-header-twentytwentyfour__container__bottom" element
      | Exact text to be present |
      | MENU                     |
      | CLOSE                    |
      | SEMICONDUCTOR            |
      | GENERAL INDUSTRIES       |
      | Search Edwards Vacuum    |

  @Device:Pixel5
  Scenario: [Mobile] Verify Upper Case and Lower Case matching
    Then verify Upper Case and Lower Case matching for ".cmp-header-twentytwentyfour__container__bottom" element
      | Exact text to be present |
      | Semiconductor            |
      | General Industries       |
      | Talk to us               |
      | Join us                  |
    
