package com.pruebatecnicaqa.stepdefinitions;

import com.pruebatecnicaqa.models.Credentials;
import com.pruebatecnicaqa.questions.LoginErrorMessage;
import com.pruebatecnicaqa.tasks.LoginTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinitions {
    private Actor actor;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Usuario");
        actor.can(BrowseTheWeb.with(WebDriverManager.chromedriver().create()));
    }

    @Given("que el usuario está en la página de login de Sauce Demo")
    public void userIsOnLoginPage() {
        // La URL se abre en la tarea de login
    }

    @When("ingresa el usuario {string} y la contraseña {string}")
    public void enterCredentials(String username, String password) {
        Credentials credentials = new Credentials(username, password);
        actor.attemptsTo(LoginTask.withCredentials(credentials));
    }

    @Then("debería ver la página principal de productos")
    public void shouldSeeProductsPage() {
        actor.attemptsTo(
            Ensure.that(TheWebPage.currentUrl())
                  .contains("/inventory.html")
        );
    }

    @Then("debería ver un mensaje de error de credenciales inválidas")
    public void shouldSeeErrorMessage() {
        actor.attemptsTo(
            Ensure.that(LoginErrorMessage.value())
                  .contains("Epic sadface: Username and password do not match any user in this service")
        );
    }
} 