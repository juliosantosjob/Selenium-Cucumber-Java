package steps.usability;

import actions.usability.BuyProductActions;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import support.DriverDefinition;

import static utils.Asserts.containsText;

public class BuyProductPages extends DriverDefinition {

    @E("busque pelo produto {string}")
    public void busque_pelo_produto(String item) {
        new BuyProductActions(driver)
                .searchForProduct(item)
                .productIsDisplayed(item);
    }

    @E("adicione este item ao carrinho")
    public void adicione_este_item_ao_carrinho() {
        new BuyProductActions(driver)
                .addProductCart()
                .seeProductInCart();
    }

    @E("vá para a pagina de checkout")
    public void va_para_a_pagina_de_checkout() {
        new BuyProductActions(driver)
                .checkoutProduct();
    }

    @Quando("ele escolher a forma de pagamento")
    public void ele_escolher_a_forma_de_pagamento() {
        new BuyProductActions(driver)
                .fillPaymentForm();
    }

    @E("confirmar a compra")
    public void confirmar_a_compra() {
        new BuyProductActions(driver)
                .saveAndSend();
    }

    @Entao("sua compra é feita com sucesso")
    public void sua_compra_e_feita_com_sucesso() {
        String getMessage = new BuyProductActions(driver).getModalSuccess();

        containsText(getMessage, "Order success!");
        containsText(getMessage, "Congrats! Your order was created with sucess!");
    }
}