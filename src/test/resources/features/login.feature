# language: es
Característica: Login en Sauce Demo

  @login @successful
  Escenario: Login exitoso en Sauce Demo
    Dado que el usuario está en la página de login de Sauce Demo
    Cuando ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    Entonces debería ver la página principal de productos

  @login @unsuccessful
  Escenario: Login fallido con credenciales inválidas
    Dado que el usuario está en la página de login de Sauce Demo
    Cuando ingresa el usuario "invalid" y la contraseña "invalid"
    Entonces debería ver un mensaje de error de credenciales inválidas 