import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class HeaderTest extends BaseTest {

    @BeforeEach
    @Override
    public void setUp() throws NoSuchMethodException {
        super.setUp();
        utility.openMainPage();
    }

    @Test
    public void navigateToMainPage_TopPromoSectionIsDisplayed() {
        header.navigateToMainPage();

        Assertions.assertTrue(driver.findElement(mainPageLocators.getTopPromoSectionThumbnails()).isDisplayed(), "Перехода не произошло");
    }

    @Test
    public void navigateToCatalog_SectionTitleIdentical() {
        String actualResult = driver.findElement(headerLocators.getCatalog()).getText();
        header.navigateToCatalog();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в каталог не произошло");
    }

    @Test
    public void navigateToHouseholdAppliancesCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        String actualResult = driver.findElement(headerLocators.getMainMenuHouseholdAppliancesSection()).getText();
        header.navigateToHouseholdAppliancesCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void navigateToFridgeCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        utility.moveToElement(headerLocators.getMainMenuHouseholdAppliancesSection());
        wait.until(ExpectedConditions.visibilityOf(header.householdAppliancesDropdownMenu()));

        String actualResult = driver.findElement(headerLocators.getSubmenuFridgeSection()).getText();
        header.navigateToFridgeCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void navigateToWashingMachineCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        utility.moveToElement(headerLocators.getMainMenuHouseholdAppliancesSection());
        wait.until(ExpectedConditions.visibilityOf(header.householdAppliancesDropdownMenu()));

        String actualResult = driver.findElement(headerLocators.getSubmenuWashingMachineSection()).getText();
        header.navigateToWashingMachineCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void navigateToElectronicsCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        String actualResult = driver.findElement(headerLocators.getMainMenuElectronicsSection()).getText();
        header.navigateToElectronicCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void navigateToPhoneCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        utility.moveToElement(headerLocators.getMainMenuElectronicsSection());
        wait.until(ExpectedConditions.visibilityOf(header.electronicsDropdownMenu()));

        String actualResult = driver.findElement(headerLocators.getSubmenuPhoneSection()).getText();
        header.navigateToPhoneCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void navigateToTabletCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        utility.moveToElement(headerLocators.getMainMenuElectronicsSection());
        wait.until(ExpectedConditions.visibilityOf(header.electronicsDropdownMenu()));

        String actualResult = driver.findElement(headerLocators.getSubmenuTabletSection()).getText();
        header.navigateToTabletCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void navigateToTelevisionCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        utility.moveToElement(headerLocators.getMainMenuElectronicsSection());
        wait.until(ExpectedConditions.visibilityOf(header.electronicsDropdownMenu()));

        String actualResult = driver.findElement(headerLocators.getSubmenuTelevisionSection()).getText();
        header.navigateToTelevisionCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void navigateToCameraCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        utility.moveToElement(headerLocators.getMainMenuElectronicsSection());
        wait.until(ExpectedConditions.visibilityOf(header.electronicsDropdownMenu()));

        String actualResult = driver.findElement(headerLocators.getSubmenuPhotoVideoSection()).getText();
        header.navigateToCameraCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void navigateToWatchesCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        utility.moveToElement(headerLocators.getMainMenuElectronicsSection());
        wait.until(ExpectedConditions.visibilityOf(header.electronicsDropdownMenu()));

        String actualResult = driver.findElement(headerLocators.getSubmenuWatchesSection()).getText();
        header.navigateToWatchesCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void navigateToBooksCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        String actualResult = driver.findElement(headerLocators.getMainMenuBooksSection()).getText();
        header.navigateToBooksCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void navigateToClothCategory_CategoryTitleIdentical() {
        utility.moveToElement(headerLocators.getCatalog());
        wait.until(ExpectedConditions.visibilityOf(header.catalogDropDownMenu()));

        String actualResult = driver.findElement(headerLocators.getMainMenuClothSection()).getText();
        header.navigateToClothCategory();
        String expectedResult = catalog.getCurrentCategoryTitle();

        Assertions.assertEquals(expectedResult,actualResult,"Перехода в выбранную категорию товаров не произошло");
    }

    @Test
    public void notAuthorized_NavigateToMyAccount_AuthorizedFormDisplayed() {
        header.navigateToMyAccount();
        Assertions.assertTrue(authoriztionForm.authorizationForm().isDisplayed(), "Форма авторизации не отображается");
    }

    @Test
    public void authorized_NavigateToMyAccount_OrdersSectionDisplayed() {
        utility.login();
        header.navigateToMyAccount();
        Assertions.assertTrue(driver.findElement(myAccountLocators.getOrdersSection()).isDisplayed(), "Не удалось перейти в \"Мой аккаунт\"");
    }

    @Test
    public void notAuthorized_NavigateToEmptyBasket_BasketIsEmptyMessageDisplayed() {
        header.navigateToBasket();
        Assertions.assertTrue(driver.findElement(basketLocators.getAlertElementBasketEmpty()).isDisplayed(), "При переходе в пустую корзину сообщение о том, что корзина пуста - не отображается");
    }

    @Test
    public void authorized_NavigateToEmptyBasket_BasketIsEmptyMessageDisplayed() {
        utility.login();
        header.navigateToBasket();
        Assertions.assertTrue(driver.findElement(basketLocators.getAlertElementBasketEmpty()).isDisplayed(), "При переходе в пустую корзину сообщение о том, что корзина пуста - не отображается");
    }

    @Test
    public void notAuthorized_NavigateToBasketWithItem_ItemDisplayed() {
        header.navigateToCatalog();

        utility.moveToElement(catalogLocators.getCategoryItem(10));
        catalog.clickAddToCartButton(10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLocators.getMoreDetailsButton(1)));
        catalog.clickMoreDetailsButton(1);

        Assertions.assertTrue(driver.findElement(basketLocators.getItem(1)).isDisplayed(), "Товар не добавился в корзину");
    }

    @Test
    public void authorized_NavigateToBasketWithItem_ItemDisplayed() {
        utility.login();
        header.navigateToCatalog();

        utility.moveToElement(catalogLocators.getCategoryItem(10));
        catalog.clickAddToCartButton(10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLocators.getMoreDetailsButton(1)));
        catalog.clickMoreDetailsButton(1);

        Assertions.assertTrue(driver.findElement(basketLocators.getItem(1)).isDisplayed(), "Товар не добавился в корзину");

        utility.clearCart(1);
    }

    @Test
    public void notAuthorized_NavigateToCheckoutEmptyCart_MessageEmptyCartDisplayed() {
        header.navigateToCheckout();
        Assertions.assertTrue(driver.findElement(basketLocators.getAlertElementBasketEmpty()).isDisplayed(), "Сообщение о том, что корзина пуста - не отображается");
    }

    @Test
    public void authorized_NavigateToCheckoutEmptyCart_MessageEmptyCartDisplayed() {
        utility.login();
        header.navigateToCheckout();
        Assertions.assertTrue(driver.findElement(basketLocators.getAlertElementBasketEmpty()).isDisplayed(), "Сообщение о том, что корзина пуста - не отображается");
    }

    @Test
    public void notAuthorized_NavigateToCheckoutCartWithItem_AuthorizationLinkDisplayed() {
        header.navigateToCatalog();

        utility.moveToElement(catalogLocators.getCategoryItem(10));
        catalog.clickAddToCartButton(10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLocators.getMoreDetailsButton(1)));
        catalog.clickMoreDetailsButton(1);

        header.navigateToCheckout();

        Assertions.assertTrue(driver.findElement(checkoutLocators.getAuthorizationFormLink()).isDisplayed(), "Ссылка ведущая к авторизации не отображается");
    }

    @Test
    public void authorized_NavigateToCheckoutCartWithItem_CheckoutFormDisplayed() {
        utility.login();
        header.navigateToCatalog();

        utility.moveToElement(catalogLocators.getCategoryItem(10));
        catalog.clickAddToCartButton(10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLocators.getMoreDetailsButton(1)));
        catalog.clickMoreDetailsButton(1);

        header.navigateToCheckout();

        Assertions.assertTrue(checkout.checkoutForm().isDisplayed(), "Не удалось перейти в раздел оформления заказа");

        header.navigateToBasket();
        utility.clearCart(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"LED телевизор", "LED ТЕЛЕВИЗОР", "led телевизор", "led ТЕЛЕВИЗОР", "led телев", "LED телев", " led телевизор", "led телевизор ", " led телевизор", "LED TV", "qwerty123"})
    public void productSearch_itemTitleIdentical (String productName) {
        header.enterItemName_SearchField(productName);
        header.clickSearchItem();

        List <WebElement> productTitle = driver.findElements(catalogLocators.getAllCategoryItemTitle());

        for (int i = 1; i <= productTitle.size(); i++) {
            String itemTitle = catalog.getCategoryItemTitle(i).toLowerCase();

            if (productName.equals("qwerty123")) {
                Assertions.assertEquals("По вашему запросу товары не найдены.", driver.findElement(catalogLocators.getNotFoundItemMessage()).getText(),"При вводе имени несуществующего товара в поле поиска - были найдены товары");
            } else if (productName.equalsIgnoreCase("LED TV")) {
                Assertions.assertTrue(itemTitle.contains("led"), "При поиске товара были найдены товары с другим названием");
            } else {
                Assertions.assertTrue(itemTitle.contains(productName.toLowerCase()), "При поиске товара были найдены товары с другим названием");
            }
        }
    }
}