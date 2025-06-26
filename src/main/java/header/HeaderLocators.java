package header;

import org.openqa.selenium.By;

public class HeaderLocators {

    //-----------------------------------LOCATORS---------------------------------------

    // Лого сайта
    private final By siteLogo = By.cssSelector("#site-branding > a:first-child");

    // Имя пользователя в header
    private final By userName = By.cssSelector(".my-account");
    private final By contactPhone = By.cssSelector("#custom_html-2 a:first-child");
    private final By contactEmail = By.cssSelector("#custom_html-2 a + a");

    // Поле писка товара
    private final By searchItemField = By.cssSelector(".search-field");
    private final By searchItemButton = By.cssSelector(".searchsubmit");

    // Кнопки войти и выйти
    private final By login = By.cssSelector("a.account");
    private final By logout = By.cssSelector("a.logout");

    // Навигационное меню в header
    private final By mainPage = By.cssSelector("#menu-item-26 > a");
    private final By catalog = By.cssSelector("#menu-item-46 > a");
    private final By myAccount = By.cssSelector("#menu-item-30 > a");
    private final By basket = By.cssSelector("#menu-item-29 > a");
    private final By checkout = By.cssSelector("#menu-item-31 > a");

    // Выпадающий список каталога в навигационном меню в header
    private final By catalogDropDownMenu = By.cssSelector("#menu-item-46 > .sub-menu");
    private final By householdAppliancesDropdownMenu = By.cssSelector("#menu-item-119 > .sub-menu");
    private final By electronicsDropdownMenu = By.cssSelector("#menu-item-47 > .sub-menu");

    private final By mainMenuHouseholdAppliancesSection = By.cssSelector("#menu-item-119 > a");
    private final By submenuFridgeSection = By.cssSelector("#menu-item-120 > a");
    private final By submenuWashingMachineSection = By.cssSelector("#menu-item-121 > a");

    private final By mainMenuElectronicsSection = By.cssSelector("#menu-item-47 > a");
    private final By submenuPhoneSection = By.cssSelector("#menu-item-114 > a");
    private final By submenuTabletSection = By.cssSelector("#menu-item-116 > a");
    private final By submenuTelevisionSection = By.cssSelector("#menu-item-118 > a");
    private final By submenuPhotoVideoSection = By.cssSelector("#menu-item-117 > a");
    private final By submenuWatchesSection = By.cssSelector("#menu-item-115 > a");

    private final By mainMenuBooksSection = By.cssSelector("#menu-item-180 > a");

    private final By mainMenuClothSection = By.cssSelector("#menu-item-48 > a");
    //------------------------------------GETTERS-----------------------------------------


    public By getContactPhone() {
        return contactPhone;
    }

    public By getContactEmail() {
        return contactEmail;
    }

    public By getSiteLogo() {
        return siteLogo;
    }

    public By getUserName() {
        return userName;
    }

    public By getSearchItemField() {
        return searchItemField;
    }

    public By getSearchItemButton() {
        return searchItemButton;
    }

    public By getLogin() {
        return login;
    }

    public By getLogout() {
        return logout;
    }

    public By getMainPage() {
        return mainPage;
    }

    public By getCatalog() {
        return catalog;
    }

    public By getMyAccount() {
        return myAccount;
    }

    public By getBasket() {
        return basket;
    }

    public By getCheckout() {
        return checkout;
    }

    public By getCatalogDropDownMenu() {
        return catalogDropDownMenu;
    }

    public By getHouseholdAppliancesDropdownMenu() {
        return householdAppliancesDropdownMenu;
    }

    public By getElectronicsDropdownMenu() {
        return electronicsDropdownMenu;
    }

    public By getMainMenuHouseholdAppliancesSection() {
        return mainMenuHouseholdAppliancesSection;
    }

    public By getSubmenuFridgeSection() {
        return submenuFridgeSection;
    }

    public By getSubmenuWashingMachineSection() {
        return submenuWashingMachineSection;
    }

    public By getMainMenuElectronicsSection() {
        return mainMenuElectronicsSection;
    }

    public By getSubmenuPhoneSection() {
        return submenuPhoneSection;
    }

    public By getSubmenuTabletSection() {
        return submenuTabletSection;
    }

    public By getSubmenuTelevisionSection() {
        return submenuTelevisionSection;
    }

    public By getSubmenuPhotoVideoSection() {
        return submenuPhotoVideoSection;
    }

    public By getSubmenuWatchesSection() {
        return submenuWatchesSection;
    }

    public By getMainMenuBooksSection() {
        return mainMenuBooksSection;
    }

    public By getMainMenuClothSection() {
        return mainMenuClothSection;
    }
}
