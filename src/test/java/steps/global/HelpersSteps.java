package steps.global;

import actions.global.HelpersActions;
import actions.accessibilities.LoginActions;
import io.cucumber.java.pt.*;
import support.DriverDefinition;

import static environments.setup.DataMass.dataMass;
import static utils.Asserts.*;

public class HelpersSteps extends DriverDefinition {
    LoginActions login = new LoginActions(driver);
    HelpersActions helper = new HelpersActions(driver);

    @Dado("que o usuario acesse o site")
    public void que_o_usuario_acesso_o_site() {
        login.goHome();
    }

    @E("faça login com {string} e {string}")
    public void o_login_com_e_a(String email, String passwd) {
        login.accessLoginPage();
        helper.fillEmailPassword(email, passwd);
        contains(login.isLoggedIn(), "Acompanhe seu pedido");
    }

    @E("logout")
    public void logout() {
        helper.logOut();
    }
}