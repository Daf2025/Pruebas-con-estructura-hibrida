package tests;

import pages.FormularioPage;
import utils.DataProviderUtil;
import utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class FormularioAltaClienteTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(""); // Página de prueba
    }

    @Test(dataProvider = "datosFormulario", dataProviderClass = DataProviderUtil.class)
    public void validarAltaCliente(String nombre, String apellido, String email, String telefono) {
        FormularioPage formulario = new FormularioPage(driver);
        formulario.completarFormulario(nombre, apellido, email, telefono);
        formulario.enviarFormulario();
        
        Assert.assertTrue(formulario.validacionExitosa(), "El formulario no fue enviado correctamente.");
    }
    
    @AfterMethod
    public void capturarPantallaSiFalla(ITestResult resultado) throws IOException {
        if (ITestResult.FAILURE == resultado.getStatus()) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String nombreTest = resultado.getName();
            File destino = new File("..\\ProyectoPrueba\\Evidencias\\Falla_" + nombreTest + "_" + System.currentTimeMillis() + ".png");
            FileUtils.copyFile(screen, destino);
            System.out.println("Captura guardada en: " + destino.getAbsolutePath());
        }
    }
        
    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
