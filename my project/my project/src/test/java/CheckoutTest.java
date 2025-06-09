import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class CheckoutTest extends BaseTest {

    private final String couponCode = "sert500";
    private final String testFirstname = "Владислав";
    private final String testLastname = "Ивлев";
    private final String testAddress = "Ленина 25";
    private final String testRegion = "Московская область";
    private final String testPostalCode = "677322";
    private final String testPhone = "89241796789";
    private final String testEmail = "test@mail.ru";
    private final String testCity = "Москва";

    @BeforeEach
    @Override
    public void setUp() throws NoSuchMethodException {
        super.setUp();
        utility.openMainPage();
    }

    private void preparatorySteps() {
        utility.login();
        header.navigateToCatalog();
        utility.addTestItemToCart();
        basket.clickPlaceAnOrder();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(utility.scrollUpButton));
        driver.findElement(checkoutLocators.getEmailField()).clear();
    }

    @Test
    public void positiveBankTransferOrderProcessing() {
        preparatorySteps();

        checkout.enterFirstName(testFirstname);
        checkout.enterLastName(testLastname);
        checkout.enterAddress(testAddress);
        checkout.enterCity(testCity);
        checkout.enterRegion(testRegion);
        checkout.enterPostalCode(testPostalCode);
        checkout.enterPhone(testPhone);
        checkout.enterEmail(testEmail);

        checkout.clickBankTransferRadioButton();
        checkout.clickPlaceAnOrderButton();
        checkout.waitLoadersInvisibility();

        Assertions.assertTrue(driver.findElement(checkoutLocators.getOrderReceivedMessage()).getText().contains("Заказ получен"), "Не удалось оформить заказ");
    }

    @Test
    public void positiveCashPaymentOrderProcessing() {
        preparatorySteps();

        checkout.enterFirstName(testFirstname);
        checkout.enterLastName(testLastname);
        checkout.enterAddress(testAddress);
        checkout.enterCity(testCity);
        checkout.enterRegion(testRegion);
        checkout.enterPostalCode(testPostalCode);
        checkout.enterPhone(testPhone);
        checkout.enterEmail(testEmail);

        checkout.clickCashPaymentRadioButton();
        checkout.clickPlaceAnOrderButton();
        checkout.waitLoadersInvisibility();

        Assertions.assertTrue(driver.findElement(checkoutLocators.getOrderReceivedMessage()).getText().contains("Заказ получен"), "Не удалось оформить заказ");
    }

    @Test
    public void inputFieldIsRequired() {
        preparatorySteps();
        checkout.clickPlaceAnOrderButton();

        Assertions.assertTrue(checkout.getMissingFirstnameMessage().contains("Имя для выставления счета обязательное поле"), "Поле ввода имени не является обязательным полем");
        Assertions.assertTrue(checkout.getMissingLastnameMessage().contains("Фамилия для выставления счета обязательное поле"), "Поле ввода фамилии не является обязательным полем");
        Assertions.assertTrue(checkout.getMissingAddressMessage().contains("Адрес для выставления счета обязательное поле"), "Поле ввода адреса не является обязательным полем");
        Assertions.assertTrue(checkout.getMissingCityMessage().contains("Город / Населенный пункт для выставления счета обязательное поле"), "Поле ввода города не является обязательным полем");
        Assertions.assertTrue(checkout.getMissingRegionMessage().contains("Область для выставления счета обязательное поле"), "Поле ввода региона не является обязательным полем");
        Assertions.assertTrue(checkout.getMissingPostalCodeMessage().contains("Почтовый индекс для выставления счета обязательное поле"), "Поле ввода почтового индекса не является обязательным полем");
        Assertions.assertTrue(checkout.getMissingPhoneMessage().contains("Телефон для выставления счета обязательное поле"), "Поле ввода телефона не является обязательным полем");
        Assertions.assertTrue(checkout.getMissingEmailMessage().contains("Адрес почты для выставления счета обязательное поле"), "Поле ввода электронной почты не является обязательным полем");

        header.navigateToBasket();
        utility.clearCart(1);
    }

    @Test
    public void applyingAndDeleteCouponCode() {
        utility.login();

        // Переход в каталог товаров и добавление товара в корзину
        header.navigateToCatalog();
        utility.addTestItemToCart();
        int itemPrice = utility.formatStringInToInt(basket.getItemPrice(1));
        basket.clickPlaceAnOrder();

        // Применение купона
        wait.until(ExpectedConditions.invisibilityOfElementLocated(utility.scrollUpButton));
        checkout.openEnterCouponForm();
        wait.until(ExpectedConditions.visibilityOf(checkout.couponDropDownMenu()));
        checkout.enterCoupon(couponCode);
        checkout.clickApplyCoupon();
        wait.until(ExpectedConditions.invisibilityOf(checkout.couponDropDownMenu()));

        int discount = utility.formatStringInToInt(checkout.getOrderDiscount());
        int actualResult = itemPrice - discount;
        int expectedResult = 29400;

        Assertions.assertEquals(expectedResult,actualResult,"Скидка не применилась");

        // Возвращаем всё в первоначальное состояние (удаление купона и товара в корзине)
        checkout.removeCoupon();
        checkout.waitLoadersInvisibility();

        int expectedResult2 = 29900;
        int actualResult2 = utility.formatStringInToInt(checkout.getOrderTotalPrice());
        Assertions.assertEquals(expectedResult2,actualResult2,"Не удалось отменить скидку");

        header.navigateToBasket();
        utility.clearCart(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"200","499","500","501"})
    public void validateCommentsField (String value) {
        String comment = utility.generateCharacters(value);

        preparatorySteps();

        checkout.enterComment(comment);
        int commentsFieldLength = driver.findElement(checkoutLocators.getCommentsField()).getAttribute("value").length();
        checkout.clickPlaceAnOrderButton();
        checkout.waitLoadersInvisibility();

        if (value.equals("501")) {
            Assertions.assertEquals(500,commentsFieldLength);
        } else {
            Assertions.assertEquals(utility.formatStringInToInt(value),commentsFieldLength);
        }
        Assertions.assertTrue(Objects.requireNonNull(driver.findElement(checkoutLocators.getCommentsField()).getAttribute("maxlength")).contains("500"));

        header.navigateToBasket();
        utility.clearCart(1);
    }


    @ParameterizedTest
    @ValueSource(strings = {"Владимир","123!?.","Константин-25","John","John-32"})
    public void validateCustomersName (String value) {
            preparatorySteps();

            checkout.enterFirstName(value);
            checkout.enterLastName(value);
            checkout.clickPlaceAnOrderButton();
            checkout.waitLoadersInvisibility();

            if (value.equals("Владимир") || value.equals("John")) {
                Assertions.assertTrue(driver.findElements(checkoutLocators.getMissingFirstnameMessage()).isEmpty(), "Поле ввода имени не принимает валидное значение");
                Assertions.assertTrue(driver.findElements(checkoutLocators.getMissingLastnameMessage()).isEmpty(), "Поле ввода имени не принимает валидное значение");
            } else {
                Assertions.assertFalse(driver.findElements(checkoutLocators.getMissingFirstnameMessage()).isEmpty(), "После ввода невалидного значения ошибки не отобразилось");
                Assertions.assertFalse(driver.findElements(checkoutLocators.getMissingLastnameMessage()).isEmpty(), "После ввода невалидного значения ошибки не отобразилось");
            }

        header.navigateToBasket();
        utility.clearCart(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ленина-1","Ленина д.2","Ленина 2/5","Lenina-1","Lenina h.2","Lenina 2/5","ЭэтоIsVeryLongAddressConsistingOfMoreThanFiftyCharacters h.5/3"})
    public void validateCustomersAddress(String value) {
        preparatorySteps();

        checkout.enterAddress(value);
        checkout.clickPlaceAnOrderButton();
        checkout.waitLoadersInvisibility();

        if (value.equals("ЭэтоIsVeryLongAddressConsistingOfMoreThanFiftyCharacters h.5/3")) {
            Assertions.assertEquals("ЭэтоIsVeryLongAddressConsistingOfMoreThanFiftyChar", driver.findElement(checkoutLocators.getAddressField()).getAttribute("value"));
        } else {
            Assertions.assertTrue(driver.findElements(checkoutLocators.getMissingAddressMessage()).isEmpty(), "Поле ввода адреса не принимает валидное значение");
        }

        header.navigateToBasket();
        utility.clearCart(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Moscow", "Московская область","veryьдлинноеназваниеCity","Yakutsk25!-."})
    public void validateCustomerCityAndRegion(String value) {
        preparatorySteps();

        checkout.enterCity(value);
        checkout.enterRegion(value);
        checkout.clickPlaceAnOrderButton();
        checkout.waitLoadersInvisibility();

        if (value.equals("veryьдлинноеназваниеCity")) {
            Assertions.assertEquals("veryьдлинноеназвание",driver.findElement(checkoutLocators.getCityField()).getAttribute("value"), "В поле ввода города возможно ввести более 20 символов");
            Assertions.assertEquals("veryьдлинноеназвание",driver.findElement(checkoutLocators.getRegionField()).getAttribute("value"),"В поле ввода региона возможно ввести более 20 символов");
        } else if (value.equals("Yakutsk25!-.")) {
            Assertions.assertFalse(driver.findElements(checkoutLocators.getMissingCityMessage()).isEmpty(),"После ввода не валидного значения в поле ввода города сообщение об ошибке не появилось");
            Assertions.assertFalse(driver.findElements(checkoutLocators.getMissingRegionMessage()).isEmpty(),"После ввода не валидного значения в поле ввода региона сообщение об ошибке не появилось");
        } else {
            Assertions.assertTrue(driver.findElements(checkoutLocators.getMissingCityMessage()).isEmpty(),"Поле ввода города не принимает валидное значение");
            Assertions.assertTrue(driver.findElements(checkoutLocators.getMissingRegionMessage()).isEmpty(),"Поле ввода региона не принимает валидное значение");
        }

        header.navigateToBasket();
        utility.clearCart(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345!","1234567","Qwerty","йцукЕн","123","123456"})
    public void validateCustomerPostalCode(String value) {
        preparatorySteps();

        checkout.enterPostalCode(value);
        checkout.clickPlaceAnOrderButton();
        checkout.waitLoadersInvisibility();

        if (value.equals("123456")) {
            Assertions.assertTrue(driver.findElements(checkoutLocators.getMissingPostalCodeMessage()).isEmpty(), "После ввода почтового индекса не принимает валидное значение");
        } else if (value.equals("1234567")) {
            Assertions.assertEquals("123456",driver.findElement(checkoutLocators.getPostalCodeField()).getAttribute("value"),"В поле ввода почтового индекса возможно ввести более 6 символов");
        } else {
            Assertions.assertFalse(driver.findElements(checkoutLocators.getMissingPostalCodeMessage()).isEmpty(), "После ввода невалидного значения в поле ввода почтового индекса сообщения об ошибке не появилось");
        }

        header.navigateToBasket();
        utility.clearCart(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"89247682567","79247682567","Qwerty","Йцукен","8Qwerty","7Йцукен","8924768256!","892473","892476825678"})
    public void validateCustomersPhoneNumber(String value) {
        preparatorySteps();

        checkout.enterPhone(value);
        checkout.clickPlaceAnOrderButton();
        checkout.waitLoadersInvisibility();

        if (value.equals("89247682567") || value.equals("79247682567")) {
            Assertions.assertTrue(driver.findElements(checkoutLocators.getMissingPhoneMessage()).isEmpty(), "Поле ввода телефона не принимает валидное значение");
        } else if (value.equals("892476825678")) {
            Assertions.assertEquals("89247682567",driver.findElement(checkoutLocators.getPhoneField()).getAttribute("value"),"В поле ввода номера телефона возможно ввести более 11 символов");
        } else {
            Assertions.assertFalse(driver.findElements(checkoutLocators.getMissingPhoneMessage()).isEmpty(), "После ввода невалидного значения в поле ввода номера телефона сообщение об ошибке не появилось");
        }
        header.navigateToBasket();
        utility.clearCart(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"user@example.com",
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
            "username@example.c",
            "username@example..com",
            "username@.example.com",
            "username@example_com",
            "username@example+com",
            "username@",
            "username@example..org",
            "user@name@example.com",
            "user@example.c",
            "user@.com",
            "user@localhost",
            "user@example.123"})
    public void validateCustomersEmail(String value) {
        preparatorySteps();

        checkout.enterEmail(value);
        checkout.clickPlaceAnOrderButton();
        checkout.waitLoadersInvisibility();

        if (value.equals("user@example.com") || value.equals("name.last@example.com") || value.equals("name+last@example.com") || value.equals("name-last@example.com") || value.equals("email@example.co.jp")) {
            Assertions.assertTrue(driver.findElements(checkoutLocators.getInvalidEmailMessage()).isEmpty(), "После ввода email не принимает валидное значение");
        } else {
            Assertions.assertFalse(driver.findElements(checkoutLocators.getInvalidEmailMessage()).isEmpty(), "После ввода не валидного значения не отобразилось ошибки");
        }

        if (value.equals("user@example.123")) {
            header.navigateToBasket();
            utility.clearCart(1);
        }
    }

    @Test
    public void basketProductInfoMatchesCheckoutSummary() {
        utility.login();
        utility.openCatalog();
        utility.addTestItemToCart();

        basket.enterItemQuantity(1,"5");
        basket.clickEmptyElement();

        int itemPrice = utility.formatStringInToInt(basket.getItemPrice(1));
        int itemQuantity = utility.formatStringInToInt(basket.getItemQuantity(1));

        int expectedOrderPrice = itemPrice * itemQuantity;
        String expectedProductTitle = basket.getItemTitle(1);

        basket.clickPlaceAnOrder();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(utility.scrollUpButton));

        int actualOrderPrice = utility.formatStringInToInt(checkout.getOrderFinalPrice());
        String actualProductTitle = checkout.getItemName(1);

        Assertions.assertEquals(expectedOrderPrice,actualOrderPrice,"Общая стоимость заказа при оформлении заказа не совпадает со стоимостью указанной в корзине");
        Assertions.assertTrue(actualProductTitle.contains(expectedProductTitle), "Наименование товара при оформлении не совпадает с наименованием товара добавленного в корзину");

        header.navigateToBasket();
        utility.clearCart(1);
    }
}
