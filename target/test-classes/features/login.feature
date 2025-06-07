# language: en
Feature: Login en Sauce Demo

  @login @successful
  Scenario: Login exitoso en Sauce Demo
    Given que el usuario está en la página de login de Sauce Demo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    Then debería ver la página principal de productos

  @login @unsuccessful
  Scenario: Login fallido con credenciales inválidas
    Given que el usuario está en la página de login de Sauce Demo
    When ingresa el usuario "invalid" y la contraseña "invalid"
    Then debería ver un mensaje de error de credenciales inválidas 