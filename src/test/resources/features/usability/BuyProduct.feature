#language:pt

@regression   @buy_product_all
Funcionalidade: Comprar de produtos
  - Eu como usuario devo poder realizar a compra de um produto de minha escolha no site.

  Contexto:
    Dado que o usuario acesse o site
    E faça login com "Email" e "Senha"

  @buy_product
  Cenario: Compra de um produto
    E busque pelo produto "T-Shirt For Men"
    E adicione este item no carrinho
    E faça o checkout da sua compra
    Quando ele escolher a forma de pagamento
    Então sua compra é feita com sucesso