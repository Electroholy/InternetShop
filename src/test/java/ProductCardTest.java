import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductCardTest extends BaseTest {

    @BeforeEach
    @Override
    public void setUp() throws NoSuchMethodException {
        super.setUp();
        utility.openCatalog();
    }

    @Test
    public void addProductToCart() {
        catalog.navigateToCategory(9);
        catalog.navigateToCategoryItem(10);

        String expectedResult = productCard.getItemTitle();
        String expectedResultQuantity = "4";

        productCard.enterItemQuantity(expectedResultQuantity);
        productCard.clickAddToCart();
        productCard.navigateToCart();

        String actualResult = basket.getItemTitle(1);
        String actualResultQuantity = basket.getItemQuantity(1);

        Assertions.assertEquals(expectedResult,actualResult,"Товар не был добавлен в корзину");
        Assertions.assertEquals(expectedResultQuantity,actualResultQuantity,"В корзину не было добавлено указанное кол-во единиц товара");
    }

    @Test
    public void navigationOfCategoryMenu_ItemTitleIdentical() {
        catalog.navigateToCategory(9);
        catalog.navigateToCategoryItem(10);
        for (int i = 1; i <= 13; i++) {
            String expectedResult = catalog.getCategoryName(i).toLowerCase();
            catalog.navigateToCategory(i);
            String actualResult = catalog.getCurrentCategoryTitle().toLowerCase();
            Assertions.assertEquals(expectedResult,actualResult,"Произошёл переход в другую категорию");

            catalog.navigateToCategory(9);
            catalog.navigateToCategoryItem(10);
        }
    }

    @Test
    public void navigateToProductsSectionItem_ItemTitleIdentical() {
        catalog.navigateToCategory(9);
        catalog.navigateToCategoryItem(10);
        for (int i = 1; i <= 5; i++) {
            String expectedResult = catalog.getProductsSectionItemTitle(i);
            catalog.navigateToProductsSectionItem(i);
            String actualResult = productCard.getItemTitle();
            Assertions.assertEquals(expectedResult,actualResult,"Произошёл переход в карточку другого товара");
            catalog.navigateToCategory(9);
            catalog.navigateToCategoryItem(10);
        }
    }

    @Test
    public void OpenImageFullscreen_ImageIsOpen() {
        catalog.navigateToCategory(11);
        catalog.navigateToCategoryItem(3);

        productCard.clickOpenThumbnailImage();
        Assertions.assertTrue(productCard.itemImageIsPresent(), "Картинка не открывается");
    }

    @Test
    public void navigateToRelatedSectionItem() {
        catalog.navigateToCategory(11);
        catalog.navigateToCategoryItem(3);
        for (int i = 1; i <= 3; i++) {
            String expectedResult = productCard.getRelatedProductsSectionItemTitle(i);
            productCard.navigateToRelatedProductsSectionItem(i);
            String actualResult = productCard.getItemTitle();
            Assertions.assertEquals(expectedResult,actualResult,"Не удалось перейти в карточку товара");
        }
    }
}
