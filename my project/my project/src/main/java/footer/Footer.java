package footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Footer {

    WebDriver driver;
    WebDriverWait wait;
    FooterLocators locators;

    public Footer (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.locators = new FooterLocators();
    }

    public WebElement footerNavigationMenuLocator() {
        return driver.findElement(locators.getFooterMenu());
    }

    public void navigateToAllProductsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getAllProducts())).click();
    }

    public void navigateToMainPage() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getMainPage())).click();
    }

    public void navigateToBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBasket())).click();
    }

    public void navigateToMyAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getMyAccount())).click();
    }

    public void navigateToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getCheckout())).click();
    }

    public void navigateToRegistrationFOrm() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRegistration())).click();
    }
    public String getContactPhone() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getContactPhone())).getText();
    }

    public String getContactEmail() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getContactEmail())).getText();
    }

    public WebElement contactInformationElement() {
        return driver.findElement(locators.getContactInformationElement());
    }

    public String getAllProductsTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getAllProducts())).getText();
    }

    public String getMainPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getMainPage())).getText();
    }

    public String getBasketTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getBasket())).getText();
    }

    public String getMyAccountTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getMyAccount())).getText();
    }

    public String getCheckoutTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getCheckout())).getText();
    }

    public String getRegistrationTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getRegistration())).getText();
    }
}
