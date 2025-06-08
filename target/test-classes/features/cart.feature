# language: en
Feature: Carrito de compras en Sauce Demo

  @cart @add_product
  Scenario: Agregar un producto al carrito
    Given que el usuario está en la página de login de Sauce Demo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    Then debería ver que el producto fue agregado al carrito
    And el contador del carrito debería mostrar "1"

  @cart @add_multiple
  Scenario: Agregar múltiples productos al carrito
    Given que el usuario está en la página de login de Sauce Demo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega los siguientes productos al carrito:
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt  |
    Then debería ver que los productos fueron agregados al carrito
    And el contador del carrito debería mostrar "3" 