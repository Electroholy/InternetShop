package catalog_productcard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCard {

    WebDriver driver;
    WebDriverWait wait;
    ProductCardLocators locators;

    public ProductCard(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.locators = new ProductCardLocators();
    }

    public WebElement productsSectionItemThumbnailsLocators() {
        return driver.findElement(locators.getProductsSectionItemThumbnailsLocator());
    }

    public WebElement relatedProductsSectionItemThumbnailsLocators() {
        return driver.findElement(locators.getRelatedProductsSectionItemThumbnailsLocator());
    }

    public String getItemThumbnailURL() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemThumbnail())).getAttribute("src");
    }

    public String getProductsSectionItemThumbnailURL (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getProductsSectionItemThumbnail(itemNumber))).getAttribute("src");
    }

    public String getCurrentCategoryTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCurrentCategoryTitle())).getText();
    }

    public String getBreadcrumbCurrentSection() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getBreadcrumbCurrentSection())).getText();
    }

    public String getCategoryName (int categoryNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemCategory(categoryNumber))).getText();
    }

    public String getCategoryItemCount (int categoryNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemCategoryCount(categoryNumber))).getText();
    }

    public String getProductsSectionItemTitle (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getProductsSectionItemTitle(itemNumber))).getText();
    }

    public String getProductsSectionItemPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getProductsSectionItemPrice(itemNumber))).getText();
    }

    public String getProductsSectionItemOldPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getProductsSectionItemOldPrice(itemNumber))).getText();
    }

    public String getProductsSectionItemNewPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getProductsSectionItemNewPrice(itemNumber))).getText();
    }

    public String getItemTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemTitle())).getText();
    }

    public String getItemPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemPrice())).getText();
    }

    public String getItemOldPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemOldPrice())).getText();
    }

    public String getItemNewPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemNewPrice())).getText();
    }

    public String getRelatedProductsSectionItemTitle (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRelatedProductsSectionItemTitle(itemNumber))).getText();
    }

    public String getRelatedProductsSectionItemPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRelatedProductsSectionItemPrice(itemNumber))).getText();
    }

    public String getRelatedProductsSectionOldPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRelatedProductsSectionOldPrice(itemNumber))).getText();
    }

    public String getRelatedProductsSectionNewPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRelatedProductsSectionNewPrice(itemNumber))).getText();
    }

    public void navigateToBreadcrumbPreviousSection (int categoryNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBreadcrumbPreviousSection(categoryNumber))).click();
    }

    public void navigateToCategory (int categoryNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getItemCategory(categoryNumber))).click();
    }

    public void navigateToProductsSectionItem (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getProductsSectionItem(itemNumber))).click();
    }

    public void navigateToProductsSectionItemByThumbnail (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getProductsSectionItemThumbnail(itemNumber))).click();
    }

    public void navigateToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getNavigateToCartButton())).click();
    }

    public void navigateToRelatedProductsSectionItem (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRelatedProductsSectionItem(itemNumber))).click();
    }

    public void navigateToRelatedProductsSectionItemByThumbnail (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRelatedProductsSectionItemThumbnail(itemNumber))).click();
    }

    public String getRelatedProductsSectionItemThumbnailURL (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRelatedProductsSectionItemThumbnail(itemNumber))).getAttribute("src");
    }

    public void openItemDescription() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getDescriptionSection())).click();
    }

    public void openItemReview() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getReviewSection())).click();
    }

    public void enterItemQuantity (String quantity) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getItemQuantityField())).clear();
        driver.findElement(locators.getItemQuantityField()).sendKeys(quantity);
    }

    public void clickRelatedProductsItemAddToCart (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRelatedProductsSectionItemAddToCart(itemNumber))).click();
    }

    public void clickRelatedProductsMoreDetailsButton (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRelatedProductsMoreDetailsButton(itemNumber))).click();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getItemAddToCartButton())).click();
    }

    public void clickCloseImageButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getItemImageCloseButton())).click();
    }

    public void clickZoomButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getImageZoomButton())).click();
    }

    public void clickOpenImageFullscreen() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getOpenItemImageFullscreenButton())).click();
    }

    public void clickOpenThumbnailImage() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getOpenItemImageButton())).click();
    }

    public boolean descriptionTabPanelIsPresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getDescriptionSectionTabPanel())).isDisplayed();
    }

    public boolean reviewTabPanelIsPresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getReviewSectionTabPanel())).isDisplayed();
    }

    public boolean alertElementIsPresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getAlertElement())).isDisplayed();
    }

    public boolean onSaleMarkIsPresent (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOnSaleMark(itemNumber))).isDisplayed();
    }

    public boolean itemThumbnailIsPresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemThumbnail())).isDisplayed();
    }

    public boolean itemImageIsPresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemImage())).isDisplayed();
    }
}
