package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

	@DataProvider(name = "datosFormulario")
    public static Object[][] datosFormulario() {
        return new Object[][] {
            {"Juan", "Perez", "juan@example.com", "1127634455"},
            {"Tiziano", "Litenvinicci", "tiziano@example.com", "7654445566"}
        };
    }
}
