package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DesktopPage;

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
    public void clickOnQuickLinksMenuWithText() {
        desktopPage.expandMainMenu();
    }

    @And("verify that background colour of {string} element is {string}")
    public void checksColourOfElement(String element, String colour) {
        desktopPage.checkColour(element, colour);
    }

    @Then("verify that colour of {string} main menu sub item is {string}")
    public void checksColourOfSubMenu(String element, String colour) {
        desktopPage.checkColourSubMenuItem(element, colour);
    }

    @Then("user expands main menu")
    public void userExpandsMainMenu() {
        desktopPage.expandMainMenu();
    }


//    @When("^user enters \"([^\"]*)\" username$")
//    public void enterUsername(String username) {
//        loginPage.enterUsername(username);
//    }
//
//    @When("^user enters \"([^\"]*)\" password$")
//    public void enterPassword(String password) {
//        loginPage.enterPassword(password);
//    }
//
//    @When("^user clicks Login button$")
//    public void clickLogin() {
//        loginPage.clickLogin();
//    }
//
//    @When("^user clicks on \"([^\"]*)\" icon in main page")
//    public void clickOnIcon(String iconName) {
//        loginPage.clickOnIcon(iconName);
//    }
//
//    @Then("verify that user is logged in and navigated to Profile page")
//    public void verifyProfilePage() {
//        Assert.assertTrue(loginPage.verifyProfilePage());
//    }
//
//    @Then("^user verifies data as \"([^\"]*)\" in \"([^\"]*)\" row and \"([^\"]*)\" column from \"([^\"]*)\" sheet in \"([^\"]*)\" file")
//    public void clickOnIcon(String expectedValue, int rowNum, int colNum, String sheetName, String fileName) {
//        String actualValue = WebActions.getRowColValue(fileName, sheetName, rowNum, colNum);
//        Assert.assertEquals(expectedValue, actualValue);
//    }
}
