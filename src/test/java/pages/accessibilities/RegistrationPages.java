package pages.accessibilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPages {

    @FindBy(css = "[class='fa fa-lock']")
    protected WebElement btnRegistration;

    @FindBy(css = "[class='account_form']")
    protected WebElement titleForm;

    @FindBy(css = "#user")
    protected WebElement fldUserForm;

    @FindBy(css = "#email")
    protected WebElement fldEmailForm;

    @FindBy(css = "#password")
    protected WebElement fldPasswordForm;

    @FindBy(css = "#btnRegister")
    protected WebElement btnRegistrationSubmit;


    @FindBy(css = "div[aria-modal='true']")
    protected WebElement popupSuccessRegister;

    @FindBy(css = "span[class='errorLabel']")
    protected WebElement form;
}