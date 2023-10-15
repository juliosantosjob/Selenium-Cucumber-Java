package steps.global;

import actions.global.HelpersActions;
import actions.accessibilities.LoginActions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import support.DriverDefinition;

public class HelpersSteps extends DriverDefinition {

    @Dado("que o usuario acesse o site")
    public void que_o_usuario_acesso_o_site() {
        new LoginActions(driver)
                .goHome()
                .accessLoginPage();
    }

    @Dado("faça login com o email {string} e a senha {string}")
    public void faca_login_com_o_email_e_a_senha(String email, String passwd) {
        new HelpersActions(driver)
                .fillEmailPassword(email, passwd);
    }

    @E("logout")
    public void logout() {
        new HelpersActions(driver)
                .logOut();
    }
}