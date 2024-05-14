
This readme.md is still under construction

---

![](logo.png)

# Edwards Vacuum Regression Suite

---
## Running Tests

To run all the tests, run the following command

```bash
  mvn test
```

To run certain scenario/set of scenarios use `Cucumber tag` - like `@Current` above `Scenario` or `Feature` keyword 

```cucumber
  @Device:iPadPro11 @Current
  Scenario: Verify colour of SEMICONDUCTOR menu item
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
```

```bash
  mvn test -Dcucumber.filter.tags=@Current
```
---
## Headless mode

 Suite is ran **_headlessly_** by default. To override use parameter `-Dheadless=false`  

```bash
  mvn test -Dcucumber.filter.tags=@Current -Dheadless=false
```
---
## Available emulated devices:

- Desktop
- Pixel5
- iPadPro11

By default suite is emulated on desktop device. To override use: `@Device:DeviceName` tag above `Feature` or a `Scenario` name

Example:
```Cucumber 
  @Device:Pixel5
  Scenario: Verify User is able to perform actions on Web Elements in Video Playlist page on Pixel5
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
```

Devices can be added to the framework in [src/main/java/factory/DriverFactory.java](src/main/java/factory/DriverFactory.java)  
A list of devices can be found [here](https://github.com/microsoft/playwright/blob/main/packages/playwright-core/src/server/deviceDescriptorsSource.json)

---
## Browser support and emulation

- Chrome
- Firefox
- WebKit (Safari engine)

By default, suite is running `Chrome`. To override use: `@Browser:BrowserName` tag above `Feature` or a `Scenario` name

Example:
```Cucumber 
  @Browser:WebKit
  Scenario: Verify User is able to perform actions on Web Elements in Video Playlist page on Pixel5
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/testing-video-playlist"
    Then user accepts cookies
```    



