package basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basket {

    WebDriver driver;
    WebDriverWait wait;
    BasketLocators locators;

    public Basket (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.locators = new BasketLocators();
    }

    public void clickBackToShopButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBackToShopButton())).click();
    }

    public String getDeletedItemTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getAlertElement())).getText();
    }

    public String getBreadcrumbCurrentSectionTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getBreadcrumbCurrentSection())).getText();
    }

    public void navigateToBreadcrumbPreviousSection (int sectionNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBreadcrumbPreviousSections(sectionNumber))).click();
    }

    public void clickRestoreDeletedItem() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRestoreDeletedItemButton())).click();
    }

    public String getCartTotalPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCartTotalPrice())).getText();
    }

    public String getCouponAmountDiscount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCouponDiscount())).getText();
    }

    public void clickEmptyElement() {
        wait.until(ExpectedConditions.presenceOfElementLocated(locators.getEmptyElement())).click();
    }

    public void enterCouponCode (String code) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCouponField())).sendKeys(code);
    }

    public void clickApplyCoupon() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getApplyCouponButton())).click();
    }

    public void clickRemoveCoupon() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRemoveCouponButton())).click();
    }

    public void clickPlaceAnOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getPlaceAnOrderButton())).click();
    }

    public void clickRemoveItem (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRemoveItemCrossButton(itemNumber))).click();
    }

    public void navigateToItemByThumbnail (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getItemThumbnail(itemNumber))).click();
    }

    public void navigateToItemByName (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getItem(itemNumber))).click();
    }

    public String getItemTitle (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItem(itemNumber))).getText();
    }

    public String getItemPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemPrice(itemNumber))).getText();
    }

    public String getItemQuantity (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemQuantity(itemNumber))).getAttribute("value");
    }

    public String getItemTotalPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemTotalPrice(itemNumber))).getText();
    }

    public void enterItemQuantity (int itemNumber, String quantity) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemQuantityField(itemNumber))).clear();
        driver.findElement(locators.getItemQuantityField(itemNumber)).sendKeys(quantity);
    }

    public WebElement pageThumbnailsImage() {
        return driver.findElement(locators.getItemThumbnailsLocator());
    }
}
