package daw;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaqueteriaTest {

    @Test
    public void testCalcularTarifaZonaA() {
        boolean resultado = false;
        if (Paqueteria.calcularTarifaEnvio(3, "A") == 10) {
            resultado = true;
        }

        assertTrue(resultado, "Envío a la zona A de 3kg cuesta 10€");
    }

    @Test
    public void testCalcularTarifaZonaBConSuplemento() {
        boolean resultado = false;
        if (Paqueteria.calcularTarifaEnvio(6, "B") == 20) {
            resultado = true;
        }

        assertTrue(resultado, "Envío a la zona B de 6kg cuesta 20€");
    }

    @Test
    public void testCalcularTarifaPesoInvalido() {
        boolean resultado = false;
        if (Paqueteria.calcularTarifaEnvio(-5, "B") == -1) {
            resultado = true;
        }

        assertTrue(resultado, "Si pasamos un peso negativo (-5), el método devuelve -1");
    }

    @Test
    public void testValidarIdentificadorCorrecto() {
        boolean resultado = false;
        if (Paqueteria.validarIdentificador("1234")) {
            resultado = true;
        }

        assertTrue(resultado, "Prueba con el ID 1234. Debe dar true.");
    }

    @Test
    public void testValidarIdentificadorIncorrectoLongitud() {
        boolean resultado = false;
        if (Paqueteria.validarIdentificador("123")) {
            resultado = true;
        }

        assertFalse(resultado, "Prueba con 123. Debe dar false");
    }

    @Test
    public void testValidarIdentificadorIncorrectoLetra() {
        boolean resultado = false;
        if (Paqueteria.validarIdentificador("12A4")) {
            resultado = true;
        }

        assertFalse(resultado, "Prueba con 12A4. Debe dar false");
    }

    @Test
    public void testRepartirCargaCorrecta() {
        boolean resultado = false;
        if (Paqueteria.epartirCarga(10, 2) == 5) {
            resultado = true;
        }

        assertTrue(resultado, "Repartir 10 paquetes entre 2 camiones. Debe devolver 5");
    }

    @Test
    public void testRepartirCargaConResto() {
        boolean resultado = false;
        if (Paqueteria.epartirCarga(10, 3) == 3) {
            resultado = true;
        }

        assertTrue(resultado, "Repartir 10 paquetes entre 3 camiones. Debe devolver 3");
    }

    @Test
    public void testRepartirCargaErrorCero() {
        boolean resultado = false;
        if (Paqueteria.epartirCarga(50, 0) == 0) {
            resultado = true;
        }

        assertTrue(resultado, "Intentar repartir 50 paquetes entre 0 camiones. Debe saltar al catch y devolver 0.");
    }

}
