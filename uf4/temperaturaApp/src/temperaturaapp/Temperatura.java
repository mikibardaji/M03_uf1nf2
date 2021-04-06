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
public class Temperatura {
    private double grados;
    private String escala;

    public Temperatura(double grados, String escala) {
        this.grados = grados;
        this.escala = escala;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        if (escala.equalsIgnoreCase("Celsius") || escala.equalsIgnoreCase("Farenheit"))
        {
            this.escala = escala;
        }
        else
        {
            System.out.println("escala no valida-> " + escala);
        }
    }
    
    public double temperaturaCelsius()
    {
        double tempC;
        if (escala.equalsIgnoreCase("Celsius"))
        {
            tempC = this.grados;
        }
        else //lo tengo en farenheit guardado
        {
            tempC = (this.grados-32) * 5/9;
        }
        
        
        return tempC;
    }
    
    public double temperaturaFarenheit()
    {
        double tempC;
        if (escala.equalsIgnoreCase("Farenheit"))
        {
            tempC = this.grados;
        }
        else
        {
            tempC = this.grados*9/5 + 32;
        }
        
        
        return tempC;
    }
}
