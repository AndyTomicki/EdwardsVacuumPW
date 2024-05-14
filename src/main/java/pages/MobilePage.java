package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MobilePage {
    private final Page page;
    private final Locator MOBILE_MAIN_MENU_BUTTON;
    private final Locator MOBILE_VIDEO_CLOSE_BUTTON;


    public MobilePage(Page page) {
        this.page = page;
        this.MOBILE_MAIN_MENU_BUTTON = page.locator("//div[@class='cmp-header-twentytwentyfour__mobile-navigation cmp-header-twentytwentyfour__toggle cmp-header-twentytwentyfour__toggle--close']");
        this.MOBILE_VIDEO_CLOSE_BUTTON = page.locator("//*[@class='svg-inline--fa fa-x internal-video-player__close']").first();
    }

    public void expandMainMenu() {
        MOBILE_MAIN_MENU_BUTTON.click();
    }
    public void closeVideo() {
        MOBILE_VIDEO_CLOSE_BUTTON.click();
    }
}
