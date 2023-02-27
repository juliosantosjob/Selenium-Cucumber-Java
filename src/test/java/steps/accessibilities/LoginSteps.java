package steps.accessibilities;

import actions.accessibilities.LoginActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import support.DriverDefinition;

import static utils.Asserts.*;

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
        login.heSee("Login realizado");
        login.isLoggedIn("Acompanhe seu pedido");
    }

    @Então("ele vê {string}")
    public void ele_ve(String msgOutput) {
        login.seeErrorMessages(msgOutput);
    }
}