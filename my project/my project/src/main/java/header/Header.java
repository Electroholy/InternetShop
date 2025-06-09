package header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HeaderLocators locators;

    public Header (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.locators = new HeaderLocators();
    }

    public String getContactPhone() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getContactPhone())).getText();
    }

    public String getContactEmail() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getContactEmail())).getText();
    }

    public void clickSiteLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSiteLogo())).click();
    }

    public void navigateToMyAccountByUsername() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getUserName())).click();
    }

    public void enterItemName_SearchField (String itemName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getSearchItemField())).sendKeys(itemName);
    }

    public void clickSearchItem() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSearchItemButton())).click();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getLogin())).click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getLogout())).click();
    }

    public void navigateToMainPage() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getMainPage())).click();
    }

    public void navigateToCatalog() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getCatalog())).click();
    }

    public void navigateToMyAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getMyAccount())).click();
    }

    public void navigateToBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBasket())).click();
    }

    public void navigateToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getCheckout())).click();
    }

    public WebElement catalogDropDownMenu() {
        return driver.findElement(locators.getCatalogDropDownMenu());
    }

    public WebElement householdAppliancesDropdownMenu() {
        return driver.findElement(locators.getHouseholdAppliancesDropdownMenu());
    }

    public WebElement electronicsDropdownMenu() {
        return driver.findElement(locators.getElectronicsDropdownMenu());
    }

    public void navigateToHouseholdAppliancesCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getMainMenuHouseholdAppliancesSection())).click();
    }

    public void navigateToFridgeCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSubmenuFridgeSection())).click();
    }

    public void navigateToWashingMachineCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSubmenuWashingMachineSection())).click();
    }

    public void navigateToElectronicCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getMainMenuElectronicsSection())).click();
    }

    public void navigateToPhoneCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSubmenuPhoneSection())).click();
    }

    public void navigateToTabletCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSubmenuTabletSection())).click();
    }

    public void navigateToTelevisionCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSubmenuTelevisionSection())).click();
    }

    public void navigateToCameraCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSubmenuPhotoVideoSection())).click();
    }

    public void navigateToWatchesCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSubmenuWatchesSection())).click();
    }

    public void navigateToBooksCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getMainMenuBooksSection())).click();
    }

    public void navigateToClothCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getMainMenuClothSection())).click();
    }
}
