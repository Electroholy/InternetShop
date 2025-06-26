import net.sourceforge.tess4j.TesseractException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RegistrationTest extends BaseTest {

    @BeforeEach
    @Override
    public void setUp() throws NoSuchMethodException {
        super.setUp();
        utility.openRegistrationForm();
    }

    @Test
    public void positiveRegistrationTest() {
        registrationForm.enterUserName(utility.randomValidUsername());
        registrationForm.enterEmail(utility.randomValidEmail());
        registrationForm.enterPassword(utility.randomValidPassword());
        registrationForm.clickRegister();

        Assertions.assertTrue(registrationForm.getSuccessfulRegistrationMessage().contains("Регистрация завершена"), "Сообщение об успешной регистрации не отобразилось");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Новыйюзер321", "pim5", "Si", "вас9", "Вася72", "Vasdjhopuihvmkjwgd897"})
    public void userNameValidation (String username) {
        registrationForm.enterUserName(username);
        registrationForm.enterEmail(utility.randomValidEmail());
        registrationForm.enterPassword(utility.randomValidPassword());
        registrationForm.clickRegister();

        boolean expectedResult = registrationForm.getSuccessfulRegistrationMessage().contains("Пожалуйста введите корректное имя пользователя.");
        Assertions.assertTrue(expectedResult, "Получилось пройти регистрацию используя невалидное имя пользователя: " + username);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ТестовыйEmail@bk.ru",
            "Тест@mail.com",
            "test@почта.com",
            "test@почтаEmail.com",
            "user@example.com",
            "email@example.co.jp",
            "name-last@example.com",
            "name+last@example.com",
            "name.last@example.com",
            "plainaddress",
            "username@.com",
            "@missingusername.com",
            ".username@example.com",
            "username@example..com",
            "username@example.com.",
            "username@-example.com",
            "username@.example.com",
            "username@example_com",
            "username@example+com",
            "username@",
            "user@name@example.com",
            "user@example.c",
            "user@.com",
            "user@localhost",
            "user@example.123"})
    public void emailValidation (String email) throws AWTException, TesseractException, InterruptedException {
        driver.manage().window().fullscreen();
        registrationForm.enterUserName(utility.randomValidUsername());
        registrationForm.enterEmail(email);
        registrationForm.enterPassword(utility.randomValidPassword());
        registrationForm.clickRegister();

        Thread.sleep(2000);

        BufferedImage image = utility.screenshot(driver.findElement(registrationFormLocators.getScreenshotElement()));
        String popupElement = utility.getScreenshotText(image);

        if (email.equals("ТестовыйEmail@bk.ru") || email.equals("Тест@mail.com")) {
            Assertions.assertTrue(popupElement.contains("Часть адреса до символа \"@\" не должна содержать cимвол"));
        } else if (email.equals("test@почта.com") || email.equals("test@почтаEmail.com")) {
            Assertions.assertTrue(popupElement.contains("Часть адреса после символа \"@\" не должна содержать cимвол"));
        } else if (email.equals("user@example.com") || email.equals("email@example.co.jp") || email.equals("name-last@example.com") || email.equals("name+last@example.com") || email.equals("name.last@example.com")) {
            Assertions.assertEquals("Ошибка: Учетная запись с такой почтой уже зарегистрирована. Пожалуйста авторизуйтесь.", registrationForm.getUnsuccessfulRegistrationMessage());
        } else if (email.equals("username@.com") || email.equals(".username@example.com") || email.equals("username@example..com") ||
                email.equals("username@example.com.") || email.equals("username@-example.com") || email.equals("username@.example.com") ||
                email.equals("username@example_com") || email.equals("username@example+com")) {
            Assertions.assertTrue(popupElement.contains("Недопустимое положение символа"));
        } else if (email.contains("@missingusername.com") || email.contains("username@") || email.equals("user@.com")) {
            Assertions.assertTrue(popupElement.contains("Введите часть адреса"));
        } else if (email.contains("user@name@example.com")) {
            Assertions.assertTrue(popupElement.contains("Часть адреса после символа \"@\" не должна содержать символ \"@\""));
        } else if (email.contains("user@example.c") || email.contains("user@localhost") || email.contains("user@example.123")) {
            Assertions.assertTrue(popupElement.contains("Введите корректный домен"));
        } else if (email.equals("plainaddress")) {
            Assertions.assertTrue(popupElement.contains("Адрес электронной почты должен содержать символ \"@\""));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"QwйЦ12!?", "VerylongpasswordФыв!?-", "", " "})
    public void passwordValidation (String password) {
        registrationForm.enterUserName(utility.randomValidUsername());
        registrationForm.enterEmail(utility.randomValidEmail());
        registrationForm.enterPassword(password);
        registrationForm.clickRegister();

        if (password.equals("QwйЦ12!?")) {
            Assertions.assertTrue(registrationForm.getSuccessfulRegistrationMessage().contains("Регистрация завершена"), "Не удалось зарегистрироваться с валидным паролем");
        } else if (password.equals("VerylongpasswordФыв!?-")) {
            Assertions.assertTrue(registrationForm.getUnsuccessfulRegistrationMessage().contains("Максимальное допустимое количество символов: 20"), "После ввода пароля более чем из 20 символов не появилось ошибки");
        } else if (password.isEmpty()) {
            Assertions.assertTrue(registrationForm.getUnsuccessfulRegistrationMessage().contains("Введите пароль для регистрации."), "При попытке регистрации без пароля не появилось сообщение с ошибкой");
        } else if (password.equals(" ")) {
            Assertions.assertFalse(registrationForm.getSuccessfulRegistrationMessage().contains("Регистрация завершена"), "Получилось пройти регистрацию указав в качестве пароля пробел");
        }
    }
}