package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MobilePage;

public class MobileSteps {
    MobilePage mobilePage = new MobilePage(DriverFactory.getPage());

    @And("user clicks on the main menu on mobile")
    public void clickOnMainMenu() {
        mobilePage.expandMainMenu();
    }

    @Then("user closes video")
    public void userClosesVideo() {
        mobilePage.closeVideo();
    }
}
