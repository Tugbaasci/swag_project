package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "user-name")
    public WebElement inputUsername;
    @FindBy(id = "password")
    public WebElement inputPassword;
    @FindBy(id = "login-button")
    public WebElement LoginButton;
    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemsLink;
    @FindBy(id = "about_sidebar_link")
    public WebElement aboutLink;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;
    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppStoreLink;
    @FindBy(xpath = "//button[text()='Open Menu']")
    public WebElement menuLink;
    @FindBy(xpath = "(//button[text()='Add to cart'])[1]")
    public WebElement firstproductAddCartBtn;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement firstProductRemoveBtn;
    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeBtn;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement filterSelect;
    @FindBy(id = "shopping_cart_container")
    public WebElement cartIkon;
    @FindBy(css = ".shopping_cart_link")
    public WebElement countInCart;
    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    public WebElement firstProductText;
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;
    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;
    @FindBy(id = "finish")
    public WebElement finishBtn;
    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    public WebElement orderCompleteText;
    @FindBy(id = "back-to-products")
    public WebElement backHomeBtn;
    @FindBy(id = "first-name")
    public WebElement firstnameCheckoutInput;
    @FindBy(id = "last-name")
    public WebElement lastnameCheckoutInput;
    @FindBy(id = "postal-code")
    public WebElement postalCodeCheckoutInput;
    @FindBy(id = "continue")
    public WebElement continueBtn;
    @FindBy(xpath = "(//div[@class='summary_info_label'])[1]")
    public WebElement paymentInformation;
    @FindBy(xpath = "(//div[@class='summary_info_label'])[2]")
    public WebElement shippingInformation;
    @FindBy(xpath = "(//div[@class='summary_info_label'])[3]")
    public WebElement priceTotal;
    @FindBy(xpath = "//button[@id='cancel']")
    public WebElement cancelBtn;
    @FindBy(xpath = "//li[@class='social_facebook']")
    public WebElement facebookIcon;
    @FindBy(xpath = "//li[@class='social_twitter']")
    public WebElement twitterIcon;
    @FindBy(xpath = "//li[@class='social_linkedin']")
    public WebElement linkedinIcon;
    @FindBy(xpath = "//div[@class='app_logo']")
    public WebElement HeaderHomePage;
}
