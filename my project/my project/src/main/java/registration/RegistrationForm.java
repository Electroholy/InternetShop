package registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationForm {

    WebDriver driver;
    WebDriverWait wait;
    RegistrationFormLocators locators;

    public RegistrationForm (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.locators = new RegistrationFormLocators();
    }

    public String getBreadcrumbCurrentSectionLocatorTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getBreadcrumbCurrentSection())).getText();
    }

    public void enterUserName (String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getUsernameField())).sendKeys(name);
    }

    public void enterEmail (String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getEmailField())).sendKeys(email);
    }

    public void enterPassword (String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPasswordField())).sendKeys(password);
    }

    public void clickRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getRegisterButton())).click();
    }

    public String getSuccessfulRegistrationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getSuccessfulRegistrationMessage())).getText();
    }

    public String getUnsuccessfulRegistrationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getUnsuccessfulRegistrationMessage())).getText();
    }

    public void navigateToBreadcrumbPreviousSection (int categoryNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBreadcrumbPreviousSections(categoryNumber))).click();
    }
}
