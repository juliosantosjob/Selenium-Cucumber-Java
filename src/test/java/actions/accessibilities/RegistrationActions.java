package actions.accessibilities;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.accessibilities.RegistrationPages;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static support.BasePage.*;
import static utils.DynamicMass.*;

public class RegistrationActions extends RegistrationPages {

    public RegistrationActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void goToRegistPage() {
        click(btnRegistration);
        assertTrue(grabText(titleForm).contains("Cadastro de usuário"));
    }

    public void fillForm() {
        type(fldUserForm, randomFirstName());
        type(fldEmailForm, randomEmail());
        type(fldPasswordForm, randomPassword());
        clickJS(btnRegistrationSubmit);
    }

    public void fillForms(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();

        type(fldUserForm, data.get(0).get(1));
        type(fldEmailForm, data.get(1).get(1));
        type(fldPasswordForm, data.get(2).get(1));
        clickJS(btnRegistrationSubmit);
    }

    public void successMsg(String message) {
        assertTrue(grabText(popupSuccessRegister).contains(message));
    }

    public void outgoingMsg(String message) {
        assertTrue(grabText(form).contains(message));
    }
    
}