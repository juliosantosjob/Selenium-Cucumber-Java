package steps.accessibilities;

import actions.accessibilities.LoginActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.BasePage;

public class LoginSteps extends BasePage {
    LoginActions loginActions = new LoginActions(driver);

    @Given("the user accesses the site")
    public void the_user_accesses_the_site() {
        loginActions.openHome();
    }

    @Given("accesses the login page")
    public void accesses_the_login_page() {
        loginActions.goToLogin();
    }

    @When("they fill in:")
    public void they_fill_in(DataTable dataTable) {
        loginActions.fillCredents(dataTable);
    }

    @Then("they see the message success {string}")
    public void they_see_the_message_success(String msgPerformLogin) {
        loginActions.seeMessage(msgPerformLogin);
    }

    @Then("they see the error {string}")
    public void they_see_the_error(String msgOutput) {
        loginActions.seeError(msgOutput);
    }
}