package steps.accessibilities;

import actions.accessibilities.RegistrationActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.BasePage;

public class RegistrationSteps extends BasePage {
    RegistrationActions registActions = new RegistrationActions(driver);

    @Given("accesses the registration page")
    public void accesses_the_registration_page() {
        registActions.goToRegistPage();
    }

    @When("they submit the form with valid data")
    public void they_submit_the_form_with_valid_data() {
        registActions.fillForm();
    }

    @Then("they see the success message: {string}")
    public void they_see_the_success_message(String messageRegistDone) {
        registActions.successMsg(messageRegistDone);
    }

    @And("the message: {string}")
    public void the_message(String messageWelcome) {
        registActions.successMsg(messageWelcome);
    }

    @When("they submit the form with:")
    public void they_submit_the_form_with(DataTable dataTable) {
        registActions.fillForms(dataTable);
    }

    @Then("they see the message {string}")
    public void they_see_the_message(String message) {
        registActions.outgoingMsg(message);
    }
}