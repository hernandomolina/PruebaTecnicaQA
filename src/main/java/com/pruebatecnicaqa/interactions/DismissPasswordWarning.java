package com.pruebatecnicaqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DismissPasswordWarning implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        try {
            // Buscar el botón "Aceptar" de la ventana emergente
            WebElement aceptarBtn = driver.findElement(By.xpath("//button[normalize-space()='Aceptar']"));
            if (aceptarBtn.isDisplayed()) {
                aceptarBtn.click();
            }
        } catch (Exception ignored) {
            // Si no está presente, continuar sin error
        }
    }

    public static DismissPasswordWarning closeIfPresent() {
        return Tasks.instrumented(DismissPasswordWarning.class);
    }
} 