package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.GeneralPage;

public class GeneralSteps {
    GeneralPage generalPage = new GeneralPage(DriverFactory.getPage());

    @Given("^user goes to \"([^\"]*)\"$")
    public void navigateToUrl(String url) {
        generalPage.navigateToUrl(url);
    }

    @When("^user accepts cookies")
    public void userAcceptsCookies() {
        generalPage.clickOnIAcceptCookies();
    }

    @And("closes location bar")
    public void closesLocationBar() {
        generalPage.closeLocationBar();
    }

    @And("^user clicks on element with text \"([^\"]*)\"$")
    public void clicksOnButtonElementItemWithText(String itemText) {
        generalPage.clickOnItemWithText(itemText);
    }

    @And("^user clicks on element by locator \"([^\"]*)\"$")
    public void clicksOnButtonElementByLocator(String itemLocator) {
        generalPage.clickOnItemByLocator(itemLocator);
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
