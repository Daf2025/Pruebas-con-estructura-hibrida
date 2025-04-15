package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioPage {
    private WebDriver driver;

    public FormularioPage(WebDriver driver) {
        this.driver = driver;
    }

    public void completarFormulario(String nombre, String apellido, String email, String telefono) {
        driver.findElement(By.id("nombre")).sendKeys(nombre);
        driver.findElement(By.id("apellido")).sendKeys(apellido);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("telefono")).sendKeys(telefono);
    }

    public void enviarFormulario() {
        driver.findElement(By.id("enviar")).click();
    }
    
    public boolean validacionExitosa() {
        try {
            String mensaje = driver.findElement(By.id("mensajeExito")).getText();
            return mensaje.equalsIgnoreCase("¡El formulario fue enviado correctamente!");
        } catch (Exception e) {
            return false;
        }
    }
}