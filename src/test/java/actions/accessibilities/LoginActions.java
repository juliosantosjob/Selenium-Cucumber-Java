package actions.accessibilities;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.accessibilities.LoginPages;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Commands.*;

public class LoginActions extends LoginPages {
    private final WebDriver driver;

    public LoginActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openHome() {
        String pageTitle = driver.getTitle();
        assertEquals("QAZANDO Shop E-Commerce", pageTitle);
        waitForElement(fldWebsiteHeader, 5);

        String websiteHeader = fldWebsiteHeader.getText();
        assertTrue(websiteHeader.contains("Promoções especiais disponíveis."));
    }

    public void goToLogin() {
        btnLogin.click();
    }

    public void fillCredents(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();
        fldEmail.sendKeys(data.get(0).get(1));
        fldPassword.sendKeys(data.get(1).get(1));
        btnLoginSubmit.click();
    }

    public void seeMessage(String msg) {
        waitForElement(labelLoginSuccess, 5);

        String getMessageLabel = labelLoginSuccess.getText();
        assertTrue(getMessageLabel.contains(msg));
    }


    public void seeError(String msg) {
        waitForElement(fldErrorMessages, 5);

        String getErrorMessage = fldErrorMessages.getText();
        assertTrue(getErrorMessage.contains(msg));
    }
}