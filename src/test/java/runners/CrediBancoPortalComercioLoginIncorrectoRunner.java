package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/resources/features/CrediBancoPortalComercioLoginIncorrecto.feature",
        //  features = "src/test/java/resources/features/pruebaArbirNavegador.feature",
        glue = "stepDefinitions",
        plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CrediBancoPortalComercioLoginIncorrectoRunner {
}
