#language:pt

@regression @registration_all
Funcionalidade: Cadastro de usuario
  - Eu como usuario devo poder me cadastrar na plataforma.

  Contexto:
    Dado que o usuario acesse o site
    E acesse a pagina de cadastro

  Cenario: Cadastro com sucesso
    Quando ele submeter o formulario com dados validos
    Então ele vê a mensagem de sucesso: "Cadastro realizado!"
    E "Bem-vindo"

  Esquema do Cenario: Envio de formulario com email invalido
    Quando ele submeter o formulario com:
      | name     | <name>     |
      | email    | <email>    |
      | password | <password> |
    Então ele vê a mensagem: "<mensagem>"

    Exemplos:
      | name | email             | password  | mensagem                                       |
      | João | joao123@erro      | Mudar@123 | O campo e-mail deve ser prenchido corretamente |
      | \n   | \n                | \n        | O campo nome deve ser prenchido                |
      | \n   | joao123@erro      | Mudar@123 | O campo nome deve ser prenchido                |
      | João | \n                | Mudar@123 | O campo e-mail deve ser prenchido corretamente |
      | João | joao123@gmail.com | \n        | O campo senha deve ter pelo menos 6 dígitos    |