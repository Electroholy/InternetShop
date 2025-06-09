package registration;

import org.openqa.selenium.By;

public class RegistrationFormLocators {

    //-------------------------------------LOCATORS-------------------------------------

    private final By breadcrumbCurrentSection = By.cssSelector("#accesspress-breadcrumb > .current");
    private By breadcrumbPreviousSections (int categoryNumber) {
        return By.xpath("(//div[@id='accesspress-breadcrumb']/a)[" + categoryNumber + "]");
    }

    private final By usernameField = By.cssSelector(".register #reg_username");
    private final By emailField = By.cssSelector(".register #reg_email");
    private final By passwordField = By.cssSelector(".register #reg_password");
    private final By registerButton = By.cssSelector(".woocommerce-form-register__submit");
    private final By successfulRegistrationMessage = By.cssSelector("#post-141 .content-page > div");
    private final By unsuccessfulRegistrationMessage = By.cssSelector(".woocommerce-error li");
    private final By registrationForm = By.cssSelector(".content-inner.clearfix");
    private final By registrationCompleteMessage = By.cssSelector(".content-page > div");
    private final By screenshotElement = By.cssSelector("#main");

    //-----------------------------------GETTERS---------------------------------------

    public By getScreenshotElement() {
        return screenshotElement;
    }

    public By getRegistrationCompleteMessage() {
        return registrationCompleteMessage;
    }

    public By getRegistrationForm() {
        return registrationForm;
    }

    public By getBreadcrumbCurrentSection() {
        return breadcrumbCurrentSection;
    }

    public By getUsernameField() {
        return usernameField;
    }

    public By getEmailField() {
        return emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getRegisterButton() {
        return registerButton;
    }

    public By getSuccessfulRegistrationMessage() {
        return successfulRegistrationMessage;
    }

    public By getUnsuccessfulRegistrationMessage() {
        return unsuccessfulRegistrationMessage;
    }

    public By getBreadcrumbPreviousSections (int categoryNumber) {
        return breadcrumbPreviousSections(categoryNumber);
    }
}
