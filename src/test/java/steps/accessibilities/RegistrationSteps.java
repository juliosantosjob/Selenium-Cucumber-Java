package steps.accessibilities;

import actions.accessibilities.RegistrationActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import support.DriverDefinition;

public class RegistrationSteps extends DriverDefinition {
    RegistrationActions registActions = new RegistrationActions(driver);

    @E("acesse a pagina de cadastro")
    public void acesse_a_pagina_de_cadastro() {
        registActions.goToRegistPage();
    }

    @Quando("ele submeter o formulario com dados validos")
    public void ele_submeter_o_formulario_com_dados_validos() {
        registActions.fillForm();
    }

    @Entao("ele vê a mensagem de sucesso: {string}")
    public void ele_ve_a_mensagem_de_sucesso(String messageRegistDone) {
        registActions.successMsg(messageRegistDone);
    }

    @E("{string}")
    public void a_mensagem(String messageWelcome) {
        registActions.successMsg(messageWelcome);
    }

    @Quando("ele submeter o formulario com:")
    public void ele_submeter_o_formulario_com(DataTable dataTable) {
        registActions.fillForms(dataTable);
    }

    @Entao("ele vê a mensagem: {string}")
    public void ele_ve_a_mensagem(String message) {
        registActions.outgoingMsg(message);
    }
    
}