package steps.accessibilities;

import actions.accessibilities.LoginActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import support.DriverDefinition;

import static utils.Asserts.assertText;
import static utils.Asserts.containsText;

public class LoginSteps extends DriverDefinition {

    @Dado("acesse a pagina de login")
    public void acesse_a_pagina_de_login() {
        new LoginActions(driver)
                .goHome()
                .accessLoginPage();
    }

    @Quando("ele preecher:")
    public void ele_preecher(DataTable dataTable) {
        new LoginActions(driver)
                .fillEmailPasswd(dataTable);
    }

    @Entao("ele visualiza a mensagem {string}")
    public void ele_visualiza_a_mensagem(String msgPerformLogin) {
        String getMessage= new LoginActions(driver)
                .getMessageSuccess();

        containsText(getMessage, msgPerformLogin);
    }

    @Entao("ele vê a mensagem de erro {string}")
    public void ele_ve_a_mensagem_de_erro(String msgOutput) {
        String getMessage= new LoginActions(driver)
                .getMessageError();

        assertText(msgOutput,getMessage);
    }

}