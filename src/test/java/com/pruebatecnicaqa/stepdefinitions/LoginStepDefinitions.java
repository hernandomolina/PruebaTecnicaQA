package com.pruebatecnicaqa.stepdefinitions;

import com.pruebatecnicaqa.models.Credentials;
import com.pruebatecnicaqa.questions.LoginErrorMessage;
import com.pruebatecnicaqa.tasks.LoginTask;
import com.pruebatecnicaqa.utils.TestContext;
import com.pruebatecnicaqa.interactions.DismissPasswordWarning;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class LoginStepDefinitions {
    private Actor actor;

    public LoginStepDefinitions() {
        this.actor = TestContext.getInstance().getActor();
    }

    @Given("que el usuario está en la página de login de Sauce Demo")
    public void userIsOnLoginPage() {
        // La URL se abre en la tarea de login
    }

    @When("ingresa el usuario {string} y la contraseña {string}")
    public void enterCredentials(String username, String password) {
        Credentials credentials = new Credentials(username, password);
        if ("invalid".equals(username) && "invalid".equals(password)) {
            actor.attemptsTo(LoginTask.withInvalidCredentials(credentials));
        } else {
            actor.attemptsTo(LoginTask.withCredentials(credentials));
        }
    }

    @Then("debería ver la página principal de productos")
    public void shouldSeeProductsPage() {
        actor.attemptsTo(
            Ensure.that(TheWebPage.currentUrl())
                  .contains("/inventory.html")
        );
        // Intentar cerrar la ventana emergente si aparece
        actor.attemptsTo(
            DismissPasswordWarning.closeIfPresent()
        );
    }

    @Then("debería ver un mensaje de error de credenciales inválidas")
    public void shouldSeeErrorMessage() {
        actor.attemptsTo(
            Ensure.that(LoginErrorMessage.value())
                  .contains("Epic sadface")
        );
    }
} 