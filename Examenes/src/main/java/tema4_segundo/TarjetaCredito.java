/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4_segundo;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author usuario
 */
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

        String numeroTarjetaRandom = generador.nextNumeric(16);
        YearMonth fechaInicialSumada = YearMonth.from(LocalDate.now());
        int pinTarjetaRandom = Integer.parseInt(generador.nextNumeric(4));

        if (creditoInicial < 500 || creditoInicial > 3000) { // gramos
            throw new IllegalArgumentException("Credito debe comenzar entre 500 y 3000 euros");
        }

        this.entidadEmisora = "DAWBANK";
        this.titular = titular;
        this.numeroTarjeta = numeroTarjetaRandom;
        this.fechaCaducidad = fechaInicialSumada;
        this.credito = creditoInicial;
        this.activada = false;
        this.pinTarjeta = pinTarjetaRandom;
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

    //Setter
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
    
    public static boolean pagar(int pinTarjeta, int cantidadPagar){
        
        if (pinTarjeta != this.pinTarjeta){
            return false;
        }
        if (cantidadPagar > this.credito){
            return false;
        }
        if (!(this.activada)){
            return false;
        }
        
        
        return true;
 
    }
    
    
    
    
    // toString
    @Override
    public String toString() {
        return titular + entidadEmisora
                + fechaCaducidad + credito + numeroTarjeta
                + activada + pinTarjeta;
    }
    
    

    public static TarjetaCredito Clonar(TarjetaCredito tarjeta) {
        return new TarjetaCredito(tarjeta);
    }

}
