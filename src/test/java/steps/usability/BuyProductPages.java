package steps.usability;

import actions.usability.BuyProductActions;
import io.cucumber.java.pt.*;
import support.DriverDefinition;

import static utils.Asserts.assertVisible;
import static utils.Asserts.contains;

public class BuyProductPages extends DriverDefinition {
    BuyProductActions buyProduct = new BuyProductActions(driver);

    @Dado("busque pelo produto {string}")
    public void busque_pelo_produto(String item) {
        buyProduct.searchForProduct(item);
        buyProduct.productIsDisplayed(item);
    }

    @Dado("adicione este item no carrinho")
    public void adicione_este_item_no_carrinho() {
        buyProduct.addProductCart();
        buyProduct.seeProductInCart();
    }

    @Dado("faça o checkout da sua compra")
    public void faca_o_checkout_da_sua_compra() {
        buyProduct.checkoutProduct();
    }

    @Quando("ele escolher a forma de pagamento")
    public void ele_escolher_a_forma_de_pagamento() {
        buyProduct.fillPaymentFormInit();
        buyProduct.fillPaymentFormFinal();
        buyProduct.saveAndSend();
    }

    @Então("sua compra é feita com sucesso")
    public void sua_compra_e_feita_com_sucesso() {
        assertVisible(buyProduct.modalSuccess());
        contains(buyProduct.modalSuccess(), "Order success!");
        contains(buyProduct.modalSuccess(), "Congrats! Your order was created with sucess!");
    }
}