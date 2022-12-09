#language:pt

@regression   @helpers_all
Funcionalidade: Steps de suporte
  - Esta feature tem como objetivo dar suporte para outros cenarios que tenha
  como premissa realizar login no aplicativo.

  @helpers
  Cenario: Login suporte
    Dado que o usuario acesse o site
    E faça login com "Email" e "Senha"
    E logout