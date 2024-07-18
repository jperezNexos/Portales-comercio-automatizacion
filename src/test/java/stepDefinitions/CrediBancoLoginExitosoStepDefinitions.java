package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.example.models.UserModel;
import org.example.questions.LoginPageQuestions;
import org.example.tasks.LoginTask;
import org.example.tasks.OpenBrowserTask;
import org.example.utils.Constants;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;




public class CrediBancoLoginExitosoStepDefinitions {



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





    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
     //   theActorInTheSpotlight().wasAbleTo(Open.url("https://portal-credibanco.apps-pruebas.credibanco.com/#/welcome"));
        userAutomation.attemptsTo(OpenBrowserTask.openBrowser());
    }

  /*  @When("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        UserModel user = new UserModel(username, password);
        theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials(user)
        );
    }*/
    @When("the user enters username and password")
    public void theUserEntersUsernameAndPassword() {
  try {
      userAutomation.attemptsTo(LoginTask.withCredentialsFromExcel(1));
  }catch (IOException e){
      e.printStackTrace();
  }
    }

    @When("the user submits the login form")
    public void theUserSubmitsTheLoginForm() {

    }

    @Then("the user should see the dashboard page")
    public void theUserShouldSeeTheDashboardPage() {
        userAutomation.should(seeThat("the dashboard page is visible", LoginPageQuestions.isVisible(), is(true)));
    }
}
