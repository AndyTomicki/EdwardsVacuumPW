package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class GeneralPage {
    private final Page page;
    private final Locator I_ACCEPT_COOKIES_BUTTON;
    private final Locator LOCATION_BAR_CLOSE_BUTTON;


    public GeneralPage(Page page) {
        this.page = page;
        this.I_ACCEPT_COOKIES_BUTTON = page.getByText("I accept cookies");
        this.LOCATION_BAR_CLOSE_BUTTON = page.locator("geo-location-close");
    }

    public void navigateToUrl(String url) {
       // this.page.setViewportSize(1920, 1080);
        this.page.navigate(url);
    }

    public void clickOnIAcceptCookies() {
        I_ACCEPT_COOKIES_BUTTON.click();
    }

    public void closeLocationBar() {
        LOCATION_BAR_CLOSE_BUTTON.click();
    }

    public void clickOnItemWithText(String itemText) {
        page.getByText(itemText).click();
    }

    public void clickOnItemByLocator(String itemLocator) {
        page.locator(itemLocator).click();
    }

    public void checkColour(String itemLocator, String colour) {
        assertThat(page.locator(itemLocator)).hasCSS("background-color", colour);
    }
//
//    public void enterPassword(String password) {
//        PASSWORD_EDITBOX.fill(WebActions.decrypt(password));
//    }
//
//    public void clickLogin() {
//        LOGIN_BUTTON.click();
//    }
//
//    public void clickOnIcon(String iconName) {
//        this.page.getByText(iconName, new Page.GetByTextOptions().setExact(true)).click();  // Clicks on the Exact text
//    }
//
//    public boolean verifyProfilePage() {
//        return WebActions.waitUntilElementDisplayed(this.BOOKS_SEARCH_BOX, 60);
//    }
}
