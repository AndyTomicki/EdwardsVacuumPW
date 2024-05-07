package hooks;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;
import java.util.Arrays;

public class Hooks {
    public DriverFactory driverFactory;
    public Page page;

    @Before
    public void launchBrowser(Scenario scenario) {
        String browser = "Chrome"; // default values
        String device = "Windows";

        for (Object o : Arrays.stream(scenario.getSourceTagNames().toArray()).toArray()) {
            String tag = o.toString();
            if (tag.contains("@Device:")) {
                device = tag.substring(8);
                System.setProperty("device", device);
            }
            if (tag.contains("@Browser:")) {
                browser = tag.substring(9);

            }
        }
        System.out.println("Running on browser: " + browser + " under device: " + device);
        driverFactory = new DriverFactory();
        page = driverFactory.initDriver(browser.toLowerCase()); // Passing browser name to launch the browser
    }

    //After runs in reverse order so order=1 will run first
    @After(order = 0)
    public void quitBrowser() {
        page.close();
    }

    @After(order = 1)
    public void takeScreenshotAndTrace(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll("", "_"); //Replace all space in scenario name with underscore
            byte[] sourcePath = page.screenshot();
            scenario.attach(sourcePath, "image/png", screenshotName);  //Attach screenshot to report if scenario fails
            DriverFactory.context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("target/" + screenshotName + ".zip")));
        }
    }


}
