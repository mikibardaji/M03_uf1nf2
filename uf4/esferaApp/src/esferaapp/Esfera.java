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
public class Esfera {
    private double radi;
    public  static final double numero_pi = 3.14;

    /*constructor 1 amb parametre*/
    public Esfera(double radi) {
        this.radi = radi;
       
    }

    /*constructor 2 sense parametre*/
    public Esfera() {
        radi = 5;
       
    }
    
    public static void hola()
    {
        System.out.println("hola");
    }
    
    public double calcularArea()
    {
        double area = this.radi * this.radi * (numero_pi);
        return area;
    }

    public double getRadi() {
        return radi;
    }

    public void setRadi(double radi) {
        this.radi = radi;
    }
    
    
}
