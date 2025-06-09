package mainpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    MainPageLocators locators;
    WebDriver driver;
    WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.locators = new MainPageLocators();
    }

    //----------------------------------GET VALUE----------------------------------------

    public String getPromoBookSectionTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPromoBookSectionTitle())).getText();
    }

    public String getPromoTabletSectionTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPromoTabletSectionTitle())).getText();
    }

    public String getPromoCameraSectionTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPromoCameraSectionTitle())).getText();
    }

    public String getBottomPromoSectionButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getBottomPromoSectionButton())).getText();
    }

    public String getBottomPromoSectionTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getBottomPromoSectionTitle())).getText();
    }

    public String getBottomPromoSectionItemTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getBottomPromoSectionItemTitle())).getText();
    }

    public String getSaleSectionItemTitle (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getSaleSectionItemTitle(itemNumber))).getText();
    }

    public String getSaleSectionThumbnailIURL (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getSaleSectionThumbnail(itemNumber))).getAttribute("src");
    }

    public String getNewArrivalsSectionThumbnailsURL (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getNewArrivalsSectionThumbnails(itemNumber))).getAttribute("src");
    }

    public String getRecentlyViewedSectionItemThumbnailURL (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRecentlyViewedSectionItemThumbnail(itemNumber))).getAttribute("src");
    }

    public String getNewArrivalsSectionItemTitle (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getNewArrivalsSectionItemTitle(itemNumber))).getText();
    }

    public String getSaleSectionItemNewPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getSaleSectionItemNewPrice(itemNumber))).getText();
    }

    public String getSaleSectionItemOldPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getSaleSectionItemOldPrice(itemNumber))).getText();
    }

    public String getSaleSectionItemDescription (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getSaleSectionItemDescription(itemNumber))).getText();
    }

    public String getNewArrivalsSectionItemPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getNewArrivalsSectionItemPrice(itemNumber))).getText();
    }

    public String getNewArrivalsSectionItemNewPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getNewArrivalsSectionItemNewPrice(itemNumber))).getText();
    }

    public String getNewArrivalsSectionItemOldPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getNewArrivalsSectionItemOldPrice(itemNumber))).getText();
    }

    public String getNewArrivalsSectionItemDescription (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getNewArrivalsSectionItemDescription(itemNumber))).getText();
    }

    public String getRecentlyViewedSectionItemTitle (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRecentlyViewedSectionItemTitle(itemNumber))).getText();
    }

    public String getRecentlyViewedSectionItemPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRecentlyViewedSectionItemPrice(itemNumber))).getText();
    }

    public String getRecentlyViewedSectionItemOldPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRecentlyViewedSectionItemOldPrice(itemNumber))).getText();
    }

    public String getRecentlyViewedSectionItemNewPrice (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRecentlyViewedSectionItemNewPrice(itemNumber))).getText();
    }

    public String getOnSaleMarkText (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemOnSaleMark(itemNumber))).getText();
    }

    public String getNewArrivalMarkText (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemNewArrivalMark(itemNumber))).getText();
    }

    //-------------------------------------NAVIGATE TO--------------------------------------
    public void navigateToPromoBookSection() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getPromoBookSection())).click();
    }

    public void navigateToPromoTabletSection() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getPromoTabletSection())).click();
    }

    public void navigateToPromoCameraSection() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getPromoCameraSection())).click();
    }

    public void navigateToBottomPromoSection() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBottomPromoSection())).click();
    }

    public void navigateToNewArrivalsSectionItem(int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getNewArrivalsSectionItem(itemNumber))).click();
    }

    public void navigateToSaleSectionItem (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSaleSectionItem(itemNumber))).click();
    }

    public void navigateToRecentlyViewedSectionItemByTitle (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRecentlyViewedSectionItemTitle(itemNumber))).click();
    }

    public void navigateToRecentlyViewedSectionItemByThumbnail (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRecentlyViewedSectionItemThumbnail(itemNumber))).click();
    }

    //----------------------------------CLICK-------------------------------------
    public void clickSaleSectionPreviousSlide() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSaleSectionPreviousSlide())).click();
    }

    public void clickSaleSectionNextSlide() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSaleSectionNextSlide())).click();
    }

    public void clickBottomPromoSectionButton() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBottomPromoSectionButton())).click();
    }

    public void clickNewArrivalsSectionPreviousSlide() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getNewArrivalsSectionPreviousSlideButton())).click();
    }

    public void clickNewArrivalsSectionNextSlide() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getNewArrivalsSectionNextSlideButton())).click();
    }

    public void clickSaleSectionAddToCart(int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getSaleSectionItemAddToCartButton(itemNumber))).click();
    }

    public void clickNewArrivalsSectionAddToCart (int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getNewArrivalsSectionItemAddToCartButton(itemNumber))).click();
    }

    //-----------------------------------CHECK-----------------------------------------
    public boolean checkItemOnSaleMark (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemOnSaleMark(itemNumber))).isDisplayed();
    }

    public boolean checkItemNewArrivalMark (int itemNumber) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getItemNewArrivalMark(itemNumber))).isDisplayed();
    }

    public WebElement recentlyViewedSectionItemThumbnailsLocator() {
        return driver.findElement(locators.getRecentlyViewedSectionItemThumbnailsLocator());
    }

    public WebElement newArrivalsAndSaleSectionThumbnailsLocator() {
        return driver.findElement(locators.getNewArrivalsAndSaleSectionThumbnailsLocator());
    }
}