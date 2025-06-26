import authorization.AuthorizationFormLocators;
import authorization.AuthoriztionForm;
import basket.Basket;
import basket.BasketLocators;
import catalog_productcard.Catalog;
import catalog_productcard.CatalogLocators;
import catalog_productcard.ProductCard;
import catalog_productcard.ProductCardLocators;
import checkout.Checkout;
import checkout.CheckoutLocators;
import footer.Footer;
import footer.FooterLocators;
import header.Header;
import header.HeaderLocators;
import mainpage.MainPage;
import mainpage.MainPageLocators;
import myaccount.MyAccount;
import myaccount.MyAccountLocators;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import registration.RegistrationForm;
import registration.RegistrationFormLocators;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    protected Utility utility;

    protected Catalog catalog;
    protected ProductCard productCard;
    protected MainPage mainPage;
    protected AuthoriztionForm authoriztionForm;
    protected Basket basket;
    protected Checkout checkout;
    protected Footer footer;
    protected Header header;
    protected MyAccount myAccount;
    protected RegistrationForm registrationForm;

    protected CatalogLocators catalogLocators;
    protected ProductCardLocators productCardLocators;
    protected MainPageLocators mainPageLocators;
    protected AuthorizationFormLocators authorizationFormLocators;
    protected BasketLocators basketLocators;
    protected CheckoutLocators checkoutLocators;
    protected FooterLocators footerLocators;
    protected HeaderLocators headerLocators;
    protected MyAccountLocators myAccountLocators;
    protected RegistrationFormLocators registrationFormLocators;

    @BeforeEach
    public void setUp() throws NoSuchMethodException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);

        utility = new Utility(driver,wait,action);
        catalog = new Catalog(driver,wait,action);
        productCard = new ProductCard(driver,wait);
        mainPage = new MainPage(driver,wait);
        authoriztionForm = new AuthoriztionForm(driver,wait);
        basket = new Basket(driver,wait);
        checkout = new Checkout(driver,wait);
        footer = new Footer(driver,wait);
        header = new Header(driver,wait);
        myAccount = new MyAccount(driver,wait);
        registrationForm = new RegistrationForm(driver,wait);

        catalogLocators = new CatalogLocators();
        productCardLocators = new ProductCardLocators();
        mainPageLocators = new MainPageLocators();
        authorizationFormLocators = new AuthorizationFormLocators();
        basketLocators = new BasketLocators();
        checkoutLocators = new CheckoutLocators();
        footerLocators = new FooterLocators();
        headerLocators = new HeaderLocators();
        myAccountLocators = new MyAccountLocators();
        registrationFormLocators = new RegistrationFormLocators();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void thumbnailsIsDisplayed (By locator) throws IOException {
        List <WebElement> imageList = driver.findElements(locator);
        List <String> imageUrlList = new ArrayList<>();
        for (WebElement element : imageList) {
            String imageURL = element.getAttribute("src");
            imageUrlList.add(imageURL);
        }
        CloseableHttpClient httpClient = utility.httpClient(216,12,5000);
        boolean allImagesLoaded = true;
        for (int i = 0; i < imageUrlList.size(); i++) {
            HttpGet request = new HttpGet(imageUrlList.get(i));
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 404) {
                WebElement parentElement = imageList.get(i).findElement(By.xpath(".."));
                String parentLink = parentElement.getAttribute("href");
                System.out.println("Не отображается изображение товара №" + (i + 1) + ": " + parentLink);
                allImagesLoaded = false;
            }
        }
        Assertions.assertTrue(allImagesLoaded, "Отображаются не все миниатюры товаров");
        httpClient.close();
    }
}
