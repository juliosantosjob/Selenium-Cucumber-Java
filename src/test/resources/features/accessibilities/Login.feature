#language:en

@regression @login_all
Feature: Login
  - As a user, I should be able to log in to the site

  Background:
    Given the user accesses the site
    And accesses the login page

  @login
  Scenario: Successful Login
    When they fill in:
      | email    | qaTest@gmail.com |
      | password | Mudar@123        |
    Then they see the message success "Login realizado"

  Scenario Outline: Alternative Scenarios
    When they fill in:
      | email    | <email>    |
      | password | <password> |
    Then they see the error <message>

    Examples:
      | email               | password    | message            |
      | dominioinvalido.com | "Mudar@123" | "E-mail inválido." |
      | qaTest@gmail.com    | \n          | "Senha inválida."  |