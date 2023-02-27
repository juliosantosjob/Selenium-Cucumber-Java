package actions.usability;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.usability.BuyProductPages;

import static utils.Asserts.*;
import static utils.Commands.*;
import static utils.DynamicMass.*;

public class BuyProductActions extends BuyProductPages {
    static String DataItem;

    public BuyProductActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String item) {
        DataItem = item;
        realClick(btnSearch);
        isEnable(fldSearch).sendKeys(DataItem, Keys.ENTER);
        clickText("OK");
    }

    public void productIsDisplayed(String item) {
        WebElement myProduct = product.get(1);
        contains(myProduct, item);
        waitAndTap(myProduct, 10);
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
        WebElement buttonCheckout = btnCheckout.get(1);
        realClick(buttonCheckout);
    }

    public void fillPaymentFormInit() {
        contains(areaBillings, "Billings Information");
        isEnable(fldFirtsName).sendKeys(randomName());
        isEnable(fldLastName).sendKeys(randomLastName());
        isEnable(fldCompany).sendKeys(randomNameCompany());
        isEnable(fldEmail).sendKeys(randomEmail());
    }

    public void fillPaymentFormFinal() {
        selectOption(optCountry, "usa");
        selectOption(optCountry, "Afghanistan");
        isEnable(fldZip).sendKeys("07500000");
        isEnable(fldAdress).sendKeys("Rua roberto silva - 3578");
        isEnable(fldAdditionalNotes).sendKeys("Informações Adicionais");
        scrollTo(btnSave);
    }

    public void saveAndSend() {
        realClick(btnSave);
        realClick(btnPlaceOrder);
    }

    public void seeModalSuccess(String mdlSucess) {
        waitForElement(modalSuccess, 5);
        contains(modalSuccess, mdlSucess);
        contains(modalSuccess, mdlSucess);
    }
}