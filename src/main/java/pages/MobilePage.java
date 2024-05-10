package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MobilePage {
    private final Page page;
    private final Locator MOBILE_MAIN_MENU_BUTTON;


    public MobilePage(Page page) {
        this.page = page;
        this.MOBILE_MAIN_MENU_BUTTON = page.locator("//div[@class='cmp-header-twentytwentyfour__mobile-navigation cmp-header-twentytwentyfour__toggle cmp-header-twentytwentyfour__toggle--close']");

    }

    public void expandMainMenu() {
        page.waitForTimeout(750);
        MOBILE_MAIN_MENU_BUTTON.click();
    }
}
