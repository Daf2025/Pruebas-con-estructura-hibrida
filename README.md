# ✅ Proyecto de Automatización Selenium + Java + TestNG

Este proyecto forma parte del repositorio [`Pruebas-con-estructura-hibirida`](https://github.com/Daf2025/Pruebas-con-estructura-hibirida/tree/main) y tiene como objetivo validar formularios web utilizando **Selenium WebDriver**, **Java**, **TestNG** y el patrón de diseño **Page Object Model (POM)**.

Está desarrollado como un proyecto de automatización **básico pero escalable**, ideal para prácticas, entrevistas o como base para automatizaciones más complejas.

## ⚙️ Justificación del Enfoque Híbrido

El proyecto implementa un enfoque híbrido en la gestión del WebDriver, lo cual permite aprovechar tanto las ventajas del patrón Singleton como de la flexibilidad del control desde TestNG:

✅ Evita múltiples instancias del navegador.

✅ Permite inicialización y cierre centralizado del WebDriver.

✅ Compatible con ejecución secuencial o futura ejecución paralela.

✅ Desacopla la lógica de setup/teardown del código de test.

Esto garantiza consistencia entre tests y reutilización de código, además de facilitar el mantenimiento.

## ⚙️ Ventajas de la Estructura

✅Separación de responsabilidades: las páginas, utilidades y tests están organizados por función.

✅Fácil mantenimiento: cambios en el WebDriver o elementos de página solo afectan a una clase.

✅Escalabilidad: se pueden agregar más tests o páginas sin modificar la estructura existente.

✅Flexibilidad para evolución: es sencillo integrar frameworks como Cucumber o Allure más adelante.

---

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Selenium WebDriver 4.10.0**
- **TestNG 6.10**
- **WebDriverManager**
- **Maven**
- IDE sugerida: **IntelliJ IDEA** o **Eclipse**

---

## 📁 Estructura del proyecto
```bash
src/
├── main/
│   └── java/
│       ├── pages/          # Clases Page Object
│       │   └── FormularioPage.java
│       └── utils/          # Utilidades de soporte
│           ├── DriverManager.java
│           └── DataProviderUtil.java
├── test/
│   └── java/
│       └── tests/          # Clases de prueba
│           └── FormularioAltaClienteTest.java
testng.xml                  # Suite de pruebas
pom.xml                     # Archivo de configuración Maven
```

## 🛠️ Instrucciones de Instalación y Ejecución

## ✅ Requisitos previos

- Java 17
- Maven 3.x
- Un IDE como IntelliJ o Eclipse

## 📦 Instalación

Clonar el proyecto:
```bash
git clone https://github.com/Daf2025/Pruebas-con-estructura-hibirida/tree/main
```
- Importar el proyecto como un proyecto Maven en tu IDE.
- Asegurarse de que Maven descargue todas las dependencias:
```bash
mvn clean install
```
## ▶️ Ejecución

- Para ejecutar los tests definidos en el archivo testng.xml, correr:
```bash
mvn test
```
💡 También podés correr desde el IDE haciendo clic derecho sobre el archivo testng.xml y seleccionando Run.

## 📄 Ejemplo de Prueba
```bash
@Test(dataProvider = "datosCliente", dataProviderClass = DataProviderUtil.class)
public void testAltaCliente(String nombre, String apellido, String email) {
    FormularioPage formulario = new FormularioPage();
    formulario.completarFormulario(nombre, apellido, email);
    formulario.validarExito();
}
```
## 🧪 testng.xml
El archivo testng.xml está configurado para ejecutar las pruebas de forma secuencial (parallel="false"), pudiendo adaptarse fácilmente a ejecuciones paralelas en el futuro.

## 🔧 Buenas prácticas y mejoras futuras
```bash
💡 Implementar manejo de logs con Log4j o SLF4J para mejor trazabilidad.
💡 Añadir validaciones negativas y pruebas de borde.
💡 Agregar un sistema de reportes como Allure o ExtentReports.
💡 Separar configuración por entorno con .properties o YAML.
💡 Incluir ejecución paralela usando parallel="methods" en testng.xml.
```

## 📌 Notas adicionales
- El proyecto usa WebDriverManager para gestionar automáticamente los drivers del navegador.
- Los datos de prueba se suministran mediante el @DataProvider de TestNG.
- Está preparado para escalar incluyendo nuevas páginas, tests y estrategias de datos.

## 📄 Licencia
Este proyecto está disponible bajo la Licencia MIT

# 📫 Contacto
📌 Autor: Daf2025
