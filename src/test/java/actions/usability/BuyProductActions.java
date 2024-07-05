package actions.usability;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.usability.BuyProductPages;

import static org.junit.Assert.assertTrue;

import static support.BasePage.realClick;
import static support.BasePage.type;
import static support.BasePage.typeAndPress;
import static support.BasePage.clickText;
import static support.BasePage.click;
import static support.BasePage.waitElementDisappear;
import static support.BasePage.waitForElement;
import static support.BasePage.grabText;
import static support.BasePage.selectOptions;
import static support.BasePage.scrollTo;

import static utils.DynamicMass.randomName;
import static utils.DynamicMass.randomLastName;
import static utils.DynamicMass.randomNameCompany;
import static utils.DynamicMass.randomEmail;

public class BuyProductActions extends BuyProductPages {

    public BuyProductActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String item) {
        realClick(btnSearch);
        typeAndPress(fldSearch, item, Keys.ENTER);
        clickText("OK");
    }

    public void productIsDisplayed(String item) {
        WebElement myProduct = product.get(1);

        assertTrue(grabText(myProduct)
                .contains(item));
        click(myProduct);
    }

    public void addProductCart() {
        realClick(btnAddToCart);
        waitElementDisappear(fldShow);
        realClick(btnBag);
    }

    public void seeProductInCart() {
        waitForElement(pageCart, 10);
    }

    public void checkoutProduct() {
        realClick(btnCheckout.get(1));
    }

    public void fillPaymentForm() {
        assertTrue(grabText(areaBillings)
                .contains("Billings Information"));

        type(fldFirtsName, randomName());
        type(fldLastName, randomLastName());
        type(fldCompany, randomNameCompany());
        type(fldEmail, randomEmail());

        selectOptions(optCountry, "usa");
        selectOptions(optCountry, "Afghanistan");

        type(fldZip, "07500000");
        type(fldAdress, "Rua roberto silva - 3578");
        type(fldAdditionalNotes, "Informacoes Adicionais");
        
        scrollTo(btnSave);
    }

    public void saveAndSend() {
        realClick(btnSave);
        realClick(btnPlaceOrder);
    }

    public void registrationSuccess() {
        assertTrue(grabText(modalSuccess)
                .contains("Order success!"));
        assertTrue(grabText(modalSuccess)
                .contains("Congrats! Your order was created with sucess!"));
    }
}