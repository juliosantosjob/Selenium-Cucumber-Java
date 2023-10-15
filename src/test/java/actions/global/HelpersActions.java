package actions.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.global.HelpersPages;

import static utils.Commands.*;

public class HelpersActions extends HelpersPages {
    private final WebDriver driver;

    public HelpersActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HelpersActions fillEmailPassword(String email, String passwd) {
        fldEmail.sendKeys(email);
        fldPassword.sendKeys(passwd);
        btnLoginSubmit.click();

        return new HelpersActions(driver);
    }

    public HelpersActions logOut() {
        mouseHover(fldLoggedArea).click();

        return new HelpersActions(driver);
    }
}