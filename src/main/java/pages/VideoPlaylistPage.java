package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.WebActions;

public class VideoPlaylistPage {
    private final Page page;
 //   private final Locator I_ACCEPT_COOKIES_BUTTON;
//    private final Locator PASSWORD_EDITBOX;
//    private final Locator LOGIN_BUTTON;
//    private final Locator BOOKS_SEARCH_BOX;

    public VideoPlaylistPage(Page page) {
        this.page = page;
     //   this.I_ACCEPT_COOKIES_BUTTON = page.getByText("I accept cookies");
//        this.PASSWORD_EDITBOX = page.locator("#password");
//        this.LOGIN_BUTTON = page.locator("#login");
//        this.BOOKS_SEARCH_BOX = page.getByPlaceholder("Type to search");
    }

//    public void navigateToUrl(String url) {
//        this.page.navigate(WebActions.getProperty(url));
//    }

//    public void enterUsername(String username) {
//        USERNAME_EDITBOX.fill(WebActions.getProperty(username));
//    }
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
