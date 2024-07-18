package org.example.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenBrowserTask implements Task {

    // Se debe crear un metodo sobreescrito para implementar la interfaz de Task
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url("https://portal-credibanco.apps-pruebas.credibanco.com/#/welcome"));
    }

    public static  OpenBrowserTask openBrowser(){
        //Instrumented para informar en el reporte de Serenity
        return Tasks.instrumented(OpenBrowserTask.class);
    }
}
