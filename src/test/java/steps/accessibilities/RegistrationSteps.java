package steps.accessibilities;

import actions.global.HelpersActions;
import actions.accessibilities.RegistrationActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.*;
import support.DriverDefinition;

import static utils.Asserts.*;
import static utils.Commands.*;

public class RegistrationSteps extends DriverDefinition {
    RegistrationActions register = new RegistrationActions(driver);

    @E("acesse a pagina de cadastro")
    public void acesse_a_pagina_de_cadastro() {
        register.accessRegistrationPage();
    }

    @Quando("ele submeter o formulario com dados validos")
    public void ele_submeter_o_formulario_com_dados_validos() {
        register.fillForm();
    }

    @Então("ele vê a mensagem de sucesso: {string}")
    public void ele_ve_a_mensagem_de_sucesso(String messageRegistDone) {
        contains(register.popup(), messageRegistDone);
    }

    @E("{string}")
    public void a_mensagem(String messageWelcome) {
        contains(register.popup(), messageWelcome);
    }

    @Quando("ele submeter o formulario com:")
    public void ele_submeter_o_formulario_com(DataTable dataTable) {
        register.fillForms(dataTable);
    }

    @Então("ele vê a mensagem: {string}")
    public void ele_ve_a_mensagem(String message) {
        assertive(register.seeMessage(), message);
    }
}