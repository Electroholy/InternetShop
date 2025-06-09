package checkout;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {

    private static final Log log = LogFactory.getLog(Checkout.class);
    WebDriver driver;
    WebDriverWait wait;
    CheckoutLocators locators;

    public Checkout (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.locators = new CheckoutLocators();
    }

    public void waitLoadersInvisibility() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locators.getFirstLoader()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locators.getSecondLoader()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locators.getThirdLoader()));
    }

    public String getBreadcrumbCurrentSectionTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getBreadcrumbCurrentSection())).getText();
    }

    public void openEnterCouponForm() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getNavigateToEnterCoupon())).click();
    }

    public void enterCoupon (String code) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getEnterCouponField())).sendKeys(code);
    }

    public void clickApplyCoupon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getApplyCouponButton())).click();
    }

    public String getUnsuccessfulApplyCouponMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getUnsuccessfulApplyCouponMessage())).getText();
    }

    public String getSuccessfulApplyCouponMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getSuccessfulApplyCouponMessage())).getText();
    }

    public void removeCoupon() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRemoveCouponButton())).click();
    }

    public void enterFirstName (String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getFirstnameField())).clear();
        driver.findElement(locators.getFirstnameField()).sendKeys(firstName);
    }

    public void enterLastName (String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getLastnameField())).clear();
        driver.findElement(locators.getLastnameField()).sendKeys(lastName);
    }

    public void enterAddress (String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getAddressField())).clear();
        driver.findElement(locators.getAddressField()).sendKeys(address);
    }

    public void enterCity (String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCityField())).clear();
        driver.findElement(locators.getCityField()).sendKeys(city);
    }

    public void enterRegion (String region) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRegionField())).clear();
        driver.findElement(locators.getRegionField()).sendKeys(region);
    }

    public void enterPostalCode (String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPostalCodeField())).clear();
        driver.findElement(locators.getPostalCodeField()).sendKeys(postalCode);
    }

    public void enterPhone (String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPhoneField())).clear();
        driver.findElement(locators.getPhoneField()).sendKeys(phone);
    }

    public void enterEmail (String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getEmailField())).clear();
        driver.findElement(locators.getEmailField()).sendKeys(email);
    }

    public void enterComment (String comment) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCommentsField())).clear();
        driver.findElement(locators.getCommentsField()).sendKeys(comment);
    }

    public String getMissingFirstnameMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getMissingFirstnameMessage())).getText();
    }

    public String getMissingLastnameMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getMissingLastnameMessage())).getText();
    }

    public String getMissingAddressMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getMissingAddressMessage())).getText();
    }

    public String getMissingCityMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getMissingCityMessage())).getText();
    }

    public String getMissingRegionMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getMissingRegionMessage())).getText();
    }

    public String getMissingPostalCodeMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getMissingPostalCodeMessage())).getText();
    }

    public String getMissingPhoneMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getMissingPhoneMessage())).getText();
    }

    public String getMissingEmailMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getMissingEmailMessage())).getText();
    }

    public void clickBankTransferRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBankTransferRadioButton())).click();
    }

    public void clickCashPaymentRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getCashPaymentRadioButton())).click();
    }

    public void clickPlaceAnOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getPlaceAnOrderButton())).click();
    }

    public void navigateToBreadcrumbPreviousSection (int categoryNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBreadcrumbPreviousSections(categoryNumber))).click();
    }

    public String getOrderTotalPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrderTotalPrice())).getText();
    }

    public String getOrderDiscount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrderDiscount())).getText();
    }

    public String getOrderFinalPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrderFinalPrice())).getText();
    }

    public String getItemName (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemName(itemNumber))).getText();
    }

    public String getItemPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemPrice(itemNumber))).getText();
    }

    public WebElement couponDropDownMenu() {
        return driver.findElement(locators.getDropdownMenu());
    }

    public WebElement checkoutForm() {
        return driver.findElement(locators.getCheckoutForm());
    }
}
