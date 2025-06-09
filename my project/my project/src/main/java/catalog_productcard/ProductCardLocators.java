package catalog_productcard;

import org.openqa.selenium.By;

public class ProductCardLocators {

    //-------------------------------------------LOCATORS-----------------------------------------------
    // Header
    private final By currentCategoryTitle = By.cssSelector("#title_bread_wrap .entry-title");
    private final By breadcrumbCurrentSection = By.cssSelector(".accesspress-breadcrumb span");
    private By breadcrumbPreviousSection (int categoryNumber) {
        return By.xpath("//header[@id='title_bread_wrap']//a[" + categoryNumber + "]");
    }

    // Карточка товара
    private final By itemTitle = By.cssSelector("#primary h1");
    private final By itemPrice = By.cssSelector(".summary bdi");
    private final By itemOldPrice = By.cssSelector(".summary del bdi");
    private final By itemNewPrice = By.cssSelector(".summary ins bdi");
    private final By itemThumbnail = By.xpath("//img[@class='wp-post-image']");

    private final By openItemImageButton = By.cssSelector("a.woocommerce-product-gallery__trigger");
    private final By itemImage = By.cssSelector("img.pswp__img");
    private final By imageZoomButton = By.cssSelector(".pswp__button--zoom");
    private final By openItemImageFullscreenButton = By.cssSelector(".pswp__button--fs");
    private final By itemImageCloseButton = By.cssSelector(".pswp__button--close");

    private final By itemQuantityField = By.cssSelector("input.input-text");
    private final By itemAddToCartButton = By.cssSelector("button[name = add-to-cart]");

    private final By alertElement = By.cssSelector(".woocommerce-message");
    private final By navigateToCartButton = By.cssSelector(".woocommerce-message > a");

    private final By descriptionSection = By.cssSelector("#tab-title-description > a");
    private final By reviewSection = By.cssSelector("#tab-title-reviews > a");
    private final By descriptionSectionTabPanel = By.cssSelector("#tab-description");
    private final By reviewSectionTabPanel = By.cssSelector("#tab-description");

    // Раздел сопутствующие товары
    private final By relatedProductsSectionItemThumbnailsLocator = By.xpath("//div[@class='inner-img']//img");

    private By relatedProductsSectionItemTitle (int itemNumber) {
        return By.xpath("(//a[@class='collection_title']/h3)[" + itemNumber + "]");
    }

    private By relatedProductsSectionItemPrice (int itemNumber) {
        return By.xpath("(//span[@class='price']/span/bdi)[" + itemNumber + "]");
    }

    private By relatedProductsSectionOldPrice (int itemNumber) {
        return By.xpath("(//span[@class='price']/del//bdi)[" + itemNumber + "]");
    }

    private By relatedProductsSectionNewPrice (int itemNumber) {
        return By.xpath("(//span[@class='price']/ins//bdi)[" + itemNumber + "]");
    }

    private By relatedProductsSectionItem (int itemNumber) {
        return By.xpath("(//div[@class='collection_desc clearfix']/a)[" + itemNumber + "]");
    }

    private By relatedProductsSectionItemThumbnail (int itemNumber) {
        return By.xpath("(//div[@class='inner-img']//img)[" + itemNumber + "]");
    }

    private By relatedProductsSectionItemAddToCart (int itemNumber) {
        return By.xpath("(//a[contains(@class, 'button') and contains(@class, 'product_type_simple')])[" + itemNumber + "]");
    }

    private By relatedProductsMoreDetailsButton (int itemNumber) {
        return By.xpath("(//a[@class='added_to_cart wc-forward'])[" + itemNumber + "]");
    }

    private By onSaleMark (int itemNumber) {
        return By.xpath("(//span[@class='onsale'])[" + itemNumber + "]");
    }

    // Раздел "Категории товаров"
    private By itemCategory (int categoryNumber) {
        return By.xpath("(//ul[@class='product-categories']/li/a)[" + categoryNumber + "]");
    }
    private By itemCategoryCount (int categoryNumber) {
        return By.xpath("(//ul[@class='product-categories']/li/span)[" + categoryNumber + "]");
    }

    // Раздел "Товары"
    private final By productsSectionItemThumbnailsLocator = By.xpath("//ul[@class='product_list_widget']//img");

    private By productsSectionItem (int itemNumber) {
        return By.xpath("(//ul[@class='product_list_widget']//a)[" + itemNumber + "]");
    }

    private By productsSectionItemTitle (int itemNumber) {
        return By.xpath("(//span[@class='product-title'])[" + itemNumber + "]");
    }

    private By productsSectionItemThumbnail (int itemNumber) {
        return By.xpath("(//ul[@class='product_list_widget']//img)[" + itemNumber + "]");
    }

    private By productsSectionItemPrice (int itemNumber) {
        return By.xpath("(//li/span[@class='woocommerce-Price-amount amount']/bdi)[" + itemNumber + "]");
    }

    private By productsSectionItemOldPrice (int itemNumber) {
        return By.xpath("(//ul[@class='product_list_widget']//del//bdi)[" + itemNumber + "]");
    }

    private By productsSectionItemNewPrice (int itemNumber) {
        return By.xpath("(//ul[@class='product_list_widget']//ins//bdi)[" + itemNumber + "]");
    }

    //-------------------------------------------GETTERS-----------------------------------------------
    public By getProductsSectionItemThumbnailsLocator() {
        return productsSectionItemThumbnailsLocator;
    }

    public By getRelatedProductsSectionItemThumbnailsLocator() {
        return relatedProductsSectionItemThumbnailsLocator;
    }

    public By getCurrentCategoryTitle() {
        return currentCategoryTitle;
    }

    public By getBreadcrumbCurrentSection() {
        return breadcrumbCurrentSection;
    }

    public By getItemTitle() {
        return itemTitle;
    }

    public By getItemPrice() {
        return itemPrice;
    }

    public By getItemOldPrice() {
        return itemOldPrice;
    }

    public By getItemNewPrice() {
        return itemNewPrice;
    }

    public By getItemThumbnail() {
        return itemThumbnail;
    }

    public By getOpenItemImageButton() {
        return openItemImageButton;
    }

    public By getItemImage() {
        return itemImage;
    }

    public By getImageZoomButton() {
        return imageZoomButton;
    }

    public By getOpenItemImageFullscreenButton() {
        return openItemImageFullscreenButton;
    }

    public By getItemImageCloseButton() {
        return itemImageCloseButton;
    }

    public By getItemQuantityField() {
        return itemQuantityField;
    }

    public By getItemAddToCartButton() {
        return itemAddToCartButton;
    }

    public By getAlertElement() {
        return alertElement;
    }

    public By getNavigateToCartButton() {
        return navigateToCartButton;
    }

    public By getDescriptionSection() {
        return descriptionSection;
    }

    public By getReviewSection() {
        return reviewSection;
    }

    public By getDescriptionSectionTabPanel() {
        return descriptionSectionTabPanel;
    }

    public By getReviewSectionTabPanel() {
        return reviewSectionTabPanel;
    }

    public By getBreadcrumbPreviousSection (int categoryNumber) {
        return breadcrumbPreviousSection(categoryNumber);
    }

    public By getOnSaleMark (int itemNumber) {
        return onSaleMark(itemNumber);
    }

    public By getItemCategory (int category) {
        return itemCategory(category);
    }

    public By getItemCategoryCount (int category) {
        return itemCategoryCount(category);
    }

    public By getProductsSectionItem (int itemNumber) {
        return productsSectionItem(itemNumber);
    }

    public By getProductsSectionItemTitle (int itemNumber) {
        return productsSectionItemTitle(itemNumber);
    }

    public By getProductsSectionItemThumbnail (int itemNumber) {
        return productsSectionItemThumbnail(itemNumber);
    }

    public By getProductsSectionItemPrice (int itemNumber) {
        return productsSectionItemPrice(itemNumber);
    }

    public By getProductsSectionItemOldPrice (int itemNumber) {
        return productsSectionItemOldPrice(itemNumber);
    }

    public By getProductsSectionItemNewPrice (int itemNumber) {
        return productsSectionItemNewPrice(itemNumber);
    }

    public By getRelatedProductsSectionItemTitle (int itemNumber) {
        return relatedProductsSectionItemTitle(itemNumber);
    }

    public By getRelatedProductsSectionItemPrice (int itemNumber) {
        return relatedProductsSectionItemPrice(itemNumber);
    }

    public By getRelatedProductsSectionOldPrice (int itemNumber) {
        return relatedProductsSectionOldPrice(itemNumber);
    }

    public By getRelatedProductsSectionNewPrice (int itemNumber) {
        return relatedProductsSectionNewPrice(itemNumber);
    }

    public By getRelatedProductsSectionItem (int itemNumber) {
        return relatedProductsSectionItem(itemNumber);
    }

    public By getRelatedProductsSectionItemThumbnail (int itemNumber) {
        return relatedProductsSectionItemThumbnail(itemNumber);
    }

    public By getRelatedProductsSectionItemAddToCart (int itemNumber) {
        return relatedProductsSectionItemAddToCart(itemNumber);
    }

    public By getRelatedProductsMoreDetailsButton (int itemNumber) {
        return relatedProductsMoreDetailsButton(itemNumber);
    }
}