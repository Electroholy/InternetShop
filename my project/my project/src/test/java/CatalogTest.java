import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class CatalogTest extends BaseTest {

    @BeforeEach
    @Override
    public void setUp() throws NoSuchMethodException {
        super.setUp();
        utility.openCatalog();
    }

    @Test
    public void currentCategoryItemThumbnail_IsDisplayed() throws IOException {
        thumbnailsIsDisplayed(catalogLocators.getCategoryItemThumbnailLocator());
    }

    @Test
    public void navigationOfCategoryMenu_ItemTitleIdentical() {
        for (int i = 1; i <= 13; i++) {
            String expectedResult = catalog.getCategoryName(i).toLowerCase();
            catalog.navigateToCategory(i);
            String actualResult = catalog.getCurrentCategoryTitle().toLowerCase();
            Assertions.assertEquals(expectedResult,actualResult,"Произошёл переход в другую категорию");
            header.navigateToCatalog();
        }
    }

    @Test
    public void leftPriceFilter() {
        catalog.navigateToCategory(8);

        catalog.moveLeftPriceFilterSlider(100);
        catalog.clickPriceFilterApplyButton();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogLocators.getAllCategoryItemPrice()));
        List <WebElement> itemCount = driver.findElements(catalogLocators.getAllCategoryItemPrice());

        for (int i = 1; i <= itemCount.size(); i++) {
            int price = utility.formatStringInToInt(catalog.getCategoryItemPrice(i));
            Assertions.assertTrue(price >= 82990 && price <= 219990);
        }
    }

    @Test
    public void rightPriceFilter() {
        catalog.navigateToCategory(8);

        catalog.moveRightPriceFilterSlider(-280);
        catalog.clickPriceFilterApplyButton();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogLocators.getAllCategoryItemPrice()));
        List <WebElement> itemCount = driver.findElements(catalogLocators.getAllCategoryItemPrice());

        for (int i = 1; i <= itemCount.size(); i++) {
            int price = utility.formatStringInToInt(catalog.getCategoryItemPrice(i));
            Assertions.assertTrue(price >= 11990 && price <= 39990, "Отображаются товары другой ценовой категории");
        }
    }

    @Test
    public void navigateToProductsSectionItem_ItemTitleIdentical() {
        for (int i = 1; i <= 5; i++) {
            String expectedResult = catalog.getProductsSectionItemTitle(i);
            catalog.navigateToProductsSectionItem(i);
            String actualResult = productCard.getItemTitle();
            Assertions.assertEquals(expectedResult,actualResult,"Произошёл переход в карточку другого товара");
            header.navigateToCatalog();
        }
    }

    @Test
    public void sortByAscending_AscendingPrice() {
        catalog.navigateToCategory(8);
        catalog.openSortingDropdownMenu();
        catalog.sortByAscending();

        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLocators.getAllCategoryItemPrice()));
        List <WebElement> itemCount = driver.findElements(catalogLocators.getAllCategoryItemPrice());

        for (int i = 1; i <= itemCount.size(); i++) {
            int price = utility.formatStringInToInt(catalog.getCategoryItemPrice(i));

            if (i == itemCount.size()) {
                Assertions.assertEquals(219990, price);
            } else {
                int nextItemPrice = utility.formatStringInToInt(catalog.getCategoryItemPrice(i + 1));
                Assertions.assertTrue(price < nextItemPrice, "Предметы не отсортированы по возрастанию цены");
            }
        }
    }

    @Test
    public void sortByDescending_DescendingPrice() {
        catalog.navigateToCategory(8);
        catalog.openSortingDropdownMenu();
        catalog.sortByDescending();

        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLocators.getAllCategoryItemPrice()));
        List <WebElement> itemCount = driver.findElements(catalogLocators.getAllCategoryItemPrice());

        for (int i = 1; i <= itemCount.size(); i++) {
            int price = utility.formatStringInToInt(catalog.getCategoryItemPrice(i));

            if (i == itemCount.size()) {
                Assertions.assertEquals(11990, price);
            } else {
                int nextItemPrice = utility.formatStringInToInt(catalog.getCategoryItemPrice(i + 1));
                Assertions.assertTrue(price > nextItemPrice, "Предметы не отсортированы по убыванию цены");
            }
        }
    }

    @Test
    public void navigateToCategoryItem_ItemTitleIdentical() {
        catalog.navigateToCategory(9);
        int itemCount = utility.formatStringInToInt(catalog.getCategoryItemAmountDisplayed());
        for (int i = 1; i <= itemCount; i++) {
            String expectedResult = catalog.getCategoryItemTitle(i);
            catalog.navigateToCategoryItem(i);
            String actualResult = productCard.getItemTitle();
            Assertions.assertEquals(expectedResult,actualResult,"Произошёл переход в карточку другого товара");
            catalog.navigateToCategory(9);
        }
    }

    @Test
    public void pagination_PageNumberChanged() {
        catalog.navigateToCategory(13);

        catalog.clickNextPageArrowButton();
        String actualResult1 = catalog.getBreadcrumbCurrentSection();
        Assertions.assertEquals("Page 2",actualResult1,"Перехода к второй странице не произошло");

        catalog.clickNextPageArrowButton();
        String actualResult2 = catalog.getBreadcrumbCurrentSection();
        Assertions.assertEquals("Page 3", actualResult2,"Перехода к третей странице не произошло");
    }

    @Test
    public void addProductToCart() {
        catalog.navigateToCategory(8);

        String expectedResult = catalog.getCategoryItemTitle(1);
        catalog.clickAddToCartButton(1);

        catalog.clickMoreDetailsButton(1);
        String actualResult = basket.getItemTitle(1);

        Assertions.assertEquals(expectedResult,actualResult,"Товар не добавился в корзину");
    }
}
