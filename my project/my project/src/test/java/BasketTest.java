import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class BasketTest extends BaseTest {

    private final String coupon = "sert500";
    private final String invalidCoupon = "qwejkl23";

    @BeforeEach
    @Override
    public void setUp() throws NoSuchMethodException {
        super.setUp();
        utility.openCatalog();
    }

    @Test
    public void changeItemQuantity_TotalPriceChanged() {
        utility.addTestItemToCart();

        basket.enterItemQuantity(1, "3");
        basket.clickEmptyElement();
        wait.until(ExpectedConditions.visibilityOfElementLocated(basketLocators.getAlertElement()));

        int expectedResult = utility.formatStringInToInt(basket.getItemTotalPrice(1));
        int actualResult = (utility.formatStringInToInt(basket.getItemPrice(1))) * 3;

        Assertions.assertEquals(expectedResult,actualResult,"После изменения кол-ва товара общая стоимость изменяется некорректно");
        utility.clearCart(1);
    }

    @Test
    public void navigateToProductCardByName_ItemTitleIdentical() {
        utility.addTestItemToCart();

        String expectedResult = basket.getItemTitle(1);
        basket.navigateToItemByName(1);
        String actualResult = productCard.getItemTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Произошёл переход в карточку другого товара");
    }

    @Test
    public void navigateToProductCardByThumbnail_ItemTitleIdentical() {
        utility.addTestItemToCart();

        String expectedResult = basket.getItemTitle(1);
        basket.navigateToItemByThumbnail(1);
        String actualResult = productCard.getItemTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Произошёл переход в карточку другого товара");
    }

    @Test
    public void applyingCoupon_orderTotalPriceChanged() {
        utility.addTestItemToCart();

        basket.enterCouponCode(coupon);
        basket.clickApplyCoupon();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(basketLocators.getLoader()));

        int itemPrice = utility.formatStringInToInt(basket.getItemTotalPrice(1));
        int discount = utility.formatStringInToInt(basket.getCouponAmountDiscount());

        int actualResult = itemPrice - discount;
        int expectedResult = 29400;

        Assertions.assertEquals(expectedResult,actualResult,"После применения скидки цена была изменена некорректно");
    }

    @Test
    public void removeCoupon_orderTotalPriceChanged() {
        utility.addTestItemToCart();

        basket.enterCouponCode(coupon);
        basket.clickApplyCoupon();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(basketLocators.getLoader()));

        int itemPrice = utility.formatStringInToInt(basket.getCartTotalPrice());
        int discount = utility.formatStringInToInt(basket.getCouponAmountDiscount());

        basket.clickRemoveCoupon();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(basketLocators.getLoader()));

        int actualResult = itemPrice + discount;
        int expectedResult = 29900;

        Assertions.assertEquals(expectedResult,actualResult,"После удаления купона скидка не была удалена");
    }

    @Test
    public void applyingInvalidCoupon_ErrorMessageDisplayed() {
        utility.addTestItemToCart();
        basket.enterCouponCode(invalidCoupon);
        basket.clickApplyCoupon();

        wait.until(ExpectedConditions.visibilityOfElementLocated(basketLocators.getAlertElement()));

        String expectedResult = "Неверный купон.";
        String actualResult = driver.findElement(basketLocators.getAlertElement()).getText();

        if (!actualResult.equals(expectedResult)) {
            Assertions.assertTrue(actualResult.contains(expectedResult), "Текст сообщения ошибки не соответствует ожидаемому результату");
        } else {
            Assertions.assertTrue(driver.findElement(basketLocators.getAlertElement()).isDisplayed(), "Сообщение об ошибке не отобразилось");
        }
    }

    @Test
    public void itemThumbnails_ThumbnailsDisplayed() throws IOException {
        utility.addTestItemToCart();
        thumbnailsIsDisplayed(basketLocators.getItemThumbnailsLocator());
    }

    @Test
    public void returnBackDeletedItem() {
        utility.addTestItemToCart();
        String expectedResult = basket.getItemTitle(1);
        basket.clickRemoveItem(1);
        basket.clickRestoreDeletedItem();
        String actualResult = basket.getItemTitle(1);

        Assertions.assertEquals(expectedResult,actualResult,"Не удалось вернуть удаленный товар обратно в корзину");
    }
}
