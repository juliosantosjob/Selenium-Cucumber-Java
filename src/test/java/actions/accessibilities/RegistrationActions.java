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

    public RegistrationActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void accessRegistrationPage() {
        btnRegistration.click();
        contains(titleForm, "Cadastro de usuário");
    }

    public void fillForm() {
        isEnable(fldUserForm).sendKeys(randomName());
        isEnable(fldEmailForm).sendKeys(randomEmail());
        isEnable(fldPasswordForm).sendKeys(randomPassword());
        realClick(btnRegistrationSubmit);
    }

    public void fillForms(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();

        isEnable(fldUserForm).sendKeys(data.get(0).get(1));
        isEnable(fldEmailForm).sendKeys(data.get(1).get(1));
        isEnable(fldPasswordForm).sendKeys(data.get(2).get(1));
        realClick(btnRegistrationSubmit);
    }

    public void heSeePopup(String messageRegistDone) {
        waitForElement(popupSuccessRegister, 5);
        contains(popupSuccessRegister, messageRegistDone);
    }

    public void seeMessage(String message) {
        assertive(form, message);
    }
}