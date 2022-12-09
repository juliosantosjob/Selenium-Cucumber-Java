package actions.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.global.HelpersPages;

import static environments.setup.DataMass.dataMass;
import static utils.Commands.*;

public class HelpersActions extends HelpersPages {

    public HelpersActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillEmailPassword(String email, String passwd) {
        isEnable(fldEmail).sendKeys(dataMass().getData(email));
        isEnable(fldPassword).sendKeys(dataMass().getData(passwd));
        isEnable(btnLoginSubmit).click();
    }

    public void logOut() {
        mouseHover(fldLoggedArea).click();
    }
}