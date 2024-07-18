package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.ui.LoginHomePage;
import org.example.utils.Constants;
import org.example.utils.ExcelUtils;

import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginIncorrectTask implements Task {
    private final String username;
    private final String password;

    public LoginIncorrectTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginHomePage.TXT_CORREO_ELECTRONICO),
                Enter.theValue(password).into(LoginHomePage.TXT_CONTRASENA),
                Click.on(LoginHomePage.BTN_INGRESAR)
        );





    }

    public static LoginIncorrectTask withCredentialsFromExcel(int rowNumber) throws IOException {
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData, Constants.Sheet_TestData);
        String username = excelUtils.getCellData(rowNumber, 0);
        String password = excelUtils.getCellData(rowNumber, 0);
        excelUtils.closeWorkbook();
        return instrumented(LoginIncorrectTask.class, username, password);
    }
}
