package endes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComprobadorTest {
    @Test
    public void testNumeroPar() {
        boolean resultado = Comprobador.esPar(4);
        assertTrue(resultado, "El número 4 debería dar 'true'");
    }
    @Test
    public void testNumeroImpar() {
        boolean resultado = Comprobador.esPar(7);
        assertFalse(resultado, "El número 7 debería dar 'false'");
    }
    @Test
    public void testNumeroCero() {
        boolean resultado = Comprobador.esPar(0);
        assertTrue(resultado, "El número 0 debería dar 'true'");
    }
}
