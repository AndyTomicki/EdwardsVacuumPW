This readme.md is still under construction
# Edwards Vacuum Regression Suite


## Running Tests

To run tests, run the following command

```bash
  mvn test
```

To run certain scenario/set of scenarios use `Tag`

```cucumber
  @Device:iPadPro11 @Current
  Scenario: Verify colour of SEMICONDUCTOR menu item
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
```

```bash
  mvn test -Dcucumber.filter.tags=@Current
```

## Available emulated devices:

- Desktop
- Pixel5
- iPadPro11

use: `@Device:DeviceName` tag above `Feature` or a `Scenario` name

Example:
```Cucumber 
  @Device:Pixel5
  Scenario: Verify User is able to perform actions on Web Elements in Video Playlist page on Pixel5
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
    Then user clicks on element with text "MENU"
```    

## Browsers support

- Chrome
- Firefox
- WebKit

use: `@Browser:BrowserName` tag above `Feature` or a `Scenario` name

Example:
```Cucumber 
  @Browser:WebKit
  Scenario: Verify User is able to perform actions on Web Elements in Video Playlist page on Pixel5
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
    Then user clicks on element with text "MENU"
```    



