package steps.global;

import actions.accessibilities.LoginActions;
import actions.global.HelpersActions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import support.DriverDefinition;

public class HelpersSteps extends DriverDefinition {
    HelpersActions helpersActions = new HelpersActions(driver);
    LoginActions loginActions = new LoginActions(driver);

    @Dado("faça login com o email {string} e a senha {string}")
    public void faca_login_com_o_email_e_a_senha(String email, String password) {
        helpersActions.fill(email, password);
    }

    @E("logout")
    public void logout() {
        helpersActions.logOut();
    }

}