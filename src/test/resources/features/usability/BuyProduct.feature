#language:pt

@regression   @buy_product_all
Funcionalidade: Compra de um produtos
  - Eu como usuario devo poder realizar a compra de um produto no site.

  Contexto:
    Dado que o usuario acesse o site
    E faça login com o email "qaTest@gmail.com" e a senha "Mudar@123"

  @buy_product
  Cenario: Compra de um produto
    E busque pelo produto "T-Shirt For Men"
    E adicione este item ao carrinho
    E vá para a pagina de checkout
    Quando ele escolher a forma de pagamento
    E confirmar a compra
    Então sua compra é feita com sucesso