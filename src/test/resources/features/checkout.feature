# language: en
Feature: Proceso de compra (Checkout) en Sauce Demo

  Como usuario de Sauce Demo
  Quiero poder completar el proceso de compra
  Para finalizar mi pedido exitosamente

  @checkout @compra_exitosa
  Scenario: Completar proceso de compra exitosamente
    Given que el usuario está en la página de login de Sauce Demo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And navega al carrito de compras
    And inicia el proceso de checkout
    And ingresa los datos de compra:
      | nombre         | Juan   |
      | apellido      | Pérez  |
      | codigo_postal | 110111 |
    And finaliza la compra
    Then debería ver el mensaje de confirmación de compra 