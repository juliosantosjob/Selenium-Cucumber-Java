package steps.accessibilities;

import actions.accessibilities.LoginActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import support.DriverDefinition;

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

    @Entao("ele visualiza a mensagem {string}")
    public void ele_visualiza_a_mensagem(String msgPerformLogin) {
        login.heSee(msgPerformLogin);
    }

    @Entao("ele vê a mensagem de erro {string}")
    public void ele_ve_a_mensagem_de_erro(String msgOutput) {
        login.seeErrorMessages(msgOutput);
    }

}