package authorization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthoriztionForm {

    WebDriver driver;
    WebDriverWait wait;
    AuthorizationFormLocators locators;

    public AuthoriztionForm (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.locators = new AuthorizationFormLocators();
    }

    public String getSuccessfulResetPasswordMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getSuccessfulResetPasswordMessage())).getText();
    }

    public String getAlertElementText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getAlertElement())).getText();
    }

    public String getUserNameInStrongTagText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getUsernameInStrongTag())).getText();
    }

    public void enterUserName (String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getUsernameField())).sendKeys(name);
    }

    public void enterPassword (String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getPasswordField())).sendKeys(password);
    }

    public void clickShowPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getShowPasswordElement())).click();
    }

    public void clickCheckboxRememberMe() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getCheckboxRememberMe())).click();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getLoginButton())).click();
    }

    public void navigateToResetPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getNavigateToResetPasswordBotForm())).click();
    }

    public void resetPasswordForm_EnterUserNameOrEmail (String nameOrEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getUsernameOrEmailField())).sendKeys(nameOrEmail);
    }

    public void clickResetPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getResetPasswordButton())).click();
    }

    public void navigateToRegistrationForm() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getNavigateToRegistrationForm())).click();
    }

    public String getBreadcrumbCurrentSectionTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locators.getBreadcrumbCurrentSection())).getText();
    }

    public void navigateToBreadcrumbPreviousSection (int categoryNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(locators.getBreadcrumbPreviousSections(categoryNumber))).click();
    }

    public WebElement authorizationForm() {
        return driver.findElement(locators.getAuthorizationForm());
    }

    public WebElement resetPasswordForm() {
        return driver.findElement(locators.getResetPasswordForm());
    }
}
