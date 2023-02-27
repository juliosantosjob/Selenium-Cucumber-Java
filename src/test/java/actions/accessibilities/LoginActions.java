package actions.accessibilities;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.accessibilities.LoginPages;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static utils.Asserts.*;
import static utils.Commands.*;

public class LoginActions extends LoginPages {
    protected WebDriver driver;
    protected String pageTitle;

    public LoginActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void goHome() {
        pageTitle = driver.getTitle();
        assertEquals("QAZANDO Shop E-Commerce", pageTitle);
        waitForElement(fldWebsiteHeader, 5);
        contains(fldWebsiteHeader, "Promoções especiais disponíveis.");
    }

    public void accessLoginPage() {
        isEnable(btnLogin).click();
    }

    public void fillEmailPasswd(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();
        isEnable(fldEmail).sendKeys(data.get(0).get(1));
        isEnable(fldPassword).sendKeys(data.get(1).get(1));
        isEnable(btnLoginSubmit).click();
    }

    public void heSee(String msgSuccess) {
        waitForElement(labelLoginSuccess, 5);
        contains(labelLoginSuccess, msgSuccess);
    }

    public void isLoggedIn(String msgYourOrder) {
        clickText("OK");
        contains(fldLoggedArea, msgYourOrder);
    }

    public void seeErrorMessages(String msgOutput) {
        assertVisible(fldErrorMessages);
        assertive(fldErrorMessages, msgOutput);
    }
}