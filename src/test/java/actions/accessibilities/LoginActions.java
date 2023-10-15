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
    private final WebDriver driver;

    public LoginActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginActions goHome() {
        String pageTitle = driver.getTitle();
        assertEquals("QAZANDO Shop E-Commerce", pageTitle);

        waitForElement(fldWebsiteHeader, 5);
        contains(fldWebsiteHeader, "Promoções especiais disponíveis.");

        return new LoginActions(driver);
    }

    public LoginActions accessLoginPage() {
        isEnable(btnLogin).click();

        return new LoginActions(driver);
    }

    public LoginActions fillEmailPasswd(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();
        fldEmail.sendKeys(data.get(0).get(1));
        fldPassword.sendKeys(data.get(1).get(1));
        btnLoginSubmit.click();

        return new LoginActions(driver);
    }

    public String getMessageSuccess() {
        waitForElement(labelLoginSuccess, 5);
        return labelLoginSuccess.getText();
    }

    public String getMessageError() {
        assertVisible(fldErrorMessages);
        return fldErrorMessages.getText();
    }
}