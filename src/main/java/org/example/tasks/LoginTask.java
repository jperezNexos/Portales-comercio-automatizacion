package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;

import org.eclipse.jetty.websocket.common.extensions.compress.XWebkitDeflateFrameExtension;
import org.example.models.UserModel;
import org.example.ui.LoginHomePage;
import org.example.utils.Constants;
import org.example.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.example.ui.LoginHomePage.*;


public class LoginTask implements Task {


  private final String username;
    private final String password;

    public LoginTask(String username, String password) {
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

//        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
 //       WebElement imgCrediBanco = driver.findElement(By.xpath("//img[@src='assets/img/credibanco-black.svg' and @alt='Credibanco']\n"));



    }

    public static LoginTask withCredentialsFromExcel(int rowNumber) throws IOException {
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData, Constants.Sheet_TestData);
        String username = excelUtils.getCellData(rowNumber, 0);
        String password = excelUtils.getCellData(rowNumber, 1);
        excelUtils.closeWorkbook();
        return instrumented(LoginTask.class, username, password);
    }

}