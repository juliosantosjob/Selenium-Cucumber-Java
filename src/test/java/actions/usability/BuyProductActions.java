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
    private final WebDriver driver;

    public BuyProductActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public BuyProductActions searchForProduct(String item) {
        realClick(btnSearch);
        isEnable(fldSearch).sendKeys(item, Keys.ENTER);
        clickText("OK");

        return new BuyProductActions(driver);
    }

    public BuyProductActions productIsDisplayed(String item) {
        WebElement myProduct = product.get(1);
        contains(myProduct, item);
        waitAndClick(myProduct, 10);

        return new BuyProductActions(driver);
    }

    public BuyProductActions addProductCart() {
        realClick(btnAddToCart);
        waitElementDisappear(fldShow, 5);
        realClick(btnBag);

        return new BuyProductActions(driver);
    }

    public BuyProductActions seeProductInCart() {
        waitForElement(pageCart, 10);

        return new BuyProductActions(driver);
    }

    public BuyProductActions checkoutProduct() {
        WebElement buttonCheckout = btnCheckout.get(1);
        realClick(buttonCheckout);

        return new BuyProductActions(driver);
    }

    public BuyProductActions fillPaymentForm() {
        contains(areaBillings, "Billings Information");
        isEnable(fldFirtsName).sendKeys(randomName());
        isEnable(fldLastName).sendKeys(randomLastName());
        isEnable(fldCompany).sendKeys(randomNameCompany());
        isEnable(fldEmail).sendKeys(randomEmail());

        selectOption(optCountry, "usa");
        selectOption(optCountry, "Afghanistan");
        isEnable(fldZip).sendKeys("07500000");
        isEnable(fldAdress).sendKeys("Rua roberto silva - 3578");
        isEnable(fldAdditionalNotes).sendKeys("Informações Adicionais");
        scrollTo(btnSave);

        return new BuyProductActions(driver);
    }

    public BuyProductActions saveAndSend() {
        realClick(btnSave);
        realClick(btnPlaceOrder);

        return new BuyProductActions(driver);
    }

    public String getModalSuccess() {
        waitForElement(modalSuccess, 5);
        return modalSuccess.getText();
    }
}