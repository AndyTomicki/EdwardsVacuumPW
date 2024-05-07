package factory;

import com.microsoft.playwright.*;
import utils.WebActions;

public class DriverFactory {
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static ThreadLocal<Page> threadLocalDriver = new ThreadLocal<>(); //For Parallel execution
    public static ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();

    //Launches Browser as set by user in config file
    public Page initDriver(String browserName) {
        BrowserType browserType = null;
        boolean headless = Boolean.parseBoolean(WebActions.getProperty("headless"));
        switch (browserName) {
            case "firefox":
                browserType = Playwright.create().firefox();
                browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "chrome":
                browserType = Playwright.create().chromium();
                browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));
                break;
            case "webkit":
                browserType = Playwright.create().webkit();
                browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
        }

        switch (System.getProperty("device")) {
            default: //Windows
                context = browser.newContext(new Browser.NewContextOptions()
                        .setDeviceScaleFactor(1)
                        .setIsMobile(false)
                        .setHasTouch(false)
                        .setScreenSize(1920, 1080)
                        .setViewportSize(1920, 1080)
                );
                break;
            case "Pixel5":
                context = browser.newContext(new Browser.NewContextOptions()
//                        .setLocale("de-DE")
//                        .setTimezoneId("Europe/Berlin")
                        .setDeviceScaleFactor(2.75)
                        .setIsMobile(true)
                        .setHasTouch(true)
                        .setScreenSize(393, 851)
                        .setViewportSize(393, 727)
                        .setUserAgent("Mozilla/5.0 (Linux; Android 11; Pixel 5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.6422.26 Mobile Safari/537.36")
                );
                break;

        }

        if (browserType == null) throw new IllegalArgumentException("Could not Launch Browser for type" + browserType);

        //Below line is used to start the trace file
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));
        page = context.newPage();
        threadLocalDriver.set(page);
        threadLocalContext.set(context);
        return page;
    }

    public static synchronized Page getPage() {
        return threadLocalDriver.get(); // Will return Initialized Thread Local Driver
    }

    public static synchronized BrowserContext getContext() {
        return threadLocalContext.get(); // Will return Initialized Thread Local Context
    }

}
