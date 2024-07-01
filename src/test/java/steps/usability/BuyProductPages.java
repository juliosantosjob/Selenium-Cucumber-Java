package steps.usability;

import actions.usability.BuyProductActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.BasePage;

public class BuyProductPages extends BasePage {
    BuyProductActions buyProductActions = new BuyProductActions(driver);

    @And("search for the product {string}")
    public void search_for_the_product(String item) {
        buyProductActions.searchForProduct(item);
        buyProductActions.productIsDisplayed(item);
    }

    @And("add this item to the cart")
    public void add_this_item_to_the_cart() {
        buyProductActions.addProductCart();
        buyProductActions.seeProductInCart();
    }

    @Given("proceed to checkout")
    public void proceed_to_checkout() {
        buyProductActions.checkoutProduct();
    }

    @When("they choose the payment method")
    public void they_choose_the_payment_method() {
        buyProductActions.fillPaymentForm();
    }

    @And("confirm the purchase")
    public void confirm_the_purchase() {
        buyProductActions.saveAndSend();
    }

    @Then("their purchase is completed successfully")
    public void their_purchase_is_completed_successfully() {
        buyProductActions.registrationSuccess();
    }
}
