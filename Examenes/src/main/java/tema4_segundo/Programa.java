/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4_segundo;

import java.time.LocalDate;

import modelo.TarjetaCredito;

/**
 *
 * @author usuario
 */
public class Programa {

    public static void main(String[] args) {

        TarjetaCredito t1 = new TarjetaCredito("Pablo", 600);
        TarjetaCredito t2 = new TarjetaCredito("Rosy", 200);
        TarjetaCredito t3 = TarjetaCredito.Clonar(t1);

        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        
        t1.pagar(1234, 200);
        System.out.println(t1.toString());
        
        t1.activar();
        t1.cambiarPin(1234);
        
        t1.pagar(1222, 200);
        System.out.println(t1.toString());
        
        t1.pagar(1222, 200000);
        System.out.println(t1.toString());
        
        t1.activar();
        t1.pagar(1234, 200);
        System.out.println(t1.toString());
        
        t3.activar();
        t3.pagar(1234, 600);
        System.out.println(t3.toString());
        
        System.out.println(t1.toString());
        System.out.println(t3.toString());
        
        
        
        
        
        
        

    }
}
