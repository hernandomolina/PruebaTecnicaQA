package com.pruebatecnicaqa.stepdefinitions;

import com.pruebatecnicaqa.questions.CartBadgeCount;
import com.pruebatecnicaqa.tasks.AddToCartTask;
import com.pruebatecnicaqa.utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

public class CartStepDefinitions {
    private Actor actor;

    public CartStepDefinitions() {
        this.actor = TestContext.getInstance().getActor();
    }

    @And("agrega el producto {string} al carrito")
    public void addProductToCart(String productName) {
        actor.attemptsTo(
            AddToCartTask.withName(productName)
        );
    }

    @And("agrega los siguientes productos al carrito:")
    public void addMultipleProductsToCart(List<String> products) {
        for (String product : products) {
            actor.attemptsTo(
                AddToCartTask.withName(product)
            );
        }
    }

    @Then("debería ver que el producto fue agregado al carrito")
    public void shouldSeeProductAddedToCart() {
        actor.attemptsTo(
            Ensure.that(CartBadgeCount.value()).isNotEmpty()
        );
    }

    @Then("debería ver que los productos fueron agregados al carrito")
    public void shouldSeeProductsAddedToCart() {
        actor.attemptsTo(
            Ensure.that(CartBadgeCount.value()).isNotEmpty()
        );
    }

    @And("el contador del carrito debería mostrar {string}")
    public void cartCounterShouldShow(String count) {
        actor.attemptsTo(
            Ensure.that(CartBadgeCount.value()).isEqualTo(count)
        );
    }
} 