package com.pruebatecnicaqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.pruebatecnicaqa.userinterfaces.LoginPage.ERROR_MESSAGE;

public class LoginErrorMessage implements Question<String> {

    public static Question<String> value() {
        return new LoginErrorMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ERROR_MESSAGE).answeredBy(actor);
    }
} 