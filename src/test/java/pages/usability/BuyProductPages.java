package pages.usability;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BuyProductPages {

    @FindBy(css = "[href='#search']")
    protected WebElement btnSearch;

    @FindBy(css = "[type='search']")
    protected WebElement fldSearch;

    @FindBy(css = ".product_wrappers_one")
    protected List<WebElement> product;

    @FindBy(css = "a[class='theme-btn-one btn-black-overlay btn_sm']")
    protected WebElement btnAddToCart;

    @FindBy(xpath = "//header//div/ul/li[2]/a")
    protected WebElement btnBag;


    @FindBy(css = "#offcanvas-add-cart")
    protected WebElement pageCart;

    @FindBy(css = "a[class='theme-btn-one btn-black-overlay btn_md']")
    protected List<WebElement> btnCheckout;

    @FindBy(css = "div[class='checkout-area-bg bg-white']")
    protected WebElement areaBillings;

    @FindBy(css = "#fname")
    protected WebElement fldFirtsName;

    @FindBy(css = "#lname")
    protected WebElement fldLastName;

    @FindBy(css = "#cname")
    protected WebElement fldCompany;


    @FindBy(css = "#email")
    protected WebElement fldEmail;

    @FindBy(css = "#country")
    protected WebElement optCountry;

    @FindBy(css = "#zip")
    protected WebElement fldZip;

    @FindBy(css = "#faddress")
    protected WebElement fldAdress;

    @FindBy(css = "#messages")
    protected WebElement fldAdditionalNotes;


    @FindBy(xpath = "(//*[@class='theme-btn-one btn-black-overlay btn_sm'])[1]")
    protected WebElement btnSave;

    @FindBy(xpath = "(//*[@class='theme-btn-one btn-black-overlay btn_sm'])[2]")
    protected WebElement btnPlaceOrder;

    @FindBy(css = "div[class='newsleetre_modal modal-body']")
    protected WebElement modalSuccess;

    protected By fldShow = By.xpath("(//*[contains(@class, '-show')])[4]");
}