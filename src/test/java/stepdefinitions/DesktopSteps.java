package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DesktopPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static factory.DriverFactory.page;

public class DesktopSteps {
    DesktopPage desktopPage = new DesktopPage(DriverFactory.getPage());

    @Given("^user goes to \"([^\"]*)\"$")
    public void navigateToUrl(String url) {
        desktopPage.navigateToUrl(url);
    }

    @When("^user accepts cookies")
    public void userAcceptsCookies() {
        desktopPage.clickOnIAcceptCookies();
    }

    @And("closes location bar")
    public void closesLocationBar() {
        desktopPage.closeLocationBar();
    }

    @And("^user clicks on element with text \"([^\"]*)\"$")
    public void clicksOnButtonElementItemWithText(String itemText) {
        desktopPage.clickOnItemWithText(itemText);
    }

    @And("^user clicks on element by locator \"([^\"]*)\"$")
    public void clicksOnButtonElementByLocator(String itemLocator) {
        desktopPage.clickOnItemByLocator(itemLocator);
    }

    @And("user clicks on {string} quick links menu item")
    public void clickOnQuickLinksMenuWithText(String itemText) {
        desktopPage.clickOnQuickLinksMenuWithText(itemText);
    }

    @And("user clicks on {string} main menu sub item")
    public void clickOnMainMenuSubItem(String itemText) {
        desktopPage.clickOnMainMenuSubItem(itemText);
    }

    @And("user clicks on the main menu")
    public void clickOnMainMenu() {
        desktopPage.expandMainMenu();
    }

    @And("user clicks on the location menu")
    public void clickOnLocationMenu() {
        desktopPage.expandLocationMenu();
    }

    @And("verify that background colour of {string} element is {string}")
    public void checksColourOfElement(String element, String colour) {
        desktopPage.checkColour(element, colour);
    }

    @And("verify that background colour of Header is {string}")
    public void checksColourOfHeader(String colour) {
        page.waitForTimeout(310);
        desktopPage.checkColourOfHeader(colour);
    }

    @Then("verify that colour of {string} main menu sub item is {string}")
    public void checksColourOfSubMenu(String element, String colour) {
        desktopPage.checkColourSubMenuItem(element, colour);
    }

    @Then("user expands main menu")
    public void userExpandsMainMenu() {
        desktopPage.expandMainMenu();
    }

    @Then("main menu is not visible")
    public void mainMenuIsNotVisible() {
        desktopPage.mainMenuIsNotVisible();
    }

    @Then("location menu is not visible")
    public void locationMenuIsNotVisible() {
        desktopPage.locationMenuIsNotVisible();
    }

    @And("user clicks on Search Input Field")
    public void userClicksOnSearchInputField() {
        desktopPage.SEARCH_INPUT.click();
    }

    @Given("top part of the header is visible")
    public void userCanSeeTopPartOfTheHeader() {
        page.waitForTimeout(300);
        assertThat(desktopPage.TOP_HEADER).isInViewport();
    }

    @And("bottom part of the header is visible")
    public void bottomPartOfTheHeaderIsVisible() {
        page.waitForTimeout(300);
        assertThat(desktopPage.BOTTOM_HEADER).isInViewport();
    }

    @And("bottom part of the header is on the bottom of the page")
    public void bottomPartOfTheHeaderIsOnTheBottom() {
        int whereIsBottomHeader = (int) (page.viewportSize().height - desktopPage.BOTTOM_HEADER.boundingBox().y);
        Assert.assertEquals("Bottom part of the header is not in the right place on a page", 65, whereIsBottomHeader);
    }

    @And("bottom part of the header is on the top of the page")
    public void bottomPartOfTheHeaderIsOnTheTop() {
        Assert.assertEquals("Bottom part of the header is not in the right place on a page", 50, desktopPage.BOTTOM_HEADER.boundingBox().y, 0.0);
    }

    @Given("top part of the header is not visible")
    public void userCantSeeTopPartOfTheHeader() {
        page.waitForTimeout(330);
        assertThat(desktopPage.TOP_HEADER).not().isInViewport();
    }

    @And("bottom part of the header is not visible")
    public void bottomPartOfTheHeaderIsNotVisible() {
        page.waitForTimeout(330);
        assertThat(desktopPage.BOTTOM_HEADER).not().isInViewport();
    }

    @Then("user scrolls down by {int} pixels")
    public void userScrollsDownByPixels(int deltaY) {
        page.mouse().wheel(0, deltaY);
    }

    @Then("user scrolls up by {int} pixels")
    public void userScrollsUpByPixels(int deltaY) {
        page.mouse().wheel(0, -deltaY);
    }

    @And("Full Edwards Logo is visible")
    public void fullEdwardsLogoIsVisible() {
        assertThat(desktopPage.EDWARDS_LOGO).isInViewport();
    }

    @And("Full Edwards Logo is not visible")
    public void fullEdwardsLogoIsNotVisible() {
        assertThat(desktopPage.EDWARDS_LOGO).not().isInViewport();
    }

    @And("Favicon Edwards Logo is visible")
    public void faviconEdwardsLogoIsVisible() {
        assertThat(desktopPage.FAVICON_EDWARDS_LOGO).isInViewport();
    }

    @And("Favicon Edwards Logo is not visible")
    public void faviconEdwardsLogoIsNotVisible() {
        assertThat(desktopPage.FAVICON_EDWARDS_LOGO).not().isInViewport();
    }

    @And("Market Picker is visible")
    public void marketPickerIsVisible() {
        assertThat(desktopPage.MARKET_PICKER).isInViewport();
    }

    @Given("user refreshes the page")
    public void userRefreshesThePage() {
        page.reload();
    }
}
