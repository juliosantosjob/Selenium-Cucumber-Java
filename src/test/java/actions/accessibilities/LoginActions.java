package actions.accessibilities;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.accessibilities.LoginPages;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static support.BasePage.grabText;
import static support.BasePage.visit;
import static support.BasePage.getDriver;
import static support.BasePage.type;
import static support.BasePage.click;
import static support.SetupEnv.getURLforEnv;

public class LoginActions extends LoginPages {
    public final String BASE_URL = getURLforEnv();

    public LoginActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openHome() {
        visit(BASE_URL);
        assertEquals("QAZANDO Shop E-Commerce", getDriver().getTitle());
        assertTrue(grabText(fldWebsiteHeader).contains("Promoções especiais disponíveis."));
    }

    public void goToLogin() {
        click(btnLogin);
    }

    public void fillCredents(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();
        type(fldEmail, data.get(0).get(1));
        type(fldPassword, data.get(1).get(1));
        click(btnLoginSubmit);
    }

    public void seeMessage(String message) {
        assertTrue(grabText(labelLoginSuccess).contains(message));
    }

    public void seeError(String error) {
        assertTrue(grabText(fldErrorMessages).contains(error));
    }
    
}