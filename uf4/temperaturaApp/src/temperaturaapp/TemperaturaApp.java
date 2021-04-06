/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperaturaapp;

/**
 *
 * @author mati
 */
public class TemperaturaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Temperatura termometro = new Temperatura(35, "celsius");
        System.out.println("Temperatura en celsius " + termometro.temperaturaCelsius());
        System.out.println("Temperatura en Farenheit " + termometro.temperaturaFarenheit());
        
        termometro.setGrados(95);
        termometro.setEscala("Farenheit");
        
        System.out.println("Temperatura en celsius " + termometro.temperaturaCelsius());
        System.out.println("Temperatura en Farenheit " + termometro.temperaturaFarenheit());
        
        
    }
    
}
