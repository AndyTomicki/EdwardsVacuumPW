package stepdefinitions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Response;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DesktopPage;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static factory.DriverFactory.page;
import static org.apache.commons.collections4.IteratorUtils.forEach;

public class DesktopSteps {
    DesktopPage desktopPage = new DesktopPage(DriverFactory.getPage());

    @Given("^user goes to \"([^\"]*)\"$")
    public void navigateToUrl(String url) {
        page.waitForTimeout(1000); // because there were problems loading page straight away
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

    @And("user clicks on {string} element")
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

    @And("verify that {string} main menu sub item is visible")
    public void verifyMainMenuSubItemVisibility(String itemText) {
        page.waitForTimeout(200);
        assertThat(page.locator("p:visible").and(page.locator("//p[.='" + itemText + "']")).last()).isVisible();
    }

    @And("verify that {string} element is loaded in the page")
    public void verifyItemVisibility(String element) {
        assertThat((page.locator(element)).first()).isVisible();
    }

    @And("verify that {string} element is currently visible")
    public void verifyItemCurrentVisibility(String element) {
        assertThat((page.locator(element)).first()).isInViewport();
    }

    @And("verify that {string} element is not currently visible")
    public void verifyItemCurrentVisibilityNot(String element) {
        assertThat((page.locator(element)).first()).not().isInViewport();
    }

    @And("verify that {string} element is not visible")
    public void verifyItemVisibilityNot(String element) {
        page.waitForTimeout(200);
        assertThat((page.locator(element)).first()).isHidden();
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
    public void checkBackgroundColourOfElement(String element, String colour) {
        page.waitForTimeout(150);
        desktopPage.checkBackgroundColour(element, colour);
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

    @And("size of {string} element is {float} by {float} pixels")
    public void verifySizeOfElement(String element, float width, float height) {
        page.waitForTimeout(300);
        Assert.assertEquals("Width of the element is not right", width, page.locator(element).first().boundingBox().width, 0.0);
        Assert.assertEquals("Height of the element is not right", height, page.locator(element).first().boundingBox().height, 0.0);
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

    @Then("user scrolls to {string} element")
    public void userScrollsUpByPixels(String element) {
        page.locator(element).first().scrollIntoViewIfNeeded();
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
        assertThat(desktopPage.MARKET_PICKER_PROMPT).isInViewport();
    }

    @And("Market Picker is not visible")
    public void marketPickerIsNotVisible() {
        assertThat(desktopPage.MARKET_PICKER_PROMPT).not().isInViewport();
    }

    @Given("user refreshes the page")
    public void userRefreshesThePage() {
        page.reload();
    }

    @Then("user hovers over {string} element")
    public void userHoversOverElement(String element) {
        page.locator(element).first().hover();
    }

    @Then("user selects {string} as a market")
    public void userSelectsAsAMarket(String market) {
        desktopPage.LOCATION_MENU_BUTTON.click();
        page.waitForTimeout(300);
        (page.getByText(market).and(page.locator("*:visible"))).first().click();
    }

    @And("user selects {string} as a preferred market")
    public void userSelectsAsAPreferredMarket(String market) {
        desktopPage.SELECT_YOUR_REGION.click();
        page.waitForTimeout(300);
        (page.getByText(market).and(page.locator("*:visible"))).first().click();
    }

    @Then("verify that cookie {string} is stored as {string}")
    public void cookieShouldBeStored(String cookieName, String cookieValue) {
        boolean cookieIsSet = false;
        for (int i = 0; i < page.context().cookies().size(); i++) {
            if (Objects.equals(cookieName, page.context().cookies().get(i).name)) {
                cookieIsSet = true;
                Assert.assertEquals("Cookie value mismatch", cookieValue, page.context().cookies().get(i).value);
            }
        }
        Assert.assertTrue("Cookie '" + cookieName + "' has not been set", cookieIsSet);
    }

    @Then("verify that cookie {string} is not set")
    public void cookieShouldBeStored(String cookieName) {
        for (int i = 0; i < page.context().cookies().size(); i++) {
            if (Objects.equals(cookieName, page.context().cookies().get(i).name))
                Assert.fail("Cookie is set as '" + page.context().cookies().get(i).value + "' but should not be set");
        }
    }

    @Then("user clicks on GO TO PAGE button")
    public void userClicksOnGOTOPAGEButton() {
        desktopPage.GO_TO_PAGE_BUTTON.click();
    }

    @Then("page url should contain {string}")
    public void pageUrlShouldContain(String partialUrl) {
        assertThat(page).hasURL(Pattern.compile(".*/" + partialUrl + "*"));
    }

    @Given("after clicking {string} the response status should be {int} with video file {string}")
    public void userClicksOnPlayButton(String elementToClick, int expectedResponseStatusCode, String fileNameToLoad) {
        page.waitForTimeout(500);
        try {
            Response response = page.waitForResponse(Pattern.compile(fileNameToLoad), () -> page.getByText(elementToClick).first().click(new Locator.ClickOptions().setForce(true)));
            Assert.assertEquals("HTTP response status match", expectedResponseStatusCode, response.status());
        } catch (Exception e) {
            Assert.fail("Failed looking for '" + fileNameToLoad + "' in the response");
            throw new RuntimeException(e);
        }
    }

    @Then("verify Upper Case and Lower Case matching for {string} element")
    public void verifyUpperCaseAndLowerCaseMatching(String element, DataTable texts) {
        List<Map<String, String>> data = texts.asMaps();
        for (Map<String, String> listOfTexts : data) {
            Assert.assertTrue("Element: '"+element+"' should contain exact text of '"+listOfTexts.get("Exact text to be present")+"', but what was found is: \n"+page.locator(element).innerText(), page.locator(element).innerText().contains(listOfTexts.get("Exact text to be present")));
        }
    }
}
