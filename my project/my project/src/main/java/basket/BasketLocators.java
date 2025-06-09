package basket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasketLocators {

    //-----------------------------------------LOCATORS-------------------------------------------

    // Элемент с сообщением об успешном завершении действия или ошибке
    private final By alertElement = By.cssSelector(".woocommerce-notices-wrapper");
    private final By alertElementBasketEmpty = By.cssSelector(".cart-empty");
    private final By cartForm = By.cssSelector(".woocommerce-cart-form");
    private final By cartInfo = By.cssSelector(".cart_totals");
    private final By loader = By.cssSelector(".processing");

    // Навигация в breadcrumb
    private final By breadcrumbCurrentSection = By.cssSelector("#accesspress-breadcrumb > .current");
    private By breadcrumbPreviousSections (int categoryNumber) {
        return By.xpath("(//div[@id='accesspress-breadcrumb']/a)[" + categoryNumber + "]");
    }

    // Корзина
    private By removeItemCrossButton (int itemNumber) {
        return By.xpath("(//*[@class='product-remove']/a)[" + itemNumber + "]");
    }

    private final By restoreDeletedItemButton = By.cssSelector(".restore-item");

    private By itemThumbnail (int itemNumber) {
        return By.xpath("(//*[@class='product-thumbnail']/a)[" + itemNumber + "]");
    }

    private final By itemThumbnailsLocator = By.xpath("//*[@class='product-thumbnail']//img");

    private By item (int itemNumber) {
        return By.xpath("(//*[@class='product-name']/a)[" + itemNumber + "]");
    }

    private By itemPrice (int itemNumber) {
        return By.xpath("(//*[@class='product-price']//bdi)[" + itemNumber + "]");
    }

    private By itemQuantity (int itemNumber) {
        return By.xpath("(//input[contains(@id, 'quantity')])[" + itemNumber + "]");
    }

    private By itemTotalPrice (int itemNumber) {
        return By.xpath("(//*[@class='product-subtotal']//bdi)[" + itemNumber + "]");
    }

    private final By cartTotalPrice = By.cssSelector(".cart_totals .order-total bdi");

    private final By couponDiscount = By.cssSelector(".cart-discount .amount");

    private By itemQuantityField (int itemNumber) {
        return By.xpath("(//*[contains(@id, 'quantity')])[" + itemNumber + "]");
    }

    private final By emptyElement = By.cssSelector(".product-remove");

    private final By couponField = By.cssSelector("#coupon_code");

    private final By applyCouponButton = By.cssSelector(".coupon > button");

    private final By removeCouponButton = By.cssSelector(".woocommerce-remove-coupon");

    private final By placeAnOrderButton = By.cssSelector(".checkout-button");

    private final By backToShopButton = By.cssSelector(".button.wc-backward");

    //-------------------------------------GETTERS---------------------------------------

    public By getLoader() {
        return loader;
    }

    public By getCartInfo() {
        return cartInfo;
    }

    public By getCartForm() {
        return cartForm;
    }

    public By getBackToShopButton() {
        return backToShopButton;
    }

    public By getAlertElement() {
        return alertElement;
    }

    public By getBreadcrumbCurrentSection() {
        return breadcrumbCurrentSection;
    }

    public By getBreadcrumbPreviousSections(int categoryNumber) {
        return breadcrumbPreviousSections(categoryNumber);
    }

    public By getRestoreDeletedItemButton() {
        return restoreDeletedItemButton;
    }

    public By getItemThumbnailsLocator() {
        return itemThumbnailsLocator;
    }

    public By getCartTotalPrice() {
        return cartTotalPrice;
    }

    public By getCouponDiscount() {
        return couponDiscount;
    }

    public By getEmptyElement() {
        return emptyElement;
    }

    public By getCouponField() {
        return couponField;
    }

    public By getApplyCouponButton() {
        return applyCouponButton;
    }

    public By getRemoveCouponButton() {
        return removeCouponButton;
    }

    public By getPlaceAnOrderButton() {
        return placeAnOrderButton;
    }

    public By getRemoveItemCrossButton (int itemNumber) {
        return removeItemCrossButton(itemNumber);
    }

    public By getItemThumbnail (int itemNumber) {
        return itemThumbnail(itemNumber);
    }

    public By getItem (int itemNumber) {
        return item(itemNumber);
    }

    public By getItemPrice (int itemNumber) {
        return itemPrice(itemNumber);
    }

    public By getItemQuantity (int itemNumber) {
        return itemQuantity(itemNumber);
    }

    public By getItemTotalPrice (int itemNumber) {
        return itemTotalPrice(itemNumber);
    }

    public By getItemQuantityField (int itemNumber) {
        return itemQuantityField(itemNumber);
    }

    public By getAlertElementBasketEmpty() {
        return alertElementBasketEmpty;
    }
}
