package myaccount;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount {

    private static final Log log = LogFactory.getLog(MyAccount.class);
    WebDriver driver;
    WebDriverWait wait;
    MyAccountLocators locators;

    public MyAccount (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.locators = new MyAccountLocators();
    }

    public String getItemQuantity (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemQuantity(itemNumber))).getText();
    }

    public String getItemPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemPrice(itemNumber))).getText();
    }

    public String getItemName (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemName(itemNumber))).getText();
    }

    public String getOrdersDetails (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrdersDetails(itemNumber))).getText();
    }

    public String getItemInOrderCount (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemInOrderCount(itemNumber))).getText();
    }

    public String getOrdersValue (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrdersValue(itemNumber))).getText();
    }

    public String getOrdersStatus (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrdersStatus(itemNumber))).getText();
    }

    public String getOrdersDate (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrdersDate(itemNumber))).getText();
    }

    public String getOrdersNumber (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrdersNumber(itemNumber))).getText();
    }

    public void navigateToBreadcrumbPreviousSections (int categoryNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBreadcrumbPreviousSections(categoryNumber))).click();
    }

    public void navigateToInformationSection() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getInformationSection())).click();
    }

    public void navigateToOrdersSection() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getOrdersSection())).click();
    }

    public void navigateToAccountDetailsSection() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getAccountDetailsSection())).click();
    }

    public void clickLogoutFromNavigationMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getLogoutFromNavigationMenu())).click();
    }

    public void clickLogoutFromInformationSection() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getLogoutFromInformationSection())).click();
    }

    public void navigateToOrdersSectionFromInformationSection() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getOrdersSectionLink())).click();
    }

    public void navigateToAccountDetailsSectionFromInformationSection() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getAccountDetailsLink())).click();
    }

    public String ordersDetails_getOrderNumberTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrderDetails_OrderNumberTitle())).getText();
    }

    public String orderDetails_GetOrderNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrderDetails_OrderNumber())).getText();
    }

    public String orderDetails_GetOrderDate() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrderDetails_OrderDate())).getText();
    }

    public String orderDetails_GetOrderStatus() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrderDetails_OrderStatus())).getText();
    }

    public String getOrderSubTotal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrderSubTotal())).getText();
    }

    public String getOrderTotal() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOrderTotal())).getText();
    }

    public String getPaymentMethod() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPaymentMethod())).getText();
    }

    public String getCustomerName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCustomerName())).getText();
    }

    public String getCustomerAddress() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCustomerAddress())).getText();
    }

    public String getCustomerCity() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCustomerCity())).getText();
    }

    public String getCustomerRegion() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCustomerRegion())).getText();
    }

    public String getCustomerPostalCode() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCustomerPostalCode())).getText();
    }

    public String getCustomerPhoneNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCustomerPhoneNumber())).getText();
    }

    public String getCustomerEmail() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCustomerEmail())).getText();
    }

    public void enterFirstName (String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getFirstNameField())).sendKeys(firstName);
    }

    public void enterLastName (String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getLastNameField())).sendKeys(lastName);
    }

    public void enterUsername (String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getUserNameField())).sendKeys(username);
    }

    public void enterEmail (String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getAccountEmailField())).sendKeys(email);
    }

    public void enterCurrentPassword (String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCurrentPasswordField())).sendKeys(password);
    }

    public void enterNewPassword (String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getNewPasswordField())).sendKeys(password);
    }

    public void enterOldPassword (String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOldPasswordField())).sendKeys(password);
    }

    public void clickSaveChangesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSaveChangesButton())).click();
    }

    public void clickShowCurrentPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getShowCurrentPassword())).click();
    }

    public void clickShowNewPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getShowNewPassword())).click();
    }

    public void clickShowOldPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getShowOldPassword())).click();
    }
}
