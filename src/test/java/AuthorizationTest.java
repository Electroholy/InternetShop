import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;

public class AuthorizationTest extends BaseTest {

    @BeforeEach
    @Override
    public void setUp() throws NoSuchMethodException {
        super.setUp();
        utility.openMyAccount();
    }

    private final String existingUsername = "kherlaeda";
    private final String existingPassword = "075gektvtn";
    private final String invalidUsername = "Kerleda";
    private final String invalidPassword = "046fdjhfd";

    @Test
    public void positiveAuthorizationTest() {
        authoriztionForm.enterUserName(existingUsername);
        authoriztionForm.enterPassword(existingPassword);
        authoriztionForm.clickLogin();

        Assertions.assertTrue(driver.findElement(headerLocators.getUserName()).isDisplayed(), "После ввода существующего имени пользователя и пароля не получилось авторизоваться");
    }

    @Test
    public void authorizationWithoutUsername() {
        authoriztionForm.enterPassword(existingPassword);
        authoriztionForm.clickLogin();
        Assertions.assertTrue(authoriztionForm.getAlertElementText().contains("Имя пользователя или электронная почта обязательны."), "Текст ошибки не соответствует спецификации");
    }

    @Test
    public void authorizationWithoutPassword() {
        authoriztionForm.enterUserName(existingUsername);
        authoriztionForm.clickLogin();
        Assertions.assertTrue(authoriztionForm.getAlertElementText().contains("Пароль обязателен."), "Текст ошибки не соответствует спецификации");
    }

    @Test
    public void authorizationWithEmptyField() {
        authoriztionForm.clickLogin();
        Assertions.assertTrue(authoriztionForm.getAlertElementText().contains("Имя пользователя или электронная почта обязательны."), "Текст ошибки не соответствует спецификации");
    }

    @Test
    public void authorizationWithInvalidUsername() {
        authoriztionForm.enterUserName(invalidUsername);
        authoriztionForm.enterPassword(existingPassword);
        authoriztionForm.clickLogin();
        Assertions.assertTrue(authoriztionForm.getAlertElementText().contains("Неизвестное имя пользователя. Попробуйте еще раз или укажите адрес почты."), "Текст ошибки не соответствует спецификации");
    }

    @Test
    public void authorizationWithInvalidPassword() {
        authoriztionForm.enterUserName(existingUsername);
        authoriztionForm.enterPassword(invalidPassword);
        authoriztionForm.clickLogin();
        Assertions.assertEquals("Введенный пароль для пользователя " + existingUsername  + " неверный. Забыли пароль?", authoriztionForm.getAlertElementText());
        Assertions.assertTrue(driver.findElement(authorizationFormLocators.getNavigateToResetPasswordTopForm()).isDisplayed(), "Не отображается ссылка ведущая к форме восстановления пароля");
    }

    @Test
    public void showPasswordButton() {
        authoriztionForm.enterUserName(existingUsername);
        authoriztionForm.enterPassword(existingPassword);
        authoriztionForm.clickShowPassword();
        Assertions.assertTrue(driver.findElement(authorizationFormLocators.getPasswordFieldAfterClickingShowPassword()).isDisplayed());
    }

    @Test
    public void navigateToResetPassword() {
        authoriztionForm.navigateToResetPassword();
        Assertions.assertTrue(authoriztionForm.resetPasswordForm().isDisplayed(), "После клика по ссылке не удалось перейти к форме восстановления пароля");
    }

    @Test
    public void navigateToRegistration() {
        authoriztionForm.navigateToRegistrationForm();
        Assertions.assertTrue(driver.findElement(registrationFormLocators.getRegistrationForm()).isDisplayed(), "После клика по ссылке не удалось перейти к форме регистрации");
    }

    @Test
    public void resetPassword() {
        authoriztionForm.navigateToRegistrationForm();

        registrationForm.enterUserName(utility.randomValidUsername());
        String username = driver.findElement(registrationFormLocators.getUsernameField()).getAttribute("value");
        registrationForm.enterEmail(utility.randomValidEmail());
        registrationForm.enterPassword(utility.randomValidPassword());
        registrationForm.clickRegister();

        header.clickLogout();
        header.clickLogin();

        authoriztionForm.navigateToResetPassword();
        authoriztionForm.resetPasswordForm_EnterUserNameOrEmail(username);
        authoriztionForm.clickResetPassword();

        String expectedResult = "Письмо для сброса пароля отправлено.";
        String actualResult = authoriztionForm.getSuccessfulResetPasswordMessage();
        try {
            Assertions.assertEquals(expectedResult,actualResult,"Текст сообщения об успешном сбросе пароля не соответствует спецификации");
            Assertions.assertTrue(driver.findElement(authorizationFormLocators.getSuccessfulResetPasswordMessage()).isDisplayed(), "Письмо для сброса пароля не было отправлено");
        } catch (NoSuchElementException e) {
            System.out.println("Элемент содержащий в себе сообщение об успешном сбросе пароля не появился: " + e.getMessage());
        }
    }

    @Test
    public void validationResetPasswordFormEmptyField() {
        authoriztionForm.navigateToResetPassword();
        authoriztionForm.clickResetPassword();

        String expectedResult = "Введите имя пользователя или электронную почту.";
        String actualResult = authoriztionForm.getAlertElementText();

        try {
            Assertions.assertEquals(expectedResult,actualResult,"Текст ошибки не соответствует тексту указанному в спецификации");
        } catch (NoSuchElementException e) {
            System.out.println("Элемент содержащий в себе сообщение об ошибке не появился: " + e.getMessage());
        }
    }

    @Test
    public void validationResetPasswordFormInvalidUsername() {
        authoriztionForm.navigateToResetPassword();
        authoriztionForm.resetPasswordForm_EnterUserNameOrEmail(invalidUsername);
        authoriztionForm.clickResetPassword();

        String expectedResult = "Неверное имя пользователя или почта.";
        String actualResult = authoriztionForm.getAlertElementText();

        try {
            Assertions.assertEquals(expectedResult,actualResult,"Текст ошибки не соответствует тексту указанному в спецификации");
        } catch (NoSuchElementException e) {
            System.out.println("Элемент содержащий в себе сообщение об ошибке не появился: " + e.getMessage());
        }
    }
}
