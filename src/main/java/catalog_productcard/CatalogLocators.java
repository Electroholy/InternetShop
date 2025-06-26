package catalog_productcard;

import org.openqa.selenium.By;

public class CatalogLocators {

    //-------------------------------------LOCATORS----------------------------------
    // Header раздела "Каталог"
    private final By currentCategoryTitle = By.cssSelector("#title_bread_wrap .entry-title");
    private final By breadcrumbCurrentSection = By.cssSelector(".accesspress-breadcrumb span");
    private By breadcrumbPreviousSection (int categoryNumber) {
        return By.xpath("//header[@id='title_bread_wrap']//a[" + categoryNumber + "]");
    }

    // Раздел "Категории товаров"
    private By itemCategory (int categoryNumber) {
        return By.xpath("(//ul[@class='product-categories']/li/a)[" + categoryNumber + "]");
    }
    private By itemCategoryCount (int categoryNumber) {
        return By.xpath("(//ul[@class='product-categories']/li/span)[" + categoryNumber + "]");
    }

    // Фильтр цены
    private final By priceFilterLeftSlider = By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all'][1]");
    private final By priceFilterRightSlider = By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all'][2]");
    private final By priceFilterApplyButton = By.cssSelector("button[type=submit]:not([class=searchsubmit])");
    private final By priceFilterFromResult = By.cssSelector(".from");
    private final By priceFilterToResult = By.cssSelector(".to");
    private final By priceFilterSliderRange = By.cssSelector(".ui-slider-range");

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

    // Элемент для сортировки товаров
    private final By sortingElement = By.cssSelector(".orderby");
    private final By sortByRegular = By.cssSelector(".orderby > [value='menu_order']");
    private final By sortByPopularity = By.cssSelector(".orderby > [value='popularity']");
    private final By sorByRating = By.cssSelector(".orderby > [value='rating']");
    private final By sortByDate = By.cssSelector(".orderby > [value='date']");
    private final By sortByAscending = By.cssSelector(".orderby > [value='price']");
    private final By sortByDescending = By.cssSelector(".orderby > [value='price-desc']");

    // Раздел товаров выбранной категории
    private final By categoryItemAmountDisplayed = By.cssSelector(".woocommerce-result-count");

    private By categoryItemThumbnail (int itemNumber) {
        return By.xpath("(//div[@class='inner-img']//img)[" + itemNumber + "]");
    }

    private final By categoryItemThumbnailLocator = By.cssSelector(".inner-img img");

    private By categoryItemTitle (int itemNumber) {
        return By.xpath("(//div[@class='collection_desc clearfix']//h3)[" + itemNumber + "]");
    }

    private final By allCategoryItemTitle = By.xpath("//div[@class='collection_desc clearfix']//h3");

    private By categoryItem (int itemNumber) {
        return By.xpath("(//div[@class='collection_desc clearfix']/a)[" + itemNumber + "]");
    }

    private By onSaleMark (int itemNumber) {
        return By.xpath("(//span[@class='onsale'])[" + itemNumber + "]");
    }

    private By categoryItemPrice (int itemNumber) {
        return By.xpath("(//span[@class='price']/span/bdi)[" + itemNumber + "]");
    }

    private final By allCategoryItemPrice = By.xpath("//span[@class='price']/span/bdi");

    private By categoryItemOldPrice (int itemNumber) {
        return By.xpath("(//ul[@class='products columns-4']//del//bdi)[" + itemNumber + "]");
    }

    private By categoryItemNewPrice (int itemNumber) {
        return By.xpath("(//ul[@class='products columns-4']//ins//bdi)[" + itemNumber + "]");
    }

    private By addToCartButton (int itemNumber) {
        return By.xpath("(//a[contains(@class, 'button') and contains(@class, 'product_type_simple')])[" + itemNumber + "]");
    }

    private By moreDetailsButton (int itemNumber) {
        return By.xpath("(//a[@class='added_to_cart wc-forward'])[" + itemNumber + "]");
    }

    private final By notFoundItemMessage = By.cssSelector("#primary .woocommerce-info");

    // Пагинация
    private final By previousPageArrowButton = By.cssSelector(".page-numbers.prev");
    private final By nextPageArrowButton = By.cssSelector(".page-numbers.next");
    private By ordinalPage (int ordinalNumber) {
        return By.xpath("(//a[@class='page-numbers'])[" + ordinalNumber + "]");
    }
    private final By lastPage = By.xpath("(//a[@class='page-numbers'])[last()]");

    //-------------------------------------------GETTERS-----------------------------------------------
    public By getProductsSectionItemThumbnailLocator() {
        return productsSectionItemThumbnailsLocator;
    }

    public By getAllCategoryItemTitle() {
        return allCategoryItemTitle;
    }

    public By getAllCategoryItemPrice() {
        return allCategoryItemPrice;
    }

    public By getPriceFilterSliderRange() {
        return priceFilterSliderRange;
    }

    public By getNotFoundItemMessage() {
        return notFoundItemMessage;
    }

    public By getCategoryItemThumbnailLocator() {
        return categoryItemThumbnailLocator;
    }

    public By getCurrentCategoryTitle() {
        return currentCategoryTitle;
    }

    public By getBreadcrumbCurrentSection() {
        return breadcrumbCurrentSection;
    }

    public By getPriceFilterLeftSlider() {
        return priceFilterLeftSlider;
    }

    public By getPriceFilterRightSlider() {
        return priceFilterRightSlider;
    }

    public By getPriceFilterApplyButton() {
        return priceFilterApplyButton;
    }

    public By getPriceFilterFromResult() {
        return priceFilterFromResult;
    }

    public By getPriceFilterToResult() {
        return priceFilterToResult;
    }

    public By getSortingElement() {
        return sortingElement;
    }

    public By getSortByRegular() {
        return sortByRegular;
    }

    public By getSortByPopularity() {
        return sortByPopularity;
    }

    public By getSorByRating() {
        return sorByRating;
    }

    public By getSortByDate() {
        return sortByDate;
    }

    public By getSortByAscending() {
        return sortByAscending;
    }

    public By getSortByDescending() {
        return sortByDescending;
    }

    public By getCategoryItemAmountDisplayed() {
        return categoryItemAmountDisplayed;
    }

    public By getPreviousPageArrowButton() {
        return previousPageArrowButton;
    }

    public By getNextPageArrowButton() {
        return nextPageArrowButton;
    }

    public By getLastPage() {
        return lastPage;
    }

    public By getBreadcrumbPreviousSection (int categoryNumber) {
        return breadcrumbPreviousSection(categoryNumber);
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

    public By getCategoryItemThumbnail (int itemNumber) {
        return categoryItemThumbnail(itemNumber);
    }

    public By getCategoryItemTitle (int itemNumber) {
        return categoryItemTitle(itemNumber);
    }

    public By getCategoryItem (int itemNumber) {
        return categoryItem(itemNumber);
    }

    public By getOnSaleMark (int itemNumber) {
        return onSaleMark(itemNumber);
    }

    public By getCategoryItemPrice (int itemNumber) {
        return categoryItemPrice(itemNumber);
    }

    public By getCategoryItemOldPrice (int itemNumber) {
        return categoryItemOldPrice(itemNumber);
    }

    public By getCategoryItemNewPrice (int itemNumber) {
        return categoryItemNewPrice(itemNumber);
    }

    public By getAddToCartButton (int itemNumber) {
        return addToCartButton(itemNumber);
    }

    public By getMoreDetailsButton (int itemNumber) {
        return moreDetailsButton(itemNumber);
    }

    public By getOrdinalPage (int pageNumber) {
        return ordinalPage(pageNumber);
    }
}