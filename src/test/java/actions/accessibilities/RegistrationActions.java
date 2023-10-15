package actions.accessibilities;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.accessibilities.RegistrationPages;

import java.util.List;

import static utils.Asserts.*;
import static utils.Commands.*;
import static utils.DynamicMass.*;

public class RegistrationActions extends RegistrationPages {
    private final WebDriver driver;

    public RegistrationActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public RegistrationActions accessRegistPage() {
        btnRegistration.click();
        contains(titleForm, "Cadastro de usuário");

        return new RegistrationActions(driver);
    }

    public RegistrationActions fillForm() {
        isEnable(fldUserForm).sendKeys(randomName());
        isEnable(fldEmailForm).sendKeys(randomEmail());
        isEnable(fldPasswordForm).sendKeys(randomPassword());
        realClick(btnRegistrationSubmit);

        return new RegistrationActions(driver);
    }

    public RegistrationActions fillForms(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();

        isEnable(fldUserForm).sendKeys(data.get(0).get(1));
        isEnable(fldEmailForm).sendKeys(data.get(1).get(1));
        isEnable(fldPasswordForm).sendKeys(data.get(2).get(1));
        realClick(btnRegistrationSubmit);

        return new RegistrationActions(driver);
    }

    public String getMessagePopup() {
        waitForElement(popupSuccessRegister, 5);

        return popupSuccessRegister.getText();
    }

    public String getMessage(String message) {
        return form.getText();
    }
}