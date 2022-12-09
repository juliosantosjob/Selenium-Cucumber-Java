#language:pt

@regression @login_all
Funcionalidade: Login
  - Eu como usuario devo poder realizar login na plataforma.

  Contexto:
    Dado que o usuario acesse o site
    E acesse a pagina de login

  @loginSuccess
  Cenario: Login sucesso
    Quando ele preecher:
      | email    | qaTest@gmail.com |
      | password | Mudar@123        |
    Então ele é logado com sucesso

  Esquema do Cenario: Cenarios alternativas para login
    Quando ele preecher:
      | email    | <email>    |
      | password | <password> |
    Então ele vê "<mensagem>"

    Exemplos:
      | email               | password  | mensagem         |
      | dominioinvalido.com | Mudar@123 | E-mail inválido. |
      | qaTest@gmail.com    | \n        | Senha inválida.  |