package catalog_productcard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Catalog {

    WebDriver driver;
    CatalogLocators locators;
    WebDriverWait wait;
    Actions action;

    public Catalog(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
        this.locators = new CatalogLocators();
    }

    public String getLastPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getLastPage())).getText();
    }

    public String getCurrentCategoryTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCurrentCategoryTitle())).getText();
    }

    public String getBreadcrumbCurrentSection() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getBreadcrumbCurrentSection())).getText();
    }

    public String getPriceFilterFromResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPriceFilterFromResult())).getText();
    }

    public String getPriceFilterToResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPriceFilterToResult())).getText();
    }

    public String getCategoryItemAmountDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCategoryItemAmountDisplayed())).getText();
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

    public String getCategoryItemPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCategoryItemPrice(itemNumber))).getText();
    }

    public String getCategoryItemOldPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCategoryItemOldPrice(itemNumber))).getText();
    }

    public String getCategoryItemNewPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCategoryItemNewPrice(itemNumber))).getText();
    }

    public String getCategoryItemTitle (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCategoryItemTitle(itemNumber))).getText();
    }

    public void moveLeftPriceFilterSlider (int offset) {
        WebElement leftSlider = wait.until(ExpectedConditions.elementToBeClickable(locators.getPriceFilterLeftSlider()));
        action.clickAndHold(leftSlider).moveByOffset(offset, 0).release().perform();
    }

    public void moveRightPriceFilterSlider (int offset) {
        WebElement rightSlider = wait.until(ExpectedConditions.elementToBeClickable(locators.getPriceFilterRightSlider()));
        action.clickAndHold(rightSlider).moveByOffset(offset, 0).release().perform();
    }

    public void clickPriceFilterApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getPriceFilterApplyButton())).click();
    }

    public void clickPreviousPageArrowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getPreviousPageArrowButton())).click();
    }

    public void clickNextPageArrowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getNextPageArrowButton())).click();
    }

    public void clickAddToCartButton (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getAddToCartButton(itemNumber))).click();
    }

    public void clickMoreDetailsButton (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getMoreDetailsButton(itemNumber))).click();
    }

    public void openSortingDropdownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSortingElement())).click();
    }

    public void sortByRegular() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSortByRegular())).click();
    }

    public void sortByPopularity() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSortByPopularity())).click();
    }

    public void sortByRating() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSorByRating())).click();
    }

    public void sortByDate() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSortByDate())).click();
    }

    public void sortByAscending() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSortByAscending())).click();
    }

    public void sortByDescending() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSortByDescending())).click();
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

    public void navigateToCategoryItemByThumbnail (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getCategoryItemThumbnail(itemNumber))).click();
    }

    public String getCategoryItemThumbnailURL (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCategoryItemThumbnail(itemNumber))).getAttribute("src");
    }

    public String getProductsSectionItemThumbnailURL (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getProductsSectionItemThumbnail(itemNumber))).getAttribute("src");
    }

    public void navigateToCategoryItem (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getCategoryItem(itemNumber))).click();
    }

    public void navigateToOrdinalPage (int pageNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getOrdinalPage(pageNumber))).click();
    }

    public boolean onSaleMarkIsPresent (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getOnSaleMark(itemNumber))).isDisplayed();
    }

    public WebElement productsSectionItemThumbnailLocators() {
        return driver.findElement(locators.getProductsSectionItemThumbnailLocator());
    }
}
