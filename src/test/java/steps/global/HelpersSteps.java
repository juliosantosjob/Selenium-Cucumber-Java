package steps.global;

import actions.accessibilities.LoginActions;
import actions.global.HelpersActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import support.BasePage;

public class HelpersSteps extends BasePage {
    HelpersActions helpersActions = new HelpersActions(driver);
    LoginActions loginActions = new LoginActions(driver);

    @Given("logs in with email {string} and password {string}")
    public void logs_in_with_email_and_password(String email, String password) {
        helpersActions.fill(email, password);
    }

    @And("logout")
    public void logout() {
        helpersActions.logOut();
    }
}