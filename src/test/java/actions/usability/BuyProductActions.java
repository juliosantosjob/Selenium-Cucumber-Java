package actions.usability;

import domain.UserDmn;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.usability.BuyProductPages;

import static org.junit.Assert.assertTrue;

import static support.BasePage.clickJS;
import static support.BasePage.type;
import static support.BasePage.typeAndPress;
import static support.BasePage.clickText;
import static support.BasePage.click;
import static support.BasePage.waitElementDisappear;
import static support.BasePage.waitForElement;
import static support.BasePage.grabText;
import static support.BasePage.selectOptions;
import static support.BasePage.scrollTo;

public class BuyProductActions extends BuyProductPages {

    public BuyProductActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String item) {
        clickJS(btnSearch);
        typeAndPress(fldSearch, item, Keys.ENTER);
        clickText("OK");
    }

    public void productIsDisplayed(String item) {
        WebElement myProduct = product.get(1);
        assertTrue(grabText(myProduct).contains(item));
        click(myProduct);
    }

    public void addProductCart() {
        clickJS(btnAddToCart);
        waitElementDisappear(fldShow);
        clickJS(btnBag);
    }

    public void seeProductInCart() {
        waitForElement(pageCart, 10);
    }

    public void checkoutProduct() {
        clickJS(btnCheckout.get(1));
    }

    public void fillPaymentForm(UserDmn user) {
        assertTrue(grabText(areaBillings).contains("Billings Information"));

        type(fldFirtsName, user.getFirstName());
        type(fldLastName, user.getLastName());
        type(fldCompany, user.getCompany());
        type(fldEmail, user.getEmail());

        scrollTo(optCountry);
        selectOptions(optCountry, "usa");

        type(fldZip, user.getZip());
        type(fldAdress, user.getAddress());
        type(fldAdditionalNotes, user.getAdditionalNotes());
    }

    public void saveAndSend() {
        scrollTo(btnSave);
        clickJS(btnSave);
        clickJS(btnPlaceOrder);
    }

    public void registrationSuccess() {
        assertTrue(grabText(modalSuccess).contains("Order success!"));
        assertTrue(grabText(modalSuccess).contains("Congrats! Your order was created with sucess!"));
    }
}