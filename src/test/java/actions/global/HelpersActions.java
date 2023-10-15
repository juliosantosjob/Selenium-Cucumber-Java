package actions.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.global.HelpersPages;

import static utils.Commands.*;

public class HelpersActions extends HelpersPages {

    public HelpersActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillEmailPassword(String email, String passwd) {
        fldEmail.sendKeys(email);
        fldPassword.sendKeys(passwd);
        btnLoginSubmit.click();
    }

    public void logOut() {
        mouseHover(fldLoggedArea).click();
    }
}