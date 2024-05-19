package stepDefinitions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Set;

public class StepDefinitions {
    HomePage page = new HomePage();
    Faker faker;
    Actions actions;
    Select select;
    String fWh;


    @Given("user navigates to the URL")
    public void user_navigates_to_the_url() {
        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));
        ReusableMethods.wait(2);
        fWh = Driver.getDriver().getWindowHandle();

    }

    @Then("user enters username to login")
    public void user_enters_username_to_login() {
        page.inputUsername.sendKeys(ConfigReader.getProperty("username"));
    }
    @Then("user enters password to login")
    public void user_enters_password_to_login() {
        page.inputPassword.sendKeys(ConfigReader.getProperty("password"));
    }

    @When("user enters login button")
    public void user_enters_login_button() {
        page.LoginButton.click();
        ReusableMethods.wait(2);
    }
    @When("user clicks the menu")
    public void user_clicks_the_menu() {
        page.menuLink.click();
        ReusableMethods.wait(2);
    }
    @Then("checks the links are visible and enabled")
    public void checks_the_links_are_visible_and_enabled() {
        Assert.assertTrue(page.allItemsLink.isEnabled());
        Assert.assertTrue(page.allItemsLink.isDisplayed());
        Assert.assertTrue(page.aboutLink.isDisplayed());
        Assert.assertTrue(page.aboutLink.isEnabled());
        Assert.assertTrue(page.logoutLink.isEnabled());
        Assert.assertTrue(page.logoutLink.isDisplayed());
        Assert.assertTrue(page.resetAppStoreLink.isDisplayed());
        Assert.assertTrue(page.resetAppStoreLink.isEnabled());
    }
    @Given("user clicks All Items and checks the url")
    public void user_clicks_all_items_and_checks_the_url() {
        page.allItemsLink.click();
        String actualAllItemLink = Driver.getDriver().getCurrentUrl();
        String expectedAllItemsLink = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedAllItemsLink,actualAllItemLink);
    }
    @Given("user clicks About and checks the url")
    public void user_clicks_about_and_checks_the_url() {
        page.aboutLink.click();
        String actualAboutLink = Driver.getDriver().getCurrentUrl();
        String expectedAboutLink = "https://saucelabs.com/";
        Assert.assertEquals(expectedAboutLink,actualAboutLink);
        Driver.getDriver().navigate().back();
    }
    @Then("user clicks Logout and checks the url")
    public void user_clicks_logout_and_checks_the_url() {
        page.menuLink.click();
        page.logoutLink.click();
        String actualLogoutLink = Driver.getDriver().getCurrentUrl();
        String expectedLogoutLink = "https://www.saucedemo.com/";
        Assert.assertEquals(actualLogoutLink,expectedLogoutLink);
    }
    @Then("clicks the reset app state and checks the url")
    public void clicks_the_reset_app_state_and_checks_the_url() {
        page.inputUsername.sendKeys(ConfigReader.getProperty("username"));
        page.inputPassword.sendKeys(ConfigReader.getProperty("password"));
        page.LoginButton.click();
        page.firstproductAddCartBtn.click();
        select = new Select(page.filterSelect);
        select.selectByValue("lohi");
        page.menuLink.click();
        page.resetAppStoreLink.click();
        page.cartIkon.click();
        page.continueShoppingButton.click();
        String actAddCart = page.firstproductAddCartBtn.getText();
        String expAddCart = "Add to cart";
        Assert.assertEquals(expAddCart,actAddCart);
        select.selectByVisibleText("Name (A to Z)");

    }
    @Then("user adds a product and checks the difference in shopping cart")
    public void user_adds_a_product_and_checks_the_difference_in_shopping_cart() {
        page.firstproductAddCartBtn.click();
        Assert.assertTrue(page.countInCart.isDisplayed());
    }
    @When("user checks the product is correctly added to the cart")
    public void user_checks_the_product_is_correctly_added_to_the_cart() {
        String firstproductTextHomepage = page.firstProductText.getText();
        page.cartIkon.click();
        String firstproductTextCart = page.firstProductText.getText();
        Assert.assertTrue(firstproductTextCart.equals(firstproductTextHomepage));

    }
    @Then("user removes the product and checks the difference in the cart")
    public void user_removes_the_product_and_checks_the_difference_in_the_cart() {
        ReusableMethods.wait(3);
        page.firstProductRemoveBtn.click();
        String pictureName = "Cart";
       ReusableMethods.takePhotoAllpage(pictureName);
    }


    @When("closes the app")
    public void closes_the_app() {
        Driver.closeDriver();
    }

    @Then("user adds products to cart")
    public void user_adds_products_to_cart() {
        page.firstproductAddCartBtn.click();
        ReusableMethods.wait(1);
        page.firstproductAddCartBtn.click();
        ReusableMethods.wait(1);
        page.firstproductAddCartBtn.click();
        ReusableMethods.wait(1);
        page.firstproductAddCartBtn.click();
        ReusableMethods.wait(1);
        page.firstproductAddCartBtn.click();
        ReusableMethods.wait(1);
        page.firstproductAddCartBtn.click();
        ReusableMethods.wait(1);
    }
    @Then("user goes to cart")
    public void user_goes_to_cart() {
        page.cartIkon.click();
    }
    @Then("user clicks on the checkout button")
    public void user_clicks_on_the_checkout_button() {
        actions = new Actions(Driver.getDriver());
        actions.scrollToElement(page.checkoutBtn).perform();
        ReusableMethods.wait(2);
        page.checkoutBtn.click();
    }
    @Given("user enters the necessary information and continues")
    public void user_enters_the_necessary_information_and_continues() {
        faker = new Faker();
        page.firstnameCheckoutInput.sendKeys(faker.name().firstName());
        page.lastnameCheckoutInput.sendKeys(faker.name().lastName());
        page.postalCodeCheckoutInput.sendKeys(faker.address().zipCode());
        ReusableMethods.wait(1);
        page.continueBtn.click();

    }
    @Then("user checks the informations and products are added correctly")
    public void user_checks_the_informations_and_products_are_added_correctly() {
        Assert.assertTrue(page.paymentInformation.isDisplayed());
        Assert.assertTrue(page.shippingInformation.isDisplayed());
        Assert.assertTrue(page.priceTotal.isDisplayed());
    }
    @Then("user clicks on the finish button")
    public void user_clicks_on_the_finish_button() {
        ReusableMethods.wait(2);
        page.finishBtn.click();
    }
    @Then("user clicks on the back home button")
    public void user_clicks_on_the_back_home_button() {
       Assert.assertTrue(page.orderCompleteText.isDisplayed());
       page.backHomeBtn.click();
    }
    @Then("user verifies the homepage")
    public void user_verifies_the_homepage() {
        String actUrl = Driver.getDriver().getCurrentUrl();
        String expeUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertTrue(actUrl.equals(expeUrl));
        ReusableMethods.wait(3);
    }


    @When("user clicks About")
    public void user_clicks_about() {
        page.aboutLink.click();
    }


    @Then("user clicks on the cancel button")
    public void user_clicks_on_the_cancel_button() {
        actions = new Actions(Driver.getDriver());
        actions.scrollToElement(page.cancelBtn).perform();
        page.cancelBtn.click();
    }
    @Given("user clicks on the facebook icon")
    public void user_clicks_on_the_facebook_icon() {
       page.facebookIcon.click();
       ReusableMethods.wait(3);
    }
    @Given("user verifies the url includes {string}")
    public void user_verifies_the_url_includes(String string) {
        String sWh = "";
        Set<String> wHList = Driver.getDriver().getWindowHandles();
        for (String each:wHList) {
            if (!each.equals(fWh)){
                sWh = each;
            }
        }
        Driver.getDriver().switchTo().window(sWh);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(string));
        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(fWh);
        ReusableMethods.wait(2);
    }
    @When("user clicks on the x icon")
    public void user_clicks_on_the_x_icon() {
        actions = new Actions(Driver.getDriver());
        actions.scrollToElement(page.twitterIcon).perform();
        page.twitterIcon.click();
    }
    @When("user clicks on the linkedin icon")
    public void user_clicks_on_the_linkedin_icon() {
      actions = new Actions(Driver.getDriver());
      actions.scrollToElement(page.linkedinIcon).perform();
      page.linkedinIcon.click();
    }

    @Then("quits the app")
    public void quits_the_app() {
        Driver.getDriver().close();
    }
    @Then("user adds a product")
    public void user_adds_a_product() {
        page.firstproductAddCartBtn.click();
        ReusableMethods.takePhotoAllpage("AddedCart");
    }
    @Then("user clicks on the reset app store")
    public void user_clicks_on_the_reset_app_store() {
       page.resetAppStoreLink.click();
       ReusableMethods.takePhotoAllpage("DeletedCart");
    }
    @When("user checks the remove changed into add after reset")
    public void user_checks_the_remove_changed_into_add_after_reset() {
        Assert.assertTrue(!page.firstProductRemoveBtn.isDisplayed());
    }
}
