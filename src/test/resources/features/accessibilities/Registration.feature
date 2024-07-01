#language:en

@regression @registration_all
Feature: User Registration
  As a user, I should be able to register on the platform

  Background:
    Given the user accesses the site
    And accesses the registration page

  @regist
  Scenario: Successful registration
    When they submit the form with valid data
    Then they see the success message: "Cadastro realizado!"
    And the message: "Bem-vindo"

  Scenario Outline: Alternative registration flows
    When they submit the form with:
      | name     | <name>     |
      | email    | <email>    |
      | password | <password> |
    Then they see the message <message>

    Examples:
      | name   | email             | password    | message                                          |
      | "João" | "joao123@erro"    | "Mudar@123" | "O campo e-mail deve ser prenchido corretamente" |
      | \n     | \n                | \n          | "O campo nome deve ser prenchido"                |
      | \n     | "joao123@erro"    | "Mudar@123" | "O campo nome deve ser prenchido"                |
      | "João" | \n                | "Mudar@123" | "O campo e-mail deve ser prenchido corretamente" |
      | "João" | joao123@gmail.com | \n          | "O campo senha deve ter pelo menos 6 dígitos"    |