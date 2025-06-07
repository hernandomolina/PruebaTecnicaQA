package com.pruebatecnicaqa.tasks;

import com.pruebatecnicaqa.models.Credentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static com.pruebatecnicaqa.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task {
    private final Credentials credentials;

    public LoginTask(Credentials credentials) {
        this.credentials = credentials;
    }

    public static LoginTask withCredentials(Credentials credentials) {
        return instrumented(LoginTask.class, credentials);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.url(URL),
            Enter.theValue(credentials.getUsername()).into(USERNAME_FIELD),
            Enter.theValue(credentials.getPassword()).into(PASSWORD_FIELD),
            Click.on(LOGIN_BUTTON)
        );

        if (credentials.getUsername().equals("standard_user") && credentials.getPassword().equals("secret_sauce")) {
            actor.attemptsTo(
                WaitUntil.the(INVENTORY_CONTAINER, WebElementStateMatchers.isPresent()).forNoMoreThan(10).seconds()
            );
        }
    }
} 