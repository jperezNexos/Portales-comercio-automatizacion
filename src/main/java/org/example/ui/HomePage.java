package org.example.ui;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target DASHBOARD_SECTION = Target.the("dashboard section")
            .located(By.xpath("//img[@src='assets/img/credibanco-black.svg' and @alt='Credibanco']\n"));
    public static final Target TXT_LOGIN_INCORRECTO = Target.the("txt login incorrecto")
            .located(By.xpath("//p[contains(@class, 'txt_error') and normalize-space(text())='Correo electrónico o contraseña incorrecta']"));

}
