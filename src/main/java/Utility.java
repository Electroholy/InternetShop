import authorization.AuthoriztionForm;
import basket.Basket;
import catalog_productcard.Catalog;
import header.Header;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Utility {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    Header header;
    AuthoriztionForm authoriztionForm;
    Basket basket;
    Catalog catalog;


    public final By scrollUpButton = By.cssSelector("#ak-top");

    public Utility(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    public void moveToElement(By locator) {
        WebElement element = driver.findElement(locator);
        action.moveToElement(element).perform();
    }

    public void scrollUp() {
        wait.until(ExpectedConditions.elementToBeClickable(scrollUpButton)).click();
    }

    public void openMainPage() {
        driver.navigate().to("https://intershop5.skillbox.ru/");
    }

    public void openCatalog() {
        driver.navigate().to("https://intershop5.skillbox.ru/product-category/catalog/");
    }

    public void openMyAccount() {
        driver.navigate().to("https://intershop5.skillbox.ru/my-account/");
    }

    public void openBasket() {
        driver.navigate().to("https://intershop5.skillbox.ru/cart/");
    }

    public void openCheckout() {
        driver.navigate().to("https://intershop5.skillbox.ru/checkout/");
    }

    public void openRegistrationForm() {
        driver.navigate().to("https://intershop5.skillbox.ru/register/");
    }

    public void login () {
        header = new Header(driver,wait);
        authoriztionForm = new AuthoriztionForm(driver,wait);

        String testUsername = "kherlaeda";
        String testPassword = "075gektvtn";

        header.clickLogin();
        authoriztionForm.enterUserName(testUsername);
        authoriztionForm.enterPassword(testPassword);
        authoriztionForm.clickLogin();
    }

    public CloseableHttpClient httpClient (int maxTotal, int maxPerRoute, int timeOut) {

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotal);
        connectionManager.setDefaultMaxPerRoute(maxPerRoute);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(timeOut)
                .setConnectTimeout(timeOut)
                .setSocketTimeout(timeOut)
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();
        return httpClient;
    }

    public void clearCart (int itemAmount) {
        basket = new Basket(driver,wait);
        for (int i = 1; i <= itemAmount; i++) {
            basket.clickRemoveItem(i);
        }
    }

    public int formatStringInToInt (String intString) {
        return Integer.parseInt(intString.replaceAll("[^\\d,]", "").replaceAll(",\\d+$", ""));
    }

    public void addTestItemToCart() {
        catalog = new Catalog(driver,wait,action);
        catalog.navigateToCategory(6);
        catalog.clickAddToCartButton(1);
        catalog.clickMoreDetailsButton(1);
    }

    public String randomValidEmail() {

        Random random = new Random();
        String localChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
        String domainChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        String[] domain = {"ru", "com"};

        StringBuilder localPart = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            localPart.append(localChars.charAt(random.nextInt(localChars.length())));
        }

        StringBuilder domainPart = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            domainPart.append(domainChars.charAt(random.nextInt(domainChars.length())));
        }

        return localPart.toString() + "@" + domainPart.toString() + "." + domain[random.nextInt(domain.length)];
    }

    public String randomValidUsername() {
        Random random = new Random();
        String chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";

        StringBuilder username = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            username.append(chars.charAt(random.nextInt(chars.length())));
        }

        return username.toString();
    }

    public String randomValidPassword() {
        Random random = new Random();
        String chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789йцукенгшщзхъфывапролджэячсмитьбюёЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁ!?-_№;%*";

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

    public String generateCharacters (String length) {
        Random random = new Random();
        StringBuilder charStrings = new StringBuilder();
        String chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789йцукенгшщзхъфывапролджэячсмитьбюёЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮЁ!?-_№;%*";
        for (int i = 1; i <= Integer.parseInt(length); i++) {
            charStrings.append(chars.charAt(random.nextInt(chars.length())));
        }
        return charStrings.toString();
    }

    public BufferedImage screenshot (WebElement element) throws AWTException {
        Robot robot = new Robot();
        org.openqa.selenium.Point point = element.getLocation();
        org.openqa.selenium.Dimension size = element.getSize();
        Rectangle screen = new Rectangle(point.x,point.y,size.width,size.height);
        return robot.createScreenCapture(screen);
    }

    public String getScreenshotText(BufferedImage image) throws TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("rus");
        return tesseract.doOCR(image);
    }
}
