package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.example.questions.LoginFailedQuestions;
import org.example.questions.LoginPageQuestions;
import org.example.tasks.LoginIncorrectTask;
import org.example.tasks.LoginTask;
import org.example.utils.Constants;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CrediBancoLoginIncorrectoStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver webDriver;
    private final Actor userAutomation = Actor.named("userAutomation");
    String path = Constants.Path_TestData + Constants.File_TestData;

    //Preparando al actor
    @Before
    public void prepareActorStage() {
        //Prepara todas las habilidades del actor (web, mobile, desktop)
        OnStage.setTheStage(new OnlineCast());
        //actor puede navegar en la web con el webdriver
        userAutomation.can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
    }


    @When("user enters incorrect credentials")
    public void userEntersIncorrectCredentials() {
        try {
            userAutomation.attemptsTo(LoginIncorrectTask.withCredentialsFromExcel(1));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @When("the user validates the incorrect login message")
    public void theUserValidatesTheIncorrectLoginMessage() {
        userAutomation.should(seeThat("the error message is visible", LoginFailedQuestions.isVisible(), is(true)));
    }

}
