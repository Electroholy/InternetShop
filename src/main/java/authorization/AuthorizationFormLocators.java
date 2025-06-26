package authorization;

import org.openqa.selenium.By;

public class AuthorizationFormLocators {

    //--------------------------------------------LOCATORS-------------------------------------

    // Общие локаторы
    private final By authorizationForm = By.cssSelector(".login");
    private final By alertElement = By.cssSelector(".woocommerce-error li");
    private final By usernameInStrongTag = By.cssSelector(".woocommerce-error strong");

    // Форма авторизации
    private final By usernameField = By.cssSelector(".login #username");
    private final By passwordField = By.cssSelector(".login #password");
    private final By showPasswordElement = By.cssSelector(".login .show-password-input");
    private final By checkboxRememberMe = By.cssSelector(".login #rememberme");
    private final By loginButton = By.cssSelector(".login .button");
    private final By passwordFieldAfterClickingShowPassword = By.cssSelector(".password-input > [type=text]");

    // Переход к форме восстановления пароля
    private final By navigateToResetPasswordBotForm = By.cssSelector(".lost_password a");
    private final By resetPasswordForm = By.cssSelector("#post-22 .lost_reset_password");
    private final By navigateToResetPasswordTopForm = By.cssSelector(".woocommerce-error a");

    // Форма восстановления пароля
    private final By usernameOrEmailField= By.cssSelector("#user_login");
    private final By resetPasswordButton = By.cssSelector("button[value = 'Reset password']");
    private final By successfulResetPasswordMessage = By.cssSelector(".woocommerce-message");

    // Переход к форме регистрации
    private final By navigateToRegistrationForm = By.cssSelector(".login .custom-register-button");

    // Навигация в breadcrumb
    private final By breadcrumbCurrentSection = By.cssSelector("#accesspress-breadcrumb > .current");
    private By breadcrumbPreviousSections (int categoryNumber) {
        return By.xpath("(//div[@id='accesspress-breadcrumb']/a)[" + categoryNumber + "]");
    }

    //------------------------------------------GETTERS----------------------------------------------

    public By getSuccessfulResetPasswordMessage() {
        return successfulResetPasswordMessage;
    }

    public By getPasswordFieldAfterClickingShowPassword() {
        return passwordFieldAfterClickingShowPassword;
    }

    public By getUsernameInStrongTag() {
        return usernameInStrongTag;
    }

    public By getAuthorizationForm() {
        return authorizationForm;
    }

    public By getAlertElement() {
        return alertElement;
    }

    public By getUsernameField() {
        return usernameField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getShowPasswordElement() {
        return showPasswordElement;
    }

    public By getCheckboxRememberMe() {
        return checkboxRememberMe;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getNavigateToResetPasswordBotForm() {
        return navigateToResetPasswordBotForm;
    }

    public By getNavigateToResetPasswordTopForm() {
        return navigateToResetPasswordTopForm;
    }

    public By getResetPasswordForm() {
        return resetPasswordForm;
    }

    public By getUsernameOrEmailField() {
        return usernameOrEmailField;
    }

    public By getResetPasswordButton() {
        return resetPasswordButton;
    }

    public By getNavigateToRegistrationForm() {
        return navigateToRegistrationForm;
    }

    public By getBreadcrumbCurrentSection() {
        return breadcrumbCurrentSection;
    }

    public By getBreadcrumbPreviousSections (int categoryNumber) {
        return breadcrumbPreviousSections(categoryNumber);
    }
}
