package org.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginHomePage {
    public static final Target TXT_CORREO_ELECTRONICO = Target.the("Txt correo electronico")
            .located(By.xpath("//input[@formcontrolname='email']"));
    public static final Target TXT_CONTRASENA = Target.the("Txt contrasena")
            .located(By.xpath("//input[@formcontrolname='password']"));
    public static final Target BTN_INGRESAR = Target.the("btn ingresar")
            .located(By.xpath("//button[@id='modalBtn']"));
}
