import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class MainPageTest extends BaseTest {

    @BeforeEach
    @Override
    public void setUp() throws NoSuchMethodException {
        super.setUp();
        utility.openMainPage();
    }

    @Test
    public void navigateToPromoBookSection_SectionTitleIdentical() {
        String expectedResult = mainPage.getPromoBookSectionTitle();
        mainPage.navigateToPromoBookSection();
        String actualResult = catalog.getCurrentCategoryTitle();
        Assertions.assertEquals(expectedResult,actualResult,"Заголовки промо-раздела и категории товаров не совпадают");
    }

    @Test
    public void navigateToPromoTabletSection_SectionTitleIdentical() {
        String expectedResult = mainPage.getPromoTabletSectionTitle();
        mainPage.navigateToPromoTabletSection();
        String actualResult = catalog.getCurrentCategoryTitle();
        Assertions.assertEquals(expectedResult,actualResult,"Заголовки промо-раздела и категории товаров не совпадают");
    }

    @Test
    public void navigateToPromoCameraSection_SectionTitleIdentical() {
        String expectedResult = mainPage.getPromoCameraSectionTitle();
        mainPage.navigateToPromoCameraSection();
        String actualResult = catalog.getCurrentCategoryTitle();
        Assertions.assertEquals(expectedResult,actualResult,"Заголовки промо-раздела и категории товаров не совпадают");
    }

    @Test
    public void topPromoSectionThumbnails_IsDisplayed() throws IOException {
        thumbnailsIsDisplayed(mainPageLocators.getTopPromoSectionThumbnails());
    }

    @Test
    public void navigateToSaleSectionItem_ItemTitleIdentical() {
        for (int i = 1; i <= 4; i++) {
            String expectedResult = mainPage.getSaleSectionItemTitle(i).toUpperCase();
            mainPage.navigateToSaleSectionItem(i);
            String actualResult = productCard.getItemTitle().toUpperCase();

            try {
                Assertions.assertEquals(expectedResult,actualResult,"Заголовки продукта в разделе \"Распродажа\" и в карточке товара не совпадают");
            } catch (AssertionError e) {
                System.out.println("Ошибка для элемента №" + i + ": " + e.getMessage());
            }
            header.navigateToMainPage();
            utility.moveToElement(mainPageLocators.getSaleSectionItemTitle(1));
        }

        for (int i = 5; i <= 10; i++) {
            for (int j = 1; j <= (i - 4); j++) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageLocators.getSaleSectionItem(4)));
                utility.moveToElement((mainPageLocators.getSaleSectionNextSlide()));
                mainPage.clickSaleSectionNextSlide();
            }
            String expectedResult = mainPage.getSaleSectionItemTitle(4).toUpperCase();
            mainPage.navigateToSaleSectionItem(4);
            String actualResult = productCard.getItemTitle().toUpperCase();

            try {
                Assertions.assertEquals(expectedResult,actualResult,"Заголовки продукта в разделе \"Распродажа\" и в карточке товара не совпадают");
            } catch (AssertionError e) {
                System.out.println("Ошибка для элемента №" + i + ": " + e.getMessage());
            }
            header.navigateToMainPage();
            utility.moveToElement(mainPageLocators.getSaleSectionItemTitle(1));
        }
    }

    @Test
    public void saleSectionThumbnails_IsDisplayed() throws IOException {
        thumbnailsIsDisplayed(mainPageLocators.getSaleSectionAllThumbnailsLocator());
    }

    @Test
    public void clickLeftSaleSectionSlider_ItemBecameSecond() {
        utility.moveToElement(mainPageLocators.getSaleSectionPreviousSlide());
        String actualResult = mainPage.getSaleSectionItemTitle(1);
        mainPage.clickSaleSectionPreviousSlide();
        String expectedResult = mainPage.getSaleSectionItemTitle(2);
        Assertions.assertEquals(expectedResult,actualResult,"После клика на слайдер карусель не прокрутилась");
    }

    @Test
    public void clickRightSaleSectionSlider_ItemBecameThird() {
        utility.moveToElement(mainPageLocators.getSaleSectionNextSlide());
        String actualResult = mainPage.getSaleSectionItemTitle(4);
        mainPage.clickSaleSectionNextSlide();
        String expectedResult = mainPage.getSaleSectionItemTitle(3);
        Assertions.assertEquals(expectedResult,actualResult,"После клика на слайдер карусель не прокрутилась");
    }

    @Test
    public void saleSectionItemOnSaleMark_OnSaleMarkIsDisplayed() {
        for (int i = 1; i <= 4; i++) {
            boolean markIsDisplayed = mainPage.checkItemOnSaleMark(i);
            try {
                Assertions.assertTrue(markIsDisplayed, "Пометка товара \"Скидка!\" не отображается");
            } catch (AssertionError e) {
                System.out.println("Ошибка с элементом №" + i + ": " + e.getMessage());
            }
        }

        for (int i = 5; i <= 10; i++) {
            for (int j = 1; j < (i - 4); j ++) {
                utility.moveToElement(mainPageLocators.getSaleSectionNextSlide());
                mainPage.clickSaleSectionNextSlide();
            }
            boolean markIsDisplayed = mainPage.checkItemOnSaleMark(4);
            try {
                Assertions.assertTrue(markIsDisplayed, "Пометка товара \"Скидка!\" не отображается");
            } catch (AssertionError e) {
                System.out.println("Ошибка с элементом №" + i + ": " + e.getMessage());
            }
        }
    }

    @Test
    public void navigateToBottomPromoSection() {
        utility.moveToElement(mainPageLocators.getBottomPromoSection());
        String expectedResult = mainPage.getBottomPromoSectionItemTitle().toUpperCase();
        mainPage.navigateToBottomPromoSection();
        String actualResult = productCard.getItemTitle().toUpperCase();
        Assertions.assertEquals(expectedResult,actualResult,"Ссылка в промо-разделе ведёт к другому товару");
    }

    @Test
    public void bottomPromoSectionThumbnail_IsDisplayed() throws IOException {
        utility.moveToElement(mainPageLocators.getBottomPromoSectionThumbnail());
        thumbnailsIsDisplayed(mainPageLocators.getBottomPromoSectionThumbnail());
    }

    @Test
    public void navigateToNewArrivalsSectionItem_ItemTitleIdentical() {
        for (int i = 1; i <= 4; i++) {
            utility.moveToElement(mainPageLocators.getNewArrivalsSectionItemTitle(1));
            String actualResult = mainPage.getNewArrivalsSectionItemTitle(i).toUpperCase();
            mainPage.navigateToNewArrivalsSectionItem(i);
            String expectedResult = productCard.getItemTitle().toUpperCase();

            try {
                Assertions.assertEquals(expectedResult,actualResult,"Заголовки продукта в разделе \"Новые поступления\" и в карточке товара не совпадают");
            } catch (AssertionError e) {
                System.out.println("Ошибка с элементом №" + i + ": " + e.getMessage());
            }
            header.navigateToMainPage();
        }

        for (int i = 5; i <= 8; i++) {
            for (int j = 1; j <= (i - 4); j++) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageLocators.getNewArrivalsSectionItem(4)));
                utility.moveToElement(mainPageLocators.getNewArrivalsSectionNextSlideButton());
                mainPage.clickNewArrivalsSectionNextSlide();
            }
            String actualResult = mainPage.getNewArrivalsSectionItemTitle(4).toUpperCase();
            mainPage.navigateToNewArrivalsSectionItem(4);
            String expectedResult = productCard.getItemTitle().toUpperCase();

            try {
                Assertions.assertEquals(expectedResult,actualResult,"Заголовки продукта в разделе \"Новые поступления\" и в карточке товара не совпадают");
            } catch (AssertionError e) {
                System.out.println("Ошибка с элементом №" + i + ": " + e.getMessage());
            }
            header.navigateToMainPage();
        }
    }

    @Test
    public void newArrivalsSectionThumbnails_IsDisplayed() throws IOException {
        thumbnailsIsDisplayed(mainPageLocators.getNewArrivalsSectionAllThumbnailsSection());
    }

    @Test
    public void clickLeftNewArrivalsSectionSlider_ItemBecameSecond() {
        utility.moveToElement(mainPageLocators.getNewArrivalsSectionPreviousSlideButton());
        String expectedResult = mainPage.getNewArrivalsSectionItemTitle(1);
        mainPage.clickNewArrivalsSectionPreviousSlide();
        String actualResult = mainPage.getNewArrivalsSectionItemTitle(2);

        Assertions.assertEquals(expectedResult,actualResult,"После клика на слайдер карусель не прокрутилась");
    }

    @Test
    public void clickRightNewArrivalsSectionSlider_ItemBecameThird() {
        utility.moveToElement(mainPageLocators.getNewArrivalsSectionNextSlideButton());
        String expectedResult = mainPage.getNewArrivalsSectionItemTitle(4);
        mainPage.clickNewArrivalsSectionNextSlide();
        String actualResult = mainPage.getNewArrivalsSectionItemTitle(3);

        Assertions.assertEquals(expectedResult,actualResult,"После клика на слайдер карусель не прокрутилась");
    }

    @Test
    public void newArrivalsSectionItemNewArrivalMark_NewArrivalMarkIsDisplayed() {
        utility.moveToElement(mainPageLocators.getNewArrivalsSectionItem(1));
        for (int i = 1; i <= 4; i++) {
            boolean newArrivalMarkIsDisplayed = mainPage.checkItemNewArrivalMark(i);
            try {
                Assertions.assertTrue(newArrivalMarkIsDisplayed, "Пометка товара \"Новый!\" не отображается");
            } catch (AssertionError e) {
                System.out.println("Ошибка с элементом №" + i + ": " + e.getMessage());
            }
        }

        for (int i = 5; i <= 8; i++) {
            for (int j = 1; j <= (i - 4); j++) {
                utility.moveToElement(mainPageLocators.getNewArrivalsSectionNextSlideButton());
                mainPage.clickNewArrivalsSectionNextSlide();
            }
            boolean newArrivalsMarkIsDisplayed = mainPage.checkItemNewArrivalMark(4);
            try {
                Assertions.assertTrue(newArrivalsMarkIsDisplayed, "Пометка товара \"Новый!\" не отображается");
            } catch (AssertionError e) {
                System.out.println("Ошибка с элементом №" + i + ": " + e.getMessage());
            }
        }
    }

    @Test
    public void recentlyViewedSection_ItemIsDisplayed() {
        mainPage.navigateToSaleSectionItem(1);
        String firstItemExpectedResult = productCard.getItemTitle();
        header.navigateToMainPage();

        mainPage.navigateToSaleSectionItem(2);
        String secondItemExpectedResult = productCard.getItemTitle();
        header.navigateToMainPage();

        mainPage.navigateToSaleSectionItem(3);
        String thirdItemExpectedResult = productCard.getItemTitle();
        header.navigateToMainPage();

        driver.navigate().refresh();
        utility.moveToElement(mainPageLocators.getRecentlyViewedSectionItemTitle(3));

        String firstItemActualResult = mainPage.getRecentlyViewedSectionItemTitle(3);
        String secondItemActualResult = mainPage.getRecentlyViewedSectionItemTitle(2);
        String thirdItemActualResult = mainPage.getRecentlyViewedSectionItemTitle(1);

        try {
            Assertions.assertEquals(firstItemExpectedResult,firstItemActualResult,"Заголовки не совпадают");
            Assertions.assertEquals(secondItemExpectedResult,secondItemActualResult,"Заголовки не совпадают");
            Assertions.assertEquals(thirdItemExpectedResult,thirdItemActualResult,"Заголовки не совпадают");
        } catch (AssertionError e) {
            System.out.println("Товар не отобразился в разделе \"Просмотренные товары\": " + e.getMessage());
        }
    }

    @Test
    public void recentlyViewedSectionItemThumbnails_ThumbnailsIsDisplayed() throws IOException {

        for (int i = 1; i <= 4; i++) {
            mainPage.navigateToSaleSectionItem(i);
            header.navigateToMainPage();
        }

        driver.navigate().refresh();

        thumbnailsIsDisplayed(mainPageLocators.getRecentlyViewedSectionItemThumbnailsLocator());
    }

    @Test
    public void navigateToRecentlyViewedItems_TitleIsIdentical() {

        for (int i = 1; i <= 4; i++) {
            mainPage.navigateToSaleSectionItem(i);
            header.navigateToMainPage();
        }

        driver.navigate().refresh();

        for (int i = 1; i <= 4; i++) {
            utility.moveToElement(mainPageLocators.getRecentlyViewedSectionItemTitle(i));
            String actualResult = mainPage.getRecentlyViewedSectionItemTitle(i).toUpperCase();
            mainPage.navigateToRecentlyViewedSectionItemByTitle(i);
            String expectedResult = productCard.getItemTitle().toUpperCase();
            header.navigateToMainPage();

            try {
                Assertions.assertEquals(expectedResult,actualResult,"Заголовки не совпадают");
            } catch (AssertionError e) {
                System.out.println("Перехода к карточке товара не произошло: " + e.getMessage());
            }
        }
    }
}