package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import pages.MobilePage;

public class MobileSteps {
    MobilePage mobilePage = new MobilePage(DriverFactory.getPage());

    @And("user clicks on the main menu on mobile")
    public void clickOnQuickLinksMenuWithText() {
        mobilePage.expandMainMenu();
    }
}
