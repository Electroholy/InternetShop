package mainpage;

import org.openqa.selenium.By;

public class MainPageLocators {

    //--------------------------------------LOCATORS--------------------------------------
    // Верхний промо-раздел
    private final By promoBookSection = By.cssSelector("#accesspress_storemo-2 a");
    private final By promoTabletSection = By.cssSelector("#accesspress_storemo-3 a");
    private final By promoCameraSection = By.cssSelector("#accesspress_storemo-4 a");

    private final By promoBookSectionTitle = By.cssSelector("#accesspress_storemo-2 h4");
    private final By promoTabletSectionTitle = By.cssSelector("#accesspress_storemo-3 h4");
    private final By promoCameraSectionTitle = By.cssSelector("#accesspress_storemo-4 h4");

    private final By topPromoSectionThumbnails = By.cssSelector("#promo-section1 img");

    // Раздел "Распродажа"
    private final By saleSectionPreviousSlide = By.cssSelector("#accesspress_store_product-2 .slick-prev");
    private final By saleSectionNextSlide = By.cssSelector("#accesspress_store_product-2 .slick-next");

    private final By saleSectionAllThumbnailsLocator = By.cssSelector("#accesspress_store_product-2 .slick-track > li:not(.slick-cloned) img");

    private final By newArrivalsAndSaleSectionThumbnailsLocator = By.xpath("//li[contains(@class, 'slick-active')]/div//img");

    private By saleSectionItemTitle (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-2']//li[contains(@class, 'slick-active')]/a/h3)[" + itemNumber + "]");
    }
    private By saleSectionItem (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-2']//li[contains(@class, 'slick-active')]/div/a[1])[" + itemNumber + "]");
    }
    private By saleSectionThumbnail (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-2']//li[contains(@class, 'slick-active')]/div//img)["+ itemNumber +"]");
    }
    private By saleSectionItemNewPrice (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-2']//li[contains(@class, 'slick-active')]//ins//span[@class='woocommerce-Price-amount amount'])[" + itemNumber + "]");
    }
    private By saleSectionItemOldPrice (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-2']//li[contains(@class, 'slick-active')]//del//span[@class='woocommerce-Price-amount amount'])[" + itemNumber + "]");
    }
    private By saleSectionItemDescription (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-2']//li[contains(@class, 'slick-active')]//p)[" + itemNumber + "]");
    }
    private By saleSectionItemAddToCartButton (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-2']//li[contains(@class, 'slick-active')]/div/a[2])[" + itemNumber + "]");
    }

    // Нижний промо-раздел
    private final By bottomPromoSection = By.cssSelector("#promo-section2 a");
    private final By bottomPromoSectionButton = By.cssSelector("#promo-section2 .promo-link-btn");
    private final By bottomPromoSectionTitle = By.cssSelector("#promo-section2 h4");
    private final By bottomPromoSectionItemTitle = By.cssSelector("#promo-section2 .promo-desc-title");
    private final By bottomPromoSectionThumbnail = By.cssSelector("#promo-section2 img");

    // Раздел "Новые поступления"
    private final By newArrivalsSectionPreviousSlideButton = By.cssSelector("#accesspress_store_product-3 .slick-prev");
    private final By newArrivalsSectionNextSlideButton = By.cssSelector("#accesspress_store_product-3 .slick-next");
    private final By newArrivalsSectionAllThumbnailsSection = By.cssSelector("#accesspress_store_product-3 .slick-track > li:not(.slick-cloned) img");
    private By newArrivalsSectionItemTitle (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-3']//li[contains(@class, 'slick-active')]/a/h3)[" + itemNumber + "]");
    }
    private By newArrivalsSectionThumbnails (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-3']//li[contains(@class, 'slick-active')]/div/a[1]/img)[" + itemNumber + "]");
    }
    private By newArrivalsSectionItem (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-3']//li[contains(@class, 'slick-active')]/div/a[1])[" + itemNumber + "]");
    }
    private By newArrivalsSectionItemPrice(int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-3']//li[contains(@class, 'slick-active')]//span[@class='price']/span[@class='woocommerce-Price-amount amount'])[" + itemNumber + "]");
    }
    private By newArrivalsSectionItemNewPrice (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-3']//li[contains(@class, 'slick-active')]//ins//span[@class='woocommerce-Price-amount amount'])[" + itemNumber + "]");
    }
    private By newArrivalsSectionItemOldPrice (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-3']//li[contains(@class, 'slick-active')]//del//span[@class='woocommerce-Price-amount amount'])[" + itemNumber + "]");
    }
    private By newArrivalsSectionItemDescription (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-3']//li[contains(@class, 'slick-active')]//p)[" + itemNumber + "]");
    }
    private By newArrivalsSectionItemAddToCartButton (int itemNumber) {
        return By.xpath("(//*[@id='accesspress_store_product-3']//li[contains(@class, 'slick-active')]/div/a[2])[" + itemNumber + "]");
    }

    // Раздел "Недавно просмотренные товары"
    public final By recentlyViewedSectionItemThumbnailsLocator = By.xpath("//*[@id='woocommerce_recently_viewed_products-2']//li//img");
    private By recentlyViewedSectionItemTitle (int itemNumber) {
        return By.xpath("(//*[@id='woocommerce_recently_viewed_products-2']//li//span[@class='product-title'])[" + itemNumber + "]");
    }
    private By recentlyViewedSectionItemThumbnail (int itemNumber) {
        return By.xpath("(//*[@id='woocommerce_recently_viewed_products-2']//li//img)[" + itemNumber + "]");
    }
    private By recentlyViewedSectionItemPrice (int itemNumber) {
        return By.xpath("(//*[@id='woocommerce_recently_viewed_products-2']//li/span[@class='woocommerce-Price-amount amount']/bdi)[" + itemNumber + "]");
    }
    private By recentlyViewedSectionItemOldPrice (int itemNumber) {
        return By.xpath("(//*[@id='woocommerce_recently_viewed_products-2']//del//bdi)[" + itemNumber + "]");
    }
    private By recentlyViewedSectionItemNewPrice (int itemNumber) {
        return By.xpath("(//*[@id='woocommerce_recently_viewed_products-2']//ins//bdi)[" + itemNumber + "]");
    }

    // Маркировка товаров "Новый!" и "Скидка!"
    private By onSaleMark (int itemNumber) {
        return By.xpath("(//li[contains(@class, 'slick-active')]//span[contains(@class,'onsale')])[" + itemNumber + "]");
    }
    private By newItemMark (int itemNumber) {
        return By.xpath("(//li[contains(@class, 'slick-active')]//span[contains(@class,'label-new')])[" + itemNumber + "]");
    }
    private final By onSale = By.cssSelector(".onsale");
    private final By newItem = By.cssSelector(".label-new");

    //---------------------------------------GETTERS--------------------------------------------


    public By getOnSale() {
        return onSale;
    }

    public By getNewItem() {
        return newItem;
    }

    public By getBottomPromoSectionThumbnail() {
        return bottomPromoSectionThumbnail;
    }

    public By getTopPromoSectionThumbnails() {
        return topPromoSectionThumbnails;
    }

    public By getSaleSectionAllThumbnailsLocator() {
        return saleSectionAllThumbnailsLocator;
    }

    public By getNewArrivalsSectionAllThumbnailsSection() {
        return newArrivalsSectionAllThumbnailsSection;
    }

    public By getRecentlyViewedSectionItemThumbnailsLocator() {
        return recentlyViewedSectionItemThumbnailsLocator;
    }

    public By getPromoBookSection() {
        return promoBookSection;
    }

    public By getPromoTabletSection() {
        return promoTabletSection;
    }

    public By getPromoCameraSection() {
        return promoCameraSection;
    }

    public By getPromoBookSectionTitle() {
        return promoBookSectionTitle;
    }

    public By getPromoTabletSectionTitle() {
        return promoTabletSectionTitle;
    }

    public By getPromoCameraSectionTitle() {
        return promoCameraSectionTitle;
    }

    public By getSaleSectionPreviousSlide() {
        return saleSectionPreviousSlide;
    }

    public By getSaleSectionNextSlide() {
        return saleSectionNextSlide;
    }

    public By getBottomPromoSection() {
        return bottomPromoSection;
    }

    public By getBottomPromoSectionButton() {
        return bottomPromoSectionButton;
    }

    public By getBottomPromoSectionTitle() {
        return bottomPromoSectionTitle;
    }

    public By getBottomPromoSectionItemTitle() {
        return bottomPromoSectionItemTitle;
    }

    public By getNewArrivalsSectionPreviousSlideButton() {
        return newArrivalsSectionPreviousSlideButton;
    }

    public By getNewArrivalsSectionNextSlideButton() {
        return newArrivalsSectionNextSlideButton;
    }

    public By getNewArrivalsAndSaleSectionThumbnailsLocator() {
        return newArrivalsAndSaleSectionThumbnailsLocator;
    }

    public By getNewArrivalsSectionThumbnails (int itemNumber) {
        return newArrivalsSectionThumbnails(itemNumber);
    }

    public By getSaleSectionThumbnail (int itemNumber) {
        return saleSectionThumbnail(itemNumber);
    }

    public By getSaleSectionItemTitle (int itemNumber) {
        return saleSectionItemTitle(itemNumber);
    }

    public By getSaleSectionItem (int itemNumber) {
        return saleSectionItem(itemNumber);
    }

    public By getSaleSectionItemNewPrice (int itemNumber) {
        return saleSectionItemNewPrice(itemNumber);
    }

    public By getSaleSectionItemOldPrice (int itemNumber) {
        return saleSectionItemOldPrice(itemNumber);
    }

    public By getSaleSectionItemDescription (int itemNumber) {
        return saleSectionItemDescription(itemNumber);
    }

    public By getSaleSectionItemAddToCartButton (int itemNumber) {
        return saleSectionItemAddToCartButton(itemNumber);
    }

    public By getNewArrivalsSectionItemTitle (int itemNumber) {
        return newArrivalsSectionItemTitle(itemNumber);
    }

    public By getNewArrivalsSectionItem (int itemNumber) {
        return newArrivalsSectionItem(itemNumber);
    }

    public By getNewArrivalsSectionItemPrice (int itemNumber) {
        return newArrivalsSectionItemPrice(itemNumber);
    }

    public By getNewArrivalsSectionItemNewPrice (int itemNumber) {
        return newArrivalsSectionItemNewPrice(itemNumber);
    }

    public By getNewArrivalsSectionItemOldPrice (int itemNumber) {
        return newArrivalsSectionItemOldPrice(itemNumber);
    }

    public By getNewArrivalsSectionItemDescription (int itemNumber) {
        return newArrivalsSectionItemDescription(itemNumber);
    }

    public By getNewArrivalsSectionItemAddToCartButton (int itemNumber) {
        return newArrivalsSectionItemAddToCartButton(itemNumber);
    }

    public By getRecentlyViewedSectionItemTitle (int itemNumber) {
        return recentlyViewedSectionItemTitle(itemNumber);
    }

    public By getRecentlyViewedSectionItemThumbnail (int itemNumber) {
        return recentlyViewedSectionItemThumbnail(itemNumber);
    }

    public By getRecentlyViewedSectionItemPrice (int itemNumber) {
        return recentlyViewedSectionItemPrice(itemNumber);
    }

    public By getRecentlyViewedSectionItemOldPrice (int itemNumber) {
        return recentlyViewedSectionItemOldPrice(itemNumber);
    }

    public By getRecentlyViewedSectionItemNewPrice (int itemNumber) {
        return recentlyViewedSectionItemNewPrice(itemNumber);
    }

    public By getItemOnSaleMark (int itemNumber) {
        return onSaleMark(itemNumber);
    }

    public By getItemNewArrivalMark (int itemNumber) {
        return newItemMark(itemNumber);
    }
}