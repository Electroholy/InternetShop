package checkout;

import org.openqa.selenium.By;

public class CheckoutLocators {

    //------------------------------------LOCATORS--------------------------------------------

    // Навигация в breadcrumb
    private final By breadcrumbCurrentSection = By.cssSelector("#accesspress-breadcrumb > .current");
    private By breadcrumbPreviousSections (int categoryNumber) {
        return By.xpath("(//div[@id='accesspress-breadcrumb']/a)[" + categoryNumber + "]");
    }

    // Локатор формы оформления заказа
    private final By checkoutForm = By.cssSelector(".checkout>#customer_details");

    // Страница оформления заказа без авторизации
    private final By authorizationFormLink = By.cssSelector("a.showlogin");

    // Ввод купона на странице оформления заказа
    private final By navigateToEnterCoupon = By.cssSelector(".showcoupon");
    private final By dropdownMenu = By.cssSelector(".checkout_coupon");
    private final By enterCouponField = By.cssSelector("input#coupon_code");
    private final By applyCouponButton = By.cssSelector(".checkout_coupon .button");
    private final By unsuccessfulApplyCouponMessage = By.cssSelector("ul.woocommerce-error>li");
    private final By successfulApplyCouponMessage = By.cssSelector("div.woocommerce-message");
    private final By removeCouponButton = By.cssSelector(".woocommerce-remove-coupon");

    // Поля для ввода
    private final By firstnameField = By.cssSelector("input#billing_first_name");
    private final By lastnameField = By.cssSelector("input#billing_last_name");
    private final By addressField = By.cssSelector("input#billing_address_1");
    private final By cityField = By.cssSelector("input#billing_city");
    private final By regionField = By.cssSelector("input#billing_state");
    private final By postalCodeField = By.cssSelector("input#billing_postcode");
    private final By phoneField = By.cssSelector("input#billing_phone");
    private final By emailField = By.cssSelector("input#billing_email");
    private final By commentsField = By.cssSelector("textarea#order_comments");

    // Сообщения об ошибках (например не заполнено обязательное поле)
    private final By alertElement = By.cssSelector(".woocommerce-error");
    private final By missingFirstnameMessage = By.cssSelector(".woocommerce-error>[data-id='billing_first_name']");
    private final By missingLastnameMessage = By.cssSelector(".woocommerce-error>[data-id='billing_last_name']");
    private final By missingAddressMessage = By.cssSelector(".woocommerce-error>[data-id='billing_address_1']");
    private final By missingCityMessage = By.cssSelector(".woocommerce-error>[data-id='billing_city']");
    private final By missingRegionMessage = By.cssSelector(".woocommerce-error>[data-id='billing_state']");
    private final By missingPostalCodeMessage = By.cssSelector(".woocommerce-error>[data-id='billing_postcode']");
    private final By missingPhoneMessage = By.xpath("//li[@data-id='billing_phone'][.//strong]");
    private final By invalidPhoneFormatMessage = By.xpath("//li[@data-id='billing_phone'][not(.//strong)]");
    private final By missingEmailMessage = By.cssSelector(".woocommerce-error>[data-id='billing_email']");
    private final By invalidEmailMessage = By.xpath("//ul[contains(@class, 'woocommerce-error') and count(li) = 1]");

    // Радио-кнопки о способе оплаты и оформить заказ
    private final By bankTransferRadioButton = By.cssSelector("#payment_method_bacs");
    private final By cashPaymentRadioButton = By.cssSelector("#payment_method_cod");
    private final By placeAnOrderButton = By.cssSelector("#place_order");

    // Окно с информацией о заказе
    private By itemName (int itemNumber) {
        return By.xpath("(//td[@class='product-name'])[" + itemNumber + "]");
    }
    private By itemPrice (int itemNumber) {
        return By.xpath("(//td[@class='product-total']//bdi)[" + itemNumber + "]");
    }
    private final By orderTotalPrice = By.cssSelector(".cart-subtotal bdi");
    private final By orderDiscount = By.cssSelector(".cart-discount .amount");
    private final By orderFinalPrice = By.cssSelector(".order-total bdi");

    // Loaders
    private final By firstLoader = By.cssSelector(".blockUI");
    private final By secondLoader = By.cssSelector(".blockUI.blockOverlay");
    private final By thirdLoader = By.cssSelector(".blockUI.blockMsg.blockElement");

    // Окно с информацией об успешном создании заказа
    private final By orderReceivedMessage = By.cssSelector("#post-24 h2");
    private final By orderNumber = By.cssSelector(".order > strong");
    private final By orderDate = By.cssSelector(".date > strong");
    private final By orderEmail = By.cssSelector(".email > strong");
    private final By orderPrice = By.cssSelector(".total > strong");
    private final By orderPaymentMethod = By.cssSelector(".method > strong");

    //-----------------------------------------GETTERS--------------------------------------------------

    public By getInvalidEmailMessage() {
        return invalidEmailMessage;
    }

    public By getOrderReceivedMessage() {
        return orderReceivedMessage;
    }

    public By getOrderNumber() {
        return orderNumber;
    }

    public By getOrderDate() {
        return orderDate;
    }

    public By getOrderEmail() {
        return orderEmail;
    }

    public By getOrderPrice() {
        return orderPrice;
    }

    public By getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    public By getInvalidPhoneFormatMessage() {
        return invalidPhoneFormatMessage;
    }

    public By getFirstLoader() {
        return firstLoader;
    }

    public By getSecondLoader() {
        return secondLoader;
    }

    public By getThirdLoader() {
        return thirdLoader;
    }

    public By getAlertElement() {
        return alertElement;
    }

    public By getAuthorizationFormLink() {
        return authorizationFormLink;
    }

    public By getBreadcrumbCurrentSection() {
        return breadcrumbCurrentSection;
    }

    public By getCheckoutForm() {
        return checkoutForm;
    }

    public By getNavigateToEnterCoupon() {
        return navigateToEnterCoupon;
    }

    public By getDropdownMenu() {
        return dropdownMenu;
    }

    public By getEnterCouponField() {
        return enterCouponField;
    }

    public By getApplyCouponButton() {
        return applyCouponButton;
    }

    public By getUnsuccessfulApplyCouponMessage() {
        return unsuccessfulApplyCouponMessage;
    }

    public By getSuccessfulApplyCouponMessage() {
        return successfulApplyCouponMessage;
    }

    public By getRemoveCouponButton() {
        return removeCouponButton;
    }

    public By getFirstnameField() {
        return firstnameField;
    }

    public By getLastnameField() {
        return lastnameField;
    }

    public By getAddressField() {
        return addressField;
    }

    public By getCityField() {
        return cityField;
    }

    public By getRegionField() {
        return regionField;
    }

    public By getPostalCodeField() {
        return postalCodeField;
    }

    public By getPhoneField() {
        return phoneField;
    }

    public By getEmailField() {
        return emailField;
    }

    public By getCommentsField() {
        return commentsField;
    }

    public By getMissingFirstnameMessage() {
        return missingFirstnameMessage;
    }

    public By getMissingLastnameMessage() {
        return missingLastnameMessage;
    }

    public By getMissingAddressMessage() {
        return missingAddressMessage;
    }

    public By getMissingCityMessage() {
        return missingCityMessage;
    }

    public By getMissingRegionMessage() {
        return missingRegionMessage;
    }

    public By getMissingPostalCodeMessage() {
        return missingPostalCodeMessage;
    }

    public By getMissingPhoneMessage() {
        return missingPhoneMessage;
    }

    public By getMissingEmailMessage() {
        return missingEmailMessage;
    }

    public By getBankTransferRadioButton() {
        return bankTransferRadioButton;
    }

    public By getCashPaymentRadioButton() {
        return cashPaymentRadioButton;
    }

    public By getPlaceAnOrderButton() {
        return placeAnOrderButton;
    }

    public By getBreadcrumbPreviousSections (int categoryNumber) {
        return breadcrumbPreviousSections(categoryNumber);
    }

    public By getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public By getOrderDiscount() {
        return orderDiscount;
    }

    public By getOrderFinalPrice() {
        return orderFinalPrice;
    }

    public By getItemName (int itemNumber) {
        return itemName(itemNumber);
    }

    public By getItemPrice (int itemNumber) {
        return itemPrice(itemNumber);
    }
}
