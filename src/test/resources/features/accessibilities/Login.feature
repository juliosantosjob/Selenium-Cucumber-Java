#language:pt

@regression @login_all
Funcionalidade: Login
  - Eu como usuario devo poder realizar login na site

  Contexto:
    Dado que o usuario acesse o site
    E acesse a pagina de login

  @login
  Cenario: Login sucesso
    Quando ele preecher:
      | email    | qaTest@gmail.com |
      | password | Mudar@123        |
    Então ele visualiza a mensagem "Login realizado"

  Esquema do Cenario: Cenários alternativos
    Quando ele preecher:
      | email    | <email>    |
      | password | <password> |
    Então ele vê a mensagem de erro "<mensagem>"

    Exemplos:
      | email               | password  | mensagem         |
      | dominioinvalido.com | Mudar@123 | E-mail inválido. |
      | qaTest@gmail.com    | \n        | Senha inválida.  |