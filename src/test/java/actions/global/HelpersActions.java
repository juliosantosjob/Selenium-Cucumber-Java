package actions.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.global.HelpersPages;

import static support.BasePage.type;
import static support.BasePage.click;
import static support.BasePage.mouseHover;

public class HelpersActions extends HelpersPages {

    public HelpersActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fill(String email, String password) {
        type(fldEmail, email);
        type(fldPassword, password);
        click(btnLoginSubmit);
    }

    public void logOut() {
        mouseHover(fldLoggedArea).click();
    }
}