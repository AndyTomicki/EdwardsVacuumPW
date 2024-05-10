package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DesktopPage {
    private final Page page;
    private final Locator QUICKLINKS_MENU_ITEM;
    private final Locator I_ACCEPT_COOKIES_BUTTON;
    private final Locator COOKIES_MODAL;
    private final Locator LOCATION_BAR_CLOSE_BUTTON;
    private final Locator MAIN_MENU_BUTTON;
    private final Locator MOBILE_MAIN_MENU_BUTTON;


    public DesktopPage(Page page) {
        this.page = page;
        this.I_ACCEPT_COOKIES_BUTTON = page.getByText("I accept cookies");
        this.COOKIES_MODAL = page.locator("//div[@aria-label='This website uses cookies']");
        this.LOCATION_BAR_CLOSE_BUTTON = page.locator("geo-location-close");
        this.MAIN_MENU_BUTTON = page.locator("//button[@class='cmp-header-twentytwentyfour__list-btn main-menu']");
        this.MOBILE_MAIN_MENU_BUTTON = page.locator("//div[@class='cmp-header-twentytwentyfour__mobile-navigation cmp-header-twentytwentyfour__toggle cmp-header-twentytwentyfour__toggle--close']");
        this.QUICKLINKS_MENU_ITEM = page.locator("//span[@class='cmp-header-twentytwentyfour__quicklinks-item__link__text']");
    }

    public void navigateToUrl(String url) {
        this.page.navigate(url);
        //always accept cookies whenever cookie popup appears
     //   page.addLocatorHandler(COOKIES_MODAL, I_ACCEPT_COOKIES_BUTTON::click);
    }

    public void clickOnIAcceptCookies() {
        I_ACCEPT_COOKIES_BUTTON.click();
    }

    public void expandMainMenu() {
        MAIN_MENU_BUTTON.click();
    }

    public void closeLocationBar() {
        LOCATION_BAR_CLOSE_BUTTON.click();
    }

    public void clickOnItemWithText(String itemText) {
        page.getByText(itemText).click();
    }

    public void clickOnQuickLinksMenuWithText(String itemText) {
        QUICKLINKS_MENU_ITEM.getByText(itemText).click();
    }

    public void clickOnMainMenuSubItem(String itemText) {
        page.waitForTimeout(450);
        page.locator("p:visible").and(page.locator("//p[.='"+itemText+"']")).first().waitFor(new Locator.WaitForOptions().setTimeout(1000));
        page.locator("p:visible").and(page.locator("//p[.='"+itemText+"']")).first().click();
    }

    public void clickOnItemByLocator(String itemLocator) {
        System.out.println("COOKIES -------------------------------------------------");
        System.out.println(page.context().cookies().get(1).name);
        page.locator(itemLocator).click();
    }

    public void checkColour(String itemLocator, String colour) {
        assertThat(page.locator(itemLocator)).hasCSS("background-color", colour);
    }

    public void checkColourSubMenuItem(String itemText, String colour) {
        assertThat(page.locator("p:visible").and(page.locator("//p[.='"+itemText+"']")).first().getByText(itemText, new Locator.GetByTextOptions().setExact(true))).hasCSS("color", colour);
    }
}
