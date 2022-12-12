package steps.accessibilities;

import actions.accessibilities.LoginActions;
import actions.accessibilities.RegistrationActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.*;
import support.DriverDefinition;

import static utils.Asserts.*;
import static utils.Commands.*;

public class LoginSteps extends DriverDefinition {
    LoginActions login = new LoginActions(driver);

    @Dado("acesse a pagina de login")
    public void acesse_a_pagina_de_login() {
        login.goHome();
        login.accessLoginPage();
    }

    @Quando("ele preecher:")
    public void ele_preecher(DataTable dataTable) {
        login.fillEmailPasswd(dataTable);
    }

    @Então("ele é logado com sucesso")
    public void ele_e_logado_com_sucesso() {
        assertVisible(login.popupLoginSuccess());
        contains(login.popupLoginSuccess(), "Login realizado");
        contains(login.isLoggedIn(), "Acompanhe seu pedido");
    }

    @Então("ele vê {string}")
    public void ele_ve(String msgOutput) {
        assertVisible(login.errorMessages());
        assertive(login.errorMessages(), msgOutput);
    }
}