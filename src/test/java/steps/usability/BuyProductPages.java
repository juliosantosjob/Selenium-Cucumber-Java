package steps.usability;

import actions.usability.BuyProductActions;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import support.DriverDefinition;

public class BuyProductPages extends DriverDefinition {
    BuyProductActions buyProductActions = new BuyProductActions(driver);

    @E("busque pelo produto {string}")
    public void busque_pelo_produto(String item) {
        buyProductActions.searchForProduct(item);
        buyProductActions.productIsDisplayed(item);
    }

    @E("adicione este item ao carrinho")
    public void adicione_este_item_ao_carrinho() {
        buyProductActions.addProductCart();
        buyProductActions.seeProductInCart();
    }

    @E("vá para a pagina de checkout")
    public void va_para_a_pagina_de_checkout() {
        buyProductActions.checkoutProduct();
    }

    @Quando("ele escolher a forma de pagamento")
    public void ele_escolher_a_forma_de_pagamento() {
        buyProductActions.fillPaymentForm();
    }

    @E("confirmar a compra")
    public void confirmar_a_compra() {
        buyProductActions.saveAndSend();
    }

    @Entao("sua compra é feita com sucesso")
    public void sua_compra_e_feita_com_sucesso() {
        buyProductActions.registrationSuccess();
    }
}