package pages.accessibilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages {

    @FindBy(css = "ul[class='right_list_fix']")
    protected WebElement fldLogin;

    @FindBy(css = "i[class='fa fa-user']")
    protected WebElement btnLogin;

    @FindBy(css = "#user")
    protected WebElement fldEmail;

    @FindBy(css = "#password")
    protected WebElement fldPassword;

    @FindBy(css = "#btnLogin")
    protected WebElement btnLoginSubmit;

    @FindBy(css = "div[aria-labelledby*='-title']")
    protected WebElement labelLoginSuccess;


    @FindBy(css = "ul[class='right_list_fix']")
    protected WebElement fldLoggedArea;

    @FindBy(css = "span[class='invalid_input']")
    protected WebElement fldErrorMessages;
}