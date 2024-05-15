package stepdefinitions;

import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import static factory.DriverFactory.page;

public class RelativePositions {
    @Then("verify that {string} is above {string}")
    public void isAbove(String firstElementLocator, String secondElementLocator) {
        Locator firstElement = page.locator(firstElementLocator).first();
        Locator secondElement = page.locator(secondElementLocator).first();
        assertThat(firstElement).isInViewport();
        assertThat(secondElement).isInViewport();
        Assert.assertTrue("'"+firstElementLocator+"' should be above of '"+secondElementLocator+"'", firstElement.boundingBox().y+firstElement.boundingBox().height < secondElement.boundingBox().y);
    }

    @Then("verify that {string} is below {string}")
    public void isBelow(String firstElementLocator, String secondElementLocator) {
        Locator firstElement = page.locator(firstElementLocator).first();
        Locator secondElement = page.locator(secondElementLocator).first();
        assertThat(firstElement).isInViewport();
        assertThat(secondElement).isInViewport();
        Assert.assertTrue("'"+firstElementLocator+"' should be below of '"+secondElementLocator+"'", firstElement.boundingBox().y > secondElement.boundingBox().y+secondElement.boundingBox().height);
    }

    @Then("verify that {string} is on the left of {string}")
    public void isOnTheLeft(String firstElementLocator, String secondElementLocator) {
        Locator firstElement = page.locator(firstElementLocator).first();
        Locator secondElement = page.locator(secondElementLocator).first();
        assertThat(firstElement).isInViewport();
        assertThat(secondElement).isInViewport();
        Assert.assertTrue("'"+firstElementLocator+"' should be on the left of '"+secondElementLocator+"'", firstElement.boundingBox().x+firstElement.boundingBox().width < secondElement.boundingBox().x);
    }

    @Then("verify that {string} is on the right of {string}")
    public void isOnTheRight(String firstElementLocator, String secondElementLocator) {
        Locator firstElement = page.locator(firstElementLocator).first();
        Locator secondElement = page.locator(secondElementLocator).first();
        assertThat(firstElement).isInViewport();
        assertThat(secondElement).isInViewport();
        Assert.assertTrue("'"+firstElementLocator+"' should be on the right of '"+secondElementLocator+"'", firstElement.boundingBox().x > secondElement.boundingBox().x+secondElement.boundingBox().width );
    }
}
