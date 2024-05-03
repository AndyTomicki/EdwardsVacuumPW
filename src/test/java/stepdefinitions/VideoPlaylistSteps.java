package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.VideoPlaylistPage;
import utils.WebActions;

public class VideoPlaylistSteps {
    VideoPlaylistPage videoPlaylistPage = new VideoPlaylistPage(DriverFactory.getPage());

//    @Given("^user navigates to \"([^\"]*)\"$")
//    public void navigateToUrl(String url) {
//        videoPlaylistPage.navigateToUrl(url);
//    }
//
//    @When("^user enters \"([^\"]*)\" username$")
//    public void enterUsername(String username) {
//        videoPlaylistPage.enterUsername(username);
//    }
//
//    @When("^user enters \"([^\"]*)\" password$")
//    public void enterPassword(String password) {
//        videoPlaylistPage.enterPassword(password);
//    }
//
//    @When("^user clicks Login button$")
//    public void clickLogin() {
//        videoPlaylistPage.clickLogin();
//    }
//
//    @When("^user clicks on \"([^\"]*)\" icon in main page")
//    public void clickOnIcon(String iconName) {
//        videoPlaylistPage.clickOnIcon(iconName);
//    }
//
//    @Then("verify that user is logged in and navigated to Profile page")
//    public void verifyProfilePage() {
//        Assert.assertTrue(videoPlaylistPage.verifyProfilePage());
//    }
//
//    @Then("^user verifies data as \"([^\"]*)\" in \"([^\"]*)\" row and \"([^\"]*)\" column from \"([^\"]*)\" sheet in \"([^\"]*)\" file")
//    public void clickOnIcon(String expectedValue, int rowNum, int colNum, String sheetName, String fileName) {
//        String actualValue = WebActions.getRowColValue(fileName, sheetName, rowNum, colNum);
//        Assert.assertEquals(expectedValue, actualValue);
//    }
}
