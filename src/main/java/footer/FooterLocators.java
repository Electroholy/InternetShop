package footer;

import org.openqa.selenium.By;

public class FooterLocators {

    //-------------------------------------LOCATORS------------------------------------------

    private final By footerMenu = By.cssSelector("#top-footer #pages-2");
    private final By allProducts = By.cssSelector(".page-item-33 a");
    private final By mainPage = By.cssSelector(".page-item-39 a");
    private final By basket = By.cssSelector(".page-item-20 a");
    private final By myAccount = By.cssSelector(".page-item-22 a");
    private final By checkout = By.cssSelector(".page-item-24 a");
    private final By registration = By.cssSelector(".page-item-141 a");
    private final By contactPhone = By.xpath("//div[@class='cta-desc_simple']/p[1]");
    private final By contactEmail = By.xpath("//div[@class='cta-desc_simple']/p[2]");
    private final By contactInformationElement = By.xpath("//div[@class='banner-text wow fadeInLeft']");

    //-----------------------------------------GETTERS-------------------------------------------


    public By getFooterMenu() {
        return footerMenu;
    }

    public By getAllProducts() {
        return allProducts;
    }

    public By getMainPage() {
        return mainPage;
    }

    public By getBasket() {
        return basket;
    }

    public By getMyAccount() {
        return myAccount;
    }

    public By getCheckout() {
        return checkout;
    }

    public By getRegistration() {
        return registration;
    }

    public By getContactPhone() {
        return contactPhone;
    }

    public By getContactEmail() {
        return contactEmail;
    }

    public By getContactInformationElement() {
        return contactInformationElement;
    }
}
