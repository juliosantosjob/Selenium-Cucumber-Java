package actions.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.global.HelpersPages;

import static support.BasePage.*;

public class HelpersActions extends HelpersPages {

    public HelpersActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fill(String email, String password) {
        fldEmail.sendKeys(email);
        fldPassword.sendKeys(password);
        btnLoginSubmit.click();
    }

    public void logOut() {
        mouseHover(fldLoggedArea).click();
    }
}