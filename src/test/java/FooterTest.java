import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FooterTest extends BaseTest {

    @BeforeEach
    @Override
    public void setUp() throws NoSuchMethodException {
        super.setUp();
        utility.openMainPage();
    }

    @Test
    public void navigateToAllProductsCategory() {
        String expectedResult = footer.getAllProductsTitle().toUpperCase();
        footer.navigateToAllProductsCategory();
        String actualResult = catalog.getCurrentCategoryTitle();
        Assertions.assertEquals(expectedResult,actualResult,"Не удалось перейти в категорию ВСЕ ТОВАРЫ");
    }

    @Test
    public void navigateToMainPage() {
        footer.navigateToMainPage();
        boolean actualResult = driver.findElement(mainPageLocators.getPromoBookSection()).isDisplayed();
        Assertions.assertTrue(actualResult, "Не удалось перейти на главную страницу через навигационное меню в футере");
    }

    @Test
    public void notAuthorized_NavigateToEmptyBasket_emptyCartMessageDisplayed() {
        footer.navigateToBasket();
        boolean actualResult = driver.findElement(basketLocators.getAlertElementBasketEmpty()).isDisplayed();
        Assertions.assertTrue(actualResult, "При переходе в пустую корзину не отобразилось сообщение о том, что корзина пуста");
    }

    @Test
    public void authorized_NavigateToEmptyBasket_emptyCartMessageDisplayed() {
        utility.login();
        footer.navigateToBasket();
        boolean actualResult = driver.findElement(basketLocators.getAlertElementBasketEmpty()).isDisplayed();
        Assertions.assertTrue(actualResult, "При переходе в пустую корзину не отобразилось сообщение о том, что корзина пуста");
    }

    @Test
    public void notAuthorized_NavigateToBasketWithItem_ItemDisplayed() {
        mainPage.navigateToPromoTabletSection();
        String expectedResult = catalog.getCategoryItemTitle(1);
        catalog.clickAddToCartButton(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLocators.getMoreDetailsButton(1)));
        footer.navigateToBasket();
        String actualResult = basket.getItemTitle(1);

        Assertions.assertEquals(expectedResult,actualResult,"Не удалось добавить товар в корзину");

        utility.clearCart(1);
    }

    @Test
    public void authorized_NavigateToBasketWithItem_ItemDisplayed() {
        utility.login();

        footer.navigateToMainPage();
        mainPage.navigateToPromoTabletSection();

        String expectedResult = catalog.getCategoryItemTitle(1);
        catalog.clickAddToCartButton(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLocators.getMoreDetailsButton(1)));
        footer.navigateToBasket();
        String actualResult = basket.getItemTitle(1);

        Assertions.assertEquals(expectedResult,actualResult,"Не удалось добавить товар в корзину");

        utility.clearCart(1);
    }

    @Test
    public void notAuthorized_NavigateToMyAccount_AuthorizationFormDisplayed() {
        footer.navigateToMyAccount();
        Assertions.assertTrue(authoriztionForm.authorizationForm().isDisplayed(), "Не отобразилась форма авторизации");
    }

    @Test
    public void authorized_NavigateToMyAccount_OrdersSectionDisplayed() {
        utility.login();
        footer.navigateToMyAccount();
        Assertions.assertTrue(driver.findElement(myAccountLocators.getOrdersSection()).isDisplayed(), "Не отобразился раздел расположенный в личном кабинете");
    }

    @Test
    public void notAuthorizedEmptyCart_NavigateToCheckout_EmptyCartMessageDisplayed() {
        footer.navigateToCheckout();
        Assertions.assertTrue(driver.findElement(basketLocators.getAlertElementBasketEmpty()).isDisplayed(), "Не отображается сообщение о пустой корзине");
    }

    @Test
    public void notAuthorizedCartWithItem_NavigateToCheckout_AuthorizationLingDisplayed() {
        header.navigateToCatalog();
        catalog.navigateToCategoryItem(10);
        productCard.clickAddToCart();
        footer.navigateToCheckout();
        Assertions.assertTrue(driver.findElement(checkoutLocators.getAuthorizationFormLink()).isDisplayed(), "Не отображается ссылка к форме авторизации");
    }

    @Test
    public void authorizedEmptyCart_NavigateToCheckout_EmptyCartMessageDisplayed() {
        utility.login();
        footer.navigateToCheckout();
        Assertions.assertTrue(driver.findElement(basketLocators.getAlertElementBasketEmpty()).isDisplayed(), "Не отображается сообщение о пустой корзине");
    }

    @Test
    public void authorizedCartWithItem_NavigateToCheckout_CheckoutFormDisplayed() {
        utility.login();
        header.navigateToCatalog();
        catalog.navigateToCategoryItem(10);
        productCard.clickAddToCart();
        footer.navigateToCheckout();
        Assertions.assertTrue(checkout.checkoutForm().isDisplayed(), "Перехода к оформлению заказа не произошло");
        footer.navigateToBasket();
        utility.clearCart(1);
    }

    @Test
    public void notAuthorized_NavigateToRegistration_RegistrationFormDisplayed() {
        footer.navigateToRegistrationFOrm();
        Assertions.assertTrue(driver.findElement(registrationFormLocators.getRegistrationForm()).isDisplayed(), "Форма регистрации не отобразилась");
    }

    @Test
    public void authorized_NavigateToRegistration_RegistrationCompleteMessageDisplayed() {
        utility.login();
        footer.navigateToRegistrationFOrm();
        Assertions.assertTrue(driver.findElement(registrationFormLocators.getRegistrationCompleteMessage()).getText().contains("Регистрация завершена"), "Не отображается сообщение о том, что регистрация уже завершена");
    }
}
