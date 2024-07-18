package org.example.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.example.ui.HomePage;
import org.openqa.selenium.WebDriver;

public class LoginPageQuestions {

        public static Question<Boolean> isVisible() {

            return actor -> WebElementQuestion.the(HomePage.DASHBOARD_SECTION).answeredBy(actor).isCurrentlyVisible();
        }
    }

