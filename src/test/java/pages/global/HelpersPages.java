package pages.global;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpersPages {

    @FindBy(css = "#user")
    protected WebElement fldEmail;

    @FindBy(css = "#password")
    protected WebElement fldPassword;

    @FindBy(css = "#btnLogin")
    protected WebElement btnLoginSubmit;

    @FindBy(css = "#userLogged")
    protected WebElement fldLoggedArea;
}