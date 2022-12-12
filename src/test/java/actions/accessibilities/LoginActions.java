package actions.accessibilities;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        waitForElement(fldWebsiteHeader, 5).isDisplayed();
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

    public WebElement popupLoginSuccess() {
        waitForElement(labelLoginSuccess, 5);
        return labelLoginSuccess;
    }

    public WebElement isLoggedIn() {
        clickText("OK");
        return fldLoggedArea;
    }

    public WebElement errorMessages() {
        return fldErrorMessages;
    }
}