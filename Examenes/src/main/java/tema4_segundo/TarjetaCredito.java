package tema4_segundo;

import java.time.YearMonth;

import org.apache.commons.lang3.RandomStringUtils;

public class TarjetaCredito {

    private static final RandomStringUtils generador = RandomStringUtils.secure();

    public String entidadEmisora;
    private String titular;
    private String numeroTarjeta;
    private YearMonth fechaCaducidad;
    private int credito;
    private boolean activada;
    private int pinTarjeta;

    // Constructor
    public TarjetaCredito(String titular, int creditoInicial) {

        if (creditoInicial < 500 || creditoInicial > 3000) { // gramos
            throw new IllegalArgumentException("Credito debe comenzar entre 500 y 3000 euros");
        }

        this.entidadEmisora = "DAWBANK";
        this.titular = titular;
        this.numeroTarjeta = generador.nextNumeric(16);
        this.fechaCaducidad = YearMonth.now().plusYears(4);
        this.credito = creditoInicial;
        this.activada = false;
        this.pinTarjeta = Integer.parseInt(generador.nextNumeric(4));
    }

    // Constructor copia
    public TarjetaCredito(TarjetaCredito otroTarjetaCredito) {
        this.entidadEmisora = otroTarjetaCredito.entidadEmisora;
        this.titular = otroTarjetaCredito.titular;
        this.numeroTarjeta = otroTarjetaCredito.numeroTarjeta;
        this.fechaCaducidad = otroTarjetaCredito.fechaCaducidad;
        this.credito = otroTarjetaCredito.credito;
        this.activada = otroTarjetaCredito.activada;
        this.pinTarjeta = otroTarjetaCredito.pinTarjeta;

    }

    // Getter
    public String getEntidadEmisora() {
        return entidadEmisora;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public YearMonth getFechaCaducidad() {
        return fechaCaducidad;
    }

    public int getCredito() {
        return credito;
    }

    public boolean isActivada() {
        return activada;
    }

    public int getPinTarjeta() {
        return pinTarjeta;
    }

    // Setter
    public void setEntidadEmisora(String entidadEmisora) {
        this.entidadEmisora = entidadEmisora;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    public void setPinTarjeta(int pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
    }

    // Activar tarjeta
    public void activar() {
        if (credito > 0) {
            this.activada = true;
        }
    }

    // Desactivar tarjeta
    public void desactivar() {
        this.activada = false;
    }

    // Cambiar pin
    public void cambiarPin(int nuevoPin) {
        this.pinTarjeta = nuevoPin;
    }

    // pagar

    public boolean pagar(int pinTarjeta, int cantidadPagar) {

        if (pinTarjeta != this.pinTarjeta) {
            return false;
        }
        if (!this.activada) {
            return false;
        }
        if (cantidadPagar > this.credito) {
            return false;
        }

        this.credito -= cantidadPagar;
        return true;

    }

    @Override
    public String toString() {
        return "Titular: " + titular +
                "\nEntidad: " + entidadEmisora +
                "\nNúmero: " + numeroTarjeta +
                "\nCaducidad: " + fechaCaducidad +
                "\nCrédito disponible: " + credito +
                "\nActivada: " + activada +
                "\nPIN: " + pinTarjeta + "\n";
    }

    public static TarjetaCredito Clonar(TarjetaCredito tarjeta) {
        return new TarjetaCredito(tarjeta);
    }

}
