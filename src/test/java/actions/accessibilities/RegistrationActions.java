package actions.accessibilities;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.accessibilities.RegistrationPages;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utils.Commands.*;
import static utils.DynamicMass.*;

public class RegistrationActions extends RegistrationPages {

    public RegistrationActions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void goToRegistPage() {
        btnRegistration.click();

        String titleFormTxt = titleForm.getText();
        assertTrue(titleFormTxt.contains("Cadastro de usuário"));
    }

    public void fillForm() {
        fldUserForm.sendKeys(randomName());
        fldEmailForm.sendKeys(randomEmail());
        fldPasswordForm.sendKeys(randomPassword());
        realClick(btnRegistrationSubmit);
    }

    public void fillForms(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();

        fldUserForm.sendKeys(data.get(0).get(1));
        fldEmailForm.sendKeys(data.get(1).get(1));
        fldPasswordForm.sendKeys(data.get(2).get(1));
        realClick(btnRegistrationSubmit);
    }

    public void successMsg(String message) {
        waitForElement(popupSuccessRegister, 5);

        String messagePp = popupSuccessRegister.getText();
        assertTrue(messagePp.contains(message));
    }

    public void outgoingMsg(String message) {
        waitForElement(form, 5);

        String formTxt = form.getText();
        assertTrue(formTxt.contains(message));
    }
}