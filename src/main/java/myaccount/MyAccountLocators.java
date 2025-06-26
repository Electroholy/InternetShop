package myaccount;

import org.openqa.selenium.By;

public class MyAccountLocators {

    //-------------------------------------------LOCATORS-------------------------------------------------

    // Навигация в breadcrumb
    private final By breadcrumbCurrentSection = By.cssSelector("#accesspress-breadcrumb > .current");
    private By breadcrumbPreviousSections (int categoryNumber) {
        return By.xpath("(//div[@id='accesspress-breadcrumb']/a)[" + categoryNumber + "]");
    }

    private final By informationSection = By.xpath("(//nav/ul/li/a)[1]");
    private final By ordersSection = By.xpath("(//nav/ul/li/a)[2]");
    private final By accountDetailsSection = By.xpath("(//nav/ul/li/a)[3]");
    private final By logoutFromNavigationMenu = By.xpath("(//nav/ul/li/a)[4]");
    // Раздел "Информация"
    private final By logoutFromInformationSection = By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]/a");
    private final By ordersSectionLink = By.xpath("//div[@class='woocommerce-MyAccount-content']/p[2]/a[1]");
    private final By accountDetailsLink = By.xpath("//div[@class='woocommerce-MyAccount-content']/p[2]/a[2]");
    // Раздел "Заказы"
    private By ordersNumber (int order) {
        return By.xpath("(//table//tr/td[1]/a)[" + order + "]");
    }
    private By ordersDate (int order) {
        return By.xpath("(//table//tr/td[2]/time)[" + order + "]");
    }
    private By ordersStatus (int order) {
        return By.xpath("(//table//tr/td[3])[" + order + "]");
    }
    private By ordersValue (int order) {
        return By.xpath("(//table//tr/td[4]/span)[" + order + "]");
    }
    private By itemInOrderCount (int order) {
        return By.xpath("(//table//tr/td[4])[" + order + "]");
    }
    private By ordersDetails (int order) {
        return By.xpath("(//table//tr/td[5]/a)[" + order + "]");
    }
    // Информация о заказе
    private final By orderDetails_OrderNumberTitle = By.cssSelector(".post-title");
    private final By orderDetails_OrderNumber = By.cssSelector(".order-number");
    private final By orderDetails_OrderDate = By.cssSelector(".order-date");
    private final By orderDetails_OrderStatus = By.cssSelector(".order-status");

    private By itemName (int itemNumber) {
        return By.xpath("(//section[@class='woocommerce-order-details']//tr/td[1]/a)[" + itemNumber + "]");
    }
    private By itemPrice (int itemNumber) {
        return By.xpath("(//section[@class='woocommerce-order-details']//tr/td[2]//bdi)[" + itemNumber + "]");
    }
    private By itemQuantity (int itemNumber) {
        return By.xpath("(//strong[@class='product-quantity'])[" + itemNumber + "]");
    }
    private final By orderSubTotal = By.xpath("(//tfoot//td/span)[1]");
    private final By orderTotal = By.xpath("(//tfoot//td/span)[2]");
    private final By paymentMethod = By.xpath("(//tfoot//td)[2]");

    private final By customerName = By.xpath("//address");
    private final By customerAddress = By.xpath("//address/br[1]");
    private final By customerCity = By.xpath("//address/br[2]");
    private final By customerRegion = By.xpath("//address/br[3]");
    private final By customerPostalCode = By.xpath("//address/br[4]");
    private final By customerPhoneNumber = By.xpath("//address/p[1]");
    private final By customerEmail = By.xpath("//address/p[2]");
    // Раздел "Данные аккаунта"
    private final By firstNameField = By.cssSelector("input#account_first_name");
    private final By lastNameField = By.cssSelector("input#account_last_name");
    private final By userNameField = By.cssSelector("input#account_display_name");
    private final By accountEmailField = By.cssSelector("input#account_email");
    private final By currentPasswordField = By.cssSelector("input#password_current");
    private final By newPasswordField = By.cssSelector("input#password_1");
    private final By oldPasswordField = By.cssSelector("input#password_2");
    private final By saveChangesButton = By.cssSelector("button[value='Save changes']");
    private final By showCurrentPassword = By.xpath("(//span[@class='show-password-input'])[1]");
    private final By showNewPassword = By.xpath("(//span[@class='show-password-input'])[2]");
    private final By showOldPassword = By.xpath("(//span[@class='show-password-input'])[3]");

    //------------------------------------------GETTERS----------------------------------------------------

    public By getItemQuantity (int itemNumber) {
        return itemQuantity(itemNumber);
    }

    public By getItemPrice (int itemNumber) {
        return itemPrice(itemNumber);
    }

    public By getItemName (int itemNumber) {
        return itemName(itemNumber);
    }

    public By getOrdersDetails (int order) {
        return ordersDetails(order);
    }

    public By getItemInOrderCount (int order) {
        return itemInOrderCount(order);
    }

    public By getOrdersValue (int order) {
        return ordersValue(order);
    }

    public By getOrdersStatus (int order) {
        return ordersStatus(order);
    }

    public By getOrdersDate (int order) {
        return ordersDate(order);
    }

    public By getOrdersNumber (int order) {
        return ordersNumber(order);
    }

    public By getBreadcrumbPreviousSections (int categoryNumber) {
        return breadcrumbPreviousSections(categoryNumber);
    }

    public By getBreadcrumbCurrentSection() {
        return breadcrumbCurrentSection;
    }

    public By getInformationSection() {
        return informationSection;
    }

    public By getOrdersSection() {
        return ordersSection;
    }

    public By getAccountDetailsSection() {
        return accountDetailsSection;
    }

    public By getLogoutFromNavigationMenu() {
        return logoutFromNavigationMenu;
    }

    public By getLogoutFromInformationSection() {
        return logoutFromInformationSection;
    }

    public By getOrdersSectionLink() {
        return ordersSectionLink;
    }

    public By getAccountDetailsLink() {
        return accountDetailsLink;
    }

    public By getOrderDetails_OrderNumberTitle() {
        return orderDetails_OrderNumberTitle;
    }

    public By getOrderDetails_OrderNumber() {
        return orderDetails_OrderNumber;
    }

    public By getOrderDetails_OrderDate() {
        return orderDetails_OrderDate;
    }

    public By getOrderDetails_OrderStatus() {
        return orderDetails_OrderStatus;
    }

    public By getOrderSubTotal() {
        return orderSubTotal;
    }

    public By getOrderTotal() {
        return orderTotal;
    }

    public By getPaymentMethod() {
        return paymentMethod;
    }

    public By getCustomerName() {
        return customerName;
    }

    public By getCustomerAddress() {
        return customerAddress;
    }

    public By getCustomerCity() {
        return customerCity;
    }

    public By getCustomerRegion() {
        return customerRegion;
    }

    public By getCustomerPostalCode() {
        return customerPostalCode;
    }

    public By getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public By getCustomerEmail() {
        return customerEmail;
    }

    public By getFirstNameField() {
        return firstNameField;
    }

    public By getLastNameField() {
        return lastNameField;
    }

    public By getUserNameField() {
        return userNameField;
    }

    public By getAccountEmailField() {
        return accountEmailField;
    }

    public By getCurrentPasswordField() {
        return currentPasswordField;
    }

    public By getNewPasswordField() {
        return newPasswordField;
    }

    public By getOldPasswordField() {
        return oldPasswordField;
    }

    public By getSaveChangesButton() {
        return saveChangesButton;
    }

    public By getShowCurrentPassword() {
        return showCurrentPassword;
    }

    public By getShowNewPassword() {
        return showNewPassword;
    }

    public By getShowOldPassword() {
        return showOldPassword;
    }
}