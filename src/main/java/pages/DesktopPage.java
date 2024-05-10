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
    private final Locator LOCATION_MENU_BUTTON;
    public final Locator SEARCH_INPUT;
    public final Locator HEADER;
    public final Locator HEADER_SCROLLED;
    public final Locator TOP_HEADER;
    public final Locator BOTTOM_HEADER;


    public DesktopPage(Page page) {
        this.page = page;
        Locator VISIBLE = page.locator("*:visible");
        this.QUICKLINKS_MENU_ITEM = page.locator("//span[@class='cmp-header-twentytwentyfour__quicklinks-item__link__text']");
        this.I_ACCEPT_COOKIES_BUTTON = page.getByText("I accept cookies");
        this.COOKIES_MODAL = page.locator("//div[@aria-label='This website uses cookies']");
        this.LOCATION_BAR_CLOSE_BUTTON = page.locator("geo-location-close");
        this.MAIN_MENU_BUTTON = page.locator("//button[@class='cmp-header-twentytwentyfour__list-btn main-menu']");
        this.LOCATION_MENU_BUTTON = VISIBLE.and(page.locator("//button[@class='cmp-header-twentytwentyfour__list-btn']")).first();
        this.SEARCH_INPUT = page.locator("//div[@class='cmp-header__search-container']");
        this.HEADER = page.locator("//header[@class='cmp-header-twentytwentyfour']");
        this.HEADER_SCROLLED = page.locator("//header[@class='cmp-header-twentytwentyfour cmp-header-twentytwentyfour--scrolled']");
        this.TOP_HEADER = page.locator("//div[@class='cmp-header-twentytwentyfour__container__top']");
        this.BOTTOM_HEADER = page.locator("//div[@class='cmp-header-twentytwentyfour__container__bottom']");
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

    public void expandLocationMenu() {
        LOCATION_MENU_BUTTON.click();
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
        page.waitForTimeout(300);
        page.locator("p:visible").and(page.locator("//p[.='" + itemText + "']")).first().waitFor(new Locator.WaitForOptions().setTimeout(1000));
        page.locator("p:visible").and(page.locator("//p[.='" + itemText + "']")).first().click();
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
        assertThat(page.locator("p:visible").and(page.locator("//p[.='" + itemText + "']")).first().getByText(itemText, new Locator.GetByTextOptions().setExact(true))).hasCSS("color", colour);
    }

    public void mainMenuIsNotVisible() {
        Locator menuItem = page.locator("//ul[@class='cmp-header-twentytwentyfour__list__items__nested']/../..//li[@class='cmp-header-twentytwentyfour__list__item ']");
        for (int i = 0; i < menuItem.count(); i++) {
            assertThat(menuItem.nth(i)).isHidden();
        }
    }

    public void locationMenuIsNotVisible() {
        Locator menuItem = page.locator("//ul[@class='cmp-header-twentytwentyfour__list__items']").getByText("Brasil");
        for (int i = 0; i < menuItem.count(); i++) {
            assertThat(menuItem.nth(i)).isHidden();
        }
    }
}
