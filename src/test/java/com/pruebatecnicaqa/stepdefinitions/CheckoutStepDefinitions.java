package com.pruebatecnicaqa.stepdefinitions;

import com.pruebatecnicaqa.tasks.AddToCartTask;
import com.pruebatecnicaqa.tasks.GoToCartTask;
import com.pruebatecnicaqa.tasks.StartCheckoutTask;
import com.pruebatecnicaqa.tasks.FillCheckoutFormTask;
import com.pruebatecnicaqa.tasks.FinishCheckoutTask;
import com.pruebatecnicaqa.questions.CheckoutConfirmationMessage;
import com.pruebatecnicaqa.utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import java.util.Map;

public class CheckoutStepDefinitions {
    private final Actor actor;

    public CheckoutStepDefinitions() {
        this.actor = TestContext.getInstance().getActor();
    }

    @And("navega al carrito de compras")
    public void goToCart() {
        actor.attemptsTo(GoToCartTask.open());
    }

    @And("inicia el proceso de checkout")
    public void startCheckout() {
        actor.attemptsTo(StartCheckoutTask.open());
    }

    @And("ingresa los datos de compra:")
    public void fillCheckoutForm(Map<String, String> data) {
        actor.attemptsTo(FillCheckoutFormTask.withData(
            data.get("nombre"),
            data.get("apellido"),
            data.get("codigo_postal")
        ));
    }

    @And("finaliza la compra")
    public void finishCheckout() {
        actor.attemptsTo(FinishCheckoutTask.complete());
    }

    @Then("debería ver el mensaje de confirmación de compra")
    public void shouldSeeConfirmationMessage() {
        actor.should(net.serenitybdd.screenplay.GivenWhenThen.seeThat(CheckoutConfirmationMessage.isVisible()));
    }
} 