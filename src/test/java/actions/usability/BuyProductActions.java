package actions.usability;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.usability.BuyProductPages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Asserts.*;
import static utils.Commands.*;
import static utils.DynamicMass.*;

public class BuyProductActions extends BuyProductPages {

    public BuyProductActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String item) {
        realClick(btnSearch);
        fldSearch.sendKeys(item, Keys.ENTER);
        clickText("OK");
    }

    public void productIsDisplayed(String item) {
        WebElement myProduct = product.get(1);
        contains(myProduct, item);
        waitAndClick(myProduct, 10);
    }

    public void addProductCart() {
        realClick(btnAddToCart);
        waitElementDisappear(fldShow, 5);
        realClick(btnBag);
    }

    public void seeProductInCart() {
        waitForElement(pageCart, 10);
    }

    public void checkoutProduct() {
        WebElement buttonCheckout = btnCheckout.get(1);
        realClick(buttonCheckout);
    }

    public void fillPaymentForm() {
        String areaBillingsTxt = areaBillings.getText();
        assertTrue(areaBillingsTxt.contains("Billings Information"));

        fldFirtsName.sendKeys(randomName());
        fldLastName.sendKeys(randomLastName());
        fldCompany.sendKeys(randomNameCompany());
        fldEmail.sendKeys(randomEmail());

        selectOption(optCountry, "usa");
        selectOption(optCountry, "Afghanistan");
        fldZip.sendKeys("07500000");
        fldAdress.sendKeys("Rua roberto silva - 3578");
        fldAdditionalNotes.sendKeys("Informações Adicionais");
        scrollTo(btnSave);
    }

    public void saveAndSend() {
        realClick(btnSave);
        realClick(btnPlaceOrder);
    }

    public void registrationSuccess() {
        waitForElement(modalSuccess, 5);
        String getMessage = modalSuccess.getText();

        assertTrue(getMessage.contains("Order success!"));
        assertTrue(getMessage.contains("Congrats! Your order was created with sucess!"));
    }
}