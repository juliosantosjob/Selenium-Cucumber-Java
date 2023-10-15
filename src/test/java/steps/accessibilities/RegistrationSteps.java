package steps.accessibilities;

import actions.accessibilities.RegistrationActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import support.DriverDefinition;

import static utils.Asserts.*;

public class RegistrationSteps extends DriverDefinition {

    @E("acesse a pagina de cadastro")
    public void acesse_a_pagina_de_cadastro() {
        new RegistrationActions(driver)
                .accessRegistPage();
    }

    @Quando("ele submeter o formulario com dados validos")
    public void ele_submeter_o_formulario_com_dados_validos() {
        new RegistrationActions(driver)
                .fillForm();
    }

    @Entao("ele vê a mensagem de sucesso: {string}")
    public void ele_ve_a_mensagem_de_sucesso(String messageRegistDone) {
        String getMessage = new RegistrationActions(driver)
                .getMessagePopup();

        containsText(getMessage, messageRegistDone);
    }

    @E("{string}")
    public void a_mensagem(String messageWelcome) {
        String getMessage = new RegistrationActions(driver)
                .getMessagePopup();

        containsText(getMessage, messageWelcome);
    }

    @Quando("ele submeter o formulario com:")
    public void ele_submeter_o_formulario_com(DataTable dataTable) {
        new RegistrationActions(driver)
                .fillForms(dataTable);
    }

    @Entao("ele vê a mensagem: {string}")
    public void ele_ve_a_mensagem(String message) {
        String getMessage = new RegistrationActions(driver)
                .getMessage(message);

        containsText(getMessage, message);
    }
}