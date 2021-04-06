/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esferaapp;

/**
 *
 * @author mati
 */
public class EsferaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Esfera.hola();
        Esfera v1 = new Esfera(); //pi3.14
        
        
        double numero = Math.random();
        System.out.println("El radi de v_radio_inf es " + v1.getRadi());
        System.out.println("area v1" + v1.calcularArea());
        
        Esfera v2 = new Esfera(7); //pi 4
        System.out.println("El radi de v_radio_inf es " + v2.getRadi());
        v2.setRadi(8);
        System.out.println("El radi de v_radio_inf es " + v2.getRadi());
        System.out.println("area v1" + v1.calcularArea());
        System.out.println("area v2 " + v2.calcularArea());
    }
    
}
