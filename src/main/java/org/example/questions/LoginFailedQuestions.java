package org.example.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.example.ui.HomePage;

public class LoginFailedQuestions {
    public static Question<Boolean> isVisible() {

        return actor -> WebElementQuestion.the(HomePage.TXT_LOGIN_INCORRECTO).answeredBy(actor).isCurrentlyVisible();
    }
}
